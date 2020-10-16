package com.example.apptonghop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

public class ListMusic extends AppCompatActivity {

    ImageView profile2;
    ListView listView;
    String mTitle[] = {"Cardigan", "Home", "Skyfall", "Lovely", "Saturn", "Mascara"};
    String mDescription[] = {"Taylor Swift", "Michael Bullet", "Adele", "Billie Eilish","Sleeping At Last","Chillies"};
    int images[] = {R.drawable.folk, R.drawable.home,R.drawable.skyfall,R.drawable.lovely,R.drawable.saturn,R.drawable.mascara};
    // so our images and other things are set in array

    // now paste some images in drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_music);

        profile2 = (ImageView) findViewById(R.id.profile2);
        profile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });
        listView = findViewById(R.id.lv);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(ListMusic.this, "Bài hát: Cardigan, Trình bày: Taylor Swift", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(ListMusic.this, "Bài hát: Home, Trình bày: Michael Bullet", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(ListMusic.this, "Bài hát: Skyfall, Trình bày: Adele", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> implements com.example.apptonghop.MyAdapter {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.activity_row_list, R.id.textview1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.activity_row_list, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textview1);
            TextView myDescription = row.findViewById(R.id.textview2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            return row;
        }
    }
    public void openProfile() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

}