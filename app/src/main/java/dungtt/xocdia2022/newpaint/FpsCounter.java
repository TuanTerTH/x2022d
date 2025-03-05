package dungtt.xocdia2022.newpaint;

import android.graphics.Canvas;
import android.graphics.Paint;

public class FpsCounter {
    private int fps;
    private Paint fpsPaint;
    private int lastFps;
    private long second = (System.currentTimeMillis() / 1000);

    public FpsCounter() {
        Paint paint = new Paint();
        this.fpsPaint = paint;
        paint.setColor(-1);
    }

    public void updateAndShowFps(int i, Canvas canvas, boolean z) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis != this.second) {
            this.second = currentTimeMillis;
            this.lastFps = this.fps;
            this.fps = 0;
        } else {
            this.fps++;
        }
        this.fps++;
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "PAUSED" : "");
        sb.append(canvas.getWidth());
        sb.append("x");
        sb.append(canvas.getHeight());
        canvas.drawText(sb.toString() + " FPS=" + this.lastFps + "  C=" + i, 20.0f, 20.0f, this.fpsPaint);
    }
}
