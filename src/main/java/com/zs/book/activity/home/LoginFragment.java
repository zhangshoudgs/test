package com.zs.book.activity.home;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.zs.book.R;
import com.zs.book.base.BaseFragment;
import com.zs.book.model.bean.UserBean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * User: special
 * Date: 13-12-22
 * Time: 下午3:28
 * Mail: specialcyci@gmail.com
 */
public class LoginFragment extends BaseFragment {

    private EditText edit_phone_num;
    private EditText edit_password;
    private Button btn_login;
    private Tencent mTencent;
    private static final String SCOPE = "all";// 权限：读取用户信息并分享信息
    private UserInfo userInfo;

    @Override
    protected void init() {

        edit_phone_num = findViewBy(R.id.edit_phone_num);
        edit_password = findViewBy(R.id.edit_password);
        btn_login = findViewBy(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_splogin;
    }
    private IUiListener iUiListener = new IUiListener() {
        @Override
        public void onComplete(Object o) {
            try {
                initOpenidAndToken(new JSONObject(o.toString()));
                userInfo = new UserInfo(getActivity(), mTencent.getQQToken());
                userInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object o) {
                        try {
                            JSONObject jsonObject = new JSONObject(o.toString());
                            UserBean userBean = JSON.parseObject(jsonObject.toString(), UserBean.class);
                        } catch (JSONException e) {
                        }

                    }

                    @Override
                    public void onError(UiError uiError) {
                        Toast.makeText(activity, uiError.errorMessage, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {

                    }
                });
            } catch (JSONException e) {
            }
        }

        @Override
        public void onError(UiError uiError) {

        }

        @Override
        public void onCancel() {

        }
    };
    public void login()
    {
        mTencent = Tencent.createInstance("1105124117", getActivity());
        if (!mTencent.isSessionValid())
        {
            mTencent.login(this, SCOPE, iUiListener);
        }
    }
    public void initOpenidAndToken(JSONObject jsonObject) {
        try {
            String token = jsonObject.getString(Constants.PARAM_ACCESS_TOKEN);
            String expires = jsonObject.getString(Constants.PARAM_EXPIRES_IN);
            String openId = jsonObject.getString(Constants.PARAM_OPEN_ID);

            System.out.println("token"+token+"-------------"+openId);
            if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(expires)
                    && !TextUtils.isEmpty(openId)) {
                mTencent.setAccessToken(token, expires);
                mTencent.setOpenId(openId);
            }
        } catch(Exception e) {
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Tencent.onActivityResultData(requestCode, resultCode, data, iUiListener);
    }
}
