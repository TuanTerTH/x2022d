package dungtt.xocdia2022.objectReq;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectRule {
    @SerializedName("so_chia")
    @Expose
    private int div;
    @SerializedName("end_time")
    @Expose
    private int endTime;
    @SerializedName("bat_con")
    @Expose
    private boolean onRuleChild;
    @SerializedName("bat_con_code")
    @Expose
    private boolean onRuleChildCode;
    @SerializedName("bat_cai")
    @Expose
    private boolean onRuleMaster;
    @SerializedName("bat_cai_code")
    @Expose
    private boolean onRuleMasterCode;
    @SerializedName("positions")
    @Expose
    private String positions;
    @SerializedName("random_number")
    @Expose
    private int randomNumber;
    @SerializedName("arr_chan")
    @Expose
    private String strArrChan;
    @SerializedName("arr_le")
    @Expose
    private String strArrLe;

    public boolean isOnRuleChild() {
        return this.onRuleChild;
    }

    public boolean isOnRuleMaster() {
        return this.onRuleMaster;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public String getPositions() {
        return this.positions;
    }

    public boolean isOnRuleChildCode() {
        return this.onRuleChildCode;
    }

    public boolean isOnRuleMasterCode() {
        return this.onRuleMasterCode;
    }

    public String getStrArrChan() {
        return this.strArrChan;
    }

    public String getStrArrLe() {
        return this.strArrLe;
    }

    public int getDiv() {
        return this.div;
    }

    public int getRandomNumber() {
        return this.randomNumber;
    }
}
