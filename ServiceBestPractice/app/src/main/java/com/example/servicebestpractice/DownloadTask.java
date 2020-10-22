package com.example.servicebestpractice;

import android.os.AsyncTask;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class DownloadTask extends AsyncTask<String,Integer,Integer> {
    public static final int TYPE_SUCCESS=0;
    public static final int TYPE_FAILED=1;
    public static final int TYPE_PAUSED=2;
    public static final int TYPE_CANCELED=3;
    private DownloadListener downloadListener;
    private boolean isCanceled =false;
    private boolean isPaused =false;
    private int lastProgress;

    public DownloadTask(DownloadListener downloadListener){
        this.downloadListener=downloadListener;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        InputStream is = null;
        RandomAccessFile savedFile =null;
        File file = null;
        return null;
    }
}
