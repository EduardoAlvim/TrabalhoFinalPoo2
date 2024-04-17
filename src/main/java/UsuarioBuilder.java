public class UsuarioBuilder {
  private String nome;
  private double salario;
  private EstrategiaEconomia estrategiaEconomia;

  public UsuarioBuilder setNome(String nome) {
    this.nome = nome;
    return this;
  }

  public UsuarioBuilder setSalario(double salario) {
    this.salario = salario;
    return this;
  }

  public UsuarioBuilder setEstrategiaEconomia(int estrategia) {
    if(estrategia == 2){
    this.estrategiaEconomia = new EstrategiaOtimo();}
    else{
      this.estrategiaEconomia = new EstrategiaIdeal();
    }
    return this;
  }

  public Usuario build() {
    return new Usuario(nome, salario, estrategiaEconomia);
  }
}
