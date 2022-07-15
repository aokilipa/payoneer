package io.github.payoneer.ui.payment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.payoneer.data.model.Applicable;
import io.github.payoneer.databinding.ItemListPaymentBinding;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.PaymentViewHolder> {

    List<Applicable> applicableMethods = new ArrayList<>();
    OnItemClickListener listener;

    PaymentMethodAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListPaymentBinding binding = ItemListPaymentBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PaymentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        holder.bind(applicableMethods.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return applicableMethods.size();
    }

    public void setData(List<Applicable> applicables) {
        applicableMethods.clear();
        applicableMethods.addAll(applicables);
        notifyDataSetChanged();
    }


    protected static final class PaymentViewHolder extends RecyclerView.ViewHolder {
        private final ItemListPaymentBinding binding;

        public PaymentViewHolder(@NonNull ItemListPaymentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Applicable item, OnItemClickListener listener) {
            binding.setItem(item);
            binding.cardView.setOnClickListener(view -> listener.onClick(item));
        }
    }
}
