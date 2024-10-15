import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.System.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        BigDecimal x;
        while (true)
        {
            out.print("Введите значение x (x > 0): ");
            x = new BigDecimal(reader.readLine());
            if (x.compareTo(BigDecimal.ZERO) > 0)
            {
                break;
            }
            else
            {
                out.println("Try again.");
            }
        }

        int k;
        while (true)
        {
            out.print("Введите значение k (натуральное число): ");
            k = Integer.parseInt(reader.readLine());


            if (k > 0)
            {
                break;
            }
            else
            {
                out.println("Try again.");
            }
        }

        TaylorSeries obj = new TaylorSeries(k, x);
        BigDecimal res = obj.ln();

        BigDecimal standardLog = BigDecimal.valueOf(Math.log(x.doubleValue()));

        out.printf("Приближенное значение ln(%.2f): %+0" + (k + 1) + "." + (k + 1) + "f%n", x, res);
        out.printf("Стандартное значение ln(%.2f):  %+0" + (k + 1) + "." + (k + 1) + "f%n", x, standardLog);

        int intRes = res.setScale(0, RoundingMode.DOWN).intValue();
        out.printf("n в восьмеричном виде: %#o%n", intRes);
        out.printf("n в шестнадцатеричном виде: %#x%n", intRes);
    }
}
