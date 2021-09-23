package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.ClienteController;
import br.unicap.pet.neurotech.model.exceptions.ContaInexistenteException;
import br.unicap.pet.neurotech.model.exceptions.SaldoInsuficienteException;
import br.unicap.pet.neurotech.model.exceptions.ValorInvalidoException;
import br.unicap.pet.neurotech.view.util.Leitor;

public class ClienteView {

    ClienteController acesso = new ClienteController();

    public void sacar() {

        System.out.println("Informe a quantia a Sacar: ");
        float quantia = Leitor.getLeitor().nextFloat();

        try{
            acesso.sacar(quantia);
            System.out.println("Saque completo ");
        } catch (ValorInvalidoException e){
            System.out.println("Valor invalido");
        } catch (SaldoInsuficienteException e){
            System.out.println("Saldo insuficiente");
        }
        
    }

    public void depositar() {

        System.out.println("Informe a quantia a depositar: ");
        float quantia = Leitor.getLeitor().nextFloat();

        try {
            acesso.depositar(quantia);
            System.out.println("Deposito concluido");
        } catch (ValorInvalidoException e){
            System.out.println("Valor invalido");
        }

    }

    public void checarConta() {
        Float saldo = acesso.getSaldo();
        System.out.println("Saldo da conta: " + saldo);

    }
}
