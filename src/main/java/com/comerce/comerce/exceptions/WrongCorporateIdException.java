package com.comerce.comerce.exceptions;

public class WrongCorporateIdException extends  RuntimeException{

    public  WrongCorporateIdException(String id){
        super("The corporateId must be Zara (1) not : " + id);
    }
}
