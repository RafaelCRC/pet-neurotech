package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ClienteDAO;
import br.unicap.pet.neurotech.model.dao.ClienteDAOMemoria;
import br.unicap.pet.neurotech.model.exceptions.ContaInexistenteException;
import br.unicap.pet.neurotech.model.exceptions.SaldoInsuficienteException;
import br.unicap.pet.neurotech.model.exceptions.ValorInvalidoException;

public class ClienteController {

    private ClienteDAO dao = ClienteDAOMemoria.getInstance();

    public boolean buscar(int numConta) {
        return dao.buscarConta(numConta);
    }

    public void sacar(int numConta, float quantia) throws SaldoInsuficienteException, ValorInvalidoException {
        dao.sacarConta(numConta, quantia);
    }

    public void depositar(int numConta, float quantia) throws ValorInvalidoException {
        dao.depositarConta(numConta, quantia);
    }

    public String getConta(int numConta) throws ContaInexistenteException {
        return dao.getConta(numConta);
    }

}
