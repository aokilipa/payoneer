package io.github.payoneer.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Identification {

    @SerializedName("longId")
    @Expose
    private String longId;
    @SerializedName("shortId")
    @Expose
    private String shortId;
    @SerializedName("transactionId")
    @Expose
    private String transactionId;

}
