package com.example.kustom.onboardingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ImageView imageView;
    private TextView title, description;



    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images={
            R.mipmap.eat,
            R.mipmap.sleep,
            R.mipmap.code
    };

    public String[] slide_headings={
            "EAT",
            "SLEEP",
            "code"
    };

    public String[] slide_desc={
            "descripcion 1",
            "descripcion 2",
            "descripccion 3"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.slide_layout,container,false);

        imageView= view.findViewById(R.id.slideHeadIv);
        title =view.findViewById(R.id.titleTv);
        description= view.findViewById(R.id.descriptionTv);

        imageView.setImageResource(slide_images[position]);
         title.setText(slide_headings[position]);
         description.setText(slide_desc[position]);

         container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
