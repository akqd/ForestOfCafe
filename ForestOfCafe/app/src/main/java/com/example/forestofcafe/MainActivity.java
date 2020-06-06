package com.example.forestofcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager(); // 프래그먼트 관리자 생성
    FragmentTransaction transaction ;
    Toolbar toolbar;
    // 프래그먼트 생성
    Profile_fragment profile_fragment = new Profile_fragment();
    Home_fragment home_fragment = new Home_fragment();
    Favorite_fragment favorite_fragment = new Favorite_fragment();
    Community_fragment community_fragment = new Community_fragment();
    Setting_fragment setting_fragment = new Setting_fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("touch", "작동하네요");
        toolbar = findViewById(R.id.toolbar); // 툴바 생성
        setSupportActionBar(toolbar); // 툴바 앱바로 사용
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("카페의 숲"); // 이름 바꿈
        // 뷰 인플레이팅
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_bottom);

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.sv_main, home_fragment).commitNowAllowingStateLoss(); // 초기화면 세팅
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) { // 바텀 바 아이템 터치시 화면 전환
                transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.bottom_community: {
                        transaction.replace(R.id.sv_main, community_fragment).commitNowAllowingStateLoss();
                        break;
                    }
                    case R.id.bottom_favorite: {
                        transaction.replace(R.id.sv_main, favorite_fragment).commitNowAllowingStateLoss();
                        break;
                    }
                    case R.id.bottom_home: {
                        transaction.replace(R.id.sv_main, home_fragment).commitNowAllowingStateLoss();
                        break;
                    }
                    case R.id.bottom_profile: {
                        transaction.replace(R.id.sv_main, profile_fragment).commitNowAllowingStateLoss();
                        break;
                    }
                    case R.id.bottom_setting: {
                        transaction.replace(R.id.sv_main, setting_fragment).commitNowAllowingStateLoss();
                        break;
                    }

                }
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
                Intent intent = new Intent(getApplicationContext(),Search_Activity.class);
                startActivity(intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
