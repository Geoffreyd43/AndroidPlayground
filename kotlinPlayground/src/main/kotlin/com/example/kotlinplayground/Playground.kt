package com.example.kotlinplayground

open class SmartDevice(val name: String = "Android TV", val category: String = "Home Entertainment") {

    var deviceStatus: String = "off"
    open val deviceType = "unknown"

    constructor(name: String, category: String, deviceStatus: Int) : this(name, category) {
        this.deviceStatus = when(deviceStatus) {
            0 -> "off"
            1 -> "on"
            else -> "unknown"
        }
    }

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

    override fun toString(): String {
        return "Smart Device(name: $name, category: $category, deviceStatus: $deviceStatus, speakerVolume: $speakerVolume)"
    }
}

class SmartTV(name: String, category: String) : SmartDevice(name = name, category = category) {
    override val deviceType = "Smart TV"

    var speakerVolume: Int = 2
        get() = field
        set(value: Int) {
            if (value in 0..100) {
                field = value
            } else {
                println("Speaker volume out of bounds!!")
            }
        }

    var channelNumber: Int = 1
        get() = field
        set(value: Int) {
            if (value in 0..200) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume: $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel Number: $channelNumber")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

}

class SmartLight(name: String, category: String) : SmartDevice(name = name, category = category) {
    override val deviceType: String = "Smart Light"

    var brightness: Int = 0
        get() = field
        set(value: Int) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightness++
        println("Brightness level: $brightness")
    }

    override fun turnOn() {
        super.turnOn()
        brightness = 2
        println("$name turned on. The brightness level is $brightness.")
    }

    override fun turnOff() {
        super.turnOff()
        brightness = 0
        println("Smart Light turned off")
    }

}

class SmartHome(val tv: SmartTV, val light: SmartLight) {
    fun turnOnTv() {
        tv.turnOn()
    }

    fun turnOffTv() {
        tv.turnOff()
    }

    fun increaseTvVolume() {
        tv.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        tv.nextChannel()
    }

    fun turnOnLight() {
        light.turnOn()
    }

    fun turnOffLight() {
        light.turnOff()
    }

    fun increaseLightBrightness() {
        light.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }

}

fun main() {
    var smartDevice: SmartDevice = SmartTV("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLight("Google Light", "Utility")
    smartDevice.turnOn()

}
