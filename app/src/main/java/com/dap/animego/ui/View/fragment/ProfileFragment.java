package com.dap.animego.ui.View.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dap.animego.R;
import com.dap.animego.common.Constantes;
import com.dap.animego.common.SharedPreferencesManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextView textViewName;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        textViewName = view.findViewById(R.id.usernameProfile);

        String username = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_USERNAME);

        textViewName.setText(username);


        return view;


    }

}
