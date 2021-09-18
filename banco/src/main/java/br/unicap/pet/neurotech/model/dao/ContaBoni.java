package br.unicap.pet.neurotech.model.dao;

public class ContaBoni extends Conta {

    private float bonus;

    public ContaBoni(int num) {
        super(num);
        setTipo("bonificada");
    }

    @Override
    public void depositar(float quantia) {
        this.saldo = +quantia;
        bonus = +(float) (quantia * 0.01);
    }

    public void doBonifica() {
        saldo = saldo + bonus;
    }

}
