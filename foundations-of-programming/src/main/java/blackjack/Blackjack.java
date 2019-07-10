package blackjack;

public class Blackjack {
    static int blackjack(int a, int b) {
        int result;
        result = a > b ? a : b;
        if (a > 21) {
            result = b;
        } else if (b > 21) {
            result = a;
        }
        if (result > 21) {
            return 0;
        }
        return result;
    }
}
