package io.github.payoneer.data.api;

import io.github.payoneer.data.model.ListResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET(Endpoints.LIST_RESULT)
    Call<ListResult> getListResult();
}
