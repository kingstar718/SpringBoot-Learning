package top.wujinxing.ch11fileupload;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ch11FileuploadApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Ch11FileuploadApplication.class, args);
    }

    //Tomcat large file upload connection reset
    //TomcatServletWebServerFactory() ⽅法主要是为了解决上传⽂件⼤于 10M 出现连接重置的问题，此异常内
    //容 GlobalException 也捕获不到
    @Bean
    public TomcatServletWebServerFactory tomcatEmbedded(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector->{
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)){
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }

}
