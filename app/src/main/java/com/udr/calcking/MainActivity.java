package com.udr.calcking;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    static int input;
    static int total =0;
    int sumRand;
    private static int nr1;
    private static int nr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void fout() {
        Context context = getApplicationContext();
        Toast.makeText(context, "Fout!", Toast.LENGTH_SHORT).show();
        countFalse();
        ((EditText) findViewById(R.id.Input)).setText("");

    }

    private void noInput() {

        Context context = getApplicationContext();
        Toast.makeText(context, "geen input!", Toast.LENGTH_SHORT).show();
    }

    private void wrongInput() {

        Context context = getApplicationContext();
        Toast.makeText(context, "onjuiste input!", Toast.LENGTH_SHORT).show();
        ((EditText) findViewById(R.id.Input)).setText("");
    }


    private void goed() {

        Context context = getApplicationContext();
        Toast.makeText(context, "Hoera!!!", Toast.LENGTH_SHORT).show();
        ((EditText) findViewById(R.id.Input)).setText("");
        count();
        getNewSum();

    }
    

    private void calcPlus() {
        nr1 = num1(100);
        nr2 = num2(100);
        TextView signView = (TextView) findViewById(R.id.sign);
        signView.setText("+");
        total = nr1 + nr2;


    }

    private void calcMultiply() {
        nr1 = num1(10);
        nr2 = num2(10);
        TextView signView = (TextView) findViewById(R.id.sign);
        signView.setText("x");
        total = nr1 * nr2;


    }


    private void calcMinus() {
        nr1 = num1(100);
        nr2 = num2(100);
        if(nr1 < nr2) {
            int temp = nr1;
            nr1 = nr2;
            nr2 = temp;
            TextView nr1View = (TextView) findViewById(R.id.nr1);
            nr1View.setText(" " + nr1);
            nr1View = (TextView) findViewById(
                    R.id.nr2);
            nr1View.setText(" " + nr2);
        }
        TextView signView = (TextView) findViewById(R.id.sign);
        signView.setText("-");
        total = nr1 - nr2;

    }

    private int num1(int range) {
        nr1 = (int) (Math.random() * range);
        TextView nr1View = (TextView) findViewById(
                R.id.nr1);
        nr1View.setText(" " + nr1);
        return nr1;
    }

    private int num2(int range) {
        nr2 = (int) (Math.random() * range);
        TextView nr1View = (TextView) findViewById(
                R.id.nr2);
        nr1View.setText(" " + nr2);
        return nr2;
    }

    private int count() {
        TextView countText = (TextView) findViewById(R.id.count);
        int count = Integer.valueOf(countText.getText().toString());
        count++;
        countText.setText("" + count);
        return count;
    }

    private int countFalse() {
        TextView countText = (TextView) findViewById(R.id.countFalse);
        int count = Integer.valueOf(countText.getText().toString());
        count++;
        countText.setText("" + count);
        return count;
    }

    private void getNewSum() {
        sumRand = (int) (Math.random() * 3 + 1);

        Log.v("main", "sumRandom" + sumRand);
        if (sumRand == 1) {
            calcPlus();
        } else if (sumRand == 2) {
            calcMinus();

        }
        if (sumRand == 3) {
            calcMultiply();

        }
    }


    public void getCheck(View view) {
        EditText inputText = (EditText) findViewById(R.id.Input);

        try{
            if (inputText.length() == 0) {
                noInput();
            } else {
                input = Integer.parseInt(inputText.getText().toString());
                if (input == total) {
                    //Log.v ("inputMinus =" , ""+input );
                    goed();
                } else {
                    fout();
                }

            }
        }catch (NumberFormatException e){
            wrongInput();
        }
    }}


