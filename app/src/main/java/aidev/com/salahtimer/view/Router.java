package aidev.com.salahtimer.view;


import android.os.Bundle;
import aidev.com.salahtimer.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import aidev.com.salahtimer.viewmodel.RouterViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;



public class Router extends AppCompatActivity {


    private RouterViewModel rvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router);

        rvm = new ViewModelProvider(this,
                new RouterFactory(getApplicationContext(),getFragementManagerObject(),Router.this)).get(RouterViewModel.class);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(rvm.getBottomNavbarObject());
        navigation.setSelectedItemId(R.id.salahtimings);

    }

    public  FragmentManager getFragementManagerObject(){
        return  getSupportFragmentManager();
    }


}
