package Interpreter;

public class Interpreter {
    public int interpret(int value, String[] commands, int[] args) {
        int result = value;
        for (int i = 0; i < commands.length; i++) {
            if (!commands[i].matches("[-+*]")) {
                return -1;
            }
            result = operation(commands[i], result, args[i]);
        }
        return result;
    }

    private int operation(String command, int value1, int value2) {
        switch (command) {
            case "*":
                return value1 * value2;
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            default:
                return -1;
        }
    }
}
