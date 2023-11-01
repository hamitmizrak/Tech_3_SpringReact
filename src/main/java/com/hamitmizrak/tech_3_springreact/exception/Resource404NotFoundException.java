package com.hamitmizrak.tech_3_springreact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//404: Bulunamadı (Not Found)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Resource404NotFoundException extends RuntimeException{

    // Override
    public Resource404NotFoundException(String message) {
        super(message);
    }
}
