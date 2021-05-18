package aidev.com.salahtimer.TransliterationData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TransLIteration {

    public static JSONObject getData(int number) throws JSONException {

        JSONObject obj = new JSONObject();

        JSONArray array = new JSONArray();

        String data[] = getQuranSurah(number);

        for (int i = 0; i < data.length; i++) {
            array.put(data[i]);
        }

        obj.put("data", array);

        return obj;
    }

    private static String[] getQuranSurah(int number){

        switch (number) {

            case 1 :
                return Trans1.getData();
            case 2:
                return Trans2.getData();
            case 3:
                return Trans3.getData();
            case 4:
                return Trans4.getData();
            case 5:
                return Trans5.getData();
            case 6:
                return Trans6.getData();
            case 7:
                return Trans7.getData();
            case 8:
                return Trans8.getData();
            case 9:
                return Trans9.getData();
            case 10:
                return Trans10.getData();
                
            case 11:
                return Trans11.getData();
                
            case 12:
                return Trans12.getData();

                
            case 13:
                return Trans13.getData();

                
            case 14:
                return Trans14.getData();

                
            case 15:
                return Trans15.getData();

                
            case 16:
                return Trans16.getData();

                
            case 17:
                return Trans17.getData();

                
            case 18:
                return Trans18.getData();

                
            case 19:
                return Trans19.getData();

                
            case 20:
                return Trans20.getData();

                
            case 21:
                return Trans21.getData();

                
            case 22:
                return Trans22.getData();

                
            case 23:
                return Trans23.getData();
                
            case 24:
                return Trans24.getData();
            case 25:
                return Trans25.getData();
            case 26:
                return Trans26.getData();
            case 27:
                return Trans27.getData();
            case 28:
                return Trans28.getData();
            case 29:
                return Trans29.getData();
            case 30:
                return Trans30.getData();
            case 31:
                return Trans31.getData();
            case 32:
                return Trans32.getData();
            case 33:
                return Trans33.getData();
            case 34:
                return Trans34.getData();
            case 35:
                return Trans35.getData();
            case 36:
                return Trans36.getData();
            case 37:
                return Trans37.getData();
            case 38:
                return Trans38.getData();
            case 39:
                return Trans39.getData();
                
            case 40:
                return Trans40.getData();

                
            case 41:
                return Trans41.getData();


                
            case 42:
                return Trans42.getData();

                
            case 43:
                return Trans43.getData();

                
            case 44:
                return Trans44.getData();

                
            case 45:
                return Trans45.getData();

                
            case 46:
                return Trans46.getData();

                
            case 47:
                return Trans47.getData();

                
            case 48:
                return Trans48.getData();
                
            case 49:
                return Trans49.getData();

                
            case 50:
                return Trans50.getData();
                
            case 51:
                return Trans51.getData();
                
            case 52:
                return Trans52.getData();

                
            case 53:
                return Trans53.getData();

                
            case 54:
                return Trans54.getData();

                
            case 55:
                return Trans55.getData();

                
            case 56:
                return Trans56.getData();

                
            case 57:
                return Trans57.getData();

                
            case 58:
                return Trans58.getData();
                
            case 59:
                return Trans59.getData();
            case 60:
                return Trans60.getData();

                
            case 61:
                return Trans61.getData();

                
            case 62:
                return Trans62.getData();
                
            case 63:
                return Trans63.getData();
            case 64:
                return Trans64.getData();
            case 65:
                return Trans65.getData();

                
            case 66:
                return Trans66.getData();
                
            case 67:
                return Trans67.getData();

                
            case 68:
                return Trans68.getData();
                

            case 69:
                return Trans69.getData();

                
            case 70:
                return Trans70.getData();
                
            case 71:
                return Trans71.getData();

                
            case 72:
                return Trans72.getData();
                
            case 73:
                return Trans73.getData();

                
            case 74:
                return Trans74.getData();

                
            case 75:
                return Trans75.getData();
                
            case 76:
                return Trans76.getData();

                
            case 77:
                return Trans77.getData();

                
            case 78:
                return Trans78.getData();

                
            case 79:
                return Trans79.getData();
            case 80:
                return Trans80.getData();
            case 81:
                return Trans81.getData();
            case 82:
                return Trans82.getData();

                
            case 83:
                return Trans83.getData();

                
            case 84:
                return Trans84.getData();

                
            case 85:
                return Trans85.getData();

                
            case 86:
                return Trans86.getData();

                
            case 87:
                return Trans87.getData();

                
            case 88:
                return Trans88.getData();

                
            case 89:
                return Trans89.getData();

                
            case 90:
                return Trans90.getData();

                
            case 91:
                return Trans91.getData();
                
            case 92:
                return Trans92.getData();

                
            case 93:
                return Trans93.getData();

                
            case 94:
                return Trans94.getData();

                
            case 95:
                return Trans95.getData();

                
            case 96:
                return Trans96.getData();
            case 97:

                return Trans97.getData();
            case 98:
                return Trans98.getData();

                
            case 99:
                return Trans99.getData();

                
            case 100:
                return Trans100.getData();
            case 101:
                return Trans101.getData();
            case 102:
                return Trans102.getData();
            case 103:
                return Trans103.getData();
            case 104:
                return Trans104.getData();
            case 105:
                return Trans105.getData();
            case 106:
                return Trans106.getData();
            case 107:
                return Trans107.getData();
            case 108:
                return Trans108.getData();
            case 109:
                return Trans109.getData();
            case 110:
                return Trans110.getData();
            case 111:
                return Trans111.getData();
            case 112:
                return Trans112.getData();
            case 113:
                return Trans113.getData();
            case 114:
                return Trans114.getData();

        }
        String data[] = {"No data"};
        return data;
    }
}

