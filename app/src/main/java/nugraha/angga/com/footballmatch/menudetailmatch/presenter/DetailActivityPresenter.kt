package nugraha.angga.com.footballmatch.menudetailmatch.presenter

import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import nugraha.angga.com.footballmatch.menudetailmatch.view.DetailActivityView
import nugraha.angga.com.footballmatch.api.SportDBRepository


class DetailActivityPresenter(private val view: DetailActivityView,
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