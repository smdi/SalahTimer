package aidev.com.salahtimer.model.pojo;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface QuranBookmarkDBTableDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(QuranBookMarkDBTable instance);

    @Query("DELETE FROM QuranBookMarkDBTable")
    void deleteAll();

    @Query("DELETE FROM QuranBookMarkDBTable WHERE cno_vno = :sno")
    void deleteParticular(String sno);

    @Query("SELECT * from QuranBookMarkDBTable")
    LiveData<List<QuranBookMarkDBTable>> getAllBookmarkedQuran();

}
