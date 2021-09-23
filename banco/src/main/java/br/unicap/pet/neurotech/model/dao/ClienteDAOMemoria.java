package br.unicap.pet.neurotech.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.unicap.pet.neurotech.model.exceptions.*;

public class ClienteDAOMemoria implements ClienteDAO {

    private List<Conta> clientes;
    private List<Conta> gerentes;
    private Conta Logged;
    private static ClienteDAOMemoria self;

    public ClienteDAOMemoria() {
        clientes = new ArrayList<Conta>();
        gerentes = new ArrayList<Conta>();
    }

    public static ClienteDAO getInstance() {
        if (self == null) {
            self = new ClienteDAOMemoria();
        }
        return self;
    }

    // metodos de login e registro
    @Override
    public void registro(int idConta, String senha, int tipoConta, boolean isGerente) throws ContaJaExisteException {

        Conta novaConta;

        if (isGerente) {
            if (!buscarContaGerente(idConta)) {
                novaConta = new ContaGerente(idConta, senha); // falta a senha
                this.gerentes.add(novaConta);
            } else {
                throw new ContaJaExisteException();
            }
        } else {
            if (!buscarConta(idConta)) {
                if (tipoConta == 1) {
                    novaConta = new Conta(idConta, senha);
                    this.clientes.add(novaConta);
                } else if (tipoConta == 2) {
                    novaConta = new ContaBoni(idConta, senha);
                    this.clientes.add(novaConta);
                }
            } else {
                throw new ContaJaExisteException();
            }
        }
    }

    @Override
    public void logIn(int idConta, String senha, int tipoConta) throws DadosLoginErradoException {

        Conta contaLogin;

        if (tipoConta == 2) {
            for (Conta conta : gerentes) {
                if (conta.getNumero() == idConta && conta.getSenha().equals(senha)) {
                    contaLogin = new ContaGerente(idConta, senha);
                    attLogged(contaLogin);
                    return;
                }
            }
            throw new DadosLoginErradoException();
        } else {
            for (Conta conta : clientes) {
                System.out.println("Logissssss");
                System.out.println(conta.getSenha());
                if (conta.getNumero() == idConta && conta.getSenha().equals(senha)) {
                    contaLogin = new Conta(idConta, senha);
                    attLogged(contaLogin);
                    return;
                }
            }
            throw new DadosLoginErradoException();
        }
    }

    @Override
    public void attLogged(Conta conta) {
        this.Logged = conta;
    }

    @Override
    public void logOut() {
        this.Logged = null;
    }

    // metodos de gerente
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

    @Override
    public boolean buscarContaGerente(int numConta) {
        boolean encontrado = false;
        for (Conta conta : gerentes) {
            if (conta.getNumero() == numConta) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    @Override
    public void criarConta(int idConta, String senha, int tipoConta) throws ContaJaExisteException {
        if (buscarConta(idConta)) {
            throw new ContaJaExisteException();
        }
        Conta novaConta;
        if (tipoConta == 1) {
            novaConta = new Conta(idConta, senha);
        } else {
            novaConta = new ContaBoni(idConta, senha);
        }
        this.clientes.add(novaConta);
    }

    @Override
    public void remover(int idConta) throws ContaInexistenteException {

        for (Conta conta : clientes) {
            if (conta.getNumero() == idConta) {
                clientes.remove(conta);
                return;
            }
        }
        throw new ContaInexistenteException();
    }

    @Override
    public void bonifica(int idConta) throws ContaInexistenteException, ContaTipoErradoException {

        if (buscarConta(idConta)) {
            for (Conta conta : clientes) {
                if (conta.getNumero() == idConta) {
                    if (conta instanceof ContaBoni) {
                        ((ContaBoni) conta).doBonifica();
                        return;
                    }
                }
            }
            throw new ContaTipoErradoException();
        }
        throw new ContaInexistenteException();
    }

    @Override
    public String getConta(int idConta) throws ContaInexistenteException {

        String contaString;

        for (Conta conta : clientes) {
            if (conta.getNumero() == idConta) {
                contaString = ("Conta: " + conta.getNumero() + "; Saldo: " + conta.getSaldo() + "; Tipo: "
                        + conta.getTipo());
                return contaString;
            }
        }
        throw new ContaInexistenteException();
    }

    @Override
    public List getContas() {

        List<String> contas = new ArrayList<String>();

        for (Conta conta : clientes) {
            contas.add("Conta: " + conta.getNumero() + "; Saldo: " + conta.getSaldo() + "; Tipo: " + conta.getTipo());
        }
        return contas;
    }

    // metodos cliente
    @Override
    public void sacarConta(float quantia) throws SaldoInsuficienteException, ValorInvalidoException {
        if (quantia < 0) {
            throw new ValorInvalidoException();
        }
        for (Conta conta : clientes) {
            if (conta.getNumero() == this.Logged.getNumero()) {
                conta.sacar(quantia);
            }
        }
    }

    @Override
    public void depositarConta(float quantia) throws ValorInvalidoException {
        if (quantia < 0) {
            throw new ValorInvalidoException();
        }
        for (Conta conta : clientes) {
            if (conta.getNumero() == this.Logged.getNumero()) {
                conta.depositar(quantia);
            }
        }
    }

    @Override
    public Float getSaldo() {
        Float saldo = null;
        for (Conta conta : clientes) {
            if (conta.getNumero() == this.Logged.getNumero()) {
                saldo = conta.getSaldo();
            }
        }
        return saldo;
    }
}
