package com.example.aharalab2017_a.beadsknot;

import android.graphics.Canvas;
import android.graphics.Paint;

/*
 * Created by eripo on 2017/06/20.
 */

class Node {
    double x;
    double y;
    double theta;
    double[] r;//長さ、４つ
    int radius;//円の半径
    double edge_x(int i){
        return x + r[i] * Math.cos(theta+Math.toRadians(i*90));
    }
    double edge_y(int i){
        return y - r[i] * Math.sin(theta+Math.toRadians(i*90));
    }
    double edge_rx(int i, double s){
        return x + s * Math.cos(theta+Math.toRadians(i*90));
    }
    double edge_ry(int i,double s){
        return y - s * Math.sin(theta+Math.toRadians(i*90));
    }
    boolean Joint;
    boolean drawOn;
    Node(double _x, double _y){
        x=_x;
        y=_y;
        theta=0;
        r=new double[4];
        radius=20;
        for(int i=0;i<4;i++) {
            r[i]=5;//線の長さ
        }
        Joint=false;
        drawOn = false;
    }
    double getR(int i){
        if(0<=i && i<4) return r[i];
        else return 0;
    }
    void setR(int i,double rr){
        if(0<=i && i<4) r[i] = rr;
    }
    double getX(){ return x;}
    double getY(){ return y;}
    void draw_Alignment(Canvas c, Paint p, double l, double t, double r, double b){
        double w = r-l;
        double h = b-t;
        double rate;
        if(w>h){
            rate = 1080/w;
        } else {
            rate = 1080/h;
        }
        //ガイドの描画
//        p.setARGB(160, 0, 0, 0);
//        p.setStrokeWidth(5);
//        for(int i=0;i<4;i++) {
//           c.drawLine((float)x, (float)y, (float)edge_x(i), (float)edge_y(i) , p);
//        }
        if(Joint) {
            p.setARGB(255, 255, 0, 0);
        }else{
            p.setARGB(255,0,255,0);
        }
        if(drawOn) {
            p.setStyle(Paint.Style.FILL);
            p.setStrokeWidth(0);
            c.drawCircle((float) ((x - l) * rate), (float) ((y - t) * rate), radius, p);
        }
    }


}
