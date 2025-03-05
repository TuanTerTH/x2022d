package dungtt.xocdia2022.newpaint;

public class V {
    public float x;
    public float y;
    public float z;

    public V(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public V(V v) {
        this(v.x, v.y, v.z);
    }

    public void add(V v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
    }

    public void sub(V v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
    }

    public float squareLength() {
        float f = this.x;
        float f2 = this.y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.z;
        return f3 + (f4 * f4);
    }

    public float squareLength(V v) {
        float f = this.x - v.x;
        float f2 = this.y - v.y;
        float f3 = this.z - v.z;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public void scale(float f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
    }

    public float len() {
        return (float) Math.sqrt((double) squareLength());
    }

    public void normalize() {
        if (squareLength() != 0.0f) {
            scale(1.0f / len());
        }
    }

    public void setScaled(V v, float f) {
        this.x = v.x * f;
        this.y = v.y * f;
        this.z = v.z * f;
    }
}
