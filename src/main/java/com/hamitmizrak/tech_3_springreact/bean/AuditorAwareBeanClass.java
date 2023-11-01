package com.hamitmizrak.tech_3_springreact.bean;

import com.hamitmizrak.tech_3_springreact.audit.AuditorAwareImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

// LOMBOK
@Log4j2 // for log

// @Configuration: Classın Bean nesnesi olması için kullanıyoruz.
@Configuration
// Auditing Aktif etmek
//@EnableJpaAuditing(auditorAwareRef = "auditorAwareBeanMethod")
public class AuditorAwareBeanClass {

    //FIRST
    public void auditorAwareBeforeBeanMethod(){
        log.info("auditor Aware bean Before başladı");
        System.out.println("auditor Aware bean Before başladı");
    }

    // Auditor Aware Bean
    @Bean
    public AuditorAware<String> auditorAwareBeanMethod(){
        return new AuditorAwareImpl();
    }


    //LAST
    public void auditorAwareAfterBeanMethod(){
        log.info("auditor Aware After bean bitti");
        System.out.println("auditor Aware After bean bitti");
    }
}
