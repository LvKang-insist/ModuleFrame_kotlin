package com.lv.core.config

import android.app.Application
import com.xiaojinzi.component.Component
import com.xiaojinzi.component.Config
import com.xiaojinzi.component.impl.BuildConfig
import com.xiaojinzi.component.impl.application.ModuleManager

object Configurator {


    private val config = LinkedHashMap<ConfigKey, Any>()

    /**
     * 配置完成时调用
     */
    fun configure() {
        config[ConfigKey.CONFIG_READER] = true
    }

    /**
     * 保存全局的 application
     */
    fun withApplication(application: Application): Configurator {
        config[ConfigKey.CONFIG_APPLICATION] = application
        return this
    }

    fun withComponent(): Configurator {
        Component.init(
            BuildConfig.DEBUG,
            Config.with(getValue(ConfigKey.CONFIG_APPLICATION) as Application)
                // 使用内置的路由重复检查的拦截器, 如果为 true,
                // 那么当两个相同的路由发生在指定的时间内后一个路由就会被拦截
                .useRouteRepeatCheckInterceptor(true)
                // 1000 是默认的, 表示相同路由拦截的时间间隔
                .routeRepeatCheckDuration(1000)
                // 是否打印日志提醒你哪些路由使用了 Application 为 Context 进行跳转
                .tipWhenUseApplication(true)
                // 这里表示使用 ASM 字节码技术加载模块, 默认是 false
                // 如果是 true 请务必配套使用 Gradle 插件, 下一步就是可选的配置 Gradle 插件
                // 如果是 false 请直接略过下一步 Gradle 的配置
                .optimizeInit(true)
                // 自动加载所有模块, 打开此开关后下面无需手动注册了
                // 但是这个依赖 optimizeInit(true) 才会生效
                .autoRegisterModule(true)
                .build()
        )
        // 注册其他业务模块,注册的字符串是上面各个业务模块配置在 build.gradle 中的 HOST
        ModuleManager.getInstance().registerArr("app", "moduleHome")
        // 自动加载所有模块, 此功能需要打开开关 optimizeInit(true).
        // 如果你同时也打开了开关 autoRegisterModule(true), 那么这句代码也可省略了, 因为初始化的时候自动帮你注册了
        // ModuleManager.getInstance().autoRegister(); // 1.7.9+
        if (BuildConfig.DEBUG) {
            // 框架还带有检查重复的路由和重复的拦截器等功能,在 `debug` 的时候开启它
            ModuleManager.getInstance().check()
        }
        return this
    }

    /**
     * 获取指定 Key 的值
     */
    fun getValue(key: ConfigKey): Any {
        return config[key]
            ?: throw  KotlinNullPointerException("未在 Configurator 中初始化")
    }


}