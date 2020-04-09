package aidev.com.salahtimer.model;

import java.util.List;

import aidev.com.salahtimer.model.pojo.Quran_Ar_En;
import aidev.com.salahtimer.model.pojo.Quran_Transliteration;
import aidev.com.salahtimer.model.pojo.TimingsData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APITimingsInterface {

    @GET("/timingsByCity?")
    Call<TimingsData> getTimingsData(@Query("city") String city,
                                     @Query("country") String country,@Query("method") String method, @Query("school") String school);

    @GET("/api/chapter/{number}")
    Call<List<Quran_Ar_En>> getQuranData(@Path("number") int number);

    @GET("/api/chapter/{number}?lang=en")
    Call<List<Quran_Ar_En>> getQuranDataEnglishTranslation(@Path("number") int number);

    @GET("/{number}")
    Call<Quran_Transliteration> getQuranDataEnglishTransliteration(@Path("number") int number);

}
