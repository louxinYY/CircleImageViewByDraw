package com.shinetechzz.lx.circleimageviewbydraw;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.ImageView;

public class CircleImageViewByDraw extends ImageView {

    private int   contentColor;//详情颜色
    private int   titleColor;//主题颜色
    private int   circleStrokeWidth;//圆线的宽度
    private int   mContentSize;//详情字体大小
    private int   mTitleSize;//主题字体大小
    private int   circleDefaultColor;//默认圆颜色
    private int   circleColor;//百分百元颜色
    private int     mMaxProgress;//百分百最大值
    private int     mProgress;//当前百分比值
    private String  Title;//主题内容
    private String  content;//详情内容
    private int     angle;//初始角度  从3点位置为0度
    private int     allAngle;//转过的角度
    private Paint mPaint;
    private RectF mRectF;
    private int   width, height;
    private Bitmap  bm;
    private Context context;

    public CircleImageViewByDraw(Context context) {
        super(context);
        this.context = context;
    }

    public CircleImageViewByDraw(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }

    public CircleImageViewByDraw(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleStyle);
        mMaxProgress= a.getInt(R.styleable.CircleStyle_circleMaxProgress,360);
        mProgress= a.getInt(R.styleable.CircleStyle_circleProgress,0);
        angle= a.getInt(R.styleable.CircleStyle_circleAngle,0);
        allAngle= a.getInt(R.styleable.CircleStyle_circleAllAngle,360);
        Title= a.getString(R.styleable.CircleStyle_circleTitle);
        content= a.getString(R.styleable.CircleStyle_circleContent);
        circleColor=a.getColor(R.styleable.CircleStyle_circleColor, Color.WHITE);
        circleDefaultColor=a.getColor(R.styleable.CircleStyle_circleDefaultColor,Color.GRAY);
        titleColor=a.getColor(R.styleable.CircleStyle_circletitleColor,Color.WHITE);
        contentColor=a.getColor(R.styleable.CircleStyle_circlecontentColor,Color.WHITE);
        mTitleSize = a.getDimensionPixelSize(R.styleable.CircleStyle_circleTitleSize, (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        mContentSize = a.getDimensionPixelSize(R.styleable.CircleStyle_circleContentSize, (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        circleStrokeWidth= a.getInt(R.styleable.CircleStyle_circleStrokeWidth, 16);
        this.context = context;
        mRectF = new RectF();
        mPaint = new Paint();
        a.recycle();
    }

    @Override
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bm);
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (getDrawable() instanceof ColorDrawable) {
            bm = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
            Canvas canv = new Canvas(bm);
            getDrawable().setBounds(0, 0, 1, 1);
            getDrawable().draw(canv);
        }
    }

    private final int mTxtStrokeWidth = 2;
    @Override
    protected void onDraw(Canvas canvas) {
        height = getHeight();
        width = getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        mPaint.setStyle(Paint.Style.STROKE);

        mPaint.setAntiAlias(true);

        mPaint.setColor(circleDefaultColor);
        mPaint.setStrokeWidth(circleStrokeWidth);

        // 位置
        mRectF.left = 9; // 左上角x
        mRectF.top = 9;// 左上角y
        mRectF.right = width - 9; // 左下角x
        mRectF.bottom = height - 9; // 右下角y
        canvas.drawArc(mRectF, angle, allAngle, false, mPaint);
        mPaint.setColor(circleColor);
        canvas.drawArc(mRectF, angle, ((float) mProgress / mMaxProgress) * allAngle, false, mPaint);


        if (!TextUtils.isEmpty(Title)) {
            mPaint.setColor(titleColor);
            mPaint.setStrokeWidth(mTxtStrokeWidth);
            mPaint.setTextSize(mTitleSize);
            int textWidth = (int) mPaint.measureText(Title, 0, Title.length());
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawText(Title, width / 2 - textWidth / 2, height / 2 +mTitleSize / 2, mPaint);
        }

        if (!TextUtils.isEmpty(content)) {
            mPaint.setColor(contentColor);
            mPaint.setStrokeWidth(mTxtStrokeWidth);
            mPaint.setTextSize(mContentSize);
            int textWidth = (int) mPaint.measureText(content, 0, content.length());
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawText(content, width / 2 - textWidth / 2,height / 2 +3*mTitleSize / 2, mPaint);
        }

    }

    /**
     * 获取最大百分比值
     * @return
     */
    public int getMaxProgress() {
        return mMaxProgress;
    }

    /**
     * 设置最大百分比值
     * @param maxProgress
     */
    public void setMaxProgress(int maxProgress) {
        this.mMaxProgress = maxProgress;
    }

    /**
     * 设置当前百分比值
     * @param progress
     */
    public void setProgress(int progress) {
        this.mProgress = progress;
        this.invalidate();
    }

    public String getTitle() {
        return Title;
    }

    /**
     * 设置title
     * @param Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getContent() {
        return content;
    }

    /**
     * 设置content
     * @param content
     */
    public void setContent(String content) {
        this.content = content;

    }

    /**
     * 设置初始化角度
     * @param angle
     */
    public void setStartAngle(int angle) {
        this.angle = angle;
    }

    /**
     * 设置转过的角度
     * @param angle
     */
    public void setAllAngle(int angle) {
        this.allAngle = angle;
    }


}




