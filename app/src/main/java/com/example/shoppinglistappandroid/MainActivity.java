package com.example.shoppinglistappandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
//    private Button button;
    private ArrayAdapter<String> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shopList = (ListView) findViewById(R.id.list_view);
        writeItem = (EditText) findViewById(R.id.edit_text);
//        button = (Button) findViewById(R.id.add_Button);

        itemList = new ArrayList<>();

        array = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        shopList.setAdapter(array);

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
//        protected void deleteItem(TextView view){
//
//        }

    }
}


