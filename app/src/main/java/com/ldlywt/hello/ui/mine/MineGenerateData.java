package com.ldlywt.hello.ui.mine;

import com.ldlywt.hello.R;
import com.ldlywt.hello.bean.SettingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/09/05
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MineGenerateData {

    private static final String[] TAB_NAME = {"收藏", "注册", "注销"};
    private static final int[] TAB_ICON = {R.mipmap.tab_collect, R.mipmap.tab_register, R.mipmap.tab_logout};

    public static List<SettingBean> generateData() {
        List<SettingBean> list = new ArrayList<>();
        list.add(new SettingBean(0, TAB_NAME[0], TAB_ICON[0]));
        list.add(new SettingBean(1, TAB_NAME[1], TAB_ICON[1]));
        list.add(new SettingBean(2, TAB_NAME[2], TAB_ICON[2]));
//        list.add(new SettingBean(2, TAB_NAME[2], TAB_ICON[2]));
//        list.add(new SettingBean(2, TAB_NAME[2], TAB_ICON[2]));
        return list;
    }

}
