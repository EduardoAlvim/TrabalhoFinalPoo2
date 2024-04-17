public class UsuarioProxy {
    private Usuario usuario;

    public UsuarioProxy(Usuario usuario) {
        this.usuario = usuario;
    }

    public void adicionarGasto(Despesa despesa) {
        if (despesa.getValor() <= usuario.getSaldo()) {
            usuario.adicionarGasto(despesa);
        } else {
            System.out.println("Erro: Saldo insuficiente para adicionar gasto.");
        }
    }

    public void adicionarSaldo(double valor) {
        usuario.adicionarSaldo(valor);
    }

    public double getSaldo() {
        return usuario.getSaldo();
    }
}
