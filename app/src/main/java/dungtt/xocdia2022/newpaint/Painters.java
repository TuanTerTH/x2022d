//package dungtt.xocdia2022.newpaint;
//
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.PorterDuff;
//import android.graphics.PorterDuffColorFilter;
//
//public class Painters {
//    /* access modifiers changed from: private */
//    public Icons icons;
//
//    public Painters(Icons icons2) {
//        this.icons = icons2;
//    }
//
//    public Painter big(int i) {
//        return new Painter(i) {
//            Paint paint;
//            final /* synthetic */ int val$color;
//
//            {
//                this.val$color = r4;
//                Paint paint2 = new Paint();
//                this.paint = paint2;
//                paint2.setColor(-1);
//                this.paint.setColorFilter(new PorterDuffColorFilter(r4, PorterDuff.Mode.MULTIPLY));
//            }
//
//            public void draw(Canvas canvas, Particle particle, float f, float f2) {
//                Bitmap particleIconBitmap = Painters.this.icons.getParticleIconBitmap();
//                this.paint.setAlpha((int) ((1.0f - ((1.0f - f2) * 0.29296875f)) * 255.0f));
//                canvas.drawBitmap(particleIconBitmap, (particle.getPosition().x * f) - ((float) (particleIconBitmap.getWidth() / 2)), (particle.getPosition().y * f) - ((float) (particleIconBitmap.getHeight() / 2)), this.paint);
//            }
//        };
//    }
//
//    public Painter bigSparking(int i) {
//        return new Painter(i) {
//            Paint paint;
//            final /* synthetic */ int val$color;
//
//            {
//                this.val$color = r4;
//                Paint paint2 = new Paint();
//                this.paint = paint2;
//                paint2.setColor(-1);
//                this.paint.setColorFilter(new PorterDuffColorFilter(r4, PorterDuff.Mode.MULTIPLY));
//            }
//
//            public void draw(Canvas canvas, Particle particle, float f, float f2) {
//                Bitmap particleIconBitmap = Painters.this.icons.getParticleIconBitmap();
//                canvas.drawBitmap(particleIconBitmap, (particle.getPosition().x * f) - ((float) (particleIconBitmap.getWidth() / 2)), (particle.getPosition().y * f) - ((float) (particleIconBitmap.getHeight() / 2)), this.paint);
//                if (RandUtils.withProbability(0.2f)) {
//                    canvas.drawPoint((particle.getPosition().x * f) + RandUtils.rand(-2.0f, 2.0f), (particle.getPosition().x * f) + RandUtils.rand(-2.0f, 2.0f), this.paint);
//                }
//            }
//        };
//    }
//
//    public static Painter small(int i) {
//        return new Painter(i) {
//            Paint paint;
//            final /* synthetic */ int val$color;
//
//            {
//                this.val$color = r2;
//                Paint paint2 = new Paint();
//                this.paint = paint2;
//                paint2.setColor(r2);
//            }
//
//            public void draw(Canvas canvas, Particle particle, float f, float f2) {
//                canvas.drawPoint(particle.getPosition().x * f, particle.getPosition().y * f, this.paint);
//            }
//        };
//    }
//
//    public static Painter blinking(int i, float f) {
//        return new Painter(i, f) {
//            Paint paint;
//            final /* synthetic */ float val$blinkShare;
//            final /* synthetic */ int val$color;
//
//            {
//                this.val$color = r1;
//                this.val$blinkShare = r2;
//                Paint paint2 = new Paint();
//                this.paint = paint2;
//                paint2.setColor(r1);
//            }
//
//            public void draw(Canvas canvas, Particle particle, float f, float f2) {
//                if (!RandUtils.withProbability(this.val$blinkShare)) {
//                    canvas.drawPoint(particle.getPosition().x * f, particle.getPosition().y * f, this.paint);
//                }
//            }
//        };
//    }
//
//    public Painter head(int i) {
//        return new Painter(i) {
//            Paint paint;
//            final /* synthetic */ int val$color;
//
//            {
//                this.val$color = r4;
//                Paint paint2 = new Paint();
//                this.paint = paint2;
//                paint2.setColorFilter(new PorterDuffColorFilter(r4, PorterDuff.Mode.MULTIPLY));
//            }
//
//            public void draw(Canvas canvas, Particle particle, float f, float f2) {
//                Bitmap headIconBitmap = Painters.this.icons.getHeadIconBitmap();
//                canvas.drawBitmap(headIconBitmap, (particle.getPosition().x * f) - ((float) (headIconBitmap.getWidth() / 2)), (particle.getPosition().y * f) - ((float) (headIconBitmap.getHeight() / 2)), this.paint);
//            }
//        };
//    }
//}
