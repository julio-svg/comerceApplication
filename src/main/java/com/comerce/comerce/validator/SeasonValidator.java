package com.comerce.comerce.validator;

import com.comerce.comerce.exceptions.WrongCorporateIdException;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class SeasonValidator {

    private static final String CTE_STRING_ZARA_CORPORATE_ID = "1";

    private static final Predicate<String> isValidCorporate = corporateId -> corporateId.equals(CTE_STRING_ZARA_CORPORATE_ID) ;

    public void validateinput(String corporateId, String productId, String applicationDate){
        validateCorporateId(corporateId);
        //TODO resto de campos de entrada, formato y logica de negocio
    }
    public void validateCorporateId(String corporateId){
        if(!isValidCorporate.test(corporateId)){
            throw new WrongCorporateIdException(corporateId);
        }

    }

    //TODO: validaciones para el resto de campos
}
