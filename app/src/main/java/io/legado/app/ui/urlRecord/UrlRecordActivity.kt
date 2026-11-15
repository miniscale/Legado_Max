package io.legado.app.ui.urlRecord

import android.os.Bundle
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import io.legado.app.base.BaseComposeActivity // 导入基类
import io.legado.app.di.AppVersionInfo
import javax.inject.Inject

@AndroidEntryPoint
class UrlRecordActivity : BaseComposeActivity() { // 改为继承 BaseComposeActivity

    @Inject
    lateinit var appVersionInfo: AppVersionInfo

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        android.util.Log.d("HiltDemo", "AppVersion: ${appVersionInfo.displayVersion}, channel: ${appVersionInfo.channel}")
    }

    @Composable
    override fun ComposeContent() {
        UrlRecordScreen(onBackClick = { finish() })
    }
}