package br.unicap.pet.neurotech.model.dao;

import java.util.List;

import br.unicap.pet.neurotech.model.exceptions.*;


public interface ClienteDAO {

    void registro(String login, String senha, int tipoConta, boolean isGerente) throws ContaJaExisteException;

    void logIn(String login, String senha, int isGerente) throws DadosLoginErradoException;

    void attLogged(UserAbs user);

    void logOut();


    boolean buscarConta(String login);

    boolean buscarContaGerente(String login);
    
    void criarConta(String login, String senha, int tipoConta) throws ContaJaExisteException;

    void remover(String login) throws ContaInexistenteException;

    void bonifica(String login) throws ContaInexistenteException, ContaTipoErradoException;

    String getConta(String login) throws ContaInexistenteException;

    List getContas();

    
    void sacarConta(float quantia) throws SaldoInsuficienteException, ValorInvalidoException;

    void depositarConta(float quantia) throws ValorInvalidoException;
    
    Float getSaldo();

}
