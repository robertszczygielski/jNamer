package alphabet;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BasicNames {
    static final List<String> names = Arrays.asList(
            "John", "Bob"
    );

    static String getRandomName() {
        Random random = new Random();
        return names.get(random.nextInt(numberOfNames()));
    }

    private static int numberOfNames() {
        return names.size();
    }
}
