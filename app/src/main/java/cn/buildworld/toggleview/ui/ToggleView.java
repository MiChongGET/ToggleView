package cn.buildworld.toggleview.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：MiChong on 2017/6/7 0007 21:25
 * 邮箱：1564666023@qq.com
 *
 *
 * 自定义开关
 * Android的界面流程
 * 测量       摆放      绘制
 * measure -> layout -> draw
 *
 * onMeasure -> onLayout -> onDraw重写这些方法，实现自定义控件
 *
 * View
 * onMeasure(在这个方法里面指定自己的宽高) -> onDraw(绘制自己的内容)
 *
 * ViewGroup
 * onMeasure(指定自己的宽高,所有子View的宽高) ->onLayout(摆放所有的子View) -> onDraw(绘制自己的内容)
 *
 */
public class ToggleView extends View {

    private Bitmap switchBitmap;
    private Bitmap decodeResource;
    private  Paint paint;
    private boolean mSwitchState = false; // 开关状态, 默认false
    /**
     * 用于代码创建控件
     * @param context
     */
    public ToggleView(Context context) {
        super(context);
        init();
    }

    /**
     * 用于XML里使用，可指定自定义属性
     * @param context
     * @param attrs
     */
    public ToggleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    /**
     * 用于XML里使用，可指定自定义属性，如果指定了样式，则走此函数
     * @param context
     * @param attrs
     */
    public ToggleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
      paint  = new Paint();
    }



    /**
     * 设置背景图片
     * @param switch_background
     */
    public void setSwitchBackgroundResouce(int switch_background) {

        switchBitmap = BitmapFactory.decodeResource(getResources(), switch_background);

    }

    /**
     * 设置滑块图片资源
     * @param slide_button
     */
    public void setSlideButtonResouce(int slide_button) {
        decodeResource = BitmapFactory.decodeResource(getResources(), slide_button);
    }


    /**
     * 设置开关状态
     * @param b
     */
    public void setSwitchState(boolean b) {
        this.mSwitchState = b;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(switchBitmap.getWidth(),switchBitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //1、绘制背景

        canvas.drawBitmap(switchBitmap,0,0,paint);

        //2、滑块
        if (mSwitchState){//开

            int newLeft = switchBitmap.getWidth() - decodeResource.getWidth();
            canvas.drawBitmap(decodeResource,newLeft,0,paint);
        }else {//关
            canvas.drawBitmap(decodeResource,0,0,paint);
        }

    }
}
