package eoinahern.ie.movietrailerapp.ui.view.trailer

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import eoinahern.ie.movietrailerapp.data.repository.trailer.TrailerRepoImp
import eoinahern.ie.movietrailerapp.domain.trailer.TrailerUsecase
import eoinahern.ie.movietrailerapp.util.exception.Failure
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.io.IOException

class TrailerViewModelTest {

    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var viewModel: TrailerViewModel
    private lateinit var trailerUseCase: TrailerUsecase

    private var testSchedMain = Schedulers.trampoline()
    private var testSchedIO = Schedulers.trampoline()

    @Mock
    private lateinit var trailerRepo: TrailerRepoImp

    @Mock
    private lateinit var mediaSource: ProgressiveMediaSource

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        trailerUseCase = TrailerUsecase(trailerRepo)
        trailerUseCase.setSchedulers(testSchedMain, testSchedIO)
        viewModel = TrailerViewModel(trailerUseCase)

    }

    @Test
    fun testHappyPath() {

        Mockito.`when`(trailerRepo.getTrailerSource(any())).thenReturn(Observable.just(mediaSource))
        viewModel.loadTrailer("")

        viewModel.getDataSource().observeForever {
            Assert.assertTrue(it is ProgressiveMediaSource)
        }

        verify(trailerRepo).getTrailerSource("")

    }

    @Test
    fun testFailure() {

        Mockito.`when`(trailerRepo.getTrailerSource(any()))
            .thenReturn(Observable.error(IOException("") as Throwable))
        viewModel.loadTrailer("")


        viewModel.failureLiveData.observeForever {
            Assert.assertTrue(it is Failure.NetworkFailure)
        }
    }
}