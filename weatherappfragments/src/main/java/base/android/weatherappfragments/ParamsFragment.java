package base.android.weatherappfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParamsFragment extends Fragment {


    public ParamsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_params, container, false);
         view.findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 MainActivity mainActivity = (MainActivity)getActivity();
                 mainActivity.startResultFragment();
             }
         });
        return view;
    }

}
