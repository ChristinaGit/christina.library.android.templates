package moe.christina.android.templates.behavior.error

interface HasErrorScreenBehavior<in TError : Any> {
    val errorBehavior: ErrorScreenBehavior<TError>
}