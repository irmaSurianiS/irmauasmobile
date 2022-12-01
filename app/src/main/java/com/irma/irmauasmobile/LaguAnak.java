package com.irma.irmauasmobile;

import android.os.Parcel;
import android.os.Parcelable;

public class LaguAnak implements Parcelable {
    private String nama, detail;
    private int photo, suara;

    public LaguAnak(){

    }

    protected LaguAnak(Parcel in) {
        nama = in.readString();
        detail = in.readString();
        photo = in.readInt();
        suara = in.readInt();
    }

    public static final Creator<LaguAnak> CREATOR = new Creator<LaguAnak>() {
        @Override
        public LaguAnak createFromParcel(Parcel in) {
            return new LaguAnak(in);
        }

        @Override
        public LaguAnak[] newArray(int size) {
            return new LaguAnak[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getSuara() {
        return suara;
    }

    public void setSuara(int suara) {
        this.suara = suara;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(detail);
        dest.writeInt(photo);
        dest.writeInt(suara);
    }
}