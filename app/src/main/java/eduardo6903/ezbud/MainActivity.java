package eduardo6903.ezbud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import eduardo6903.ezbud.entities.User;
import eduardo6903.ezbud.fragments.*;
//import eduardo6903.ezbud.fragments.BudgetOutcomeFragment;
//import eduardo6903.ezbud.fragments.HistoryWeekFragment;
//import eduardo6903.ezbud.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView btNav = findViewById(R.id.bottom_navigation);
        btNav.setOnNavigationItemSelectedListener(this);

        loadFragment(new BalanceFragment());

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()) {
            case R.id.action_balance:
                fragment = new BalanceFragment();
                break;
            case R.id.action_budget:
                fragment = new BudgetOutcomeFragment();
                break;
            case R.id.action_history:
                fragment = new HistoryFragment();
                break;
            case R.id.action_settings:
                fragment = new SettingsFragment();
                break;
        }
        return loadFragment(fragment);
    }

    public boolean loadFragment (Fragment fragment){
        if (fragment != null ) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainFrameLayoutContainer, fragment)
                    .commit();
        }

        return false;
    }
}
