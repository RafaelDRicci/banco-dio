package com.dio.banco.model.conta;

import com.dio.banco.model.Cliente;

public class ContaCorrente extends Conta{

    public ContaCorrente(int agencia, long numero, double saldo, Cliente cliente) {
        super(agencia, numero, saldo, cliente);
    }

    @Override
    public void informacoes(){
        System.out.println("===========================================");
        System.out.println("CONTA CORRENTE");
        super.informacoes();
    }
}
