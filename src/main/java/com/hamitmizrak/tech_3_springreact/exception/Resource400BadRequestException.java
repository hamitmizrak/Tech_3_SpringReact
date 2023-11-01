package com.hamitmizrak.tech_3_springreact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//400: Kötü istek (Bad Request)
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class Resource400BadRequestException extends RuntimeException{

    // Override
    public Resource400BadRequestException(String message) {
        super(message);
    }
}
