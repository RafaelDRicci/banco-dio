package com.dio.banco.exception;

import com.dio.banco.model.conta.Conta;

public class ContaNaoPertenceAoClienteException extends Exception{

    public ContaNaoPertenceAoClienteException(Conta conta, long idCliente){
        super(String.format("CONTA %04d %05d NAO PERTENCE AO CLIENTE %s",
                conta.getAgencia(), conta.getNumero(), idCliente));
    }

}
