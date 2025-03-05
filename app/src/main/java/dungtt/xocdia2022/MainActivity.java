package dungtt.xocdia2022;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

import dungtt.xocdia2022.Request.RequestListener;
import dungtt.xocdia2022.Request.ServerRequest;
import dungtt.xocdia2022.Util.Constance;
import dungtt.xocdia2022.mEnum.TypeInternet;
import dungtt.xocdia2022.objectReq.ObjectOff;
import dungtt.xocdia2022.objectReq.ObjectRule;
//import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static String APPLICATION_ID = "com.dungtt.xocdia2022";
    private int NUMBER_CODE = 9;
    private ArrayList<Integer> arrChan;
    private ArrayList<Integer> arrLe;
    private ArrayList<Integer> arrPos;
    private String[] arrayKey = {"BMWR", "QTVT", "DVTH", "DMKI", "DTTW", "DTAT", "DTQN", "THAT"};
    private String[] arrayKeyOff = {"A", "B", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
//    @BindView(2131230810)
//    ImageView bowl;
//    @BindView(2131230962)
//    RelativeLayout bowlDisk;
//    @BindView(2131230820)
//    Button btnChan;
//    @BindView(2131230807)
//    ImageView btnExist;
//    @BindView(2131231030)
//    ImageView btnMusic;
//    @BindView(2131230821)
//    ImageView btnXoc;
//    @BindView(2131230835)
//    ImageView chan;
    private int continueMedia = 0;
    private int currentX = 0;
    private int currentY = 0;
    private int div;
    private int endTime;
    private boolean flagHiddenBowl = true;
    /* access modifiers changed from: private */
    public boolean flagInsertCode = false;
    /* access modifiers changed from: private */
    public boolean flagShock = true;
    /* access modifiers changed from: private */
    public Gson gson;
    private boolean isChan = true;
    private boolean isOffLine = true;
//    @BindView(2131230964)
//    ImageView le;
//    private MediaPlayer musicBg;
//    private MediaPlayer musicShock;
//    @BindView(2131231067)
//    GifImageView phoenix;
//    @BindView(2131231202)
//    ImageView point1;
//    @BindView(2131231203)
//    ImageView point2;
//    @BindView(2131231204)
//    ImageView point3;
//    @BindView(2131231205)
//    ImageView point4;
    private int pos = 0;
    private int random;
    private boolean ruleChild;
    private boolean ruleChildCode;
    private boolean ruleMaster;
    private boolean ruleMasterCode;
//    @BindView(2131231195)
//    TextView tvCode;
//    @BindView(2131231196)
//    TextView tvVersion;
//    @BindView(2131231221)
//    ImageView x1;
//    @BindView(2131231222)
//    ImageView x10;
//    @BindView(2131231223)
//    ImageView x11;
//    @BindView(2131231224)
//    ImageView x12;
//    @BindView(2131231225)
//    ImageView x2;
//    @BindView(2131231226)
//    ImageView x3;
//    @BindView(2131231227)
//    ImageView x4;
//    @BindView(2131231228)
//    ImageView x5;
//    @BindView(2131231229)
//    ImageView x6;
//    @BindView(2131231230)
//    ImageView x7;
//    @BindView(2131231231)
//    ImageView x8;
//    @BindView(2131231232)
//    ImageView x9;
    TextView tvCode;
    public MainActivity() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_main);
        init();
        initPhoenix();
        setFullScreen();
        initOnCLick();
        tvCode  = findViewById(R.id.tvCode);
        findViewById(R.id.tvOpen).setOnClickListener(v -> {
            openBowl();

//                if (this.flagShock) {
//                    if (this.flagHiddenBowl) {
//                        closeBowl();
//                        return;
//                    } else {
//                        openBowl(false, this.isChan);
//                        return;
//                    }
//                } else {
//                    return;
//                }
        });
        findViewById(R.id.tvRoll).setOnClickListener(v -> {
            closeBowl();
        });
//        if (XocDia2022App.share().getCode()==null||!checkExistCode(XocDia2022App.share().getCode())) {
//            XocDia2022App.share().setCode(this.arrayKey[randomValue(this.arrayKey.length)]);
//        }
        loadsDataFromServer();
    }

    private void init() {
//        ButterKnife.bind((Activity) this);
        startMusic(false);
//        this.musicShock = MediaPlayer.create(this, R.raw.xoc);
        this.gson = new GsonBuilder().create();
        Calendar.getInstance();
//        TextView textView = this.tvVersion;
//        textView.setText(" - " + XocDia2022App.share().getCode() + TypeInternet.INTERNET_ONLINE.getValue());
    }

    private void showHiddenResult(boolean z) {
        if (z) {
//            this.chan.setImageResource(R.drawable.chan_win);
        } else {
//            this.le.setImageResource(R.drawable.le_win);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        View decorView = getWindow().getDecorView();
        if (z) {
            decorView.setSystemUiVisibility(5894);
        }
    }

    private void loadsDataFromServer() {
        if (!this.flagInsertCode) {
            insertCode();
        } else {
            requestRule();
        }
    }

    private void requestRule() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", APPLICATION_ID);
            jSONObject.put("code", XocDia2022App.share().getCode());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ServerRequest.sharedInstance().postRequest(Constance.SERVER_GET_RULE, jSONObject, new RequestListener() {
            public void onSuccess(JSONObject jSONObject) {
                ObjectRule objectRule;
                MainActivity.this.checkInternet(true);
                try {
                    objectRule = (ObjectRule) MainActivity.this.gson.fromJson(jSONObject.getString("data"), ObjectRule.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                    objectRule = null;
                }
                MainActivity.this.saveDataLocal(objectRule);
                MainActivity.this.loadDataLocal();
            }

            public void onError(JSONObject jSONObject) {
                MainActivity.this.checkInternet(false);
            }
        });
    }

    /* access modifiers changed from: private */
    public void checkInternet(boolean z) {
        if (z) {
            if ((this.ruleChild || this.ruleMaster || this.ruleChildCode || this.ruleMasterCode) && ((long) this.endTime) > System.currentTimeMillis() / 1000) {
                setCodeGame(TypeInternet.OPEN_RULE);
            } else {
                setCodeGame(TypeInternet.INTERNET_ONLINE);
            }
        } else if ((this.ruleChild || this.ruleMaster || this.ruleChildCode || this.ruleMasterCode) && ((long) this.endTime) > System.currentTimeMillis() / 1000) {
            setCodeGame(TypeInternet.OPEN_RULE);
        } else {
            setCodeGame(TypeInternet.INTERNET_OFF);
        }
    }

    private String decodeRule() {
        String str = Constance.OFF_DAT;
//        if (Build.VERSION.SDK_INT >= 26) {
//            return new String(MainActivity$$ExternalSyntheticApiModelOutline0.m().decode(str.getBytes()));
//        }
        return new String(Base64.decode(str.getBytes(), 0));
    }

    private void setCodeGame(TypeInternet typeInternet) {
        if (typeInternet.getKey() == TypeInternet.INTERNET_OFF.getKey()) {
            if (!checkExistCode(XocDia2022App.share().getCode())) {
                XocDia2022App.share().setCode(this.arrayKey[randomValue(this.arrayKey.length)]);
            }
            this.isOffLine = true;
        } else {
            while (checkExistCode(XocDia2022App.share().getCode())) {
                XocDia2022App.share().createCode();
                this.flagInsertCode = false;
            }
            this.isOffLine = false;
        }
        if (typeInternet.getKey() == TypeInternet.OPEN_RULE.getKey()) {
//            TextView textView = this.tvVersion;
//            textView.setText(" - " + XocDia2022App.share().getCode() + TypeInternet.OPEN_RULE.getValue());
        } else if (this.isOffLine) {
//            TextView textView2 = this.tvVersion;
//            textView2.setText(" - " + XocDia2022App.share().getCode() + getKeyOffLineCheckHack() + TypeInternet.INTERNET_OFF.getValue());
        } else {
//            TextView textView3 = this.tvVersion;
//            textView3.setText(" - " + XocDia2022App.share().getCode() + TypeInternet.INTERNET_ONLINE.getValue());
        }
    }

    private String getKeyOffLineCheckHack() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(5) + instance.get(2);
        return this.arrayKeyOff[(i + instance.get(11)) % 25];
    }

    private String insertTextDot(String str) {
        String str2 = "";
        ArrayList arrayList = new ArrayList(Arrays.asList(str.split(str2)));
        arrayList.removeAll(Arrays.asList(new String[]{str2, null}));
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 2 || i == 5) {
                str2 = str2 + ((String) arrayList.get(i)) + ".";
            } else {
                str2 = str2 + ((String) arrayList.get(i));
            }
        }
        return str2;
    }

    private boolean checkExistCode(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.arrayKey;
            if (i >= strArr.length) {
                return false;
            }
            if (str.equalsIgnoreCase(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    private ArrayList<Integer> parserStringToArray(String str) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (str.trim().isEmpty()) {
            return arrayList;
        }
        String[] split = str.split(",");
        if (split.length > 0) {
            for (int i = 0; i < split.length; i++) {
                if (!split[i].trim().equalsIgnoreCase("")) {
                    arrayList.add(Integer.valueOf(split[i].trim()));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void saveDataLocal(ObjectRule objectRule) {
        XocDia2022App.share().setArrLe(parserStringToArray(objectRule.getStrArrLe()));
        XocDia2022App.share().setArrChan(parserStringToArray(objectRule.getStrArrChan()));
        XocDia2022App.share().setArrPos(parserStringToArray(objectRule.getPositions()));
        XocDia2022App.share().setRuleChild(objectRule.isOnRuleChild());
        XocDia2022App.share().setRuleMaster(objectRule.isOnRuleMaster());
        XocDia2022App.share().setEndTime(objectRule.getEndTime());
        XocDia2022App.share().setDiv(objectRule.getDiv());
        XocDia2022App.share().setRuleMasterCode(objectRule.isOnRuleMasterCode());
        XocDia2022App.share().setRuleChildCode(objectRule.isOnRuleChildCode());
        XocDia2022App.share().setRandom(objectRule.getRandomNumber());
    }

    private void insertCode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", APPLICATION_ID);
            jSONObject.put("code", XocDia2022App.share().getCode());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ServerRequest.sharedInstance().postRequest(Constance.SERVER_INSERT_CODE, jSONObject, new RequestListener() {
            public void onSuccess(JSONObject jSONObject) {
                boolean unused = MainActivity.this.flagInsertCode = true;
            }

            public void onError(JSONObject jSONObject) {
                MainActivity.this.checkInternet(false);
            }
        });
    }

    private void insertNumberClick() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", APPLICATION_ID);
            jSONObject.put("code", XocDia2022App.share().getCode());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ServerRequest.sharedInstance().postRequest(Constance.SERVER_UPDATE_NUMBER, jSONObject, new RequestListener() {
            public void onSuccess(JSONObject jSONObject) {
                MainActivity.this.checkInternet(true);
            }

            public void onError(JSONObject jSONObject) {
                MainActivity.this.checkInternet(false);
            }
        });
    }

    private void initOnCLick() {
//        this.btnXoc.setOnClickListener(this);
//        this.btnChan.setOnClickListener(this);
//        this.btnExist.setOnClickListener(this);
//        this.btnMusic.setOnClickListener(this);
    }

    private void showHiddenBg(boolean z) {
//        if (z) {
//            this.chan.setImageResource(R.drawable.chan_win);
//        } else {
//            this.le.setImageResource(R.drawable.le_win);
//        }
//        showHiddenResult(z);
    }

    private void closeBowl() {
        this.flagHiddenBowl = false;
//        this.chan.setImageResource(R.drawable.chan);
//        this.le.setImageResource(R.drawable.le);
        setTextCode();
        effectVisibilityBowl();
//        this.btnXoc.setImageResource(R.drawable.mo);
    }

    private void openBowl() {
        this.flagHiddenBowl = true;
//        disPlayVi(z2);
//        showHiddenBg(z2);
        effectHiddenBowl();
        loadsDataFromServer();
        insertNumberClick();
//        setPosBall(z2);
//        this.btnXoc.setImageResource(R.drawable.xoc);
    }
    private void openBowl(boolean z, boolean z2) {
        this.flagHiddenBowl = true;
        disPlayVi(z2);
        showHiddenBg(z2);
        effectHiddenBowl();
        loadsDataFromServer();
        insertNumberClick();
        setPosBall(z2);
//        this.btnXoc.setImageResource(R.drawable.xoc);
    }

    private void effectHiddenBowl() {
        this.flagShock = false;
//        this.bowl.animate().translationY((float) (-(this.bowl.getHeight() * 2))).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
//            public void onAnimationEnd(Animator animator) {
//                super.onAnimationEnd(animator);
//                MainActivity.this.bowl.setVisibility(8);
//                boolean unused = MainActivity.this.flagShock = true;
//            }
//        });
    }

    private void effectVisibilityBowl() {
        this.flagShock = false;
//        this.musicShock.start();
//        setBowl();
//        this.bowl.setVisibility(0);
//        this.bowl.setAlpha(1.0f);
//        this.bowl.animate().translationY(0.0f).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
//            public void onAnimationEnd(Animator animator) {
//                super.onAnimationEnd(animator);
//                Animation loadAnimation = AnimationUtils.loadAnimation(MainActivity.this.getApplicationContext(), R.anim.shake);
//                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
//                    public void onAnimationRepeat(Animation animation) {
//                    }
//
//                    public void onAnimationStart(Animation animation) {
//                    }
//
//                    public void onAnimationEnd(Animation animation) {
//                        boolean unused = MainActivity.this.flagShock = true;
//                    }
//                });
//                MainActivity.this.bowlDisk.startAnimation(loadAnimation);
//            }
//        });
    }

    private int randomValue(int i) {
        return new Random().nextInt(i);
    }

    private void disPlayVi(boolean z) {
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(4);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(1);
        arrayList2.add(3);
        arrayList2.add(5);
        if (z) {
            i = ((Integer) arrayList.get(randomValue(3))).intValue();
        } else {
            i = ((Integer) arrayList2.get(randomValue(3))).intValue();
        }
        ArrayList arrayList3 = new ArrayList();
//        arrayList3.add(this.point1);
//        arrayList3.add(this.point2);
//        arrayList3.add(this.point3);
//        arrayList3.add(this.point4);
        if (i == 0 || i == 4) {
            int randomValue = randomValue(5);
            if (randomValue == 0) {
                while (i2 < arrayList3.size()) {
                    setViVang((ImageView) arrayList3.get(i2));
                    i2++;
                }
            } else if (randomValue == 4) {
                while (i2 < arrayList3.size()) {
//                    ((ImageView) arrayList3.get(i2)).setImageResource(R.drawable.vi_1);
                    i2++;
                }
            } else {
                displayXap2(arrayList3);
            }
        } else if (i == 2) {
            displayXap2(arrayList3);
        } else {
            displayLe(arrayList3);
        }
    }

    private void displayLe(ArrayList<ImageView> arrayList) {
        int randomValue = randomValue(arrayList.size());
        int i = 0;
        if (randomValue(20) % 2 == 0) {
            setViVang(arrayList.get(randomValue));
            arrayList.remove(randomValue);
            while (i < arrayList.size()) {
//                arrayList.get(i).setImageResource(R.drawable.vi_1);
                i++;
            }
            return;
        }
//        arrayList.get(randomValue).setImageResource(R.drawable.vi_1);
        arrayList.remove(randomValue);
        while (i < arrayList.size()) {
            setViVang(arrayList.get(i));
            i++;
        }
    }

    private void displayXap2(ArrayList<ImageView> arrayList) {
        int randomValue = randomValue(arrayList.size());
//        arrayList.get(randomValue).setImageResource(R.drawable.vi_1);
        arrayList.remove(randomValue);
        int randomValue2 = randomValue(arrayList.size());
//        arrayList.get(randomValue2).setImageResource(R.drawable.vi_1);
        arrayList.remove(randomValue2);
        for (int i = 0; i < arrayList.size(); i++) {
            setViVang(arrayList.get(i));
        }
    }

    private void setFullScreen() {
        if (Build.VERSION.SDK_INT >= 30) {
            getWindow().setDecorFitsSystemWindows(false);
            WindowInsetsController m = getWindow().getInsetsController();
            if (m != null) {
//                m.hide(MainActivity$$ExternalSyntheticApiModelOutline0.m() | WindowInsets.Type.navigationBars());
//                m.setSystemBarsBehavior(2);
                return;
            }
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(3846);
    }

    /* access modifiers changed from: private */
    public void loadDataLocal() {
        this.ruleChild = XocDia2022App.share().isRuleChild();
        this.ruleMaster = XocDia2022App.share().isRuleMaster();
        this.endTime = XocDia2022App.share().getEndTime();
        this.arrPos = new ArrayList<>();
        this.arrChan = new ArrayList<>();
        this.arrLe = new ArrayList<>();
        this.arrPos = XocDia2022App.share().getArrPos();
        this.arrChan = XocDia2022App.share().getArrChan();
        this.arrLe = XocDia2022App.share().getArrLe();
        this.div = XocDia2022App.share().getDiv();
        this.random = XocDia2022App.share().getRandom();
        this.ruleChildCode = XocDia2022App.share().isRuleChildCode();
        this.ruleMasterCode = XocDia2022App.share().isRuleMasterCode();
    }

    private void setTextCode() {
        ObjectOff objectOff;
        int i;
        this.tvCode.setText("");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        String str = "";
        for (int i3 = 0; i3 < this.NUMBER_CODE; i3++) {
            int randomValue = randomValue(10);
            arrayList.add(Integer.valueOf(randomValue));
            str = str + String.valueOf(randomValue);
        }
        this.tvCode.setText(insertTextDot(str.trim()));
        if ((this.ruleChild || this.ruleChildCode) && ((long) this.endTime) > System.currentTimeMillis() / 1000) {
            if (this.arrPos.size() > 0) {
                i = 0;
                for (int i4 = 0; i4 < this.arrPos.size(); i4++) {
                    i += ((Integer) arrayList.get(this.arrPos.get(i4).intValue())).intValue();
                }
            } else {
                i = 0;
            }
            int i5 = i % this.div;
            this.isChan = false;
            if (this.arrChan.size() != 0 && i5 != this.random) {
                while (i2 < this.arrChan.size()) {
                    if (this.arrChan.get(i2).intValue() == i5) {
                        this.isChan = true;
                        return;
                    }
                    i2++;
                }
            } else if (randomValue(999) % 2 == 0) {
                this.isChan = true;
            }
        } else if (this.isOffLine) {
            try {
                Calendar instance = Calendar.getInstance();
                objectOff = getRuleOff(XocDia2022App.share().getCode(), (((instance.get(5) + instance.get(2)) + instance.get(11)) % 13) + "");
            } catch (JSONException e) {
                e.printStackTrace();
                objectOff = null;
            }
            if (objectOff != null) {
                String[] split = objectOff.getStrPositions().split(",");
                int i6 = 0;
                for (String parseInt : split) {
                    i6 += ((Integer) arrayList.get(Integer.parseInt(parseInt))).intValue();
                }
                int div2 = i6 % objectOff.getDiv();
                this.isChan = false;
                String[] split2 = objectOff.getStrArrChan().split(",");
                if (split2.length != 0 && div2 != objectOff.getRandom()) {
                    while (i2 < split2.length) {
                        if (split2[i2].equalsIgnoreCase(div2 + "")) {
                            this.isChan = true;
                            return;
                        }
                        i2++;
                    }
                } else if (randomValue(999) % 2 == 0) {
                    this.isChan = true;
                }
            } else if (randomValue(999) % 2 == 0) {
                this.isChan = true;
            } else {
                this.isChan = false;
            }
        } else if (randomValue(999) % 2 == 0) {
            this.isChan = true;
        } else {
            this.isChan = false;
        }
    }

    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.back /*2131230807*/:
//                finish();
//                return;
//            case R.id.btn_chan /*2131230820*/:
//                if (this.flagShock) {
//                    if (this.flagHiddenBowl) {
//                        closeBowl();
//                        return;
//                    }
//                    if ((this.ruleMaster || this.ruleMasterCode) && ((long) this.endTime) > System.currentTimeMillis() / 1000) {
//                        this.isChan = !this.isChan;
//                    }
//                    openBowl(false, this.isChan);
//                    return;
//                }
//                return;
//            case R.id.btn_xoc_mo /*2131230821*/:
//                if (this.flagShock) {
//                    if (this.flagHiddenBowl) {
//                        closeBowl();
//                        return;
//                    } else {
//                        openBowl(false, this.isChan);
//                        return;
//                    }
//                } else {
//                    return;
//                }
//            case R.id.music /*2131231030*/:
////                if (((BitmapDrawable) this.btnMusic.getDrawable()).getBitmap() == ((BitmapDrawable) getResources().getDrawable(R.drawable.mute)).getBitmap()) {
////                    onOffMusic(true);
////                    return;
////                } else {
////                    onOffMusic(false);
////                    return;
////                }
//            default:
//                return;
//        }
    }

    private ObjectOff getRuleOff(String str, String str2) throws JSONException {
        return (ObjectOff) this.gson.fromJson(new JSONObject(decodeRule()).getJSONObject(str).getString(str2), ObjectOff.class);
    }

    /* access modifiers changed from: private */
    public void initPhoenix() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        Random random2 = new Random();
        int nextInt = random2.nextInt(i) - 100;
        int nextInt2 = random2.nextInt(i2) - 200;
        TranslateAnimation translateAnimation = new TranslateAnimation((float) this.currentX, (float) nextInt, (float) this.currentY, (float) nextInt2);
        translateAnimation.setDuration(7000);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setRepeatMode(1);
        this.currentX = nextInt;
        this.currentY = nextInt2;
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                MainActivity.this.initPhoenix();
            }
        });
//        this.phoenix.startAnimation(translateAnimation);
    }

//    private void setBowl() {
//        this.bowl.setImageResource(R.drawable.bat);
//    }

    private void setViVang(ImageView imageView) {

//        imageView.setImageResource(R.drawable.vi_2);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        stopMusic();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        startMusic(true);
    }

    private void onOffMusic(boolean z) {
//        if (z) {
//            this.btnMusic.setImageDrawable(getResources().getDrawable(R.drawable.loa));
//            startMusic(true);
//            return;
//        }
//        this.btnMusic.setImageDrawable(getResources().getDrawable(R.drawable.mute));
//        stopMusic();
    }

    private void startMusic(boolean z) {
//        if (this.musicBg == null) {
//            this.musicBg = MediaPlayer.create(this, R.raw.nhac_nen);
//        }
//        if (z) {
//            this.musicBg.seekTo(this.continueMedia);
//            this.musicBg.start();
//            return;
//        }
//        this.musicBg.start();
//        this.musicBg.setLooping(true);
    }

    private void stopMusic() {
//        this.musicBg.pause();
//        this.continueMedia = this.musicBg.getCurrentPosition();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    private void setPosBall(boolean z) {
//        int i = this.pos;
//        if (i < 12) {
//            this.pos = i + 1;
//        } else {
//            this.pos = 1;
//            this.x2.setImageResource(R.drawable.trang);
//            this.x3.setImageResource(R.drawable.trang);
//            this.x4.setImageResource(R.drawable.trang);
//            this.x5.setImageResource(R.drawable.trang);
//            this.x6.setImageResource(R.drawable.trang);
//            this.x7.setImageResource(R.drawable.trang);
//            this.x8.setImageResource(R.drawable.trang);
//            this.x9.setImageResource(R.drawable.trang);
//            this.x10.setImageResource(R.drawable.trang);
//            this.x11.setImageResource(R.drawable.trang);
//            this.x12.setImageResource(R.drawable.trang);
//        }
//        switch (this.pos) {
//            case 1:
//                setBall(this.x1, z);
//                return;
//            case 2:
//                setBall(this.x2, z);
//                return;
//            case 3:
//                setBall(this.x3, z);
//                return;
//            case 4:
//                setBall(this.x4, z);
//                return;
//            case 5:
//                setBall(this.x5, z);
//                return;
//            case 6:
//                setBall(this.x6, z);
//                return;
//            case 7:
//                setBall(this.x7, z);
//                return;
//            case 8:
//                setBall(this.x8, z);
//                return;
//            case 9:
//                setBall(this.x9, z);
//                return;
//            case 10:
//                setBall(this.x10, z);
//                return;
//            case 11:
//                setBall(this.x11, z);
//                return;
//            case 12:
//                setBall(this.x12, z);
//                return;
//            default:
//                return;
//        }
    }

    private void setBall(ImageView imageView, boolean z) {
//        if (z) {
//            imageView.setVisibility(0);
//            imageView.setImageResource(R.drawable.do1);
//            return;
//        }
//        imageView.setVisibility(0);
//        imageView.setImageResource(R.drawable.xanh);
    }
}
