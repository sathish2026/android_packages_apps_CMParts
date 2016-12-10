/**
 * Copyright (C) 2015-2016 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cyanogenmod.cmparts.applications;

import android.provider.Settings;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import android.support.v14.preference.SwitchPreference;

import org.cyanogenmod.cmparts.R;
import org.cyanogenmod.cmparts.SettingsPreferenceFragment;

import cyanogenmod.preference.SettingsHelper;

public class screenshot extends SettingsPreferenceFragment
        implements Preference.OnPreferenceChangeListener, SettingsHelper.OnSettingsChangeListener {

 private static final String SCREENSHOT_TYPE = "screenshot_type";

 private ListPreference mScreenshotType;
 
  @Override
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
 
         addPreferencesFromResource(R.xml.ui_tab);
 
         PreferenceScreen prefScreen = getPreferenceScreen();
         ContentResolver resolver = getActivity().getContentResolver();
 
 
         mScreenshotType = (ListPreference) findPreference(SCREENSHOT_TYPE);
         int mScreenshotTypeValue = Settings.System.getInt(getActivity().getContentResolver(),
                 Settings.System.SCREENSHOT_TYPE, 0);
         mScreenshotType.setValue(String.valueOf(mScreenshotTypeValue));
         mScreenshotType.setSummary(mScreenshotType.getEntry());
         mScreenshotType.setOnPreferenceChangeListener(this);
         }

         if  (preference == mScreenshotType) {
             int mScreenshotTypeValue = Integer.parseInt(((String) objValue).toString());
             mScreenshotType.setSummary(
                     mScreenshotType.getEntries()[mScreenshotTypeValue]);
             Settings.System.putInt(getContentResolver(),
                     Settings.System.SCREENSHOT_TYPE, mScreenshotTypeValue);
             mScreenshotType.setValue(String.valueOf(mScreenshotTypeValue));
             return true;
          }
         return false;
      }
  }
