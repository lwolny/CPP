/*
 *This class should be called via the html doc. 
 *Each value should have a button that allows for the user to set new values.
 *Each value will be held until all boxes have been entered. 
 *At the end, the IRA class will be called so the user can assign values.
 *The IRA class will then have methods to calculate each yearly value and give 
 *    a range of values based upon passed time.
 *
 */
public class Main   
{
    private IRA myIRA;
    private Pension myPension;
    private Retirement403b my403b;
    private int year;
    private int age;
    private int numYearsUntilRetirement;
    private double inflationRate;
    private double currentBalance;
    private double monthlyContribution;
    private double apr;
    private double[] valueEachYear;
    //After all are set, allow the user to click on a button to figure out IRA or 403b
    public Main()
    {
       
    }
    public void setAge(int inputAge)
    {
        age = inputAge;
    }
    public void setYear(int inputYear)
    {
        year = inputYear;
    }
    public void setYearsToRetirement(int time)
    {
        numYearsUntilRetirement = time;
    }
    public void setExpectedAPR(double apr)
    {
        this.apr = apr;
    }
    public void setStartingBalance(double balance)
    {
        this.currentBalance = balance;
    }
    public void setMonthlyContribution(double contribution)
    {
        this.monthlyContribution = contribution;
    }
    public void setExpectedInflationRate(double inflation)
    {
        inflationRate = inflation;
    }
  
}
