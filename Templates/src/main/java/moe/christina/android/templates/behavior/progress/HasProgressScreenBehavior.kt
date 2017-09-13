package moe.christina.android.templates.behavior.progress

interface HasProgressScreenBehavior<in TProgress : Any> {
    val progressBehavior: ProgressScreenBehavior<TProgress>
}