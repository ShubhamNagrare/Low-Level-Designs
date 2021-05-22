package com.lld.SnakesAndLadder.Models;
import java.util.Random;

public class Dice {
	
	private int minValue;
	private int maxValue;
	private int currentValue;
	
	public Dice(int min, int max, int curr) {
		this.minValue = min;
		this.maxValue = max;
		this.currentValue = curr;
	}
	
	public int roll() {
		Random random = new Random();
		return random.nextInt(maxValue) + 1;
	}

	
	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}


}
