package com.example.anjali.project;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Drawer extends AppCompatActivity {

    ListView listView;
    TextView textView;
    ArrayAdapter<String> listAdapter;
    String fragmentArray[]={"EBook","TestPaper","Discussion Forum"};
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        listView = (ListView)findViewById(R.id.listview);
        listAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fragmentArray);
        listView.setAdapter(listAdapter);

        textView=(TextView)findViewById(R.id.txtdrawer);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment;
                switch(position){
                    case 0:
                        fragment=new Ebook();
                        textView.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        fragment=new TestPaper();
                        textView.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        fragment=new Discussion();
                        textView.setVisibility(View.INVISIBLE);
                    default:
                        fragment=new Ebook();
                        textView.setVisibility(View.INVISIBLE);
                        break;
                }
                FragmentManager fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit();
                //drawerLayout.closeDrawers();
            }
        });
    }
}
