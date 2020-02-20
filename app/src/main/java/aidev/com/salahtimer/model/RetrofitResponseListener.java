package aidev.com.salahtimer.model;

import aidev.com.salahtimer.model.pojo.TimingsData;

public interface RetrofitResponseListener {


    void onFailure();

    void onSuccess(TimingsData body);
}
