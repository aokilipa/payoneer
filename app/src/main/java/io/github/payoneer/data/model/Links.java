package io.github.payoneer.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Links {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("validation")
    @Expose
    private String validation;
}
