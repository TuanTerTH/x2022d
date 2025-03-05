package dungtt.xocdia2022.objectReq;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseRule {
    @SerializedName("data")
    @Expose
    private ObjectRule objectRule;
    @SerializedName("status")
    @Expose
    private Integer status;

    public Integer getStatus() {
        return this.status;
    }

    public ObjectRule getObjectRule() {
        return this.objectRule;
    }
}
