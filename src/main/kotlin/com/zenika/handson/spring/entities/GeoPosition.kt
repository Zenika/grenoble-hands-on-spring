package com.zenika.handson.spring.entities

import javax.persistence.Embeddable

@Embeddable
data class GeoPosition(val latitude: Double, val longitude: Double)