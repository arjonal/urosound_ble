package es.deustotech.bleadv

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.AdvertiseCallback
import android.bluetooth.le.AdvertiseData
import android.bluetooth.le.AdvertiseSettings
import android.os.Bundle
import android.os.ParcelUuid
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import es.deustotech.bleadv.databinding.ActivityMainBinding
import org.altbeacon.beacon.Beacon
import org.altbeacon.beacon.BeaconParser
import org.altbeacon.beacon.BeaconTransmitter
import java.util.*


class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    var advertiser = BluetoothAdapter.getDefaultAdapter().bluetoothLeAdvertiser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        //binding = ActivityMainBinding.inflate(layoutInflater)
       // setContentView(binding.root)


        val beacon = Beacon.Builder()
            .setId1("2f234454-cf6d-4a0f-adf2-f4911ba9ffa6")
            .setId2("1")
            .setId3("2")
            .setManufacturer(0x0118)
            .setTxPower(-59)
            .setDataFields(Arrays.asList(0))
            .build()
        val beaconParser = BeaconParser()
            .setBeaconLayout("m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25")
        val beaconTransmitter = BeaconTransmitter(getApplicationContext(), beaconParser)
        beaconTransmitter.startAdvertising(beacon)


        //advertiser.startAdvertising(settings, data2, advertisingCallback );

    }


    var ble_uuid = "CDB7950D-73F1-4D4D-8E47-C090502DBD63"




    fun show_toast(text:String){
        val duration = Toast.LENGTH_LONG

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

}