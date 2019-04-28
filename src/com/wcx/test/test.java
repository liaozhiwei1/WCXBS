package com.wcx.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;

public class test {
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        ServerSocket client=new ServerSocket(8080);
        Socket server = client.accept();
        String str=new String();
        BufferedOutputStream dos=new BufferedOutputStream(server.getOutputStream());
        while(true)
        {
            String a=test.formatDouble4(Math.random()*100);
            String b=test.formatDouble4(Math.random()*100);
            str="*"+a+"@"+b;
            String c=test.formatDouble4(Math.random()*100);
            String d=test.formatDouble4(Math.random()*100);
            str=str+"#"+c+"@"+d;
            String e=test.formatDouble4(Math.random()*100);
            String f=test.formatDouble4(Math.random()*100);
            str=str+"#"+a+"@"+b+"*";
            byte[] a1=str.getBytes();
            System.out.println(str);
            dos.write(a1,0,a1.length);
            dos.flush();
            Thread.sleep(2000);
        }
    }
    public static String formatDouble4(double d) {
        DecimalFormat df = new DecimalFormat("00.00");
        return df.format(d);
    }

}
