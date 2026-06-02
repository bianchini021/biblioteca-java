package domain;

public class Livro {
    private String titulo;
    private String nomeAutor;
    private String isbn;
    private boolean disponivel;

    public Livro(String titulo, String nomeAutor, String isbn) {
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nAutor: " + nomeAutor +
                "\nISBN: " + isbn +
                "\nDisponível: " + (disponivel ? "Sim" : "Não") +
                "\n-------------------------";
    }
}