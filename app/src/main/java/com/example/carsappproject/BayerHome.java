package com.example.carsappproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.carsappproject.fragments.ProfileFragment;
import com.example.carsappproject.fragments.RecyclerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BayerHome extends AppCompatActivity {


    private BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.FrameConatiner,new RecyclerFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottombar_nav);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment temp=null;

                switch (item.getItemId())
                {
                    case R.id.home_item : temp=new RecyclerFragment();
                        break;
                    case R.id.profile_item : temp=new ProfileFragment();
                        break;
                    case R.id.sale_item :
                        Intent intent2 = new Intent(BayerHome.this, AdCarActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.rent_item:
                        Intent intent = new Intent(BayerHome.this, Home.class);
                        startActivity(intent);
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.FrameConatiner,temp).commit();

                return true;
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu,menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.profile_item){
            Toast.makeText(this, "profil item", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(BayerHome.this, ProfileFragment.class);
            startActivity(intent2);
            return true;
        }
        return super.onContextItemSelected(item);
    }


/*
    private BottomNavigationView bottomNavigationView;
    private BadgeDrawable badgeDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new RecyclerFragment()).commit();
            bottomNavigationView=findViewById(R.id.bottombar_nav);
            badgeDrawable=bottomNavigationView.getOrCreateBadge(androidx.appcompat.R.id.message);
            badgeDrawable.setNumber(1000);

            bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@org.jetbrains.annotations.NotNull MenuItem item) {
                    badgeDrawable=bottomNavigationView.getBadge((item.getItemId()));
                    if(badgeDrawable!=null){
                        badgeDrawable.clearNumber();
                    }
                    Fragment fragment=null;

                    switch (item.getItemId()){

                        case R.id.home_item:
                            fragment=new RecyclerFragment();
                            break;
                        case R.id.profile_item:
                            fragment=new ProfileFragment();
                            break;
                        case R.id.sale_item:
                            Intent intent2 = new Intent(Home.this, AdCarActivity.class);
                            startActivity(intent2);
                            break;
                    }

                    return;
                }
            });

        }
       /* super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new RecyclerFragment()).commit();*/
    //binding=ActivityMainBinding.inflate(getLayoutInflater());
    // setContentView(binding.getRoot());
    //
    //bottomNavigationView=findViewById(R.id.bottombar_nav);
    // bottomNavigationVie
    // .setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
    //     @Override
    //public void onNavigationItemReselected(@NonNull MenuItem item) {
    //   Fragment fragment=null;
    // switch (item.getItemId()) {
    //     case R.id.profile_item:
    //   fragment=new
    //  }
    //  }
    //});

/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.itemAdd){
            Toast.makeText(this, "Add item", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(Home.this, AdCarActivity.class);
            startActivity(intent2);
            return true;
        }
        return super.onContextItemSelected(item);
    }*/
    /* private ImageView addCar;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Ads");
    private MyAdapter adapter;
    private ArrayList<Ad> adsList;
    private View itemAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbar);
        addCar=findViewById(R.id.addbtn);
        addCar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(Home.this, AdCarActivity.class);
                startActivity(intent2);
            }

        });





        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adsList = new ArrayList<Ad>();
        clearAll();
        getDataFromFireBase();
       /* adapter = new MyAdapter(this , AdsList);

        recyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Ad ad = dataSnapshot.getValue(Ad.class);
                    AdsList.add(ad);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
/*
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    //get data from firebase
    public void getDataFromFireBase() {
        adapter = new MyAdapter(this , adsList);

        recyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Ad ad = dataSnapshot.getValue(Ad.class);
                    adsList.add(ad);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    //clear data
    public void clearAll() {
        if(adsList!=null){
            adsList.clear();
        }
        else adsList=new ArrayList<Ad>();
    }
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addCar=findViewById(R.id.addbtn);
        addCar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent2 = new Intent(Home.this, AdCarActivity.class);
                startActivity(intent2);
            }
        });
    }*/
}