package com.hamitmizrak.tech_3_springreact.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// LOMBOK
@Log4j2 // for log

// @Configuration: Classın Bean nesnesi olması için kullanıyoruz.
@Configuration
public class AllAfterBeanBeforeBean {

    // Command Line Runner Bean Method
    @Bean(initMethod = "blogCommandLineRunnerAfterBeanMethod",destroyMethod ="blogCommandLineRunnerBeforeBeanMethod")
    public BlogCommandLineRunner blogCommandLineRunner(){
        return new BlogCommandLineRunner();
    }

    // Model Mapper
    @Bean(initMethod = "modelMapperBeforeBeanMethod",destroyMethod ="modelMapperAfterBeanMethod")
    public ModelMapperBeanClass modelMapperBeanClass(){
        return new ModelMapperBeanClass();
    }

    // Masking Password Encoder
    @Bean(initMethod = "passwordEncoderBeforeBeanMethod",destroyMethod ="passwordEncoderAfterBeanMethod")
    public PasswordEncoderBeanClass passwordEncoderBeanClass(){
        return new PasswordEncoderBeanClass();
    }

    // Swagger
    @Bean(initMethod = "swaggerOpenApiBeforeBeanMethod",destroyMethod ="swaggerOpenApiAfterBeanMethod")
    public SwaggerOpenApiBeanClass swaggerOpenApiBeanClass(){
        return new SwaggerOpenApiBeanClass();
    }

    // Locale18NBean
    @Bean(initMethod = "locale18NBeforeBeanMethod",destroyMethod ="locale18NAfterBeanMethod")
    public Locale18NBeanClass locale18NBeanClass(){
        return new Locale18NBeanClass();
    }


    // Auditor Aware Bean
    @Bean(initMethod = "auditorAwareBeforeBeanMethod",destroyMethod ="auditorAwareAfterBeanMethod")
    public AuditorAwareBeanClass auditorAwareBeanClass(){
        return new AuditorAwareBeanClass();
    }

} //end class
