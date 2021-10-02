package io.github.payoneer.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Applicable {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("grouping")
    @Expose
    private String grouping;
    @SerializedName("registration")
    @Expose
    private String registration;
    @SerializedName("recurrence")
    @Expose
    private String recurrence;
    @SerializedName("redirect")
    @Expose
    private Boolean redirect;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("selected")
    @Expose
    private Boolean selected;
    @SerializedName("inputElements")
    @Expose
    private List<InputElement> inputElements = null;
    @SerializedName("operationType")
    @Expose
    private String operationType;
    @SerializedName("contractData")
    @Expose
    private ContractData contractData;

}
