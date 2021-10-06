package io.github.payoneer.binding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import io.github.payoneer.R;

public class BindingUtils {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        if (!url.isEmpty()) {
            Glide.with(view)
                    .load(url)
                    .fitCenter()
                    .placeholder(R.drawable.ic_logo_placeholder)
                    .into(view);
        }
    }
}
