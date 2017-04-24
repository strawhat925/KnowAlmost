package warehouse.code.knowalmost.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.LinkedList;

import warehouse.code.knowalmost.R;
import warehouse.code.knowalmost.activity.WebViewActivity;
import warehouse.code.knowalmost.adapter.ListPostAdapter;
import warehouse.code.knowalmost.adapter.PageCarouseAdapter;
import warehouse.code.knowalmost.bean.PostBean;

/**
 * ${DESCRIPTION}
 * package warehouse.code.knowalmost.view
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-22 13:37
 **/
public class MainFragment extends Fragment {
    private View view;
    private CarouselViewPage viewPager;
    private IndicatorLayout indicatorLayout;
    private PullToRefreshListView listView;
    private ListPostAdapter listPostAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initPostListView();
        initPageView();
    }


    private void initPageView() {
        View pageView = LayoutInflater.from(getActivity()).inflate(R.layout.vp_main, null);
        viewPager = (CarouselViewPage) pageView.findViewById(R.id.vp_main);
        viewPager.setAdapter(new PageCarouseAdapter(getActivity()));
        indicatorLayout = (IndicatorLayout) pageView.findViewById(R.id.indicate_main);
        indicatorLayout.setViewPage(viewPager);
        listView.getRefreshableView().addHeaderView(pageView, null, false);
    }

    private void initPostListView() {
        listView = (PullToRefreshListView) view.findViewById(R.id.main_list_view);
        listView.getRefreshableView().setDivider(null);
        listView.getRefreshableView().setVerticalScrollBarEnabled(false);
        listView.setMode(PullToRefreshBase.Mode.BOTH);

        listPostAdapter = new ListPostAdapter(getActivity());
        listView.setAdapter(listPostAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
                        | DateUtils.FORMAT_SHOW_DATE
                        | DateUtils.FORMAT_ABBREV_ALL);

                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                //刷新数据
                new AsyncTask<Void, Void, String>() {

                    @Override
                    protected String doInBackground(Void... params) {
                        //后台获取数据
                        return null;
                    }

                    @Override
                    protected void onPostExecute(String result) {

                        Toast toast;
                        if (result == null || result.length() == 0) {
                            toast = Toast.makeText(getActivity(), "已显示全部内容", Toast.LENGTH_SHORT);
                        } else {
                            LinkedList<PostBean> postBeans = PostBean.parse(result);
                            listPostAdapter.addPost(postBeans);
                            listPostAdapter.notifyDataSetChanged();
                            toast = Toast.makeText(getActivity(), "刷新" + postBeans.size() + "条记录", Toast.LENGTH_SHORT);
                        }
                        toast.setGravity(Gravity.TOP, 0, 100);
                        toast.show();
                        //
                        listView.getLoadingLayoutProxy(false, true).setPullLabel("");
                        listView.getLoadingLayoutProxy(false, true).setLastUpdatedLabel("正在加载");
                        listView.getLoadingLayoutProxy(false, true).setReleaseLabel("");
                        listView.onRefreshComplete();

                    }
                }.execute();
            }
        });
    }
}
