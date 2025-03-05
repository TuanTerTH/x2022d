package dungtt.xocdia2022.newpaint;

import android.graphics.Canvas;

public class VirtualScreen {
    public static final int HEIGHT = 480;
    public static final int WIDTH = 320;

    public static boolean isInside(V v) {
        return v.y >= 0.0f && v.y <= 480.0f && v.x >= 0.0f && v.x <= 320.0f;
    }

    public static V getRelative(float f, float f2) {
        return new V(f * 320.0f, f2 * 480.0f, 0.0f);
    }

    public static float virtualToReal(Canvas canvas) {
        return Math.max(((float) canvas.getWidth()) / 320.0f, ((float) canvas.getHeight()) / 480.0f);
    }
}
