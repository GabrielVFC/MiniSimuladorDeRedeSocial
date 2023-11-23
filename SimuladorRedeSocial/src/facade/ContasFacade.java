package facade;

import dominio.Conta;

import java.util.List;

public interface ContasFacade {
    List<Conta> obterContas();
    Conta obterContaPorEmail(String email);
    void cadastrarConta(Conta conta);
}