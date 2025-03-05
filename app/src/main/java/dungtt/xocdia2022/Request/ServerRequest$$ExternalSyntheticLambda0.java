package dungtt.xocdia2022.Request;

import android.os.Handler;
import org.json.JSONObject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServerRequest$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ServerRequest f$0;
    public final /* synthetic */ RequestListener f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ JSONObject f$4;
    public final /* synthetic */ Handler f$5;

    public /* synthetic */ ServerRequest$$ExternalSyntheticLambda0(ServerRequest serverRequest, RequestListener requestListener, String str, int i, JSONObject jSONObject, Handler handler) {
        this.f$0 = serverRequest;
        this.f$1 = requestListener;
        this.f$2 = str;
        this.f$3 = i;
        this.f$4 = jSONObject;
        this.f$5 = handler;
    }

    public final void run() {
        this.f$0.m33lambda$volleyJsonRequest$1$comdungttxocdia2022RequestServerRequest(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
