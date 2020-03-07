package aidev.com.salahtimer.view;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;


import com.sdsmdg.tastytoast.TastyToast;

import aidev.com.salahtimer.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class Location extends Fragment {


    private EditText city;
    private EditText country;
    private Button search;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_location,container ,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        city = view.findViewById(R.id.city);
        country = view.findViewById(R.id.country);
        search = view.findViewById(R.id.get_The_Results);
    }


    @Override
    public void onStart() {
        super.onStart();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startplayer();

                String cityText = city.getText().toString();
                String countryText = country.getText().toString();

                if(cityText.length() > 0  && countryText.length() > 0){
                    setCityCountry(cityText,countryText);
                }
                else {
                    TastyToast.makeText(getActivity(),"enter valid details",TastyToast.LENGTH_SHORT,TastyToast.CONFUSING).show();
                }
            }
        });

    }




    private void setCityCountry(String cityText, String countryText) {

        Bundle bundle = new Bundle();
        bundle.putString("city",cityText);
        bundle.putString("country",countryText);
        Fragment fragment = new TimingsFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.location,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    private void startplayer() {

        final MediaPlayer mp = MediaPlayer.create(getActivity() ,R.raw.knock);
        mp.start();
    }

}
