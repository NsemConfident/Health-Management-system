package com.example.healam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CartLabActivity extends AppCompatActivity {

    ArrayList list;
    ListView lst;
    SimpleAdapter sa;
    TextView tvTotal;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    HashMap<String, String> item;
    Button datePicker, timePicker, btnCheckout, btnBack;
    private  String[][] packages = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_lab);

        datePicker = findViewById(R.id.buttonCartDatePicker);
        timePicker = findViewById(R.id.buttonCartTimePicker);
        btnCheckout = findViewById(R.id.buttoncheckout);
        btnBack = findViewById(R.id.buttonCartBack);
        tvTotal = findViewById(R.id.textViewCartTotalPrice);
        lst = findViewById(R.id.listViewCart);


        SharedPreferences sharedPreferences = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();

        Database db = new Database(getApplicationContext(), "healthcare", null, 1);
        float totalamount = 0;
        ArrayList<String> dbData = db.getCartData(username,"lab");
        Toast.makeText(getApplicationContext(), " "+dbData, Toast.LENGTH_LONG).show();
        packages = new String[dbData.size()][];
        for (int i = 0; i < packages.length; i++){
            packages[i] = new String[5];
        }
        for (int i = 0; i < dbData.size(); i++){
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            packages[i][0] = strData[0];
            packages[i][4] = "Cost: :"+strData[1]+"$";
            totalamount = totalamount + Float.parseFloat(strData[1]);
        }



        tvTotal.setText("Total cost" + totalamount);

        list = new ArrayList<>();
        for(int i = 0; i < packages.length; i++){
            item  = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", packages[i][4]);

        }

        sa = new SimpleAdapter(this, list, R.layout.multi_line,
                new String[] {"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        lst.setAdapter(sa);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartLabActivity.this, LabTestActivity.class));
            }
        });

        initTimePicker();
        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        initDatePicker();
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

    }

        public void initDatePicker(){
            DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month = month + 1;

                  datePicker.setText(dayOfMonth+"/"+month+"/"+year);
                }
            };

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int date = cal.get(Calendar.DATE);

            int style = AlertDialog.THEME_HOLO_DARK;
            datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, date);
            datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
        }

    /*
    function for time
     */

        public void initTimePicker(){
            TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                   timePicker.setText(hourOfDay+":"+minute);

                }
            };
            Calendar cal = Calendar.getInstance();
            int hrs = cal.get(Calendar.HOUR);
            int min = cal.get(Calendar.MINUTE);

            int style = AlertDialog.THEME_HOLO_DARK;
            timePickerDialog = new TimePickerDialog(this, style, timeSetListener,hrs, min, true);
        }
}