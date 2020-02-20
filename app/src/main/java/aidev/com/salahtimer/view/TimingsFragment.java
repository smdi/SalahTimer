package aidev.com.salahtimer.view;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.sdsmdg.tastytoast.TastyToast;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.RetrofitResponseListener;
import aidev.com.salahtimer.model.pojo.TimingsData;
import aidev.com.salahtimer.viewmodel.TimingsViewModel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

public class TimingsFragment extends Fragment {

    private String cityText, countryText;

    private TimingsViewModel tvm;
    private TimingsData timingsData;
    private TimingsData.Datum data;

    private TextView citycountry, timezone, sunrise, sunset, date, imsak, fajr, dhuhr, asrs, asrh, maghrib, isha, midnight;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timings_item,container ,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        cityText = getArguments().getString("city");
        countryText = getArguments().getString("country");

        tvm = ViewModelProviders.of(this, new TimingsFactory(getActivity(), cityText, countryText)).get(TimingsViewModel.class);

        initializer(view);

        tvm.getTimingsData(new RetrofitResponseListener() {
            @Override
            public void onFailure() {
                TastyToast.makeText(getActivity(),"No data found",Toast.LENGTH_SHORT,TastyToast.ERROR).show();
                Fragment fragment = new Location();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentstimingsitem,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

            @Override
            public void onSuccess(TimingsData body) {
                data = body.data;


                String coni = ""+countryText.toString().charAt(0);
                String citi = ""+cityText.toString().charAt(0);

                citycountry.setText(coni.toUpperCase() + countryText.toString().substring(1,countryText.toString().length())
                                    +" - " + citi.toUpperCase() + cityText.toString().substring(1,cityText.toString().length()));
                timezone.setText(data.meta.timezone);
                sunrise.setText(data.timings.sunrise);
                sunset.setText(data.timings.sunset);
                date.setText(data.date.date);
                imsak.setText(data.timings.imsak);
                fajr.setText(data.timings.fajr);
                dhuhr.setText(data.timings.dhuhr);
                asrh.setText(data.timings.asr);
                maghrib.setText(data.timings.magrib);
                isha.setText(data.timings.isha);
                midnight.setText(data.timings.midnight);
            }
        });

    }



    private void initializer(View view) {

        citycountry = view.findViewById(R.id.citycountry);
        timezone = view.findViewById(R.id.timezone);
        sunrise = view.findViewById(R.id.sunrise);
        sunset = view.findViewById(R.id.sunset);
        date = view.findViewById(R.id.date);
        imsak = view.findViewById(R.id.imsak);
        fajr = view.findViewById(R.id.fajr);
        dhuhr = view.findViewById(R.id.dhuhr);
        imsak = view.findViewById(R.id.imsak);
        fajr =view.findViewById(R.id.fajr);
        dhuhr =view.findViewById(R.id.dhuhr);
        asrh = view.findViewById(R.id.asrh);
        asrs = view.findViewById(R.id.asrh);
        maghrib = view.findViewById(R.id.maghrib);
        isha =view.findViewById(R.id.isha);
        midnight =view.findViewById(R.id.midnight);

    }



}
