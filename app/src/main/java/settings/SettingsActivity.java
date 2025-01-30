package settings;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.handbook.R;

public class SettingsActivity extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        if(getSupportActionBar() != null){
            actionBar = getSupportActionBar();
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle(R.string.action_settings);
        }
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
    public boolean onOptionsItemSelected (MenuItem item){
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return (true);

    }


}
