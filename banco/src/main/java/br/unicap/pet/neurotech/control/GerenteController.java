package br.unicap.pet.neurotech.control;

import java.util.List;

import br.unicap.pet.neurotech.model.dao.GerenteDAO;
import br.unicap.pet.neurotech.model.dao.GerenteDAOMemoria;

public class GerenteController {

    private GerenteDAO dao = GerenteDAOMemoria.getInstance();

    public boolean criarConta(int idConta, int tipoConta) {
        return dao.criarConta(idConta, tipoConta);
    }

    public boolean removerConta(int idConta) {
        return dao.removerConta(idConta);
    }

    public String getConta(int idConta) {
        return dao.getConta(idConta);
    }

    public List getContasList() {
        return dao.getContasList();
    }

    public String bonificarConta(int idConta) {
        return dao.bonificarConta(idConta);
    }

}
