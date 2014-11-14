/*
 * Copyright (c) 2013 by CDAC Chennai 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.contextawareframework.backgroundservices;

import java.util.ArrayList;
import java.util.Set;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.hardware.SensorEventListener;
import android.widget.ArrayAdapter;

public class BluetoothListener extends CAFService
{
	
	private final Context mContext;
	private static final int REQUEST_ENABLE_BT = 0;
	private BluetoothAdapter myBluetoothAdapter;
	
	
	
	public BluetoothListener(Context context) 
	{
		// TODO Auto-generated constructor stub
    	this.mContext = context;    
	}
	
	
	public Intent enablebluetooth()
	{
		
	 Log.d("ENABLE BLUETOOTH::::", "ENABLE BLUETOOTH::::" ); 	
	 Intent enableBtIntent = new Intent();
	 
	 myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();	 
	 Log.d("BLUETOOTH ADAPTER", "BLUETOOTH ADAPTER" + myBluetoothAdapter + "BLUETOOTH ADAPTER" +myBluetoothAdapter);
	 
	 if (!myBluetoothAdapter.isEnabled()) 
	 {           
		 Log.d("BLUETOOTH ENABLED", "BLUETOOTH ENABLED");		 
		 enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		 Log.d("BLUETOOTH ENABLED INSTANCE", "BLUETOOTH ENABLED INSTANCE" +enableBtIntent);
     } 	
	 return enableBtIntent;	 
	 
	}
	
	
	
	public void disablebluetooth()
	{
		
		myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		myBluetoothAdapter.disable(); 		
	}
	
	
	public Intent discoverbluetooth()	
	{
		Intent discoverIntent = new Intent();
		myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();		 
		if (!myBluetoothAdapter.isDiscovering()) 
		{               
			 discoverIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);               
        }		 
		return  discoverIntent;
	}
	
	
	// This wont work
	public void list(View view)
	{
	   final Set<BluetoothDevice>  pairedDevices;
	   final ArrayAdapter  BTArrayAdapter = null;          
	   final ArrayList bluetoothDeviceNameList = new ArrayList();
	   
	  // get paired devices
	   pairedDevices = myBluetoothAdapter.getBondedDevices();		       
	  // put it's one to the adapter

	   for(BluetoothDevice device : pairedDevices)
	   {
		   BTArrayAdapter.add(device.getName()+ "\n" + device.getAddress());
		   bluetoothDeviceNameList.add(device.getName());
		   
	   }
	   Toast.makeText(getApplicationContext(),"Show Paired Devices", Toast.LENGTH_SHORT).show();	   
	}
	

	
	
	
		
	
}