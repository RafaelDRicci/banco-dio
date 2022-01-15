package com.dio.banco;

import com.dio.banco.exception.ContaNaoEncontradaException;
import com.dio.banco.exception.ContaNaoPertenceAoClienteException;
import com.dio.banco.exception.SaldoInsuficienteException;
import com.dio.banco.model.Banco;
import com.dio.banco.model.Cliente;

public class Main {

    public static void main(String[] args) {

       Banco banco = new Banco("Banco DIO");
       Cliente rafael = new Cliente("Rafael");
       Cliente daniel = new Cliente("Daniel");
       Cliente maria = new Cliente("Maria");

       banco.abrirContaCorrente(rafael);
       banco.abrirContaPoupanca(rafael);

       banco.abrirContaPoupanca(daniel);

       banco.abrirContaCorrente(maria);

       try {
          banco.consultarConta(1,1, rafael.getId());
       } catch (ContaNaoEncontradaException | ContaNaoPertenceAoClienteException e) {
          e.printStackTrace();
       }

       try {
          banco.depositar(1,1, 1000f);
       } catch (ContaNaoEncontradaException e) {
          e.printStackTrace();
       }
       try {
          banco.sacar(1,1,rafael.getId(), 100f);
       } catch (ContaNaoEncontradaException | ContaNaoPertenceAoClienteException | SaldoInsuficienteException e) {
          e.printStackTrace();
       }

       try {
          banco.transferir(banco.getContas().get(3),1,1, rafael.getId(), 500f);
       } catch (ContaNaoEncontradaException | SaldoInsuficienteException | ContaNaoPertenceAoClienteException e) {
          e.printStackTrace();
       }

       banco.exibirTodosOsClientes();
       banco.exibirTodasAsContas();

       try {
          banco.depositar(2,1,100f);
       } catch (ContaNaoEncontradaException e) {
          e.printStackTrace();
       }

       try {
          banco.sacar(1,2, rafael.getId(), 500f);
       } catch (ContaNaoEncontradaException | SaldoInsuficienteException | ContaNaoPertenceAoClienteException e) {
          e.printStackTrace();
       }

       try {
          banco.sacar(1,3, rafael.getId(), 100f );
       } catch (ContaNaoEncontradaException | SaldoInsuficienteException | ContaNaoPertenceAoClienteException e) {
          e.printStackTrace();
       }

    }

}
