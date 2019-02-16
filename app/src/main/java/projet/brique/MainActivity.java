package projet.brique;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtNom;
    private EditText txtMdp;
    private TextView err;
    private Button idBtn;
    private Button idBtn2;
    private Script sc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sc2 = new Script();
        txtNom = (EditText) findViewById(R.id.editText);
        txtMdp = (EditText) findViewById(R.id.editText2);
        err = (TextView) findViewById(R.id.textView);
        idBtn = (Button) findViewById(R.id.button);
        idBtn2 = (Button) findViewById(R.id.button4);
        idBtn.setOnClickListener(ecoute);
        idBtn2.setOnClickListener(ecoute2);
    }


    public View.OnClickListener ecoute = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // String mdpCripte2 = sc2.script(txtMdp.getText().toString());
            // String testLogin = WebService.Login(txtNom.getText().toString(),mdpCripte2);
            //Log.i("TEST LLOGGGIINNNN",testLogin);
            //System.out.println(testLogin);
            //if(testLogin.equals("1")==true){
                    Intent intention = new Intent(MainActivity.this,Main2Activity.class);
                    MainActivity.this.startActivityForResult(intention,2);
            //}
            //else if(testLogin.equals("0")==true){
             //   err.setText("Login ou mot de passe incorrect");
            //}
        }
    };

    public View.OnClickListener ecoute2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intention = new Intent(MainActivity.this,InscriptionActivity.class);
            MainActivity.this.startActivityForResult(intention,3);
        }
    };
}
