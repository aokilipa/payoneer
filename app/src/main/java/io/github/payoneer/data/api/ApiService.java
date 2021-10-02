package io.github.payoneer.data.api;

import io.github.payoneer.data.model.ListResult;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET(Endpoints.LIST_RESULT)
    Single<ListResult> getListResult();
}
