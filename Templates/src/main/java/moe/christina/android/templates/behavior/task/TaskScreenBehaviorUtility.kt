package moe.christina.android.templates.behavior.task

import io.reactivex.Observable
import moe.christina.android.templates.behavior.error.displayErrorOnScreen
import moe.christina.android.templates.behavior.progress.displayProgressOnScreen
import moe.christina.common.core.event.Event

fun <TResult>
    HasTaskScreenBehavior<*, TResult, *, *>.displayResult(result: TResult) =
    taskBehavior.displayResult(result)

val <TEvent : Event>
    HasTaskScreenBehavior<TEvent, *, *, *>.onRequestPerformTask: Observable<TEvent>
    get() = taskBehavior.onRequestPerformTask

fun <TResult, TProgress : Any, TError : Any>
    Observable<TResult>.displayTaskOnScreen(
    behavior: TaskScreenBehavior<*, TResult, TProgress, TError>,
    progressConverter: (TResult) -> TProgress,
    errorConverter: (Throwable) -> TError): Observable<TResult> =
    this.displayProgressOnScreen(behavior, progressConverter)
        .displayErrorOnScreen(behavior, errorConverter)
        .doOnNext { behavior.displayResult(it) }

fun <TResult, TProgress : Any, TError : Any>
    Observable<TResult>.displayTaskOnScreen(
    screen: HasTaskScreenBehavior<*, TResult, TProgress, TError>,
    progressConverter: (TResult) -> TProgress,
    errorConverter: (Throwable) -> TError): Observable<TResult> =
    displayTaskOnScreen(screen.taskBehavior, progressConverter, errorConverter)