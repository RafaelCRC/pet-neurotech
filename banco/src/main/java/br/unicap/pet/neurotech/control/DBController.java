package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ClienteDAO;
import br.unicap.pet.neurotech.model.dao.ClienteDAODatabase;

public class DBController {

    private ClienteDAO dao = ClienteDAODatabase.getInstance();
    
    public void connect(){
        dao.connect();
    }

    public void dis(){
        dao.dis();
    }
    
}
