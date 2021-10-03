package io.github.payoneer.ui.payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import io.github.payoneer.R;
import io.github.payoneer.databinding.MainFragmentBinding;
import io.github.payoneer.databinding.PaymentFragmentBinding;
import io.github.payoneer.ui.main.MainFragment;
import io.github.payoneer.ui.main.MainViewModel;

public class PaymentMethod extends Fragment {

    private PaymentViewModel viewModel;
    private PaymentFragmentBinding binding;
    private final PaymentMethodAdapter adapter = new PaymentMethodAdapter();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.payment_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PaymentViewModel.class);
        initBinding();
        viewModel.listResultLiveData.observe(getViewLifecycleOwner(), listResult -> {
                    binding.swipeRefresh.setRefreshing(false);
                    adapter.setData(listResult.getNetworks().getApplicable());
                }
        );
        viewModel.fetchPaymentMethods();
    }

    private void initBinding() {
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(viewModel);
        binding.recyclerPayment.setAdapter(adapter);
        binding.swipeRefresh.setOnRefreshListener(() -> {
            viewModel.fetchPaymentMethods();
        });
    }
}