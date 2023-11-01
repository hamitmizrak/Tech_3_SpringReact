package com.hamitmizrak.tech_3_springreact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//403: Yasak Giriş (Forbitten)
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class Resource403ForbiddenException extends RuntimeException{

    // Override
    public Resource403ForbiddenException(String message) {
        super(message);
    }
}
