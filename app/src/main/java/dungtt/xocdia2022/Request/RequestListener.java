package dungtt.xocdia2022.Request;

import org.json.JSONObject;

public interface RequestListener {
    void onError(JSONObject jSONObject);

    void onSuccess(JSONObject jSONObject);
}
