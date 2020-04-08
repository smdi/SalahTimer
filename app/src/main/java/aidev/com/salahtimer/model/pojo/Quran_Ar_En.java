package aidev.com.salahtimer.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quran_Ar_En {


    @SerializedName("Verses")
    public List<Datum> data;

    public class Datum {
        @SerializedName("VerseId")
        public String verseId;
        @SerializedName("Text")
        public String text;
    }

}
