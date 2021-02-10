package com.zenika.handson.spring.repositories.http

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class Weather7TimerMapperTest {

    @Test
    fun `convert daily weather from 7timer to domain`() {
        // Given
        val weather7Timer = DailyWeather7Timer(listOf(DailyWeather7Timer.DataSeries("20210223", DailyWeather7Timer.Temp2m(28.0, 27.0), "lightrain", 3.0)))

        // When
        val dailyWeather = Weather7TimerMapper.toDomain(weather7Timer)[0]

        // Then
        assertThat(dailyWeather.day).isEqualTo(LocalDate.of(2021, 2, 23))
        assertThat(dailyWeather.temperatureMax).isEqualTo(28.0)
        assertThat(dailyWeather.temperatureMin).isEqualTo(27.0)
        assertThat(dailyWeather.weather).isEqualTo("lightrain")
    }
}
