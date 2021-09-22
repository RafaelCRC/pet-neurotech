package br.unicap.pet.neurotech.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.unicap.pet.neurotech.model.exceptions.ContaInexistenteException;
import br.unicap.pet.neurotech.model.exceptions.ContaJaExisteException;
import br.unicap.pet.neurotech.model.exceptions.ContaTipoErradoException;
import br.unicap.pet.neurotech.model.exceptions.SaldoInsuficienteException;
import br.unicap.pet.neurotech.model.exceptions.ValorInvalidoException;

public class ClienteDAOMemoria implements ClienteDAO {

    private List<Conta> clientes;
    private static ClienteDAOMemoria self;

    public ClienteDAOMemoria() {
        clientes = new ArrayList<Conta>();
    }

    @Override
    public boolean buscarConta(int numConta) {
        boolean encontrado = false;
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public static ClienteDAO getInstance() {
        if (self == null) {
            self = new ClienteDAOMemoria();
        }
        return self;
    }

    @Override
    public void sacarConta(int numConta, float quantia) throws SaldoInsuficienteException, ValorInvalidoException {
        if (quantia < 0){
            throw new ValorInvalidoException();
        }
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                conta.sacar(quantia);
            }
        }
    }

    @Override
    public void depositarConta(int numConta, float quantia) throws ValorInvalidoException {
        if (quantia < 0){
            throw new ValorInvalidoException();
        }
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                conta.depositar(quantia);
            }
        }
    }

    @Override
    public void criarConta(int idConta, int tipoConta) throws ContaJaExisteException {
        if (buscarConta(idConta)) {
            throw new ContaJaExisteException();
        }
        Conta novaConta;
        if (tipoConta == 1) {
            novaConta = new Conta(idConta);
        } else {
            novaConta = new ContaBoni(idConta);
        }
        this.clientes.add(novaConta);
    }

    @Override
    public void remover(int idConta) throws ContaInexistenteException {

        for (Conta conta : clientes){
            if (conta.getNumero() == idConta){
                clientes.remove(conta);
                return;
            }
        }
        throw new ContaInexistenteException();
    }

    @Override
    public String getConta(int idConta) throws ContaInexistenteException {

        String contaString;

        for (Conta conta : clientes){
            if (conta.getNumero() == idConta){
                contaString = ("Conta: " + conta.getNumero() + "; Saldo: " + conta.getSaldo() + "; Tipo: " + conta.getTipo());

                return contaString;
            }
        }
        throw new ContaInexistenteException();
    }

    @Override
    public List getContas() {

        List<String> contas = new ArrayList<String>();

        for (Conta conta : clientes){
            contas.add("Conta: " + conta.getNumero() + "; Saldo: " + conta.getSaldo() + "; Tipo: " + conta.getTipo());
        }
        return contas;
    }

    @Override
    public void bonifica(int idConta) throws ContaInexistenteException, ContaTipoErradoException {

        if (buscarConta(idConta)){
            for (Conta conta : clientes){
                if (conta.getNumero() == idConta){
                    if (conta instanceof ContaBoni){
                        ((ContaBoni)conta).doBonifica();
                        return;
                    }
                }
            }
            throw new ContaTipoErradoException();
        }
        throw new ContaInexistenteException();
    }

}
