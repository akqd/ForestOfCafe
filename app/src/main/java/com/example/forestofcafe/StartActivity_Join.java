package com.example.forestofcafe;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity_Join extends AppCompatActivity {
    TextView tvAddProfileImage;
    ImageView imgProfile;
    EditText edtID, edtPassword,edtPasswordRepeat, edtNickName, edtName, edtPhoneNumber, edtArea, edtEmail;
    Button btnOverlapCheck, btnJoin;
    Profile_CustomDialog dialog;

    private final int GET_GALLERY_IMAGE = 200;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_join);
        setTitle("회원가입");

        tvAddProfileImage = findViewById(R.id.tvAddProfileImage);

        imgProfile = findViewById(R.id.imgProfile);

        edtID = findViewById(R.id.edtID);
        edtPassword = findViewById(R.id.edtPassword);
        edtPasswordRepeat = findViewById(R.id.edtPasswordRepeat);
        edtNickName = findViewById(R.id.edtNickName);
        edtName = findViewById(R.id.edtName);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        edtArea = findViewById(R.id.edtArea);
        edtEmail = findViewById(R.id.edtEmail);

        btnOverlapCheck = findViewById(R.id.btnOverlapCheck);
        btnJoin = findViewById(R.id.btnJoin);

        tvAddProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });

        btnOverlapCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //중복버튼을 클릭했을 때 작성된 edtID를 비교해야 한다.
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = null;

                View.OnClickListener postiveListner = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(),"회원가입을 축하드립니다! 로그인해볼까요?", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        Intent intent = new Intent(getApplicationContext(), StartActivity_Login.class);
                        startActivity(intent);
                    }
                };
                View.OnClickListener negativeListner = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(StartActivity_Join.this,"취소 버튼을 누르셨습니다.",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                };
                dialog = new Profile_CustomDialog(StartActivity_Join.this,"회원가입을 하시겠습니까?",postiveListner,negativeListner);
                dialog.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GET_GALLERY_IMAGE && requestCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            imgProfile.setImageURI(selectedImageUri);
        }
    }
}
