package br.unicap.pet.neurotech.view;

import java.util.List;

import br.unicap.pet.neurotech.control.GerenteController;
import br.unicap.pet.neurotech.model.exceptions.ContaInexistenteException;
import br.unicap.pet.neurotech.model.exceptions.ContaJaExisteException;
import br.unicap.pet.neurotech.model.exceptions.ContaTipoErradoException;
import br.unicap.pet.neurotech.view.util.Leitor;

public class GerenteView {

    GerenteController acesso = new GerenteController();

    //GerenteController acessotemp = new ClienteController();

    public void criarConta() {
        int numConta, tipoConta;

        System.out.println("numero da nova conta ");
        numConta = Leitor.getLeitor().nextInt();

        System.out.println("\nTipo de conta ");
        System.out.println("1 - Conta normal");
        System.out.println("2 - Conta bonificada");
        tipoConta = Leitor.getLeitor().nextInt();
        if (tipoConta > 0 && tipoConta < 3) {
            try {
                acesso.criarConta(numConta, tipoConta);
                System.out.println("conta criada com sucesso");
            } catch (ContaJaExisteException e){
                System.out.println("Conta ja existe");
            }
        } else {
            System.out.println("Tipo invalido");
        }

    }

    public void removerConta() {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();

        try {
            acesso.remover(numConta);
            System.out.println("conta removida com sucesso");
        }catch (ContaInexistenteException e){
            System.out.println("Conta Inexistente");
        }
    }

    public void getContasList() {
        List contas = acesso.getContas();

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

        try {
            String conta = acesso.getConta(numConta);
            System.out.println(conta);
        } catch (ContaInexistenteException e){
            System.out.println("Conta Inexistente");
        }
    }

    public void bonificaConta() {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();

        try {
            acesso.bonifica(numConta);
            System.out.println("Conta bonificada ");
        } catch (ContaInexistenteException e){
            System.out.println("Conta Inexistente");
        } catch (ContaTipoErradoException e){
            System.out.println("Conta nao e bonificada ");
        }
    }

}
