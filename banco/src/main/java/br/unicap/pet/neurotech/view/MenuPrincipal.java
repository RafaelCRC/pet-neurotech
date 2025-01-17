package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.DBController;
import br.unicap.pet.neurotech.view.util.Leitor;

public class MenuPrincipal {

    public static void main(String[] args) {
        int op;
        DBController DBacesso = new DBController();
        MenuLogin acessoLogin = new MenuLogin();
        MenuRegistro acessoRegistro = new MenuRegistro();
        do {

            System.out.println("<<MENU PRINCIPAL>>");

            System.out.println("1 - Login");
            System.out.println("2 - Registre-se");
            System.out.println("3 - Sair");

            op = Leitor.getLeitor().nextInt();
            switch (op) {

                case 1:
                    DBacesso.connect();
                    acessoLogin.Menu();
                    break;
                case 2:
                    DBacesso.connect();
                    acessoRegistro.Menu();
                    break;
            }
        } while (op != 3);
        DBacesso.dis();
    }

}
