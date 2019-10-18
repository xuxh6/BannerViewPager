package com.example.zhpan.circleviewpager.activity;

import android.os.Bundle;

import com.example.zhpan.circleviewpager.R;
import com.example.zhpan.circleviewpager.viewholder.ImageResourceViewHolder;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.bannerview.constants.PageStyle;
import com.zhpan.bannerview.utils.DpUtils;

public class PageStyleActivity extends BaseDataActivity {
    private BannerViewPager<Integer, ImageResourceViewHolder> mBannerViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_style);
        mBannerViewPager = findViewById(R.id.banner_view);
        setupBanner();
    }

    private void setupBanner() {
        mBannerViewPager
                .setPageMargin(DpUtils.dp2px(20))
                .setRevealWidth(DpUtils.dp2px(20))
                .setHolderCreator(ImageResourceViewHolder::new)
                .setPageStyle(PageStyle.MULTI_PAGE)
                .create(mDrawableList);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBannerViewPager.stopLoop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBannerViewPager.startLoop();
    }
}
