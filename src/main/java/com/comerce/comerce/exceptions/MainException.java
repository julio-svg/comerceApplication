package com.comerce.comerce.exceptions;

import com.comerce.comerce.exceptions.menssage.Menssage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MainException extends RuntimeException{

    private Menssage men;

    private HttpStatus httpStatus;

    public MainException() {
        super();
    }
}
