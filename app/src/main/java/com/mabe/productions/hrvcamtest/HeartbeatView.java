package com.mabe.productions.hrvcamtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;


/**
 * This class extends the View class and is designed draw the heartbeat image.
 * 
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class HeartbeatView extends View {

    private static final Matrix matrix = new Matrix();
    private static final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private static Drawable greenDrawable = null;
    private static Drawable redDrawable = null;

    private static int parentWidth = 0;
    private static int parentHeight = 0;

    public HeartbeatView(Context context, AttributeSet attr) {
        super(context, attr);

        greenDrawable = getResources().getDrawable(R.drawable.ic_heart_white);
        redDrawable = getResources().getDrawable(R.drawable.ic_heart);
    }

    public HeartbeatView(Context context) {
        super(context);

        greenDrawable = getResources().getDrawable(R.drawable.ic_heart_white);
        redDrawable = getResources().getDrawable(R.drawable.ic_heart);    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(parentWidth, parentHeight);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onDraw(Canvas canvas) {
        if (canvas == null) throw new NullPointerException();

        Drawable d = null;
        if (HeartRateMonitor.getCurrent() == HeartRateMonitor.TYPE.GREEN){
            d = greenDrawable;
        }else{
            d = redDrawable;
        }
        d.setBounds(canvas.getClipBounds());
        d.draw(canvas);
    }
}
