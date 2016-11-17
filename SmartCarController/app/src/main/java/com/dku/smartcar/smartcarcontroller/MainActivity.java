package com.dku.smartcar.smartcarcontroller;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dku.smartcar.smartcarcontroller.thread.ClientThread;
import com.dku.smartcar.smartcarcontroller.thread.TCPClient;

public class MainActivity extends AppCompatActivity {


    private EditText editAddr;
    private EditText editPort;
    private EditText editSend;
    private Button btnSend;
    private Button btnClose;
    private Button btnConnect;
    private ClientThread clientThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAddr = (EditText) findViewById(R.id.editAddr);
        editPort = (EditText) findViewById(R.id.editPort);
        editSend = (EditText) findViewById(R.id.editSend);

        btnSend = (Button) findViewById(R.id.btnSend);
        btnClose = (Button) findViewById(R.id.btnClose);
        btnConnect = (Button) findViewById(R.id.btnConnect);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSend :
                send();
                break;

            case R.id.btnConnect :
                connect();
                break;

            case R.id.btnClose :
                close();
                break;
        }
    }

    private void connect() {
        clientThread = new ClientThread(this, mhandler);
        clientThread.start();
    }

    private void send() {
        String msg = editSend.getText().toString();
        clientThread.send(msg);
    }

    private void close() {
        clientThread.close();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }

    Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}