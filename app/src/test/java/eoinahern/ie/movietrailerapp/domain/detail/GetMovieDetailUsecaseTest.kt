package eoinahern.ie.movietrailerapp.domain.detail

import com.nhaarman.mockitokotlin2.any
import eoinahern.ie.movietrailerapp.data.model.NestedSingleMovieData
import eoinahern.ie.movietrailerapp.data.repository.detail.DetailRepositoryImp
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
class GetMovieDetailUsecaseTest {

    private lateinit var getMovieDetailUsecase: GetMovieDetailUsecase

    @Mock
    private lateinit var getMoviesDetailsRepo: DetailRepositoryImp

    @Mock
    private lateinit var mockNestedMovie: NestedSingleMovieData

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getMovieDetailUsecase = GetMovieDetailUsecase(getMoviesDetailsRepo)
    }


    @Test
    fun test() {

        Mockito.`when`(getMoviesDetailsRepo.getDetail(""))
            .thenReturn(Observable.just(mockNestedMovie))
        Mockito.`when`(mockNestedMovie.id)
            .thenReturn("avatar")
        Mockito.`when`(mockNestedMovie.type)
            .thenReturn("movie")

        getMovieDetailUsecase.setId("")
        var result = getMovieDetailUsecase
            .buildObservable().blockingFirst()

        assertEquals(result.id, "avatar")
        assertEquals(result.type, "movie")

        verify(getMoviesDetailsRepo).getDetail(any())

    }
}