package com.zenika.wheatherapi.model

import javax.persistence.Embeddable

@Embeddable
data class GeoPosition(
    var latitude: Double,
    var longitude: Double
)
