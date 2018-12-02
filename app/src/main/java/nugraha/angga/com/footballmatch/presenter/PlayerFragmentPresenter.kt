package nugraha.angga.com.footballmatch.presenter

import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import nugraha.angga.com.footballmatch.`interface`.PlayerFragmentView
import nugraha.angga.com.footballmatch.api.SportDBRepository



class PlayerFragmentPresenter(private val view:PlayerFragmentView,
                              private val compositeDisposable:CompositeDisposable,
                              private val repository: SportDBRepository,
                              private val backgroundSchedulers: Scheduler,
                              private val mainSchedulers: Scheduler) {

        fun getPlayerList(nameClub:String){
            view.showLoading()
            compositeDisposable.add(
                    repository.allPlayer(nameClub)
                            .observeOn(backgroundSchedulers)
                            .subscribeOn(mainSchedulers)
                            .subscribe ({
                                PlayerData ->
                                view.hideLoading()
                                view.showPlayerList(PlayerData.player)

                            }, { error ->
                                error.printStackTrace()
                            })
            )
        }

}