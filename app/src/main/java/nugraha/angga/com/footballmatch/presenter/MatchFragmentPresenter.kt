package nugraha.angga.com.footballmatch.presenter

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import nugraha.angga.com.footballmatch.`interface`.MatchFragmentView
import nugraha.angga.com.footballmatch.api.SportDBRepository


class MatchFragmentPresenter(private val view:MatchFragmentView,
                             private val compositeDisposable:CompositeDisposable,
                             private val repository: SportDBRepository,
                             private val backgroundSchedulers: Scheduler,
                             private val mainSchedulers: Scheduler) {

        fun getMatchList(codeLeague:String){
            view.showLoading()
            compositeDisposable.add(
                    repository.lastMatchReq(codeLeague)
                            .observeOn(backgroundSchedulers)
                            .subscribeOn(mainSchedulers)
                            .subscribe ({
                                EventMatch ->
                                view.hideLoading()
                                view.showMatchList(EventMatch.events)

                            }, { error ->
                                error.printStackTrace()
                            })
            )
        }

    fun getNextMatchList(codeLeague:String){
            view.showLoading()
            compositeDisposable.add(
                    repository.nextMatchReq(codeLeague)
                            .observeOn(backgroundSchedulers)
                            .subscribeOn(mainSchedulers)
                            .subscribe ({
                                EventMatch ->
                                view.hideLoading()
                                view.showMatchList(EventMatch.events)
                            }, { error ->
                                error.printStackTrace()
                            })
            )
        }

    fun getSearchMatchList(match:String){
            view.showLoading()
            compositeDisposable.add(
                    repository.searchEvent(match)
                            .observeOn(backgroundSchedulers)
                            .subscribeOn(mainSchedulers)
                            .subscribe ({
                                EventMatch ->
                                view.hideLoading()
                                view.showMatchList(EventMatch.event)
                            }, { error ->
                                error.printStackTrace()
                            })
            )
        }

    fun getAllLeague(){
        view.showLoading()
        compositeDisposable.add(
                repository.allLeague()
                        .observeOn(backgroundSchedulers)
                        .subscribeOn(mainSchedulers)
                        .subscribe ({
                            AllLeague ->
                            view.hideLoading()
                            view.showListAllLeague(AllLeague.leagues)
                        }, { error ->
                            error.printStackTrace()
                        })
        )
    }



}