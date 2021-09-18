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

    @Override
    public String getConta(int idConta) {
        String conta;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getNumero() == idConta) {
                conta = ("Conta: " + this.clientes.get(i).getNumero() + "; Saldo: " + this.clientes.get(i).getSaldo()
                        + "; Tipo: " + this.clientes.get(i).getTipo());
                return conta;
            }
        }
        return "não existe uma conta com esse numero";
    }

    @Override
    public List getContas() {
        List<String> contas = new ArrayList<String>();
        for (int i = 0; i < this.clientes.size(); i++) {
            contas.add("Conta: " + this.clientes.get(i).getNumero() + "; Saldo: " + this.clientes.get(i).getSaldo()
                    + "; Tipo: " + this.clientes.get(i).getTipo());
        }
        return contas;
    }

    @Override
    public boolean bonifica(int idConta) {
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getTipo() == "bonificada" && this.clientes.get(i).getNumero() == idConta) {
                ContaBoni conta = (ContaBoni) this.clientes.get(i);
                conta.doBonifica();
                return true;
            }
        }
        return false;
    }

}
