package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ClienteDAO;
import br.unicap.pet.neurotech.model.dao.ClienteDAOMemoria;
import br.unicap.pet.neurotech.model.exceptions.*;
import br.unicap.pet.neurotech.model.dao.Conta;
import br.unicap.pet.neurotech.model.dao.UserAbs;

public class LoginController {
    
    private ClienteDAO dao = ClienteDAOMemoria.getInstance();

    public void registro(String login, String senha, int tipoConta, boolean isGerente) throws ContaJaExisteException {
        dao.registro(login, senha, tipoConta, isGerente);
    }

    public void logIn(String login, String senha, int isGerente) throws DadosLoginErradoException {
        dao.logIn(login, senha, isGerente);
    }

    public void attLogged(UserAbs user){
        dao.attLogged(user);
    }

    public void logOut(){
        dao.logOut();
    }

}
