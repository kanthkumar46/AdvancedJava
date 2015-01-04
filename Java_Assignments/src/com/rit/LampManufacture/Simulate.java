package com.rit.LampManufacture;

import java.util.ArrayList;
import java.util.List;

class ScrewProducer extends Thread{
	static List<Object> screws = new ArrayList<>();
	
	@Override
	public void run() {
		try {
			while(true){
				sleep(2000);
				WareHouse.setScrews();
			}
		} catch (Exception e) {
			System.out.println("Interrupted :"+e.getMessage());
		}
	}
}

class BaseProducer extends Thread{
	static List<Object> bases = new ArrayList<>();
	
	@Override
	public void run() {
		try {
			while(true){
				sleep(2000);
				WareHouse.setBases();
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted :"+e.getMessage());
		}
	}
}

class StandProducer extends Thread{
	static List<Object> stands = new ArrayList<>();
	
	@Override
	public void run() {
		try {
			while(true){
				sleep(2000);
				WareHouse.setStands();
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted :"+e.getMessage());
		}
	}
}

class SocketProducer extends Thread{
	static List<Object> sockets = new ArrayList<>();
	
	@Override
	public void run() {
		try {
			while(true){
				sleep(2000);
				WareHouse.setSockets();
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted :"+e.getMessage());
		}
	}
}

class BulbProducer extends Thread{
	static List<Object> bulbs = new ArrayList<>();
	
	@Override
	public void run() {
		try {
			while(true){
				sleep(2000);
				WareHouse.setBulbs();
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted :"+e.getMessage());
		}
	}
}

class ConsumerOne extends Thread{
	@Override
	public void run() {
		while(true){
			WareHouse.getScrews();
			WareHouse.getBase();
			WareHouse.getStand();
			WareHouse.getSockets();
			WareHouse.getBulbs();
			System.out.println("Lamp is Built");
		}
	}
}

class WareHouse{
	static Object swrewObject = new Object();
	static Object baseObject = new Object();
	static Object standObject = new Object();
	static Object socketObject = new Object();
	static Object bulbObject = new Object();
	static private int MAXSIZE = 15;
	
	public static void setScrews(){
		synchronized (swrewObject) {
			try {
				if(ScrewProducer.screws.size()<=MAXSIZE-4){
					swrewObject.notifyAll();
					for(int i=0; i<4; i++)
						ScrewProducer.screws.add("screw");
				} 
				else{
					System.out.println("Screw producer waiting...!!!");
					swrewObject.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void getScrews(){
		synchronized (swrewObject) {
			try {
				if(ScrewProducer.screws.size()>=4){
					swrewObject.notify();
					for(int i=0; i<4; i++)
						ScrewProducer.screws.remove("screw");
				}
				else{
					System.out.println("consumer waiting for screws...!!!");
					swrewObject.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setBases(){
		synchronized (baseObject) {
			try {
				if(BaseProducer.bases.size()<=MAXSIZE-2){
					baseObject.notifyAll();
					for(int i=0; i<2; i++)
						BaseProducer.bases.add("base");
				} 
				else{
					System.out.println("Base producer waiting...!!!");
					baseObject.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void getBase(){
		synchronized (baseObject) {
			try {
				if(BaseProducer.bases.size()>=1){
					baseObject.notify();
					BaseProducer.bases.remove("base");
				}
				else{
					System.out.println("consumer waiting for bases...!!!");
					baseObject.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setStands(){
		synchronized (standObject) {
			try {
				if(StandProducer.stands.size()<=MAXSIZE-4){
					standObject.notifyAll();
					for(int i=0; i<4; i++)
						StandProducer.stands.add("stand");
				} 
				else{
					System.out.println("Stand producer waiting...!!!");
					standObject.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void getStand(){
		synchronized (standObject) {
			try {
				if(StandProducer.stands.size()>=1){
					standObject.notify();
					StandProducer.stands.remove("stand");
				}
				else{
					System.out.println("consumer waiting for stands...!!!");
					standObject.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setSockets(){
		synchronized (socketObject) {
			try {
				if(SocketProducer.sockets.size()<=MAXSIZE-7){
					socketObject.notifyAll();
					for(int i=0; i<4; i++)
						SocketProducer.sockets.add("socket");
				} 
				else{
					System.out.println("Socket producer waiting...!!!");
					socketObject.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void getSockets(){
		synchronized (socketObject) {
			try {
				if(SocketProducer.sockets.size()>=3){
					socketObject.notify();
					for(int i=0; i<3; i++)
						SocketProducer.sockets.remove("socket");
				}
				else{
					System.out.println("consumer waiting for sockets...!!!");
					socketObject.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setBulbs(){
		synchronized (bulbObject) {
			try {
				if(BulbProducer.bulbs.size()<=MAXSIZE-4){
					bulbObject.notifyAll();
					for(int i=0; i<4; i++)
						BulbProducer.bulbs.add("bulb");
				} 
				else{
					System.out.println("Bulb producer waiting...!!!");
					bulbObject.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void getBulbs(){
		synchronized (bulbObject) {
			try {
				if(BulbProducer.bulbs.size()>=3){
					bulbObject.notify();
					for(int i=0; i<3; i++)
						BulbProducer.bulbs.remove("bulb");
				}
				else{
					System.out.println("consumer waiting for bulbs...!!!");
					bulbObject.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Simulate {
	public static void main(String[] args) {
		ScrewProducer screwproducer = new ScrewProducer();
		BaseProducer baseproducer = new BaseProducer();
		StandProducer standproducer = new StandProducer();
		SocketProducer socketproducer = new SocketProducer();
		BulbProducer bulbproducer = new BulbProducer();
		ConsumerOne c1 = new ConsumerOne();
		ConsumerOne c2 = new ConsumerOne();
		
		screwproducer.start();
		baseproducer.start();
		standproducer.start();
		socketproducer.start();
		bulbproducer.start();
		c1.start();
		c2.start();
	}
}
