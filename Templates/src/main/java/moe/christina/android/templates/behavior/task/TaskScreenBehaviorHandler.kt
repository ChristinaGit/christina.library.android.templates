package moe.christina.android.templates.behavior.task

import android.support.annotation.CallSuper
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import moe.christina.android.templates.behavior.error.ErrorScreenBehaviorHandler
import moe.christina.android.templates.behavior.progress.ProgressScreenBehaviorHandler
import moe.christina.common.core.event.Event

abstract class TaskScreenBehaviorHandler<
    TEvent : Event,
    in TResult,
    in TProgress : Any,
    in TError : Any> :
    TaskScreenBehavior<
        TEvent,
        TResult,
        TProgress,
        TError> {
    @CallSuper
    override fun displayResult(result: TResult) {
        progressBehaviorHandler.onChangeProgressVisibility(false)
        errorBehaviorHandler.onChangeErrorVisibility(false)

        onChangeResultVisibility(true)

        onDisplayResult(result)
    }

    @CallSuper
    override fun displayProgress() {
        errorBehaviorHandler.onChangeErrorVisibility(false)
        onChangeResultVisibility(false)

        progressBehaviorHandler.displayProgress()
    }

    @CallSuper
    override fun displayProgress(progress: TProgress) {
        errorBehaviorHandler.onChangeErrorVisibility(false)
        onChangeResultVisibility(false)

        progressBehaviorHandler.displayProgress(progress)
    }

    @CallSuper
    override fun displayError(error: TError) {
        progressBehaviorHandler.onChangeProgressVisibility(false)
        onChangeResultVisibility(false)

        errorBehaviorHandler.displayError(error)
    }

    @CallSuper
    protected open fun onDisplayResult(result: TResult) {
    }

    @CallSuper
    protected open fun onDisplayProgress() {
    }

    @CallSuper
    protected open fun onDisplayError(error: TError) {
    }

    @CallSuper
    protected open fun onDisplayProgress(progress: TProgress) {
    }

    @CallSuper
    protected open fun onChangeResultVisibility(visible: Boolean) {
    }

    @CallSuper
    protected open fun onChangeProgressVisibility(visible: Boolean) {
    }

    @CallSuper
    protected open fun onChangeErrorVisibility(visible: Boolean) {
    }

    private val progressBehaviorHandler = object : ProgressScreenBehaviorHandler<TProgress>() {
        public override fun onDisplayProgress() {
            super.onDisplayProgress()

            this@TaskScreenBehaviorHandler.onDisplayProgress()
        }

        public override fun onDisplayProgress(progress: TProgress) {
            super.onDisplayProgress(progress)

            this@TaskScreenBehaviorHandler.onDisplayProgress(progress)
        }

        public override fun onChangeProgressVisibility(visible: Boolean) {
            super.onChangeProgressVisibility(visible)

            this@TaskScreenBehaviorHandler.onChangeProgressVisibility(visible)
        }
    }

    private val errorBehaviorHandler = object : ErrorScreenBehaviorHandler<TError>() {
        override fun onDisplayError(error: TError) {
            super.onDisplayError(error)

            this@TaskScreenBehaviorHandler.onDisplayError(error)
        }

        public override fun onChangeErrorVisibility(visible: Boolean) {
            super.onChangeErrorVisibility(visible)

            this@TaskScreenBehaviorHandler.onChangeErrorVisibility(visible)
        }
    }

    @CallSuper
    fun riseRequestPerformTaskEvent(event: TEvent) =
        onRequestPerformTaskSubject.onNext(event)

    final override val onRequestPerformTask: Observable<TEvent>
        get() = onRequestPerformTaskSubject.hide()

    private val onRequestPerformTaskSubject: PublishSubject<TEvent> = PublishSubject.create()
}