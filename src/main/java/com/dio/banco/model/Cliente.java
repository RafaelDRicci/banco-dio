package com.dio.banco.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

    private static long ID_CONTROLE = 1;

    private long id;
    private String nome;

    public Cliente(String nome){
        this.nome = nome;
        id = ID_CONTROLE;
        ID_CONTROLE++;
    }

}
