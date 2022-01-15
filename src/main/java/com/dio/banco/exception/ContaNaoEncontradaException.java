package com.dio.banco.exception;

public class ContaNaoEncontradaException extends Exception{

    public ContaNaoEncontradaException(int agencia, long numero){
        super(String.format("CONTA %04d %05d NAO ENCONTRADA!", agencia, numero));
    }

}
