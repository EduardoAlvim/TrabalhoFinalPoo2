public class EstrategiaIdeal implements EstrategiaEconomia {
    @Override
    public double calcularValorIdeal(double salario) {
        return salario * 0.20; // 20% do salário
    }
}
