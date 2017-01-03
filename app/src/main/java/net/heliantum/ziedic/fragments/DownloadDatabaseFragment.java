package net.heliantum.ziedic.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import net.heliantum.ziedic.R;
import net.heliantum.ziedic.database.DataHandler;
import net.heliantum.ziedic.database.DatabaseRepository;
import net.heliantum.ziedic.database.entity.LanguageEntites;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownloadDatabaseFragment extends Fragment {

    private Button update;

    public DownloadDatabaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_download_database, container, false);

        update = (Button) rootView.findViewById(R.id.update_button);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseRepository dr = DataHandler.getDatabaseRepository();

                dr.updateData();
                int previously = LanguageEntites.size();

                LanguageEntites.reset();
                dr.loadData();

                int now = LanguageEntites.size();

                Toast.makeText(getContext(), "Pomyślnie zaktualizowano bazę słów (+" + (now - previously) + ")", Toast.LENGTH_SHORT).show();
            }

        });

        return rootView;
    }

}