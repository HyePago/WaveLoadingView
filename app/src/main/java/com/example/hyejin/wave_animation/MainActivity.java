package com.example.hyejin.wave_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import me.itangqi.waveloadingview.WaveLoadingView;

public class MainActivity extends AppCompatActivity {

    WaveLoadingView waveLoadingView;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        waveLoadingView.setProgressValue(0);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                waveLoadingView.setProgressValue(progress);

                if(progress < 50){
                    waveLoadingView.setTopTitle("");
                    waveLoadingView.setBottomTitle(String.format("%d%%", progress));
                    waveLoadingView.setCenterTitle("");
                } else if (progress == 80){
                    waveLoadingView.setTopTitle("");
                    waveLoadingView.setBottomTitle("");
                    waveLoadingView.setCenterTitle(String.format("%d%%", progress));
                } else {
                    waveLoadingView.setTopTitle(String.format("%d%%", progress));
                    waveLoadingView.setBottomTitle("");
                    waveLoadingView.setCenterTitle("");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
