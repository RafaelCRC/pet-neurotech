package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ClienteDAO;
import br.unicap.pet.neurotech.model.dao.ContaDAO_DB;
import br.unicap.pet.neurotech.model.dao.ClienteDAOMemoria;
import br.unicap.pet.neurotech.model.exceptions.*;

public class ClienteController {

    private ClienteDAO dao = ClienteDAOMemoria.getInstance();
    private ClienteDAO daodb = ContaDAO_DB.getInstance();

    public boolean buscar(String login) {
        return dao.buscarConta(login);
    }

    public void sacar(float quantia) throws SaldoInsuficienteException, ValorInvalidoException {
        dao.sacarConta(quantia);
    }

    public void depositar(float quantia) throws ValorInvalidoException {
        daodb.depositarConta(quantia);
    }

    public Float getSaldo() {
        return daodb.getSaldo();
    }

}
