package com.wcx.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.wcx.Dao.selins;
import com.wcx.pojo.Data;

public class server {
    public static String str;
    public Socket socket;

    public server() {
        try {
            socket = new Socket("192.168.4.1", 8090); //创建socket客户端并连接服务器
            System.out.println("连接成功");
            MyThread m = new MyThread(socket);  //连接成功启动线程
            new Thread(m).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class MyThread implements Runnable {
    public BufferedInputStream dis;
    public Socket socket;
    StringBuffer str1 = new StringBuffer();    //储存需要加入的数据
    selins sl = new selins();
    String[] b;
    boolean bloo;
    boolean d;

    MyThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        boolean wflag1 = true;
        boolean sflag1 = true;
        boolean wflag2 = true;
        boolean sflag2 = true;
        boolean wflag3 = true;
        boolean sflag3 = true;
        email ea = new email();
        try {
            dis = new BufferedInputStream(socket.getInputStream());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        while (true) {
            d = true;
            bloo = true;
            try {
                byte[] c = new byte[1024];
                int len = 0;
                while (-1 != (len = dis.read(c))) {
                    String temp = new String(c, 0, len);
                    String temps = temp.substring(1,temp.indexOf("*",3));
                    System.out.println(temps);
                    /*str1 = str1.append(str);
                    String temps = str1.substring(1, str1.indexOf("*", str1.indexOf("*") + 1));
                    System.out.println(temps);
                    str1.delete(0, str1.indexOf("*", str1.indexOf("*") + 1) + 1);
                    System.out.println(str1);*/
                    b = temps.split("#");
                    if (b[0].equals("!!!!!!!!!!!")) {
                        System.out.println("没有数据");
                    } else {
                        String[] c1 = b[0].split("@");
                        for (int i = 0; i < 2; i++) {
                            d = Pattern.matches("^[0-9]{2}\\.[0-9]{2}$", c1[i]);
                            if (!d) {
                                System.out.println(c1[i]);
                                System.out.println("earro");
                                bloo = false;
                                break;
                            }
                        }
                        if (bloo) {
                            if (new Double(c1[0]) > 30 && wflag1) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器一温度过高");
                                        } catch (MessagingException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                wflag1 = false;
                            }
                            if (new Double(c1[1]) > 90 && sflag1) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器一湿度过高");
                                        } catch (MessagingException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                sflag1 = false;
                            }
                            if (new Double(c1[0]) < 30 && new Double(c1[0]) > 10 && !wflag1) {
                                wflag1 = true;
                            }
                            if (new Double(c1[1]) < 90 && new Double(c1[1]) > 70 && !sflag1) {
                                sflag1 = true;
                            }
                            if (new Double(c1[0]) < 10 && wflag1) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器一温度过低");
                                        } catch (MessagingException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                wflag1 = false;
                            }
                            if (new Double(c1[1]) < 70 && sflag1) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器一湿度过低");
                                        } catch (MessagingException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                sflag1 = false;
                            }
                            Data da = new Data();
                            da.setTemperature(c1[0]);
                            da.setHumidity(c1[1]);
                            sl.ins(da);
                        }
                    }
                    if (b[1].equals("!!!!!!!!!!!")) {
                        System.out.println("没有数据");
                    } else {
                        String[] c1 = b[1].split("@");
                        for (int i = 0; i < 2; i++) {
                            d = Pattern.matches("^[0-9]{2}\\.[0-9]{2}$", c1[i]);
                            if (!d) {
                                System.out.println(c1[i]);
                                System.out.println("earro");
                                bloo = false;
                                break;
                            }
                        }
                        if (bloo) {
                            if (new Double(c1[0]) > 30 && wflag2) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器二温度过高");
                                        } catch (MessagingException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                wflag2 = false;
                            }
                            if (new Double(c1[1]) > 90 && sflag2) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器二湿度过高");
                                        } catch (MessagingException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                sflag2 = false;
                            }
                            if (new Double(c1[0]) < 30 && new Double(c1[0]) > 10 && !wflag2) {
                                wflag2 = true;
                            }
                            if (new Double(c1[1]) < 90 && new Double(c1[1]) > 70 && !sflag2) {
                                sflag2 = true;
                            }
                            if (new Double(c1[0]) < 10 && wflag2) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器二温度过低");
                                        } catch (MessagingException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                wflag2 = false;
                            }
                            if (new Double(c1[1]) < 70 && sflag2) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器二湿度过低");
                                        } catch (MessagingException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                sflag2 = false;
                            }

                            Data da = new Data();
                            da.setTemperature(c1[0]);
                            da.setHumidity(c1[1]);
                            sl.ins1(da);
                            System.out.println(da);
                        }
                    }
                    if (b[2].equals("!!!!!!!!!!!")) {
                        System.out.println("没有数据");
                    } else {
                        String[] c1 = b[2].split("@");
                        for (int i = 0; i < 2; i++) {
                            d = Pattern.matches("^[0-9]{2}\\.[0-9]{2}$", c1[i]);
                            if (!d) {
                                System.out.println(c1[i]);
                                System.out.println("earro");
                                bloo = false;
                                break;
                            }
                        }
                        if (bloo) {
                            if (new Double(c1[0]) > 30 && wflag3) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器三温度过高");
                                        } catch (MessagingException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                wflag3 = false;
                            }
                            if (new Double(c1[1]) > 90 && sflag3) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器三湿度过高");
                                        } catch (MessagingException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                sflag3 = false;
                            }
                            if (new Double(c1[0]) < 30 && new Double(c1[0]) > 10 && !wflag3) {
                                wflag3 = true;
                            }
                            if (new Double(c1[1]) < 90 && new Double(c1[1]) > 70 && !sflag3) {
                                sflag3 = true;
                            }
                            if (new Double(c1[0]) < 10 && wflag3) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器三温度过低");
                                        } catch (MessagingException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                wflag3 = false;
                            }
                            if (new Double(c1[1]) < 70 && sflag3) {
                                Thread t1 = new Thread() {
                                    public void run() {
                                        try {
                                            ea.fun("传感器三湿度过低");
                                        } catch (MessagingException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //t1.start();
                                sflag3 = false;
                            }
                            Data da = new Data();
                            da.setTemperature(c1[0]);
                            da.setHumidity(c1[1]);
                            sl.ins2(da);
                            System.out.println(da);
                        }
                    }
                }
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }
}
