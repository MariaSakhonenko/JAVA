import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Main
{
    public static void main(String[] args)
    {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt")))
        {

            // Считываем строки из файла
            String lexemes = fileReader.readLine();
            String delimiters = fileReader.readLine();

            writer.write("Исходная строка: " + lexemes + "\n");

            // Разделение лексем
            StringTokenizer tokenizer = new StringTokenizer(lexemes, delimiters);
            List<String> lexemeList = new ArrayList<>();
            while (tokenizer.hasMoreTokens())
            {
                lexemeList.add(tokenizer.nextToken());
            }

            writer.write("Все найденные лексемы: " + lexemeList + "\n");

            // Найдем вещественные числа и запишем их в массив
            List<Double> floatNumbers = new ArrayList<>();
            for (String lexeme : lexemeList)
            {
                try {
                    floatNumbers.add(Double.parseDouble(lexeme));
                }
                catch (NumberFormatException e)
                {
                    // Игнорируем нечисловые лексемы
                }
            }

            writer.write("Вещественные числа: " + floatNumbers + "\n");

            // Найдем время (ММ:ЧЧ) среди лексем, не являющихся числами
            Pattern timePattern = Pattern.compile("\\b\\d{2}:\\d{2}\\b");
            List<String> times = new ArrayList<>();
            for (String lexeme : lexemeList)
            {
                Matcher matcher = timePattern.matcher(lexeme);
                if (matcher.find())
                {
                    times.add(matcher.group());
                }
            }

            writer.write("Все найденные времена: " + String.join(", ", times) + "\n");

            // Подстроку с самой маленькой длиной, начинающуюся цифрой, удалить из строки
            Pattern digitPattern = Pattern.compile("\\b\\d+\\S*\\b");
            Matcher digitMatcher = digitPattern.matcher(lexemes);
            String shortestSubstring = null;
            while (digitMatcher.find())
            {
                String substring = digitMatcher.group();
                if (shortestSubstring == null || substring.length() < shortestSubstring.length())
                {
                    shortestSubstring = substring;
                }
            }

            StringBuilder result = new StringBuilder(lexemes);
            if (shortestSubstring != null)
            {
                int startIndex = result.indexOf(shortestSubstring);
                result.delete(startIndex, startIndex + shortestSubstring.length());
            }

            writer.write("Изменённая строка: " + result.toString().trim() + "\n");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
