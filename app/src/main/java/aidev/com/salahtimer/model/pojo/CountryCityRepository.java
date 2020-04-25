package aidev.com.salahtimer.model.pojo;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

public class CountryCityRepository {

    private CountryCityDBTableDAO countryCityDBTableDAO;
    private LiveData<List<CountryCityDBTable>> allCC;


   public CountryCityRepository(Application application) {
        CountryCityDBRoomDatabase db = CountryCityDBRoomDatabase.getDatabase(application);
        countryCityDBTableDAO = db.countryCityDAO();
        allCC = countryCityDBTableDAO.getAllCC();
   }


   public LiveData<List<CountryCityDBTable>> getAllCC() {
        return allCC;
    }


    public void insert(CountryCityDBTable instance) {
        CountryCityDBRoomDatabase.databaseWriteExecutor.execute(() -> {
            countryCityDBTableDAO.insert(instance);
        });
    }



}
