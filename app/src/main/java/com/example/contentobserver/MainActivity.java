package com.example.contentobserver;

import android.database.ContentObserver;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String Tag="MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI,true,new ContactsObserver(new Handler()));

    }

    private final class ContactsObserver extends ContentObserver {
        public ContactsObserver(Handler handler){
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            Log.v(Tag,"联系人数据发生变化");
            Toast.makeText(MainActivity.this,"联系人数据发生变化",Toast.LENGTH_LONG).show();
        }

    }

}
