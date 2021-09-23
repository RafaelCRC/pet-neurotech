package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ClienteDAO;
import br.unicap.pet.neurotech.model.dao.ClienteDAOMemoria;
import br.unicap.pet.neurotech.model.exceptions.*;
import br.unicap.pet.neurotech.model.dao.Conta;

public class LoginController {
    
    private ClienteDAO dao = ClienteDAOMemoria.getInstance();

    public void registro(int idConta, String senha, int tipoConta, boolean isGerente) throws ContaJaExisteException {
        dao.registro(idConta, senha, tipoConta, isGerente);
    }

    public void logIn(int idConta, String senha, int tipoConta) throws DadosLoginErradoException {
        dao.logIn(idConta, senha, tipoConta);
    }

    public void attLogged(Conta conta){
        dao.attLogged(conta);
    }

    public void logOut(){
        dao.logOut();
    }

}
