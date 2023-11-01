package com.hamitmizrak.tech_3_springreact.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// LOMBOK
@Log4j2 // for log

// @Configuration: Classın Bean nesnesi olması için kullanıyoruz.
@Configuration
public class SwaggerOpenApiBeanClass {


    // FIRST
    public void swaggerOpenApiBeforeBeanMethod() {
        log.info("swagger Open Api Before Bean başladı");
        System.out.println("swagger Open Api Before Bean başladı");
    }

    // OpenAPI
    @Bean
    public OpenAPI swaggerOpenApiMethod() {
        return new OpenAPI().info(
                new Info()
                        .title("title bilgisi")
                        .description("description bilgisi")
                        .version("V1.0")
                        .contact(new Contact()
                                .name("Hamit")
                                .url("www.hamitmizrak.com.tr")
                                .email("hamitmizrak@gmail.com"))
                        .termsOfService(" Software INC.")
                        .license(
                                new License()
                                        .name("Licence ")
                                        .url("www."))
        );
    }


    // LAST
    public void swaggerOpenApiAfterBeanMethod() {
        log.info("swagger Open Api After Bean bitti");
        System.out.println("swagger Open Api After Bean bitti");
    }

}
