package br.unicap.pet.neurotech.control;

import java.util.List;

import br.unicap.pet.neurotech.model.dao.ClienteDAOMemoria;
import br.unicap.pet.neurotech.model.exceptions.*;
import br.unicap.pet.neurotech.model.dao.ClienteDAO;


public class GerenteController {

    private ClienteDAO dao = ClienteDAOMemoria.getInstance();

    public void criarConta(String login, String senha, int tipoConta) throws ContaJaExisteException {
        dao.criarConta(login, senha, tipoConta);
    }

    public void remover(String login) throws ContaInexistenteException {
        dao.remover(login);
    }

    public String getConta(String login) throws ContaInexistenteException {
        return dao.getConta(login);
    }

    public List getContas() {
        return dao.getContas();
    }

    public void bonifica(String login) throws ContaInexistenteException, ContaTipoErradoException {
        dao.bonifica(login);
    }

}
