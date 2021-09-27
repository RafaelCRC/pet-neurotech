package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ClienteDAO;
import br.unicap.pet.neurotech.model.dao.ClienteDAOMemoria;
import br.unicap.pet.neurotech.model.exceptions.*;
import br.unicap.pet.neurotech.model.dao.ContaDAO_DB;

public class LoginController {
    
    private ClienteDAO dao = ClienteDAOMemoria.getInstance();
    private ClienteDAO daodb = ContaDAO_DB.getInstance();

    public void registro(String login, String senha, int tipoConta, boolean isGerente) throws ContaJaExisteException {
        daodb.registro(login, senha, tipoConta, isGerente);
    }

    public void logIn(String login, String senha, int isGerente) throws DadosLoginErradoException {
        daodb.logIn(login, senha, isGerente);
    }

    public void logOut(){
        daodb.logOut();
    }

}
