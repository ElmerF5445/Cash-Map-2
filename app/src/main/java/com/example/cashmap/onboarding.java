package com.example.cashmap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.example.cashmap.data.*;
import com.example.cashmap.data.cashmap_onboarding_data;
import com.example.cashmap.adapters.cashmap_onboarding_adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link onboarding#newInstance} factory method to
 * create an instance of this fragment.
 */
public class onboarding extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public onboarding() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment onboarding.
     */
    // TODO: Rename and change types and number of parameters
    public static onboarding newInstance(String param1, String param2) {
        onboarding fragment = new onboarding();
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

    private ListView Banks_List;
    private List<cashmap_onboarding_data> Banks;
    private cashmap_onboarding_adapter Adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_onboarding, container, false);

        Button button = view.findViewById(R.id.Button_Begin);

        Banks_List = view.findViewById(R.id.Onboarding_Cards_List);

        Banks = new ArrayList<>();
        Banks.add(new cashmap_onboarding_data("Elmer's Bank", R.drawable.pattern_1, R.drawable.logo, "2315 5834 1243"));
        Banks.add(new cashmap_onboarding_data("JC's Finance Group", R.drawable.pattern_1, R.drawable.logo, "8823 4823 5923"));
        Banks.add(new cashmap_onboarding_data("Reniel's Vault", R.drawable.pattern_1, R.drawable.logo, "1295 9455 9230"));
        Banks.add(new cashmap_onboarding_data("Banking to the Heart", R.drawable.pattern_1, R.drawable.logo, "3942 0344 1203"));
        Banks.add(new cashmap_onboarding_data("Marc JuDeposit", R.drawable.pattern_1, R.drawable.logo, "2391 0234 2343"));
        Banks.add(new cashmap_onboarding_data("BANKok ni Juliane", R.drawable.pattern_1, R.drawable.logo, "2939 4923 5493"));

        Adapter = new cashmap_onboarding_adapter(getContext(), Banks, view);
        Banks_List.setAdapter(Adapter);

        // Inflate the layout for this fragment

        // Brought to you by Reniel Baldove
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_onboarding_to_home2);

            }
        });

        return view;
    }
}