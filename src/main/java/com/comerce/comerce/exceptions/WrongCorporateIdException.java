package com.comerce.comerce.exceptions;

import com.comerce.comerce.exceptions.menssage.Menssage;
import com.comerce.comerce.exceptions.menssage.Type;
import org.springframework.http.HttpStatus;

public class WrongCorporateIdException extends  MainException{

    public  WrongCorporateIdException(String id){
        super();
        super.setHttpStatus(HttpStatus.BAD_REQUEST);
        super.setMen(new Menssage(Type.ERROR,"The corporateId must be Zara (1) not : " + id, "Zara (1) is mandatory"));
    }
}
