package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.ClienteController;
import br.unicap.pet.neurotech.model.exceptions.ContaInexistenteException;
import br.unicap.pet.neurotech.model.exceptions.SaldoInsuficienteException;
import br.unicap.pet.neurotech.model.exceptions.ValorInvalidoException;
import br.unicap.pet.neurotech.view.util.Leitor;

public class ClienteView {

    ClienteController acesso = new ClienteController();

    public void sacar() {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();
        boolean haConta = acesso.buscar(numConta);

        if (haConta) {
            System.out.println("Informe a quantia a Sacar: ");
            float quantia = Leitor.getLeitor().nextFloat();

            try{
                acesso.sacar(numConta, quantia);
                System.out.println("Saque concluido");
            } catch (ValorInvalidoException e){
                System.out.println("Valor invalido");
            } catch (SaldoInsuficienteException e){
                System.out.println("Saldo insuficiente");
            }
            
        } else {
            System.out.println("Conta Inexistente");
        }
    }

    public void depositar() {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();
        boolean haConta = acesso.buscar(numConta);

        if (haConta) {
            System.out.println("Informe a quantia a depositar: ");
            float quantia = Leitor.getLeitor().nextFloat();

            try {
                acesso.depositar(numConta, quantia);
                System.out.println("Deposito concluido");
            } catch (ValorInvalidoException e){
                System.out.println("Valor invalido");
            }
            
        } else {
            System.out.println("Conta Inexistente");
        }
    }

    public void checarConta() {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();

        try {
            String conta = acesso.getConta(numConta);
            System.out.println(conta);
        } catch (ContaInexistenteException e){
            System.out.println("Conta Inexistente");
        }
    }
}
