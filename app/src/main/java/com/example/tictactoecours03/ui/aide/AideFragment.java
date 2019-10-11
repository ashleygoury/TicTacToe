package com.example.tictactoecours03.ui.aide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tictactoecours03.R;

public class AideFragment extends Fragment {

    private AideViewModel aideViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aideViewModel =
                ViewModelProviders.of(this).get(AideViewModel.class);
        View root = inflater.inflate(R.layout.fragment_aide, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        aideViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}