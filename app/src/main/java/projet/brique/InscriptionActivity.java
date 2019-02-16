package projet.brique;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InscriptionActivity extends AppCompatActivity {
    private Button insc;
    private EditText txtNom2;
    private EditText txtMdp2;
    private Script sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        sc= new Script();
        txtNom2 = (EditText) findViewById(R.id.editText3);
        txtMdp2 = (EditText) findViewById(R.id.editText4);
        insc = (Button) findViewById(R.id.button5);
        insc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mdpCripte = sc.script(txtMdp2.getText().toString());
                WebService.insert(txtNom2.getText().toString(),mdpCripte);
                Intent intention = new Intent(InscriptionActivity.this,MainActivity.class);
                InscriptionActivity.this.startActivityForResult(intention, 5);
            }
        });
    }
}
