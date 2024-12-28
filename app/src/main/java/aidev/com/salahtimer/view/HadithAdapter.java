package aidev.com.salahtimer.view;


import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.pojo.HadithBookmarkDBTable;
import aidev.com.salahtimer.viewmodel.HadithBookmarkViewModel;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HadithAdapter extends RecyclerView.Adapter<HadithAdapter.ViewHolder>{


    private List<HadithBookmarkDBTable> listitem;
    private Context ctx;
    private HadithBookmarkViewModel hadithBookmarkViewModel;



    public HadithAdapter(Context ctx, List<HadithBookmarkDBTable> listitem, HadithBookmarkViewModel hadithBookmarkViewModel) {
        this.listitem = listitem;
        this.ctx = ctx;
        this.hadithBookmarkViewModel = hadithBookmarkViewModel;
    }

    @Override
    public HadithAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hadithlist,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        HadithBookmarkDBTable hadithBookmarkDBTable = listitem.get(position);

        holder.title.setText(hadithBookmarkDBTable.getSerail_no_of_hadith()+"\t\t"+hadithBookmarkDBTable.getTitle());

        holder.content.setText(hadithBookmarkDBTable.getContent());

        if(hadithBookmarkDBTable.getBookmarked() == 1){
            holder.selected.setVisibility(View.VISIBLE);
        }

        holder.cardView.setOnClickListener(view -> {

            if(hadithBookmarkDBTable.getBookmarked() == 1){
                hadithBookmarkViewModel.insert(new HadithBookmarkDBTable(hadithBookmarkDBTable.getSerail_no_of_hadith(),
                        hadithBookmarkDBTable.getTitle(),hadithBookmarkDBTable.getContent(),0));

            }
            else{
                hadithBookmarkViewModel.insert(new HadithBookmarkDBTable(hadithBookmarkDBTable.getSerail_no_of_hadith(),
                        hadithBookmarkDBTable.getTitle(),hadithBookmarkDBTable.getContent(),1));

            }
            SharedPreferences.Editor editor = ctx.getSharedPreferences("HadithSNO", Context.MODE_PRIVATE).edit();
            editor.putInt("hno",hadithBookmarkDBTable.getSerail_no_of_hadith());
            editor.apply();

        });


    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView title,content;
        public ImageView selected;
        public CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            selected = itemView.findViewById(R.id.selected);
            cardView = itemView.findViewById(R.id.hadithbookmark);

        }
    }

}
