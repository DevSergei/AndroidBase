package base.android.fragmentlifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import base.android.fragmentlifecycle.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements DataFragment.OnFragmentInteractionListener,
                                                               ListFragment.OnListFragmentInteractionListener {
    public static final String tag = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(tag, "onCreate Activity");
    }

    @Override
    public void onFragmentInteraction() {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
