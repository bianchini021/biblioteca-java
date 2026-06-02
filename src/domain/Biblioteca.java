package domain;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public boolean cadastrarLivro(Livro livro) {
        if (buscarLivro(livro.getIsbn()) != null) {
            return false;
        }

        livros.add(livro);
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (buscarUsuario(usuario.getCpf()) != null) {
            return false;
        }

        usuarios.add(usuario);
        return true;
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Não existem livros cadastrados.");
            return;
        }

        System.out.println("\n===== LIVROS CADASTRADOS =====");

        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Não existem usuários cadastrados.");
            return;
        }

        System.out.println("\n===== USUÁRIOS CADASTRADOS =====");

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public boolean temUsuariosCadastrados() {
        return !usuarios.isEmpty();
    }

    public boolean temLivrosCadastrados() {
        return !livros.isEmpty();
    }

    public Usuario buscarUsuario(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }

        return null;
    }

    public Livro buscarLivro(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }

        return null;
    }

    public boolean emprestarLivro(String cpf, String isbn) {
        Usuario usuario = buscarUsuario(cpf);

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return false;
        }

        Livro livro = buscarLivro(isbn);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return false;
        }

        if (!livro.isDisponivel()) {
            System.out.println("Este livro já está emprestado.");
            return false;
        }

        usuario.adicionarLivroEmprestado(livro);
        return true;
    }

    public boolean devolverLivro(String cpf, String isbn) {
        Usuario usuario = buscarUsuario(cpf);

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return false;
        }

        Livro livro = buscarLivro(isbn);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return false;
        }

        if (!usuario.possuiLivro(livro)) {
            System.out.println("Este usuário não possui esse livro emprestado.");
            return false;
        }

        usuario.removerLivroEmprestado(livro);
        return true;
    }
}