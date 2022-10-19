package com.example.labtest1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {

    String[] colors = { "Blue", "Red", "Green" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.colors_list_view, colors);

        ListView listView = (ListView) findViewById(R.id.colors_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String color = colors[position];
                changeBackgroundColor(color == "Blue" ? Color.BLUE : color == "Red" ? Color.RED : Color.GREEN);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void changeBackgroundColor(int colorCode){
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(colorCode);
    }
}