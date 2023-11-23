package dominio;

import dominio.enums.TipoConta;

public class Administrador extends Conta {
    
    @Override
    public TipoConta getTipo() {
        return TipoConta.ADMINISTRADOR;
    }

}