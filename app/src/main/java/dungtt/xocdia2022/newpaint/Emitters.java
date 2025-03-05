//package dungtt.xocdia2022.newpaint;
//
//public class Emitters {
//    public static Emitter at(final int i, final Emitter emitter) {
//        return new Emitter() {
//            public void emit(Particle particle, Particles particles) {
//                if (particle.getAge() == i) {
//                    emitter.emit(particle, particles);
//                }
//            }
//        };
//    }
//
//    public static Emitter at(int i, int i2, final Emitter emitter) {
//        final int rand = RandUtils.rand(i, i2);
//        return new Emitter() {
//            public void emit(Particle particle, Particles particles) {
//                if (particle.getAge() == rand) {
//                    emitter.emit(particle, particles);
//                }
//            }
//        };
//    }
//
//    public static Emitter ending(final Emitter emitter) {
//        return new Emitter() {
//            public void emit(Particle particle, Particles particles) {
//                if (particle.isRemove()) {
//                    Emitter.this.emit(particle, particles);
//                }
//            }
//        };
//    }
//
//    public static Emitter repeat(final int i, final Emitter emitter) {
//        return new Emitter() {
//            public void emit(Particle particle, Particles particles) {
//                for (int i = 0; i < i; i++) {
//                    emitter.emit(particle, particles);
//                }
//            }
//        };
//    }
//
//    public static Emitter timeToLive(int i) {
//        return at(i, new Emitter() {
//            public void emit(Particle particle, Particles particles) {
//                particle.die();
//            }
//        });
//    }
//
//    public static Emitter explode(final Painters painters, final int i) {
//        return new Emitter() {
//            public void emit(Particle particle, Particles particles) {
//                V randomVelocity = RandUtils.randomVelocity(5.0f);
//                randomVelocity.add(particle.getVelocity());
//                Particle particle2 = new Particle(new V(particle.getPosition()), randomVelocity);
//                particle2.setPainter(Painters.small(RandUtils.randomSubColor(i)));
//                particle2.add(Emitters.timeToLive(RandUtils.rand(3, 5)));
//                particles.add(particle2);
//            }
//        };
//    }
//
//    public static Emitter shot(final Painter painter) {
//        return new Emitter() {
//            public void emit(Particle particle, Particles particles) {
//                Particle particle2 = new Particle(VirtualScreen.getRelative(0.5f, 1.0f), new V(RandUtils.rand(-2.5f, 2.5f), (float) RandUtils.rand(-30, -25), 0.0f));
//                particle2.add(Emitters.timeToLive(20));
//                particle2.setPainter(Painter.this);
//                particles.add(particle2);
//            }
//        };
//    }
//
//    public static Emitter explode(final float f, final Painter painter) {
//        return new Emitter() {
//            public void emit(Particle particle, Particles particles) {
//                V randomVelocity = RandUtils.randomVelocity(f);
//                randomVelocity.add(particle.getVelocity());
//                Particle particle2 = new Particle(new V(particle.getPosition()), randomVelocity);
//                particle2.add(Emitters.timeToLive(RandUtils.rand(15, 20)));
//                particle2.setPainter(painter);
//                particles.add(particle2);
//            }
//        };
//    }
//}
