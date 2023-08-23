import java.util.Scanner;

public class Main {
    //Para todos métodos tiverem acesso, declaro como variável de classe
    private static String userName;

    public static void main(String[] args) {

        // Criar um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        //Solicitar o nome do hotel
        System.out.println("Digite o nome do hotel:");
        String hotelName = scanner.nextLine();


        //%s -> irá ser substituída pela variável hotelName.
        String message = String.format("O nome do hotel é %s.",
                hotelName);

        System.out.println(message);

        //Solicitar o nome do usuário e senha(2678)
        System.out.println("Qual é o seu nome?");
        userName = scanner.nextLine();

        System.out.println("Digite a senha:");
        int enterPassword = scanner.nextInt();

        int verificationPassword = 2678;

        while (enterPassword != verificationPassword) {
            System.out.println("Senha incorreta!");

            System.out.println("Digite a senha novamente:");
            enterPassword = scanner.nextInt();
        }
        System.out.println("Bem vindo ao Hotel, " + hotelName + "," + userName + "." + "  É um imenso prazer ter você por aqui!");

        start(scanner);
        // Fechar o objeto Scanner para liberar recursos
        scanner.close();

    }

    //Método start
    public static void start(Scanner scanner) {
        System.out.println("Selecione uma opção:");
        System.out.println("1. Reserva de Quartos");
        System.out.println("2. Cadastro de Hóspedes");
        System.out.println("3. Pesquisa de Hóspedes");
        System.out.println("4. Abastecimento de Carros");
        System.out.println("5. Reservar um evento");
        System.out.println("6. Buffet");
        System.out.println("7. Reserva dos Auditórios");
        System.out.println("8. Reserva do Restaurante");
        System.out.println("9. Manutenção do Ar Condicionado");
        System.out.println("10. Sair");


        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                roomReservation(scanner);
                break;
            case 2:
                registerGuest(scanner);
                break;
            case 3:
                registerSearchList(scanner);
                break;
            case 4:
                fuelCar(scanner);
                break;
            case 5:
                reserveEvent(scanner);
                break;
            default:
                error(scanner);


        }

    }

    private static void reserveEvent(Scanner scanner) {
    }

    private static void fuelCar(Scanner scanner) {
    }

    private static void registerSearchList(Scanner scanner) {
        System.out.println("1. Cadastrar;");
        System.out.println("2. Pesquisar");
        System.out.println("3. Listar");
        System.out.println("4. Sair");


        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                roomReservation(scanner);
                break;
            case 2:
                registerGuest(scanner);
                break;
            case 3:
                registerSearchList(scanner);
                break;
            case 4:
                fuelCar(scanner);
                break;
            case 5:
                reserveEvent(scanner);
                break;
            default:
                error(scanner);


        }
    }

    private static void error(Scanner scanner) {
        System.out.println("Por favor, informe um número entre 1 e 10.");
        start(scanner);
    }

    private static void registerGuest(Scanner scanner) {
        System.out.println("Qual valor padrão da diária?");
        double valueDaily = scanner.nextDouble();
        scanner.nextLine();//Consumir quebra de linha

        int freeCount = 0; // Contador para gratuidades
        int halfPriceCount = 0; // Contador para meias hospedagens
        int valueTotalCount = 0; // Valor total das hospedagens

        while (true) {
            System.out.println("Qual o nome do Hóspede? (ou digite 'PARE' para finalizar)");
            String guestName = scanner.nextLine();


            if (guestName.equalsIgnoreCase("PARE")) {
                break;
            }
            while (true) {
                System.out.println("Qual é a idade do hóspede?");
                if (scanner.hasNextInt()) {

                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha

                    double guestValue = valueDaily;

                    if (age < 6) {
                        System.out.println(guestName + " cadastrada(o) com sucesso. " + guestName + " possui gatuidade.");
                        freeCount++;
                    } else if (age > 60) {
                        System.out.println(guestName + " cadastrada(o) com sucesso. " + guestName + "  paga meia.");
                        guestValue /= 2; //Maneira simplificada de divisão
                        halfPriceCount++;

                    }

                    valueTotalCount += guestValue;
                    System.out.println(guestName + " cadastrada(o) com sucesso.");
                    break; // Saia do loop após obter uma idade válida
                } else {
                    System.out.println("Idade inválida! Digite novamente.");
                }
            }


        }
        System.out.println(userName + ", o valor total das hospedagens é: R$" + valueTotalCount + "; " + freeCount + " gratuidade(s);" + halfPriceCount + " meia(s)");
    }

    private static void roomReservation(Scanner scanner) {

        //Calculo da quantidade diária * valor da diária.
        System.out.println("Qual o valor padrão da diária?");
        double valueDaily = scanner.nextDouble();

        while (valueDaily <= 0) {
            System.out.println("Valor inválido!");

            System.out.println("Digite novamente o valor da diária:");
            valueDaily = scanner.nextDouble();

        }
        System.out.println("Quantas diárias serão necessárias?");
        int howManyDailys = scanner.nextInt();

        // Consumir a quebra de linha restante
        scanner.nextLine();

        while (howManyDailys <= 0) {
            System.out.println("Valor inválido, " + userName + "!");

            System.out.println("Digite novamente quantas diárias precisa:");
            howManyDailys = scanner.nextInt();
        }

        // Consumir a quebra de linha restante
        //Adicionando scanner.nextLine()após scanner.nextInt()em ambos os lugares, você garante que qualquer quebra de linha restante seja consumida antes de ler a próxima entrada de string, evitando assim o problema de pular a solicitação do nome do hóspede.
//        scanner.nextLine();

        double valueReserve = valueDaily * howManyDailys;

        System.out.println("O valor de " + howManyDailys + " dia(s) de hospedagem é de R$" + valueReserve);

        System.out.println("Qual o nome do hóspede?");
        String clientName = scanner.nextLine();

        while (clientName.isEmpty()) {
            System.out.println("Por favor, digite o nome do hóspede:");
            clientName = scanner.nextLine();
        }

        //Confirmar hospedagem.
        boolean validInput = false;
        String confirmHosting = "";


        while (!validInput) {
            System.out.println(userName + ", você confirma a hospedagem para " + clientName + " por " + howManyDailys + " dias? S/N");
            confirmHosting = scanner.nextLine();

            if (confirmHosting.equalsIgnoreCase("S") || confirmHosting.equalsIgnoreCase("N")) {
                validInput = true;
            } else {
                System.out.println("Desculpa, mas não compreendi! Digite: S/N");
            }

        }
        if (confirmHosting.equalsIgnoreCase("S")) {
            System.out.println(userName + ", reserva efetuada para " + clientName + ". O valor total é de R$" + valueReserve + ".");
        } else if (confirmHosting.equalsIgnoreCase("N")) {
            System.out.println(userName + ", reserva não efetuada!");
        }

    }
}