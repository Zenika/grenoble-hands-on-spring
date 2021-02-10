package com.zenika.handson.spring.entities

import java.time.LocalDate

data class Weather(val day: LocalDate, val weather: String, val temperatureMax: Double, val temperatureMin: Double)
