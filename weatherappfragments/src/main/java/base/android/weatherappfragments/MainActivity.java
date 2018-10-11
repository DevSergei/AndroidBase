package base.android.weatherappfragments;

import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Fragment paramsFragment;
    private ResultFragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            paramsFragment = getSupportFragmentManager()
                    .getFragment(savedInstanceState, "paramsFragment");
        }
        else{
            paramsFragment = new ParamsFragment();
            resultFragment = new ResultFragment();
        }

        if(paramsFragment != null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, paramsFragment)
                        .commit();
                }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        getSupportFragmentManager().putFragment(outState, "paramsFragment", paramsFragment);
    }

    public void startResultFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().remove(paramsFragment);
        fragmentTransaction.add(R.id.fragment_container, resultFragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
//        secondFragment.setShape(shape);
    }
}
