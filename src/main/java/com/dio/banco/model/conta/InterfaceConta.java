package com.dio.banco.model.conta;

import com.dio.banco.exception.SaldoInsuficienteException;

public interface InterfaceConta {

    double sacar(double valor) throws SaldoInsuficienteException;
    void depositar(double valor);
    void transferir(Conta conta, double valor) throws SaldoInsuficienteException;
    void informacoes();
}
