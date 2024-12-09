package com.raulastete.run.domain

import kotlin.time.Duration
import com.raulastete.core.domain.location.LocationTimestamp

data class RunData(
    val distanceMeters: Int = 0,
    val pace: Duration = Duration.ZERO,
    val locations: List<List<LocationTimestamp>> = emptyList()
)