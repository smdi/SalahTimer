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

public class AllahNames extends Fragment {

    private List<AllahNamesInitialiser> arrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_allah_names, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayList = new ArrayList<>();

        for (int i = 1; i <= 99; i++) {

            String message = AllahSWT.Allah_ke_naam.getIndexDisplay(i);
            String[] array = message.split("@");
            arrayList.add(new AllahNamesInitialiser(array[1], array[0], array[2]));
        }


        AllahNamesAdapter qa = new AllahNamesAdapter(getActivity(), arrayList);

        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(qa);


    }
}