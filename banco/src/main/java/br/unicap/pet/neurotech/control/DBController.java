package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ClienteDAO;
import br.unicap.pet.neurotech.model.dao.ContaDAO_DB;

public class DBController {

    private ClienteDAO dao = ContaDAO_DB.getInstance();
    
    public void connect(){
        dao.connect();
    }

    public void dis(){
        dao.dis();
    }
    
}
