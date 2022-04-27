public class IRA
{
    private int startYear;
    private int startAge;
    private int numYearsUntilRetirement;
    private double inflationRate;
    private double currentBalance;
    private double monthlyContribution;
    private double APR;
    private double[] valueEachYear;
    public IRA()
    {
        startYear = 2022;
        startAge = 30;
        inflationRate = 0.03;
        currentBalance = 0.0;
        monthlyContribution = 500;
        this.APR = .08;
    }
    public IRA(int myStartYear, int myStartAge, double inflationRate, double mycurrentBalance, double contribution)
    {
        startYear = myStartYear;
        startAge = myStartAge;
        this.inflationRate = inflationRate;
        currentBalance = mycurrentBalance;
        monthlyContribution = contribution;
    }
    public void setMyMonthlyContribution(double contribution)
    {
        monthlyContribution = contribution;
    }
    public void setAnnualInterestRate(double APR)
    {
        this.APR = APR;
    }
    public double howMuchAtEndOfYear(int whichYear)
    {
        return this.valueEachYear[whichYear];
    }
     public void setValueOverTime(int numYears)
    {
    	this.valueEachYear = new double[numYears];
    	this.numYearsUntilRetirement = numYears;
    	this.valueEachYear[0]=currentBalance;
    	for(int i = 1; i < numYears; i++)
    		this.valueEachYear[i] = ((valueEachYear[i-1]+(monthlyContribution*12))*(APR+1));
    }
    public String retirementAge()
    {
        return "You will be " + (startAge + numYearsUntilRetirement) + ". And retire in " + (startYear + numYearsUntilRetirement);
    }
    //need get methods to allow for the financials to add all together?
}