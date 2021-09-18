package br.unicap.pet.neurotech.model.dao;

import java.util.List;

public interface GerenteDAO {
    
    boolean criarConta(int idConta);

    boolean removerConta(int idConta);

    Object getConta(int idConta);

    List getContasList();

}
