package com.example.com.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText et1, et2, det1, det2;
    Button b1;
    TextView toastText;
    View dialogView, toastView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder (MainActivity.this);
                det1 = (EditText) dialogView.findViewById(R.id.det1);
                det2 = (EditText) dialogView.findViewById(R.id.det2);
                det1.setText(et1.getText().toString());
                det2.setText(et2.getText().toString());

                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.p);
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        det1 = (EditText) dialogView.findViewById(R.id.det1);
                        det2 = (EditText) dialogView.findViewById(R.id.det2);

                        et1.setText(det1.getText().toString());
                        et2.setText(det2.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        Toast toast = new Toast(MainActivity.this);
                        int xoffset = (int)(Math.random() * display.getWidth());
                        int yoffset = (int)(Math.random() * display.getHeight());
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, xoffset, yoffset);
                        toastView = (View) View.inflate(MainActivity.this, R.layout.toast, null);
                        toastText = (TextView) toastView.findViewById(R.id.toastText1);
                        toastText.setText("취소했습니다");
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }

}
