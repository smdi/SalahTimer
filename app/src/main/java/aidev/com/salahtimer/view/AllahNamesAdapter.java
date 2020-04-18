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

public class AllahNamesAdapter extends ArrayAdapter<AllahNamesInitialiser> {

    public Context context;
    public List<AllahNamesInitialiser> quranlist;


    public AllahNamesAdapter(@NonNull Context context, List<AllahNamesInitialiser> quranlist) {
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
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_names ,parent,false);
            }


            final AllahNamesInitialiser curr = getItem(position);

            TextView no = listItemView.findViewById(R.id.sno);
            TextView englishName = listItemView.findViewById(R.id.enlishname);
            TextView arabicName = listItemView.findViewById(R.id.arabicname);
            TextView meaning = listItemView.findViewById(R.id.meaning);


            no.setText(""+(position+1));
            englishName.setText(curr.getEnglishName());
            arabicName.setText(curr.getArabicName());
            meaning.setText(curr.getMeaning());

            return listItemView;
    }

    @Override
    public int getCount() {
        return quranlist.size();
    }

}
