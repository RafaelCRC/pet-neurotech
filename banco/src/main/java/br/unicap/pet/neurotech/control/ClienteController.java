package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ClienteDAO;
import br.unicap.pet.neurotech.model.dao.ClienteDAODatabase;
import br.unicap.pet.neurotech.model.exceptions.*;

public class ClienteController {

    private ClienteDAO dao = ClienteDAODatabase.getInstance();

    public void sacar(float quantia) throws SaldoInsuficienteException, ValorInvalidoException {
        dao.sacarConta(quantia);
    }

    public void depositar(float quantia) throws ValorInvalidoException {
        dao.depositarConta(quantia);
    }

    public Float getSaldo() {
        return dao.getSaldo();
    }

}
