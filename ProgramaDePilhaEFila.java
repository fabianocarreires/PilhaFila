package programadepilhaefila;

import java.util.Scanner;

public class ProgramaDePilhaEFila {

    public static Scanner ler = new Scanner(System.in);
    static String[] pilha = new String[10];
    static String[] fila = new String[10];
    static String nome;
    public static int iPilha=0, iFila=0;

    public static void main(String[] args) {
        int opcaoMenu = 0;

        do {
            menu();
            opcaoMenu = ler.nextInt();
            if (opcaoMenu == 1) {
                Pilha();
            }
            if (opcaoMenu == 2) {
                Fila();
            }
        } while (opcaoMenu != 3);
    }

    public static void menu() {
        System.out.println("*** Menu Principal ***");
        System.out.println("1 - Pilha ");
        System.out.println("2 - Fila  ");
        System.out.println("3 - Sair ");
        System.out.print("Opção: ");
    }

    public static void Pilha() {
        int opcaoSubMenu = 0;        
        do {
            System.out.println("*** Menu Pilha ***");
            System.out.println("Selecione a opção");
            System.out.println("1- Empilhar");
            System.out.println("2- Desempilhar");
            System.out.println("3- Mostrar o Topo");
            System.out.println("4- Mostrar a Base");
            System.out.println("5- Mostrar a Pilha");
            System.out.println("6- Verificar se a Pilha Está Cheia");
            System.out.println("7- Verificar se a Pilha Está Vazia");
            System.out.println("8– Voltar ao Menu Anterior");
            System.out.print("Opção: ");
            opcaoSubMenu = ler.nextInt();
            if (opcaoSubMenu == 1) {
                Empilhar(iPilha);
                iPilha++;
            }
            if (opcaoSubMenu == 2) {
                Desempilhar();
            }
            if (opcaoSubMenu == 3) {
                MostrarTopo();
            }
            if (opcaoSubMenu == 4) {
                MostrarBase();
            }
            if (opcaoSubMenu == 5) {
                MostrarPilha();
            }
            if (opcaoSubMenu == 6) {
                VerificarPilhaCheia();
            }
            if (opcaoSubMenu == 7) {
                VerificarPilhaVazia();
            }
        } while (opcaoSubMenu != 8);
    }

    public static void Fila() {
        int opcaoSubMenu = 0;        
        do {
            System.out.println("*** Menu Fila ***");
            System.out.println("Selecione a opção");
            System.out.println("1- Enfileirar");
            System.out.println("2- Desenfileirar");
            System.out.println("3- Mostrar o Primeiro da Fila");
            System.out.println("4- Mostrar o Último da Fila");
            System.out.println("5- Mostrar a Fila");
            System.out.println("6- Verificar se a Fila Está Cheia");
            System.out.println("7- Verificar se a Fila Está Vazia");
            System.out.println("8– Voltar ao Menu Anterior");
            System.out.print("Opção: ");
            opcaoSubMenu = ler.nextInt();
            if (opcaoSubMenu == 1) {
                Enfileirar(iFila);
                iFila++;
            }
            if (opcaoSubMenu == 2) {
                Desenfileirar();
                iFila--;
            }
            if (opcaoSubMenu == 3) {
                MostrarPrimeiro();
            }
            if (opcaoSubMenu == 4) {
                MostrarUltimo();
            }
            if (opcaoSubMenu == 5) {
                MostrarFila();
            }
            if (opcaoSubMenu == 6) {
                VerificarFilaCheia();
            }
            if (opcaoSubMenu == 7) {
                VerificarFilaVazia();
            }
        } while (opcaoSubMenu != 8);
    }

    public static void Empilhar(int iPilha) {
        Scanner entrada = new Scanner(System.in);
        if (RetornaPosicao(pilha) == 9) {
            System.out.println("A pilha está cheia!\n");
        } else {
            System.out.print("Digite o nome a empilhar: ");
            nome = entrada.nextLine();
            pilha[iPilha] = nome;
        }
    }

    public static int RetornaPosicao(String[] vetor) {
        int indice = 10;
        for (int i = 0; i < 10; i++) {
            if (vetor[i] == "" || vetor[i] == null) {
                indice = i - 1;
                break;
            }
        }
        if (indice == 10) {
            indice = indice - 1;
        }
        // -1 = vazia ,  9 = cheia
        return indice;
    }

    public static void Desempilhar() {
        if (RetornaPosicao(pilha) == -1) {
            System.out.println("A pilha está vazia!\n");
        } else {
            System.out.println(pilha[RetornaPosicao(pilha)] + " da posição " + (RetornaPosicao(pilha) + 1) + " foi retirado da pilha!");
            pilha[RetornaPosicao(pilha)] = "";
        }
    }

    public static void MostrarTopo() {
        if (RetornaPosicao(pilha) == -1) {
            System.out.println("A pilha está vazia!\n");
        } else {
            System.out.println(RetornaPosicao(pilha) + " está no topo da pilha.");
        }
    }

    public static void MostrarBase() {
        if (RetornaPosicao(pilha) == -1) {
            System.out.println("A pilha está vazia!\n");
        } else {
            System.out.println(pilha[0] + " está na base da pilha.\n");
        }
    }

    public static void MostrarPilha() {
        if (RetornaPosicao(pilha) == -1) {
            System.out.println("A pilha está vazia!\n");
        } else {
            System.out.print("Topo -> ");
            for (int i = RetornaPosicao(pilha); i >= 0; i--) {
                if (i == RetornaPosicao(pilha)) {
                    System.out.println(pilha[i]);
                } else if (i == 0) {
                    System.out.print("Base -> ");
                    System.out.print(pilha[i] + "\n");
                } else {
                    System.out.println("\t" + pilha[i]);
                }
            }
        }
    }

    public static void VerificarPilhaCheia() {
        if (RetornaPosicao(pilha) == 9) {
            System.out.println("A pilha está cheia!\n");
        } else {
            System.out.println("A pilha não está cheia!\n");
        }
    }

    public static void VerificarPilhaVazia() {
        if (RetornaPosicao(pilha) == -1) {
            System.out.println("Sim, a pilha está vazia!\n");
        }
    }

    public static void Enfileirar(int iFila) {
        Scanner entrada = new Scanner(System.in);
        if (RetornaPosicao(fila) == 9) {
            System.out.println("A fila está cheia!\n");
        } else {
            System.out.print("Digite o nome a enfileirar: ");
            nome = entrada.nextLine();
            fila[iFila] = nome;
        }
    }

    public static void Desenfileirar() {
        if (RetornaPosicao(fila) == -1) {
            System.out.println("A fila está vazia!\n");
        } else {
            System.out.println(fila[0] + " que estava na primeira posição, saiu da fila!");
            for (int i = 0; i < RetornaPosicao(fila); i++) {
                fila[i] = fila[i + 1];
            }
            fila[RetornaPosicao(fila)] = "";
        }        
    }

    public static void MostrarPrimeiro() {
        if (RetornaPosicao(fila) == -1) {
            System.out.println("A fila está vazia!\n");
        } else {
            System.out.println(fila[0] + " está no primeiro lugar da fila.");
        }
    }

    public static void MostrarUltimo() {
        if (RetornaPosicao(fila) == -1) {
            System.out.println("A fila está vazia!\n");
        } else {
            System.out.println(fila[RetornaPosicao(fila)] + " é o último da fila.");
        }
    }

    public static void MostrarFila() {
        if (RetornaPosicao(fila) == -1) {
            System.out.println("A fila está vazia!\n");
        } else if (RetornaPosicao(fila) >= 0) {
            System.out.print("Início da fila -> ");
            for (int i = 0; i <= RetornaPosicao(fila) - 1; i++) {
                System.out.print(fila[i] + ", ");
            }
            System.out.print(fila[RetornaPosicao(fila)] + " <- Final da Fila.\n");
        }        
    }

    public static void VerificarFilaCheia() {
        if (RetornaPosicao(fila) == 9) {
            System.out.println("A fila está cheia!\n");
        } else {
            System.out.println("A fila não está cheia!\n");
        }
    }

    public static void VerificarFilaVazia() {
        if (RetornaPosicao(fila) == -1) {
            System.out.println("Sim, a fila está vazia!\n");
        }else{
            System.out.println("Não, a fila não está vazia!\n");
        }
    }

}
