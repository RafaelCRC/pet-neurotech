package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ClienteDAO;
import br.unicap.pet.neurotech.model.dao.ClienteDAOMemoria;

public class ClienteController {

    private ClienteDAO dao = ClienteDAOMemoria.getInstance();

    public boolean buscar(int numConta) {
        return dao.buscarConta(numConta);
    }

    public void sacar(int numConta, float quantia) {
        dao.sacarConta(numConta, quantia);
    }

    public void depositar(int numConta, float quantia) {
        dao.depositarConta(numConta, quantia);
    }
}
