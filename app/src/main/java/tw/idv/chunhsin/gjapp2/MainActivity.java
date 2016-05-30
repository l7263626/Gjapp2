package tw.idv.chunhsin.gjapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText celsius;
    Button btnGetFahrentheit;
    TextView fahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsius = (EditText) findViewById(R.id.celsius);
        btnGetFahrentheit = (Button)findViewById(R.id.btnGetFahrenheit);
        fahrenheit = (TextView)findViewById(R.id.fahrenheit);

        BtnClickListener clickListener = new BtnClickListener();
        btnGetFahrentheit.setOnClickListener(clickListener);
    }

    class BtnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            double c=0.0,f=0.0;
            try {
                c = Double.parseDouble(celsius.getText().toString());
                f = 9.0 / 5.0 * c + 32;
                fahrenheit.setText("華氏" + f + "度");
            }catch(NumberFormatException e){
                Toast.makeText(MainActivity.this,"沒有輸入數字",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
