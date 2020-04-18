package aidev.com.salahtimer.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import aidev.com.salahtimer.R;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NamazAdapter extends ArrayAdapter<AllahNamesInitialiser> {

    public Context context;
    public List<AllahNamesInitialiser> quranlist;


    public NamazAdapter(@NonNull Context context, List<AllahNamesInitialiser> quranlist) {
        super(context, 0,quranlist);
        this.context = context;
        this.quranlist = quranlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;


        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_namaz_ke_dua ,parent,false);
        }


        final AllahNamesInitialiser curr = getItem(position);



        TextView dua_ka_naam = listItemView.findViewById(R.id.dua_ka_naam);
        TextView dua = listItemView.findViewById(R.id.dua);

        dua_ka_naam.setText(curr.getDua_ka_naam());

        dua.setText(curr.getDua_content());

        return listItemView;
    }

    @Override
    public int getCount() {
        return quranlist.size();
    }
}

