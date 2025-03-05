//package dungtt.xocdia2022;
//
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import butterknife.Unbinder;
//import butterknife.internal.Utils;
//import pl.droidsonroids.gif.GifImageView;
//
//public class MainActivity_ViewBinding implements Unbinder {
//    private MainActivity target;
//
//    public MainActivity_ViewBinding(MainActivity mainActivity) {
//        this(mainActivity, mainActivity.getWindow().getDecorView());
//    }
//
//    public MainActivity_ViewBinding(MainActivity mainActivity, View view) {
//        this.target = mainActivity;
//        mainActivity.chan = (ImageView) Utils.findRequiredViewAsType(view, R.id.chan, "field 'chan'", ImageView.class);
//        mainActivity.le = (ImageView) Utils.findRequiredViewAsType(view, R.id.le, "field 'le'", ImageView.class);
//        mainActivity.point1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.v1, "field 'point1'", ImageView.class);
//        mainActivity.point2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.v2, "field 'point2'", ImageView.class);
//        mainActivity.point3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.v3, "field 'point3'", ImageView.class);
//        mainActivity.point4 = (ImageView) Utils.findRequiredViewAsType(view, R.id.v4, "field 'point4'", ImageView.class);
//        mainActivity.bowl = (ImageView) Utils.findRequiredViewAsType(view, R.id.bat, "field 'bowl'", ImageView.class);
//        mainActivity.bowlDisk = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.layout_center, "field 'bowlDisk'", RelativeLayout.class);
//        mainActivity.tvVersion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_version, "field 'tvVersion'", TextView.class);
//        mainActivity.tvCode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_code, "field 'tvCode'", TextView.class);
//        mainActivity.phoenix = (GifImageView) Utils.findRequiredViewAsType(view, R.id.phuong_hoang, "field 'phoenix'", GifImageView.class);
//        mainActivity.btnXoc = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_xoc_mo, "field 'btnXoc'", ImageView.class);
//        mainActivity.btnChan = (Button) Utils.findRequiredViewAsType(view, R.id.btn_chan, "field 'btnChan'", Button.class);
//        mainActivity.btnExist = (ImageView) Utils.findRequiredViewAsType(view, R.id.back, "field 'btnExist'", ImageView.class);
//        mainActivity.btnMusic = (ImageView) Utils.findRequiredViewAsType(view, R.id.music, "field 'btnMusic'", ImageView.class);
//        mainActivity.x1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x1, "field 'x1'", ImageView.class);
//        mainActivity.x2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x2, "field 'x2'", ImageView.class);
//        mainActivity.x3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x3, "field 'x3'", ImageView.class);
//        mainActivity.x4 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x4, "field 'x4'", ImageView.class);
//        mainActivity.x5 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x5, "field 'x5'", ImageView.class);
//        mainActivity.x6 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x6, "field 'x6'", ImageView.class);
//        mainActivity.x7 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x7, "field 'x7'", ImageView.class);
//        mainActivity.x8 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x8, "field 'x8'", ImageView.class);
//        mainActivity.x9 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x9, "field 'x9'", ImageView.class);
//        mainActivity.x10 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x10, "field 'x10'", ImageView.class);
//        mainActivity.x11 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x11, "field 'x11'", ImageView.class);
//        mainActivity.x12 = (ImageView) Utils.findRequiredViewAsType(view, R.id.x12, "field 'x12'", ImageView.class);
//    }
//
//    public void unbind() {
//        MainActivity mainActivity = this.target;
//        if (mainActivity != null) {
//            this.target = null;
//            mainActivity.chan = null;
//            mainActivity.le = null;
//            mainActivity.point1 = null;
//            mainActivity.point2 = null;
//            mainActivity.point3 = null;
//            mainActivity.point4 = null;
//            mainActivity.bowl = null;
//            mainActivity.bowlDisk = null;
//            mainActivity.tvVersion = null;
//            mainActivity.tvCode = null;
//            mainActivity.phoenix = null;
//            mainActivity.btnXoc = null;
//            mainActivity.btnChan = null;
//            mainActivity.btnExist = null;
//            mainActivity.btnMusic = null;
//            mainActivity.x1 = null;
//            mainActivity.x2 = null;
//            mainActivity.x3 = null;
//            mainActivity.x4 = null;
//            mainActivity.x5 = null;
//            mainActivity.x6 = null;
//            mainActivity.x7 = null;
//            mainActivity.x8 = null;
//            mainActivity.x9 = null;
//            mainActivity.x10 = null;
//            mainActivity.x11 = null;
//            mainActivity.x12 = null;
//            return;
//        }
//        throw new IllegalStateException("Bindings already cleared.");
//    }
//}
