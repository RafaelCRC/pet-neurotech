package br.unicap.pet.neurotech.model.dao;

public class ContaGerente extends Conta {

    public ContaGerente(int num, String senha) {
        super(num, senha);
        this.tipo = "gerente";
        //TODO Auto-generated constructor stub
    }
    
}
