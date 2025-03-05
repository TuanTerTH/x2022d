package dungtt.xocdia2022.newpaint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Particles {
    private List<Particle> newParticles = new ArrayList();
    private List<Particle> particles = new ArrayList();

    public List<Particle> getParticles() {
        return this.particles;
    }

    public void add(Particle particle) {
        this.newParticles.add(particle);
    }

    public void cycle() {
        removeDead();
        addNew();
    }

    private void removeDead() {
        Iterator<Particle> it = this.particles.iterator();
        while (it.hasNext()) {
            Particle next = it.next();
            if (next.isRemove() || !VirtualScreen.isInside(next.getPosition())) {
                it.remove();
            }
        }
    }

    private void addNew() {
        this.particles.addAll(this.newParticles);
        this.newParticles.clear();
    }
}
