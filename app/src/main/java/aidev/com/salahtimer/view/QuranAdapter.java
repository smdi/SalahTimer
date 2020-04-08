package aidev.com.salahtimer.view;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aidev.com.salahtimer.R;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class QuranAdapter extends ArrayAdapter<QuranInitialiser> {

    public Context context;
    public List<QuranInitialiser> quranlist;

    public QuranAdapter(@NonNull Context context, List<QuranInitialiser> quranlist) {
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
         listItemView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_quran_index ,parent,false);
        }


        final QuranInitialiser curr = getItem(position);



            TextView chapterNo = listItemView.findViewById(R.id.chapterno);
            TextView chapterName = listItemView.findViewById(R.id.chaptername);
            TextView echapterName = listItemView.findViewById(R.id.echaptername);
            TextView ayahs = listItemView.findViewById(R.id.totalayahs);
            TextView language = listItemView.findViewById(R.id.language);
            TextView place = listItemView.findViewById(R.id.place);

            chapterNo.setText(curr.getChapterNo());
            echapterName.setText(curr.geteChapName());
            chapterName.setText(curr.getNameOfChapter());
            ayahs.setText(curr.getTotalAyahs());
            language.setText(curr.getLanguage());
            place.setText(curr.getPlace());

        return listItemView;
    }

    @Override
    public int getCount() {
        return quranlist.size();
    }
}
