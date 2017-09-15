package com.example.dell.erweimasc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

public class MainActivity extends AppCompatActivity {
    private EditText mEt;

    private Button mButs;
    private EditText et;
    private Button btn;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = et.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    Toast.makeText(MainActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                et.setText("");
                Bitmap mBitmap = CodeUtils.createImage(s, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                img.setImageBitmap(mBitmap);
            }
        });
    }

    private void initview() {
        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);
        img = (ImageView) findViewById(R.id.img);

    }
}
