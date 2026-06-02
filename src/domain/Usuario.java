package domain;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String cpf;
    private ArrayList<Livro> livrosEmprestados = new ArrayList<>();

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean temLivrosEmprestados() {
        return !livrosEmprestados.isEmpty();
    }

    public void listarLivrosEmprestados() {
        if (livrosEmprestados.isEmpty()) {
            System.out.println("Este usuário não possui livros emprestados.");
            return;
        }

        System.out.println("\nLivros emprestados para " + nome + ":");

        for (Livro livro : livrosEmprestados) {
            System.out.println(livro);
        }
    }

    public void adicionarLivroEmprestado(Livro livro) {
        livrosEmprestados.add(livro);
        livro.emprestar();
    }

    public void removerLivroEmprestado(Livro livro) {
        livrosEmprestados.remove(livro);
        livro.devolver();
    }

    public boolean possuiLivro(Livro livro) {
        for (Livro livroEmprestado : livrosEmprestados) {
            if (livroEmprestado.getIsbn().equals(livro.getIsbn())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nCPF: " + cpf +
                "\nLivros emprestados: " + livrosEmprestados.size() +
                "\n-------------------------";
    }
}