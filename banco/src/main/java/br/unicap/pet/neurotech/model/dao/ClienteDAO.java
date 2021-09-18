package br.unicap.pet.neurotech.model.dao;

import java.util.List;

public interface ClienteDAO {

    boolean buscarConta(int numConta);

    void sacarConta(int numConta, float quantia);

    void depositarConta(int numConta, float quantia);

    boolean add(Conta conta);

    boolean remover(int idConta);

    Conta getConta(int idConta);

    List getContas();
}
