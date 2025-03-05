package dungtt.xocdia2022.objectReq;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectOff {
    @SerializedName("div")
    @Expose
    private int div;
    @SerializedName("random")
    @Expose
    private int random;
    @SerializedName("strArrChan")
    @Expose
    private String strArrChan;
    @SerializedName("strArrLe")
    @Expose
    private String strArrLe;
    @SerializedName("positions")
    @Expose
    private String strPositions;

    public int getRandom() {
        return this.random;
    }

    public String getStrPositions() {
        return this.strPositions;
    }

    public void setStrPositions(String str) {
        this.strPositions = str;
    }

    public String getStrArrChan() {
        return this.strArrChan;
    }

    public void setStrArrChan(String str) {
        this.strArrChan = str;
    }

    public String getStrArrLe() {
        return this.strArrLe;
    }

    public void setStrArrLe(String str) {
        this.strArrLe = str;
    }

    public int getDiv() {
        return this.div;
    }

    public void setDiv(int i) {
        this.div = i;
    }
}
