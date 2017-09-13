package moe.christina.android.templates.behavior.task

import io.reactivex.Observable
import moe.christina.android.templates.behavior.error.ErrorScreenBehavior
import moe.christina.android.templates.behavior.progress.ProgressScreenBehavior
import moe.christina.common.core.event.Event

interface TaskScreenBehavior<
    TEvent : Event,
    in TResult,
    in TProgress : Any,
    in TError : Any> :
    ProgressScreenBehavior<TProgress>,
    ErrorScreenBehavior<TError> {
    fun displayResult(result: TResult)

    val onRequestPerformTask: Observable<TEvent>
}