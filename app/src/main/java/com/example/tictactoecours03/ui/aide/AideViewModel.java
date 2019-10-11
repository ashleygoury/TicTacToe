package com.example.tictactoecours03.ui.aide;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AideViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AideViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Simple texte");
    }

    public LiveData<String> getText() {
        return mText;
    }
}