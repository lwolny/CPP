public class Pension
{
    private int retirementAge;
    private int yearsOfService;
    private double highestSalary;
    private double[] ageFactorTable = {0.0116,0.0128,0.014,0.0152,0.0164,0.0176,0.0188,0.02,0.0213,0.0227,0.024};
    private double ageFactor;
    public Pension()
    {
        retirementAge = 62;
        yearsOfService = 20;
        highestSalary = 100000;
        int index = retirementAge - 55;
        if(index > 10)
        index = 10;
        ageFactor = ageFactorTable[retirementAge - 55];
    }
    public Pension(int myRetirementAge, int myYearsOfService, double HighestSalary)
    {
        retirementAge = myRetirementAge;
        yearsOfService = myYearsOfService;
        this.highestSalary = HighestSalary;
        int index = retirementAge - 55;
        if(index > 10)
        index = 10;
        ageFactor = ageFactorTable[index];
    }
    public void setMyYearlySalary(double salary)
    {
        highestSalary = salary;
    }
    public void setMyRetirementAge(int myRetirementAge)
    {
        retirementAge = myRetirementAge;
        int index = retirementAge - 55;
        if(index > 10)
        index = 10;
        ageFactor = ageFactorTable[index];
    }
    public void setMyYearsOfService(int myYearsOfService)
    {
         yearsOfService = myYearsOfService;
    }
    public double monthlyRetirementValue()
    {
        return ageFactor*yearsOfService*(highestSalary/12);
    }
    
}
