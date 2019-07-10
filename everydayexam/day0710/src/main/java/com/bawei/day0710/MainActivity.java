package com.bawei.day0710;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bar1)
    ProgressBar bar1;
    @BindView(R.id.bt1)
    Button bt1;
    @BindView(R.id.b)
    RelativeLayout b;
    @BindView(R.id.bt2)
    Button bt2;
    private long offset = 0;
    private int len = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //开始下载

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUntils.getInstance().getcreate(ApiService.class).get()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Consumer<ResponseBody>() {
                            @Override
                            public void accept(ResponseBody responseBody) throws Exception {
                                InputStream inputStream = responseBody.byteStream();
                                //得到服务端文件的大小
                                long length = responseBody.contentLength();
                                //在本地创建空白文件并设置大小
                                String absolutePath = Environment.getDownloadCacheDirectory().getAbsolutePath();
                                File file = new File("absolutePath","aaa.png");
                                Log.e("123", "完毕: " +file.getName());

                                RandomAccessFile raf = new RandomAccessFile("temp.png", "r");
                                raf.setLength(length);
                                byte[] bt = new byte[1024];
                                while ((len = inputStream.read(bt, 0, 8192)) != -1) {
                                    raf.write(bt, 0, len);
                                }

                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.e("123", "accept: " + throwable);
                            }
                        });
            }
        });
        //暂停
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


}
