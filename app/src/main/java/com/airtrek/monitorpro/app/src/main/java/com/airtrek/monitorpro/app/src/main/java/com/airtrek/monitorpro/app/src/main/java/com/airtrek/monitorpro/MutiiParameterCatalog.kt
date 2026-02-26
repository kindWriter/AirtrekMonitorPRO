package com.airtrek.monitorpro

data class MutiiParameter(val group: String, val name: String)

object MutiiParameterCatalog {
    fun load(): List<MutiiParameter> {
        val core = listOf(
            MutiiParameter("ENGINE", "GDI High Pressure Fuel"),
            MutiiParameter("ENGINE", "Low Pressure Fuel"),
            MutiiParameter("ENGINE", "Injector Pulse Width"),
            MutiiParameter("ENGINE", "Knock Sum"),
            MutiiParameter("ENGINE", "Knock Retard Cylinder 1"),
            MutiiParameter("ENGINE", "Knock Retard Cylinder 2"),
            MutiiParameter("ENGINE", "Knock Retard Cylinder 3"),
            MutiiParameter("ENGINE", "Knock Retard Cylinder 4"),
            MutiiParameter("ENGINE", "Ignition Timing Cylinder 1"),
            MutiiParameter("ENGINE", "Ignition Timing Cylinder 2"),
            MutiiParameter("ENGINE", "Ignition Timing Cylinder 3"),
            MutiiParameter("ENGINE", "Ignition Timing Cylinder 4"),
            MutiiParameter("ENGINE", "Airflow Sensor Raw"),
            MutiiParameter("ENGINE", "Throttle Motor Position"),
            MutiiParameter("ENGINE", "Idle Control"),
            MutiiParameter("ENGINE", "Fuel Pressure Regulator"),
            MutiiParameter("ENGINE", "Fuel Rail Pressure"),
            MutiiParameter("ENGINE", "Air Temperature"),
            MutiiParameter("ENGINE", "Coolant Temperature"),
            MutiiParameter("ENGINE", "Oxygen Sensor Data"),
            MutiiParameter("ENGINE", "Fuel Trim Bank 1"),
            MutiiParameter("ENGINE", "Fuel Trim Bank 2"),
            MutiiParameter("AT", "ATF Temperature"),
            MutiiParameter("AT", "Current Gear"),
            MutiiParameter("AT", "Shift Solenoids"),
            MutiiParameter("AT", "Torque Converter Lock"),
            MutiiParameter("AT", "Line Pressure"),
            MutiiParameter("AWD", "Transfer Case Status"),
            MutiiParameter("AWD", "Center Differential Lock"),
            MutiiParameter("AWD", "Torque Split Front/Rear"),
            MutiiParameter("AWD", "AWD Clutch Status"),
            MutiiParameter("ABS", "Wheel Speed FL"),
            MutiiParameter("ABS", "Wheel Speed FR"),
            MutiiParameter("ABS", "Wheel Speed RL"),
            MutiiParameter("ABS", "Wheel Speed RR"),
            MutiiParameter("ABS", "ABS Pump Status"),
            MutiiParameter("ABS", "ABS Errors"),
            MutiiParameter("ELECTRICAL", "Battery Voltage"),
            MutiiParameter("ELECTRICAL", "Alternator Load")
        )
        val generated = mutableListOf<MutiiParameter>()
        val groups = listOf("ENGINE", "AT", "AWD", "ABS", "ELECTRICAL")
        for (g in groups) {
            for (i in 1..70) {
                generated += MutiiParameter(g, "$g MUT-II PID $i")
            }
        }
        return (core + generated).distinctBy { "${it.group}:${it.name}" }
    }
}
