package base.android.weatherappfragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParamsFragment extends Fragment {

    Parcel currentParcel;
    Switch swPressure;
    Switch swHumidity;
    Switch swWind;
    EditText etCity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("mytag", "onActivityCreated");
        if (savedInstanceState != null && currentParcel != null)
            currentParcel = (Parcel) savedInstanceState.getSerializable("params");
        else
            currentParcel = new Parcel(false,
                    false,
                    false,
                    getResources().getResourceName(R.string.moscow));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("mytag", "onActivityCreated");
        if (savedInstanceState != null && currentParcel != null)
            currentParcel = (Parcel) savedInstanceState.getSerializable("params");
        else
            currentParcel = new Parcel(false,
                    false,
                    false,
                    getResources().getResourceName(R.string.moscow));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_params, container, false);

        swPressure = view.findViewById(R.id.sw_pressure);
        swHumidity = view.findViewById(R.id.sw_humidity);
        swWind = view.findViewById(R.id.sw_wind);
        etCity = view.findViewById(R.id.et_city);

        if (savedInstanceState != null && currentParcel != null) {
            currentParcel = (Parcel) savedInstanceState.getSerializable("params");
        }

        if (currentParcel != null) {
            swPressure.setChecked(currentParcel.isShowPressure());
            swHumidity.setChecked(currentParcel.isShowHumidity());
            swWind.setChecked(currentParcel.isShowWind());
            etCity.setText(currentParcel.getCityName());
        }

        swPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentParcel != null) {
                    currentParcel.setShowPressure(swPressure.isChecked());
                }
            }
        });

        swHumidity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentParcel != null) {
                    currentParcel.setShowHumidity(swHumidity.isChecked());
                }
            }
        });

        swWind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentParcel != null) {
                    currentParcel.setShowWind(swWind.isChecked());
                }
            }
        });
        etCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentParcel != null) {
                    currentParcel.setCityName(String.valueOf(etCity.getText()));
                }
            }
        });

        view.findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.startResultFragment();
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("params", currentParcel);
        getActivity().getSupportFragmentManager().putFragment(outState, "paramsFragment", this);
        Log.i("mytag", "onSaveInstanceState");
    }
}
