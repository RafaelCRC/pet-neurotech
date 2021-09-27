package br.unicap.pet.neurotech.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.unicap.pet.neurotech.model.exceptions.*;

public class ClienteDAOMemoria implements ClienteDAO {

    private List<UserAbs> clientes;
    private List<UserAbs> gerentes;
    private UserAbs Logged;

    private static ClienteDAOMemoria self;

    public ClienteDAOMemoria() {
        clientes = new ArrayList<UserAbs>();
        gerentes = new ArrayList<UserAbs>();
    }

    public static ClienteDAO getInstance() {
        if (self == null) {
            self = new ClienteDAOMemoria();
        }
        return self;
    }

    // metodos de login e registro
    @Override
    public void registro(String login, String senha, int tipoConta, boolean isGerente) throws ContaJaExisteException {

        UserAbs novoUser;
        Conta novaConta;

        if (isGerente) {
            if (!buscarContaGerente(login)) {
                novoUser = new UserGerente(login, senha);
                this.gerentes.add(novoUser);
            } else {
                throw new ContaJaExisteException();
            }
        } else {
            if (!buscarConta(login)) {
                if (tipoConta == 1) { // conta normal
                    novaConta = new Conta();
                    novoUser = new UserCliente(login, senha, novaConta);
                    this.clientes.add(novoUser);
                } else if (tipoConta == 2) { // conta bonificada
                    novaConta = new ContaBoni();
                    novoUser = new UserCliente(login, senha, novaConta);
                    this.clientes.add(novoUser);
                }
            } else {
                throw new ContaJaExisteException();
            }
        }
    }

    @Override
    public void logIn(String login, String senha, int isGerente) throws DadosLoginErradoException {

        if (isGerente == 2) {
            for (UserAbs user : gerentes) {
                if (user.getLogin().equals(login) && user.getSenha().equals(senha)) {
                    //attLogged(user);
                    return;
                }
            }
            throw new DadosLoginErradoException();
        } else {
            for (UserAbs user : clientes) {
                if (user.getLogin().equals(login) && user.getSenha().equals(senha)) {
                    //attLogged(user);
                    return;
                }
            }
            throw new DadosLoginErradoException();
        }
    }

    @Override
    public void attLogged(int id) {
        //this.Logged = user;
    }

    @Override
    public void logOut() {
        this.Logged = null;
    }

    // metodos de gerente
    @Override
    public boolean buscarConta(String login) {
        boolean encontrado = false;
        for (UserAbs user : clientes) {
            if (user.getLogin().equals(login)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    @Override
    public boolean buscarContaGerente(String login) {
        boolean encontrado = false;
        for (UserAbs user : gerentes) {
            if (user.getLogin().equals(login)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    @Override
    public void criarConta(String login, String senha, int tipoConta) throws ContaJaExisteException {
        if (buscarConta(login)) {
            throw new ContaJaExisteException();
        }
        UserAbs novoUser;
        Conta novaConta;
        if (tipoConta == 1) {
            novaConta = new Conta();
        } else {
            novaConta = new ContaBoni();
        }
        novoUser = new UserCliente(login, senha, novaConta);
        this.clientes.add(novoUser);
    }

    @Override
    public void remover(String login) throws ContaInexistenteException {

        for (UserAbs user : clientes) {
            if (user.getLogin().equals(login)) {
                clientes.remove(user);
                return;
            }
        }
        throw new ContaInexistenteException();
    }

    @Override
    public void bonifica(String login) throws ContaInexistenteException, ContaTipoErradoException {

        if (buscarConta(login)) {
            for (UserAbs user : clientes) {
                if (user.getLogin().equals(login)) {
                    Conta temp = ((UserCliente) user).getConta();
                    if (temp instanceof ContaBoni) {
                        ((ContaBoni) ((UserCliente) user).getConta()).doBonifica();
                        return;
                    }
                }
            }
            throw new ContaTipoErradoException();
        }
        throw new ContaInexistenteException();
    }

    @Override
    public String getConta(String login) throws ContaInexistenteException {

        String contaString;

        for (UserAbs user : clientes) {
            if (user.getLogin().equals(login)) {
                contaString = ("Usuario: " + user.getLogin() + "; Saldo: " + ((UserCliente) user).getConta().getSaldo()
                        + "; Tipo: " + ((UserCliente) user).getConta().getTipo());
                return contaString;
            }
        }
        throw new ContaInexistenteException();
    }

    @Override
    public List getContas() {

        List<String> contas = new ArrayList<String>();

        for (UserAbs user : clientes) {
            contas.add("Usuario: " + user.getLogin() + "; Saldo: " + ((UserCliente) user).getConta().getSaldo()
                    + "; Tipo: " + ((UserCliente) user).getConta().getTipo());
        }
        return contas;
    }

    @Override
    public void sacarConta(float quantia) throws SaldoInsuficienteException, ValorInvalidoException {
        if (quantia < 0) {
            throw new ValorInvalidoException();
        }
        for (UserAbs user : clientes) {
            if (user.getLogin().equals(Logged.getLogin())) {
                ((UserCliente) user).getConta().sacar(quantia);
            }
        }
    }

    @Override
    public void depositarConta(float quantia) throws ValorInvalidoException {
        if (quantia < 0) {
            throw new ValorInvalidoException();
        }
        for (UserAbs user : clientes) {
            if (user.getLogin().equals(Logged.getLogin())) {
                ((UserCliente) user).getConta().depositar(quantia);
            }
        }
    }

    @Override
    public Float getSaldo() {
        Float saldo = null;
        for (UserAbs user : clientes) {
            if (user.getLogin().equals(Logged.getLogin())) {
                saldo = ((UserCliente) user).getConta().getSaldo();
            }
        }
        return saldo;
    }

    @Override
    public void connect() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dis() {
        // TODO Auto-generated method stub
        
    }
}
