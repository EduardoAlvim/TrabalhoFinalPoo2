public class EstrategiaOtimo implements EstrategiaEconomia {
    @Override
    public double calcularValorIdeal(double salario) {
        return salario * 0.30; // 30% do salário
    }
}
