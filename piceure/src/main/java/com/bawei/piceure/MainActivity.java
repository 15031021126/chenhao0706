package com.bawei.piceure;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.piceure.net.ApiService;
import com.bawei.piceure.net.HttpUntils;
import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.luck.picture.lib.config.PictureConfig.CHOOSE_REQUEST;

public class MainActivity extends AppCompatActivity {

    private PhotoPopupWindow photoPopupWindow;

    @BindView(R.id.pic)
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String one = SPUtils.getInstance().getString("one");

        Glide.with(getApplicationContext()).load(one).apply(new RequestOptions().circleCrop()).into(pic);

        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoPopupWindow = new PhotoPopupWindow(MainActivity.this, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 进入相册选择
                        photoPopupWindow.dismiss();//取消
                        PictureSelector.create(MainActivity.this)
                                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                                .maxSelectNum(1)// 最大图片选择数量 int
                                .minSelectNum(1)// 最小选择数量 int
                                .imageSpanCount(4)// 每行显示个数 int
                                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                                .previewImage(true)// 是否可预览图片 true or false
                                .forResult(CHOOSE_REQUEST);//结果回调onActivityResult code
                    }
                }, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 拍照
                        // 进入相册选择
                        photoPopupWindow.dismiss();
                        PictureSelector.create(MainActivity.this)
                                .openCamera(PictureMimeType.ofImage())
                                .forResult(1);
                    }
                });
                View rootView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
                photoPopupWindow.showAtLocation(rootView,
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CHOOSE_REQUEST:
                    try {
                        List<LocalMedia> localMedia = PictureSelector.obtainMultipleResult(data);
                        Log.e("123", "onActivityResult: " + "\n" + localMedia.size());

                        LocalMedia localMedia1 = localMedia.get(0);
                        //获取图片路径
                        final String path = localMedia1.getPath();
                        //转码
                        String encode = URLEncoder.encode(path, "utf-8");
                        Toast.makeText(this, encode, Toast.LENGTH_SHORT).show();
                        //新建文件图片
                        File file = new File(path);
                        Log.e("123", "onActivityResult: " + file.toString());
                        //文件转化成内存对象（请求体对象）0
                        final RequestBody requestBody = MultipartBody.create(MediaType.parse("image/*"), file);

                        MultipartBody.Part part = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
                        ApiService getcreate = HttpUntils.getInstance().getcreate(ApiService.class);

                        //请求
                        getcreate.onepic("15624026012001452", "1452", part)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(new Consumer<Bean>() {
                                    @Override
                                    public void accept(Bean responseBody) throws Exception {
                                        String s = responseBody.getHeadPath();
                                        Log.e("123", "accept: " + s);
                                        Glide.with(getApplicationContext()).load(s).apply(new RequestOptions().circleCrop()).into(pic);

                                        SPUtils instance = SPUtils.getInstance();
                                        instance.clear();
                                        instance.put("one", s);
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        Log.e("123", "accept: " + throwable.toString());
                                    }
                                });
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    if (resultCode == RESULT_OK) {
                        List<LocalMedia> localMedia = PictureSelector.obtainMultipleResult(data);
                        LocalMedia media = localMedia.get(0);
                        String path = media.getPath();
                        File file = new File(path);
                        RequestBody requestBody = MultipartBody.create(MediaType.parse("image/*"), file);
                        MultipartBody.Part image = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
                        ApiService getcreate = HttpUntils.getInstance().getcreate(ApiService.class);

                        getcreate.onepic("15623765783923377", "3377", image)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(new Consumer<Bean>() {
                                    @Override
                                    public void accept(Bean responseBody) throws Exception {
                                        String s = responseBody.getHeadPath();
                                        Log.e("123", "accept: " + s);
                                        //设置图片
                                        Glide.with(getApplicationContext()).load(s).apply(new RequestOptions().circleCrop()).into(pic);
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        Log.e("123", "accept: " + throwable.toString());
                                    }
                                });
                    }
                    break;

            }
        }
    }
}
