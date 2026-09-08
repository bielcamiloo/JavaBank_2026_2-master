import java.util.Scanner;

import br.com.javabank.modelo.Conta;

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
            Conta conta1 = null;
            Conta conta2 = null;
            int opcao;

            do{
                System.out.println("Escolha uma opção: ");
                System.out.println("1 - Criar/Abrir conta");
                System.out.println("2 - Consultar Saldo");
                System.out.println("3 - Realizar Depósito");
                System.out.println("4 - Realizar Saque");
                System.out.println("5 - Transferência");
                System.out.println("6 - Sair");
                System.out.println("Selecione uma opção: ");
                opcao = Integer.parseInt(entrada.nextLine());

                switch(opcao) {
                    case 1 -> {
                        if (conta1 != null && conta2 != null) {
                            System.out.println("[ERRO] Limite máximo de contas cadastradas atingido (máx: 2).");
                        } else {
                            System.out.print("Informe o número da conta: ");
                            int num = Integer.parseInt(entrada.nextLine());

                            System.out.print("Informe o titular da conta: ");
                            String titular = entrada.nextLine();

                            System.out.print("Informe o depósito inicial: ");
                            double depInicial = Double.parseDouble(entrada.nextLine());

                            while (depInicial < 0) {
                                System.out.println("O saldo não deve ser um valor negativo.");
                                System.out.print("Informe um depósito inicial válido: ");
                                depInicial = Double.parseDouble(entrada.nextLine());
                            }

                            Conta novaConta = new Conta(num, titular);
                            if (depInicial > 0) {
                                novaConta.depositar(depInicial);
                            }

                            if (conta1 == null) {
                                conta1 = novaConta;
                            } else {
                                conta2 = novaConta;
                            }

                            System.out.println("br.com.javabank.modelo.Conta criada com SUCESSO!!!");
                        }
                    }
                    case 2 -> {
                        if (conta1 == null && conta2 == null) {
                            System.out.println("[ERRO] Nenhuma conta ativa no momento.");
                        } else {
                            if (conta1 != null) {
                                System.out.println("br.com.javabank.modelo.Conta: " + conta1.getNumero() +
                                        " | Titular: " + conta1.getTitular() +
                                        " | Saldo atual: R$ " + conta1.getSaldo());
                            }
                            if (conta2 != null) {
                                System.out.println("br.com.javabank.modelo.Conta: " + conta2.getNumero() +
                                        " | Titular: " + conta2.getTitular() +
                                        " | Saldo atual: R$ " + conta2.getSaldo());
                            }
                        }
                    }
                    case 3 -> {
                        if (conta1 == null && conta2 == null) {
                            System.out.println("[ERRO] Nenhuma conta ativa no momento.");
                        } else {
                            System.out.print("Informe o número da conta para depósito: ");
                            int numBusca = Integer.parseInt(entrada.nextLine());

                            // Localizar a conta de destino
                            Conta alvo = null;
                            if (conta1 != null && conta1.getNumero() == numBusca) {
                                alvo = conta1;
                            } else if (conta2 != null && conta2.getNumero() == numBusca) {
                                alvo = conta2;
                            }

                            if (alvo == null) {
                                System.out.println("[ERRO] Conta não encontrada!");
                            } else {
                                System.out.print("Informe o valor do depósito: ");
                                double valor = Double.parseDouble(entrada.nextLine());

                                boolean ok = alvo.depositar(valor);
                                if (ok) {
                                    System.out.println("DEPÓSITO REALIZADO COM SUCESSO!!!");
                                    System.out.println("Novo saldo: R$ " + alvo.getSaldo());
                                } else {
                                    System.out.println("[ERRO] Valor inválido para depósito.");
                                }
                            }
                        }
                    }
                    case 4 -> {
                        if (conta1 == null && conta2 == null) {
                            System.out.println("[ERRO] Nenhuma conta ativa no momento.");
                        } else {
                            System.out.print("Informe o número da conta para saque: ");
                            int numBusca = Integer.parseInt(entrada.nextLine());

                            // Localizar a conta de origem
                            Conta alvo = null;
                            if (conta1 != null && conta1.getNumero() == numBusca) {
                                alvo = conta1;
                            } else if (conta2 != null && conta2.getNumero() == numBusca) {
                                alvo = conta2;
                            }

                            if (alvo == null) {
                                System.out.println("[ERRO] Conta não encontrada!");
                            } else {
                                System.out.print("Informe o valor do saque: ");
                                double valor = Double.parseDouble(entrada.nextLine());

                                boolean ok = alvo.sacar(valor);
                                if (ok) {
                                    System.out.println("Saque realizado com SUCESSO!!!");
                                    System.out.println("Novo saldo: R$ " + alvo.getSaldo());
                                } else {
                                    System.out.println("[ERRO] Saque não realizado. Verifique o valor digitado ou se há saldo suficiente.");
                                }
                            }
                        }
                    }
                    case 5 -> {
                        if (conta1 == null || conta2 == null) {
                            System.out.println("[ERRO] É necessário ter pelo menos 2 contas cadastradas para realizar uma transferência.");
                        } else {
                            System.out.print("Informe o número da conta de ORIGEM: ");
                            int numOrigem = Integer.parseInt(entrada.nextLine());

                            System.out.print("Informe o número da conta de DESTINO: ");
                            int numDestino = Integer.parseInt(entrada.nextLine());

                            Conta origem = null;
                            if (conta1.getNumero() == numOrigem) origem = conta1;
                            else if (conta2.getNumero() == numOrigem) origem = conta2;

                            Conta destino = null;
                            if (conta1.getNumero() == numDestino) destino = conta1;
                            else if (conta2.getNumero() == numDestino) destino = conta2;

                            if (origem == null || destino == null) {
                                System.out.println("[ERRO] Conta de origem ou destino não encontrada!");
                            } else if (origem == destino) {
                                System.out.println("[ERRO] A conta de origem e destino não podem ser a mesma!");
                            } else {
                                System.out.print("Informe o valor da transferência: ");
                                double valor = Double.parseDouble(entrada.nextLine());

                                boolean ok = origem.transferir(valor, destino);
                                if (ok) {
                                    System.out.println("TRANSFERÊNCIA REALIZADA COM SUCESSO!!!");
                                    System.out.println("Novo saldo (Origem): R$ " + origem.getSaldo());
                                    System.out.println("Novo saldo (Destino): R$ " + destino.getSaldo());
                                } else {
                                    System.out.println("[ERRO] Transferência não realizada. Verifique o valor ou saldo disponível.");
                                }
                            }
                        }
                    }
                    case 6-> {
                        System.out.println("[FECHAMENTO] Encerrando o sistema.");
                    }
                    default -> {
                        System.out.println("Opção Inválida. ");
                    }

                }
            }while(opcao != 6);
        }

        entrada.close();

    }
}
