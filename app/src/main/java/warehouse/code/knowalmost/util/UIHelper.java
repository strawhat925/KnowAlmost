package warehouse.code.knowalmost.util;

import android.app.Activity;
import android.view.View;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import warehouse.code.knowalmost.R;

/**
 * ${DESCRIPTION}
 * package warehouse.code.knowalmost.util
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-21 16:46
 **/
public class UIHelper {

    /**
     * 初始化SlidingMenu侧滑菜单
     * SlidingMenu属性详情
     * {@Link http://blog.csdn.net/caiwenfeng_for_23/article/details/23384775}
     *
     * @param context
     *
     * @return
     */
    public static SlidingMenu initSlidingMenu(Activity context) {

        SlidingMenu menu = new SlidingMenu(context);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.color.colorAccent);

        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        menu.attachToActivity(context, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.menu_left);
        return menu;
    }

    /**
     * 初始化头部bar的按钮事件
     *
     * @param context
     * @param slidingMenu
     */
    public static void initActionButton(Activity context, final SlidingMenu slidingMenu) {
        View view = context.findViewById(R.id.header_bar);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("-----------------------------------------------------------------");
                slidingMenu.showMenu();
            }
        });
    }
}
