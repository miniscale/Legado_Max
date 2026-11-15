package io.legado.app.model

import android.content.Context
import io.legado.app.constant.IntentAction
import io.legado.app.service.DownloadService
import io.legado.app.utils.startService

object Download {

    /**
     * 启动下载服务
     * @param context 上下文
     * @param url 下载URL
     * @param fileName 文件名
     */
    fun start(context: Context, url: String, fileName: String, sourceUrl: String? = null) {
        // 👇 1. 新增代理重写逻辑
        val finalUrl = if (url.startsWith("https://github.com/") && url.contains("/releases/download/")) {
            "https://gh-proxy.org/$url"
        } else {
            url
        }

        context.startService<DownloadService> {
            action = IntentAction.start
            putExtra("url", finalUrl)
            putExtra("fileName", fileName)
            putExtra("sourceUrl", sourceUrl)
        }
    }

}