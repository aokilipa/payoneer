package io.github.payoneer.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Interaction {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("reason")
    @Expose
    private String reason;
}
