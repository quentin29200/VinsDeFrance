package com.example.quentin.vinsdefrance;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by quentin on 05/11/16.
 */

public class RegionsFragment extends Fragment {
    private ListView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_regions,
                container, false);

        this.list = (ListView) view.findViewById(R.id.list_regions);

        String[] regions = {    "Alsace",
                                "Beaujolais" ,
                                "Jura",
                                "Champagne",
                                "Savoie",
                                "Languedoc-Roussilon",
                                "Bordelais",
                                "Vallée du Rhone",
                                "Provence",
                                "Val de Loire",
                                "Sud-Ouest",
                                "Corse",
                                "Bourgogne"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, regions);
        this.list.setAdapter(adapter);

        return view;
    }

    public ListView getList() {
        return list;
    }
}
