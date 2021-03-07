package com.example.regularviewforfloatingnumbers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    TextView display;


    public void msg_box(String msg)
    {

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });




        alertDialog.show();

    }

    public String reg_view_for_flt(Double ssw)
    {


        String re =ssw +"";



          try {


            String after_e =  re.substring(re.indexOf("E")+1);
            Integer after_e2 = Integer.parseInt(after_e);
            String no_dot = re.replace(".","");
            String before_dot = no_dot.substring(0,after_e2+1);
            String after_dot = no_dot.substring(after_e2+1);
            after_dot = after_dot.substring(0,after_dot.indexOf('E'));
            //msg_box(before_dot+"."+after_dot);

            return before_dot+"."+after_dot;
        }
        catch (Exception e)
        {
            return re;
        }



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);


        //display.setText(reg_view_for_flt(12345678912345678912345.1235565));

msg_box(reg_view_for_flt(12345891656565.1235565));
    }
}