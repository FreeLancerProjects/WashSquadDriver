package com.creative.share.apps.wash_squad_driver.ui_general_method;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;


import com.creative.share.apps.wash_squad_driver.R;
import com.creative.share.apps.wash_squad_driver.tags.Tags;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import io.paperdb.Paper;

public class UI_General_Method {

    @BindingAdapter("error")
    public static void setErrorUi(View view, String error)
    {
        if (view instanceof EditText)
        {
            EditText editText = (EditText) view;
            editText.setError(error);

        }else if (view instanceof TextView)
        {
            TextView textView = (TextView) view;
            textView.setError(error);

        }
    }

    @BindingAdapter("imageEventEndPoint")
    public static void displayImage(RoundedImageView imageView, String imageEndPoint)
    {

        Picasso.with(imageView.getContext()).load(Uri.parse(Tags.IMAGE_URL+imageEndPoint)).placeholder(R.drawable.logo_only).fit().into(imageView);

    }

    @BindingAdapter("imageActivityEndPoint")
    public static void displayImage2(ImageView imageView, String imageEndPoint)
    {        Log.e("image",imageEndPoint);

        Picasso.with(imageView.getContext()).load(Uri.parse(Tags.IMAGE_URL+imageEndPoint)).placeholder(R.drawable.logo_only).fit().into(imageView);

    }

    @BindingAdapter("imageUserEndPoint")
    public static void displayImage3(CircleImageView imageView, String imageEndPoint)
    {
        Picasso.with(imageView.getContext()).load(Uri.parse(Tags.IMAGE_URL+imageEndPoint)).placeholder(R.drawable.logo_only).fit().into(imageView);

    }

    @BindingAdapter({"startDate","endDate"})
    public static void displayDate(TextView textView,String start_date,String end_date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        String sDate = dateFormat.format(new Date(Long.parseLong(start_date)*1000));

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        String eDate = dateFormat2.format(new Date(Long.parseLong(end_date)*1000));

        textView.setText(String.format("%s - %s",sDate,eDate));
    }

    @BindingAdapter({"startTime"})
    public static void displayTime(TextView textView,long start_time)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm aa", Locale.ENGLISH);
        String sTime = dateFormat.format(new Date(start_time*1000));

     //   SimpleDateFormat dateFormat2 = new SimpleDateFormat("hh:mm aa", Locale.ENGLISH);

      //  String eTime = dateFormat2.format(new Date(Long.parseLong(end_time)*1000));

        textView.setText(sTime);
    }

    @BindingAdapter("rate")
    public static void displayRate(SimpleRatingBar simpleRatingBar, double rate)
    {

        simpleRatingBar.setRating((float) rate);
    }
    @BindingAdapter("date")
    public static void convertToDate(TextView textView,long date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd/MM/yyy", Locale.ENGLISH);
        String d = dateFormat.format(new Date(date*1000));
        textView.setText(d);

    }


    @BindingAdapter("event_date")
    public static void convertToEventDate(TextView textView,String date)
    {
        Paper.init(textView.getContext());
        String lang = Paper.book().read("lang",Locale.getDefault().getLanguage());
        long d = Long.parseLong(date)*1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd\n MMM",new Locale(lang));
        String dd = dateFormat.format(new Date(d));
        textView.setText(dd);

    }





}