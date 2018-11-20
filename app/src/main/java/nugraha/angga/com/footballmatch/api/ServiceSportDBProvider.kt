package nugraha.angga.com.footballmatch.api

object ServiceSportDBProvider {
    fun providerLastMatchRepository():SportDBRepository{
        return SportDBRepository(ServiceSportDBApi.Factory.create())
    }

    fun providerNextMatchRepository():SportDBRepository{
        return SportDBRepository(ServiceSportDBApi.Factory.create())
    }

    fun providerAllTeamLeagueTeamRepository():SportDBRepository{
        return SportDBRepository(ServiceSportDBApi.Factory.create())
    }
}