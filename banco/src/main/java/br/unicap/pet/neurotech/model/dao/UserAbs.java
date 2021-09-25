package br.unicap.pet.neurotech.model.dao;

public abstract class UserAbs {

    private String login;
    private String senha;

    public UserAbs(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return this.login;
    }

    public String getSenha() {
        return this.senha;
    }

}
