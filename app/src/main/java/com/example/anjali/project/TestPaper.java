package com.example.anjali.project;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Anjali on 13-04-2016.
 */
public class TestPaper extends Fragment {




        public TestPaper() {
            // Required empty public constructor
        }

    @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.activity_testpaper, container, false);
        }


}
