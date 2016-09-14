package net.tatans.weixin.red.packet;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.umeng.analytics.MobclickAgent;

import java.util.Map;

/**
 * Created by Yuriy on 2016/7/28.
 */
public class ServiceSettingActivity extends Activity {

    private Map<String,String> mapDefaultSettingApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PrefsFragment()).commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public static class PrefsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.service_setting_hello_preference);
        }
    }
}
