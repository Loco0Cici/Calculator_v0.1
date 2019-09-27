package com.example.reese.calculator;

import android.icu.math.BigDecimal;
import android.icu.text.DecimalFormat;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by reese on 2018/3/9.
 */

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private String text = "";
    private int flag;
    private boolean n,Continue;
    private double n1,n2,res;
    private Button num0 = null;
    private Button num00 = null;
    private Button num1 = null;
    private Button num2 = null;
    private Button num3 = null;
    private Button num4 = null;
    private Button num5 = null;
    private Button num6 = null;
    private Button num7 = null;
    private Button num8 = null;
    private Button num9 = null;
    private Button addition = null;
    private Button C = null;
    private Button xx = null;
    private Button percent = null;
    private Button x1 = null;
    private Button division = null;
    private Button genhao = null;
    private Button multiplication = null;
    private Button delete = null;
    private Button subtraction = null;
    private Button point = null;
    private Button equal = null;
    private Button symbol = null;
    private Button second = null;
    private Button eighth = null;
    private Button sixteenth = null;
    private Button centigrade = null;
    private Button sin = null;
    private Button cos = null;
    private Button tan = null;
    private Button pai = null;
    private TextView input = null;

    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null){
            actionbar.hide();
        }

        num0 = (Button)findViewById(R.id.num0);
        num00 = (Button)findViewById(R.id.num00);
        num1 = (Button)findViewById(R.id.num1);
        num2 = (Button)findViewById(R.id.num2);
        num3 = (Button)findViewById(R.id.num3);
        num4 = (Button)findViewById(R.id.num4);
        num5 = (Button)findViewById(R.id.num5);
        num6 = (Button)findViewById(R.id.num6);
        num7 = (Button)findViewById(R.id.num7);
        num8 = (Button)findViewById(R.id.num8);
        num9 = (Button)findViewById(R.id.num9);
        addition = (Button)findViewById(R.id.addition);
        C = (Button)findViewById(R.id.C);
        xx = (Button)findViewById(R.id.xx);
        percent = (Button)findViewById(R.id.percent);
        x1 = (Button)findViewById(R.id.x1);
        division = (Button)findViewById(R.id.division);
        genhao = (Button)findViewById(R.id.genhao);
        multiplication = (Button)findViewById(R.id.multiplication);
        delete = (Button)findViewById(R.id.delete);
        subtraction = (Button)findViewById(R.id.subtraction);
        point = (Button)findViewById(R.id.point);
        equal = (Button)findViewById(R.id.equal);
        symbol = (Button)findViewById(R.id.symbol);
        second = (Button)findViewById(R.id.second);
        eighth = (Button)findViewById(R.id.eighth);
        sixteenth = (Button)findViewById(R.id.sixteenth);
        centigrade = (Button)findViewById(R.id.centigrade);
        sin = (Button)findViewById(R.id.sin);
        cos = (Button)findViewById(R.id.cos);
        tan = (Button)findViewById(R.id.tan);
        pai = (Button)findViewById(R.id.pai);
        input = (TextView)findViewById(R.id.input);

        num0.setOnClickListener(this);
        num00.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        addition.setOnClickListener(this);
        C.setOnClickListener(this);
        xx.setOnClickListener(this);
        percent.setOnClickListener(this);
        x1.setOnClickListener(this);
        division.setOnClickListener(this);
        genhao.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        delete.setOnClickListener(this);
        subtraction .setOnClickListener(this);
        point.setOnClickListener(this);
        equal.setOnClickListener(this);
        symbol.setOnClickListener(this);
        second.setOnClickListener(this);
        eighth.setOnClickListener(this);
        sixteenth.setOnClickListener(this);
        centigrade.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        pai.setOnClickListener(this);

        n = false;
        Continue = false;
        flag = 10;

    }

    @Override
    public void onClick(View v) {
        if(text.length()<10)
        switch(v.getId()){
            case R.id.num0:{
                if (text.equals("")) {
                    input.setText("0");
                } else {
                    text = text + "0";
                    input.setText(text);
                }
                break;
            }
            case R.id.num00:text = text+"00";Continue = false;input.setText(text);break;
            case R.id.num1:text = text+"1";Continue = false;input.setText(text);break;
            case R.id.num2:text = text+"2";Continue = false;input.setText(text);break;
            case R.id.num3:text = text+"3";Continue = false;input.setText(text);break;
            case R.id.num4:text = text+"4";Continue = false;input.setText(text);break;
            case R.id.num5:text = text+"5";Continue = false;input.setText(text);break;
            case R.id.num6:text = text+"6";Continue = false;input.setText(text);break;
            case R.id.num7:text = text+"7";Continue = false;input.setText(text);break;
            case R.id.num8:text = text+"8";Continue = false;input.setText(text);break;
            case R.id.num9:text = text+"9";Continue = false;input.setText(text);break;
            case R.id.pai:{
                Continue = false;
                text = Double.toString(Math.PI);
                input.setText(text);
                break;
            }
        }
        switch(v.getId()){
            case R.id.point:{       //输入小数点
                if(!n){
                    n=false;
                    Continue=false;
                    if(text.equals("")){
                        text=text+"0.";
                    }
                    else
                        text=text+".";
                    input.setText(text);
                    break;
                }
                n=false;
            }
            case R.id.C:text="";n1=0;n2=0;n=false;input.setText("0");break; //清空
            case R.id.delete:  //删除一位，字符串长度大于0时才截取字符,如果长度为1，则直接把字符串设置为0
                if (text.equals("")){
                    text = "0";
                }
                else if(text.length() > 0){
                    if(text.length() == 1) {
                        text = "0";
                    }
                    else {
                        text = text.substring(0,text.length()-1);
                        input.setText(text);
                    }
                }
                n=false;
                break;
            case R.id.percent:{     //百分号
                if(!text.equals("")) {
                    String num_s;
                    Double temp;
                    if (text.equals("") && Continue) {
                        n1 = n1 / 100;
                        num_s = Double.toString(n1);
                        temp = n1;
                    } else {
                        temp = Double.parseDouble(text) / 100;
                        num_s = Double.toString(temp);
                        text = num_s;
                    }
                    if (num_s.length() > 8) {
                        input.setText(new DecimalFormat("#.###E00" +
                                "").format(temp));
                    } else
                        input.setText(num_s);
                }
                n=false;
                break;
            }
            case R.id.division: {       //除法
                flag=1;
                if(!Continue&&flag==1&&!text.equals("")) {
                    n1 = Double.parseDouble(text);
                    text = "";
                }
                n=false;
                break;
            }
            case R.id.multiplication: {     //乘法
                flag=2;
                if(!Continue&&flag==2&&!text.equals("")) {
                    n1 = Double.parseDouble(text);
                    text = "";
                }
                n=false;
                break;
            }
            case R.id.subtraction: {        //减法
                flag=3;
                if(!Continue&&flag==3&&!text.equals("")) {
                    n1 = Double.parseDouble(text);
                    text = "";
                }
                n=false;
                break;
            }
            case R.id.addition: {       //加法
                flag=4;
                if(!Continue&&flag==4&&!text.equals("")) {
                    n1 = Double.parseDouble(text);
                    text = "";
                }
                n=false;
                break;
            }
            case R.id.xx: {         //x的y次方
                flag=5;
                if(!Continue&&flag==5&&!text.equals("")) {
                    n1 = Double.parseDouble(text);
                    text = "";
                }
                n=false;
                break;
            }
            case R.id.genhao: {     //根号x
                flag=6;
                if(!Continue&&flag==6&&!text.equals("")) {
                    n1 = Double.parseDouble(text);
                    text = "";
                }
                n=false;
                break;
            }
            case R.id.x1: {         //x取倒数
                flag=7;
                if(!Continue&&flag==7&&!text.equals("")) {
                    n1 = Double.parseDouble(text);
                    n2=1;
                    text = "";
                }
                n=false;
                break;
            }
            case R.id.symbol: {         //正负号
                if(!text.equals(""))
                    if(!Continue) {
                        int len = text.length();
                        n1 = Double.parseDouble(text);
                        n1 = 0 - n1;
                        text = Double.toString(n1);
                        if ((Math.floor(n1) - n1) == 0 && text.length() == len) {
                            BigDecimal R_num = new BigDecimal(text);
                            text="";
                            text = R_num.setScale(0, BigDecimal.ROUND_UP).toString();
                        }
                        input.setText(text);
                    }
                    else{
                        n1=0-n1;
                        String num_S = Double.toString(n1);
                        if(num_S.length()>11)
                            input.setText(new DecimalFormat("#.###E00").format(n1));
                        else {
                            if ((Math.floor(n1) - n1) == 0) {
                                BigDecimal R_num = new BigDecimal(num_S);
                                num_S = R_num.setScale(0, BigDecimal.ROUND_UP).toString();
                                input.setText(num_S);
                            } else {
                                input.setText(num_S);
                            }
                        }
                    }
                break;
            }
            case R.id.second: {         //十进制转换为二进制
                if (text.equals("")){
                    text = "0";
                }
                else {
                    input.setText(Integer.toBinaryString((int)Double.parseDouble(text)));
                }
                n=false;
                break;
            }
            case R.id.eighth: {         //十进制转换为八进制
                if (text.equals("")){
                    text = "0";
                }
                else {
                    input.setText(Integer.toOctalString((int)Double.parseDouble(text)));
                }
                n=false;
                break;
            }
            case R.id.sixteenth: {      //十进制转换为十六进制
                if (text.equals("")){
                    text = "0";
                }
                else {
                    input.setText(Integer.toHexString((int)Double.parseDouble(text)));
                }
                n=false;
                break;
            }
            case R.id.centigrade: {    //摄氏度转变为华氏度
                if (text.equals("")){
                    text = "0";
                }
                else {
                    n1=(Double.parseDouble(text) * 9 / 5) + 32;
                    String num_S = Double.toString(n1);
                    input.setText(num_S);
                }
                n=false;
                break;
            }
            case R.id.sin: {
                if (text.equals("")){
                    text = "0";
                }
                else {
                    n1 = Double.parseDouble(text);
                    String num_S = Double.toString(Math.sin(Math.toRadians(n1)));
                    input.setText(num_S);
                }
                n=false;
                break;
            }
            case R.id.cos: {
                if (text.equals("")){
                    text = "0";
                }
                else {
                    n1 = Double.parseDouble(text);
                    String num_S = Double.toString(Math.cos(Math.toRadians(n1)));
                    input.setText(num_S);
                }
                n=false;
                break;
            }
            case R.id.tan: {
                if (text.equals("")) {
                    text = "0";
                } else {
                    n1 = Double.parseDouble(text);
                    String num_S = Double.toString(Math.tan(Math.toRadians(n1)));
                    input.setText(num_S);
                }
                n = false;
                break;
            }
            case R.id.equal: {          //等号
                n = false;
                if (text.equals(""))
                    n2 = 0.0;
                else
                    n2 = Double.parseDouble(text);
                if (flag == 1) {
                    if (n2 != 0.0)
                        res = n1 / n2;
                    else {
                        input.setText("错误");
                        break;
                    }
                } else if (flag == 2) {
                    res = n1 * n2;
                } else if (flag == 3) {
                    res = n1 - n2;
                } else if (flag == 4) {
                    res = n1 + n2;
                } else if (flag == 5) {
                    res = Math.pow(n1,n2);
                }else if (flag == 6) {
                    res = Math.sqrt(n1);
                }else if (flag == 7) {
                    if (n1 != 0.0)
                        res = 1 / n1;
                    else {
                        input.setText("错误");
                        break;
                    }
                } else {
                    if (!text.equals(""))
                        res = Double.parseDouble(text);
                }
                text = "";
                text = Double.toString(res);
                if (text.length() > 11) {
                    input.setText(new DecimalFormat("#.###E00").format(res));
                } else {
                    if ((Math.floor(res) - res) != 0) {
                        input.setText(text);
                    } else {
                        BigDecimal R_num = new BigDecimal(text);
                        text = R_num.setScale(0, BigDecimal.ROUND_UP).toString();
                        input.setText(text);
                    }
                }
                n1 = res;
                text = "";
                Continue = true;
                flag = 8;
                break;
            }

        }

    }
}
