package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.ClienteController;
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
            acesso.sacar(numConta, quantia);
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
            acesso.depositar(numConta, quantia);
        } else {
            System.out.println("Conta Inexistente");
        }
    }

    public void checarConta() {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();
        String conta = acesso.getConta(numConta);

        System.out.println(conta);
    }
}
