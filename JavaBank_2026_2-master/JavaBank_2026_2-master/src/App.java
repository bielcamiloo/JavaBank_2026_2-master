import java.util.Scanner;

public class App {
    //ATALHO ==> PSVM + TAB = main ()
    public static void main(String[] args) {
        //ATALHO ==> SOUT + TAB = println
        System.out.println("JAVABANK = TERMINAL DO CAIXA");

        //VARIÁVEIS
        Scanner entrada = new Scanner(System.in);
        boolean operadorAutenticado = false;

        //CONSTANTE
        final int SENHA_OPERADOR = 8888;

        for (int tentativa = 1; tentativa <= 3; tentativa++) {
            System.out.println("Informe a sua SENHA: ");
            int senha = Integer.parseInt(entrada.nextLine());

            if (senha == SENHA_OPERADOR) {
                System.out.println("[SESSÃO INICIADA] Bem-vindo.");
                operadorAutenticado = true;
                break;
            } else {
                System.out.println("[ALERTA] Senha incorreta");
            }

        }

        if (operadorAutenticado == false) {
            System.out.println("[BLOQUEIO] Limite de tentativas excedidas. ");
        } else {
            int numeroConta = 0;
            String titular = "";
            double saldo = 0;
            boolean contaAtiva = false;
            int opcao;

            do{
                System.out.println("Escolha uma opção: ");
                System.out.println("1 - Criar/Abrir conta");
                System.out.println("2 - Consultar Saldo");
                System.out.println("3 - Realizar Depósito");
                System.out.println("4 - Realizar Saque");
                System.out.println("5 - Sair");
                System.out.println("Selecione uma opção: ");
                opcao = Integer.parseInt(entrada.nextLine());

                switch(opcao) {
                    case 1 -> {
                        System.out.print("Informe o número da conta: ");
                        numeroConta = Integer.parseInt(entrada.nextLine());
                        System.out.println("Informe o titular da conta: ");
                        titular = entrada.nextLine();
                        System.out.println("Informe o saldo inicial: ");
                        saldo = Double.parseDouble(entrada.nextLine());

                        while(saldo < 0) {
                            System.out.println("O saldo não deve ser um valor negativo.");
                            System.out.println();
                        }
                        contaAtiva = true;
                        System.out.println("br.com.javabank.modelo.Conta criada com SUCESSO!!!");
                    }
                    case 2 -> {
                        if(contaAtiva == true){
                            System.out.println("br.com.javabank.modelo.Conta: " + numeroConta +
                                               "| Titular: " + titular +
                                               "| Saldo atual: R$ " + saldo
                                                                           );
                        }
                        else{
                            System.out.println("[ERRO] Nenhuma conta ativa");
                        }
                    }
                    case 3 -> {
                            if (contaAtiva) {
                                System.out.println("Informe o valor do depósito: ");
                                double deposito = Double.parseDouble(entrada.nextLine());

                                while (deposito <= 0) {
                                    System.out.println("O valor do depósito deve ser maior que zero.");
                                    System.out.println("Informe um valor válido: ");
                                    deposito = Double.parseDouble(entrada.nextLine());
                                }

                                saldo += deposito;
                                System.out.println("DEPÓSITO REALIZADO COM SUCESSO!!!");
                                System.out.println("Novo saldo: R$ " + saldo);
                            }
                                else {
                                System.out.println("[ERRO] Nenhuma conta ativa");
                            }
                    }
                    case 4 -> {
                        if (contaAtiva) {
                            System.out.println("Informe o valor do saque: ");
                            double saque = Double.parseDouble(entrada.nextLine());

                            while (saque <= 0 || saque > saldo) {
                                if (saque <=0) {
                                    System.out.println("O valor do saque deve ser maior que zero.");
                                }
                                else {
                                    System.out.println("Saldo insuficiente! Saldo atual: R$ " + saldo);
                                }
                                System.out.println("Informe um valor válido: ");
                                saque = Double.parseDouble(entrada.nextLine());
                            }

                            saldo -= saque;
                            System.out.println("Saque realizado com SUCESSO!!!");
                            System.out.println("Novo saldo: R$ " + saldo);
                        }
                        else {
                            System.out.println("[ERRO] Nenhuma conta ativa");
                        }
                    }
                    case 5 -> {
                        System.out.println("[FECHAMENTO] Encerrando o sistema. ");
                    }
                    default -> {
                        System.out.println("Opção Inválida. ");
                    }

                }
            }while(opcao != 5);
        }

        entrada.close();

    }
}
