package com.example.uts_bookkeretadanhotel.model;

public class HistoryModel{

    private final String mIdBook;
    private final String mTanggal;
    private final String mRiwayat;
    private final String mTotal;
    private final int mImageResourceId;
    private static final int NO_IMAGE_PROVIDED = -1;

    public HistoryModel(String idBook, String tanggal, String riwayat, String total, int imageResourceId) {
        mIdBook = idBook;
        mTanggal = tanggal;
        mRiwayat = riwayat;
        mTotal = total;
        mImageResourceId = imageResourceId;
    }

    public String getIdBook() {
        return mIdBook;
    }

    public String getTanggal() {
        return mTanggal;
    }

    public String getRiwayat() {
        return mRiwayat;
    }

    public String getTotal() {
        return mTotal;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
