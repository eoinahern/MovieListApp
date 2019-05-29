package eoinahern.ie.movietrailerapp.domain.list

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.data.repository.list.ListRepositoryImp
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetMovieListTest {

    private lateinit var getList: GetMovieList

    @Mock
    lateinit var repo: ListRepositoryImp

    @Mock
    lateinit var mockMovieMap: Map<String, List<MovieListEntry>>

    @Mock
    lateinit var mockMovieList: List<MovieListEntry>

    @Mock
    lateinit var mockMovie: MovieListEntry

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getList = GetMovieList(repo)
        getList.setList(listOf())
    }

    @Test
    fun executeUsecaseTest() {
        Mockito.`when`(repo.getList(any())).thenReturn(Observable.just(mockMovieMap))
        Mockito.`when`(mockMovieMap.get(any())).thenReturn(mockMovieList)
        Mockito.`when`(mockMovieList.get(any())).thenReturn(mockMovie)
        Mockito.`when`(mockMovie.id).thenReturn("matrix")


        val obs = getList.buildObservable()
        val rest = obs.blockingFirst()


        Mockito.verify(repo).getList(any())
        assertTrue(obs is Observable<Map<String, List<MovieListEntry>>>)
        assertTrue(rest is Map<String, List<MovieListEntry>>)
        assertEquals(mockMovieList.get(0).id, "matrix")

    }
}