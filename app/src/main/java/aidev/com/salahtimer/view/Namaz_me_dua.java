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

        arrayList.add(new AllahNamesInitialiser("Niyyat ki Dua","Inni wajjahtu wajhiya lillazi fataras samawati wal arda hanifau wama ana minal mushrikin."));
        arrayList.add(new AllahNamesInitialiser("Sana","Subhana Kal-lah hum-ma wabi hamdika wata-bara kasmuka wata’ala jad-duka wala ilaha ghyruka."));
        arrayList.add(new AllahNamesInitialiser("Attahiyyat","Attahiyyatu Lillahi was salawatu wa tayyibatu assalamu alayka " +
                "ayyuhan Nabiyyu wa rahmatullahi wa barakatuhu assalamu alayna wa alaa ibadilla his saliheen " +
                "ashhadu alla ilaha illallah wa ashhadu anna muhammadan abduhu wa rasuluhu."));
        arrayList.add(new AllahNamesInitialiser("Darood e Ibrahim","Allahumma salli ala muhammadiw wa ala aali muhammadin " +
                "kama sallaita ala ibraheema wa ala aali ibraheema innaka " +
                "hamidum majid, Allahumma baarik ala muhammadiw wa ala aali muhammadin kama barakta ala ibraheema wa ala aali ibraheema innaka" +
                " hamidum majeed"));
        arrayList.add(new AllahNamesInitialiser("Dua e Qunoot","Allah humma inna nasta-eenoka wa nastaghfiruka wa nu'minu bika wa natawakkalu alaika wa nusni alaikal khair, wa nashkuruka wala nakfuruka wa nakhla-oo wa natruku mai yafjuruka, Allah humma iyyaka na'budu wa laka nusalli wa nasjud; wa ilaika nas aaa wa nahfizu wa narju rahma taka wa nakhshaa azaabaka; inna azaabaka bil kuffari mulhik."));
        arrayList.add(new AllahNamesInitialiser("Dua e Nazira","Allahumma inni zalamtu nafsi zulman kaseerau wala egfiruzunuba illa anta fagfirli magfiratan min indika war hamni innaka antal gafoorur rahim."));

        NamazAdapter qa = new NamazAdapter(getActivity(), arrayList);

        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(qa);

    }

}
