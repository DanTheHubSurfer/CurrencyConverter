import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner inputOne;
        String currencyType;



        do {
            welcome();

            inputOne = new Scanner(System.in);
            currencyType = inputOne.nextLine();
            char currencyTypeChar = currencyType.charAt(0);

            if (currencyTypeChar == '1' || currencyTypeChar == '2' || currencyTypeChar == '3' || currencyTypeChar == 'e') {
                switch (currencyTypeChar) {
                    case '1':
                        System.out.println("Ваша исходная валюта: Euro");
                        break;
                    case '2':
                        System.out.println("Ваша исходная валюта: United States dollar");
                        break;
                    case '3':
                        System.out.println("Ваша исходная валюта: Turkish lira");
                        break;
                    case 'e':
                        System.out.println("Вы вышли из программы CurrencyConverter");
                        System.exit(0);
                }
            } else {
                System.out.println("Неправильный ввод данных, пожалуйста выберите правильный тип валюты!");
                continue;
            }

            System.out.println("\n" + "Выберите конечную вашу валюту из списка:" + "\n");

            System.out.println("1 = EURO");
            System.out.println("2 = USD");
            System.out.println("3 = TL");

            System.out.println("\n" + "Ввод конечной валюты:");

            Scanner inputTwo = new Scanner(System.in);
            String currencyType2 = inputTwo.nextLine();
            char currencyTypeChar2 = currencyType2.charAt(0);


            if (currencyTypeChar2 == '1' || currencyTypeChar2 == '2' || currencyTypeChar2 == '3') {

                outUsersChoise(currencyTypeChar2);

            } else {
                System.out.println("Неправильный ввод данных, пожалуйста выберите правильный тип валюты!");
                continue;
            }

            double[] currencyRatesEuro = {1.00, 1.09, 32.97};
            double[] currencyRatesDollar = {0.917, 1.00, 30.28};
            double[] currencyRatesTL = {0.030, 0.033, 1.00};

            System.out.println("\n" + "Введите вашу сумму:");
            Scanner geldEingabe = new Scanner(System.in);
            double waehrungsZahl = geldEingabe.nextDouble();

            if (currencyTypeChar == '1' && currencyTypeChar2 == '1') {
                double inRates = getRateValue(currencyTypeChar2, currencyRatesEuro);
                System.out.println(waehrungsZahl * inRates + "Euro");
            } else if (currencyTypeChar == '1' && currencyTypeChar2 == '2') {
                double inRates = getRateValue(currencyTypeChar2, currencyRatesEuro);
                System.out.println(waehrungsZahl * inRates + " Dollaer");
            } else if (currencyTypeChar == '1' && currencyTypeChar2 == '3') {
                double inRates = getRateValue(currencyTypeChar2, currencyRatesEuro);
                System.out.println(waehrungsZahl * inRates + " TL");
            } else if (currencyTypeChar == '2' && currencyTypeChar2 == '1') {
                double inRates = getRateValue(currencyTypeChar2, currencyRatesDollar);
                System.out.println(waehrungsZahl * inRates + "Euro");
            } else if (currencyTypeChar == '2' && currencyTypeChar2 == '2') {
                double inRates = getRateValue(currencyTypeChar2, currencyRatesDollar);
                System.out.println(waehrungsZahl * inRates + " Dollar");
            } else if (currencyTypeChar == '2' && currencyTypeChar2 == '3') {
                double inRates = getRateValue(currencyTypeChar2, currencyRatesDollar);
                System.out.println(waehrungsZahl * inRates + " TL");
            }else if (currencyTypeChar == '3' && currencyTypeChar2 == '1') {
                double inRates = getRateValue(currencyTypeChar2, currencyRatesTL);
                System.out.println(waehrungsZahl * inRates + "Euro");
            } else if (currencyTypeChar == '3' && currencyTypeChar2 == '2') {
                double inRates = getRateValue(currencyTypeChar2, currencyRatesTL);
                System.out.println(waehrungsZahl * inRates + " Dollar");
            } else if (currencyTypeChar == '3' && currencyTypeChar2 == '3') {
                double inRates = getRateValue(currencyTypeChar2, currencyRatesTL);
                System.out.println(waehrungsZahl * inRates + " TL");
            }
            else {
                System.out.println("Неправильный ввод данных, пожалуйста выберите правильный тип валюты!");

            }


        }

        while (currencyType != ("e"));
        //System.exit(0);
    }

    public static void welcome () {
        System.out.println("\n" + "Приветствуем в CurrencyConverter!" + "\n");

        System.out.println("\n" + "Выберите исходную валюту из списка:" + "\n");
        System.out.println("1 = EURO");
        System.out.println("2 = USD");
        System.out.println("3 = TL");
        System.out.println("e = Выход из программы");
        System.out.println("\n" + "Введите номер исходной валюты:");
    }

    public static void outUsersChoise(char currencyTypeChar2M)
    {

        switch (currencyTypeChar2M) {
            case '1':
                System.out.println("Ваша исходная валюта: Euro");
                break;
            case '2':
                System.out.println("Ваша исходная валюта: United States dollar");
                break;
            case '3':
                System.out.println("Ваша исходная валюта: Turkish lira");
                break;

        }


    }
    public static double getRateValue(char currencyTypeChar2M, double[] rates)
    {
            double rate = 0;
            switch (currencyTypeChar2M) {
                case '1':
                    rate = rates[0];
                    break;
                case '2':
                    rate = rates[1];
                    break;
                case '3':
                    rate = rates[2];
                    break;
                default:
                    System.out.println("Неправильный ввод данных, пожалуйста выберите правильный тип валюты!");
                    rate = -1;
            }
            return rate;
    }


}