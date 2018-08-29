package com.demo.lambda;

import java.util.function.IntConsumer;

public class Averager implements IntConsumer {

	private int total = 0;
	private int count = 0;
	
	public double average() {
		return count > 0 ? ((double) total)/count : 0; 
	}
	
	@Override
	public void accept(int i) {
		// TODO Auto-generated method stub
		total += i; count ++;
	}
	
	public void combine(Averager other) {
		this.total += other.total;
		this.count += other.count;
	}

}
