package com.example.shoppinglistappandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> itemList;
    private ListView shopList;
    private EditText writeItem;
    private ArrayAdapter<String> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shopList = (ListView) findViewById(R.id.list_view);
        writeItem = (EditText) findViewById(R.id.edit_text);

        itemList = new ArrayList<>();

        //creating array with arrayadapter for our item list
        array = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,itemList);
        shopList.setAdapter(array);



        //It is the part that you add items with 'return' key
        writeItem.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_NULL)) {
                    String item = writeItem.getText().toString();
                    array.add(item);
                    array.notifyDataSetChanged();
                    writeItem.setText("");
                }
                return false;
            }
        });


        // It is the part that you delete items with clicking long
        shopList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, View view, int i,long l) {

                final int item = i;

                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this item?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i){
                                itemList.remove(item);
                                array.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return true;
                // I added alertdialog so that it looks good

            }
        });



    }
}


