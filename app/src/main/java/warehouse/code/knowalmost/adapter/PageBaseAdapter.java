package warehouse.code.knowalmost.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

/**
 * ${DESCRIPTION}
 * package warehouse.code.knowalmost.adapter
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-22 15:43
 **/
public class PageBaseAdapter extends PagerAdapter {
    protected LinkedList<View> views;

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }
}
