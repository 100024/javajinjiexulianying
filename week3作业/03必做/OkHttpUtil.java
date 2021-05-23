package Week03.HomeWork.outbound.okhttp;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class OkHttpUtil {
    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8808/test" ;
        Response response = getResponse(url);

        System.out.println("Result: " + response.isSuccessful());
        System.out.println("Server: " + response.header("Server"));
        System.out.println("ResponseBody: " + response.body().string());

    }

    public static Response getResponse(String url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient() ;
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build() ;
        Call call = okHttpClient.newCall(request) ;
        return  call.execute();
    }
}
