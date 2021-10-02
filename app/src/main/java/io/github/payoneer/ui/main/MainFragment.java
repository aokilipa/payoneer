package io.github.payoneer.ui.main;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.payoneer.R;
import io.github.payoneer.data.model.ListResult;
import io.github.payoneer.databinding.MainFragmentBinding;
import io.github.payoneer.ui.payment.PaymentMethodAdapter;

public class MainFragment extends Fragment {

    private MainViewModel viewModel;

    private MainFragmentBinding binding;
    private final PaymentMethodAdapter adapter = new PaymentMethodAdapter();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
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