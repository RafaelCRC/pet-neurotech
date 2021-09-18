package br.unicap.pet.neurotech.model.dao;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAOMemoria implements ClienteDAO {

    private List<Conta> clientes;
    private static ClienteDAOMemoria self;

    public ClienteDAOMemoria() {
        clientes = new ArrayList<Conta>();
    }

    @Override
    public boolean buscarConta(int numConta) {
        boolean encontrado = false;
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public static ClienteDAO getInstance() {
        if (self == null) {
            self = new ClienteDAOMemoria();
        }
        return self;
    }

    @Override
    public void sacarConta(int numConta, float quantia) {
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                conta.sacar(quantia);
            }
        }
    }

    @Override
    public void depositarConta(int numConta, float quantia) {
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                conta.depositar(quantia);
            }
        }
    }

    @Override
    public boolean add(Conta conta) {
        if (buscarConta(conta.getNumero())) {
            return false;
        } else {
            this.clientes.add(conta);
            return true;
        }

    }

    @Override
    public boolean remover(int idConta) {
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getNumero() == idConta) {
                this.clientes.remove(this.clientes.get(i));
                return true;
            }
        }
        return false;
    }

    public Conta getConta(int idConta) {
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getNumero() == idConta) {
                return this.clientes.get(i);
            }
        }
        return null;
    }

    @Override
    public List getContas() {
        return this.clientes;
    }

}
