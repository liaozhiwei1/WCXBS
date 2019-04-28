package com.wcx.pojo;

import java.util.Objects;

public class Data implements java.io.Serializable{
	private String temperature;		//温度
	private String time;	//时间
	private String humidity;		//压力

	public Data() {
	}

	public Data(String temperature, String time, String humidity) {
		this.temperature = temperature;
		this.time = time;
		this.humidity = humidity;
	}

    @Override
    public String toString() {
        return "Data{" +
                "temperature='" + temperature + '\'' +
                ", time='" + time + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }

    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Data data = (Data) o;
		return Objects.equals(temperature, data.temperature) &&
				Objects.equals(time, data.time) &&
				Objects.equals(humidity, data.humidity);
	}

	@Override
	public int hashCode() {

		return Objects.hash(temperature, time, humidity);
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
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
}