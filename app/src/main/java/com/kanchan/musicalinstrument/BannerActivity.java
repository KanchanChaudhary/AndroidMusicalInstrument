package com.kanchan.musicalinstrument;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.kanchan.musicalinstrument.PermissionApi.LinkPermission;
import com.kanchan.musicalinstrument.PermissionApi.StoragePath;

public class BannerActivity extends AppCompatActivity {
    private ImageView imageView;
    private String imagepath="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BrowseImage();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(BannerActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void BrowseImage() throws Exception {
        // checkPermissionForReadExtertalStorage();
        LinkPermission linkPermisson= new LinkPermission(this);
        linkPermisson.requestPermissionForReadExtertalStorage();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        imageView.setImageURI(uri);
        StoragePath storagePath= new StoragePath(this);
        imagepath = storagePath.getRealPathFromUri(uri);
    }
    }
