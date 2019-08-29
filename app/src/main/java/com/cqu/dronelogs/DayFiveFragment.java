package com.cqu.dronelogs;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DayFiveFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Context context;
    private EditText etSerial, etPilotName, etContract;


    public DayFiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_day_five, container, false);
        context = inflater.getContext();

        Log.e("onCreateView: ", "DAY Five FRAGMENT...55");
        fetchId();

        return view;
    }

    private void fetchId() {
        Button btnNext = view.findViewById(R.id.btn_next);
        Button btnPrevious = view.findViewById(R.id.btn_previous);
        Button btnHome = view.findViewById(R.id.btn_home);
        Button btnSaveLog = view.findViewById(R.id.btn_save_log);
        Button btnShowLog = view.findViewById(R.id.btn_display_entry);
        Spinner categorySpn = view.findViewById(R.id.spinner_category);

        etSerial = view.findViewById(R.id.et_serial);
        etPilotName = view.findViewById(R.id.et_pilot_name);
        etContract = view.findViewById(R.id.et_contract);

        ArrayList<String> categoryList = new ArrayList<>();
        categoryList.add("Civil");
        categoryList.add("Government");
        categoryList.add("Military");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item,
                categoryList);
        categorySpn.setAdapter(adapter);

        btnNext.setVisibility(View.GONE);
        btnPrevious.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnSaveLog.setOnClickListener(this);
        btnShowLog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next:
//                loadFragment(new DayFiveFragment());
                break;
            case R.id.btn_previous:
                loadFragment(new DayFourFragment());
                break;
            case R.id.btn_home:
                loadFragment(new HomeFragment());
                break;
            case R.id.btn_save_log:
                //save log to db with validation
                saveDataToDatabase();
                break;
            case R.id.btn_display_entry:
                // display list of all log entries
                break;
        }

    }

    private void saveDataToDatabase() {

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
