package com.jd.business.http;

import java.io.InputStream;

public interface CallbackListener {
    void onSuccess(InputStream inputStream);
    void onFalure();
}
