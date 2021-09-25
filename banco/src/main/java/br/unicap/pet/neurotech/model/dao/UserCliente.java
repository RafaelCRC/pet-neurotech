package br.unicap.pet.neurotech.model.dao;

public class UserCliente extends UserAbs {

    private Conta conta;

    public UserCliente(String login, String senha, Conta conta) {
        super(login, senha);
        this.conta = conta;
    }

    public Conta getConta() {
        return this.conta;
    }

}
