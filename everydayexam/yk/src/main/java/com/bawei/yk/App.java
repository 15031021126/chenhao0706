package com.bawei.yk;

import android.app.Application;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:11:37
 *@Description:${DESCRIPTION}
 * */public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        DiskCacheConfig cacheConfig = DiskCacheConfig.newBuilder(this)
//                .setBaseDirectoryPath(Environment.getDownloadCacheDirectory())
//                .setBaseDirectoryName("image/")
//                .build();

        ImagePipelineConfig pipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(DiskCacheConfig.newBuilder(this)
                        .setBaseDirectoryPath(Environment.getDownloadCacheDirectory())
                        .setBaseDirectoryName("cc/")
                        .build())
                .build();

        Fresco.initialize(this, pipelineConfig);
    }
}
