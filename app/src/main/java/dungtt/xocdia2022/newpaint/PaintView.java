//package dungtt.xocdia2022.newpaint;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.os.Handler;
//import android.util.AttributeSet;
//import androidx.appcompat.widget.AppCompatImageView;
//import androidx.core.internal.view.SupportMenu;
//
//public class PaintView extends AppCompatImageView {
//    private static final int FRAME_RATE = 30;
//    private FadingCanvas fadingCanvas = new FadingCanvas();
//    private FpsCounter fpsCounter = new FpsCounter();
//    private Handler h = new Handler();
//    private Painters painters;
//    private Particles particles = new Particles();
//    private boolean paused;
//    private Runnable r = new Runnable() {
//        public void run() {
//            PaintView.this.postInvalidate();
//        }
//    };
//
//    public PaintView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        this.painters = new Painters(new Icons(context.getResources()));
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDraw(Canvas canvas) {
//        this.fadingCanvas.makeSureWeHaveCanvas(canvas.getWidth(), canvas.getHeight());
//        if (!this.paused) {
//            this.fadingCanvas.fade();
//            for (Particle paint : this.particles.getParticles()) {
//                paint.paint(this.fadingCanvas.getCanvas(), this.particles);
//            }
//        }
//        canvas.drawBitmap(this.fadingCanvas.getBmp(), new Rect(0, 0, this.fadingCanvas.getBmp().getWidth(), this.fadingCanvas.getBmp().getHeight()), new Rect(0, 0, canvas.getWidth(), canvas.getHeight()), (Paint) null);
//        for (Particle paintReal : this.particles.getParticles()) {
//            paintReal.paintReal(canvas);
//        }
//        if (!this.paused) {
//            this.particles.cycle();
//            createNewPainter();
//        }
//        this.fpsCounter.updateAndShowFps(this.particles.getParticles().size(), canvas, this.paused);
//        this.h.postDelayed(this.r, 30);
//    }
//
//    private void createNewPainter() {
//        if (Math.random() < 0.03d) {
//            redAndWhite();
//        }
//        if (Math.random() < 0.04d) {
//            blueToGreen();
//        }
//        if (Math.random() < 0.02d) {
//            withHeads();
//        }
//        if (Math.random() < 0.04d) {
//            justRed();
//        }
//        if (Math.random() < 0.03d) {
//            yellowToRed();
//        }
//        if (Math.random() < 0.02d) {
//            justNavy();
//        }
//    }
//
//    private void withHeads() {
//        int randomColor = RandUtils.randomColor();
//        int randomColor2 = RandUtils.randomColor();
//        EmitterBuilder speedDegrading = new EmitterBuilder().shoot().painter(this.painters.big(-1)).speedDegrading(1.0f);
//        Emitter build = new EmitterBuilder().color(this.painters, randomColor).realPainter(this.painters.head(randomColor2)).randomSubColor().ttl(4, 7).randomSpeed(20.0f).withEmitter(Emitters.ending(Emitters.repeat(10, new EmitterBuilder().color(this.painters, randomColor2).randomSubColor().randomSpeed(10.0f).speedDegrading(0.5f).ttl(10).build()))).build();
//        AnonymousClass2 r1 = new Emitter() {
//            public void emit(Particle particle, Particles particles) {
//                V v = new V(particle.getPosition());
//                v.add(RandUtils.randomVelocity(5.0f));
//                Particle particle2 = new Particle(v, new V(particle.getVelocity()));
//                particle2.setPainter(Painters.blinking(-1, 0.2f));
//                particle2.add(Emitters.timeToLive(10));
//                particle2.setSpeedDegradingFactor(0.5f);
//                particles.add(particle2);
//            }
//        };
//        speedDegrading.withEmitter(Emitters.at(20, Emitters.repeat(40, build)));
//        speedDegrading.withEmitter(Emitters.repeat(3, r1));
//        speedDegrading.build().emit((Particle) null, this.particles);
//    }
//
//    private void redAndWhite() {
//        EmitterBuilder speedDegrading = new EmitterBuilder().shoot().painter(this.painters.big(-16776961)).speedDegrading(1.0f);
//        Emitter build = new EmitterBuilder().color(this.painters, -1).ttl(6, 7).randomSpeed(20.0f).build();
//        Emitter build2 = new EmitterBuilder().color(this.painters, SupportMenu.CATEGORY_MASK).ttl(15, 20).randomSpeed(10.0f).gravity(0.1f).build();
//        AnonymousClass3 r3 = new Emitter() {
//            public void emit(Particle particle, Particles particles) {
//                V v = new V(particle.getPosition());
//                v.add(RandUtils.randomVelocity(5.0f));
//                Particle particle2 = new Particle(v, new V(particle.getVelocity()));
//                particle2.setPainter(Painters.blinking(-1, 0.2f));
//                particle2.add(Emitters.timeToLive(10));
//                particle2.setSpeedDegradingFactor(0.5f);
//                particles.add(particle2);
//            }
//        };
//        speedDegrading.withEmitter(Emitters.at(20, Emitters.repeat(24, build)));
//        speedDegrading.withEmitter(Emitters.at(20, Emitters.repeat(24, build2)));
//        speedDegrading.withEmitter(Emitters.repeat(3, r3));
//        speedDegrading.build().emit((Particle) null, this.particles);
//    }
//
//    private void blueToGreen() {
//        int parseColor = Color.parseColor("#a6bbf4");
//        int parseColor2 = Color.parseColor("#3e8c29");
//        EmitterBuilder speedDegrading = new EmitterBuilder().shoot().painter(this.painters.big(-1)).speedDegrading(1.0f);
//        speedDegrading.withEmitter(Emitters.at(20, Emitters.repeat(24, new EmitterBuilder().color(this.painters, parseColor).ttl(3, 4).randomSpeed(20.0f).withEmitter(Emitters.ending(new EmitterBuilder().color(this.painters, parseColor2).ttl(9, 10).build())).build())));
//        speedDegrading.build().emit((Particle) null, this.particles);
//    }
//
//    private void yellowToRed() {
//        int parseColor = Color.parseColor("#ffcf5f");
//        int parseColor2 = Color.parseColor("#ffb07b");
//        EmitterBuilder speedDegrading = new EmitterBuilder().shoot().painter(this.painters.big(-1)).speedDegrading(1.0f);
//        speedDegrading.withEmitter(Emitters.at(20, Emitters.repeat(40, new EmitterBuilder().color(this.painters, parseColor).ttl(10, 13).randomSpeed(20.0f).withEmitter(Emitters.ending(new EmitterBuilder().color(this.painters, parseColor2).ttl(6, 7).speedDegrading(0.5f).build())).build())));
//        speedDegrading.build().emit((Particle) null, this.particles);
//    }
//
//    private void justRed() {
//        int parseColor = Color.parseColor("#ce4928");
//        EmitterBuilder speedDegrading = new EmitterBuilder().shoot().painter(this.painters.big(-1)).speedDegrading(1.0f);
//        speedDegrading.withEmitter(Emitters.at(20, Emitters.repeat(24, new EmitterBuilder().color(this.painters, parseColor).ttl(6, 7).randomSubColor().randomSpeed(20.0f).build())));
//        speedDegrading.build().emit((Particle) null, this.particles);
//    }
//
//    private void justNavy() {
//        int parseColor = Color.parseColor("#000080");
//        EmitterBuilder speedDegrading = new EmitterBuilder().shoot().painter(this.painters.big(SupportMenu.CATEGORY_MASK)).speedDegrading(1.0f);
//        speedDegrading.withEmitter(Emitters.at(20, Emitters.repeat(24, new EmitterBuilder().color(this.painters, parseColor).ttl(6, 7).randomSubColor().randomSpeed(20.0f).build())));
//        speedDegrading.build().emit((Particle) null, this.particles);
//    }
//
//    private void foo() {
//        V relative = VirtualScreen.getRelative((float) ((Math.random() / 2.0d) + 0.25d), (float) ((Math.random() / 2.0d) + 0.25d));
//        int randomColor = RandUtils.randomColor();
//        V v = new V(0.0f, -7.0f, 0.0f);
//        int randomColor2 = RandUtils.randomColor();
//        for (int i = 0; i < 50; i++) {
//            V randomVelocity = RandUtils.randomVelocity(10.0f);
//            randomVelocity.add(v);
//            Particle particle = new Particle(new V(relative), randomVelocity);
//            particle.setPainter(this.painters.big(RandUtils.randomSubColor(randomColor)));
//            particle.add(Emitters.timeToLive((int) ((Math.random() * 5.0d) + 15.0d)));
//            particle.add(Emitters.at(12, Emitters.repeat(10, Emitters.explode(this.painters, randomColor2))));
//            this.particles.add(particle);
//        }
//    }
//}
