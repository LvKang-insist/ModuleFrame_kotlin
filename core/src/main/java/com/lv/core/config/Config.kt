@file:Suppress("UNCHECKED_CAST")

package com.lv.core.config

import android.app.Application

object Config {

    /**
     * 获取全局的 application
     */
    fun getApplication(): Application {
        val application = Configurator.getValue(ConfigKey.CONFIG_APPLICATION)
        return application as Application
    }

    /**
     * 获取指定 Key 的值
     */
    fun <V> getValue(key: ConfigKey): V {
        return Configurator.getValue(key) as V
    }

    fun build(): Configurator {
        return Configurator
    }
}