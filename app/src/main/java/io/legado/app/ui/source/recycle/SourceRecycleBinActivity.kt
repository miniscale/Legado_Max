package io.legado.app.ui.source.recycle

import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import io.legado.app.base.BaseComposeActivity
import io.legado.app.utils.toastOnUi
import kotlinx.coroutines.launch

class SourceRecycleBinActivity : BaseComposeActivity() {

    private val viewModel: SourceRecycleBinViewModel by viewModels {
        SourceRecycleBinViewModel.Factory
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        collectToasts()
    }

    @Composable
    override fun ComposeContent() {
        SourceRecycleBinScreen(
            viewModel = viewModel,
            onBackClick = { finish() }
        )
    }

    /** 收集 Toast 事件并在主线程执行（ViewModel 只抛事件，§4.1/§4.4） */
    private fun collectToasts() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.toasts.collect { toastOnUi(it.msgRes) }
            }
        }
    }
}