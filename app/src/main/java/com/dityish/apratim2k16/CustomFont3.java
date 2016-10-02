package com.dityish.apratim2k16;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomFont3 extends TextView {

    public CustomFont3(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomFont3(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomFont3(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/LemonMilk.ttf");
        setTypeface(tf);
    }
}
