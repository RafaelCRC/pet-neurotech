package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.LoginController;
import br.unicap.pet.neurotech.model.exceptions.ContaJaExisteException;
import br.unicap.pet.neurotech.model.exceptions.DadosLoginErradoException;
import br.unicap.pet.neurotech.view.util.Leitor;

public class LoginRegistroView {
    
    MenuCliente acessoCliente = new MenuCliente();
    MenuGerente acessoGerente = new MenuGerente();

    LoginController acesso = new LoginController();

    public void Logar(int op) {
        int login;
        String senha;

        System.out.println("numero de usuario ");
        login = Leitor.getLeitor().nextInt();
        System.out.println("senha ");
        senha = Leitor.getLeitor().next();

        try{
            acesso.logIn(login, senha, op);
            System.out.println("Login completo ");
            if (op == 1){
                acessoCliente.Menu();
            }else {
                acessoGerente.Menu();
            }
        } catch (DadosLoginErradoException e){
            System.out.println("Usuario ou senha errado ");
        }
    }

    public void Registrar(int op){
        int login, tipoConta = 1;
        String senha;
        boolean isGerente = true;

        System.out.println("numero de usuario ");
        login = Leitor.getLeitor().nextInt();
        System.out.println("senha ");
        senha = Leitor.getLeitor().next();

        if (op == 1){
            isGerente = false;
            System.out.println("\nTipo de conta ");
            System.out.println("1 - Conta normal");
            System.out.println("2 - Conta bonificada");
            tipoConta = Leitor.getLeitor().nextInt();
        }
        if (tipoConta > 0 && tipoConta < 3){
            try{
                acesso.registro(login, senha, tipoConta, isGerente);
                System.out.println("Conta registrada ");
            } catch (ContaJaExisteException e){
                System.out.println("Conta ja existe ");
            }
        } else {
            System.out.println("Tipo invalido");
        }
    }

    public void Deslogar(){
        System.out.println("Deslogando! ");
        acesso.logOut();
    }

}
