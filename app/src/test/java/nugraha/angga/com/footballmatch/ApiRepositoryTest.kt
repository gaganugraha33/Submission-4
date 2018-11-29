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
    fun testAllTeamLeague(){
        val apiRepository = Mockito.mock(ServiceSportDBApi::class.java)
        apiRepository.getAllTeamLeague("4328")
        Mockito.verify(apiRepository).getAllTeamLeague("4328")
    }
}