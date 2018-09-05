package com.ldlywt.hello.ui.maintab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ldlywt.hello.R;
import com.ldlywt.hello.ui.home.HomeFragment;
import com.ldlywt.hello.ui.mine.MineFragment;
import com.ldlywt.hello.ui.tree.TreeFragment;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/09/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MainTabData {

    public static final int[] tabResNormal = new int[]{R.drawable.tab_home_selector, R.drawable.tab_discovery_selector, R.drawable.tab_attention_selector, R.drawable.tab_profile_selector};
    public static final int[] tabResPressed = new int[]{R.mipmap.ic_tab_strip_icon_feed_selected, R.mipmap.ic_tab_strip_icon_category_selected, R.mipmap.ic_tab_strip_icon_pgc_selected, R.mipmap.ic_tab_strip_icon_profile_selected};
    private static final String[] tabTitle = new String[]{"首页", "体系", "关注", "我的"};

    public static Fragment[] getFragments(String from){
        Fragment[] fragments = new Fragment[4];
        fragments[0] = HomeFragment.newInstance(from);
        fragments[1] = TreeFragment.newInstance(from);
        fragments[2] = AttentionFragment.newInstance(from);
        fragments[3] = MineFragment.newInstance(from);
        return fragments;
    }


    public static View getTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content, null);
        ImageView tabIcon = view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(MainTabData.tabResNormal[position]);
        TextView tabText = view.findViewById(R.id.tab_content_text);
        tabText.setText(tabTitle[position]);
        return view;
    }


}
