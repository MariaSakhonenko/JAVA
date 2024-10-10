public class TaylorSeries
{
    int k;
    double x;

    TaylorSeries(int k_cpy, double x_cpy)
    {
        k = k_cpy;
        x = x_cpy;
    }

    public double ln()
    {
        double epsilon = Math.pow(10, -k);
        double term = (x - 1) / (x + 1);
        double sum = 0;
        int n = 0;

        while (Math.abs(term) > epsilon)
        {
            sum += term;
            n++;
            term *= (Math.pow((x - 1) / (x + 1), 2) * (2 * n - 1)) / (2 * n + 1);
        }
        sum *= 2;
        return sum;
    }
}
