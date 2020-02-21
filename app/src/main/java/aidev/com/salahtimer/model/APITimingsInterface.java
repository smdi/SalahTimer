package aidev.com.salahtimer.model;

import aidev.com.salahtimer.model.pojo.TimingsData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APITimingsInterface {

    @GET("/timingsByCity?")
    Call<TimingsData> getTimingsData(@Query("city") String city,
                                     @Query("country") String country,@Query("method") String method, @Query("school") String school);
}
