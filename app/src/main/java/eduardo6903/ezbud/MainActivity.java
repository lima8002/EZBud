package eduardo6903.ezbud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
//        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);
//        relativeLayout.setBackgroundResource(R.drawable.bg_grad_1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BalanceFragment additionFragment = new BalanceFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayoutContainer, additionFragment).commit();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.action_balance:
                    fragment = new BalanceFragment();

                    FragmentTransaction tBalance = getSupportFragmentManager().beginTransaction();
                    tBalance.replace(R.id.mainFrameLayoutContainer, fragment);
//                    tBalance.addToBackStack(null);
                    tBalance.commit();
                    return true;
                case R.id.action_budget:
                    fragment = new BudgetFragment();
                    FragmentTransaction tBudget = getSupportFragmentManager().beginTransaction();
                    tBudget.replace(R.id.mainFrameLayoutContainer, fragment);
//                    tBudget.addToBackStack(null);
                    tBudget.commit();
                    return true;
                case R.id.action_history:
                    fragment = new HistoryFragment();
                    FragmentTransaction tHistory = getSupportFragmentManager().beginTransaction();
                    tHistory.replace(R.id.mainFrameLayoutContainer, fragment);
//                    tHistory.addToBackStack(null);
                    tHistory.commit();
                    return true;
                case R.id.action_settings:
                    fragment = new SettingsFragment();
                    FragmentTransaction tSettings = getSupportFragmentManager().beginTransaction();
                    tSettings.replace(R.id.mainFrameLayoutContainer, fragment);
//                    tSettings.addToBackStack(null);
                    tSettings.commit();
                    return true;
            }

            return false;
        }
    };






}
