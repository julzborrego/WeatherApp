package com.example.mcs.weatherapp.UI;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.mcs.weatherapp.Model.WeatherModel;
import com.example.mcs.weatherapp.R;
import com.example.mcs.weatherapp.ViewModel.WeatherViewModel;
import com.example.mcs.weatherapp.databinding.FragmentWeatherBinding;

 /*
 * Weather fragment to display the ViewModel
 */
public class WeatherFragment extends Fragment {

    private static final String TAG = "WeatherFragment";
    private static final String KEY_ZIP = "zip";

    //auto genterated binding class
    FragmentWeatherBinding mBinding;

    WeatherViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //creates a ViewModel for this fragment
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);

        //sends the viewmodel the zip and application
        viewModel.init(getArguments().getString(KEY_ZIP),getActivity().getApplication());

        //Sets the viewmodel to observe the weathermodel and update if changed
        viewModel.getWeatherModel().observe(this, new Observer<WeatherModel>() {
            @Override
            public void onChanged(@Nullable WeatherModel weatherModel) {

                if(weatherModel!=null) {

                    //error handling if there was a servise error
                    if (weatherModel.getOverview().equals("ERROR")) {
                        Toast.makeText(getActivity(), R.string.error_server,
                                Toast.LENGTH_LONG).show();
                    }
                    //Udate the UI
                    else {
                        mBinding.setWeatherViewModel(viewModel);
                    }
                }
            }
        });

    }

    // Creates product fragment for specific product ID
    public static WeatherFragment forZip(String zip) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(KEY_ZIP, zip);
        fragment.setArguments(args);
        return fragment;
    }

}
