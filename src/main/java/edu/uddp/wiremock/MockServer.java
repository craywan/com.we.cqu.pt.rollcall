package edu.uddp.wiremock;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @program: rollcall-ai
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-31
 **/
public class MockServer {

    public static void main(String[] args) throws IOException {
        WireMock.configureFor( 8086);
        WireMock.removeAllMappings();

        mock("/1", "01");
    }

    private static void mock(String url, String file) throws IOException {
        //加载文件
        ClassPathResource resource = new ClassPathResource("mock/response/"+file+".txt");

        //读取内容
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");

        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo(url))
                .willReturn(WireMock.aResponse()
                        .withBody(content)
                        .withStatus(200)));
    }
}
