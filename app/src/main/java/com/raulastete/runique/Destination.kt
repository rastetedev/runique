package com.raulastete.runique

import kotlinx.serialization.Serializable

sealed interface Destination {
    @Serializable
    data object Intro : Destination

    @Serializable
    data object Register : Destination

    @Serializable
    data object Login : Destination

    @Serializable
    data object RunOverview : Destination
}

sealed interface Graph {
    @Serializable
    data object Auth : Graph

    @Serializable
    data object Run : Graph
}