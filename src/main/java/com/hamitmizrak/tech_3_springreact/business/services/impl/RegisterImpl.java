package com.hamitmizrak.tech_3_springreact.business.services.impl;


import com.hamitmizrak.tech_3_springreact.bean.ModelMapperBeanClass;
import com.hamitmizrak.tech_3_springreact.bean.PasswordEncoderBeanClass;
import com.hamitmizrak.tech_3_springreact.business.dto.RegisterDto;
import com.hamitmizrak.tech_3_springreact.business.services.IRegisterServices;
import com.hamitmizrak.tech_3_springreact.data.entity.RegisterEntity;
import com.hamitmizrak.tech_3_springreact.data.repository.IRegisterRepository;
import com.hamitmizrak.tech_3_springreact.exception.HamitMizrakException;
import com.hamitmizrak.tech_3_springreact.exception.Resource404NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICE
// Asıl is Yükünü yapan yer
@Service
public class RegisterImpl implements IRegisterServices<RegisterDto, RegisterEntity> {

    // Injection
    private final IRegisterRepository iRegisterRepository;
    private final ModelMapperBeanClass modelMapperBeanClass;

    private final PasswordEncoderBeanClass passwordEncoderBeanClass;

    // Model Mapper
    @Override
    public RegisterDto entityToDto(RegisterEntity registerEntity) {
        return modelMapperBeanClass.modelMapperMethod().map(registerEntity, RegisterDto.class);
    }

    @Override
    public RegisterEntity dtoToEntity(RegisterDto registerDto) {
        return modelMapperBeanClass.modelMapperMethod().map(registerDto, RegisterEntity.class);
    }

    /////////////////////////////////////////////////////////////////
    // SPEED DATA
    @Override
    public List<RegisterDto> registerServiceSpeedData(Long key) {
        List<RegisterDto> registerDtoList=new ArrayList<>();
        if (key != null) {
            for (int i = 1; i <=key ; i++) {
                RegisterDto registerDto=RegisterDto
                        .builder()
                        .registerNickName("nick name "+i)
                        .registerName("name "+i)
                        .registerSurname("surname "+i)
                        .registerPassword(passwordEncoderBeanClass.passwordEncoderMethod().encode(UUID.randomUUID().toString()))
                        .registerEmail("hamitmizrak"+UUID.randomUUID().toString()+"@gmail.com")
                        .registerIsPassive(false)
                        .build();
                RegisterEntity registerEntity = dtoToEntity(registerDto);
                iRegisterRepository.save(registerEntity);
                registerDto.setId(registerEntity.getId());
                registerDto.setSystemDate(registerEntity.getSystemDate());
                registerDtoList.add(registerDto);
            }
        }
        registerDtoList.stream().forEach((temp)->
                System.out.println(temp)
        );
        return registerDtoList;
    }

    // DELETE ALL
    @Override
    public String registerServiceDeleteAll() {
        iRegisterRepository.deleteAll();
        System.out.println(iRegisterRepository.findAll().toString());
        return iRegisterRepository.findAll().toString();
    }

    /////////////////////////////////////////////////////////////////
    // LOGIN
    @Override
    public RegisterDto loginServiceFindBySurname(String surname) {
        Optional<RegisterEntity> loginFindBySurname=iRegisterRepository.findByRegisterSurname(surname);
        RegisterDto registerDto=entityToDto(loginFindBySurname.get());
        if(loginFindBySurname.isPresent()){
            return registerDto;
        }
        // Eğer kullanıcı yoksa null döndersin
        return null;
    }

    /////////////////////////////////////////////////////////////////
    // C R U D
    // CREATE
    // org.springframework.transaction.annotation.Transactional
    @Override
    @Transactional // create , delete, update
    public RegisterDto registerServiceCreate(RegisterDto registerDto) {
        if (registerDto != null) {
            RegisterEntity registerEntity = dtoToEntity(registerDto);
            // Password Encoder Bean
            //passwordEncoderBeanClass.passwordEncoderMethod().encode(registerDto.getRegisterPassword());
            iRegisterRepository.save(registerEntity);
            // Dto Set(id ve date)
            registerDto.setId(registerEntity.getId());
            registerDto.setSystemDate(registerEntity.getSystemDate());
        }
        return registerDto;
    }

    // LIST
    @Override
    public List<RegisterDto> registerServiceList() {
        // ENTITIY LIST
       Iterable<RegisterEntity> registerEntityIterable = iRegisterRepository.findAll();
       // DTO LIST
       List<RegisterDto> registerDtoList=new ArrayList<>();
       //forEach Loop
        for(RegisterEntity entity: registerEntityIterable ){
            // Entity Listesini ==> Dto Listesine çeviriyor
            registerDtoList.add(entityToDto(entity));
        }
        log.info("Register Liste Sayısı:"+registerDtoList.size());
        return registerDtoList;
    }

    // FIND BY ID
    @Override
    public RegisterDto registerServiceFindById(Long id) {
        // 1.YOL
        /*
        Optional<RegisterEntity> findRegisterEntityWay1=iRegisterRepository.findById(id);
        RegisterDto registerDtoWay1=entityToDto(findRegisterEntityWay1.get());
        if(findRegisterEntityWay1.isPresent()){
            return registerDtoWay1;
        }
        */

        // 2.YOL
        RegisterEntity findRegisterEntityWay2=null;
        if(id!=null){
            findRegisterEntityWay2=iRegisterRepository.findById(id).orElseThrow(
                    ()->new Resource404NotFoundException(id+ " nolu id yoktur")
            );
        }else if(id==null){
            throw new HamitMizrakException("id null olarak geldi");
        }
        return entityToDto(findRegisterEntityWay2);
    }

    // UPDATE
    @Override
    @Transactional // create , delete, update
    public RegisterDto registerServiceUpdate(Long id, RegisterDto registerDto) {
        // Öncelikle ilgili Register kaydını bulmalısın.
        RegisterDto registerFindDto= registerServiceFindById(id);
        //Entity Instance
        RegisterEntity registerEntity = null;
        if(registerFindDto!=null){
            registerEntity=dtoToEntity(registerDto);
            registerEntity.setId(registerDto.getId());
            registerEntity.setRegisterNickName(registerDto.getRegisterNickName());
            registerEntity.setRegisterName(registerDto.getRegisterName());
            registerEntity.setRegisterSurname(registerDto.getRegisterSurname());
            registerEntity.setRegisterEmail(registerDto.getRegisterEmail());
            registerEntity.setRegisterPassword(registerDto.getRegisterPassword());
            registerEntity.setRegisterIsPassive(registerDto.getRegisterIsPassive());
            iRegisterRepository.save(registerEntity);
        }
        return entityToDto(registerEntity);
    }

    // DELETE BY ID
    @Override
    @Transactional // create , delete, update
    public RegisterDto registerServiceDeleteById(Long id) {
        // Öncelikle ilgili Register kaydını bulmalısın.
        RegisterDto registerFindDto= registerServiceFindById(id);
        if(registerFindDto!=null){
            iRegisterRepository.deleteById(id);
        }
        return registerFindDto;
    }

} //end class
