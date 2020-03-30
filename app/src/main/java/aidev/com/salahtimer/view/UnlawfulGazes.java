package aidev.com.salahtimer.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aidev.com.salahtimer.R;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UnlawfulGazes extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_unlawfulgazes,container,false);

    }
}
