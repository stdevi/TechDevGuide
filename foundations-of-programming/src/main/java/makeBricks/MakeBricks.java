package makeBricks;

public class MakeBricks {
    public boolean makeBricks(int small, int big, int goal) {
        return small + 5 * big >= goal && goal % 5 <= small;
    }
}
