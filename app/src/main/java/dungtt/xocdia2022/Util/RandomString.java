package dungtt.xocdia2022.Util;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;

public class RandomString {
    public static final String alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final char[] buf;
    private final Random random;
    private final char[] symbols;

    public String nextString() {
        int i = 0;
        while (true) {
            char[] cArr = this.buf;
            if (i >= cArr.length) {
                return new String(cArr);
            }
            char[] cArr2 = this.symbols;
            cArr[i] = cArr2[this.random.nextInt(cArr2.length)];
            i++;
        }
    }

    public RandomString(int i, Random random2, String str) {
        if (i < 1) {
            throw new IllegalArgumentException();
        } else if (str.length() >= 2) {
            this.random = (Random) Objects.requireNonNull(random2);
            this.symbols = str.toCharArray();
            this.buf = new char[i];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public RandomString(int i, Random random2) {
        this(i, random2, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    public RandomString(int i) {
        this(i, new SecureRandom());
    }

    public RandomString() {
        this(21);
    }
}
