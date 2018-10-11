package base.android.cityinfo;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// Фрагмент для вывода герба
public class CoatOfArmsFragment extends Fragment {

    public static final String PARCEL = "parcel";

    // фабричный метод, создает фрагмент и передадет параметр
    public static CoatOfArmsFragment create(Parcel parcel) {
        CoatOfArmsFragment f = new CoatOfArmsFragment();    // создание

        // передача параметра
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, parcel);
        f.setArguments(args);
        return f;
    }

    // получить индекс из списка (фактически из параметра)
    public Parcel getParcel() {
        return (Parcel) getArguments().getSerializable(PARCEL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_coatofarm, container, false);
        // определить какой герб надо показать, и показать его
        ImageView coatOfArms  = layout.findViewById(R.id.imageView);
        TextView cityNameView = layout.findViewById(R.id.textView);

        // получить из ресурсов массив указателей на изображения гербов
        TypedArray imgs = getResources().obtainTypedArray(R.array.coatofarms_imgs);
        Parcel parcel = getParcel();

        // выбрать по индексу подходящий
        coatOfArms.setImageResource(imgs.getResourceId(parcel.getImageIndex(), -1));
        imgs.recycle();
        cityNameView.setText(parcel.getCityName());

        return layout; // Вместо макета используем сразу картинку
    }
}
