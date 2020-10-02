package com.kholis.dev.gamepuzzle;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * 1 October 2020
 *
 * by Nurkholis
 * kholis.dev@gmail.com
 * Android Developers Expert
 *
 * Game sederhana ini saya buat dalam pembelajaran DTS VSGA 2020
 * Cara pertama 1.
 *
 * Link pembelajaran :
 * https://www.wildantechnoart.net/2018/01/cara-membuat-layout-grid-view-di-android-studio.html
 *
 */


public class MainActivity extends AppCompatActivity {

    private String[] item = {"A", "B", "C", "D","E","F","G","H","I","J","K","L","M","N","","O"};
    private String[] success = {"A", "B", "C", "D","E","F","G","H","I","J","K","L","M","N","O",""};
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gvContainer = findViewById(R.id.containerGridView);
        adapter = new ItemAdapter(this);
        adapter.setItem(item);
        adapter.setOnClicked(new OnClicked() {
            @Override
            public void onNumberClicked(int position) {
                switch (position){
                    case 0:
                        if (item[1].equals("")){
                            change(position,1);
                        } else if (item[4].equals("")){
                            change(position,4);
                        }
                        break;
                    case 1:
                        if (item[0].equals("")){
                            change(position,0);
                        } else if (item[2].equals("")){
                            change(position,2);
                        } else if (item[5].equals("")){
                            change(position,5);
                        }
                        break;
                    case 2:
                        if (item[1].equals("")){
                            change(position,1);
                        } else if (item[3].equals("")){
                            change(position,3);
                        } else if (item[6].equals("")){
                            change(position,6);
                        }
                        break;
                    case 3:
                        if (item[2].equals("")){
                            change(position,2);
                        } else if (item[7].equals("")){
                            change(position,7);
                        }
                        break;
                    case 4:
                        if (item[0].equals("")){
                            change(position,0);
                        } else if (item[5].equals("")){
                            change(position,5);
                        } else if (item[8].equals("")){
                            change(position,8);
                        }
                        break;
                    case 5:
                        if (item[1].equals("")){
                            change(position,1);
                        } else if (item[4].equals("")){
                            change(position,4);
                        } else if (item[6].equals("")){
                            change(position,6);
                        } else if (item[9].equals("")){
                            change(position,9);
                        }
                        break;
                    case 6:
                        if (item[2].equals("")){
                            change(position,2);
                        } else if (item[5].equals("")){
                            change(position,5);
                        } else if (item[7].equals("")){
                            change(position,7);
                        } else if (item[10].equals("")){
                            change(position,10);
                        }
                        break;
                    case 7:
                        if (item[3].equals("")){
                            change(position,3);
                        } else if (item[6].equals("")){
                            change(position,6);
                        } else if (item[11].equals("")){
                            change(position,11);
                        }
                        break;
                    case 8:
                        if (item[4].equals("")){
                            change(position,4);
                        } else if (item[9].equals("")){
                            change(position,9);
                        } else if (item[12].equals("")){
                            change(position,12);
                        }
                        break;
                    case 9:
                        if (item[5].equals("")){
                            change(position,5);
                        } else if (item[8].equals("")){
                            change(position,8);
                        } else if (item[10].equals("")){
                            change(position,10);
                        } else if (item[13].equals("")){
                            change(position,13);
                        }
                        break;
                    case 10:
                        if (item[6].equals("")){
                            change(position,6);
                        } else if (item[9].equals("")){
                            change(position,9);
                        } else if (item[11].equals("")){
                            change(position,11);
                        } else if (item[14].equals("")){
                            change(position,14);
                        }
                        break;
                    case 11:
                        if (item[7].equals("")){
                            change(position,7);
                        } else if (item[10].equals("")){
                            change(position,10);
                        } else if (item[15].equals("")){
                            change(position,15);
                        }
                        break;
                    case 12:
                        if (item[8].equals("")){
                            change(position,8);
                        } else if (item[13].equals("")){
                            change(position,13);
                        }
                        break;
                    case 13:
                        if (item[9].equals("")){
                            change(position,9);
                        } else if (item[12].equals("")){
                            change(position,12);
                        } else if (item[14].equals("")){
                            change(position,14);
                        }
                        break;
                    case 14:
                        if (item[10].equals("")){
                            change(position,10);
                        } else if (item[13].equals("")){
                            change(position,13);
                        } else if (item[15].equals("")){
                            change(position,15);
                        }
                        break;
                    case 15:
                        if (item[11].equals("")){
                            change(position,11);
                        } else if (item[14].equals("")){
                            change(position,14);
                        }
                        break;
                }
                adapter.notifyDataSetChanged();
                if(Arrays.equals(item, success)){
                    Toast.makeText(MainActivity.this, "You Win It", Toast.LENGTH_SHORT).show();
                }
            }
        });
        gvContainer.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.actClose){
            MainActivity.this.finish();
        } else if (item.getItemId() == R.id.actUlangi){
            actMethodAcak();
        }
        return true;
    }

    private void actMethodAcak() {
        ArrayList<String> arr = new ArrayList<>();
        for (String item : success) {
            arr.add(item.trim());
        }
        Collections.shuffle(arr);
        int index = 0;
        for (String data :arr){
            item[index] = data;
            index++;
        }
        adapter.notifyDataSetChanged();
    }

    private void change(int asal, int target){
        item[target]=item[asal];
        item[asal]="";
    }

    static class ItemAdapter extends BaseAdapter {

        private OnClicked onClicked;
        private String[] item;
        public void setOnClicked(OnClicked onClicked) {
            this.onClicked = onClicked;
        }

        public void setItem(String[] item) {
            this.item = item;
        }

        private Context mContext;
        ItemAdapter(Context c) {
            mContext = c;
        }
        @Override
        public int getCount() {
            return item.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            TextView tvItem;
            if (view == null) {
                tvItem = new TextView(mContext);
                if (item[i].equals("")){
                    tvItem.setBackgroundColor(Color.BLACK);
                }
                tvItem.setBackgroundColor(Color.parseColor("#ffffff"));
                tvItem.setGravity(TextView.TEXT_ALIGNMENT_CENTER);
                tvItem.setLayoutParams(new GridView.LayoutParams(120, 120));
                tvItem.setPadding(35, 20, 35, 20);
            } else {
                tvItem = (TextView) view;
            }
            tvItem.setTextSize(27);
            tvItem.setText(item[i]);
            tvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClicked.onNumberClicked(i);
                }
            });
            return tvItem;
        }
    }

    public interface OnClicked{
        void onNumberClicked(int position);
    }
}