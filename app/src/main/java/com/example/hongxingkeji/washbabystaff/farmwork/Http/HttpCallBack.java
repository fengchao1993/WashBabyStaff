package com.example.hongxingkeji.washbabystaff.farmwork.Http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseBean;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.LogUtils;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.StringUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.ParameterizedType;

import okhttp3.Call;

/**
 * Created by Lizhangfeng on 2016/1/16 0016.
 * Description: http回调
 * 对象解析
 */
public abstract class HttpCallBack<T> extends StringCallback {

    private Class<T> tClass;

    public HttpCallBack() {
        tClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        onFail("网络异常");
    }

    @Override
    public void onResponse(String response, int id) {

        if (StringUtils.isNotEmpty(response)) {

            LogUtils.e("服务器返回结果: " + response);

            try {

                BaseBean baseBean = JSON.parseObject(response, BaseBean.class);

                if ("200".equals(baseBean.resultcode)) {

                    if (StringUtils.isNotEmpty(baseBean.result))

                        onSuccess(JSON.parseObject(baseBean.result, tClass));
                    else
                        onFail("result is empty");

                } else {
                    onFail(baseBean.error);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                onFail("解析异常");
            }


        } else
            onFail("服务器返回内容为空");

    }

    public abstract void onSuccess(T result);

    public abstract void onFail(String errMsg);

}
