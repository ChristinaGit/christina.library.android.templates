package moe.christina.android.templates.behavior.error

import io.reactivex.Observable

fun <TError : Any> HasErrorScreenBehavior<TError>.displayError(error: TError) =
    errorBehavior.displayError(error)

fun <T, TError : Any>
    Observable<T>.displayErrorOnScreen(
    behavior: ErrorScreenBehavior<TError>,
    converter: (Throwable) -> TError): Observable<T> =
    doOnError { behavior.displayError(converter(it)) }

fun <T, TError : Any>
    Observable<T>.displayErrorOnScreen(
    screen: HasErrorScreenBehavior<TError>,
    converter: (Throwable) -> TError): Observable<T> =
    displayErrorOnScreen(screen.errorBehavior, converter)
