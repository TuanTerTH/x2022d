package dungtt.xocdia2022.newpaint;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import com.example.myapplication.R;
//import com.dungtt.xocdia2022.R;

public class Icons {
    private Bitmap headIconBitmap;
    private Bitmap particleIconBitmap;

    public Icons(Resources resources) {
//        this.particleIconBitmap = ((BitmapDrawable) resources.getDrawable(R.drawable.particle3x3b9x9)).getBitmap();
//        this.headIconBitmap = ((BitmapDrawable) resources.getDrawable(R.drawable.particle3x3b7x7)).getBitmap();
    }

    public Bitmap getParticleIconBitmap() {
        return this.particleIconBitmap;
    }

    public Bitmap getHeadIconBitmap() {
        return this.headIconBitmap;
    }
}
