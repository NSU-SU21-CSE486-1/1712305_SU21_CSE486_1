package com.hmtsoft.lifecycle.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hmtsoft.lifecycle.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d("MainFragment ", "onCreateView method called");
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("MainFragment ", "onActivityCreated method called");
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("MainFragment ", "onAttach method called");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("MainFragment ", "onViewCreated method called");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("MainFragment ", "onViewStateRestored method called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("MainFragment ", "onStart method called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("MainFragment ", "onResume method called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("MainFragment ", "onPause method called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("MainFragment ", "onStop method called");
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MainFragment ", "onSaveInstanceState method called");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MainFragment ", "onDestroyView method called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MainFragment ", "onDestroy method called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("MainFragment ", "onDetach method called");
    }
}