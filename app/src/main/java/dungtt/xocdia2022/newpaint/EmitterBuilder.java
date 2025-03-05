//package dungtt.xocdia2022.newpaint;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class EmitterBuilder {
//    private float blinking = 0.0f;
//    /* access modifiers changed from: private */
//    public int color = -1;
//    /* access modifiers changed from: private */
//    public List<Emitter> emitters = new ArrayList();
//    /* access modifiers changed from: private */
//    public boolean freeFall = false;
//    /* access modifiers changed from: private */
//    public float gravityDegrading = 1.0f;
//    /* access modifiers changed from: private */
//    public int maxTtl = 0;
//    /* access modifiers changed from: private */
//    public int minTtl = 0;
//    /* access modifiers changed from: private */
//    public Painter painter = null;
//    /* access modifiers changed from: private */
//    public Painters painters;
//    /* access modifiers changed from: private */
//    public boolean randomSubColor = false;
//    /* access modifiers changed from: private */
//    public Painter realPainter = null;
//    /* access modifiers changed from: private */
//    public boolean shot;
//    private boolean spark = false;
//    /* access modifiers changed from: private */
//    public float speed = 0.0f;
//    /* access modifiers changed from: private */
//    public float speedDegrading = 0.9f;
//
//    public EmitterBuilder ttl(int i) {
//        return ttl(i, i);
//    }
//
//    public EmitterBuilder ttl(int i, int i2) {
//        this.minTtl = i;
//        this.maxTtl = i2;
//        return this;
//    }
//
//    public EmitterBuilder randomSpeed(float f) {
//        this.speed = f;
//        return this;
//    }
//
//    public EmitterBuilder painter(Painter painter2) {
//        this.painter = painter2;
//        return this;
//    }
//
//    public EmitterBuilder realPainter(Painter painter2) {
//        this.realPainter = painter2;
//        return this;
//    }
//
//    public EmitterBuilder color(Painters painters2, int i) {
//        this.painters = painters2;
//        this.color = i;
//        return this;
//    }
//
//    public EmitterBuilder randomSubColor() {
//        this.randomSubColor = true;
//        return this;
//    }
//
//    public EmitterBuilder asSpark() {
//        this.spark = true;
//        return this;
//    }
//
//    public EmitterBuilder freeFall() {
//        this.freeFall = true;
//        return this;
//    }
//
//    public EmitterBuilder blinking(float f) {
//        this.blinking = f;
//        return this;
//    }
//
//    public EmitterBuilder withEmitter(Emitter emitter) {
//        this.emitters.add(emitter);
//        return this;
//    }
//
//    public EmitterBuilder speedDegrading(float f) {
//        this.speedDegrading = f;
//        return this;
//    }
//
//    public EmitterBuilder gravity(float f) {
//        this.gravityDegrading = f;
//        return this;
//    }
//
//    public Emitter build() {
//        return new Emitter() {
//            public void emit(Particle particle, Particles particles) {
//                V v;
//                Painter painter;
//                V relative = EmitterBuilder.this.shot ? VirtualScreen.getRelative(0.5f, 1.0f) : new V(particle.getPosition());
//                if (EmitterBuilder.this.shot) {
//                    v = new V(RandUtils.rand(-2.5f, 2.5f), (float) RandUtils.rand(-30, -25), 0.0f);
//                    EmitterBuilder.this.ttl(20);
//                } else {
//                    v = EmitterBuilder.this.freeFall ? new V(0.0f, 0.0f, 0.0f) : new V(particle.getVelocity());
//                    if (EmitterBuilder.this.speed > 0.0f) {
//                        v.add(RandUtils.randomVelocity(EmitterBuilder.this.speed));
//                    }
//                }
//                if (EmitterBuilder.this.color != -1) {
//                    painter = EmitterBuilder.this.randomSubColor ? EmitterBuilder.this.painters.big(RandUtils.randomSubColor(EmitterBuilder.this.color)) : EmitterBuilder.this.painters.big(EmitterBuilder.this.color);
//                } else {
//                    painter = EmitterBuilder.this.painter == null ? particle.getPainter() : EmitterBuilder.this.painter;
//                }
//                Particle particle2 = new Particle(relative, v);
//                particle2.setSpeedDegradingFactor(EmitterBuilder.this.speedDegrading);
//                particle2.setGravityDegradingFactor(EmitterBuilder.this.gravityDegrading);
//                particle2.setPainter(painter);
//                particle2.setRealPainter(EmitterBuilder.this.realPainter);
//                if (!(EmitterBuilder.this.minTtl == 0 || EmitterBuilder.this.maxTtl == 0)) {
//                    particle2.add(Emitters.timeToLive(RandUtils.rand(EmitterBuilder.this.minTtl, EmitterBuilder.this.maxTtl)));
//                }
//                for (Emitter add : EmitterBuilder.this.emitters) {
//                    particle2.add(add);
//                }
//                particles.add(particle2);
//            }
//        };
//    }
//
//    public EmitterBuilder shoot() {
//        this.shot = true;
//        return this;
//    }
//}
