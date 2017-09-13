package moe.christina.android.templates.behavior.progress

import io.reactivex.Observable

fun HasProgressScreenBehavior<*>.displayProgress() =
    progressBehavior.displayProgress()

fun <TProgress : Any> HasProgressScreenBehavior<TProgress>.displayProgress(progress: TProgress) =
    progressBehavior.displayProgress(progress)

fun <T, TProgress : Any>
    Observable<T>.displayProgressOnScreen(
    behavior: ProgressScreenBehavior<TProgress>,
    converter: (T) -> TProgress): Observable<T> =
    this.doOnSubscribe { behavior.displayProgress() }
        .doOnNext { behavior.displayProgress(converter(it)) }

fun <T, TProgress : Any>
    Observable<T>.displayProgressOnScreen(
    screen: HasProgressScreenBehavior<TProgress>,
    converter: (T) -> TProgress): Observable<T> =
    displayProgressOnScreen(screen.progressBehavior, converter)