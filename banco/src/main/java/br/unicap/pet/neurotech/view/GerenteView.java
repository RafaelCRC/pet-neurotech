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
        //int numConta;
        int tipoConta;
        String senha;
        String login;

        //System.out.println("numero da nova conta ");
        //numConta = Leitor.getLeitor().nextInt();

        System.out.println("nome de usuario");
        login = Leitor.getLeitor().next();

        System.out.println("senha da nova conta ");
        senha = Leitor.getLeitor().next();

        System.out.println("\nTipo de conta ");
        System.out.println("1 - Conta normal");
        System.out.println("2 - Conta bonificada");
        tipoConta = Leitor.getLeitor().nextInt();
        if (tipoConta > 0 && tipoConta < 3) {
            try {
                //acesso.criarConta(numConta, senha, tipoConta);
                acesso.criarConta(login, senha, tipoConta);
                System.out.println("conta criada com sucesso");
            } catch (ContaJaExisteException e){
                System.out.println("Conta ja existe");
            }
        } else {
            System.out.println("Tipo invalido");
        }

    }

    public void removerConta() {
        //int numConta;
        String login;

        //System.out.println("numero da conta ");
        //numConta = Leitor.getLeitor().nextInt();

        System.out.println("nome de usuario");
        login = Leitor.getLeitor().next();

        try {
            //acesso.remover(numConta);
            acesso.remover(login);
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
        //int numConta;
        String login;

        //System.out.println("numero da conta ");
        //numConta = Leitor.getLeitor().nextInt();

        System.out.println("nome de usuario");
        login = Leitor.getLeitor().next();

        try {
            //String conta = acesso.getConta(numConta);
            String conta = acesso.getConta(login);
            System.out.println(conta);
        } catch (ContaInexistenteException e){
            System.out.println("Conta Inexistente");
        }
    }

    public void bonificaConta() {
        //int numConta;
        String login;

        //System.out.println("numero da conta ");
        //numConta = Leitor.getLeitor().nextInt();

        System.out.println("nome de usuario");
        login = Leitor.getLeitor().next();

        try {
            //acesso.bonifica(numConta);
            acesso.bonifica(login);
            System.out.println("Conta bonificada ");
        } catch (ContaInexistenteException e){
            System.out.println("Conta Inexistente");
        } catch (ContaTipoErradoException e){
            System.out.println("Conta nao e bonificada ");
        }
    }

}
