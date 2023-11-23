package facade;

import dominio.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContasFacadeImpl implements ContasFacade {

    List<Conta> usuariosCadastrados = new ArrayList<Conta>();

    @Override
    public List<Conta> obterContas() {
        return usuariosCadastrados;
    }

	@Override
	public Conta obterContaPorEmail(String email) {
        Conta contaEncontrada = null;
        for (Conta aConta : this.usuariosCadastrados) {
            if (aConta.getEmail().equals(email)) {
                contaEncontrada = aConta;
                break;
            }
        }
        return contaEncontrada;
	}

	@Override
	public void cadastrarConta(Conta conta) {
		usuariosCadastrados.add(conta);
	}    
}