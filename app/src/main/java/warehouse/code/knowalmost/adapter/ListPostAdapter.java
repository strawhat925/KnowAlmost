package warehouse.code.knowalmost.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.LinkedList;

import warehouse.code.knowalmost.R;
import warehouse.code.knowalmost.bean.PostBean;
import warehouse.code.knowalmost.util.CommonUtils;

/**
 * ${DESCRIPTION}
 * package warehouse.code.knowalmost.adapter
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-22 14:57
 **/
public class ListPostAdapter extends BaseAdapter {
    public LinkedList<PostBean> postBeans;
    private Context context;

    public ListPostAdapter(Context context) {
        this.context = context;
        int[] images = {
                R.drawable.new01,
                R.drawable.new02,
                R.drawable.new03,
                R.drawable.new04,
                R.drawable.new01,
                R.drawable.new03
        };
        String[] testStrings = context.getResources().getStringArray(R.array.testList);
        postBeans = new LinkedList<PostBean>();
        for (int i = 0; i < images.length; i++) {
            PostBean postBean = new PostBean();
            postBean.setImage(images[i]);
            postBean.setText(testStrings[i]);
            postBeans.add(postBean);
        }
    }

    public ListPostAdapter(Context context, LinkedList<PostBean> postBeans) {
        this.postBeans = postBeans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return postBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return postBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("========================================" + position);
        PostBean postBean = postBeans.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.main_list_view, null);
        TextView textView = (TextView) convertView.findViewById(R.id.post_list_text);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.post_list_image);

        textView.setText(CommonUtils.getText(postBean.getText()));
        if (postBean.getImageUrl() != null) {
            ImageLoader.getInstance().displayImage(postBean.getImageUrl(), imageView, CommonUtils.getImageOption(context));
        } else {
            imageView.setImageResource(postBean.getImage());
        }
        convertView.setTag(position);
        return convertView;
    }

    public void addPost(LinkedList<PostBean> newPostBeans) {
        for (int i = 0; i < newPostBeans.size(); i++) {
            postBeans.addFirst(newPostBeans.get(i));
        }
    }
}
