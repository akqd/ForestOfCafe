package com.example.forestofcafe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {
    final static long FINISH_INTERVAL_TIME = 2000; // ms 단위 1 second = 1000ms
    long backPressedTime;
    FragmentManager fragmentManager = getSupportFragmentManager(); // 프래그먼트 관리자 생성
    FragmentTransaction transaction;
    Toolbar toolbar;
    // 프래그먼트 생성
    Profile_fragment profile_fragment = new Profile_fragment();
    Home_fragment home_fragment = new Home_fragment();
    Favorite_fragment favorite_fragment = new Favorite_fragment();
    Community_fragment community_fragment = new Community_fragment();
    Setting_fragment setting_fragment = new Setting_fragment();
    BottomNavigationView bottomNavigationView;
    NestedScrollView sv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar); // 툴바 생성
        setSupportActionBar(toolbar); // 툴바 앱바로 사용
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("카페의 숲"); // 이름 바꿈
        // 뷰 인플레이팅
        sv_main = findViewById(R.id.sv_main);
        bottomNavigationView = findViewById(R.id.navigation_bottom);
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.sv_main, home_fragment,"home").commit(); // 초기화면 세팅
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) { // 바텀 바 아이템 터치시 화면 전환
                int count = fragmentManager.getBackStackEntryCount();
                for(int i = 0 ; i < count ; ++i){
                    fragmentManager.popBackStack();
                }
                transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.bottom_community: {
                        sv_main.scrollTo(0,0);
                        transaction.replace(R.id.sv_main, community_fragment);
                        break;

                    }
                    case R.id.bottom_favorite: {
                        sv_main.scrollTo(0,0);
                        transaction.replace(R.id.sv_main, favorite_fragment);
                        break;
                    }
                    case R.id.bottom_home: {
                        sv_main.scrollTo(0,0);
                        transaction.replace(R.id.sv_main, home_fragment);
                        break;

                    }
                    case R.id.bottom_profile: {
                        sv_main.scrollTo(0,0);
                        transaction.replace(R.id.sv_main, profile_fragment);
                        break;
                    }
                    case R.id.bottom_setting: {
                        sv_main.scrollTo(0,0);
                        transaction.replace(R.id.sv_main, setting_fragment);
                        break;
                    }
                }
                transaction.commit();
                return true;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //함수 재정의 툴바에 아이콘 올리기
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_search: {
                Log.d("touch", "작동하네요");
                Toast.makeText(this, "서치 버튼 클릭", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Search_Activity.class);
                startActivity(intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void replaceFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.sv_main, fragment,tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() == 0) {
            long tempTime = System.currentTimeMillis();
            long intervalTime = tempTime - backPressedTime;
            if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
                finishAffinity();
                System.runFinalization();
                System.exit(0);
            } else {
                backPressedTime = tempTime;
                Toast.makeText(this, "뒤로가기 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        super.onBackPressed();
    }
/*    public void updateBottomMenu() {
        Fragment tag1 = fragmentManager.findFragmentByTag("profile");
        Fragment tag2 = fragmentManager.findFragmentByTag("favorite");
        if (tag1 != null && tag1.isVisible()) {
            bottomNavigationView.getMenu().findItem(R.id.bottom_profile).setChecked(true);
        } else if (tag2 != null && tag2.isVisible()) {
            bottomNavigationView.getMenu().findItem(R.id.bottom_favorite).setChecked(true);
        }
    }*/
}

