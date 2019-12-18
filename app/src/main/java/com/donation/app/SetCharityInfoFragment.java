package com.donation.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SetCharityInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView mTextView;

    private EditText mEdit;

    public SetCharityInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SetCharityInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SetCharityInfoFragment newInstance(String param1, String param2) {
        SetCharityInfoFragment fragment = new SetCharityInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_set_charity_info, container, false);
        mTextView  = (TextView) v.findViewById(R.id.textView8);
        mEdit  = (EditText) v.findViewById(R.id.editText7);
        Button b = (Button) v.findViewById(R.id.button5);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setCharityNeed(v);
            }
        });
        return v;
    }

    // It is safe to access the views here, not in onCreate since it is called before onCreateView
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        if(UserSingleton.getInstance().getCharityNeeds().isEmpty()) {
            mTextView.setText("Charity needs not set yet.");
        } else {
            mTextView.setText("You are currently looking for "+UserSingleton.getInstance().getCharityNeeds()+" food donations.");
        }

    }

    public void setCharityNeed(View view) {
        UserSingleton.getInstance().setCharityNeeds(mEdit.getText().toString());
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }
}
