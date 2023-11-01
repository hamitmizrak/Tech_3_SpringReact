package com.hamitmizrak.tech_3_springreact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//401: Yetkisiz Giris (Bad Request)
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class Resource401UnAuthorizedException extends RuntimeException{

    // Override
    public Resource401UnAuthorizedException(String message) {
        super(message);
    }
}
