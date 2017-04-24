package warehouse.code.knowalmost.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * ${DESCRIPTION}
 * package warehouse.code.knowalmost.view
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-22 14:45
 **/
public class CarouselViewPage extends ViewPager {

    public CarouselViewPage(Context context) {
        super(context);
    }

    public CarouselViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(ev);
    }
}
