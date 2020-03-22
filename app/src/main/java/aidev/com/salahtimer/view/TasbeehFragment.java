package aidev.com.salahtimer.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import aidev.com.salahtimer.R;
import aidev.com.salahtimer.viewmodel.TasbeehViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


public class TasbeehFragment extends Fragment {


    private int count = 0;

    private TextView counttv;
    private ImageView add, subtract, reset;

    private TasbeehViewModel tasbeehViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tasbeeh,container ,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialiser(view);

        tasbeehViewModel = new ViewModelProvider(this).get(TasbeehViewModel.class);

        count = tasbeehViewModel.getTasbeehCount();

        counttv.setText(""+count);

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tasbeehViewModel.getTasbeehCount()>0){counttv.setText(""+tasbeehViewModel.minus());}
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counttv.setText(""+tasbeehViewModel.addCount());
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counttv.setText(""+tasbeehViewModel.reset());
            }
        });

    }

    private void initialiser(View view) {

        counttv = view.findViewById(R.id.counttasbeeh);
        add = view.findViewById(R.id.addtasbeehcount);
        subtract = view.findViewById(R.id.subtasbeehcount);
        reset = view.findViewById(R.id.resettasbeehcount);

    }

}
