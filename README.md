# 📚 Sistema de Biblioteca

Sistema de gerenciamento de biblioteca desenvolvido em Java, com funcionalidades de cadastro de livros e usuários, empréstimos e devoluções via terminal.

---

## 🗂️ Estrutura do Projeto

```
biblioteca-java/
└── src/
    ├── application/
    │   └── Main.java         # Ponto de entrada e interface com o usuário
    └── domain/
        ├── Biblioteca.java   # Regras de negócio principais
        ├── Livro.java        # Entidade Livro
        └── Usuario.java      # Entidade Usuário
```

---

## ⚙️ Funcionalidades

- ✅ Cadastro de usuários (identificados por CPF)
- ✅ Cadastro de livros (identificados por ISBN)
- ✅ Empréstimo de livros com verificação de disponibilidade
- ✅ Devolução de livros
- ✅ Listagem de todos os livros cadastrados
- ✅ Listagem de todos os usuários cadastrados
- ✅ Consulta de livros emprestados por usuário

---

## ▶️ Como executar

### Pré-requisitos

- [Java JDK 11+](https://www.oracle.com/java/technologies/downloads/) instalado

### Compilando e rodando

```bash
# Clone o repositório
git clone https://github.com/bianchini021/biblioteca-java.git
cd biblioteca-java

# Compile os arquivos
javac -d out src/domain/*.java src/application/*.java

# Execute o programa
java -cp out application.Main
```

---

## 🖥️ Menu do sistema

```
+--------- MENU ---------+
| 1 - CADASTRAR USUARIO  |
| 2 - CADASTRAR LIVRO    |
| 3 - EMPRESTAR LIVRO    |
| 4 - DEVOLVER LIVRO     |
| 5 - LISTAR LIVROS      |
| 6 - LISTAR USUARIOS    |
| 7 - LIVROS DO USUARIO  |
| 9 - SAIR               |
+------------------------+
```

---

## 🧠 Conceitos aplicados

- Orientação a Objetos (encapsulamento, separação de responsabilidades)
- Pacotes (`domain` e `application`)
- Coleções com `ArrayList`
- Tratamento de exceções com `try/catch`
- Entrada de dados via `Scanner`

---

## 🚀 Melhorias futuras

- [ ] Interface gráfica (JavaFX ou Swing)
- [ ] Persistência de dados (arquivo ou banco de dados)
- [ ] Validação de CPF e ISBN
- [ ] Limite de livros por usuário
- [ ] Data de devolução e controle de atraso

---

## 👨‍💻 Autor

Feito por **bianchini021** — primeiro projeto Java 🎉
