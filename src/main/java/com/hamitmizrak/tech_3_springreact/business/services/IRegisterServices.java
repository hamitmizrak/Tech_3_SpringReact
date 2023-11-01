package com.hamitmizrak.tech_3_springreact.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface IRegisterServices<D,E>{

    // INJECTION

    // Model Mapper
    public D entityToDto(E e);
    public E dtoToEntity(D d);

    ////////////////////////////////////////////////////////////
    // SPEED DATA
    public List<D> registerServiceSpeedData(Long key);

    // ALL DELETE
    public String registerServiceDeleteAll();
    /////////////////////////////////////////////////////////////
    // LOGIN
    // FIND SURNAME
    public D loginServiceFindBySurname(String surname);

    ////////////////////////////////////////////////////////////
    //  REGISTER C R U D
    // CREATE
    public D registerServiceCreate(D d);

    // LIST
    public List<D> registerServiceList();

    // FIND
    public D registerServiceFindById(Long id);

    // UPDATE
    public D registerServiceUpdate(Long id, D d);

    // DELETE
    public D registerServiceDeleteById(Long id);

} //end interface
