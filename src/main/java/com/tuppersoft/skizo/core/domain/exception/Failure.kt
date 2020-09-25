package com.tuppersoft.skizo.core.domain.exception

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
    object UnknownError : Failure()
    abstract class FeatureFailure : Failure()
}

