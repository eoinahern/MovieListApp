package eoinahern.ie.movietrailerapp.domain.detail

import eoinahern.ie.movietrailerapp.data.repository.detail.DetailRepositoryImp
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetMovieDetailUsecaseTest {


    private lateinit var getMovieDetailUsecase: GetMovieDetailUsecase

    @Mock
    private lateinit var getMoviesDetailsRepo: DetailRepositoryImp

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getMovieDetailUsecase = GetMovieDetailUsecase(getMoviesDetailsRepo)
    }


    @Test
    fun test() {

    }
}