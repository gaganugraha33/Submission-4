package nugraha.angga.com.footballmatch.presenter

import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import nugraha.angga.com.footballmatch.`interface`.AllTeamFragmentView
import nugraha.angga.com.footballmatch.api.SportDBRepository


class TeamFragmentPresenter(private val view:AllTeamFragmentView,
                            private val compositeDisposable:CompositeDisposable,
                            private val repository: SportDBRepository,
                            private val backgroundSchedulers: Scheduler,
                            private val mainSchedulers: Scheduler) {

        fun getAllTeamList(){
            view.showLoading()
            compositeDisposable.add(
                    repository.allTeamReq()
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


}