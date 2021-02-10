package com.zenika.handson.spring.entities

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class City(@Id val name: String, @Embedded val position: GeoPosition)