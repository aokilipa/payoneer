package io.github.payoneer.data.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListResult {

    @SerializedName("links")
    private Links links;

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("operation")
    private String operation;

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("resultInfo")
    private String resultInfo;

    @SerializedName("returnCode")
    private ReturnCode returnCode;

    @SerializedName("status")
    private Status status;

    @SerializedName("interaction")
    private Interaction interaction;

    @SerializedName("identification")
    private Identification identification;

    @SerializedName("networks")
    private Networks networks;

    @SerializedName("operationType")
    private String operationType;

    @SerializedName("style")
    private Style style;

    @SerializedName("payment")
    private Payment payment;

    @SerializedName("integrationType")
    private String integrationType;
}
