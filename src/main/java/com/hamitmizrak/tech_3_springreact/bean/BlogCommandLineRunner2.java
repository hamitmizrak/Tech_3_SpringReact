package com.hamitmizrak.tech_3_springreact.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class BlogCommandLineRunner2 implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        // Uygulama başladığında çalışmasını istediğimiz komutlar
        System.out.println("CommandLineRunner Çalıştı Sade");
        log.info("CommandLineRunner Çalıştı Sade");
    }

} //end class

