package aidev.com.salahtimer.model;

import aidev.com.salahtimer.model.pojo.Quran_Ar_En;
import aidev.com.salahtimer.model.pojo.Quran_Transliteration;
import aidev.com.salahtimer.model.pojo.TimingsData;

public interface RetrofitResponseListener {


    void onFailure();

    void onSuccess(TimingsData body);

    void onSuccess(Quran_Ar_En body);

    void onSuccess(Quran_Transliteration body);
}
