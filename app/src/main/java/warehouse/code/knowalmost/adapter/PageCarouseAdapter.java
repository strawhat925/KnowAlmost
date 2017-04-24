package warehouse.code.knowalmost.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.LinkedList;

import warehouse.code.knowalmost.R;

/**
 * 页卡
 * package warehouse.code.knowalmost.view
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-22 15:42
 **/
public class PageCarouseAdapter extends PageBaseAdapter {

    private Context context;

    public PageCarouseAdapter(Context context) {
        views = new LinkedList<View>();
        int[] images = {
                R.drawable.new01,
                R.drawable.new02,
                R.drawable.new03,
                R.drawable.new04
        };
        for (int i = 0; i < images.length; i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.view_page, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.view_page_image);
            imageView.setImageResource(images[i]);
            view.setTag(i);
            views.add(view);
        }
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        System.out.println("==========================" + position);
        View view = views.get(position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("=================" + v.getTag());
                Toast.makeText(context, v.getTag().toString(), Toast.LENGTH_LONG).show();
            }
        });
        container.addView(view);
        return view;
    }
}
