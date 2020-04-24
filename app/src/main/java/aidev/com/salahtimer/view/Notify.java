package aidev.com.salahtimer.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import aidev.com.salahtimer.R;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Notify extends Fragment {

    private ImageView imageView;
    private TextView head, body;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notify, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = (ImageView) view.findViewById(R.id.image);
        head = (TextView) view.findViewById(R.id.head);
        body = (TextView) view.findViewById(R.id.body);



        if(getArguments().getString("image")!=null){
            Glide.with(getActivity()).load(getArguments().getString("image")).into(imageView);
        }
        else {
            Glide.with(getActivity()).load(R.drawable.mosque).into(imageView);
        }

        head.setText(getArguments().getString("head"));

        body.setText(getArguments().getString("body"));

    }
}