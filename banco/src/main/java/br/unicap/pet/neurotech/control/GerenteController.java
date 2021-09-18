package br.unicap.pet.neurotech.control;

import java.util.List;

import br.unicap.pet.neurotech.model.dao.GerenteDAO;
import br.unicap.pet.neurotech.model.dao.GerenteDAOMemoria;

public class GerenteController {

    private GerenteDAO dao = GerenteDAOMemoria.getInstance();

    public boolean criarConta(int idConta){
        return dao.criarConta(idConta);
    }

    public boolean removerConta(int idConta){
        return dao.removerConta(idConta);
    }

    public Object getConta(int idConta){
        return dao.getConta(idConta);
    }

    public List getContasList(){
        return dao.getContasList();
    }
    
}
