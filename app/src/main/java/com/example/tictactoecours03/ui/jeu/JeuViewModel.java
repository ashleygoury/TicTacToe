package com.example.tictactoecours03.ui.jeu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JeuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public JeuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }



    public LiveData<String> getText() {
        return mText;
    }
}