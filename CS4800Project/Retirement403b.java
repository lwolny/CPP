public class Retirement403b
{
    private int startYear;
    private int startAge;
    private double inflationRate;
    private double currentBalance;
    private double monthlyContribution;
    private double APR;
    
    public Retirement403b()
    {
        startYear = 2022;
        startAge = 30;
        inflationRate = 0.03;
        currentBalance = 0.0;
    }
    public Retirement403b(int myStartYear, int myStartAge, double inflationRate, double mycurrentBalance)
    {
        startYear = myStartYear;
        startAge = myStartAge;
        this.inflationRate = inflationRate;
        currentBalance = mycurrentBalance;
    }
    public void setMyMonthlyContribution(double contribution)
    {
        monthlyContribution = contribution;
    }
    public void setAnnualInterestRate(double APR)
    {
        this.APR = APR;
    }
    public double totalAtRetirement(int numYears)
    {
        double total = 0;
        for(int i = 0; i < numYears; i++)
        {
            currentBalance = ((currentBalance+(monthlyContribution*12))*(APR+1));
        }
        return currentBalance;
    }
    
}
