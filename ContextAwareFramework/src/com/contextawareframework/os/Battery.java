/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        Battery
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 ******************************************************************/
package com.contextawareframework.os;

import android.os.BatteryManager;
/*********************************************************************
 * This is a POJO class for accesing all details of Battery in Android
 *********************************************************************/
public class Battery extends BatteryManager {
private static  int level=0;
private int 	BATTERY_HEALTH_COLD;
private int 	BATTERY_HEALTH_DEAD;
private int 	BATTERY_HEALTH_GOOD;
private int 	BATTERY_HEALTH_OVERHEAT;
private int 	BATTERY_HEALTH_OVER_VOLTAGE; 	
private int 	BATTERY_HEALTH_UNKNOWN;
private int 	BATTERY_HEALTH_UNSPECIFIED_FAILURE; 	
private int 	BATTERY_PLUGGED_AC;
private int 	BATTERY_PLUGGED_USB;
private int 	BATTERY_PLUGGED_WIRELESS; 	
private int 	BATTERY_STATUS_CHARGING;
private int 	BATTERY_STATUS_DISCHARGING; 	
private int 	BATTERY_STATUS_FULL;
private int 	BATTERY_STATUS_NOT_CHARGING; 	
private int 	BATTERY_STATUS_UNKNOWN; 

private String 	EXTRA_HEALTH;
private String 	EXTRA_ICON_SMALL;
private String 	EXTRA_LEVEL;
private String 	EXTRA_PLUGGED;
private String 	EXTRA_PRESENT;
private String 	EXTRA_SCALE;
private String 	EXTRA_STATUS;
private String 	EXTRA_TECHNOLOGY;
private String 	EXTRA_TEMPERATURE;
private String 	EXTRA_VOLTAGE;
public int getBATTERY_HEALTH_COLD() {
	return BATTERY_HEALTH_COLD;
}

public void setBATTERY_HEALTH_COLD(int bATTERY_HEALTH_COLD) {
	BATTERY_HEALTH_COLD = bATTERY_HEALTH_COLD;
}

public int getBATTERY_HEALTH_DEAD() {
	return BATTERY_HEALTH_DEAD;
}

public void setBATTERY_HEALTH_DEAD(int bATTERY_HEALTH_DEAD) {
	BATTERY_HEALTH_DEAD = bATTERY_HEALTH_DEAD;
}

public int getBATTERY_HEALTH_GOOD() {
	return BATTERY_HEALTH_GOOD;
}

public void setBATTERY_HEALTH_GOOD(int bATTERY_HEALTH_GOOD) {
	BATTERY_HEALTH_GOOD = bATTERY_HEALTH_GOOD;
}

public int getBATTERY_HEALTH_OVERHEAT() {
	return BATTERY_HEALTH_OVERHEAT;
}

public void setBATTERY_HEALTH_OVERHEAT(int bATTERY_HEALTH_OVERHEAT) {
	BATTERY_HEALTH_OVERHEAT = bATTERY_HEALTH_OVERHEAT;
}

public int getBATTERY_HEALTH_OVER_VOLTAGE() {
	return BATTERY_HEALTH_OVER_VOLTAGE;
}

public void setBATTERY_HEALTH_OVER_VOLTAGE(int bATTERY_HEALTH_OVER_VOLTAGE) {
	BATTERY_HEALTH_OVER_VOLTAGE = bATTERY_HEALTH_OVER_VOLTAGE;
}

public int getBATTERY_HEALTH_UNKNOWN() {
	return BATTERY_HEALTH_UNKNOWN;
}

public void setBATTERY_HEALTH_UNKNOWN(int bATTERY_HEALTH_UNKNOWN) {
	BATTERY_HEALTH_UNKNOWN = bATTERY_HEALTH_UNKNOWN;
}

public int getBATTERY_HEALTH_UNSPECIFIED_FAILURE() {
	return BATTERY_HEALTH_UNSPECIFIED_FAILURE;
}

public void setBATTERY_HEALTH_UNSPECIFIED_FAILURE(
		int bATTERY_HEALTH_UNSPECIFIED_FAILURE) {
	BATTERY_HEALTH_UNSPECIFIED_FAILURE = bATTERY_HEALTH_UNSPECIFIED_FAILURE;
}

public int getBATTERY_PLUGGED_AC() {
	return BATTERY_PLUGGED_AC;
}

public void setBATTERY_PLUGGED_AC(int bATTERY_PLUGGED_AC) {
	BATTERY_PLUGGED_AC = bATTERY_PLUGGED_AC;
}

public int getBATTERY_PLUGGED_USB() {
	return BATTERY_PLUGGED_USB;
}

public void setBATTERY_PLUGGED_USB(int bATTERY_PLUGGED_USB) {
	BATTERY_PLUGGED_USB = bATTERY_PLUGGED_USB;
}

public int getBATTERY_PLUGGED_WIRELESS() {
	return BATTERY_PLUGGED_WIRELESS;
}

public void setBATTERY_PLUGGED_WIRELESS(int bATTERY_PLUGGED_WIRELESS) {
	BATTERY_PLUGGED_WIRELESS = bATTERY_PLUGGED_WIRELESS;
}

public int getBATTERY_STATUS_CHARGING() {
	return BATTERY_STATUS_CHARGING;
}

public void setBATTERY_STATUS_CHARGING(int bATTERY_STATUS_CHARGING) {
	BATTERY_STATUS_CHARGING = bATTERY_STATUS_CHARGING;
}

public int getBATTERY_STATUS_DISCHARGING() {
	return BATTERY_STATUS_DISCHARGING;
}

public void setBATTERY_STATUS_DISCHARGING(int bATTERY_STATUS_DISCHARGING) {
	BATTERY_STATUS_DISCHARGING = bATTERY_STATUS_DISCHARGING;
}

public int getBATTERY_STATUS_FULL() {
	return BATTERY_STATUS_FULL;
}

public void setBATTERY_STATUS_FULL(int bATTERY_STATUS_FULL) {
	BATTERY_STATUS_FULL = bATTERY_STATUS_FULL;
}

public int getBATTERY_STATUS_NOT_CHARGING() {
	return BATTERY_STATUS_NOT_CHARGING;
}

public void setBATTERY_STATUS_NOT_CHARGING(int bATTERY_STATUS_NOT_CHARGING) {
	BATTERY_STATUS_NOT_CHARGING = bATTERY_STATUS_NOT_CHARGING;
}

public int getBATTERY_STATUS_UNKNOWN() {
	return BATTERY_STATUS_UNKNOWN;
}

public void setBATTERY_STATUS_UNKNOWN(int bATTERY_STATUS_UNKNOWN) {
	BATTERY_STATUS_UNKNOWN = bATTERY_STATUS_UNKNOWN;
}

public String getEXTRA_HEALTH() {
	return EXTRA_HEALTH;
}

public void setEXTRA_HEALTH(String eXTRA_HEALTH) {
	EXTRA_HEALTH = eXTRA_HEALTH;
}

public String getEXTRA_ICON_SMALL() {
	return EXTRA_ICON_SMALL;
}

public void setEXTRA_ICON_SMALL(String eXTRA_ICON_SMALL) {
	EXTRA_ICON_SMALL = eXTRA_ICON_SMALL;
}

public String getEXTRA_LEVEL() {
	return EXTRA_LEVEL;
}

public void setEXTRA_LEVEL(String eXTRA_LEVEL) {
	EXTRA_LEVEL = eXTRA_LEVEL;
}

public String getEXTRA_PLUGGED() {
	return EXTRA_PLUGGED;
}

public void setEXTRA_PLUGGED(String eXTRA_PLUGGED) {
	EXTRA_PLUGGED = eXTRA_PLUGGED;
}

public String getEXTRA_PRESENT() {
	return EXTRA_PRESENT;
}

public void setEXTRA_PRESENT(String eXTRA_PRESENT) {
	EXTRA_PRESENT = eXTRA_PRESENT;
}

public String getEXTRA_SCALE() {
	return EXTRA_SCALE;
}

public void setEXTRA_SCALE(String eXTRA_SCALE) {
	EXTRA_SCALE = eXTRA_SCALE;
}

public String getEXTRA_STATUS() {
	return EXTRA_STATUS;
}

public void setEXTRA_STATUS(String eXTRA_STATUS) {
	EXTRA_STATUS = eXTRA_STATUS;
}

public String getEXTRA_TECHNOLOGY() {
	return EXTRA_TECHNOLOGY;
}

public void setEXTRA_TECHNOLOGY(String eXTRA_TECHNOLOGY) {
	EXTRA_TECHNOLOGY = eXTRA_TECHNOLOGY;
}

public String getEXTRA_TEMPERATURE() {
	return EXTRA_TEMPERATURE;
}

public void setEXTRA_TEMPERATURE(String eXTRA_TEMPERATURE) {
	EXTRA_TEMPERATURE = eXTRA_TEMPERATURE;
}

public String getEXTRA_VOLTAGE() {
	return EXTRA_VOLTAGE;
}

public void setEXTRA_VOLTAGE(String eXTRA_VOLTAGE) {
	EXTRA_VOLTAGE = eXTRA_VOLTAGE;
}



public static int getLevel() {
	
	return level;
}

public static void setLevel(int level) {
	Battery.level = level;
}

	
}
