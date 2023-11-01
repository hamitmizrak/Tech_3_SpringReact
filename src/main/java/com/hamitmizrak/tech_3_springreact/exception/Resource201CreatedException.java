package com.hamitmizrak.tech_3_springreact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//201: oluşturuldu (Created)
@ResponseStatus(value = HttpStatus.CREATED)
public class Resource201CreatedException extends RuntimeException{

    // Override
    public Resource201CreatedException(String message) {
        super(message);
    }
}
