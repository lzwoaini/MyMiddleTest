package com.example.mymiddletest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Integer> number;

    public HomeViewModel() {
        if (number == null) {
            number = new MutableLiveData<>();
            number.setValue(0);
        }
    }

    public void add(int n) {
        number.setValue(number.getValue() + n);
    }

    public MutableLiveData<Integer> getNumber() {
        return number;
    }

    public void setNumber(MutableLiveData<Integer> number) {
        this.number = number;
    }
}