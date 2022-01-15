package com.dio.banco.model.conta;

import com.dio.banco.exception.SaldoInsuficienteException;
import com.dio.banco.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;


@Getter
@AllArgsConstructor
public abstract class Conta implements InterfaceConta{

    private final int agencia;
    private final long numero;
    private double saldo;
    private final Cliente cliente;

    @Override
    public double sacar(double valor) throws SaldoInsuficienteException {
        if(valor <= saldo){
            saldo -= valor;
            return valor;
        } else throw new SaldoInsuficienteException();
    }

    @Override
    public void depositar(double valor) {
        this.saldo+=valor;
    }

    @Override
    public void transferir(Conta conta, double valor) throws SaldoInsuficienteException {
        conta.depositar(this.sacar(valor));
    }

    @Override
    public void informacoes(){
        System.out.printf("CLIENTE: %s%n", cliente.getNome());
        System.out.printf("AGENCIA: %04d%n", agencia);
        System.out.printf("NUMERO: %05d%n", numero);
        System.out.printf("EXTRATO: R$%.2f%n", saldo);
    }

}
