package com.example.anjali.project;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Anjali on 13-04-2016.
 */
public class TestPaper extends Fragment {

Button testButton;


        public TestPaper() {
            // Required empty public constructor
        }

    @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_testpaper, container, false);
        testButton=(Button)view.findViewById(R.id.testButton);
        testButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i1 = new Intent(getActivity(),test.class);
                startActivity(i1);
            }
        });
        //bookButton.setOnClickListener(this);
        return view ;

        }


}
