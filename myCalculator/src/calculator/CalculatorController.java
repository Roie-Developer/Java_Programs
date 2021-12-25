package calculator;

public class CalculatorController {

	private Model model;
	private View view = new View();

	public CalculatorController() {
		view.setCalculatorListener(new CalculatorListener() {
			@Override
			public void CalculatorEvent(CalculatorOperation toCalc) {
				Double num1 = toCalc.getFirstValue();
				Double num2 = toCalc.getSecondValue();
				String opType = toCalc.getOperationType();
				String continusOperation = toCalc.getContinusOperation();
				model = new Model(num1, num2, opType);
				Double res = model.getCalculationResult();
				if (continusOperation != null) {
					view.setResult(res, continusOperation);
				} else
					view.setResult(res);
			}
		});
	}

}
