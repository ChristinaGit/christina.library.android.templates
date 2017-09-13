package moe.christina.android.templates.behavior.task

import moe.christina.android.templates.behavior.error.ErrorScreenBehavior
import moe.christina.android.templates.behavior.error.HasErrorScreenBehavior
import moe.christina.android.templates.behavior.progress.HasProgressScreenBehavior
import moe.christina.android.templates.behavior.progress.ProgressScreenBehavior
import moe.christina.common.core.event.Event

interface HasTaskScreenBehavior<
    TEvent : Event,
    in TResult,
    in TProgress : Any,
    in TError : Any> :
    HasProgressScreenBehavior<TProgress>,
    HasErrorScreenBehavior<TError> {
    val taskBehavior: TaskScreenBehavior<
        TEvent,
        TResult,
        TProgress,
        TError>

    override val errorBehavior: ErrorScreenBehavior<TError>
        get() = taskBehavior
    override val progressBehavior: ProgressScreenBehavior<TProgress>
        get() = taskBehavior
}