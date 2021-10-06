package io.github.payoneer.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.github.payoneer.data.model.Applicable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractData {

    @SerializedName("PAGE_ENVIRONMENT")
    @Expose
    private String pageEnvironment;
    @SerializedName("JAVASCRIPT_INTEGRATION")
    @Expose
    private String javascriptIntegration;
    @SerializedName("PAGE_BUTTON_LOCALE")
    @Expose
    private String pageButtonLocale;
}