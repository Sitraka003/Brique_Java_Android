package projet.brique;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Vector;

public class JeuActivity extends Activity {
    private Button ajout;
    Jeu j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        j = new Jeu(this);
        setContentView(R.layout.activity_jeu2);
        this.addContentView(j, new RelativeLayout.LayoutParams(700, 900));
        ajout = (Button) findViewById(R.id.button3);
        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j.ajoutBalle();
            }
        });
    }
}
