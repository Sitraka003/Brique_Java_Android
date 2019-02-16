package projet.brique;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(ecoute);
    }

    public View.OnClickListener ecoute = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intention = new Intent(Main2Activity.this,JeuActivity.class);
            Main2Activity.this.startActivityForResult(intention,3);
        }
    };
}
