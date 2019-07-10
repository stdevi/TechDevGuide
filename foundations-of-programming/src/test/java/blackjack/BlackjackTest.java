package blackjack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackjackTest {

    @Test
    public void firstValueNearestTest() {
        assertEquals(19, Blackjack.blackjack(19, 1));
    }

    @Test
    public void secondValueNearestTest() {
        assertEquals(20, Blackjack.blackjack(18, 20));
    }

    @Test
    public void firstValueOverTest() {
        assertEquals(9, Blackjack.blackjack(23, 9));
    }

    @Test
    public void secondValueOverTest() {
        assertEquals(18, Blackjack.blackjack(18, 22));
    }

    @Test
    public void bothValuesOverTest() {
        assertEquals(0, Blackjack.blackjack(24, 26));
    }
}
