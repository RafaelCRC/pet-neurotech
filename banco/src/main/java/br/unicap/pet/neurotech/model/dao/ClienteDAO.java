package br.unicap.pet.neurotech.model.dao;

import java.util.List;

import br.unicap.pet.neurotech.model.exceptions.ContaInexistenteException;
import br.unicap.pet.neurotech.model.exceptions.ContaJaExisteException;
import br.unicap.pet.neurotech.model.exceptions.ContaTipoErradoException;
import br.unicap.pet.neurotech.model.exceptions.SaldoInsuficienteException;
import br.unicap.pet.neurotech.model.exceptions.ValorInvalidoException;

public interface ClienteDAO {

    boolean buscarConta(int numConta);

    void sacarConta(int numConta, float quantia) throws SaldoInsuficienteException, ValorInvalidoException;

    void depositarConta(int numConta, float quantia) throws ValorInvalidoException;

    void criarConta(int idConta, int tipoConta) throws ContaJaExisteException;

    void remover(int idConta) throws ContaInexistenteException;

    String getConta(int idConta) throws ContaInexistenteException;

    List getContas();

    void bonifica(int idConta) throws ContaInexistenteException, ContaTipoErradoException;


}
