package com.zawzaw.savethelibrary.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zawzaw.savethelibrary.R;
import com.zawzaw.savethelibrary.utils.Const;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideFragment extends Fragment
{
    private static final String ARG_PARAM1 = "imageLink";
    private static final String ARG_PARAM2 = "newTitle";

    private String imageLink;
    private String newTitle;

    public SlideFragment() {
        // Required empty public constructor
    }

    public static SlideFragment newInstance(String imageLink, String newTitle) {
        SlideFragment fragment = new SlideFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, imageLink);
        args.putString(ARG_PARAM2, newTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageLink = getArguments().getString(ARG_PARAM1);
            newTitle = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_slide, container, false);
        ImageView imageView = view.findViewById(R.id.main_slider_image);
        TextView textView = view.findViewById(R.id.main_slider_text);

        Glide.with(getActivity().getApplicationContext()).load(Const.IMAGE_URL + imageLink).into(imageView);
        textView.setText(newTitle);

        return view;
    }

}
