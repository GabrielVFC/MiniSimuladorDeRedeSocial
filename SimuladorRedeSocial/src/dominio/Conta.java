package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dominio.enums.TipoConta;

public abstract class Conta {
    private String nome;
    private String email;
    private String senha;

    private List<Conta> amigos;

    public Conta() {
        this.amigos = new ArrayList<Conta>();
    }
    
    public Conta(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.amigos = new ArrayList<Conta>();
    }

    public abstract TipoConta getTipo();

    public void adicionarAmigo(Conta amigo){
        this.amigos.add(amigo);
    }

    public void removerAmigo (Conta amigo){
        this.amigos.remove(amigo);
    }

    public List<Conta> listaDeAmigos(){
        return this.amigos;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        // mas precisa desse that aq?
        Conta that = (Conta) o;
        return Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, senha);
    }

    @Override
    public String toString() {
        return "RedeSocial{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}