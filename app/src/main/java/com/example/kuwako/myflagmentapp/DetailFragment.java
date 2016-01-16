package com.example.kuwako.myflagmentapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kuwako on 2016/01/16.
 */
public class DetailFragment extends Fragment {
    public DetailFragment() {}

    // コンストラクタに引数を渡してはいけないので、動的にインスタンスを作るための性的なメソッドを作成
    public static DetailFragment newInstance(int position) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        detailFragment.setArguments(args);

        return detailFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View detailView = inflater.inflate(R.layout.view_detail, container, false);
        ((TextView) detailView.findViewById(R.id.detailText)).setText(News.Details[getArguments().getInt("position")]);

        return detailView;
    }
}
