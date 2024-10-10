import java.util.Formatter;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение x (x > 0): ");
        double x = scanner.nextDouble();
        while(x <= 0)
        {
            System.out.print("Введите значение x (x > 0): ");
            x = scanner.nextDouble();
        }
        System.out.print("Введите значение k (натуральное число): ");
        int k = scanner.nextInt();
        while (k <= 0)
        {
            System.out.print("Введите значение k (натуральное число): ");
            k = scanner.nextInt();
        }

        TaylorSeries obj = new TaylorSeries(k, x);
        double res = obj.ln();
        int IntRes = (int) res;

        double standardLog = Math.log(x);

        Formatter formatter = new Formatter();
        formatter.format("Приближенное значение ln(%.2f): %+0" + Integer.valueOf(k+1).toString() + "." + Integer.valueOf(k+1).toString() + "f%n", x, res);
        formatter.format("Стандартное значение ln(%.2f):  %+0" + Integer.valueOf(k+1).toString() + "." + Integer.valueOf(k+1).toString() + "f%n", x, standardLog);
        System.out.println(formatter);

        System.out.printf("n в восьмеричном виде: %#o%n", IntRes);
        System.out.printf("n в шестнадцатеричном виде: %#x%n", IntRes);
    }
}
