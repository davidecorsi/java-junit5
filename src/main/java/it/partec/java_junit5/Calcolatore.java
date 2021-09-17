package it.partec.java_junit5;

public class Calcolatore {
	
	private int result = 0;
	
	public int add(int a, int b) {
		result = result + (a + b);
		return result;
	}
	
	public int sub(int a, int b) {
		result = result + (a - b);
		return result;
	}
	
	public int mul(int a, int b) {
		result = result + (a * b);
		return result;
	}
	
	public int div(int a, int b) {
		result = result + (a / b);
		return result;
	}
	
	public void canc() {
		result = 0;
	}
	
	public boolean checkResult0() {
		return result == 0;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
