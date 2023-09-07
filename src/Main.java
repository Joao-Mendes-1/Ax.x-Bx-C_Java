import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bem-vindo a calculadora de equações do 2ª grau");

        double a;
        double b;
        double c;
        char continuar = 's';

        do {
            System.out.println("Digite o valor de A, B e C");

            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            if(a != 0){

                if(b == 0){
                    EquacaoIncompleta(a,c);
                    System.out.println("|-- INICIANDO NOVO CÁLCULO --|");
                    continue;
                }

                EquacaoCompleta(a,b,c);

                System.out.println("Deseja fazer um novo cálculo? s/n");
                continuar = sc.next().charAt(0);

            }else {
                System.out.println("Impossível realizar o cálculo : A menor que zero");
            }

        } while (continuar == 's');

        }

    public static double CalcularDelta(double a , double b, double c) {
        double delta;
        delta = Math.pow(b,2) - 4 * (a * c);
        return delta;
    }
    public static void EquacaoCompleta(double a ,double b, double c) {
        double valorDelta = CalcularDelta(a,b,c);
        System.out.printf("(%.2f)X² + (%.2f)X + (%.2f) = 0",a,b,c);
        if(valorDelta > 0 ){
            double x1 = ((-b) + Math.sqrt(valorDelta)) / (2 * a);
            double x2 = ((-b) - Math.sqrt(valorDelta)) / (2 * a);
            FormatarConjunto(x1,x2);

        }else{
            System.out.println();
            System.out.println("Impossível realizar o cálculo: delta é negativo");
        }
    }

    public static void EquacaoIncompleta(double a ,double c) {
        double valorDelta = CalcularDelta(a,0,c);
        System.out.printf("(%.2f)X² + 0X + (%.2f) = 0",a,c);
        if(valorDelta > 0 ){

            double x1 = Math.sqrt((-c)/a);
            double x2 = -Math.sqrt((-c)/a);
            FormatarConjunto(x1,x2);
        }else {
            System.out.println();
            System.out.println("Impossível realizar o cálculo: delta é negativo");
        }
    }

    public static void FormatarConjunto(double x1, double x2){

        if(x1 == x2){
            System.out.println();
            System.out.printf("S = [%.2f]",x1);
            System.out.println();
            return;
        }
        System.out.println();
        System.out.printf(" S = [%.2f, %.2f]",x1,x2);
        System.out.println();
    }
}
