package edu.uddp.interceptor;


import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.io.Serializable;

//        import org.apache.log4j.Logger;

/**
 * 缓存方法拦截器核心代码 。<br/>
 * 拦截以get和select开头的方法（用于缓存结果）
 */
public class MethodEhCacheInterceptor implements MethodInterceptor,
        InitializingBean {

//    private static final Logger log = Logger.getLogger(MethodCacheInterceptor.class);

    private Cache cache;

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(cache, "Need a cache. Please use setCache(Cache) create it.");
    }


    public Object invoke(MethodInvocation invocation) throws Throwable {
        String targetName = invocation.getThis().getClass().getName();//这个表示哪个类调用（或触发）了这个MethodCacheInterceptor，如里的:manager.PersonMagagerImpl
        String methodName = invocation.getMethod().getName();//这个表示哪个方法触发了这个类（MethodCacheInterceptor）方法（invoke）的调用，如这里的:getList
        Object[] arguments = invocation.getArguments();//调用的参数,这里没有参数
        Object result;
//        log.debug("Find object from cache is " + cache.getName());
        String cacheKey = getCacheKey(targetName, methodName, arguments);//这里得出的是:manager.PersonManagerImpl.getList
        Element element = null;
        synchronized (this) {
            element = cache.get(cacheKey);
            if (element == null) {
//                log.debug("Hold up method , Get method result and create cache........!");
                // call target/sub-interceptor
                result = invocation.proceed();//这个就是调用数据访问方法，如这里是调用manager.PersonManagerImpl.getList(),并用result保存执行的结果（数据访问的结果）,如这里调用了getList()方法，会先打印出"get Person from DB" ，然后将结果集放入到result里面去，这里由于使用的是自己配置只能放入10个元素的ehcache，所以这里的result是ArrayList<E> ，它里面存放的是elementData[10]，并将getList得到的结果放入到elementData里面去了
                //log.info(cacheKey + "加入到缓存： " + cache.getName());
                // cache method result
                //下面方法执行后，将cacheKey与数据集连起来，cacheKey是用来标识这个element的标志，我们可以有多个element(各自是来自不同的数据访问方法而形成的)，区分它们就是用cacheKey，
                element = new Element(cacheKey, (Serializable) result);//这里的新生成后的element，含有cacheKey，还在element创建时间，访问时间，还有命令次数等cache的属性，我觉得它就像是一个小cache一样，下次要不要更新它就要看它的这些属性来决定。
                System.out.println("-----非缓存中查找，查找后放入缓存");
                cache.put(element);//放入cache中
            } else {
                System.out.println("----缓存中查找----");
                //log.info(cacheKey + "使用缓存： " + cache.getName());
            }
        }
//        log.info("out cache");//完成cache操作
        return element.getValue();
    }


    private String getCacheKey(String targetName, String methodName,
                               Object[] arguments) {
        StringBuffer sb = new StringBuffer();
        sb.append(targetName).append(".").append(methodName);
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                sb.append(".").append(arguments[i]);
            }
        }
        return sb.toString();
    }

}
