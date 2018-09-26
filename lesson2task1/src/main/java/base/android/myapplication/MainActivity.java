package base.android.myapplication;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
/*
* Здравствуйте, Александр.
* Хотелось выводить в лог то, что пользователь нажимает, а затем выводить какие методы жизн цикла отрабатывают. Не совсем получилось.
* Не совсем ясно как правильно отлавливать такие действия, как нажатие home или "квадратик" и смену ориентации.
* Не ясно почему не выполняется код в методе onConfigurationChanged пока не напишешь в манифесте android:configChanges="orientation|screenSize",
* а после того, как эта строчка написана, код метода начинает исполняться, зато не вызывается цепочка: onCreate-onStart-onResume,
 * которая вызывалась при повороте до внесения изменений в манифест
* */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("lifecycle_tag","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i("lifecycle_tag","onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestart() {
        Log.i("lifecycle_tag","onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.i("lifecycle_tag","onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("lifecycle_tag","onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("lifecycle_tag","onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("lifecycle_tag","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("lifecycle_tag","onDestroy");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Log.i("lifecycle_tag","onBackPressed caused:");
        super.onBackPressed();
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        Log.i("lifecycle_tag","onConfigurationChanged");
//        // Checks the orientation of the screen
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    protected void onUserLeaveHint() // Do not understand what is it, but it tells me about the Home btn pressed.
    {
        Log.d("lifecycle_tag","Home button pressed");
        super.onUserLeaveHint();
    }
}
