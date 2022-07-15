package io.github.payoneer.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.test.core.os.Parcelables;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Applicable implements Parcelable {

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

    public static final Creator<Applicable> CREATOR = new Creator<Applicable>() {
        @Override
        public Applicable createFromParcel(Parcel in) {
            return new Applicable(in);
        }

        @Override
        public Applicable[] newArray(int size) {
            return new Applicable[size];
        }
    };

    protected Applicable(Parcel in) {
        code = in.readString();
        label = in.readString();
        method = in.readString();
        grouping = in.readString();
        registration = in.readString();
        recurrence = in.readString();
        byte tmpRedirect = in.readByte();
        redirect = tmpRedirect == 0 ? null : tmpRedirect == 1;
        byte tmpSelected = in.readByte();
        selected = tmpSelected == 0 ? null : tmpSelected == 1;
        operationType = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(code);
        parcel.writeString(label);
        parcel.writeString(method);
        parcel.writeString(grouping);
        parcel.writeString(registration);
        parcel.writeString(recurrence);
        parcel.writeByte((byte) (redirect == null ? 0 : redirect ? 1 : 2));
        parcel.writeByte((byte) (selected == null ? 0 : selected ? 1 : 2));
        parcel.writeString(operationType);
    }
}
