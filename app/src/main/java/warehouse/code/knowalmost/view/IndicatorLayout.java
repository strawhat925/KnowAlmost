package warehouse.code.knowalmost.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import warehouse.code.knowalmost.R;

/**
 * ${DESCRIPTION}
 * package warehouse.code.knowalmost.view
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-22 14:49
 **/
public class IndicatorLayout extends LinearLayout implements ViewPager.OnPageChangeListener {
    private Context context;
    private int count;

    public IndicatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void setViewPage(ViewPager viewPager) {
        count = viewPager.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.indicate_image, null);
            this.addView(view);
        }
        this.getChildAt(0).setSelected(true);
        viewPager.addOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < count; i++) {
            if (i == position) {
                this.getChildAt(i).setSelected(true);
            } else {
                this.getChildAt(i).setSelected(false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
