package com.wd.health;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.aa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "'点击", Toast.LENGTH_SHORT).show();
                IWXAPI wxapi = WXAPIFactory.createWXAPI(MainActivity.this,null);
                wxapi.registerApp("wxe3fcbe8a55cd33ff");
                PayReq req = new PayReq();
                req.appId           = "wxe3fcbe8a55cd33ff";//你的微信appid
                req.partnerId       = "1526061551";//商户号
                req.prepayId        = "wx22183652782717886112a3b31101194200";//预支付交易会话ID
                req.nonceStr        = "Pp1sFkftR7AtcQdT";//随机字符串
                req.timeStamp       = "1566470229";//时间戳
                req.packageValue    = "Sign=WXPay";//扩展字段,这里固定填写Sign=WXPay
                req.sign            = "F3F486C0E0318C7B90D72FD4771F2E9F";//签名
//              req.extData         = "app data"; // optional
                // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
                wxapi.sendReq(req);
            }
        });
    }
}
