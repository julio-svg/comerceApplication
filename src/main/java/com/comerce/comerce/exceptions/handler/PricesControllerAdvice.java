package com.comerce.comerce.exceptions.handler;

import com.comerce.comerce.exceptions.WrongCorporateIdException;
import com.comerce.comerce.exceptions.menssage.Menssage;
import com.comerce.comerce.exceptions.menssage.Type;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PricesControllerAdvice {

    @ExceptionHandler(WrongCorporateIdException.class)
    public ResponseEntity<Menssage> handle(WrongCorporateIdException e){
        return new ResponseEntity(e.getMen(),e.getHttpStatus());
    }
}
