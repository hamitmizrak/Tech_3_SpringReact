package com.hamitmizrak.tech_3_springreact.audit;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

// LOMBOK
@Log4j2

// StereoType
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    // get Current Auditor
    @Override
    public Optional<String> getCurrentAuditor() {
        // database ile login girişi yapmış kullanıcı bilgilerini almak
        // org.springframework.security.core.Authentication;
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        // Eğer kullanıcı giriş yapmışsa session bilgilerini almak
        if(authentication!=null && authentication.isAuthenticated()){
            log.warn("Sistemde Kullanı vardır.");
            System.out.println("Name: "+authentication.getName());
            System.out.println("Principal: "+authentication.getPrincipal());
            return Optional.of(authentication.getName());
        }
       /* else if(authentication==null && !authentication.isAuthenticated()){
            log.error("Sistemde Kullanı yoktur");
            return Optional.empty();
        }*/
        // Eğer sistemde bir kullanıcı giriş  yapmamışsa default olarak HamitM. dönder
        //return Optional.ofNullable(authentication!=null? authentication.getName() : null)
        return Optional.of("HamitM.");
    }
}
