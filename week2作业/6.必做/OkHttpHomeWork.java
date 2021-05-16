package Week02.HomeWork;

import com.squareup.okhttp.*;

import java.io.IOException;

public class OkHttpHomeWork {
    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8808/test" ;
        OkHttpClient okHttpClient = new OkHttpClient() ;
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build() ;
        Call call = okHttpClient.newCall(request) ;
        Response response = call.execute();

        System.out.println("Result: " + response.isSuccessful());
        System.out.println("Server: " + response.header("Server"));
        System.out.println("ResponseBody: " + response.body().string());

    }
}
