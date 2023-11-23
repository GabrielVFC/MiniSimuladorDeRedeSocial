package dominio;

import dominio.enums.TipoConta;

public class Usuario extends Conta {

    @Override
    public TipoConta getTipo() {
        return TipoConta.USUARIO;
    }

}
