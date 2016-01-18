package com.example.kuwako.myflagmentapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by kuwako on 2016/01/09.
 */
public class TitlesFragment extends ListFragment {
    public TitlesFragment() {}
    public final static String EXTRA_POSITION = "com.example.kuwako.myflagmentapp.POSITION";
    private OnTitleSelectedListener lister;

    public interface OnTitleSelectedListener {
        public void onTitleSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            lister = (OnTitleSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onTitleSelected");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        lister = null;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                News.Titles
        ));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getActivity(), SubActivity.class);
        intent.putExtra(EXTRA_POSITION, position);

        startActivity(intent);
    }
}
