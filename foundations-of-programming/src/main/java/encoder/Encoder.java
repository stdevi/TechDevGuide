package encoder;

import java.util.HashMap;
import java.util.Map;

public class Encoder {
    public String[] encoder(String[] raw, String[] code_words) {
        Map<String, String> map = new HashMap<>();
        String[] result = new String[raw.length];

        for (int i = 0; i < raw.length; i++) {
            if (!map.containsKey(raw[i])) {
                map.put(raw[i], code_words[i]);
            }
            result[i] = map.get(raw[i]);
        }
        return result;
    }
}
