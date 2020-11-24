package Optional;

import java.util.Optional;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class OptionalFeature {

    public static void basicsOfOptional() {
        String s = null;
        Optional<String> optionalString = Optional.ofNullable(s);
        System.out.println(optionalString.orElse("Object is NULL"));

        String usingMap = optionalString.map(str -> str)
                .orElse("Object is NULL");
        System.out.println("usingMap=" + usingMap);

        System.out.println(Optional.ofNullable(s).orElse("Object is NULL - Inline"));
    }

    public static void labeledLoops() {
        outer:
        for (int i = 0; i < 10; i++) {
            System.out.println("Outer " + i);
            inner:
            for (int j = 0; j < 10; j++) {
                System.out.println("Inner " + j);
                if (j == 5) {
                    break outer;
                }
            }
        }
    }


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("apple");
        sb.append("banana");
    }
}
