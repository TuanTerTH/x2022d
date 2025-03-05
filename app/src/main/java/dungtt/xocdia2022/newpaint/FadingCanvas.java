package dungtt.xocdia2022.newpaint;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

public class FadingCanvas {
    public static final int FADER = Color.argb(75, 0, 0, 0);
    public static final float FADING_FACTOR = 0.29296875f;
    private Bitmap bmp;
    private Canvas canvas;

    public void makeSureWeHaveCanvas(int i, int i2) {
        if (this.bmp == null) {
            this.bmp = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.canvas = new Canvas(this.bmp);
        }
    }

    public void fade() {
        this.canvas.drawColor(FADER);
    }

    public Bitmap getBmp() {
        return this.bmp;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }
}
