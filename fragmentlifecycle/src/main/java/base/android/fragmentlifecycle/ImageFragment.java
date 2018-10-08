package base.android.fragmentlifecycle;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ImageFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("flc","onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("flc","onCreateView");
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("flc","onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("flc","onDetach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("flc","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("flc","onResume");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("flc","onSaveInstanceState");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("flc","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("flc","onStop");
    }
}
