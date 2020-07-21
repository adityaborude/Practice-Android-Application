package com.example.techteamselectionapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    TabLayout tabLayout;
    ItemAdapter1 itemAdapter1;
    Handler handler;
    Runnable update;
    int page;
    ArrayList<String> images = new ArrayList<>();

    ImageButton favourite;
    MaterialToolbar toolbar;

    RecyclerView recyclerView;
    ItemAdapter2 itemAdapter2;
    ArrayList<ListItem> listItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        viewPager2 = findViewById(R.id.photos_viewpager);
        tabLayout = findViewById(R.id.tab_layout);
        images.add("https://cdn.windowsreport.com/wp-content/uploads/2020/04/best-jazz-music-software.jpg");
        images.add("https://www.99images.com/photos/wallpapers/music/jazz-musicandroid-iphone-desktop-hd-backgrounds-wallpapers-1080p-4k-9nti5.jpg?v=1583636882");
        images.add("https://www.desktopbackground.org/download/960x544/2015/01/11/885233_miles-davis-abstract-jazz-music-wallpapers_1920x1080_h.jpg");
        photoGallery();

        favourite = findViewById(R.id.favourite);
        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favouriteButtonPressed();
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        listItems.add(new ListItem("https://www.radioandmusic.com/sites/www.radioandmusic.com/files/images/entertainment/2018/11/20/jazz_0.jpg",
                SpannableString.valueOf("NOV\n23"),
                "The NCPA International Jazz Festival",
                "Tata Theatre, The NCPA",
                "Rs 269"));
        listItems.add(new ListItem("https://www.mumbailive.com/images/media/images/images_1573462796563_N4.jpg?bg=faf9f9&crop=1368%2C768%2C0%2C0&fit=fill&h=768&height=768&w=1368&width=1368",
                SpannableString.valueOf("NOV\n29"),
                "The NCPA Add Art Festival",
                "Tata Theatre, The NCPA",
                "Rs 329"));
        listItems.add(new ListItem("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTpnIz9CdxelZUa8gj2dXyhGmUrLHTYS9sIGQ&usqp=CAU",
                SpannableString.valueOf("JAN\n25"),
                "NCPA - Jim Porto: My Braziliand Suingue",
                "Tata Theatre, The NCPA",
                "Rs 349"));
        listItems.add(new ListItem("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQWz36Ilnhk7_nwa6VDxMaSRtd1lmzcMMNkrg&usqp=CAU",
                SpannableString.valueOf("MAR\n05"),
                "NCPA - Artie's Festival India",
                "Experimental Theatre, The NCPA",
                "Rs 229"));
        listItems.add(new ListItem("https://lh3.googleusercontent.com/proxy/fkgr8L25gmGIwaWSaWrnfALn4iQbbOeYbo8gsGZz-aYX4f-y38-eG6oWEO8L6iAUh_4avjGjXfhIhX73RbnNRkWSVME1Je-XwucsKPf54eb6shol4fkUCbvoRPOKJ8pL2CmYevilYGFh_nYVQOkJ",
                SpannableString.valueOf("MAY\n02"),
                "The NCPA May Festival",
                "Tata Theatre, The NCPA",
                "Rs 279"));
        setListItems();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

    public void photoGallery() {
        itemAdapter1 = new ItemAdapter1(this, images);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setAdapter(itemAdapter1);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
            }
        }).attach();

        page = viewPager2.getCurrentItem();
        handler = new Handler();
        update = new Runnable() {
            @Override
            public void run() {
                if(viewPager2.getCurrentItem()==images.size()-1)
                    page = 0;
                viewPager2.setCurrentItem(page++, true);
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3500, 3500);
    }

    public void favouriteButtonPressed() {
        if(favourite.getTag().equals("Not Selected")) {
            favourite.setImageResource(R.drawable.ic_baseline_favorite_24);
            favourite.setTag("Selected");
        }
        else {
            favourite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
            favourite.setTag("Not Selected");
        }
    }

    public void setListItems() {
        itemAdapter2 = new ItemAdapter2(listItems, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter2);
        recyclerView.setHasFixedSize(true);
    }
}