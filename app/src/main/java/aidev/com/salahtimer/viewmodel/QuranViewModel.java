package aidev.com.salahtimer.viewmodel;

import android.content.Context;

import aidev.com.salahtimer.model.APIClientArabic;
import aidev.com.salahtimer.model.APIClientTimings;
import aidev.com.salahtimer.model.APIClientTransliteration;
import aidev.com.salahtimer.model.APITimingsInterface;
import aidev.com.salahtimer.model.RetrofitResponseListener;
import aidev.com.salahtimer.model.pojo.Quran_Ar_En;
import aidev.com.salahtimer.model.pojo.Quran_Transliteration;
import aidev.com.salahtimer.model.pojo.TimingsData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuranViewModel extends ViewModel {

    private Context activity;
    private APITimingsInterface api_ar_en = null, api_trans = null;
    private Quran_Ar_En arb;
    private Quran_Ar_En eng;
    private Quran_Transliteration trans;

    public QuranViewModel(Context activity){
        this.activity = activity;
    }

    private APITimingsInterface getAPI_Ar_en(){
        if(api_ar_en == null){
            api_ar_en = APIClientArabic.getClient().create(APITimingsInterface.class);
            return api_ar_en;
        }
        else return api_ar_en;
    }

    private APITimingsInterface getAPI_Transliteration(){
        if(api_trans == null){
            api_trans = APIClientTransliteration.getClient().create(APITimingsInterface.class);
            return api_trans;
        }
        else return api_trans;
    }

    public void getQuranArabicChapterwise(final RetrofitResponseListener retrofitResponseListener, int number){

        if(arb == null ){

            Call<Quran_Ar_En> call = getAPI_Ar_en().getQuranData(number);
            call.enqueue(new Callback<Quran_Ar_En>() {
                @Override
                public void onResponse(Call<Quran_Ar_En> call, Response<Quran_Ar_En> response) {

                    if(response.isSuccessful()){
                        arb = response.body();
                        retrofitResponseListener.onSuccess(arb);
                    }else {
                        retrofitResponseListener.onFailure();
                    }

                }

                @Override
                public void onFailure(Call<Quran_Ar_En> call, Throwable t) {
                    call.cancel();
                    retrofitResponseListener.onFailure();
                }
            });

        }
        else{
            retrofitResponseListener.onSuccess(arb);
        }
    }

    public void getQuranEnglishChapterwise(final RetrofitResponseListener retrofitResponseListener, int number){

        if(eng == null ){

            Call<Quran_Ar_En> call = getAPI_Ar_en().getQuranDataEnglishTranslation(number,"en");
            call.enqueue(new Callback<Quran_Ar_En>() {
                @Override
                public void onResponse(Call<Quran_Ar_En> call, Response<Quran_Ar_En> response) {

                    if(response.isSuccessful()){
                        eng = response.body();
                        retrofitResponseListener.onSuccess(eng);
                    }else {
                        retrofitResponseListener.onFailure();
                    }

                }

                @Override
                public void onFailure(Call<Quran_Ar_En> call, Throwable t) {
                    call.cancel();
                    retrofitResponseListener.onFailure();
                }
            });

        }
        else{
            retrofitResponseListener.onSuccess(eng);
        }
    }

    public void getQuranTransliterationChapterwise(final RetrofitResponseListener retrofitResponseListener, int number){

        if(trans == null ){

            Call<Quran_Transliteration> call = getAPI_Transliteration().getQuranDataEnglishTransliteration(number);
            call.enqueue(new Callback<Quran_Transliteration>() {
                @Override
                public void onResponse(Call<Quran_Transliteration> call, Response<Quran_Transliteration> response) {

                    if(response.isSuccessful()){
                        trans = response.body();
                        retrofitResponseListener.onSuccess(trans);
                    }else {
                        retrofitResponseListener.onFailure();
                    }

                }

                @Override
                public void onFailure(Call<Quran_Transliteration> call, Throwable t) {
                    call.cancel();
                    retrofitResponseListener.onFailure();
                }
            });

        }
        else{
            retrofitResponseListener.onSuccess(trans);
        }
    }

}
