package aidev.com.salahtimer.viewmodel;


import com.sdsmdg.tastytoast.TastyToast;

import aidev.com.salahtimer.model.APIClientTimings;
import aidev.com.salahtimer.model.APITimingsInterface;
import aidev.com.salahtimer.model.RetrofitResponseListener;
import aidev.com.salahtimer.model.pojo.TimingsData;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimingsViewModel extends ViewModel {

    private String city, country;
    private FragmentActivity application;
    private APITimingsInterface apiTimingsInterface = null;
    private TimingsData timingsData = null;

    public  TimingsViewModel(FragmentActivity application, String city, String country){
        this.application = application;
        this.city = city;
        this.country = country;
    }

    public APITimingsInterface getApiTimingsInterface(){
        if(apiTimingsInterface == null){
            return APIClientTimings.getClient().create(APITimingsInterface.class);
        }
        else return apiTimingsInterface;
    }

    public void getTimingsData(final RetrofitResponseListener retrofitResponseListener){
        if(timingsData == null){

            Call<TimingsData> call = getApiTimingsInterface().getTimingsData(city,country,"8");
            call.enqueue(new Callback<TimingsData>() {
                @Override
                public void onResponse(Call<TimingsData> call, Response<TimingsData> response) {


                    if(response.isSuccessful()){
                        timingsData = response.body();
                        retrofitResponseListener.onSuccess(timingsData);
                    }else {
                        retrofitResponseListener.onFailure();
                    }

                }

                @Override
                public void onFailure(Call<TimingsData> call, Throwable t) {
                    call.cancel();
                    retrofitResponseListener.onFailure();
                }
            });


        }
        else{
               retrofitResponseListener.onSuccess(timingsData);
        }
    }


}
