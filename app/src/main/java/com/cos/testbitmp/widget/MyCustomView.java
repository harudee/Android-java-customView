package com.cos.testbitmp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.cos.testbitmp.R;

import java.util.ArrayList;

//CustomView
public class MyCustomView extends View {
    private static final String TAG = "MyCustomView";
    //private MainActivity mContext;

    private Paint paint = new Paint();
    private Bitmap bitmap;
    private ArrayList<Bitmap> array_Bitmap = new ArrayList<>();


    private int[] array_Drawable = {
            R.drawable.android_0000,
            R.drawable.android_0001,
            R.drawable.android_0002,
            R.drawable.android_0003,
            R.drawable.android_0004,
            R.drawable.android_0005,
            R.drawable.android_0006,
            R.drawable.android_0007,
            R.drawable.android_0008,
            R.drawable.android_0009,
            R.drawable.android_0010

    };


    //생성자 -> xml에서 사용할 수 있도록
    public MyCustomView(Context context) {
        super(context);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }


    //초기값
    private int nCurrentValue = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        setValue(nCurrentValue);


        //save() 랑 restore()를 까먹지마!
        canvas.save();
        if(array_Bitmap.size() > 0){
            //Log.d(TAG, "onDraw: 실행됨");
            canvas.drawBitmap(array_Bitmap.get(nCurrentValue), 0, 0, paint);

        }
        canvas.restore();

    }


    private int width;
    private int height;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //크기 임의로 지정
        /*width = 2780;
        height = 2780;

        setMeasuredDimension(width, height);*/


    }

    private void init(Context context){
        //공통 작업 처리
        //paint = new Paint();
        //array_Bitmap = new ArrayList<>();

        initDrawingTools();

    }

    private void initDrawingTools(){

        //setImageArray
        if(array_Drawable != null){
            for(int i = 0; i< array_Drawable.length; i++){
                if(true){
                    array_Bitmap.add(BitmapFactory.decodeResource(getContext().getResources(), array_Drawable[i]));

                }
            }
        }

        //bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.android_0003);

    }

    private int nMax = 10;
    private int nMin = 0;
    public void setValue(int nValue){

        //value 값 지정해서 넘어오면 그리기
        if(nValue < nMin)
            nValue = nMin;
        else if(nValue > nMax)
            nValue = nMax;


        if(nCurrentValue != nValue)
            nCurrentValue = nValue;

        postInvalidate();

    }


}


