package edu.uddp.util;



import org.apache.log4j.Logger;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.apache.lucene.document.Field.*;


/**
 * @program: rollcall-ai
 * @description: 实现Lucene搜索的工具类
 * @author: wanzh
 * @create: 2018-10-26
 **/
@Component
public class LuceneUtil {
    public static Logger logger = Logger.getLogger(LuceneUtil.class);
    private static Integer totalNum = 0;
    IndexWriter indexWriter = null;
    IndexWriterConfig indexWriterConfig = null;
    Directory directory = null;


    /**
     * 创建索引
     */
//    public IndexWriter indexWriter() {
//        try {
//            //        Directory directory = new RAMDirectory();//在内存中建立索引
//            File file = new File("D:/TestLucene/index");
//            Path filePath = file.toPath();
//            directory = FSDirectory.open(filePath);
//            //创建解析器
//            Analyzer luceneAnalyzer = new StandardAnalyzer();
//            //创建indexWriter
//            indexWriterConfig = new IndexWriterConfig(luceneAnalyzer);
//            indexWriter = new IndexWriter(directory, indexWriterConfig);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return indexWriter;
//    }
//
//    /**
//     * 为数据库中的数据添加缩影
//     *
//     * @return
//     */
//    public void addIndex(List<Lessons> lessons) {
//        indexWriter = indexWriter();
//        for (Lessons lesson:lessons) {
//            Document document = new Document();//新建文档对象
//            document = getDocument(lesson);
//            //添加资源
//            try {
//                indexWriter.addDocument(document);//一个对象封装在一个document中，这里共四个document
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            indexWriter.close();
//            directory.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 删除索引
//     *
//     * @param id
//     */
//    public void deIndex(String id) {
//        IndexWriter indexWriter = this.indexWriter();
//        //删除
//        try {
//            indexWriter.deleteDocuments(new Term("id", id));
//            indexWriter.forceMergeDeletes();
//            indexWriter.commit();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                indexWriter.close();
//                directory.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * 更新索引
//     *
//     * @param lessons
//     */
//    public void updateIndex(Lessons lessons) {
//        //获取writer对象
//        indexWriter = this.indexWriter();
//        //获取文档对象
//        Document document = new Document();
//        document = getDocument(lessons);
//        //修改，根据id更新
//        try {
//            indexWriter.updateDocument(new Term("id", String.valueOf(document.get("id"))), document);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                indexWriter.close();
//                directory.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    /**
//     * 把传入的数据对象换成Document
//     *
//     * @param data
//     * @return
//     */
//    private static Document getDocument(Lessons data) {
//        Document doc = new Document();
//        doc.add(new TextField("id", String.valueOf(data.getId()), Store.YES));
//        doc.add(new TextField("jxb", String.valueOf(data.getJxb()), Store.YES));
//        doc.add(new TextField("kcmc", String.valueOf(data.getKcmc()),Store.YES));
//        doc.add(new TextField("js", String.valueOf(data.getJs()), Store.YES));
//        doc.add(new TextField("jiaos", String.valueOf(data.getJiaos()), Store.YES));
//        doc.add(new TextField("bj", String.valueOf(data.getBj()), Store.YES));
//       // doc.add(new TextField("Ez", String.valueOf(data.getEz()), Store.YES));
//        doc.add(new TextField("jsbh", String.valueOf(data.getJsbh()), Store.YES));
//        doc.add(new TextField("kcbh", String.valueOf(data.getKcbh()), Store.YES));
//        doc.add(new TextField("nj", String.valueOf(data.getNj()), Store.YES));
//        doc.add(new TextField("zc", String.valueOf(data.getZc()), Store.YES));
//        return doc;
//    }
}