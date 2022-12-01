package com.irma.irmauasmobile;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvlaguanak;
    private ArrayList<LaguAnak> list = new ArrayList<>();


//    MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvlaguanak = findViewById(R.id.rv_laguanak);
        rvlaguanak.setHasFixedSize(true);

        list.addAll(LaguAnakData.getListData());
        showRecyclerList();
    }
    private void showRecyclerList(){
        rvlaguanak.setLayoutManager(new LinearLayoutManager(this));
        ListLaguAnakAdapter listLaguAnakAdapter = new ListLaguAnakAdapter(list);
        rvlaguanak.setAdapter(listLaguAnakAdapter);

        listLaguAnakAdapter.setOnItemClickCallback(new ListLaguAnakAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(LaguAnak laguanak) {

                Intent moveIntent = new Intent(MainActivity.this, DetailLaguAnakActivity.class);
                moveIntent.putExtra(DetailLaguAnakActivity.ITEM_EXTRA, laguanak);
                startActivity(moveIntent);

            }
        });

    }
}
