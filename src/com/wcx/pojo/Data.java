package com.wcx.pojo;

public class Data implements java.io.Serializable{
	private String temperature;		//温度
	private String nextTemperature;
	private String time;	//时间
	private String humidity;		//压力
	private String nextHumidity ;
	@Override
	public String toString() {
		return "Data [temperature=" + temperature + ", nextTemperature=" + nextTemperature + ", time=" + time
				+ ", humidity=" + humidity + ", nextHumidity=" + nextHumidity + "]";
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getNextTemperature() {
		return nextTemperature;
	}
	public void setNextTemperature(String nextTemperature) {
		this.nextTemperature = nextTemperature;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getNextHumidity() {
		return nextHumidity;
	}
	public void setNextHumidity(String nextHumidity) {
		this.nextHumidity = nextHumidity;
	}
	public Data(String temperature, String nextTemperature, String time, String humidity, String nextHumidity) {
		super();
		this.temperature = temperature;
		this.nextTemperature = nextTemperature;
		this.time = time;
		this.humidity = humidity;
		this.nextHumidity = nextHumidity;
	}
	public Data() {
		super();
	}
	
}