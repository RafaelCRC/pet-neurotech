package br.unicap.pet.neurotech.model.dao;

import java.util.List;

public class GerenteDAOMemoria implements GerenteDAO {

    private ClienteDAO clientesMe;
    private static GerenteDAOMemoria self;

    public GerenteDAOMemoria() {
        clientesMe = ClienteDAOMemoria.getInstance();
    }

    public static GerenteDAO getInstance() {
        if (self == null) {
            self = new GerenteDAOMemoria();
        }
        return self;
    }

    @Override
    public boolean criarConta(int idConta, int tipoConta) {
        Conta novaConta;
        if (tipoConta == 1) {
            novaConta = new Conta(idConta);
        } else {
            novaConta = new ContaBoni(idConta);
        }

        return clientesMe.add(novaConta);
    }

    @Override
    public boolean removerConta(int idConta) {
        return clientesMe.remover(idConta);
    }

    @Override
    public String getConta(int idConta) {
        return clientesMe.getConta(idConta);
    }

    @Override
    public List getContasList() {
        return clientesMe.getContas();
    }

    @Override
    public String bonificarConta(int idConta) {
        if (clientesMe.buscarConta(idConta)) {
            if (clientesMe.bonifica(idConta)) {
                return "conta bonificada";
            } else {
                return "conta não é do tipo bonificada";
            }
        }
        return "conta não existe";
    }

}
