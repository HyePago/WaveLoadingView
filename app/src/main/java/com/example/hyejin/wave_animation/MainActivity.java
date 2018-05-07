package com.example.hyejin.wave_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import me.itangqi.waveloadingview.WaveLoadingView;

public class MainActivity extends AppCompatActivity {

    WaveLoadingView waveLoadingView[] = new WaveLoadingView[9];
    SeekBar seekBar;
    Integer[] WaveIDs = {R.id.waveLoadingView1, R.id.waveLoadingView2, R.id.waveLoadingView3, R.id.waveLoadingView4, R.id.waveLoadingView5, R.id.waveLoadingView6, R.id.waveLoadingView7, R.id.waveLoadingView8, R.id.waveLoadingView9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<waveLoadingView.length; i++){
            waveLoadingView[i] = (WaveLoadingView)findViewById(WaveIDs[i]);
            waveLoadingView[i].setProgressValue(0);
        }

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                for(int i=0; i<waveLoadingView.length; i++){
                    waveLoadingView[i].setProgressValue(progress);
                }

                if(progress < 50){
                    for(int i=0; i<waveLoadingView.length; i++){
                        waveLoadingView[i].setTopTitle("");
                        waveLoadingView[i].setBottomTitle(String.format("%d%%", progress));
                        waveLoadingView[i].setCenterTitle("");
                    }
                } else if (progress == 50){
                    for(int i=0; i<waveLoadingView.length; i++) {
                        waveLoadingView[i].setTopTitle("");
                        waveLoadingView[i].setBottomTitle("");
                        waveLoadingView[i].setCenterTitle(String.format("%d%%", progress));
                    }
                } else {
                    for(int i=0; i<waveLoadingView.length; i++) {
                        waveLoadingView[i].setTopTitle(String.format("%d%%", progress));
                        waveLoadingView[i].setBottomTitle("");
                        waveLoadingView[i].setCenterTitle("");
                    }
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
