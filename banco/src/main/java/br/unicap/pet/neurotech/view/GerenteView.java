package br.unicap.pet.neurotech.view;

import java.util.List;

import br.unicap.pet.neurotech.control.GerenteController;
import br.unicap.pet.neurotech.view.util.Leitor;

public class GerenteView {

    GerenteController acesso = new GerenteController();

    public void criarConta() {
        int numConta, tipoConta;

        System.out.println("numero da nova conta ");
        numConta = Leitor.getLeitor().nextInt();

        System.out.println("\nTipo de conta ");
        System.out.println("1 - Conta normal");
        System.out.println("2 - Conta bonificada");
        tipoConta = Leitor.getLeitor().nextInt();
        if (tipoConta > 0 && tipoConta < 3) {
            boolean criouConta = acesso.criarConta(numConta, tipoConta);
            if (criouConta) {
                System.out.println("conta criada com sucesso");
            } else {
                System.out.println("ja existe uma conta com esse numero");
            }
        } else {
            System.out.println("Tipo invalido");
        }

    }

    public void removerConta() {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();
        boolean removeuConta = acesso.removerConta(numConta);

        if (removeuConta) {
            System.out.println("conta removida com sucesso");
        } else {
            System.out.println("nao existe uma conta com esse numero");
        }

    }

    public void getContasList() {
        List contas = acesso.getContasList();

        if (!contas.isEmpty()) {
            for (int i = 0; i < contas.size(); i++) {
                System.out.println(contas.get(i));
            }
        } else {
            System.out.println("nenhuma conta registrada");
        }
    }

    public void getConta() {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();
        String conta = acesso.getConta(numConta);

        System.out.println(conta);
    }

    public void bonificaConta() {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();
        String message = acesso.bonificarConta(numConta);

        System.out.println(message);
    }

}
