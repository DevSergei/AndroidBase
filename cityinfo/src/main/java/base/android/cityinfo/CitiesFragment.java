package base.android.cityinfo;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static base.android.cityinfo.CoatOfArmsFragment.PARCEL;

// Фрагмент выбора города из списка
public class CitiesFragment extends ListFragment {

    boolean isExistCoatofarms;  // Можно ли расположить рядом фрагмент с гербом
    Parcel currentParcel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("mytag","onCreate");

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Cities,
                android.R.layout.simple_list_item_activated_1);

        setListAdapter(adapter);

        // Определение, можно ли будет расположить рядом герб в другом фрагменте
        View detailsFrame = getActivity().findViewById(R.id.coat_of_arms);
        View view = getActivity().findViewById(R.id.cities);
        // getActivity - получить контекст активити, где расположен фрагмент
        isExistCoatofarms = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE; //getActivity().getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE;
        // Если это не повторное создание, то восстановим текущую позицию
        if (savedInstanceState != null)
            currentParcel = (Parcel) savedInstanceState.getSerializable("CurrentCity");
        else
            currentParcel = new Parcel(0,
                    getResources().getTextArray(R.array.Cities)[0].toString());

        // Если можно нарисовать рядом герб, то сделаем это
        if (isExistCoatofarms) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showCoatOfArms(currentParcel);
        }

    }

    // При создании фрагмента, укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("mytag","onCreateView");

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Cities,
                android.R.layout.simple_list_item_activated_1);

        setListAdapter(adapter);

        // Определение, можно ли будет расположить рядом герб в другом фрагменте
        View detailsFrame = getActivity().findViewById(R.id.coat_of_arms);
        // getActivity - получить контекст активити, где расположен фрагмент
        isExistCoatofarms = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE; //getActivity().getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE;
        // Если это не повторное создание, то восстановим текущую позицию
        if (savedInstanceState != null)
            currentParcel = (Parcel) savedInstanceState.getSerializable("CurrentCity");
        else
            currentParcel = new Parcel(0,
                    getResources().getTextArray(R.array.Cities)[0].toString());

        // Если можно нарисовать рядом герб, то сделаем это
        if (isExistCoatofarms) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showCoatOfArms(currentParcel);
        }

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    // Активити создана, можно к ней обращаться. Выполним начальные действия
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("mytag","onActivityCreated");

        // Для того, чтобы показать список, надо задействовать адаптер.
        // Такая конструкция работает для списков, например, ListActivity.
        // Здесь создаем из ресурсов список городов (из массива)
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Cities,
                android.R.layout.simple_list_item_activated_1);

        setListAdapter(adapter);

        // Определение, можно ли будет расположить рядом герб в другом фрагменте
        View detailsFrame = getActivity().findViewById(R.id.coat_of_arms);
        // getActivity - получить контекст активити, где расположен фрагмент
        isExistCoatofarms = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE; //getActivity().getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE;
        // Если это не повторное создание, то восстановим текущую позицию
        if (savedInstanceState != null)
            currentParcel = (Parcel) savedInstanceState.getSerializable("CurrentCity");
        else
            currentParcel = new Parcel(0,
                    getResources().getTextArray(R.array.Cities)[0].toString());

        // Если можно нарисовать рядом герб, то сделаем это
        if (isExistCoatofarms) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showCoatOfArms(currentParcel);
        }
    }

    // Сохраним текущую позицию (вызывается перед выходом из фрагмента)
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("CurrentCity", currentParcel);
        Log.i("mytag","onSaveInstanceState");
    }

    // Обработка выбора позиции
    @Override
    public void onListItemClick(ListView l, View view, int position, long id) {
        TextView cityNameView = (TextView) view;
        currentParcel = new Parcel(position, cityNameView.getText().toString());
        showCoatOfArms(currentParcel);
        Log.i("mytag","onListItemClick");
    }

    // Показать герб. Ecли возможно, то показать рядом со списком,
    // если нет, то открыть второе активити
    private void showCoatOfArms(Parcel parcel) {
        if (isExistCoatofarms) {
            // Выделим текущий элемент списка
            getListView().setItemChecked(parcel.getImageIndex(), true);

            // Проверим, что фрагмент с гербом существует в активити
            CoatOfArmsFragment detail = (CoatOfArmsFragment)
                    getFragmentManager().findFragmentById(R.id.coat_of_arms);
            // если есть необходимость, то выведем герб
            if (detail == null || detail.getParcel().getImageIndex() != parcel.getImageIndex()) {

                // Создаем новый фрагмент, с текущей позицией, для вывода герба
                detail = CoatOfArmsFragment.create(parcel);

                // Выполняем транзакцию по замене фрагмента
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.coat_of_arms, detail);  // замена фрагмента
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }
        else {
            // Если нельзя вывести герб рядом, откроем вторую активити
            Intent intent = new Intent();
            intent.setClass(getActivity(), CoatOfArmsActivity.class);
            // и передадим туда параметры
            intent.putExtra(PARCEL, parcel);
            startActivity(intent);
        }
    }
}
