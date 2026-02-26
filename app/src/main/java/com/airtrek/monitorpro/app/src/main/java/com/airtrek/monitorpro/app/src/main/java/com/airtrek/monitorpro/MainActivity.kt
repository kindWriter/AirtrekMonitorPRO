package com.airtrek.monitorpro

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.airtrek.monitorpro.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val parameterCatalog = MutiiParameterCatalog.load()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ensureBluetoothPermissions()
        ContextCompat.startForegroundService(this, Intent(this, ElmForegroundService::class.java))

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            parameterCatalog.map { "${it.group}: ${it.name}" }
        )
        binding.parameterList.adapter = adapter

        binding.safeModeLabel.text = getString(R.string.safe_mode_enabled)
        binding.vehicleDetails.text = getString(R.string.vehicle_details)
        binding.paramCount.text = getString(R.string.param_count, parameterCatalog.size)

        val diag = AiDealerDiagnostics.sample()
        binding.engineHealth.text = getString(R.string.engine_health, diag.engineHealth.roundToInt())
        binding.transmissionHealth.text = getString(R.string.transmission_health, diag.transmissionHealth.roundToInt())
        binding.awdHealth.text = getString(R.string.awd_health, diag.awdHealth.roundToInt())
        binding.warnings.text = diag.warnings.joinToString(prefix = "⚠ ", separator = "\n⚠ ")

        binding.scanButton.setOnClickListener {
            binding.status.text = getString(R.string.scan_status)
        }
        binding.clearButton.setOnClickListener {
            binding.status.text = getString(R.string.clear_dtc_status)
        }
    }

    private fun ensureBluetoothPermissions() {
        val toRequest = mutableListOf<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                toRequest += Manifest.permission.BLUETOOTH_CONNECT
            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
                toRequest += Manifest.permission.BLUETOOTH_SCAN
            }
        }
        if (toRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, toRequest.toTypedArray(), 2201)
        }
    }
}
