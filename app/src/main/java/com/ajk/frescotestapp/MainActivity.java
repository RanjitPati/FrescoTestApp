package com.ajk.frescotestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] titles = {"Aeroplane", "Arctic hare", "Baboon", "Boat", "Pool", "Peppers", "Barbara",
            "Monarch", "Girl", "Serrano", "Tulips", "Aeroplane", "Arctic hare", "Baboon", "Boat", "Pool", "Peppers", "Barbara",
            "Monarch", "Girl", "Serrano", "Tulips"};

    String[] urls = {"https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
            "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
            "https://homepages.cae.wisc.edu/~ece533/images/baboon.png",
            "https://homepages.cae.wisc.edu/~ece533/images/boat.png",
            "https://homepages.cae.wisc.edu/~ece533/images/pool.png",
            "https://homepages.cae.wisc.edu/~ece533/images/peppers.png",
            "https://homepages.cae.wisc.edu/~ece533/images/barbara.png",
            "https://homepages.cae.wisc.edu/~ece533/images/monarch.png",
            "https://homepages.cae.wisc.edu/~ece533/images/girl.png",
            "https://homepages.cae.wisc.edu/~ece533/images/serrano.png",
            "https://homepages.cae.wisc.edu/~ece533/images/tulips.png",
            "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
            "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
            "https://homepages.cae.wisc.edu/~ece533/images/baboon.png",
            "https://homepages.cae.wisc.edu/~ece533/images/boat.png",
            "https://homepages.cae.wisc.edu/~ece533/images/pool.png",
            "https://homepages.cae.wisc.edu/~ece533/images/peppers.png",
            "https://homepages.cae.wisc.edu/~ece533/images/barbara.png",
            "https://homepages.cae.wisc.edu/~ece533/images/monarch.png",
            "https://homepages.cae.wisc.edu/~ece533/images/girl.png",
            "https://homepages.cae.wisc.edu/~ece533/images/serrano.png",
            "https://homepages.cae.wisc.edu/~ece533/images/tulips.png"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //let's create a local collection to hold some titles and image urls to display
        ArrayList<ImageData> mImageDataCollection = new ArrayList<>();

        //let's put all datas to the collection one by one
        for(int i=0; i<titles.length; i++){
            //Create ImageData objects for each item
            ImageData mImageData = new ImageData();
            mImageData.setTitle(titles[i]);
            mImageData.setImageUrl(urls[i]);
            //now add each object to the collection
            mImageDataCollection.add(mImageData);
        }

        //we are done, just need to put these datas to the our Image List Adapter

        //Listview
        ListView list = findViewById(R.id.lvImageList);

        //Adapter, Context will be the Current Activity i.e (this or CurrentActivityName.this),
        //use getActivity() if you are calling from Fragment
        ImageListAdapter adapter = new ImageListAdapter(this, mImageDataCollection);

        //now set the adapter inside the ListView to reflect the data
        list.setAdapter(adapter);

    }
}
