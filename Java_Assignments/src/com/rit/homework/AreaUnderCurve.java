package com.rit.homework;

import java.util.ArrayList;
import java.util.List;

class ComputeArea extends Thread{
	private double x;
	private double y;
	private double area;
	
	ComputeArea(double a, double b){
		x = a;
		y = b;
	}
	
	@Override
	public void run() {
		setArea(this.getHeightofCurve() * 
				AreaUnderCurve.deltaX * AreaUnderCurve.deltaY);
	}
	
	public double getHeightofCurve(){
		return x*x+y+y;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
}

public class AreaUnderCurve{
	
	static double deltaX = 0.1;
	static double deltaY = 0.1;

	public static void main(String[] args) {
		double orangeArea = -1.0;
		double greenArea = 0.0;
		
		while(Math.abs(orangeArea-greenArea)>0.01){
			double sum = 0.0;
			List<ComputeArea> list = new ArrayList<ComputeArea>();
			for(double x=-1;x<=1;x+=deltaX)
				for(double y=-2;y<=2;y+=deltaY){
					ComputeArea c = new ComputeArea(x, y);
					list.add(c);
					c.start();
			}
			
			for(ComputeArea c:list){
				try {
					c.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for(ComputeArea c:list){
				sum += c.getArea();
			}
			
			orangeArea = greenArea;
			greenArea = sum;
			deltaX = deltaX - 0.0008;
			deltaY = deltaY - 0.0008;
			System.out.println(Math.abs(orangeArea-greenArea));
		}
		
		System.out.println("area under the curve is :"+ greenArea);
	}
}
