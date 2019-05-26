package eoinahern.ie.movietrailerapp.util.exception


sealed class Failure {
    object ServerFailure : Failure()
    object NetworkFailure : Failure()

    abstract class FeatureFailure : Failure()
}