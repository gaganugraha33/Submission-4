package nugraha.angga.com.footballmatch

import nugraha.angga.com.footballmatch.api.ServiceSportDBApi
import org.junit.Test
import org.mockito.Mockito

class ApiRepositoryTest {
    @Test
    fun testLastMatchRequest(){
        val apiRepository = Mockito.mock(ServiceSportDBApi::class.java)
        apiRepository.getLastMatch()
        Mockito.verify(apiRepository).getLastMatch()
    }

    @Test
    fun testNextMatchRequest(){
        val apiRepository = Mockito.mock(ServiceSportDBApi::class.java)
        apiRepository.getNextMatch()
        Mockito.verify(apiRepository).getNextMatch()
    }

    @Test
    fun testAllTeamLeague(){
        val apiRepository = Mockito.mock(ServiceSportDBApi::class.java)
        apiRepository.getAllTeamLeague()
        Mockito.verify(apiRepository).getAllTeamLeague()
    }
}