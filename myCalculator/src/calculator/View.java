package calculator;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class View extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private boolean isFirstValue = true;
	private String[] symbol = { "%", "?", "^2", "1/x", "CE", "C", "DEL", "/", "7", "8", "9", "x", "4", "5", "6", "-",
			"1", "2", "3", "+", "-/+", "0", ".", "=" };
	private final int NUM_OF_BUTTONS = 24;
	private final String regXNumber = "\\d";
	private final String regXMathSymbols = "(\\^2)?%?(CE)?C?(DEL)?(%)?(\\-\\/\\+)?(1/x)?";
	private JButton[] btn = new JButton[NUM_OF_BUTTONS];
	private JTextArea textField = new JTextArea("");
	private Listener lis = new Listener();
	private JPanel btnPanel = new JPanel();
	private Font font = new Font("Ariel", Font.PLAIN, 58);
	private Font btnFont = new Font("Ariel", Font.PLAIN, 42);
	private CalculatorOperation calculationValues;
	private CalculatorListener listener;
	private Integer equelPositionInSymbolsArr = symbol.length - 2;

	public View() {
		addButtonsToPanel();
		intializeFrame();
		calculationValues = new CalculatorOperation();
	}

	private void addButtonsToPanel() {
		try {
			btnPanel.setLayout(new GridLayout(6, 4, 5, 5));
			for (int i = 0; i < NUM_OF_BUTTONS; i++) {
				btn[i] = new JButton(symbol[i]);
				btn[i].setFont(btnFont);
				btn[i].addActionListener(lis);
				btnPanel.add(btn[i]);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.toString());
			System.exit(1);
		}
	}

	private void intializeFrame() {
		setSize(600, 500);
		textField.setFont(font);
		setLayout(new BorderLayout());
		add(btnPanel, BorderLayout.CENTER);
		add(textField, BorderLayout.NORTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setCalculatorListener(CalculatorListener lis) {
		listener = lis;
	}

	private class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String btnContent = e.getActionCommand();
				if (btnContent.matches(regXNumber))
					textField.append(btnContent);
				else if (btnContent == ".") {
					textField.append(btnContent);
					btn[equelPositionInSymbolsArr].removeActionListener(lis);
				} else if (!btnContent.matches(regXMathSymbols)) {
					btn[equelPositionInSymbolsArr].addActionListener(lis);
					if (isFirstValue) {
						calculationValues.setFirstValue(Double.parseDouble(textField.getText()));
						textField.setText("");
						isFirstValue = false;
						calculationValues.setOperationType(btnContent);
					} else {
						if (btnContent != "=")
							calculationValues.setContinusOperation(btnContent);
						calculationValues.setSecondValue(Double.parseDouble(textField.getText()));
						listener.CalculatorEvent(calculationValues);
					}
				} else {
					System.out.println("here");
					if (btnContent == "C") {
						restart();
					} else if (btnContent == "CE")
						;
					else if (btnContent == "^2")
						calculatePowerOfTwo(btnContent);
					else if (btnContent == "%")
						divideByPercentageX();
					else if (btnContent == "-/+")
						switchValueSign();
					else if (btnContent == "1/x")
						switchFreqtion();
				}
			} catch (NumberFormatException ex) {
				System.out.println("bad \n" + ex);
				restart();
			}
		}

		private void switchFreqtion() {
			try {
				Double x = 1.0;
				calculationValues.setFirstValue(x);
				calculationValues.setSecondValue(Double.parseDouble(textField.getText()));
				calculationValues.setOperationType("/");
				calculationValues.setContinusOperation(null);
				listener.CalculatorEvent(calculationValues);
			} catch (Error e) {
			}

		}

		private void switchValueSign() {
			try {
				int x = -1;
				calculationValues.setFirstValue(Double.parseDouble(textField.getText()));
				calculationValues.setSecondValue(x);
				calculationValues.setOperationType("x");
				calculationValues.setContinusOperation(null);
				listener.CalculatorEvent(calculationValues);
			} catch (Error e) {
			}
		}

		private void divideByPercentageX() {
			try {
				int x = 100;
				calculationValues.setFirstValue(Double.parseDouble(textField.getText()));
				calculationValues.setSecondValue(x);
				calculationValues.setOperationType("/");
				calculationValues.setContinusOperation(null);
				listener.CalculatorEvent(calculationValues);
			} catch (Error e) {
			}
		}

	}

	private void calculatePowerOfTwo(String value) {
		try {
			calculationValues.setFirstValue(Double.parseDouble(textField.getText()));
			calculationValues.setSecondValue(Double.parseDouble(textField.getText()));
			calculationValues.setOperationType("x");
			listener.CalculatorEvent(calculationValues);
		} catch (Error e) {
		}

	}

	private void restart() {
		textField.setText("");
		calculationValues = new CalculatorOperation();
		isFirstValue = true;
		btn[equelPositionInSymbolsArr].addActionListener(lis);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	public void setResult(double res) {
		calculationValues = new CalculatorOperation();
		calculationValues.setFirstValue(res);
		textField.setText(String.valueOf(res));
		isFirstValue = true;
	}

	public void setResult(double res, String op) {
		calculationValues = new CalculatorOperation(res, op);
		textField.setText(String.valueOf(res));
		isFirstValue = false;
	}

}
