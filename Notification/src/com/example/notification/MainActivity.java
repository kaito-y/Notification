package com.example.notification;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Notificationクリック時に開くURL
		String url = "thhp://www.google.com/";
		Uri uri = Uri.parse(url);
		
		//NotificationクリックjinoPendingIntentを生成
		Intent intent = new Intent(Intent.ACTION_VIEW,uri);
		PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
		
		//NotificationManagerインスタンスを取得
		NotificationManager nManager = 
		    (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		
		//Notificationインスタンスを生成
		Notification notification = new Notification();
		
		//フラグをセット
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		//アイコンをセット
		notification.icon = R.drawable.ic_launcher;
		//通常時のテキストをセット
		notification.tickerText = "テキスト";
		//Notificationバーを開いた時に表示される内容をセット
		notification.setLatestEventInfo(getApplicationContext(),
		"タイトル",
		"メッセージ",
		pendingIntent
		);
		//Notificationを通知
		nManager.notify(1,notification);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
