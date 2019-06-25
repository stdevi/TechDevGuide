import java.util.Arrays;

public class SumNumbers {

    public int sumNumbers(String str) {
        return Arrays.stream(str.split("\\D"))
                .filter(number -> !number.isEmpty())
                .map(String::trim)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
