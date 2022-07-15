package io.github.payoneer.ui.payment.input;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import io.github.payoneer.data.model.Applicable;
import io.github.payoneer.data.model.InputElement;
import io.github.payoneer.databinding.PaymentDetailFragmentBinding;

public class PaymentDetailFragment extends Fragment {

    private PaymentDetailFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PaymentDetailFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Applicable applicable = this.getArguments().getParcelable("applicable");

        List<InputElement> inputElements = applicable.getInputElements();

        if (inputElements != null && !inputElements.isEmpty()) {
            for (InputElement e : inputElements) {
                binding.rootLayout.addView(editText(e.getName()));
            }
        }

    }

    EditText editText(String hint) {
        EditText editText = new EditText(requireActivity());
        editText.setHint(hint);
        //editText.setInputType(type);
        return editText;
    }
}
