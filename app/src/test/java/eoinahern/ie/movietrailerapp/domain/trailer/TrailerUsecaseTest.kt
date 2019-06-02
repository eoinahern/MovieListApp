package eoinahern.ie.movietrailerapp.domain.trailer

import eoinahern.ie.movietrailerapp.data.repository.trailer.TrailerRepoImp
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TrailerUsecaseTest {


    private lateinit var trailerUseCase: TrailerUsecase

    @Mock
    private lateinit var trailerRepo: TrailerRepoImp

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        trailerUseCase = TrailerUsecase(trailerRepo)
    }

    @Test
    fun test() {

    }
}