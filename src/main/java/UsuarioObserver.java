public class UsuarioObserver implements Observer {
    private Usuario usuario;
    private double limiteGastos;

    public UsuarioObserver(Usuario usuario) {
        this.usuario = usuario;
        this.usuario.addObserver(this);
        this.limiteGastos = 0.8;
    }

    @Override
    public void update() {
      double limitePermitido = usuario.getSalario() - (usuario.getSalario() * limiteGastos);
      
      if (usuario.getSaldo() <= limitePermitido) {
          System.out.println("Aviso: Você gastou 80% do seu salário. Considere revisar suas despesas.");
      }
    }
}
