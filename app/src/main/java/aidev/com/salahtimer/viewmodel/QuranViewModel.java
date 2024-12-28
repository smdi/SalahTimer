package aidev.com.salahtimer.viewmodel;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aidev.com.salahtimer.TransliterationData.TransLIteration;
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
    private List<Quran_Ar_En> arb;
    private List<Quran_Ar_En> eng;
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
    public void getQuranEnglishChapterwise(final RetrofitResponseListener retrofitResponseListener, int number){

        if(eng == null ){

            Call<List<Quran_Ar_En>> call = getAPI_Ar_en().getQuranDataEnglishTranslation(number);
            call.enqueue(new Callback<List<Quran_Ar_En>>() {
                @Override
                public void onResponse(Call<List<Quran_Ar_En>> call, Response<List<Quran_Ar_En>> response) {

                    if(response.isSuccessful()){
                        eng = response.body();
                        retrofitResponseListener.onSuccess(eng.get(0));
                    }else {
                        retrofitResponseListener.onFailure();
                    }
                }
                @Override
                public void onFailure(Call<List<Quran_Ar_En>> call, Throwable t) {
                    call.cancel();
                    retrofitResponseListener.onFailure();
                }
            });


        }
        else{
            retrofitResponseListener.onSuccess(eng.get(0));
        }
    }

    public void getQuranTransliterationChapterwise(final RetrofitResponseListener retrofitResponseListener, int number){

        if(trans == null ){

            try{

                Gson gson = new Gson();
                trans =
                        gson.fromJson(TransLIteration.getData(number).toString(), Quran_Transliteration.class);
                retrofitResponseListener.onSuccess(trans);
            }
            catch (Exception e){
                retrofitResponseListener.onFailure();
            }
        }
        else{
            retrofitResponseListener.onSuccess(trans);
        }
    }

}
