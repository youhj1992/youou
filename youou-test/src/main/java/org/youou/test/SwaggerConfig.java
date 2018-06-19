/**
 * Project Name:manager-web<br>
 * File Name:SwaggerConfig.java<br>
 * Package Name:cn.com.duiba.tuia.manager<br>
 * Date:2016年8月23日下午2:06:29<br>
 * Copyright (c) 2016, duiba.com.cn All Rights Reserved.
 */
package org.youou.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ClassName: SwaggerConfig <br/>
 * date: 2016年8月23日 下午2:06:29 <br/>.
 *
 * @author xiawei
 * @version
 * @since JDK 1.7
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /** The swagger enbale. */
    @Value("${swagger.enable:true}")
    private Boolean swaggerEnbale;
    
    /**
     * Creates the rest api.
     *
     * @return the docket
     */
    @Bean
    public Docket createRestApi(){
        
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .enable(swaggerEnbale)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.youou.test"))
                .paths(PathSelectors.any())
                .build();
       
    }

    /**
     * Api info.
     *
     * @return the api info
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("YOUOU-Api文档")
                .description("RESTful API文档")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
