package com.hamitmizrak.tech_3_springreact.controller.impl;

import com.hamitmizrak.tech_3_springreact.business.dto.RegisterDto;
import com.hamitmizrak.tech_3_springreact.business.services.IRegisterServices;
import com.hamitmizrak.tech_3_springreact.controller.IRegisterApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor //ınjection
@Log4j2

// API
@RestController
//v1.0.0       1: major version 0: minor 0: patch(yama)
@RequestMapping("/register/api/v1.0.0")
@CrossOrigin // CORSS Hatası almamak için
//@CrossOrigin(origins = FrontendPortUrl.REACT_FRONTEND_PORT_URL)
//Dış dünyaya açılan kapı
public class RegisterApiImpl implements IRegisterApi<RegisterDto> {

    // INJECTION
    private final IRegisterServices iRegisterServices;


    ///////////////////////////////////////////////////////////////////////////
    // SPEED DATA
    // http://localhost:4444/register/api/v1.0.0/speed/data/10
    @Override
    @GetMapping("/speed/data/{id}")
    public ResponseEntity<List<RegisterDto>> registerApiSpeedData( @PathVariable(name="id")  Long key) {
        return ResponseEntity.ok(iRegisterServices.registerServiceSpeedData(key));
    }

    // DELETE ALL
    // http://localhost:4444/register/api/v1.0.0/delete/all
    @Override
    @GetMapping("/delete/all")
    public ResponseEntity<?> registerApiDeleteAll() {
        return ResponseEntity.ok(iRegisterServices.registerServiceDeleteAll());
    }

    /////////////////////////////////////////////////////////////////
    // SEARCH
    // LOGIN
    // http://localhost:4444/register/api/v1.0.0/search?surname=mizrak
    @Override
    @GetMapping("/search")
    public ResponseEntity<?> loginApiFindBySurname(@RequestParam String surname) {
        return ResponseEntity.ok(iRegisterServices.loginServiceFindBySurname(surname));
    }

    ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // http://localhost:4444/register/api/v1.0.0/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> registerApiCreate(@Valid @RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(iRegisterServices.registerServiceCreate(registerDto)) ;
    }

    // LIST
    // http://localhost:4444/register/api/v1.0.0/list
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<RegisterDto>> registerApiList() {
        return ResponseEntity.ok().body(iRegisterServices.registerServiceList());
    }

    // FIND BY ID
    // http://localhost:4444/register/api/v1.0.0/find/1
    @Override
    @GetMapping("/find/{id}")
    public ResponseEntity<?> registerApiFindById(@PathVariable(name = "id") Long id) {
        //return ResponseEntity.status(200).body(iRegisterServices.registerServiceFindById(id));
        return ResponseEntity.ok(iRegisterServices.registerServiceFindById(id));
    }

    // UPDATE
    // http://localhost:4444/register/api/v1.0.0/update/1
    @Override
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> registerApiUpdate( @PathVariable(name="id") Long id,@Valid @RequestBody RegisterDto registerDto) {
        return ResponseEntity.status(HttpStatus.OK).body(iRegisterServices.registerServiceUpdate(id,registerDto));
    }

    // DELETE BY ID
    // http://localhost:4444/register/api/v1.0.0/delete/1
    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> registerApiDeleteById(@PathVariable(name="id")  Long id) {
        //return new ResponseEntity<>((HttpStatusCode) iRegisterServices.registerServiceDeleteById(id));
        return ResponseEntity.ok(iRegisterServices.registerServiceDeleteById(id));
    }


} //end class
