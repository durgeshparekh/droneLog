package com.cqu.dronelogs;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "HomeFragment";
    private View view;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        Log.e(TAG, "onCreateView: Called......." );

        fetchId();

        return view;
    }

    private void fetchId() {
        Button day1 = view.findViewById(R.id.day_one);
        Button day2 = view.findViewById(R.id.day_two);
        Button day3 = view.findViewById(R.id.day_three);
        Button day4 = view.findViewById(R.id.day_four);
        Button day5 = view.findViewById(R.id.day_five);

        day1.setOnClickListener(this);
        day2.setOnClickListener(this);
        day3.setOnClickListener(this);
        day4.setOnClickListener(this);
        day5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.day_one){

            loadFragment(new DayOneFragment());

        }else if (v.getId() == R.id.day_two){

            loadFragment(new DayTwoFragment());

        }else if (v.getId() == R.id.day_three){

            loadFragment(new DayThreeFragment());

        }else if (v.getId() == R.id.day_four){

            loadFragment(new DayFourFragment());

        }else if (v.getId() == R.id.day_five){

            loadFragment(new DayFiveFragment());

        }
    }

    private void loadFragment(Fragment fragment) {
        if (getFragmentManager() != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

}
