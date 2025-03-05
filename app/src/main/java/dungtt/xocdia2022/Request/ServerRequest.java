package dungtt.xocdia2022.Request;

import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.Executors;

import dungtt.xocdia2022.XocDia2022App;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerRequest {
    private static ServerRequest mInstance;
    /* access modifiers changed from: private */
    public int SUCCESS_CODE = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    private String TAG = "ServerRequest";

    private ServerRequest init() {
        return this;
    }

    static /* synthetic */ void lambda$volleyJsonRequest$0() {
    }

    private ServerRequest() {
    }

    public static ServerRequest sharedInstance() {
        if (mInstance == null) {
            mInstance = new ServerRequest();
        }
        return mInstance.init();
    }

    private void jsonRequest(String str, int i, JSONObject jSONObject, Response.Listener listener, Response.ErrorListener errorListener, String str2) {
        if (i == 0) {
            Iterator<String> keys = jSONObject.keys();
            StringBuilder sb = new StringBuilder();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    sb.append(URLEncoder.encode(next, "utf-8"));
                    sb.append('=');
                    sb.append(URLEncoder.encode(jSONObject.getString(next), "utf-8"));
                    sb.append(Typography.amp);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (!sb.toString().isEmpty()) {
                str = str + "&" + sb.toString().substring(0, sb.toString().length() - 1);
            }
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(i, str, jSONObject, listener, errorListener);
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(40000, 1, 1.0f));
        XocDia2022App.share().addToRequestQueue(jsonObjectRequest, str2);
    }

    public void postRequest(String str, JSONObject jSONObject, RequestListener requestListener) {
        volleyJsonRequest(str, 1, jSONObject, requestListener);
    }

    private void volleyJsonRequest(String str, int i, JSONObject jSONObject, RequestListener requestListener) {
        Executors.newSingleThreadExecutor().execute(new ServerRequest$$ExternalSyntheticLambda0(this, requestListener, str, i, jSONObject, new Handler(Looper.getMainLooper())));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$volleyJsonRequest$1$com-dungtt-xocdia2022-Request-ServerRequest  reason: not valid java name */
    public /* synthetic */ void m33lambda$volleyJsonRequest$1$comdungttxocdia2022RequestServerRequest(final RequestListener requestListener, String str, int i, JSONObject jSONObject, Handler handler) {
        jsonRequest(str, i, jSONObject, new Response.Listener() {
            public void onResponse(Object obj) {
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    try {
                        if (jSONObject.getInt(NotificationCompat.CATEGORY_STATUS) == ServerRequest.this.SUCCESS_CODE) {
                            requestListener.onSuccess(jSONObject);
                        } else {
                            requestListener.onError(jSONObject);
                        }
                    } catch (JSONException unused) {
                        requestListener.onError(jSONObject);
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("error_common", true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    requestListener.onError(jSONObject2);
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                requestListener.onError((JSONObject) null);
            }
        }, this.TAG);
        handler.post(new ServerRequest$$ExternalSyntheticLambda1());
    }
}
