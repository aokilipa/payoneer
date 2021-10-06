package io.github.payoneer.data.api;

import static okhttp3.logging.HttpLoggingInterceptor.Level.*;

import io.github.payoneer.BuildConfig;
import io.github.payoneer.data.model.ListResult;
import io.reactivex.rxjava3.core.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient client;
    private final ApiService apiService;

    private ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Endpoints.BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    private OkHttpClient httpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor())
                .build();
    }

    private HttpLoggingInterceptor loggingInterceptor() {
        return new HttpLoggingInterceptor()
                .setLevel(BuildConfig.DEBUG ? BODY : NONE);
    }

    public static ApiClient client() {
        if (client == null) {
            client = new ApiClient();
        }
        return client;
    }

    public Single<ListResult> fetchPaymentMethod() {
        return apiService.getListResult();
    }
}
