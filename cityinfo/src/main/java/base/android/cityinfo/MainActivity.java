package base.android.cityinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

//Главная активити
public class MainActivity extends AppCompatActivity {
    private Fragment citiesFragment;
    private Fragment coatOfArmsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("mytag","onCreate");
        if(savedInstanceState != null)
        {
            this.citiesFragment = getSupportFragmentManager().getFragment(savedInstanceState,"CitiesFragment");
            this.coatOfArmsFragment = getSupportFragmentManager().getFragment(savedInstanceState,"CoatOfArmsFragment");
        }
        setContentView(R.layout.activity_main);
    }
}
