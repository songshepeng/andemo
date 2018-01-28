package com.bwei.ssp.andemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.ssp.andemo.activity.LoginActivity;
import com.bwei.ssp.andemo.activity.Main2Activity;
import com.bwei.ssp.andemo.avtivityutils.BaseMainActivity;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseMainActivity {


    @InjectView(R.id.weixinlog)
    LinearLayout weixinlog;
    @InjectView(R.id.qqlogin)
    LinearLayout qqlogin;
    @InjectView(R.id.arraylogin)
    TextView arraylogin;
    private Tencent mTencent;
    private String APP_ID = "222222";
    private IUiListener loginListener;
    private String SCOPE = "all";
    // private Tencent instance;

    private IUiListener userInfoListener;
    private  String TAG;
    private UserInfo mUserInfo;
    @Override
    protected int getRootView() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);


    }

    @OnClick({R.id.weixinlog, R.id.qqlogin, R.id.arraylogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.weixinlog:
                Toast.makeText(MainActivity.this, "微信登录维护中", Toast.LENGTH_LONG).show();

                break;
            case R.id.qqlogin:
                initQqLogin();
                mTencent.login(MainActivity.this, SCOPE, loginListener);
                break;
            case R.id.arraylogin:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void initQqLogin() {
        mTencent = Tencent.createInstance(APP_ID, this);
        loginListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                //登录成功后回调该方法
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "response:" + o);
                JSONObject obj = (JSONObject) o;
                try {
                    String openID = obj.getString("openid");
                    String accessToken = obj.getString("access_token");
                    String expires = obj.getString("expires_in");
                    mTencent.setOpenId(openID);
                    mTencent.setAccessToken(accessToken, expires);
                    QQToken qqToken = mTencent.getQQToken();
                    mUserInfo = new UserInfo(getApplicationContext(), qqToken);
                    mUserInfo.getUserInfo(new IUiListener() {
                        @Override
                        public void onComplete(Object response) {
                            Log.e(TAG, "登录成功" + response.toString());
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            intent.putExtra("json", response.toString());
                            startActivity(intent);
                        }
                        @Override
                        public void onError(UiError uiError) {
                            Log.e(TAG, "登录失败" + uiError.toString());
                        }
                        @Override
                        public void onCancel() {
                            Log.e(TAG, "登录取消");
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(UiError uiError) {
                //登录失败后回调该方法
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                Log.e("LoginError:", uiError.toString());
            }

            @Override
            public void onCancel() {
                //取消登录后回调该方法
                Toast.makeText(MainActivity.this, "取消登录", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_LOGIN) {
            if (resultCode == -1) {
//                Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
//                Tencent.handleResultData(data, loginListener);

                Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
                Tencent.handleResultData(data, loginListener);
                UserInfo info = new UserInfo(this, mTencent.getQQToken());
                info.getUserInfo(userInfoListener);
            }
        }
    }
}
