package dungtt.xocdia2022;

import android.app.Application;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
//import com.dungtt.xocdia2022.Util.RandomString;
import java.util.ArrayList;

import dungtt.xocdia2022.Util.RandomString;

public class XocDia2022App extends Application {
    public static final String TAG = "GAME_XD_2024";
    private static XocDia2022App instance;
    private ArrayList<Integer> arrChan;
    private ArrayList<Integer> arrLe;
    private ArrayList<Integer> arrPos;
    private String code;
    private int div;
    private int endTime;
    private RandomString gen;
    private RequestQueue mRequestQueue;
    private int random;
    private boolean ruleChild;
    private boolean ruleChildCode;
    private boolean ruleMaster;
    private boolean ruleMasterCode;

    public void onCreate() {
        super.onCreate();
        RandomString randomString = new RandomString(5);
        this.gen = randomString;
        instance = this;
        this.code = randomString.nextString();
    }

    public void createCode() {
        this.code = this.gen.nextString();
    }

    public static synchronized XocDia2022App share() {
        XocDia2022App xocDia2022App;
        synchronized (XocDia2022App.class) {
            xocDia2022App = instance;
        }
        return xocDia2022App;
    }

    public boolean isRuleChild() {
        return this.ruleChild;
    }

    public void setRuleChild(boolean z) {
        this.ruleChild = z;
    }

    public boolean isRuleMaster() {
        return this.ruleMaster;
    }

    public void setRuleMaster(boolean z) {
        this.ruleMaster = z;
    }

    public boolean isRuleChildCode() {
        return this.ruleChildCode;
    }

    public void setRuleChildCode(boolean z) {
        this.ruleChildCode = z;
    }

    public boolean isRuleMasterCode() {
        return this.ruleMasterCode;
    }

    public void setRuleMasterCode(boolean z) {
        this.ruleMasterCode = z;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public void setEndTime(int i) {
        this.endTime = i;
    }

    public ArrayList<Integer> getArrPos() {
        return this.arrPos;
    }

    public void setArrPos(ArrayList<Integer> arrayList) {
        this.arrPos = arrayList;
    }

    public ArrayList<Integer> getArrChan() {
        return this.arrChan;
    }

    public void setArrChan(ArrayList<Integer> arrayList) {
        this.arrChan = arrayList;
    }

    public ArrayList<Integer> getArrLe() {
        return this.arrLe;
    }

    public int getRandom() {
        return this.random;
    }

    public void setRandom(int i) {
        this.random = i;
    }

    public void setArrLe(ArrayList<Integer> arrayList) {
        this.arrLe = arrayList;
    }

    public int getDiv() {
        return this.div;
    }

    public void setDiv(int i) {
        this.div = i;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public RequestQueue getRequestQueue() {
        if (this.mRequestQueue == null) {
            RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(getCacheDir(), 1048576), new BasicNetwork((BaseHttpStack) new HurlStack()));
            this.mRequestQueue = requestQueue;
            requestQueue.start();
        }
        return this.mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request, String str) {
        if (TextUtils.isEmpty(str)) {
            str = TAG;
        }
        request.setTag(str);
        getRequestQueue().add(request);
    }
}
