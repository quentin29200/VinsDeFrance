package com.example.quentin.vinsdefrance;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_regions);

        /* code for dynamic layouts V3 */

		setContentView(R.layout.main);
		if (savedInstanceState == null) { // to avoid recreating if restored from a previous state


			// need to check if we are in tablet configuration or in normal configuration
			if (findViewById(R.id.layoutTablette) != null) {
				// tablet configuration

				FragmentManager fragmentManager = getFragmentManager();
				final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

				RegionsFragment regions = new RegionsFragment();

				final InfoFragment info = new InfoFragment();

				fragmentTransaction.add(R.id.fragmentLayout, regions);
				fragmentTransaction.add(R.id.fragmentLayout2, info);
				fragmentTransaction.commit();

				regions.getList().setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						String regionSelected = ((TextView)view).getText().toString();
						Bundle args = new Bundle();
						args.putString("region", regionSelected);
						InfoFragment newInfo = new InfoFragment();
						newInfo.setArguments(args);
						FragmentManager fragmentManager = getFragmentManager();
						final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
						fragmentTransaction.remove(info);
						fragmentTransaction.add(R.id.fragmentLayout2, newInfo);
						fragmentTransaction.commit();
					}
				});

			} else {
				// normal configuration

				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

				RegionsFragment regions = new RegionsFragment();

				fragmentTransaction.add(R.id.fragmentLayout, regions);
				fragmentTransaction.commit();

			}
		}



    }
}
