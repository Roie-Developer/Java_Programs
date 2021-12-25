package calculator;

public class CalculatorOperation {

	private String continusOperation;
	private String operationType;
	private double firstValue;
	private double secondValue;

	public CalculatorOperation() {
		firstValue = 0;
		secondValue = 0;
		operationType = null;
		continusOperation = null;
	}

	public CalculatorOperation(Double FirstVal, String op) {
		this.firstValue = FirstVal;
		this.operationType = op;
		continusOperation = null;
	}

	/**
	 * @return the seconedValue
	 */
	public double getSecondValue() {
		return secondValue;
	}

	/**
	 * @param seconedValue the seconedValue to set
	 */
	public void setSecondValue(double seconedValue) {
		this.secondValue = seconedValue;
	}

	/**
	 * @return the firstValue
	 */
	public double getFirstValue() {
		return firstValue;
	}

	/**
	 * @param firstValue the firstValue to set
	 */
	public void setFirstValue(double firstValue) {
		this.firstValue = firstValue;
	}

	/**
	 * @return the operationType
	 */
	public String getOperationType() {
		return operationType;
	}

	/**
	 * @param operationType the operationType to set
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	/**
	 * @return the continusOperation
	 */
	public String getContinusOperation() {
		return continusOperation;
	}

	/**
	 * @param continusOperation the continusOperation to set
	 */
	public void setContinusOperation(String continusOperation) {
		this.continusOperation = continusOperation;
	}

}
