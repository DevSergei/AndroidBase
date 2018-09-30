package base.android.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class RequestActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE_CITY = "base.android.weatherapp.city";
    public static final String EXTRA_MESSAGE_PRESSURE = "base.android.weatherapp.pressure";
    public static final String EXTRA_MESSAGE_HUMIDITY = "base.android.weatherapp.humidity";
    public static final String EXTRA_MESSAGE_WIND = "base.android.weatherapp.wind";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        Button button = findViewById(R.id.btn_get);
        final EditText et = findViewById(R.id.et_city);
        final Switch swPressure = findViewById(R.id.sw_pressure);
        final Switch swHumidity = findViewById(R.id.sw_humidity);
        final Switch swWind = findViewById(R.id.sw_wind);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String city = et.getText().toString();
                intent.putExtra(EXTRA_MESSAGE_CITY, city);
                intent.putExtra(EXTRA_MESSAGE_PRESSURE,swPressure.isChecked());
                intent.putExtra(EXTRA_MESSAGE_HUMIDITY,swHumidity.isChecked());
                intent.putExtra(EXTRA_MESSAGE_WIND,swWind.isChecked());
                startActivity(intent);
            }
        });
    }
}
