package moe.christina.android.templates.behavior.progress

import android.support.annotation.CallSuper

abstract class ProgressScreenBehaviorHandler<in TProgress : Any> : ProgressScreenBehavior<TProgress> {
    @CallSuper
    override fun displayProgress() {
        onChangeProgressVisibility(true)

        onDisplayProgress()
    }

    @CallSuper
    override fun displayProgress(progress: TProgress) {
        onChangeProgressVisibility(true)

        onDisplayProgress(progress)
    }

    @CallSuper
    protected open fun onDisplayProgress() {
    }

    @CallSuper
    protected open fun onDisplayProgress(progress: TProgress) {
    }

    @CallSuper
    protected open fun onChangeProgressVisibility(visible: Boolean) {
    }
}