package eoinahern.ie.movietrailerapp.ui.view.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.data.repository.list.ListRepositoryImp
import eoinahern.ie.movietrailerapp.domain.list.GetMovieList
import eoinahern.ie.movietrailerapp.util.exception.Failure
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException
import org.junit.Assert


@RunWith(MockitoJUnitRunner::class)
class ListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ListViewModel

    @Mock
    private lateinit var mockRepo: ListRepositoryImp

    private var testSchedMain = Schedulers.trampoline()
    private var testSchedIO = Schedulers.trampoline()

    lateinit private var getMovieList: GetMovieList
    val map = mapOf("hello" to emptyList<MovieListEntry>())


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getMovieList = GetMovieList(mockRepo)
        getMovieList.setSchedulers(testSchedMain, testSchedIO)
        viewModel = ListViewModel(getMovieList)
    }


    @Test
    fun test() {

        Mockito.`when`(mockRepo.getList(any())).thenReturn(Observable.just(map))

        viewModel.getFromApi(listOf())

        viewModel.getMovieList().observeForever {
            Assert.assertTrue(it is Map<String, List<MovieListEntry>>)
            Assert.assertTrue(it.containsKey("hello"))
            Assert.assertTrue(it["hello"]?.size == 0)
        }

        verify(mockRepo).getList(any())
    }

    @Test
    fun testFailureServer() {

        Mockito.`when`(mockRepo.getList(any()))
            .thenReturn(Observable.error(Exception("hello") as Throwable))

        viewModel.getFromApi(listOf())

        viewModel.failureLiveData.observeForever {
            Assert.assertTrue(it is Failure.ServerFailure)
        }
    }

    @Test
    fun testFailureNetwork() {

        Mockito.`when`(mockRepo.getList(any()))
            .thenReturn(Observable.error(IOException("") as Throwable))

        viewModel.getFromApi(listOf())

        viewModel.failureLiveData.observeForever {
            Assert.assertTrue(it is Failure.NetworkFailure)
        }

    }
}