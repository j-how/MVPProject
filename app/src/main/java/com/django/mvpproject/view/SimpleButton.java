package com.django.mvpproject.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import com.django.mvpproject.R;
import com.django.mvpproject.utils.MeasureUtils;

import static android.R.attr.maxWidth;

/**
 * Created by dalei on 2017/6/17.
 */

public class SimpleButton extends View {
    String textCountDown;//倒计时
    int mColor;
    int textSize;
    // 遮罩颜色
    private int mScrimColor = Color.argb(0x66, 0xc0, 0xc0, 0xc0);
    // 是否被按住
    private boolean mIsPressed = false;
    // 选中状态背景色
    private int mBgColorChecked = Color.WHITE;

    public String getShowText() {
        return mShowText;
    }

    public void setShowText(String showText) {
        mShowText = showText;
    }

    public int getIconSize() {
        return mIconSize;
    }

    public void setIconSize(int iconSize) {
        mIconSize = iconSize;
    }

    public float getBaseLineDistance() {
        return mBaseLineDistance;
    }

    public void setBaseLineDistance(float baseLineDistance) {
        mBaseLineDistance = baseLineDistance;
    }

    public int getFontLen() {
        return mFontLen;
    }

    public void setFontLen(int fontLen) {
        mFontLen = fontLen;
    }

    public int getFontH() {
        return mFontH;
    }

    public void setFontH(int fontH) {
        mFontH = fontH;
    }

    public int getFontLenChecked() {
        return mFontLenChecked;
    }

    public void setFontLenChecked(int fontLenChecked) {
        mFontLenChecked = fontLenChecked;
    }

    public Paint getPaint() {
        return mPaint;
    }

    public void setPaint(Paint paint) {
        mPaint = paint;
    }

    public RectF getRect() {
        return mRect;
    }

    public void setRect(RectF rect) {
        mRect = rect;
    }

    public int getIconGravity() {
        return mIconGravity;
    }

    public void setIconGravity(int iconGravity) {
        mIconGravity = iconGravity;
    }

    public Drawable getDecorateIcon() {
        return mDecorateIcon;
    }

    public void setDecorateIcon(Drawable decorateIcon) {
        mDecorateIcon = decorateIcon;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public void setTextColor(int textColor) {
        mTextColor = textColor;
    }

    public int getBorderColor() {
        return mBorderColor;
    }

    public void setBorderColor(int borderColor) {
        mBorderColor = borderColor;
    }

    public int getBorderColorChecked() {
        return mBorderColorChecked;
    }

    public void setBorderColorChecked(int borderColorChecked) {
        mBorderColorChecked = borderColorChecked;
    }

    public int getBgColor() {
        return mBgColor;
    }

    public void setBgColor(int bgColor) {
        mBgColor = bgColor;
    }

    public String getTextChecked() {
        return mTextChecked;
    }

    public void setTextChecked(String textChecked) {
        mTextChecked = textChecked;
    }

    // 显示的文字
    private String mShowText;
    // icon大小
    private int mIconSize = 0;
    // 基线偏移距离
    private float mBaseLineDistance;
    // 字体宽度和高度
    private int mFontLen;
    private int mFontH;
    private int mFontLenChecked;
    // 画笔
    private Paint mPaint;
    // 边框矩形
    private RectF mRect;
    // 设置图标的位置，只支持左右两边
    private int mIconGravity = Gravity.LEFT;
    // 装饰的icon
    private Drawable mDecorateIcon;
    // 原始标签颜色
    private int mTextColor = Color.parseColor("#ff666666");
    // 边框颜色
    private int mBorderColor = Color.parseColor("#ff333333");
    // 选中状态边框颜色
    private int mBorderColorChecked = Color.parseColor("#ff333333");
    // 背景色
    private int mBgColor = Color.WHITE;
    // 选中时内容
    private String mTextChecked;
    // 3种外形模式：圆角矩形、圆弧、直角矩形
    public final static int SHAPE_ROUND_RECT = 101;
    public final static int SHAPE_ARC = 102;
    public final static int SHAPE_RECT = 103;

    // 类型模式：正常、可选中、图标选中消失、图标选中切换
    public final static int MODE_NORMAL = 201;
    public final static int MODE_CHECK = 202;
    public final static int MODE_ICON_CHECK_INVISIBLE = 203;
    public final static int MODE_ICON_CHECK_CHANGE = 204;
    // 边框大小
    private float mBorderWidth;
    // 边框角半径
    private float mRadius;
    // 字体水平空隙
    private int mHorizontalPadding;
    // 字体垂直空隙
    private int mVerticalPadding;
    // icon和文字间距
    private int mIconPadding = 0;
    // 字体大小
    private float mTextSize;
    // 显示外形
    private int mTagShape = SHAPE_ROUND_RECT;
    // 显示类型
    private int mTagMode = MODE_NORMAL;
    // 是否自动切换选中状态，不仅能可以灵活地选择切换，通过用于等待网络返回再做切换
    private boolean mIsAutoToggleCheck = false;
    // 是否选中
    private boolean mIsChecked = false;
    // 变化模式下的icon
    private Drawable mDecorateIconChange;
    // 内容
    private String mText;
    // 选中状态字体颜色
    private int mTextColorChecked = Color.parseColor("#ff666666");
    public String getTextCountDown() {
        return textCountDown;
    }

    public void setTextCountDown(String textCountDown) {
        this.textCountDown = textCountDown;
    }
    /**
     * 1.自定义Button 倒计时 ,点击，跳转到主界面。
     * 2.
     */

    public SimpleButton(Context context) {
        super(context);
    }

    public SimpleButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAtrributeSet(context,attrs);
    }

    public SimpleButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initAtrributeSet(Context context,AttributeSet attrs)
    {
//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SimpleButton);
//        textCountDown = a.getString(R.styleable.SimpleButton_textCountDown);
//        mColor = a.getColor(R.styleable.SimpleButton_colorValue, Color.RED);
//        textSize = a.getDimensionPixelOffset(R.styleable.SimpleButton_textSize, 20);
//        a.recycle();

        //自定义View的属性
        mBorderWidth = MeasureUtils.dp2px(context, 0.5f);
        mRadius = MeasureUtils.dp2px(context, 5f);
        mHorizontalPadding = (int) MeasureUtils.dp2px(context, 5f);
        mVerticalPadding = (int) MeasureUtils.dp2px(context, 5f);
        mIconPadding = (int) MeasureUtils.dp2px(context, 3f);
        mTextSize = MeasureUtils.sp2px(context, 14f);

        if (attrs != null)
        {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SimpleButton);
            mTagShape = a.getInteger(R.styleable.SimpleButton_sb_shape, SimpleButton.SHAPE_ROUND_RECT);
            mTagMode = a.getInteger(R.styleable.SimpleButton_sb_mode, MODE_NORMAL);

            if (mTagMode == MODE_CHECK || mTagMode == MODE_ICON_CHECK_INVISIBLE || mTagMode == MODE_ICON_CHECK_CHANGE)
            {
                mIsAutoToggleCheck = true;
                mIsChecked = a.getBoolean(R.styleable.SimpleButton_sb_checked, false);
                mDecorateIconChange = a.getDrawable(R.styleable.SimpleButton_sb_icon_change);
            }
            //是否自动的选择切换状态
            mIsAutoToggleCheck = a.getBoolean(R.styleable.SimpleButton_sb_auto_check, mIsAutoToggleCheck);

            mText = a.getString(R.styleable.SimpleButton_sb_text);
            mTextChecked = a.getString(R.styleable.SimpleButton_sb_text_check);
            mTextSize = a.getDimension(R.styleable.SimpleButton_sb_text_size, mTextSize);
            mBgColor = a.getColor(R.styleable.SimpleButton_sb_bg_color, Color.WHITE);
            mBorderColor = a.getColor(R.styleable.SimpleButton_sb_border_color, Color.parseColor("#ff333333"));
            mBorderColorChecked = a.getColor(R.styleable.SimpleButton_sb_border_color_check, mBorderColor);
            mTextColorChecked = a.getColor(R.styleable.SimpleButton_sb_text_color_check, mTextColor);

            mBorderWidth = a.getDimension(R.styleable.SimpleButton_sb_border_width, mBorderWidth);
            mRadius = a.getDimension(R.styleable.SimpleButton_sb_border_radius, mRadius);

            mHorizontalPadding = (int) a.getDimension(R.styleable.SimpleButton_sb_horizontal_padding, mHorizontalPadding);
            mVerticalPadding = (int) a.getDimension(R.styleable.SimpleButton_sb_vertical_padding, mVerticalPadding);

            mIconPadding = (int) a.getDimension(R.styleable.SimpleButton_sb_icon_padding, mIconPadding);
            mDecorateIcon = a.getDrawable(R.styleable.SimpleButton_sb_icon);
            mIconGravity = a.getInteger(R.styleable.SimpleButton_sb_gravity, Gravity.LEFT);
            a.recycle();
        }
        if (mTagMode == MODE_ICON_CHECK_CHANGE && mDecorateIconChange == null) {
            throw new RuntimeException("You must set the drawable by 'tag_icon_change' property in MODE_ICON_CHECK_CHANGE mode");
        }
        // 如果没有图标则把 mIconPadding 设为0
        if (mDecorateIcon == null && mDecorateIconChange == null) {
            mIconPadding = 0;
        }
        mRect = new RectF();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        setClickable(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int allPadding = _adjustText(getMeasuredWidth());
        int fontLen = mIsChecked ? mFontLenChecked : mFontLen;
        // 如果为精确测量 MeasureSpec.EXACTLY，则直接使用测量的大小，否则让控件实现自适应
        // 如果你用了精确测量则 mHorizontalPadding 和 mVerticalPadding 会对最终大小判定无效
        int width = (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY) ?
                MeasureSpec.getSize(widthMeasureSpec) : allPadding + fontLen;
        int height = (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY) ?
                MeasureSpec.getSize(heightMeasureSpec) : mVerticalPadding * 2 + mFontH;
        setMeasuredDimension(width, height);

        // 计算图标放置位置
        if (mDecorateIcon != null || mDecorateIconChange != null)
        {
            int top = (height - mIconSize) / 2;
            int left;
            if (mIconGravity == Gravity.RIGHT) {
                int padding = (width - mIconSize - fontLen - mIconPadding) / 2;
                left = width - padding - mIconSize;
            } else {
                left = (width - mIconSize - fontLen - mIconPadding) / 2;
            }

            if (mTagMode == MODE_ICON_CHECK_CHANGE && mIsChecked && mDecorateIconChange != null) {
                mDecorateIconChange.setBounds(left, top, mIconSize + left, mIconSize + top);
            } else if (mDecorateIcon != null) {
                mDecorateIcon.setBounds(left, top, mIconSize + left, mIconSize + top);
            }

        }
    }

    private int _adjustText(int maxWidth) {
        if (mPaint.getTextSize() != mTextSize) {
            mPaint.setTextSize(mTextSize);
            final Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
            // 文字高度
            mFontH = (int) (fontMetrics.descent - fontMetrics.ascent);
            // 用来设置基线的偏移量,再加上 getHeight() / 2 就是基线坐标，尼玛折腾了我好久
            mBaseLineDistance = (int) Math.ceil((fontMetrics.descent - fontMetrics.ascent) / 2 - fontMetrics.descent);
        }
        // 计算文字宽度
        if (TextUtils.isEmpty(mText)) {
            mText = "";
        }
        mFontLen = (int) mPaint.measureText(mText);
        if (TextUtils.isEmpty(mTextChecked)) {
            mFontLenChecked = mFontLen;
        } else {
            mFontLenChecked = (int) mPaint.measureText(mTextChecked);
        }
        // 计算图标大小
        if ((mDecorateIcon != null || mDecorateIconChange != null) && mIconSize != mFontH) {
            mIconSize = mFontH;
        }
        // 计算出了文字外所需要占用的宽度
        int allPadding;
        if (mTagMode == MODE_ICON_CHECK_INVISIBLE && mIsChecked) {
            allPadding = mHorizontalPadding * 2;
        } else if (mDecorateIcon == null && !mIsChecked) {
            allPadding = mHorizontalPadding * 2;
        } else {
            allPadding = mIconPadding + mIconSize + mHorizontalPadding * 2;
        }
        // 设置显示的文字
        if (mIsChecked && !TextUtils.isEmpty(mTextChecked)) {
            if (mFontLenChecked + allPadding > maxWidth) {
                float pointWidth = mPaint.measureText(".");
                // 计算能显示的字体长度
                float maxTextWidth = maxWidth - allPadding - pointWidth * 3;
                mShowText = _clipShowText(mTextChecked, mPaint, maxTextWidth);
                mFontLenChecked = (int) mPaint.measureText(mShowText);
            } else {
                mShowText = mTextChecked;
            }
        } else if (mFontLen + allPadding > maxWidth) {
            float pointWidth = mPaint.measureText(".");
            // 计算能显示的字体长度
            float maxTextWidth = maxWidth - allPadding - pointWidth * 3;
            mShowText = _clipShowText(mText, mPaint, maxTextWidth);
            mFontLen = (int) mPaint.measureText(mShowText);
        } else {
            mShowText = mText;
        }
        return allPadding;
    }
    /**
     * 裁剪Text
     * @param oriText
     * @param paint
     * @param maxTextWidth
     * @return
     */
    private String _clipShowText(String oriText, Paint paint, float maxTextWidth) {
        float tmpWidth = 0;
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < oriText.length(); i++) {
            char c = oriText.charAt(i);
            float cWidth = paint.measureText(String.valueOf(c));
            // 计算每个字符的宽度之和，如果超过能显示的长度则退出
            if (tmpWidth + cWidth > maxTextWidth) {
                break;
            }
            strBuilder.append(c);
            tmpWidth += cWidth;
        }
        // 末尾添加3个.并设置为显示字符
        strBuilder.append("...");
        return strBuilder.toString();

    }

    //画框，画文本
    @Override
    protected void onDraw(Canvas canvas)
    {
        // 圆角
        float radius = mRadius;
        if (mTagShape == SHAPE_ARC) {
            radius = mRect.height() / 2;
        } else if (mTagShape == SHAPE_RECT) {
            radius = 0;
        }

        // 绘制背景
        mPaint.setStyle(Paint.Style.FILL);
        if (mIsChecked) {
            mPaint.setColor(mBgColorChecked);
        } else {
            mPaint.setColor(mBgColor);
        }
        canvas.drawRoundRect(mRect, radius, radius, mPaint);

        // 绘制边框
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mBorderWidth);
        if (mIsChecked) {
            mPaint.setColor(mBorderColorChecked);
        } else {
            mPaint.setColor(mBorderColor);
        }
        canvas.drawRoundRect(mRect, radius, radius, mPaint);

        // 绘制文字
        mPaint.setStyle(Paint.Style.FILL);
        if (mIsChecked) {
            mPaint.setColor(mTextColorChecked);
            int padding = mTagMode == MODE_ICON_CHECK_INVISIBLE ? 0 : mIconSize + mIconPadding;
            canvas.drawText(mShowText,
                    mIconGravity == Gravity.RIGHT ? (getWidth() - mFontLenChecked - padding) / 2
                            : (getWidth() - mFontLenChecked - padding) / 2 + padding,
                    getHeight() / 2 + mBaseLineDistance, mPaint);
        } else {
            mPaint.setColor(mTextColor);
            int padding = mDecorateIcon == null ? 0 : mIconSize + mIconPadding;
            canvas.drawText(mShowText,
                    mIconGravity == Gravity.RIGHT ? (getWidth() - mFontLen - padding) / 2
                            : (getWidth() - mFontLen - padding) / 2 + padding,
                    getHeight() / 2 + mBaseLineDistance, mPaint);
        }

        // 绘制Icon
        if (mTagMode == MODE_ICON_CHECK_CHANGE && mIsChecked && mDecorateIconChange != null) {
            mDecorateIconChange.setColorFilter(mPaint.getColor(), PorterDuff.Mode.SRC_IN);
            mDecorateIconChange.draw(canvas);
        } else if (mTagMode == MODE_ICON_CHECK_INVISIBLE && mIsChecked) {
            // Don't need to draw
        } else if (mDecorateIcon != null) {
            mDecorateIcon.setColorFilter(mPaint.getColor(), PorterDuff.Mode.SRC_IN);
            mDecorateIcon.draw(canvas);
        }

        // 绘制半透明遮罩
        if (mIsPressed) {
            mPaint.setColor(mScrimColor);
            canvas.drawRoundRect(mRect, radius, radius, mPaint);
        }
    }

    /**
     * ==================================== 点击监听 ====================================
     */

    private OnCheckedChangeListener mCheckListener;


    public void setCheckListener(OnCheckedChangeListener onCheckedChangeListener)
    {
        mCheckListener = onCheckedChangeListener;
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(boolean isChecked);
    }

}
