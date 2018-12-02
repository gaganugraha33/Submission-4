package nugraha.angga.com.footballmatch

import nugraha.angga.com.footballmatch.api.ServiceSportDBApi
import org.junit.Test
import org.mockito.Mockito

class ApiRepositoryTest {
    @Test
    fun testLastMatchRequest(){
        val apiRepository = Mockito.mock(ServiceSportDBApi::class.java)
        apiRepository.getLastMatch("4328")
        Mockito.verify(apiRepository).getLastMatch("4328")
    }

    @Test
    fun testNextMatchRequest(){
        val apiRepository = Mockito.mock(ServiceSportDBApi::class.java)
        apiRepository.getNextMatch("4328")
        Mockito.verify(apiRepository).getNextMatch("4328")
    }

    @Test
    fun testSearchEvent(){
        val apiRepository = Mockito.mock(ServiceSportDBApi::class.java)
        apiRepository.getSearchEvent("Arsenal")
        Mockito.verify(apiRepository).getSearchEvent("Arsenal")
    }

    @Test
    fun testAllTeamLeague(){
        val apiRepository = Mockito.mock(ServiceSportDBApi::class.java)
        apiRepository.getAllTeamLeague("4328")
        Mockito.verify(apiRepository).getAllTeamLeague("4328")
    }

    @Test
    fun testSearchTeamLeague(){
        val apiRepository = Mockito.mock(ServiceSportDBApi::class.java)
        apiRepository.getSearchTeamLeague("Arsenal")
        Mockito.verify(apiRepository).getSearchTeamLeague("Arsenal")
    }

    @Test
    fun testPlayerList(){
        val apiRepository = Mockito.mock(ServiceSportDBApi::class.java)
        apiRepository.getPlayerList("Arsenal")
        Mockito.verify(apiRepository).getPlayerList("Arsenal")
    }

    @Test
    fun testAllLeague(){
        val apiRepository = Mockito.mock(ServiceSportDBApi::class.java)
        apiRepository.getAllLeague()
        Mockito.verify(apiRepository).getAllLeague()
    }
}