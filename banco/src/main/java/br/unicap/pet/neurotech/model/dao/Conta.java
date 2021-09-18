package br.unicap.pet.neurotech.model.dao;

public class Conta {

    private int numConta;
    private float saldo;

    public Conta(int num) {
        saldo = 0;
        numConta = num;
    }

    public int getNumero() {
        return numConta;
    }

    public void sacar(float quantia) {
        if (saldo > quantia) {
            saldo = -quantia;
        }
    }

    public void depositar(float quantia) {
        saldo = +quantia;
    }

    
    public float getSaldo(){
        return this.saldo;
    }

}
