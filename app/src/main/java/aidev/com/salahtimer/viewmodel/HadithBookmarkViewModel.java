package aidev.com.salahtimer.viewmodel;

import android.app.Application;

import java.util.List;

import aidev.com.salahtimer.model.pojo.HadithBookmarkDBTable;
import aidev.com.salahtimer.model.pojo.HadithBookmarkRepository;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class HadithBookmarkViewModel extends AndroidViewModel {

    private HadithBookmarkRepository mRepository;

    private LiveData<List<HadithBookmarkDBTable>> allHadiths,bookmark;

    public HadithBookmarkViewModel (Application application) {
        super(application);
        mRepository = new HadithBookmarkRepository(application);
        allHadiths = mRepository.getAllHadiths();
        bookmark = mRepository.getAllBookmarkHadiths();
    }

    public LiveData<List<HadithBookmarkDBTable>> getAllHadiths() { return allHadiths; }

    public LiveData<List<HadithBookmarkDBTable>> getAllBookmarkHadiths() {
        return  bookmark;
    }

    public void insert(HadithBookmarkDBTable hadithBookmarkDBTable) { mRepository.insert(hadithBookmarkDBTable); }


}
