package com.jd.business.http;

/**
 * Created by weip on 2019/2/20.
 */
public interface IHttpRequest {
    // 封装请求接口
    void setUrl(String url);
    void setData(byte[] data);
    void setListener(CallbackListener callbackListener);
    void execute();
}
