package aidev.com.salahtimer.model.pojo;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface CountryCityDBTableDAO {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CountryCityDBTable countryCityDBTable);

    @Query("SELECT * from CountryCityDBTable")
    LiveData<List<CountryCityDBTable>> getAllCC();

}
