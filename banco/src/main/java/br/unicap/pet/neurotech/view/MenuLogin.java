package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;

public class MenuLogin {

    public void Menu(){
        LoginRegistroView lv = new LoginRegistroView();
        int op;
        do {
            System.out.println("\n<<MENU LOGIN>>");
            System.out.println("1 - Login como Cliente");
            System.out.println("2 - Login como Gerente");
            System.out.println("3 - Voltar");
            op = Leitor.getLeitor().nextInt();
            System.out.println("");
            switch (op) {
                case 1:
                    lv.Logar(op);
                    op = 3;
                    break;
                case 2:
                    lv.Logar(op);
                    op = 3;
                    break;
                case 3:
                    System.out.println("Voltando!!");
                    break;
                default:
                    System.out.println("Opcao invalida!!");
            }
        } while (op != 3);
    }
}
