package nugraha.angga.com.footballmatch.presenter

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import nugraha.angga.com.footballmatch.`interface`.DetailActivityView
import nugraha.angga.com.footballmatch.`interface`.MatchFragmentView
import nugraha.angga.com.footballmatch.api.SportDBRepository


class DetailActivityPresenter(private val view:DetailActivityView,
                              private val compositeDisposable:CompositeDisposable,
                              private val repository: SportDBRepository,
                              private val backgroundSchedulers: Scheduler,
                              private val mainSchedulers: Scheduler) {


    fun getAllTeamLeagueList(codeLeague:String){
            view.showLoading()
            compositeDisposable.add(
                    repository.allTeamReq(codeLeague)
                            .observeOn(backgroundSchedulers)
                            .subscribeOn(mainSchedulers)
                            .subscribe ({
                                AllTeamLeague ->

                                view.hideLoading()
                                view.showAllteam(AllTeamLeague.teams)

                            }, { error ->
                                error.printStackTrace()
                            })
            )
        }
}