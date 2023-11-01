package com.hamitmizrak.tech_3_springreact.bean;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// LOMBOK
@Log4j2 // for log

// @Configuration: Classın Bean nesnesi olması için kullanıyoruz.
@Configuration
public class ModelMapperBeanClass {

    //FIRST
    public void modelMapperBeforeBeanMethod(){
        log.info("Model mapper bean Before başladı");
        System.out.println("Model mapper bean Before başladı");
    }

    // Model Mapper
    @Bean
    public ModelMapper modelMapperMethod(){
        return new ModelMapper();
    }


    //LAST
    public void modelMapperAfterBeanMethod(){
        log.info("Model mapper After bean bitti");
        System.out.println("Model mapper After bean bitti");
    }
}
