package aidev.com.salahtimer.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.List;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.pojo.Quran_Ar_En;
import aidev.com.salahtimer.viewmodel.QuranViewModel;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class QuranChapterAdapter extends RecyclerView.Adapter<QuranChapterAdapter.ViewHolder> {

    private QuranViewModel quranViewModel;
    private Context ctx;
    private List<Quran_Ar_En.Datum> listitem;
    private List<String> listitem1;
    private int use;
    private String[] split;
    private SharedPreferences sh;
    private SharedPreferences.Editor editor;


    public QuranChapterAdapter(Context ctx, List<Quran_Ar_En.Datum> listitem, List<String> listitem1
            , QuranViewModel quranViewModel, int use) {
        this.listitem = listitem;
        this.ctx = ctx;
        this.listitem1 = listitem1;
        this.quranViewModel = quranViewModel;
        this.use  =use;
        this.split = split;
        sh = ctx.getSharedPreferences("QuranBookmark", Context.MODE_PRIVATE);
    }

    public QuranChapterAdapter(Context ctx, List<Quran_Ar_En.Datum> listitem, List<String> listitem1
            , QuranViewModel quranViewModel, int use, String[] split) {
        this.listitem = listitem;
        this.ctx = ctx;
        this.listitem1 = listitem1;
        this.quranViewModel = quranViewModel;
        this.use  =use;
        this.split = split;
        sh = ctx.getSharedPreferences("QuranBookmark", Context.MODE_PRIVATE);
    }

    @Override
    public QuranChapterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.quran_chapter_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        if(use == 1){
//            holder.content.setTypeface(Typeface.DEFAULT_BOLD);
//            holder.content.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
//        }
//        if(use != 1){
//            holder.content.setTypeface(Typeface.DEFAULT);
//            holder.content.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
//        }


        if(use == 0){

            holder.vno.setText("Data");

            holder.content.setText(""+listitem1.get(position));
        }

        if( use == 2){

            Quran_Ar_En.Datum data = listitem.get(position);

            holder.vno.setText(data.verseId);

            holder.content.setText(data.text);

            holder.cardView.setOnClickListener(view -> {

                startplayer();
//                TastyToast.makeText(ctx,"Bookmarked",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
                setBookmark(holder,ctx,split,Integer.parseInt(data.verseId),data.text);
            });

            checkandSetBookmark(holder,data.verseId,split[0]);
        }

        if(use == 3){

            int ind = position+1;
            holder.vno.setText(""+(position+1));

            holder.content.setText(listitem1.get(position));

            holder.cardView.setOnClickListener(view -> {

                startplayer();
//                holder.bookmark.setVisibility(View.VISIBLE);
//                TastyToast.makeText(ctx,"Bookmarked",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
                setBookmark(holder,ctx,split,ind,listitem1.get(position));
            });

            checkandSetBookmark(holder,""+ind,split[0]);
        }
    }

    private void checkandSetBookmark(ViewHolder holder, String verseId, String c) {


        String vno = ""+sh.getInt("verseno",1);
        String cno = ""+sh.getInt("chapterno",1);

        if(vno.equals(verseId) && cno.equals(c)){
            holder.bookmark.setVisibility(View.VISIBLE);
        }

    }


    private void setBookmark(ViewHolder holder, Context ctx, String[] split, int ind, String s) {


        holder.bookmark.setVisibility(View.INVISIBLE);



        editor = ctx.getSharedPreferences("QuranBookmark", Context.MODE_PRIVATE).edit();
        editor.putInt("chapterno", Integer.parseInt(split[0]));
        editor.putString("chaptername",split[5]);
        editor.putString("verses",split[2]);
        editor.putString("revealedat",split[4]);
        editor.putInt("verseno",ind);
        editor.putString("verse",s);
        editor.apply();

        checkandSetBookmark(holder, ""+ind, split[0]);
    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView vno, content;
        public ImageView bookmark, current, stop;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            vno = itemView.findViewById(R.id.vno);
            content = itemView.findViewById(R.id.content);
            cardView = itemView.findViewById(R.id.hadithbookmark);
            bookmark = itemView.findViewById(R.id.bookmark);

        }
    }

    private void startplayer() {

        final MediaPlayer mp = MediaPlayer.create(ctx ,R.raw.knock);
        mp.start();
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
