package warehouse.code.knowalmost.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import warehouse.code.knowalmost.R;

/**
 * ${DESCRIPTION}
 * package warehouse.code.knowalmost.view
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-24 10:46
 **/
public class ContentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collect, container, false);
    }
}
