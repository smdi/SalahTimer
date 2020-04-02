package aidev.com.salahtimer.model.pojo;



import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import androidx.room.Query;

@Dao
public interface HadithBookmarkDBTableDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HadithBookmarkDBTable hadithBookmarkDBTable);

    @Query("DELETE FROM HadithBookmarkDBTable")
    void deleteAll();

    @Query("DELETE FROM HadithBookmarkDBTable WHERE serail_no_of_hadith = :sno")
    void deleteParticular(int sno);

    @Query("SELECT * from HadithBookmarkDBTable WHERE bookmarked = :bmark")
    LiveData<List<HadithBookmarkDBTable>> getAllBookmarkedHadiths(int bmark);

    @Query("SELECT * from HadithBookmarkDBTable ORDER BY serail_no_of_hadith  ASC")
    LiveData<List<HadithBookmarkDBTable>> getAllHadiths();
}
