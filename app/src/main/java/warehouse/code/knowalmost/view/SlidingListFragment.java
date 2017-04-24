package warehouse.code.knowalmost.view;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import warehouse.code.knowalmost.R;
import warehouse.code.knowalmost.activity.MainActivity;

/**
 * ${DESCRIPTION}
 * package warehouse.code.knowalmost.view
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-24 10:05
 **/
public class SlidingListFragment extends ListFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_left_fragment, container, false);
    }


    private class ListOnClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new MainFragment();
                    break;
                case 1:
                    fragment = new MainFragment();
                    break;
                case 2:
                    fragment = new ContentFragment();
                    break;
                default:
                    fragment = new MainFragment();
                    break;
            }
            switchFragment(fragment);
        }
    }


    private void switchFragment(Fragment fragment) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.switchFragment(fragment);
    }


    private ListView listView;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = getListView();
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),
                this.getData(),
                R.layout.menu_left_list,
                new String[]{ "image", "text" },
                new int[]{ R.id.menu_list_image, R.id.menu_list_text });
        listView.setAdapter(simpleAdapter);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setOnItemClickListener(new ListOnClickListener());
    }


    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int[] images = {
                R.mipmap.menu_home,
                R.mipmap.menu_management,
                R.mipmap.menu_collect,
                R.mipmap.menu_message,
                R.mipmap.menu_setting
        };

        String[] textStrings = getResources().getStringArray(R.array.menuList);
        for (int i = 0; i < textStrings.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", images[i]);
            map.put("text", textStrings[i]);
            list.add(map);
        }

        return list;
    }
}
