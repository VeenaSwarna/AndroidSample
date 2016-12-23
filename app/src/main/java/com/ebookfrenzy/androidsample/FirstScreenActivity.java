package com.ebookfrenzy.androidsample;

import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by veena on 7/29/15.
 */
public class FirstScreenActivity extends Activity {


    ListView listView ;
    String ITEM_NAME = null;
    static final String[] LIST_VIEW_ITEM_DETAILS = new String[] { "Health",
            "Fitness",
            "HairCare",
            "SkinCare",
            "Homemade Remedies",
            "Tips"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen );
        ListView listview=(ListView)  findViewById(R.id.list);
        listview.setAdapter(new AndroidSampleArrayAdapter(this, LIST_VIEW_ITEM_DETAILS));
        listview.setOnItemClickListener(new ListViewListener(this));

    }
/*
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //get selected items
        String selectedValue = (String) l.getAdapter().getItem(position);
        //Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,SecondScreenActivity.class);
        //intent.putExtra("selectedValue",String.valueOf(id));
        intent.putExtra("selectedValue",LIST_VIEW_ITEM_DETAILS[position]);
        startActivity(intent);

    }
    */







    // Defined Array values to show in ListView

        //ArrayAdapter<String> adapter = new ArrayAdapter<1,2,3,4>
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data


                // Show Alert
              /*  Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();*/



                //ITEM_NAME = (String) LIST_VIEW_ITEM_DETAILS[position];
                //Intent intent = new Intent(context,AndroidSample1Activity.class);
               // intent.putExtra("ITEM_NAME",String.valueOf(id));
                //startActivity(intent);


    public class ListViewListener implements AdapterView.OnItemClickListener{

       Activity activity=null;

        public ListViewListener(Activity activity){
            this.activity=activity;
        }


        @Override
        public void onItemClick(AdapterView<?> adapterView, View v, int position, long l) {
            //get selected items
            String selectedValue = (String) adapterView.getAdapter().getItem(position);
            //Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this.activity,SecondScreenActivity.class);
            //intent.putExtra("selectedValue",String.valueOf(id));
            intent.putExtra("selectedValue",LIST_VIEW_ITEM_DETAILS[position]);
            startActivity(intent);
        }
    }


}
