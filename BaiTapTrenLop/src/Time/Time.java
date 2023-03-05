package Time;

import java.util.Date;
import java.util.Observable;

public class Time extends Observable {
	private int hour, second, minute;

	public Time(Date now){
		hour = now.getHours();
		second = now.getSeconds();
		minute = now.getMinutes();
	}

	public void changeTime() {
		this.setChanged();
		this.notifyObservers();
	}

	public void countingTime() throws InterruptedException {
		if (second == 59) {
			second = -1;
			minute++;
		}

		if (minute == 60) {
			minute = 0;
			hour++;
		}

		if (hour == 24) {
			hour = 0;
		}
		second++;
		changeTime();
		Thread.sleep(1000);
	}

	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}

	public static void main(String[] args) throws InterruptedException {
		Time time = new Time(new Date());

		time.countingTime();
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void run() throws InterruptedException {
		while(true) {
			this.countingTime();
		}
	}
}
