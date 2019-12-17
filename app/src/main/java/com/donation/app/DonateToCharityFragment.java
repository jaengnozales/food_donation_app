package com.donation.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.donation.app.R;
import com.donation.app.ui.main.PageViewModel;
import com.donation.app.ui.main.PlaceholderFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class DonateToCharityFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static DonateToCharityFragment newInstance(int index) {
        DonateToCharityFragment fragment = new DonateToCharityFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_donate_to_charity, container, false);

        Button b = (Button) root.findViewById(R.id.btn_submit);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                findCharities(v);
            }
        });
        return root;
    }


    /** Called when the user taps the Send button */
    public void findCharities(View view) {
        Intent intent = new Intent(getActivity(), FindCharityActivity.class);
        startActivity(intent);
    }



}