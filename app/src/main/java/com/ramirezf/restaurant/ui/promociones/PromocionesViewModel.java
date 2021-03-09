package com.ramirezf.restaurant.ui.promociones;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PromocionesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PromocionesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}