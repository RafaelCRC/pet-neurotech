package br.unicap.pet.neurotech.control;

import java.util.List;

import br.unicap.pet.neurotech.model.dao.ClienteDAOMemoria;
import br.unicap.pet.neurotech.model.exceptions.*;
import br.unicap.pet.neurotech.model.dao.ClienteDAO;


public class GerenteController {

    private ClienteDAO dao = ClienteDAOMemoria.getInstance();

    public void criarConta(int idConta, String senha, int tipoConta) throws ContaJaExisteException {
        dao.criarConta(idConta, senha, tipoConta);
    }

    public void remover(int idConta) throws ContaInexistenteException {
        dao.remover(idConta);
    }

    public String getConta(int idConta) throws ContaInexistenteException {
        return dao.getConta(idConta);
    }

    public List getContas() {
        return dao.getContas();
    }

    public void bonifica(int idConta) throws ContaInexistenteException, ContaTipoErradoException {
        dao.bonifica(idConta);
    }

}
