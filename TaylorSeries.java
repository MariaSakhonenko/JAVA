import java.math.BigDecimal;
import java.math.MathContext;

public class TaylorSeries
{
    private final int k;
    private final BigDecimal x;

    public TaylorSeries(int k_cpy, BigDecimal x_cpy)
    {
        k = k_cpy;
        x = x_cpy;
    }

    public BigDecimal ln()
    {
        final BigDecimal exp = (x.subtract(BigDecimal.ONE)).divide(x.add(BigDecimal.ONE), MathContext.DECIMAL128);
        BigDecimal epsilon = BigDecimal.ONE.divide(BigDecimal.TEN.pow(k), MathContext.DECIMAL128);
        BigDecimal term = exp;
        BigDecimal sum = BigDecimal.ZERO;
        int n = 0;

        while (term.abs().compareTo(epsilon) > 0)
        {
            sum = sum.add(term);
            n++;
            term = term.multiply(exp
                    .pow(2)
                    .multiply(BigDecimal.valueOf(2L * n - 1))
                    .divide(BigDecimal.valueOf(2L * n + 1), MathContext.DECIMAL128)
            );
        }
        return sum.multiply(BigDecimal.valueOf(2), MathContext.DECIMAL128);
    }
}
