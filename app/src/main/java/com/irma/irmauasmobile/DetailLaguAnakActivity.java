package com.irma.irmauasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailLaguAnakActivity extends AppCompatActivity {

    public static final String ITEM_EXTRA = "item_extra";
    private MediaPlayer tvLaguanakSuara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_laguanak);

        ImageView imgLaguanak = findViewById(R.id.img_laguank);
        TextView tvLaguanakNama = findViewById(R.id.tvLaguanakNama);
        TextView tvLaguanakDetail = findViewById(R.id.tvLaguanakDetail);

        LaguAnak laguAnak = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (laguAnak != null) {
            Glide.with(this)
                    .load(laguAnak.getPhoto())
                    .into(imgLaguanak);
            tvLaguanakNama.setText(laguAnak.getNama());
            tvLaguanakDetail.setText(laguAnak.getDetail());
            tvLaguanakSuara = MediaPlayer.create(DetailLaguAnakActivity.this,laguAnak.getSuara()); // ## sudah bisa memanggil suara
            tvLaguanakSuara.start(); //## sudah bisa jalan suara
        }
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail Lagu Anak");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        tvLaguanakSuara.release();
        finish();
//        Toast.makeText(this, "Hello wolrd", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onBackPressed() {
        tvLaguanakSuara.release();
        finish();
        super.onBackPressed();
    }
}