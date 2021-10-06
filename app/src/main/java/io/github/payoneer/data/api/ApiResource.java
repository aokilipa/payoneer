package io.github.payoneer.data.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.github.payoneer.data.ApiState;


public class ApiResource<T> {
    @NonNull
    public final ApiState status;
    @Nullable
    public final T data;
    @Nullable
    public final String message;

    private ApiResource(@NonNull ApiState status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }


    public static <T> ApiResource<T> success(@NonNull T data, @Nullable String message) {
        return new ApiResource<>(ApiState.SUCCESS, data, message);
    }

    public static <T> ApiResource<T> error(String message, @Nullable T data) {
        return new ApiResource<>(ApiState.ERROR, data, message);
    }

    public static <T> ApiResource<T> loading(@Nullable T data) {
        return new ApiResource<>(ApiState.LOADING, data, null);
    }
}


