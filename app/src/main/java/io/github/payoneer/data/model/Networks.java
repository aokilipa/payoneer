package io.github.payoneer.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Networks {

    @SerializedName("applicable")
    @Expose
    private List<Applicable> applicable = null;
}
