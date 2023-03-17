package com.comerce.comerce.exceptions.menssage;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Menssage {

    public Menssage(Type type, String description, String alias) {
        this.type = type;
        this.description = description;
        this.alias = alias;
    }

    Type type;
    String description;
    String alias;


}