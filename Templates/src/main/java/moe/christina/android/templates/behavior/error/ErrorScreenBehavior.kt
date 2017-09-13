package moe.christina.android.templates.behavior.error

interface ErrorScreenBehavior<in TError : Any> {
    fun displayError(error: TError)
}