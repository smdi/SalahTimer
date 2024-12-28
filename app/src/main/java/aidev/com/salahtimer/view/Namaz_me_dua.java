package aidev.com.salahtimer.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import aidev.com.salahtimer.R;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Namaz_me_dua extends Fragment {

    private List<AllahNamesInitialiser> arrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_namaz_ke_dua, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayList = new ArrayList<>();

        arrayList.add(new AllahNamesInitialiser("Dua before niyyat","Inni wajjahtu wajhiya lillazi fataras samawati wal arda hanifau wama ana minal mushrikin."));

        arrayList.add(new AllahNamesInitialiser("Sana","Subhana Kal-lah hum-ma wabi hamdika wata-bara kasmuka wata’ala jad-duka wala ilaha ghyruka."));

        arrayList.add(new AllahNamesInitialiser("Attahiyyat","Attahiyyatu Lillahi was salawatu wa tayyibatu assalamu alayka " +
                "ayyuhan Nabiyyu wa rahmatullahi wa barakatuhu assalamu alayna wa alaa ibadilla his saliheen " +
                "ashhadu alla ilaha illallah wa ashhadu anna muhammadan abduhu wa rasuluhu."));

        arrayList.add(new AllahNamesInitialiser("Darood e Ibrahim","Allahumma salli ala muhammadiw wa ala aali muhammadin " +
                "kama sallaita ala ibraheema wa ala aali ibraheema innaka " +
                "hamidum majid, Allahumma baarik ala muhammadiw wa ala aali muhammadin kama barakta ala ibraheema wa ala aali ibraheema innaka" +
                " hamidum majeed"));

        arrayList.add(new AllahNamesInitialiser("Dua e Maasora","Allahumma inni zalamtu nafsi zulman kaseerau wala egfiruzunuba illa anta fagfirli magfiratan min indika war hamni innaka antal gafoorur rahim."));

        arrayList.add(new AllahNamesInitialiser("Dua e Qunoot","Allah humma inna nasta-eenoka wa nastaghfiruka wa nu'minu bika wa natawakkalu alaika wa nusni alaikal khair, wa nashkuruka wala nakfuruka wa nakhla-oo wa natruku mai yafjuruka, Allah humma iyyaka na'budu wa laka nusalli wa nasjud; wa ilaika nas aaa wa nahfizu wa narju rahma taka wa nakhshaa azaabaka; inna azaabaka bil kuffari mulhik."));

        arrayList.add(new AllahNamesInitialiser("Aayatul kursi","Allahu laaa ilaaha illaa huwal haiyul qaiyoom laa taakhuzuhoo sinatunw wa laa nawm lahoo maa fissamaawaati wa maa fil ard man zallazee yashfa'u indahooo illaa be iznih ya'lamu maa baina aideehim wa maa khalfahum" +
                " wa laa yuheetoona beshai 'immin 'ilmihee illa be maa shaaaa wasi'a kursiyyuhus samaa waati wal arda " +
                "wa la ya'ooduho hifzuhumaa wa huwal aliyyul 'azeem"));

        arrayList.add(new AllahNamesInitialiser("Dua during travel","Subhaanallazzee Sakhkhara lanaa Haaza Wama Kunna Lahu Muqrineen" +
                "Wa Inna Ilaa Rabbina Lamun Qaliboon"));

        arrayList.add(new AllahNamesInitialiser("Dua after azaan","Allaahumma Rabba haathihid da" +
                " 'watit-taammati wassalaatil qaa'imati 'aati Muhammadanil " +
                "waseelata walfadheelata wab asu hu maqaamam mahmoodanil lazee wa'attah 'innaka laa tukhliful mee'aad"));

        arrayList.add(new AllahNamesInitialiser("Dua of having food","Bismillahi wala barakatullah"));

        arrayList.add(new AllahNamesInitialiser("Dua after having food","Alhamdulillahilladhii ath’amanaa wa saqaanaa wa ja’alanaa minalmuslimiin."));

        arrayList.add(new AllahNamesInitialiser("forgot to read dua of having food","Bismillahi fii awwalihi wa akhirih"));

        arrayList.add(new AllahNamesInitialiser("Dua to read before sleep","Allahumma Bismika Amutu Wa Ahya"));

        arrayList.add(new AllahNamesInitialiser("Dua to read after woke up","Alhamdulilla hilladzi Ahyana Ba’da Ma Amatana Wailaihin Nushoor."));

        arrayList.add(new AllahNamesInitialiser("Dua of entering a masjid","Allaahum maf taḥ lee abwaaba  raḥmatik"));

        arrayList.add(new AllahNamesInitialiser("Dua of leaving from masjid","Allahumma inne asaluka min fazlik wa rahamatik"));

        arrayList.add(new AllahNamesInitialiser("Dua of entering home","Allahumma inne asaluka khairal moulaji wa khairal makhraji bismillaahi walajnaa wa bismillaahi kharajnaa wa 'alaaRabblnaa tawakkalnaa"));

        arrayList.add(new AllahNamesInitialiser("Dua of leaving home","Bismillaahi tawakkaltu 'alallaahi wa laa hawla wa laa quwwata ‘ illaa billaah."));

        arrayList.add(new AllahNamesInitialiser("Dua of entering bathroom","Allaahumma 'innee 'a'oozu bika minal khubsi wal khabaa'is."));

        arrayList.add(new AllahNamesInitialiser("Dua of exit from bathroom","Ghufraanaka alhamdu lillahillazi az haaba annil aza wa aafaani "));

        arrayList.add(new AllahNamesInitialiser("Dua before wudhu","Subhanakallahumma wabi hamdika ash hadu al laailaaha illa anta astagfiruka wa atoobu ilay."));

        arrayList.add(new AllahNamesInitialiser("Dua after wudhu","Ash-hadu 'an laa 'ilaaha 'illallaahu wahdahu laa shareeka lahu wa 'ash-hadu 'anna Muhammadan 'abduhu wa Rasooluhu " +
                "Allaahummaj'alnee minat tawwaabeena waj'alnee minal mutatahhireen."));

        arrayList.add(new AllahNamesInitialiser("Dua of wearing clothes","Alḥamdu lillaahil ladhee kasaanee haazah sawba wa razaqaneehi min ghayri ḥawli minnee wa laa quwwah"));

        NamazAdapter qa = new NamazAdapter(getActivity(), arrayList);

        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(qa);

    }

}
