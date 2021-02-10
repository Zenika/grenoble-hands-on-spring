package com.zenika.handson.spring.entities

import javax.persistence.Embeddable
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Embeddable
data class GeoPosition(
    @field:Min(-90) @field:Max(90)
    val latitude: Double,

    @field:Min(-180) @field:Max(180)
    val longitude: Double)