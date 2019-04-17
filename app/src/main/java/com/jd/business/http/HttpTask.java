package com.jd.business.http;

import com.alibaba.fastjson.JSON;

public class HttpTask<T> implements Runnable{

    public HttpTask(T requestData,String url,IHttpRequest httpRequest,CallbackListener callbackListener){
        httpRequest.setUrl(url);
        httpRequest.setListener(callbackListener);
        String json = JSON.toJSONString(requestData);

    }

    @Override
    public void run() {

    }
}
