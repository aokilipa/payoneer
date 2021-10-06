package io.github.payoneer.ui.payment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.github.payoneer.data.api.ApiClient;
import io.github.payoneer.data.api.ApiResource;
import io.github.payoneer.data.model.ListResult;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.HttpException;

public class PaymentViewModel extends ViewModel {

    private Disposable disposable;

    private final MediatorLiveData<ApiResource<ListResult>> _listResultLiveData = new MediatorLiveData<>();
    public LiveData<ApiResource<ListResult>> listResultLiveData = _listResultLiveData;

    public void fetchPaymentMethods() {
        _listResultLiveData.postValue(ApiResource.loading(null));
        disposable = ApiClient.client()
                .fetchPaymentMethod()
                .subscribeOn(Schedulers.io())
                .subscribe(listResult -> {
                    _listResultLiveData.postValue(ApiResource.success(listResult, null));
                }, this::handleErrors);
    }

    private void handleErrors(Throwable throwable) {
        String message = "Something went wrong, please try again";
        if (throwable instanceof HttpException) {
            HttpException e = (HttpException) throwable;
            switch (e.code()) {
                case 500:
                    message = "Seems we are having problem connecting to the server, please try again later";
                    break;
                case 404:
                    message = "No records found, please check again later";
                    break;
            }
        }
        throwable.printStackTrace();
        _listResultLiveData.postValue(ApiResource.error(message, null));
    }

    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }
}
