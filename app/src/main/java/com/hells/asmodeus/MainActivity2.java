package com.hells.asmodeus;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    ImageButton btn1;
    AnimationDrawable LaughingCat;

    MediaPlayer mp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1 = findViewById(R.id.imageButtonCatlaughing);
        mp1 = MediaPlayer.create(this, R.raw.catlaughingatyou);
        btn1.setBackgroundResource(R.drawable.laughing_cat_anim);
        btn1.setImageResource(R.color.transparent);
        LaughingCat = (AnimationDrawable) btn1.getBackground();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn1.setImageResource(R.color.transparent);
                LaughingCat.start();

                if (mp1.isPlaying()){
                    mp1.seekTo(0);
                    LaughingCat.stop();
                    LaughingCat.start();

                }
                else {
                    mp1.start();
                }

                mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (!mp1.isPlaying()&&LaughingCat.isRunning()) {
                            LaughingCat.stop();
                        }
                    }
                });
            }
        });

        mp1.start();
        LaughingCat.start();
        mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (!mp1.isPlaying()&&LaughingCat.isRunning()) {
                    LaughingCat.stop();
                }
            }
        });
    }
}