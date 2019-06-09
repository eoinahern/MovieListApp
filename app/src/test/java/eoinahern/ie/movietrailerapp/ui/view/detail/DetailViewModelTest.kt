package eoinahern.ie.movietrailerapp.ui.view.detail


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import eoinahern.ie.movietrailerapp.data.model.NestedSingleMovieData
import eoinahern.ie.movietrailerapp.data.repository.detail.DetailRepositoryImp
import eoinahern.ie.movietrailerapp.domain.detail.GetMovieDetailUsecase
import eoinahern.ie.movietrailerapp.util.exception.Failure
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Before

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException
import java.lang.NumberFormatException

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {


    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailViewModel
    private lateinit var getMovieDetails: GetMovieDetailUsecase

    private var testSchedMain = Schedulers.trampoline()
    private var testSchedIO = Schedulers.trampoline()

    @Mock
    private lateinit var mockRepo: DetailRepositoryImp

    @Mock
    private lateinit var mockMovieData: NestedSingleMovieData

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getMovieDetails = GetMovieDetailUsecase(mockRepo)
        getMovieDetails.setSchedulers(testSchedMain, testSchedIO)
        viewModel = DetailViewModel(getMovieDetails)
    }

    @Test
    fun testGetData() {

        Mockito.`when`(mockRepo.getDetail(any())).thenReturn(Observable.just(mockMovieData))
        Mockito.`when`(mockMovieData.id).thenReturn("id")

        viewModel.getSingleMovieData("")

        viewModel.getMovieItem().observeForever {
            Assert.assertEquals(it.id, "id")
            Assert.assertTrue(it is NestedSingleMovieData)
        }

        verify(mockRepo).getDetail(any())
    }

    @Test
    fun testNetworkError() {

        Mockito.`when`(mockRepo.getDetail(any()))
            .thenReturn(Observable.error(IOException("")))

        viewModel.getSingleMovieData("")

        viewModel.failureLiveData.observeForever {
            Assert.assertTrue(it is Failure.NetworkFailure)
        }
    }

    @Test
    fun testServerError() {

        val t = NumberFormatException("") as? Throwable

        Mockito.`when`(mockRepo.getDetail(""))
            .thenReturn(Observable.error(t))

        viewModel.getSingleMovieData("")

        viewModel.failureLiveData.observeForever {
            Assert.assertTrue(it is Failure.ServerFailure)
        }

    }
}