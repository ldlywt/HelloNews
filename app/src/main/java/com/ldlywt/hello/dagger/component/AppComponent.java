package com.ldlywt.hello.dagger.component;

import com.ldlywt.hello.App;
import com.ldlywt.hello.dagger.module.AllActivitysMoudle;
import com.ldlywt.hello.dagger.module.AllFragmentsModule;


import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/09/03
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AllActivitysMoudle.class,
        AllFragmentsModule.class
})
public interface AppComponent {
    void inject(App app);
}
