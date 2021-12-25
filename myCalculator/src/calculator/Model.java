package calculator;

public class Model {
	private String action;
	private Double num1;
	private Double num2;

	Model(Double num1, Double num2, String action) {
		this.num1 = num1;
		this.num2 = num2;
		this.action = action;
	}

	public double getCalculationResult() {
		String var1;
		switch ((var1 = this.action).hashCode()) {
		case 43:
			if (var1.equals("+")) {
				return this.num1 + this.num2;
			}
			break;
		case 45:
			if (var1.equals("-")) {
				return this.num1 - this.num2;
			}
			break;
		case 47:
			if (var1.equals("/")) {
				return this.num1 / this.num2;
			}
			break;
		case 61:
			if (var1.equals("=")) {
				return this.num1;
			}
			break;
		case 120:
			if (var1.equals("x")) {
				return this.num1 * this.num2;
			}
		}

		return 2.0D;
	}
}
