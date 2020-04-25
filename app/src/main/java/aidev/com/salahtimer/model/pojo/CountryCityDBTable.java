package aidev.com.salahtimer.model.pojo;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "CountryCityDBTable")
public class CountryCityDBTable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "names")
    private String names;


    public CountryCityDBTable( @NonNull String names) {
        this.names = names;
    }

    @NonNull
    public String getNames() {
        return names;
    }

    public void setNames(@NonNull String names) {
        this.names = names;
    }
}
