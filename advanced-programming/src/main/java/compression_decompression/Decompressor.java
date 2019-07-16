package compression_decompression;

public class Decompressor {
    public String decomp(String comp) {
        int numOfChars = 0;
        int number = 0;
        int endPosition = 0;

        if (!comp.matches("([a-zA-Z]*(\\d+\\[[\\w\\d\\]\\[]*])*)*")) {
            throw new IllegalArgumentException("Wrong input format!");
        }

        for (int i = 0; i < comp.length(); i++) {
            char c = comp.charAt(i);
            if (Character.isDigit(c)) {
                if (Character.isDigit(comp.charAt(i + 1))) {
                    number = Integer.parseInt(Character.getNumericValue(c) + "" +
                            Character.getNumericValue(comp.charAt(i + 1)));
                    numOfChars++;
                    i = i + 1;
                } else {
                    number = Character.getNumericValue(c);
                }
            } else if (c == '[') {
                endPosition = i;
            } else if (c == ']') {
                comp = comp.substring(0, endPosition - 1 - numOfChars) +
                        comp.substring(endPosition + 1, i).repeat(number) +
                        comp.substring(i + 1);
                numOfChars = 0;
                if (comp.contains("]")) {
                    return decomp(comp);
                }
            }
        }
        return comp;
    }
}
