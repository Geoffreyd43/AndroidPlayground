package com.example.kotlinplayground

fun main() {
    // Celsius
    TemperatureConverter.printFinalTemperature(350.0, TemperatureScale.Kelvin, TemperatureScale.Celsius)
    TemperatureConverter.printFinalTemperature(41.0, TemperatureScale.Fahrenheit, TemperatureScale.Celsius)
    TemperatureConverter.printFinalTemperature(17.0, TemperatureScale.Celsius, TemperatureScale.Celsius)
    println()

    // Kelvin
    TemperatureConverter.printFinalTemperature(76.85, TemperatureScale.Celsius, TemperatureScale.Kelvin)
    TemperatureConverter.printFinalTemperature(10.0, TemperatureScale.Fahrenheit, TemperatureScale.Kelvin)
    TemperatureConverter.printFinalTemperature(201.0, TemperatureScale.Kelvin, TemperatureScale.Kelvin)
    println()

    // Fahrenheit
    TemperatureConverter.printFinalTemperature(260.93, TemperatureScale.Kelvin, TemperatureScale.Fahrenheit)
    TemperatureConverter.printFinalTemperature(5.0, TemperatureScale.Celsius, TemperatureScale.Fahrenheit)
    TemperatureConverter.printFinalTemperature(41.0, TemperatureScale.Fahrenheit, TemperatureScale.Fahrenheit)
}

enum class TemperatureScale {
    Celsius,
    Fahrenheit,
    Kelvin,
}

class TemperatureConverter {
    companion object {

        @Suppress("DefaultLocale")
        fun printFinalTemperature(
            initialMeasurement: Double,
            initialUnit: TemperatureScale,
            finalUnit: TemperatureScale
        ) {
            val conversionFormula = this.selectConverterFunction(finalUnit)
            val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement, initialUnit)) // two decimal places
            println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
        }

        private fun selectConverterFunction(finalUnit: TemperatureScale): (Double, TemperatureScale) -> Double {
            return when (finalUnit) {
                TemperatureScale.Celsius -> ::convertCelsius
                TemperatureScale.Kelvin -> ::convertKelvin
                TemperatureScale.Fahrenheit -> ::convertFahrenheit
            }
        }

        private fun convertCelsius(initialDegrees: Double, fromScale: TemperatureScale): Double {
            if (fromScale == TemperatureScale.Kelvin) {
                return initialDegrees - 273.15
            } else if (fromScale == TemperatureScale.Fahrenheit) {
                return (initialDegrees - 32) * (5.0 / 9.0)
            }
            // else already celsius, so do nothing
            return initialDegrees
        }

        private fun convertKelvin(initialDegrees: Double, fromScale: TemperatureScale): Double {
            if (fromScale == TemperatureScale.Kelvin) return initialDegrees

            var degreesCelsius: Double = initialDegrees
            if (fromScale == TemperatureScale.Fahrenheit) {
                degreesCelsius = convertCelsius(initialDegrees, TemperatureScale.Fahrenheit)
            }

            return degreesCelsius + 273.15
        }

        private fun convertFahrenheit(initialDegrees: Double, fromScale: TemperatureScale): Double {
            if (fromScale == TemperatureScale.Fahrenheit) return initialDegrees

            var degreesCelsius: Double = initialDegrees
            if (fromScale == TemperatureScale.Kelvin) {
                degreesCelsius = convertCelsius(initialDegrees, TemperatureScale.Kelvin)
            }

            return (degreesCelsius * 9 / 5) + 32
        }
    }
}
