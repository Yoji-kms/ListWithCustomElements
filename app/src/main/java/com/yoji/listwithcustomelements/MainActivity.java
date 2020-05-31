package com.yoji.listwithcustomelements;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.yoji.listwithcustomelements.health_monitoring_system.HealthMonitoringSystemMainFragment;
import com.yoji.listwithcustomelements.main.MainFragment;
import com.yoji.listwithcustomelements.radio_button_by_checkboxes.RadioButtonByCheckboxesMainFragment;
import com.yoji.listwithcustomelements.splash_screen.SplashScreenFirstFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private int appBarLayoutId;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();
        openMainFragment();
    }

    public void initViews (){
        toolbar = findViewById(R.id.toolbarId);
        appBarLayoutId = R.id.appBarLayoutId;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.health_monitoring_system_app:
                openHealthMonitoringSystemFragment();
                break;
            case R.id.notebook_app:
                openNotebookFragment();
                break;
            case R.id.splash_screen_app:
                openSplashScreenFragment();
                break;
            case R.id.universal_input_form_app:
                openUniversalInputFormFragment();
                break;
            case R.id.infinite_activity_loop_app:
                openInfiniteActivityLoopFragment();
                break;
            case R.id.radiobutton_by_checkboxes_app:
                openRadiobuttonByCheckboxesFragment();
                break;
            case R.id.countries_cities_streets_app:
                openCountiesCitiesStreetsFragment();
                break;
            case R.id.task_time_limits_app:
                openTaskTimeLimitsFragment();
                break;
            case R.id.main_screen_app:
                openMainFragment();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openMainFragment(){
        toolbar.setTitle(R.string.app_name);
        toolbar.setLogo(R.drawable.list_with_custom_elements_logo);
        MainFragment fragment = new MainFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(appBarLayoutId, fragment);
        fragmentTransaction.commit();
    }

    public void openNotebookFragment(){
        toolbar.setTitle(R.string.notebook_title);
        toolbar.setLogo(R.drawable.notebook_logo);
        NotebookMainFragment fragment = new NotebookMainFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(appBarLayoutId, fragment);
        fragmentTransaction.commit();
    }

    public void openHealthMonitoringSystemFragment(){
        toolbar.setTitle(R.string.complex_health_monitoring_system_title);
        toolbar.setLogo(R.drawable.health_monitoring_system_logo);
        HealthMonitoringSystemMainFragment fragment = new HealthMonitoringSystemMainFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(appBarLayoutId, fragment);
        fragmentTransaction.commit();
    }

    public void openSplashScreenFragment(){
        toolbar.setTitle(R.string.splash_screen_title);
        toolbar.setLogo(R.drawable.android_mashnin_splash_screen_logo);
        SplashScreenFirstFragment fragment = new SplashScreenFirstFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(appBarLayoutId, fragment);
        fragmentTransaction.commit();
    }

    public void openUniversalInputFormFragment(){
        toolbar.setTitle(R.string.universal_input_form_title);
        toolbar.setLogo(R.drawable.universal_input_form_logo);
        UniversalInputFormMainFragment fragment = new UniversalInputFormMainFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(appBarLayoutId, fragment);
        fragmentTransaction.commit();
    }

    public void openInfiniteActivityLoopFragment(){
        toolbar.setTitle(R.string.infinite_activity_loop_title);
        toolbar.setLogo(R.drawable.infinite_activity_loop_logo);
        InfiniteActivityLoopMainFragment fragment = new InfiniteActivityLoopMainFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(appBarLayoutId, fragment);
        fragmentTransaction.commit();
    }

    public void openRadiobuttonByCheckboxesFragment(){
        toolbar.setTitle(R.string.radio_button_by_checkboxes_title);
        toolbar.setLogo(R.drawable.radiobutton_by_checkboxes_logo);
        RadioButtonByCheckboxesMainFragment fragment = new RadioButtonByCheckboxesMainFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(appBarLayoutId, fragment);
        fragmentTransaction.commit();
    }

    public void openCountiesCitiesStreetsFragment(){
        toolbar.setTitle(R.string.countries_cities_streets_title);
        toolbar.setLogo(R.drawable.countries_cities_streets_logo);
        CountriesCitiesStreetsMainFragment fragment = new CountriesCitiesStreetsMainFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(appBarLayoutId, fragment);
        fragmentTransaction.commit();
    }

    public void openTaskTimeLimitsFragment(){
        toolbar.setTitle(R.string.task_time_limits_title);
        toolbar.setLogo(R.drawable.task_time_limits_logo);
        TaskTimeLimitsMainFragment fragment = new TaskTimeLimitsMainFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(appBarLayoutId, fragment);
        fragmentTransaction.commit();
    }
}