package com.bawei.js;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/*
 *@Auther:陈浩
 *@Date: 2019/7/4
 *@Time:10:39
 *@Description:${DESCRIPTION}
 * */
public class JavaScripts {

    @JavascriptInterface
    public void reload(Context context) {
        Toast.makeText(context, "aaa", Toast.LENGTH_SHORT).show();
    }

}
