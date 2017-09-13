package moe.christina.android.templates.behavior.progress

interface ProgressScreenBehavior<in TProgress : Any> {
    fun displayProgress()
    fun displayProgress(progress: TProgress)
}