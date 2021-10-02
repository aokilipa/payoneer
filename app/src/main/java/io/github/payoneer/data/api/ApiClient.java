package io.github.payoneer.data.api;

import io.github.payoneer.data.model.ListResult;
import io.reactivex.rxjava3.core.Single;
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
                .build();
        apiService = retrofit.create(ApiService.class);
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
