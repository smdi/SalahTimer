package aidev.com.salahtimer.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import aidev.com.salahtimer.R;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GhustKeAdaab extends Fragment {
    private List<AllahNamesInitialiser> arrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ghust_ke_adaab, container, false);
    }


}
