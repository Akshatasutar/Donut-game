package com.example.donut_game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Lvl2DonutView extends View {
    private Bitmap mutableBitmap;
    private Canvas mSourceCanvas;
    private Paint destPaint = new Paint();
    private Path destPath = new Path();

    public Lvl2DonutView(Context context) {
        super(context) ;
        //convert drawable file into bitmap
        Bitmap rawBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.lvl_2_donut);

        //convert bitmap into mutable bitmap
        mutableBitmap = rawBitmap.copy(Bitmap.Config.ARGB_8888, true);
        //mutableBitmap = Bitmap.createBitmap(rawBitmap.getWidth(), rawBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        //mSourceCanvas.setBitmap(mutableBitmap);
        mSourceCanvas = new Canvas(mutableBitmap);
        mSourceCanvas.drawBitmap(rawBitmap, 0, 0, null);

        destPaint.setAlpha(0);
        destPaint.setAntiAlias(true);
        destPaint.setStyle(Paint.Style.STROKE);
        destPaint.setStrokeJoin(Paint.Join.ROUND);
        destPaint.setStrokeCap(Paint.Cap.ROUND);
        destPaint.setStrokeWidth(50);
        destPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    protected void onDraw(Canvas canvas){
        //Draw path:
        mSourceCanvas.drawPath(destPath, destPaint);
        mSourceCanvas.drawBitmap(mutableBitmap, 0,0, null);

        //int ht = canvas.getHeight();

        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float xPos = event.getX();
        float yPos = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                destPath.moveTo(xPos, yPos);
                break;

            case MotionEvent.ACTION_MOVE:
                destPath.lineTo(xPos, yPos);
                break;

            default:
                return false;
        }

        invalidate();
        return true;
    }
}
