package eoinahern.ie.movietrailerapp.domain.trailer

import com.google.android.exoplayer2.source.ProgressiveMediaSource
import eoinahern.ie.movietrailerapp.data.repository.trailer.TrailerRepoImp
import io.reactivex.Observable
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TrailerUsecaseTest {


    private lateinit var trailerUseCase: TrailerUsecase

    @Mock
    private lateinit var trailerRepo: TrailerRepoImp

    @Mock
    private lateinit var progressiveDataSource: ProgressiveMediaSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        trailerUseCase = TrailerUsecase(trailerRepo)
    }

    @Test
    fun test() {

        Mockito.`when`(trailerRepo.getTrailerSource(""))
            .thenReturn(Observable.just(progressiveDataSource))

        trailerUseCase.setMovieId("")
        val result = trailerUseCase.buildObservable().blockingFirst()


        assertTrue(result is ProgressiveMediaSource)
        verify(trailerRepo).getTrailerSource("")
    }
}