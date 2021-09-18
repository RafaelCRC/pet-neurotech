package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;

public class MenuCliente {

    public void Menu() {
        ClienteView cv = new ClienteView();
        int op;
        do {
            System.out.println("\n<<MENU CLIENTE>>");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Voltar");
            op = Leitor.getLeitor().nextInt();
            System.out.println("");
            switch (op) {
                case 1:
                    cv.sacar();
                    break;
                case 2:
                    cv.depositar();
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
