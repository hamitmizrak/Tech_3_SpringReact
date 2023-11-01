package com.hamitmizrak.tech_3_springreact.data.repository;


import com.hamitmizrak.tech_3_springreact.data.entity.RegisterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// 3 2 1 8

// CrudRepository
// JpaRepository
// PagingAndSortingRepository
@Repository
public interface IRegisterRepository extends CrudRepository<RegisterEntity,Long> {

    // Delivered Query
    Optional<RegisterEntity> findByRegisterEmail(String email);

    // Login surname
    Optional<RegisterEntity> findByRegisterSurname(String surname);
} //end interface
