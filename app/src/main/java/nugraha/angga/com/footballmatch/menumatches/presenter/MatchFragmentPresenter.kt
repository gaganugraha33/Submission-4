package nugraha.angga.com.footballmatch.menumatches.presenter

import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import nugraha.angga.com.footballmatch.menumatches.view.MatchFragmentView
import nugraha.angga.com.footballmatch.api.SportDBRepository


class MatchFragmentPresenter(private val view: MatchFragmentView,
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