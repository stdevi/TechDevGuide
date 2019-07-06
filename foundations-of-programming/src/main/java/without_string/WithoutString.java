package without_string;

public class WithoutString {

    public String withoutString(String base, String remove) {
        return base.replaceAll("(?i)" + remove, "");
    }
}
