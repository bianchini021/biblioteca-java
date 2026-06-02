package domain;

public class Livro {
    private String titulo;
    private String nomeAutor;
    private String isbn;
    private boolean disponivel;

    public Livro(String titulo, String nomeAutor, String isbn, boolean disponivel) {
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.isbn = isbn;
        this.disponivel = disponivel;
    }


}
