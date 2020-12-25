package com.chooloo.www.callmanager.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.chooloo.www.callmanager.R;
import com.chooloo.www.callmanager.databinding.ListItemBinding;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListItem extends ConstraintLayout {

    private ListItemBinding binding;

    public ListItem(Context context) {
        super(context);
        setUp(context);
    }

    public ListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ListItem, 0, 0);
        setBigText(a.getString(R.styleable.ListItem_bigText));
        setSmallText(a.getString(R.styleable.ListItem_smallText));
        setHeaderText(a.getString(R.styleable.ListItem_header));
        setImageDrawable(a.getDrawable(R.styleable.ListItem_src));
        a.recycle();

        setUp(context);
    }

    private void setUp(Context context) {
        binding = ListItemBinding.inflate(LayoutInflater.from(context), this, true);
        setClickable(true);
        setFocusable(true);
    }

    public void setBigText(@Nullable String text) {
        binding.listItemBigText.setText(text == null ? "" : text);
    }

    public void setSmallText(@Nullable String text) {
        binding.listItemSmallText.setText(text == null ? "" : text);
        binding.listItemSmallText.setVisibility(text == null ? GONE : VISIBLE);
    }

    public void setHeaderText(@Nullable String text) {
        binding.listItemHeader.listItemHeader.setText(text == null ? "" : text);
        showHeader(text != null);
    }

    public void setImageDrawable(@Nullable Drawable image) {
        if (image != null) {
            binding.listItemImage.setImageDrawable(image);
        }
    }

    public void setImageUri(@Nullable Uri image) {
        binding.listItemImage.setImageURI(image);
    }

    public void showHeader(boolean isShow) {
        binding.listItemHeader.listItemHeader.setVisibility(isShow ? VISIBLE : INVISIBLE);
    }
}
