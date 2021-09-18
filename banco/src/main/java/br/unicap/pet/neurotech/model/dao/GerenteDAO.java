package br.unicap.pet.neurotech.model.dao;

import java.util.List;

public interface GerenteDAO {

    boolean criarConta(int idConta, int tipoConta);

    boolean removerConta(int idConta);

    String getConta(int idConta);

    List getContasList();

    String bonificarConta(int idConta);

}
