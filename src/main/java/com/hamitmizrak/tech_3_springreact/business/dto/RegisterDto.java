package com.hamitmizrak.tech_3_springreact.business.dto;

import com.hamitmizrak.tech_3_springreact.annotation.AnnotationUniqueEmailAddress;
import com.hamitmizrak.tech_3_springreact.audit.AuditingAwareBaseDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data
@Log4j2
@Builder

// REGISTER
public class RegisterDto extends AuditingAwareBaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // Global Variable (6)
    // Dikkat: message sonunda boşluk olmasın
    @NotEmpty(message = "{register.nickname.validation.constraints.NotNull.message}")
    private String registerNickName;

    @NotEmpty(message = "{register.name.validation.constraints.NotNull.message}")
    private String registerName;

    @NotEmpty(message = "{register.surname.validation.constraints.NotNull.message}")
    private String registerSurname;

    // Kendi annotation'ımı yazdı
    @AnnotationUniqueEmailAddress
    @NotEmpty(message = "{register.email.validation.constraints.NotNull.message}")
    @Email(message = "{register.email.validation.constraints.regex.message}")
    private String registerEmail;

    @NotEmpty(message = "{register.password.validation.constraints.NotNull.message}")
    private String registerPassword;

    @Builder.Default //default olarak kullanıcı pasif olsun admin bunu aktif yapsın
    private Boolean registerIsPassive=false;

    //parametresiz constructor
    public RegisterDto() {
    }

    //parametreli constructor
    public RegisterDto(String registerNickName, String registerName, String registerSurname, String registerEmail, String registerPassword, Boolean registerIsPassive) {
        this.registerNickName = registerNickName;
        this.registerName = registerName;
        this.registerSurname = registerSurname;
        this.registerEmail = registerEmail;
        this.registerPassword = registerPassword;
        this.registerIsPassive = registerIsPassive;
    }

    // toString
    @Override
    public String toString() {
        return "RegisterDto{" +
                "registerNickName='" + registerNickName + '\'' +
                ", registerName='" + registerName + '\'' +
                ", registerSurname='" + registerSurname + '\'' +
                ", registerEmail='" + registerEmail + '\'' +
                ", registerPassword='" + registerPassword + '\'' +
                ", registerIsPassive='" + registerIsPassive + '\'' +
                ", id=" + id +
                ", systemDate=" + systemDate +
                ", createdUser='" + createdUser + '\'' +
                ", createdDate=" + createdDate +
                ", lastUser='" + lastUser + '\'' +
                ", lastDate=" + lastDate +
                '}';
    } //end toString

} //end class
