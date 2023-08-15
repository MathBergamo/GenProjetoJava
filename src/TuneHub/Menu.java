package TuneHub;

import TuneHub.Controller.GuitarraController;
import TuneHub.Model.Guitarra;
import TuneHub.util.Cores;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GuitarraController guitarraController = new GuitarraController();

        Guitarra gregBennettTorino = new Guitarra(guitarraController.gerarId(), "Greg Bennett Torino", 2014, 1200f);
        guitarraController.create(gregBennettTorino);

        Guitarra tagimaTw = new Guitarra(guitarraController.gerarId(), "Tagima TG-510", 2011, 800f);
        guitarraController.create(tagimaTw);

        Guitarra gibsonSg = new Guitarra(guitarraController.gerarId(), "Gibson SG Faded", 2015, 4000f);
        guitarraController.create(gibsonSg);

        int escolha = -1, id;

        while (escolha != 0) {
            System.out.println(Cores.TEXT_BLUE + Cores.ANSI_BLACK_BACKGROUND
                    + "*******************************************************************");
            System.out.println("                                                     ");
            System.out.println("" +
                    "" +
                    "                         ,-.        _.---._\n" +
                    "                        |  `\\.__.-''       `.\n" +
                    "                         \\  _        _  ,.   \\\n" +
                    "   ,+++=._________________)_||______|_|_||    |\n" +
                    "  (_.ooo.===================||======|=|=||    |\n" +
                    "     ~~'                 |  ~'      `~' o o  /\n" +
                    "                          \\   /~`\\     o o  /\n" +
                    "                           `~'    `-.____.-'\n" +
                    "\n" +
                    "*******************************************************************\n");
            System.out.println(" ________                           __    __          __       \n" +
                    "|        \\                         |  \\  |  \\        |  \\      \n" +
                    " \\$$$$$$$__    __ _______   ______ | $$  | $$__    __| $$____  \n" +
                    "   | $$ |  \\  |  |       \\ /      \\| $$__| $|  \\  |  | $$    \\ \n" +
                    "   | $$ | $$  | $| $$$$$$$|  $$$$$$| $$    $| $$  | $| $$$$$$$\\\n" +
                    "   | $$ | $$  | $| $$  | $| $$    $| $$$$$$$| $$  | $| $$  | $$\n" +
                    "   | $$ | $$__/ $| $$  | $| $$$$$$$| $$  | $| $$__/ $| $$__/ $$\n" +
                    "   | $$  \\$$    $| $$  | $$\\$$     | $$  | $$\\$$    $| $$    $$\n" +
                    "    \\$$   \\$$$$$$ \\$$   \\$$ \\$$$$$$$\\$$   \\$$ \\$$$$$$ \\$$$$$$$ ");
            System.out.println("*******************************************************************");
            System.out.println("                   LOJA DE GUITARRA                  ");
            System.out.println("*******************************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Registrar Guitarra                   ");
            System.out.println("            2 - Listar Guitarras                     ");
            System.out.println("            3 - Buscar Guitarra por Identificador    ");
            System.out.println("            4 - Atualizar Dados da Guitarra          ");
            System.out.println("            5 - Apagar Dados da Guitarra             ");
            System.out.println("            0 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*******************************************************************");
            System.out.println("Entre com a opção desejada:                          " + Cores.TEXT_RESET);
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    Guitarra novaGuitarra = new Guitarra();
                    System.out.println("*******************************************************************");
                    System.out.println("REGISTRAR GUITARRA");
                    System.out.println("*******************************************************************");
                    System.out.println("Digite as informações da Guitarra");

                    novaGuitarra.setId(guitarraController.gerarId());
                    scanner.nextLine();

                    System.out.println("Nome: ");
                    novaGuitarra.setNome(scanner.nextLine());

                    System.out.println("Ano: ");
                    novaGuitarra.setAno(scanner.nextInt());

                    System.out.println("Preço: ");
                    novaGuitarra.setPreco(scanner.nextFloat());

                    guitarraController.create(novaGuitarra);

                    keyPress();
                    break;

                case 2:
                    System.out.println("*******************************************************************");
                    System.out.println("LISTA DE GUITARRAS DISPONÍVEIS");
                    System.out.println("*******************************************************************");
                    guitarraController.listGuitarra();

                    keyPress();
                    break;

                case 3:
                    System.out.println("*******************************************************************");
                    System.out.println("BUSCAR GUITARRA");
                    System.out.println("*******************************************************************");
                    System.out.println("Digite o Número Identificador da guitarra: ");
                    id = scanner.nextInt();

                    guitarraController.findById(id);

                    keyPress();
                    break;

                case 4:
                    Guitarra atualizarGuitarra = new Guitarra();

                    System.out.println("*******************************************************************");
                    System.out.println("ATUALIZAR DADOS DA GUITARRA");
                    System.out.println("*******************************************************************");
                    System.out.println("Digite as novas informações da Guitarra\n");
                    System.out.println("Número Identificador:");

                    atualizarGuitarra.setId(scanner.nextInt());
                    scanner.nextLine();

                    if (guitarraController.findInCollection(atualizarGuitarra.getId()) != null){
                        System.out.println("Nome: ");
                        atualizarGuitarra.setNome(scanner.nextLine());

                        System.out.println("Ano: ");
                        atualizarGuitarra.setAno(scanner.nextInt());

                        System.out.println("Preço: ");
                        atualizarGuitarra.setPreco(scanner.nextFloat());

                        guitarraController.update(atualizarGuitarra);
                        keyPress();
                        break;
                    } else {
                        System.out.println("Guitarra não encontrada!");
                        break;
                    }

                case 5:
                    System.out.println("*******************************************************************");
                    System.out.println("DELETAR DADOS DA GUITARRA");
                    System.out.println("*******************************************************************");
                    System.out.println("Digite o Número Identificador da Guitarra: ");
                    id = scanner.nextInt();

                    guitarraController.delete(id);
                    keyPress();
                    break;
            }
        }
    }
    public static void keyPress() {

        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
