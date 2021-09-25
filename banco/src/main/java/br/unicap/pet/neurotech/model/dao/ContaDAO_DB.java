package br.unicap.pet.neurotech.model.dao;

import java.util.List;

import br.unicap.pet.neurotech.model.exceptions.ContaInexistenteException;
import br.unicap.pet.neurotech.model.exceptions.ContaJaExisteException;
import br.unicap.pet.neurotech.model.exceptions.ContaTipoErradoException;
import br.unicap.pet.neurotech.model.exceptions.DadosLoginErradoException;
import br.unicap.pet.neurotech.model.exceptions.SaldoInsuficienteException;
import br.unicap.pet.neurotech.model.exceptions.ValorInvalidoException;

public class ContaDAO_DB implements ClienteDAO{

    @Override
    public void registro(String login, String senha, int tipoConta, boolean isGerente) throws ContaJaExisteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void logIn(String login, String senha, int isGerente) throws DadosLoginErradoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void attLogged(UserAbs user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void logOut() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean buscarConta(String login) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean buscarContaGerente(String login) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void criarConta(String login, String senha, int tipoConta) throws ContaJaExisteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void remover(String login) throws ContaInexistenteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void bonifica(String login) throws ContaInexistenteException, ContaTipoErradoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getConta(String login) throws ContaInexistenteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List getContas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void sacarConta(float quantia) throws SaldoInsuficienteException, ValorInvalidoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void depositarConta(float quantia) throws ValorInvalidoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Float getSaldo() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
