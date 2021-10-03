package io.github.payoneer.ui.payment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.github.payoneer.data.api.ApiClient;
import io.github.payoneer.data.model.ListResult;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PaymentViewModel extends ViewModel {

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>(false);
    public LiveData<Boolean> isLoading = _isLoading;

    private Disposable disposable;

    private final MediatorLiveData<ListResult> _listResultLiveData = new MediatorLiveData<>();
    LiveData<ListResult> listResultLiveData = _listResultLiveData;

    public void fetchPaymentMethods() {
        _isLoading.postValue(true);
        disposable = ApiClient.client()
                .fetchPaymentMethod()
                .subscribeOn(Schedulers.io())
                .subscribe(listResult -> {
                    _listResultLiveData.postValue(listResult);
                    _isLoading.postValue(false);
                }, throwable -> {
                    throwable.printStackTrace();
                    _isLoading.postValue(false);
                });
    }

    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }
}
