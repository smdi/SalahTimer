package aidev.com.salahtimer.view;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.pojo.Quran_Ar_En;
import aidev.com.salahtimer.viewmodel.QuranViewModel;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuranChapterAdapter extends RecyclerView.Adapter<QuranChapterAdapter.ViewHolder> {

    private QuranViewModel quranViewModel;
    private Context ctx;
    private List<Quran_Ar_En.Datum> listitem;
    private List<String> listitem1;
    private int use;


    public QuranChapterAdapter(Context ctx, List<Quran_Ar_En.Datum> listitem, List<String> listitem1
            , QuranViewModel quranViewModel, int use) {
        this.listitem = listitem;
        this.ctx = ctx;
        this.listitem1 = listitem1;
        this.quranViewModel = quranViewModel;
        this.use  =use;
    }

    @Override
    public QuranChapterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.quran_chapter_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        if(use == 1){
            holder.content.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        }
        if(use != 1){
            holder.content.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        }


        if(use == 0){

            holder.vno.setText("Data");

            holder.content.setText(""+listitem1.get(position));
        }

        if(use == 1 || use == 2){

            Quran_Ar_En.Datum data = listitem.get(position);



            holder.vno.setText(data.verseId);

            holder.content.setText(data.text);

        }

        if(use == 3){

            holder.vno.setText(""+(position+1));

            holder.content.setText(listitem1.get(position));

        }

    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView vno, content;
        public ImageView playpause, current, stop;

        public ViewHolder(View itemView) {
            super(itemView);

            vno = itemView.findViewById(R.id.vno);
            content = itemView.findViewById(R.id.content);
            current = itemView.findViewById(R.id.current);
            stop = itemView.findViewById(R.id.stop);
            playpause = itemView.findViewById(R.id.playpause);


        }
    }

    @Override
    public int getItemCount() {
        if (use == 0 || use == 3){
            return listitem1.size();
        }
        else {
            return listitem.size();
        }
    }


}
