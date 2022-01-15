package com.dio.banco.model;

import com.dio.banco.exception.ContaNaoEncontradaException;
import com.dio.banco.exception.ContaNaoPertenceAoClienteException;
import com.dio.banco.exception.SaldoInsuficienteException;
import com.dio.banco.model.conta.Conta;
import com.dio.banco.model.conta.ContaCorrente;
import com.dio.banco.model.conta.ContaPoupanca;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Banco {

    private static int AGENCIA_PADRAO = 1;
    private static int NUMERO_CONTA = 1;

    private String nome;
    private int agencia;
    private List<Conta> contas;

    public Banco(String nome) {
        agencia = AGENCIA_PADRAO;
        this.nome = nome;
        contas = new ArrayList<>();
        AGENCIA_PADRAO++;
    }

    public void abrirContaCorrente(Cliente cliente){

        contas.add(new ContaCorrente(agencia, NUMERO_CONTA, 100f, cliente));
        NUMERO_CONTA++;
    }

    public void abrirContaPoupanca(Cliente cliente){

        contas.add(new ContaPoupanca(agencia, NUMERO_CONTA, 100f, cliente));
        NUMERO_CONTA++;
    }

    public List<Cliente> listAllClients(){
        List<Cliente> clientes = new ArrayList<>();
        contas.forEach(conta ->  clientes.add(conta.getCliente()));
        return clientes;
    }

    public void exibirTodosOsClientes(){
        System.out.println("===========================================");
        System.out.println("\t\tCLIENTES");
        for (Cliente cliente : listAllClients()) {
            System.out.println(cliente.getNome());
        }
    }

    public void exibirTodasAsContas(){
        System.out.println("===========================================");
        System.out.println("\t\tCONTAS");
        this.contas.forEach(Conta::informacoes);
    }

    public void informacoesConta(int agencia,
                                 long numero,
                                 int idCliente) throws
            ContaNaoEncontradaException,
            ContaNaoPertenceAoClienteException {

        Conta conta = findByAgenciaENumero(agencia, numero);
        validaContaCliente(conta, idCliente);
        conta.informacoes();

    }

    public void consultarConta(int agencia,
                                 long numero,
                                 long idCLiente) throws
            ContaNaoEncontradaException,
            ContaNaoPertenceAoClienteException {

        Conta conta = findByAgenciaENumero(agencia, numero);
        validaContaCliente(conta, idCLiente);
        conta.informacoes();
    }

    public void depositar(int agencia,
                          long numero,
                          double valor) throws ContaNaoEncontradaException {

        Conta conta = findByAgenciaENumero(agencia, numero);
        conta.depositar(valor);
    }

    public double sacar(int agencia,
                        long numero,
                        long idCliente,
                        double valor) throws
            ContaNaoEncontradaException,
            ContaNaoPertenceAoClienteException,
            SaldoInsuficienteException {

        Conta conta = findByAgenciaENumero(agencia, numero);
        validaContaCliente(conta, idCliente);
        return conta.sacar(valor);
    }

    public void transferir(Conta conta,
                           int agenciaTransferinte,
                           long numeroTransferinte,
                           long idClienteTransferinte,
                           double valor) throws
            ContaNaoEncontradaException,
            ContaNaoPertenceAoClienteException,
            SaldoInsuficienteException {

        Conta contaTransferinte = findByAgenciaENumero(agenciaTransferinte, numeroTransferinte);
        validaContaCliente(contaTransferinte, idClienteTransferinte);
        contaTransferinte.transferir(conta, valor);
    }

    private Conta findByAgenciaENumero(int agencia, long numero) throws ContaNaoEncontradaException {
        for(Conta conta : contas){
            if(conta.getAgencia() == agencia && conta.getNumero() == numero) return conta;
        }
        throw new ContaNaoEncontradaException(agencia, numero);
    }

    private void validaContaCliente(Conta conta, long idCliente) throws ContaNaoPertenceAoClienteException {
        if(!(conta.getCliente().getId() == idCliente))
            throw new ContaNaoPertenceAoClienteException(conta, idCliente);
    }

}
