package dominio.enums;

public enum TipoConta {
    USUARIO(0L, "Usuario"),
    ADMINISTRADOR(1L, "Administrador");

    private Long peso;
    private String descricao;

    TipoConta(Long peso, String descricao) {
        this.peso = peso;
        this.descricao = descricao;
    }

    public Long getPeso() {
        return this.peso;
    }

    public String getDescricao() {
        return this.descricao;
    }
}