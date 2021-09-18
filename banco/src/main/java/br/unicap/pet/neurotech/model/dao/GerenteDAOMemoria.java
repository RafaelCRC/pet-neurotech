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

    public boolean criarConta(int idConta) {
        Conta novaConta = new Conta(idConta);
        return clientesMe.add(novaConta);
    }

    public boolean removerConta(int idConta) {
        return clientesMe.remover(idConta);
    }

    public Object getConta(int idConta) {
        return clientesMe.getConta(idConta);
    }

    public List getContasList() {
        return clientesMe.getContas();
    }

}
