package moe.christina.android.templates.behavior.error

import android.support.annotation.CallSuper

abstract class ErrorScreenBehaviorHandler<in TError : Any> : ErrorScreenBehavior<TError> {
    @CallSuper
    override fun displayError(error: TError) {
        onChangeErrorVisibility(true)

        onDisplayError(error)
    }

    @CallSuper
    protected open fun onDisplayError(error: TError) {
    }

    @CallSuper
    protected open fun onChangeErrorVisibility(visible: Boolean) {
    }
}