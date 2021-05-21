package com.sgr.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {
    ColorPickerView colorPickerView;
    TextView text;
    ImageView img;
    int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
        colorPickerView=findViewById(R.id.colorPickerView);
        img=findViewById(R.id.img);
        color= Color.RED;
        colorPickerView.setColorListener(new ColorEnvelopeListener() {
            @Override
            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                text.setText("#" + envelope.getHexCode().substring(2));
                text.setBackgroundColor(envelope.getColor());
                color=envelope.getColor();
            }
        });
       Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageBitmap(getTextBitmap(color));
            }
        });
    }
    public static Bitmap getTextBitmap(int color)
    {

        Bitmap back= Bitmap.createBitmap(100
                ,100
                , Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(back);
        canvas.drawColor(color);
        return back;
    }

}
