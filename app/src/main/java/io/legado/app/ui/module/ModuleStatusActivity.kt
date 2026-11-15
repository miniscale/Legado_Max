package io.legado.app.ui.module

import androidx.compose.runtime.Composable
import io.legado.app.base.BaseComposeActivity

class ModuleStatusActivity : BaseComposeActivity() {

    @Composable
    override fun ComposeContent() {
        ModuleStatusScreen(onBackClick = { finish() })
    }
}