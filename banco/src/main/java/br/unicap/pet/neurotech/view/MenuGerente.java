package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;

public class MenuGerente {

    public void Menu() {
        GerenteView gv = new GerenteView();
        int op;
        do {
            System.out.println("\n<<MENU GERENTE>>");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Apagar Conta");
            System.out.println("3 - Buscar Conta");
            System.out.println("4 - Listar Contas");
            System.out.println("5 - Voltar");
            op = Leitor.getLeitor().nextInt();
            System.out.println("");
            switch (op) {
                case 1:
                    gv.criarConta();
                    break;
                case 2:
                    gv.removerConta();
                    break;
                case 3:
                    gv.getConta();
                    break;
                case 4:
                    gv.getContasList();
                    break;
                case 5:
                    System.out.println("Voltando!!");
                    break;
                default:
                    System.out.println("Opcao invalida!!");
            }
        } while (op != 5);

    }

}
