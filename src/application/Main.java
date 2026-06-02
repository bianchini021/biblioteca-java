package application;

import domain.Biblioteca;
import domain.Livro;
import domain.Usuario;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int opc = 0;

        System.out.println("Sistema de Biblioteca");

        do {
            exibeMenu();
            opc = lerOpcao();

            switch (opc) {
                case 1:
                    cadastrarUsuario(biblioteca);
                    break;
                case 2:
                    cadastrarLivro(biblioteca);
                    break;
                case 3:
                    emprestarLivro(biblioteca);
                    break;
                case 4:
                    devolverLivro(biblioteca);
                    break;
                case 5:
                    biblioteca.listarLivros();
                    break;
                case 6:
                    biblioteca.listarUsuarios();
                    break;
                case 7:
                    listarLivrosEmprestadosUsuario(biblioteca);
                    break;
                case 9:
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opc != 9);
    }

    private static void exibeMenu() {
        System.out.println("\n+--------- MENU ---------+");
        System.out.println("| 1 - CADASTRAR USUARIO  |");
        System.out.println("| 2 - CADASTRAR LIVRO    |");
        System.out.println("| 3 - EMPRESTAR LIVRO    |");
        System.out.println("| 4 - DEVOLVER LIVRO     |");
        System.out.println("| 5 - LISTAR LIVROS      |");
        System.out.println("| 6 - LISTAR USUARIOS    |");
        System.out.println("| 7 - LIVROS DO USUARIO  |");
        System.out.println("| 9 - SAIR               |");
        System.out.println("+------------------------+");
        System.out.print("Selecione uma das opções: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void cadastrarUsuario(Biblioteca biblioteca) {
        System.out.println("\n+-- CADASTRO DE USUÁRIOS --+");

        System.out.print("Informe o nome do usuário: ");
        String nome = input.nextLine();

        System.out.print("Informe o CPF do usuário: ");
        String cpf = input.nextLine();

        Usuario usuario = new Usuario(nome, cpf);

        if (biblioteca.cadastrarUsuario(usuario)) {
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.out.println("Erro: já existe um usuário com este CPF.");
        }
    }

    private static void cadastrarLivro(Biblioteca biblioteca) {
        System.out.println("\n+-- CADASTRO DE LIVROS --+");

        System.out.print("Informe o título do livro: ");
        String titulo = input.nextLine().toUpperCase();

        System.out.print("Informe o autor do livro: ");
        String autor = input.nextLine().toUpperCase();

        System.out.print("Informe o ISBN do livro: ");
        String isbn = input.nextLine();

        Livro livro = new Livro(titulo, autor, isbn);

        if (biblioteca.cadastrarLivro(livro)) {
            System.out.println("Livro cadastrado com sucesso!");
        } else {
            System.out.println("Erro: já existe um livro com este ISBN.");
        }
    }

    private static void emprestarLivro(Biblioteca biblioteca) {
        System.out.println("\n+-- EMPRESTAR LIVRO --+");

        if (!biblioteca.temUsuariosCadastrados()) {
            System.out.println("Não existem usuários cadastrados.");
            return;
        }

        if (!biblioteca.temLivrosCadastrados()) {
            System.out.println("Não existem livros cadastrados.");
            return;
        }

        System.out.print("Informe o CPF do usuário: ");
        String cpf = input.nextLine();

        System.out.print("Informe o ISBN do livro: ");
        String isbn = input.nextLine();

        if (biblioteca.emprestarLivro(cpf, isbn)) {
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o empréstimo.");
        }
    }

    private static void devolverLivro(Biblioteca biblioteca) {
        System.out.println("\n+-- DEVOLVER LIVRO --+");

        if (!biblioteca.temUsuariosCadastrados()) {
            System.out.println("Não existem usuários cadastrados.");
            return;
        }

        System.out.print("Informe o CPF do usuário: ");
        String cpf = input.nextLine();

        System.out.print("Informe o ISBN do livro: ");
        String isbn = input.nextLine();

        if (biblioteca.devolverLivro(cpf, isbn)) {
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a devolução.");
        }
    }

    private static void listarLivrosEmprestadosUsuario(Biblioteca biblioteca) {
        System.out.println("\n+-- LIVROS EMPRESTADOS DO USUÁRIO --+");

        if (!biblioteca.temUsuariosCadastrados()) {
            System.out.println("Não existem usuários cadastrados.");
            return;
        }

        System.out.print("Informe o CPF do usuário: ");
        String cpf = input.nextLine();

        Usuario usuario = biblioteca.buscarUsuario(cpf);

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        usuario.listarLivrosEmprestados();
    }
}