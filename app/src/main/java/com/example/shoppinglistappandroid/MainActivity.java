package com.example.shoppinglistappandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView shopList;
    private EditText writeItem;
    private Button button;
    private ArrayAdapter<String> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shopList = (ListView) findViewById(R.id.list_view);
        writeItem = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.add_Button);


        array = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        shopList.setAdapter(array);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String item = writeItem.getText().toString();
                array.add(item);
                array.notifyDataSetChanged();
                writeItem.setText("");
            }

        });
    }
}


