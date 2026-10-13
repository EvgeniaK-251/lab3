import java.util.*;


public class Collect5 {
    public static Map invert(Map source) {
        Map result = new HashMap();
        for (Object obj: source.entrySet()) {
            Map.Entry entry = (Map.Entry) obj;
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        Map original = new HashMap();
        original.put(1, "один");
        original.put(2, "два");
        original.put(3, "три");

        System.out.println("Исходный Map:\n" + original);

        Map turned = invert(original);
        System.out.println("Перевернутый Map:\n" + turned);
    }
}
