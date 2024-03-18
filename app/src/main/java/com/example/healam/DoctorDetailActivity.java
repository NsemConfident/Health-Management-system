package com.example.healam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor name: Aboko Festus", "Hospital Address: Bomaka junction","Exp: 5yrs", "mobile number: +237 6749754739", "600"},
                    {"Doctor name: Nsem Confident", "Hospital Address: Bomaka junction","Exp: 15yrs", "mobile number: +237 684857884", "900"},
                    {"Doctor name: Ambo miracle", "Hospital chiefStreet junction","Exp: 8yrs", "mobile number: +237 684994799", "300"},
                    {"Doctor name: ago Agbo", "Hospital Address: telepoint junction","Exp: 6yrs", "mobile number: +237 624587748", "500"},
                    {"Doctor name: Ester Usim", "Hospital Address: Bomaka junction","Exp: 7yrs", "mobile number: +237 621408847", "800"}
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor name: Aboko Festus", "Hospital Address: Bomaka junction","Exp: 5yrs", "mobile number: +237 6749754739", "600"},
                    {"Doctor name: Agbo Confident", "Hospital Address: Bomaka junction","Exp: 15yrs", "mobile number: +237 684857884", "900"},
                    {"Doctor name: Ikanga miracle", "Hospital chiefStreet junction","Exp: 8yrs", "mobile number: +237 684994799", "300"},
                    {"Doctor name: Lobo Agbo", "Hospital Address: telepoint junction","Exp: 6yrs", "mobile number: +237 624587748", "500"},
                    {"Doctor name: Itor Usim", "Hospital Address: Bomaka junction","Exp: 7yrs", "mobile number: +237 621408847", "800"}
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor name: Eva Festus", "Hospital Address: Bomaka junction","Exp: 5yrs", "mobile number: +237 6749754739", "600"},
                    {"Doctor name: ikan Confident", "Hospital Address: Bomaka junction","Exp: 15yrs", "mobile number: +237 684857884", "900"},
                    {"Doctor name: Lolo miracle", "Hospital chiefStreet junction","Exp: 8yrs", "mobile number: +237 684994799", "300"},
                    {"Doctor name: afombom Agbo", "Hospital Address: telepoint junction","Exp: 6yrs", "mobile number: +237 624587748", "500"},
                    {"Doctor name: Miguel Usim", "Hospital Address: Bomaka junction","Exp: 7yrs", "mobile number: +237 621408847", "800"}
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor name: ado bias", "Hospital Address: Bomaka junction","Exp: 5yrs", "mobile number: +237 6749754739", "600"},
                    {"Doctor name: abombea gagra", "Hospital Address: Bomaka junction","Exp: 15yrs", "mobile number: +237 684857884", "900"},
                    {"Doctor name: amoko miracle", "Hospital chiefStreet junction","Exp: 8yrs", "mobile number: +237 684994799", "300"},
                    {"Doctor name: Ebuka Agbo", "Hospital Address: telepoint junction","Exp: 6yrs", "mobile number: +237 624587748", "500"},
                    {"Doctor name: Tata Usim", "Hospital Address: Bomaka junction","Exp: 7yrs", "mobile number: +237 621408847", "800"}
            };


    private String[][] doctor_details5 =
            {
                    {"Doctor name: Aboko faith", "Hospital Address: IT junction","Exp: 5yrs", "mobile number: +237 6749754739", "600"},
                    {"Doctor name: dos santos", "Hospital Address: Ek junction","Exp: 15yrs", "mobile number: +237 684857884", "900"},
                    {"Doctor name: D J micheal p k", "Hospital Address: Abudabi junction","Exp: 8yrs", "mobile number: +237 684994799", "300"},
                    {"Doctor name: ago mark", "Hospital Address: tele junction","Exp: 6yrs", "mobile number: +237 624587748", "500"},
                    {"Doctor name: Brenda Usim", "Hospital Address: Bomaka junction","Exp: 7yrs", "mobile number: +237 621408847", "800"}
            };
    TextView tv;
    Button btn;

    String[][] doctor_detail = {};
    ArrayList list;
    HashMap<String, String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv = findViewById(R.id.textViewDDtitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("family physician")==0){
            doctor_detail = doctor_details1;
        } else if (title.compareTo("Dietician")==0) {
            doctor_detail = doctor_details2;
        } else if (title.compareTo("Dentist")==0) {
            doctor_detail = doctor_details3;
        } else if (title.compareTo("Surgeon")==0) {
            doctor_detail = doctor_details4;
        } else {
            doctor_detail = doctor_details5;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i<doctor_detail.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_detail[i][0]);
            item.put("line2", doctor_detail[i][1]);
            item.put("line3", doctor_detail[i][2]);
            item.put("line4", doctor_detail[i][3]);
            item.put("line5", "Cons Fees:"+" "+doctor_detail[i][4] +"$");
            list.add(item);
        }
        /*
        mapping to the layout of multi_line.xml
         */

        sa = new SimpleAdapter(this,list, R.layout.multi_line, new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
    }
}