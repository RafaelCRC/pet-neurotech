package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;

public class MenuRegistro {

    public void Menu(){
        LoginRegistroView rv = new LoginRegistroView();
        int op;
        do {
            System.out.println("\n<<MENU REGISTRO>>");
            System.out.println("1 - Registro como Cliente");
            System.out.println("2 - Registro como Gerente");
            System.out.println("3 - Voltar");
            op = Leitor.getLeitor().nextInt();
            System.out.println("");
            switch (op) {
                case 1:
                    rv.Registrar(op);
                    op = 3;
                    break;
                case 2:
                    rv.Registrar(op);
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
