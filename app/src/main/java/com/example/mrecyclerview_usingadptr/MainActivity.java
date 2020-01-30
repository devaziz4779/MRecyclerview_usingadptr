package com.example.mrecyclerview_usingadptr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;

import com.bumptech.glide.Glide;
import com.example.mrecyclerview_usingadptr.adapters.AdapterViewHolder;
import com.example.mrecyclerview_usingadptr.adapters.RecyclerViewAdapter;
import com.example.mrecyclerview_usingadptr.models.SafeJSONArray;
import com.example.mrecyclerview_usingadptr.models.SafeJSONObject;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView,recycle;
    Button allview;
    RecyclerViewAdapter adapter;

    int VIEW_TYPE_HEAD = 1, VIEW_TYPE_BODY = 2;

    SafeJSONObject object = new SafeJSONObject();
    SafeJSONObject objj=new SafeJSONObject();
    boolean isview=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recycle=findViewById(R.id.recycel);
        allview=findViewById(R.id.allview);


        allview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isview){
                    GridLayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),3);
                    recycle.setLayoutManager(layoutManager);

                }
                else {
//                    adapter.setItemsData(narray());
                    LinearLayoutManager layoutManager
                            = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                    recycle.setLayoutManager(layoutManager);
//                    recycle.setAdapter(adapter);
                }
                   isview=!isview;



//                GridLayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),3);
//                recycle.setLayoutManager(layoutManager);
            }
        });
        setupnewadapter();
        Setupadapter();

    }

    private void setupnewadapter() {

        adapter=new RecyclerViewAdapter(getApplicationContext(),R.layout.differentview) {
            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                AdapterViewHolder holder1 = (AdapterViewHolder) holder;
                SafeJSONObject objec=getItem(position);
                if(objec!=null){

                     int pic= objec.getInt("pic");
                    Glide.with(getApplicationContext()).load(pic).into(holder1.getImageView(R.id.imageview));
                   // holder1.getImageView(R.id.imageview).setImageResource(objec.getInt("pic"));
                    holder1.getTextView(R.id.product).setText(objec.getString("key"));
                    holder1.getTextView(R.id.price).setText(objec.getString("key1"));
                   // Glide.with(getActivity()).load(img).into(holderr.getImageView(R.id.image_view));

                }

            }
        };

       adapter.setItemsData(narray());
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recycle.setLayoutManager(layoutManager);
        recycle.setAdapter(adapter);



    }

    private void Setupadapter() {
        adapter = new RecyclerViewAdapter(getApplicationContext(), R.layout.custome_one) {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                if (viewType == VIEW_TYPE_HEAD) {
                    View itemView = LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.custome_one, parent, false);
                    // create ViewHolder
                    return new AdapterViewHolder(itemView);
                } else {
                    View itemView = LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.custome_second, parent, false);
                    // create ViewHolder
                    return new AdapterViewHolder(itemView);
                }
            }


            @Override
            public int getItemViewType(int position) {
                if (getItem(position).getInt("is_header") == 1) {
                    return VIEW_TYPE_HEAD;
                } else {
                    return VIEW_TYPE_BODY;
                }

            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                AdapterViewHolder holderr = (AdapterViewHolder) holder;
                SafeJSONObject obj = getItem(position);
                if (obj != null) {
                    if (getItemViewType(position) == VIEW_TYPE_HEAD) {
                        holderr.getTextView(R.id.textview1).setText(obj.getString("country"));
                        holderr.getTextView(R.id.textview2).setText(obj.getString("capital"));



                    } else {
                        holderr.getTextView(R.id.secondtext).setText(obj.getString("city"));

                    }
                }
            }

        };

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter.setItemsData(array());
        recyclerView.setAdapter(adapter);


    }

    public SafeJSONArray array() {
        SafeJSONArray jsonArray = new SafeJSONArray();
        object = new SafeJSONObject();
        object.putInt("is_header", 1);
        object.putString("country", "Pakistan");
        object.putString("capital", "Islambad");
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();
        object.putInt("is_header", 0);
        object.putString("city", "Islambad");
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();
        object.putInt("is_header", 1);
        object.putString("country", "Afghanistan");
        object.putString("capital", "Kabul");
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();
        object.putInt("is_header", 0);
        object.putString("city", "Kabul");
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();
        object.putInt("is_header", 1);
        object.putString("country", "England");
        object.putString("capital", "London");
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();
        object.putInt("is_header", 0);
        object.putString("city", "Multan");
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();

        object.putInt("is_header", 1);
        object.putString("country", "England");
        object.putString("capital", "London");
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();
        object.putInt("is_header", 0);
        object.putString("city", "Multan");
        jsonArray.addJSONObject(object);




       /* object = new SafeJSONObject();
        object.putInt( "is_header" ,1);
        object.putString( "country" ,"China");
        object.putString( "capital" ,"Shinghai" );
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();
        object.putInt( "is_header" ,0);
        object.putString( "country" ,"Saudia");
        object.putString( "capital" ,"Riyadh" );
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();
        object.putInt( "is_header" ,1);
        object.putString( "country" ,"Japan");
        object.putString( "capital" ,"Tokio" );
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();
        object.putInt( "is_header" ,0);
        object.putString( "country" ,"Sirilanka");
        object.putString( "capital" ,"Colombo" );
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();
        object.putInt( "is_header" ,1);
        object.putString( "country" ,"England");
        object.putString( "capital" ,"London" );
        jsonArray.addJSONObject(object);

        object = new SafeJSONObject();
        object.putInt( "is_header" ,0);
        object.putString( "country" ,"Auterila");
        object.putString( "capital" ,"Canbera" );
        jsonArray.addJSONObject(object);*/
        return jsonArray;


    }




    public  SafeJSONArray narray(){
        SafeJSONArray jarray=new SafeJSONArray();
        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.ic_launcher_foreground);
        objj.putString("key","Samsun");
        objj.putString("key1","price ");
        jarray.addJSONObject(objj);

        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.rose);
        objj.putString("key","Rose");
        objj.putString("key1","price2");
        jarray.addJSONObject(objj);


        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.eaglepng);
        objj.putString("key","Eagle");
        objj.putString("key1","price2");
        jarray.addJSONObject(objj);

        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);

        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);




        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);




        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);


        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);

        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);

        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);

        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);

        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);

        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);

        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);

        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);

        objj=new SafeJSONObject();
        objj.putInt("pic",R.drawable.butterflypng);
        objj.putString("key","butterfly");
        objj.putString("key1","price3");
        jarray.addJSONObject(objj);

        return jarray;
    }

}
