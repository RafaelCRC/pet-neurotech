package br.unicap.pet.neurotech.model.dao;

import br.unicap.pet.neurotech.model.exceptions.SaldoInsuficienteException;

public class Conta {

    protected int numConta;
    protected float saldo;
    protected String tipo;

    protected String login;
    protected String senha;

    public Conta(int num, String senha) {
        this.saldo = 0;
        this.numConta = num;
        this.senha = senha;
        this.tipo = "normal";
        
    }

    public int getNumero() {
        return this.numConta;
    }

    public void sacar(float quantia) throws SaldoInsuficienteException {
        if (this.saldo >= quantia) {
            this.saldo = this.saldo - quantia;
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    public void depositar(float quantia) {
        this.saldo = this.saldo + quantia;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getLogin() {
        String ret = "" + this.numConta;
        return ret;
    }

    public String getSenha() {
        return this.senha;
    }
}
