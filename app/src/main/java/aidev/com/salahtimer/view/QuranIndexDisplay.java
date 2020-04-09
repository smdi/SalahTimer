package aidev.com.salahtimer.view;



import android.content.Context;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;


import java.util.ArrayList;
import java.util.List;

import aidev.com.salahtimer.R;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class QuranIndexDisplay extends Fragment {

    private List<QuranInitialiser> arrayList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

            return inflater.inflate(R.layout.read,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

                arrayList = new ArrayList<>();

                for (int i = 1; i <= 114; i++) {

                    String message = QuranIndex.QuranIndexProfile.getIndexDisplay(i);
                    String[] array = message.split("@");
                    arrayList.add(new QuranInitialiser(array[0], array[1], array[2], array[3], array[4], array[5]));
                }

                QuranAdapter qa = new QuranAdapter(getActivity(), arrayList);

                ListView listView = (ListView) view.findViewById(R.id.listview);
                listView.setAdapter(qa);

                listView.setOnItemClickListener((adapterView, view1, i, l) -> {
                    //make a transaction to new fragment
                    movetoQuranChapter(i+1);
            });

    }


    private void movetoQuranChapter(int num){

            if(checkConnection()){
                Bundle bundle = new Bundle();
                bundle.putInt("number",num);
                Fragment fragment = new QuranChapter();
                fragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.quranindex,fragment).addToBackStack("chapter");
                fragmentTransaction.commit();
            }
            else { displayNoInternet("No Internet"); }
    }

    private boolean checkConnection() {


        ConnectivityManager connectivityManager = (ConnectivityManager)  getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;

        } else { return false; }

    }
    private void displayNoInternet(String msg) {
        TastyToast.makeText(getActivity(),msg,TastyToast.LENGTH_SHORT,TastyToast.DEFAULT).show();
    }
}
