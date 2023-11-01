package com.hamitmizrak.tech_3_springreact.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// @Component: BackendProfile nesnesi Spring nesnesi olması için
@Component
// application.properties => spring.profiles.active=fullstack
@Profile("fullstack")
public class FullStackProfile implements IChooiseProfile{
    @Override
    public String message(String name) {
        return FullStackProfile.class+" Profile: "+name;
    }
}
