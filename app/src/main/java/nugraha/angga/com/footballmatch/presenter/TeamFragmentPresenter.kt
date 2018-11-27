package nugraha.angga.com.footballmatch.presenter

import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import nugraha.angga.com.footballmatch.`interface`.AllTeamFragmentView
import nugraha.angga.com.footballmatch.api.SportDBRepository
import nugraha.angga.com.footballmatch.model.allLeagueModel.AllLeague


class TeamFragmentPresenter(private val view:AllTeamFragmentView,
                            private val compositeDisposable:CompositeDisposable,
                            private val repository: SportDBRepository,
                            private val backgroundSchedulers: Scheduler,
                            private val mainSchedulers: Scheduler) {

        fun getAllTeamList(codeLeague:String){
            view.showLoading()
            compositeDisposable.add(
                    repository.allTeamReq(codeLeague)
                            .observeOn(backgroundSchedulers)
                            .subscribeOn(mainSchedulers)
                            .subscribe ({
                                AllTeamLeague ->
                                view.hideLoading()
                                view.showListAllTeam(AllTeamLeague.teams)

                            }, { error ->
                                error.printStackTrace()
                            })
            )
        }

      fun getSearchTeamList(nameTeam:String){
            view.showLoading()
            compositeDisposable.add(
                    repository.allTeamSearchReq(nameTeam)
                            .observeOn(backgroundSchedulers)
                            .subscribeOn(mainSchedulers)
                            .subscribe ({
                                AllTeamLeague ->
                                view.hideLoading()
                                view.showListAllTeam(AllTeamLeague.teams)

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