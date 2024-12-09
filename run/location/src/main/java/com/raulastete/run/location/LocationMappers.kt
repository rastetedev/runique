package com.raulastete.run.location

import android.location.Location
import com.raulastete.core.domain.location.Location as DomainLocation
import com.raulastete.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = DomainLocation(
            lat = latitude,
            long = longitude
        ),
        altitude = altitude
    )
}