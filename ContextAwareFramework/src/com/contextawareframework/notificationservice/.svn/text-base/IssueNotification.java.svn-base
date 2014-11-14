/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        Notification
 * @Created:    21.07.2014
 * @author:     Divya
 * Last Change: 06.08.2014 by Divya
 ******************************************************************/

package com.contextawareframework.notificationService;
import com.contextawareframework.backgroundservices.Text2Speech;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
/**
 *This class will issue notification.The developer can set Title,icon,Ticker text,
 *Content Text,Content Title by just passing the value to the startAlert() 
*/
public class IssueNotification {

	private Context context;
	private boolean readNotification = false;
	public IssueNotification(Context mContext, boolean enableReadNotification){
		
		//Passes the context of the application component
		context=mContext; 
		
		//the value of check is true if developer wants the notifications to be read out
		readNotification=enableReadNotification;
	}
/**
 * Method to issue notification,the developer just requires to pass the PendingIntent object,Resource id 
 * to be used as icon in the status bar,Text to scroll on the status bar,Text which has to be set as 
 * the first line of text in the platform notification template,Text which has to be set as the second
 * line of text in the platform notification template.
 * @param pintent
 * @param icon
 * @param tickerText
 * @param contentTitle
 * @param contentText
 */
	public void startAlert(PendingIntent pintent,int icon,CharSequence tickerText,CharSequence contentTitle,CharSequence contentText,int id)//(View view)
	{ 
		try{
			NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
			
			//Sets the second line of text in the platform notification template.
			notification.setContentTitle(contentTitle);
			
			//Sets the first line of text in the platform notification template.
			notification.setContentText(contentText);
			
			//Sets the icon 
			notification.setSmallIcon(icon);
			
			//Sets the text to scroll on the status bar
			notification.setTicker(tickerText);
			
			//Supply a PendingIntent to be sent when the notification is clicked.
			notification.setContentIntent(pintent);
			
			//Notification automatically dismissed when user touches it
			notification.setAutoCancel(true);
			
			//Obtain a handle to Notification Service
			NotificationManager nmgr=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
			
			//Post notification on the status bar
			nmgr.notify(id,notification.build());
			
			//Check if user wants the notification to be read out
				if(readNotification){
					Intent intent=new Intent(context,Text2Speech.class);
					intent.putExtra("From",contentTitle);
					context.startService(intent);
				}

		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
