package aidev.com.salahtimer.model.pojo;

import com.google.gson.annotations.SerializedName;



public class TimingsData {


    @SerializedName("data")
    public Datum data;

    public class Datum {


        @SerializedName("timings")
        public Timings timings;
        @SerializedName("date")
        public Date date;
        @SerializedName("meta")
        public Meta meta;


        public  class  Timings{

            @SerializedName("Fajr")
            public String fajr;
            @SerializedName("Sunrise")
            public String sunrise;
            @SerializedName("Dhuhr")
            public String dhuhr;
            @SerializedName("Asr")
            public String asr;
            @SerializedName("Sunset")
            public String sunset;
            @SerializedName("Maghrib")
            public String magrib;
            @SerializedName("Isha")
            public String isha;
            @SerializedName("Imsak")
            public String imsak;
            @SerializedName("Midnight")
            public String midnight;

        }

        public class  Date {

            @SerializedName("readable")
            public String date;

        }

        public  class Meta{

            @SerializedName("timezone")
            public String timezone;
        }

    }

}
