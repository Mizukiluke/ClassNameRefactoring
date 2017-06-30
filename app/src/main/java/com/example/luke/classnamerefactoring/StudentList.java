package com.example.luke.classnamerefactoring;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentList extends Fragment {

    View root;
    String[] mClassItems;
    String[] StudentItems;
    LinearLayout linearArray[];
    int classTag;
    public StudentList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root=inflater.inflate(R.layout.fragment_student_list,container, false);
        initClassSelector();
        initStudentList();
        return root;
    }
    void initClassSelector()
    {
        Spinner mSpinner = (Spinner) root.findViewById(R.id.class_spinner);
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(getActivity());
        mClassItems = sp.getString("studentListSetting","null").split(",|，");
        ArrayAdapter<String> stringAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,mClassItems);
        stringAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(stringAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                classTag=position;
                Toast.makeText(getActivity().getApplicationContext(),mClassItems[position],Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
    void initStudentList()
    {
        linearArray=new LinearLayout[4];
        linearArray[0]=(LinearLayout)root.findViewById(R.id.yet_layout);
        linearArray[1]=(LinearLayout)root.findViewById(R.id.late_layout);
        linearArray[2]=(LinearLayout)root.findViewById(R.id.checked_layout);
        linearArray[3]=(LinearLayout)root.findViewById(R.id.leave_layout);
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(getActivity());
        mClassItems = sp.getString("classListSetting","null").split(",|，");

    }
}