package dungtt.xocdia2022.newpaint;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

public class Particle {
    private static final V GRAVITY = new V(0.0f, 1.0f, 0.0f);
    private int age = 0;
    private List<Emitter> emitters = new ArrayList();
    private V gravity = new V(GRAVITY);
    private Painter painter;
    private V position;
    private Painter realPainter;
    private boolean remove;
    private float speedDegradingFactor = 0.9f;
    private V velocity;

    public Particle(V v, V v2) {
        this.position = v;
        this.velocity = v2;
    }

    public void setSpeedDegradingFactor(float f) {
        this.speedDegradingFactor = f;
        V v = new V(GRAVITY);
        this.gravity = v;
        v.scale(f);
    }

    public void setGravityDegradingFactor(float f) {
        V v = new V(GRAVITY);
        this.gravity = v;
        v.scale(f);
    }

    public void paint(Canvas canvas, Particles particles) {
        physicalUpdate();
        paint(canvas, VirtualScreen.virtualToReal(canvas));
        emit(particles);
    }

    public void add(Emitter emitter) {
        this.emitters.add(emitter);
    }

    public void setPainter(Painter painter2) {
        this.painter = painter2;
    }

    public void setRealPainter(Painter painter2) {
        this.realPainter = painter2;
    }

    public V getPosition() {
        return this.position;
    }

    public boolean isRemove() {
        return this.remove;
    }

    private void physicalUpdate() {
        this.velocity.add(this.gravity);
        this.velocity.scale(this.speedDegradingFactor);
    }

    private void emit(Particles particles) {
        this.age++;
        for (Emitter emit : this.emitters) {
            emit.emit(this, particles);
        }
    }

    private void paint(Canvas canvas, float f) {
        if (this.painter != null) {
            int calculatePaintingStepsCount = calculatePaintingStepsCount(f);
            V v = new V(this.velocity);
            float f2 = 1.0f / ((float) calculatePaintingStepsCount);
            v.scale(f2);
            for (int i = 0; i < calculatePaintingStepsCount; i++) {
                this.position.add(v);
                this.painter.draw(canvas, this, f, ((float) i) * f2);
            }
        }
    }

    private int calculatePaintingStepsCount(float f) {
        int max = (int) (Math.max(Math.abs(this.velocity.x), Math.abs(this.velocity.y)) * f);
        if (max == 0) {
            return 1;
        }
        return max;
    }

    public int getAge() {
        return this.age;
    }

    public void die() {
        this.remove = true;
    }

    public V getVelocity() {
        return this.velocity;
    }

    public void paintReal(Canvas canvas) {
        Painter painter2 = this.realPainter;
        if (painter2 != null) {
            painter2.draw(canvas, this, VirtualScreen.virtualToReal(canvas), 1.0f);
        }
    }

    public Painter getPainter() {
        return this.painter;
    }
}
