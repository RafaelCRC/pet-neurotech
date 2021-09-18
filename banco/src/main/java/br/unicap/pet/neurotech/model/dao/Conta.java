package br.unicap.pet.neurotech.model.dao;

public class Conta {

    protected int numConta;
    protected float saldo;
    protected String tipo;

    public Conta(int num) {
        saldo = 0;
        numConta = num;
        setTipo("normal");
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

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float valor) {
        this.saldo = valor;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tiponovo) {
        this.tipo = tiponovo;
    }

}
