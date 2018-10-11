package base.android.weatherappfragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ParamsFragment paramsFragment;
    private ResultFragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paramsFragment = new ParamsFragment();
        resultFragment = new ResultFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, paramsFragment)
                .commit();
    }

    public void startResultFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().remove(paramsFragment);
        fragmentTransaction.add(R.id.fragment_container, resultFragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
//        secondFragment.setShape(shape);
    }
}
