import java.util.ArrayList;
import java.util.List;

public class Usuario implements Observable {
    private String nome;
    private double salario;
    private double saldo;
    private List<Despesa> despesas;
    private List<Observer> observers;
    private EstrategiaEconomia estrategiaEconomia;

    public Usuario(String nome, double salario, EstrategiaEconomia estrategiaEconomia) {
        this.nome = nome;
        this.salario = salario;
        this.saldo = salario;
        this.despesas = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.estrategiaEconomia = estrategiaEconomia;
        System.out.println("Usuário(a) "+nome+" criado(a) com sucesso!\nSeu salário é de R$"+salario+"\nSegundo a estrategia escolhida, no fim do mês ele(a) deverá guardar: R$"+estrategiaEconomia.calcularValorIdeal(salario)+"\n");
    }

    public void adicionarGasto(Despesa despesa) {
        this.despesas.add(despesa);
        this.saldo -= despesa.getValor();
        System.out.println("Despesa adicionada: " + despesa.getDescricao() + " - Valor: " + despesa.getValor());
      notifyObservers();
    }

    public void adicionarSaldo(double valor) {
        this.saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }

  public double getSalario() {
      return salario;
  }
  public double getValorIdealEconomia() {
      return estrategiaEconomia.calcularValorIdeal(salario);
  }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
