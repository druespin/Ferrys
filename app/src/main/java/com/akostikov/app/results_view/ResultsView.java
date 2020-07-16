package com.akostikov.app.results_view;


import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public interface ResultsView extends LifecycleOwner {

    void showDbItems();

}
