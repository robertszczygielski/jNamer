package jnamer;

import java.util.Arrays;
import java.util.List;

class BasicAlphabet {

    static final List<String> letters = Arrays.asList(
            "a","b","c","d","e","f","g","h","i","j","k","l","m",
            "n","o","p","q","r","s","t","u","v","w","x","y","z");

    static int maxIndex() {
        return letters.size() - 1;
    }
}
