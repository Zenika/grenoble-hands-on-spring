package com.zenika.wheatherapi.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class City(
    @Id
    var cityId: String,
    var name: String,
    var position: GeoPosition
)
