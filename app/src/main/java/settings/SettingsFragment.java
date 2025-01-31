package settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.annotation.Nullable;

import com.example.handbook.R;

public class SettingsFragment extends PreferenceFragment {

   public void onCreate (@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       addPreferencesFromResource(R.xml.preference_screen);


    }


}
