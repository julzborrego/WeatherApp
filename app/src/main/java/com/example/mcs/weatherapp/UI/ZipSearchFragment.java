package com.example.mcs.weatherapp.UI;


import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mcs.weatherapp.R;
import com.example.mcs.weatherapp.Utils.FormatUtils;

public class ZipSearchFragment extends Fragment {

    private static final String TAG = "ZipSearchFragment";


    private static EditText editTextZip;
    private static ImageButton searchBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_zip_search, container, false);

        //initializes the widgets
        init(rootView);

        return rootView;
    }

    private void init(View view){
        editTextZip= (EditText)view.findViewById(R.id.et_zip);
        searchBtn = (ImageButton)view.findViewById(R.id.btn_zip);

        //checks to see if zip is exaclty 5 digits
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editTextZip.getText().toString();
                if(FormatUtils.isValidZip(input)){
                    //get the activity to start fragment if Activity is at least started
                    if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                        ((MainActivity) getActivity()).show(input);
                    }
                }
                else{
                    //error handling for invalid zip
                    Toast.makeText(getActivity(), R.string.error_zip,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
