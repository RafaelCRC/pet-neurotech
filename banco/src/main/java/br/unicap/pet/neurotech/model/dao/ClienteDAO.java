package br.unicap.pet.neurotech.model.dao;

import java.util.List;

import br.unicap.pet.neurotech.model.exceptions.*;


public interface ClienteDAO {

    void registro(int idConta, String senha, int tipoConta, boolean isGerente) throws ContaJaExisteException;

    void logIn(int idConta, String senha, int tipoConta) throws DadosLoginErradoException;

    void attLogged(Conta conta);

    void logOut();


    boolean buscarConta(int numConta);

    boolean buscarContaGerente(int numConta);
    
    void criarConta(int idConta, String senha, int tipoConta) throws ContaJaExisteException;

    void remover(int idConta) throws ContaInexistenteException;

    void bonifica(int idConta) throws ContaInexistenteException, ContaTipoErradoException;

    String getConta(int idConta) throws ContaInexistenteException;

    List getContas();

    
    void sacarConta(float quantia) throws SaldoInsuficienteException, ValorInvalidoException;

    void depositarConta(float quantia) throws ValorInvalidoException;
    
    Float getSaldo();

}
