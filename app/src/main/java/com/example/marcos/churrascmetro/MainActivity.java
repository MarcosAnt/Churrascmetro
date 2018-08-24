package com.example.marcos.churrascmetro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar skMen, skWomen, skKids;
    TextView tvSkMen, tvSkWomen, tvSkKids, tvOutLing, tvOutCarne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mapeando SeekBar's
        skMen   = (SeekBar)findViewById(R.id.skMen);
        skWomen = (SeekBar)findViewById(R.id.skWomen);
        skKids  = (SeekBar)findViewById(R.id.skKids);

        //Mapeando TextView's
        tvSkMen    = (TextView)findViewById(R.id.tvSkMen);
        tvSkWomen  = (TextView)findViewById(R.id.tvSkWomen);
        tvSkKids   = (TextView)findViewById(R.id.tvSkKids);
        tvOutLing  = (TextView)findViewById(R.id.tvOutLing);
        tvOutCarne = (TextView)findViewById(R.id.tvOutCarne);

        skMen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSkMen.setText(String.valueOf(progress));
                calculate(progress, skWomen.getProgress(), skKids.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skWomen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSkWomen.setText(String.valueOf(progress));
                calculate(skMen.getProgress(), progress, skKids.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skKids.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSkKids.setText(String.valueOf(progress));
                calculate(skMen.getProgress(), skWomen.getProgress(), progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        calculate(skMen.getProgress(), skWomen.getProgress(), skKids.getProgress());
    }

    private void calculate(int prgMen, int prgWomen, int prgKids) {
        double totalLing, totalCarne;

        totalLing  = (double)((prgMen * 250) + (prgWomen * 200) + (prgKids * 100)) / 1000;
        totalCarne = (double)((prgMen * 500) + (prgWomen * 300) + (prgKids * 200)) / 1000;

        tvOutLing.setText(String.valueOf(totalLing) + "Kg");
        tvOutCarne.setText(String.valueOf(totalCarne) + "Kg");
    }
}
