package com.hamitmizrak.tech_3_springreact.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

// D: Dto
public interface IRegisterApi<D> {

    // INJECTION

    // SPEED DATA
    public ResponseEntity<List<D>> registerApiSpeedData(Long key);

    // ALL DELETE
    public ResponseEntity<?> registerApiDeleteAll();


    /////////////////////////////////////////////////////////////
    // LOGIN
    // FIND SURNAME
    public ResponseEntity<?> loginApiFindBySurname(String surname);

    ////////////////////////////////////////////////////////////

    // C R U D
    // CREATE
    public ResponseEntity<?> registerApiCreate(D d);

    // LIST
    public ResponseEntity<List<D>> registerApiList();

    // FIND
    public ResponseEntity<?> registerApiFindById(Long id);

    // UPDATE
    public ResponseEntity<?> registerApiUpdate(Long id, D d);

    // DELETE
    public ResponseEntity<?> registerApiDeleteById(Long id);

} //end interface

