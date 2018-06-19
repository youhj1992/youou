package org.youou.test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * ClassName: Application <br/>
 * date: 2016年11月30日 下午5:05:37 <br/>
 *
 * @version 
 * @since JDK 1.6
 */
@Configuration
//@EnableDiscoveryClient
//@EnableCircuitBreaker
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceTransactionManagerAutoConfiguration.class,DataSourceAutoConfiguration.class})
@ImportResource({ "classpath:/spring/spring-config.xml" })
public class Application {
    

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    /**
     * main:(这里用一句话描述这个方法的作用). <br/>
     * 作用很大
     * @param args
     * @since JDK 1.6
     */
    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = null;
        try {
            long start = System.currentTimeMillis();
            SpringApplication springApplication=new SpringApplication(Application.class);
            ctx = springApplication.run(args);
            long period = System.currentTimeMillis() - start;
            log.error("youou-test start successfully in "+period+" ms.");
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            log.error("youou-test start error :", e);
            System.exit(-1);
        } finally{
            if(ctx !=null){
                ctx.close();
            }
        }
    }
}
