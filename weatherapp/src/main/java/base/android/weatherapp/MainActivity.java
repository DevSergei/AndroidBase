package base.android.weatherapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        final String city = intent.getStringExtra(RequestActivity.EXTRA_MESSAGE_CITY);
        boolean pressure = intent.getBooleanExtra(RequestActivity.EXTRA_MESSAGE_PRESSURE,false);
        boolean humidity = intent.getBooleanExtra(RequestActivity.EXTRA_MESSAGE_HUMIDITY,false);
        boolean wind = intent.getBooleanExtra(RequestActivity.EXTRA_MESSAGE_WIND,false);

//      findViewById(R.id.tv_city).setText(message); - why this doesn't work?
        TextView tvCity = findViewById(R.id.tv_city);
        tvCity.setText(city);

        findViewById(R.id.tv_pressure).setVisibility(pressure?View.VISIBLE:View.INVISIBLE);
        findViewById(R.id.tv_humidity).setVisibility(humidity?View.VISIBLE:View.INVISIBLE);
        findViewById(R.id.tv_wind).setVisibility(wind?View.VISIBLE:View.INVISIBLE);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://yandex.com/weather/"+city));
                startActivity(implicit);
            }
        });
    }
}
