package org.jnamer;

import java.util.Arrays;
import java.util.List;

class BasicAlphabet {

    static final List<String> letters = Arrays.asList(
            "a","b","c","d","e","f","g","h","i","j","k","l","m",
            "n","o","p","q","r","s","t","u","v","w","x","y","z");

static final List<String> bigLetters = Arrays.asList(
            "A","B","C","D","E","F","G","H","I","J","K","L","M",
            "N","O","P","Q","R","S","T","U","V","W","X","Y","Z");

    static int maxIndex() {
        return letters.size() - 1;
    }
}
