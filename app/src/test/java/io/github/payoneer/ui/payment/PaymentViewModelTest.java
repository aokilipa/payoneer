package io.github.payoneer.ui.payment;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.github.payoneer.data.api.ApiClient;
import io.github.payoneer.data.model.ListResult;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observers.TestObserver;

@RunWith(MockitoJUnitRunner.class)
public class PaymentViewModelTest extends TestCase {

    ApiClient apiClient = Mockito.mock(ApiClient.class);

    @Test
    public void shouldCallFetchPaymentMethod() {
        ListResult listResult = new ListResult();
        Mockito.doReturn(Single.just(listResult))
                .when(apiClient)
                .fetchPaymentMethod();

        TestObserver<ListResult> testObserver = apiClient
                .fetchPaymentMethod()
                .test();

        testObserver
                .assertNoErrors()
                .assertValue(listResult);

        testObserver.dispose();
    }
}