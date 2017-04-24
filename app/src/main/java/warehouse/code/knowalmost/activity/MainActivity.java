package warehouse.code.knowalmost.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import warehouse.code.knowalmost.R;
import warehouse.code.knowalmost.util.UIHelper;
import warehouse.code.knowalmost.view.MainFragment;

public class MainActivity extends FragmentActivity {
    private SlidingMenu slidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//remove title bar  即隐藏标题栏
        //getSupportActionBar().hide();// 隐藏ActionBar
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove notification bar  即全屏
        setContentView(R.layout.activity_main);

        slidingMenu = UIHelper.initSlidingMenu(this);
        //设置头部bar的按钮事件
        UIHelper.initActionButton(this, slidingMenu);

        switchFragment(new MainFragment());

        Log.i("Know", "start android app");
    }


    public void switchFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.content_fragment, fragment).commit();
        slidingMenu.showContent();
    }
}
