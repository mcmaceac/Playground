package model;

public class Loan {
	public static final String startPage = "/UI.jspx";
    public static final String resultsPage = "/Result.jspx";
    
    private static final String MONTHLYPAY = "monthlyPayments";
    private static final String GRACEINTEREST = "graceInterest";
	
	public Loan() {
		
	}
	
	public double computePayment(String p, String a, String i, 
			String g, String gp, String fi) throws Exception {
		
		double principal = Double.parseDouble(p);
		double interest = Double.parseDouble(i);
		double period = Double.parseDouble(a);
		double gracePeriod = Double.parseDouble(gp);
		double fixedInterest = Double.parseDouble(fi);
		
		double monthlyInt = computeMonthlyInterest(interest, fixedInterest);
		double monthlyPayments = monthlyInt * principal / (1 - Math.pow(1+monthlyInt, -period));
		
		//error detected, throw exception to the view
		if (principal < 0 || interest < 0 || period < 0) {
			throw new Exception();
		}
		
		double graceInterest = 0.0;
		if (graceEnabled(g)) {
			graceInterest = computeGraceInterest(p, gp, i, fi, g);
			monthlyPayments += (graceInterest / gracePeriod);
		}
		
		return monthlyPayments;
	}
	
	public double computeGraceInterest(String p, String gp, String i, 
			String fi, String g) throws Exception {
		
		double principal = Double.parseDouble(p);
		double interest = Double.parseDouble(i);
		double gracePeriod = Double.parseDouble(gp);
		double fixedInterest = Double.parseDouble(fi);
		
		double graceInterest = 0.0;
		if (graceEnabled(g)) {
			graceInterest = principal * computeMonthlyInterest(interest, fixedInterest) * gracePeriod;
		}
		
		return graceInterest;
	}
	
	//computes the monthly interest rate based on fixed and regular interest rates
	private double computeMonthlyInterest(double i, double fi) {
		return ((fi + i) / 12.0) * .01;
	}
	
	//checks if the value of the checkbox is null (unchecked) or not (checked)
	private boolean graceEnabled(String g) {
		if (g == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
