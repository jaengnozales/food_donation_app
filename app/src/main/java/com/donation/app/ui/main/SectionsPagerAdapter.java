package com.donation.app.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.donation.app.Constants;
import com.donation.app.DonateToCharityFragment;
import com.donation.app.R;
import com.donation.app.SetCharityInfoFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] DONATOR_TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private static final int[] CHARITY_TAB_TITLES = new int[]{R.string.tab_text_3, R.string.tab_text_2};
    private final Context mContext;
    private String user;

    public SectionsPagerAdapter(String user, Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        this.user = user;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            if(isCharity()) {
                return SetCharityInfoFragment.newInstance("", "");
            } else {
                return DonateToCharityFragment.newInstance(2);
            }
        }
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(isCharity())
            return mContext.getResources().getString(CHARITY_TAB_TITLES[position]);

        return mContext.getResources().getString(DONATOR_TAB_TITLES[position]);
    }

    private boolean isCharity() {
        return user != null && user.equalsIgnoreCase(Constants.USER_CHARITY);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}