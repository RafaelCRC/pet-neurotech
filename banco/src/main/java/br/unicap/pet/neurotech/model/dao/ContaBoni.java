package br.unicap.pet.neurotech.model.dao;

public class ContaBoni extends Conta {

    private float bonus;

    public ContaBoni(int num) {
        super(num);
        this.tipo = "bonificada";
    }

    @Override
    public void depositar(float quantia) {
        this.saldo = this.saldo + quantia;
        this.bonus = (float) (this.bonus + (quantia * 0.01));
    }

    public void doBonifica() {
        this.saldo = this.saldo + this.bonus;
    }

}
