package com.example.mymiddletest;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserFragment extends Fragment {

    private UserViewModel myViewModel;

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.user_fragment, container, false);
        textViewOutLogin = view.findViewById(R.id.textView13);
        textViewInfo = view.findViewById(R.id.textView14);
        return view;
    }

    private TextView textViewOutLogin,textViewInfo;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        textViewInfo.setText("Hello! "+myViewModel.getUsername());
        textViewOutLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.outLogin();
                Intent intent = new Intent(getActivity().getApplication(),MainActivity.class);
                startActivity(intent);

            }
        });
        // TODO: Use the ViewModel

    }

}