package com.example.quentin.vinsdefrance;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by quentin on 05/11/16.
 */

public class InfoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info,
                container, false);
        WebView wv = (WebView) view.findViewById(R.id.webInfo);
        Bundle bundle = this.getArguments();
        if(bundle.containsKey("region")) {
            String region = bundle.get("region").toString();
            region.replaceAll("\\s", "_" );
            region.toLowerCase();
            Log.i("URL", "http://technoresto.org/vdf/"+region+"/index.html");
            wv.loadUrl("http://technoresto.org/vdf/"+region+"/index.html");
        }

        return view;
    }
}
