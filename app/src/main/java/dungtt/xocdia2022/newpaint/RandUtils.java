package dungtt.xocdia2022.newpaint;

import android.graphics.Color;

public class RandUtils {
    private static V[] rands = new V[117];
    private static int ri;

    static {
        for (int i = 0; i < rands.length; i++) {
            V v = new V(0.0f, 0.0f, 0.0f);
            do {
                v.x = (float) ((Math.random() * 2.0d) - 1.0d);
                v.y = (float) ((Math.random() * 2.0d) - 1.0d);
                v.z = (float) ((Math.random() * 2.0d) - 1.0d);
            } while (v.squareLength() > 1.0f);
            v.scale((float) (1.0d / Math.sqrt((double) v.squareLength())));
            rands[i] = v;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            spread();
        }
    }

    private static void spread() {
        for (int i = 0; i < rands.length; i++) {
            V v = new V(0.0f, 0.0f, 0.0f);
            for (V v2 : rands) {
                if (((double) v2.squareLength(rands[i])) < 0.09d) {
                    v.add(rands[i]);
                    v.sub(v2);
                }
            }
            v.normalize();
            v.scale(0.1f);
            rands[i].add(v);
            rands[i].normalize();
        }
    }

    public static V randomVelocity(float f) {
        V[] vArr = rands;
        int length = (ri + 1) % vArr.length;
        ri = length;
        V v = new V(vArr[length]);
        v.scale(f);
        return v;
    }

    public static int randomSubColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[0] = (((float) ((Math.random() * 50.0d) - 25.0d)) + fArr[0]) % 360.0f;
        return Color.HSVToColor((int) ((Math.random() * 50.0d) + 200.0d), fArr);
    }

    public static int randomColor() {
        return Color.HSVToColor(new float[]{(float) (Math.random() * 360.0d), 1.0f, 1.0f});
    }

    public static float rand(float f, float f2) {
        return (float) ((Math.random() * ((double) (f2 - f))) + ((double) f));
    }

    public static int rand(int i, int i2) {
        return (int) ((Math.random() * ((double) (i2 - i))) + ((double) i));
    }

    public static boolean withProbability(float f) {
        return Math.random() < ((double) f);
    }
}
