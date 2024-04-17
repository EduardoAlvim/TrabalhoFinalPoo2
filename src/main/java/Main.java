import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String nome;
    double salario;
    int estrategia;
    System.out.println("Digite o nome do usuário:");
    nome = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Digite o salário do usuário:");
    salario = scanner.nextDouble();
    scanner.nextLine();
    System.out.println("Digite 1 se quer uma estrategia economica idel e 2 se quer uma estrategia economica otima");
    estrategia = scanner.nextInt();
    scanner.nextLine();
      UsuarioBuilder usuarioBuilder = new UsuarioBuilder();
      Usuario usuario = usuarioBuilder
          .setNome(nome)
          .setSalario(salario)
          .setEstrategiaEconomia(estrategia)
          .build();
    
    UsuarioProxy usuarioProxy = new UsuarioProxy(usuario);
    UsuarioObserver usuarioObserver = new UsuarioObserver(usuario);
    UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance(usuario);
    int resposta=0;
    do{
      System.out.println(
          "MENU DO SISTEMA:\nDigite 0 para sair\nDigite 1 para adicionar um gasto\nDigite 2 para adicionar um saldo\nDigite 3 para consultar o saldo atual\n");
      resposta = scanner.nextInt();
      scanner.nextLine();
      switch (resposta) {
        case 0:
          System.out.println("Saindo do sistema...");
          break;
        case 1:
          double valor;
          String descricao;
          System.out.println("Digite a descrição do gasto:");
          descricao = scanner.nextLine();
          System.out.println("Digite o valor do gasto:");
          valor = scanner.nextDouble();
          usuarioProxy.adicionarGasto(new Despesa(descricao, valor));
          break;
        case 2:
          double valor2;
          System.out.println("Digite o valor que deseja adicionar:");
          valor2 = scanner.nextDouble();
          usuarioProxy.adicionarSaldo(valor2);
          break;
        case 3:
          System.out.println("Saldo atual: " + usuarioProxy.getSaldo());
          break;
        default:
          System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
      }
    }while (resposta != 0);
  }
}