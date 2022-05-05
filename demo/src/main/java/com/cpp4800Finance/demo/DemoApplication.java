package com.cpp4800Finance.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(DemoApplication.class, args);
	}

	
	@GetMapping("/calculation") // called from index.html. This code changes the lable associated with the button
	public String calculation(@RequestParam(value = "monthlyValue", defaultValue = "500") double cost,@RequestParam(value = "years", defaultValue = "20") int years,@RequestParam(value = "percent", defaultValue = "8") double percent) 
	{
		double money = 0.0;
//		int years = 20;
//		double percent = .08;
		for(int i = 0; i < years * 12; i++)
		{
			
			money += cost;			
			money *= 1 + (percent*.01/12);
		}
		
		String printMoney =String.format("%,.2f", money);
		
		return String.format("You would have $"+ printMoney + " after " + years + " years");
	}
	@GetMapping("/pension")
	public String pension(@RequestParam(value = "retirementAge", defaultValue = "62") int age,@RequestParam(value = "yearsOfService", defaultValue = "20") double years,@RequestParam(value = "highestSalary", defaultValue = "100000.00") double salary)
	{
		double[] ageFactorTable = {0.0116,0.0128,0.014,0.0152,0.0164,0.0176,0.0188,0.02,0.0213,0.0227,0.024};
		int index = age - 55;
        if(index < 0)
        	return "You're not old enough to retire";
        else if(index > 10)
        	index = 10;
        double ageFactor = ageFactorTable[index];
        double monthlyIncome = ageFactor * years*(salary/12);
        String printMoney =String.format("%,.2f", monthlyIncome);
		return String.format("You would have $"+ printMoney + " every month at " + years + " years of service");
	}
	@GetMapping("/retired")
	public String retired(@RequestParam(value = "valueAtRetirement", defaultValue = "300000") double total,@RequestParam(value = "yearsRetired", defaultValue = "20") double years,@RequestParam(value = "withdrawl", defaultValue = "2000") double perMonthWithdrawl,@RequestParam(value = "percent", defaultValue = "5") double percent)
	{
		double runningTotal = total;
		double increase = 0;
		double totalMonths = years*12;
		double time = 0;
		while(runningTotal > 0 && totalMonths > 0)
		{
			increase = runningTotal * ((percent*.01)/12.0);
			runningTotal += increase;
			runningTotal -= perMonthWithdrawl;
			time++;
			totalMonths--;
			if(runningTotal > total)
			{
				return "You will never run out of money as you're earning more than you're spending. The amount you withdraw per month should increase beyond " + increase;
			}
		}
			if(totalMonths <=0)
			{
				return "You would still have $" + String.format("%,.2f", runningTotal) + " remaining after " + years + " years.\nYou could increase your per month withdrawl or increase your time retired.";
			}
		String totalYears =String.format("%,.2f", time/12.0);

		return String.format("You have enough money for " + totalYears + " years of retirement.");
	}
	
	
	
	
//	@GetMapping("/home") // called from index.html. This code changes the lable associated with the button
//	public String home(@RequestParam(value = "name", defaultValue = "World") String name) 
//	{
//		return String.format("Hello %s! home method", name);
////	}
//	@GetMapping("/hello")
//	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) 
//	{
//		return String.format("Hello %s! hello method", name);
//	}
//	
//	@GetMapping("/IRA") // called from index.html. This code changes the lable associated with the button
//	public int IRA(@RequestParam(value = "age", defaultValue = "30") int age) 
//	{
//		return age-10;
//	}
//	@GetMapping("/onePercent") // called from index.html. This code changes the lable associated with the button
//	public String onePercent() 
//	{
//		double money = 0.0;
//		double monthlyContribution = 500.00;
//		int years = 20;
//		for(int i = 0; i < years * 12; i++)
//		{
//			
//			money += monthlyContribution;
//			money *= 1+(0.01/12);
//			System.out.println(money);
//			
//		}
//		String printMoney =String.format("%.2f", money);
//		
//		return String.format("You would have "+ printMoney + " after 20 years");	
//	}
//	@GetMapping("/twoPercent") // called from index.html. This code changes the lable associated with the button
//	public String twoPercent() 
//	{
//		double money = 0.0;
//		double monthlyContribution = 500.00;
//		int years = 20;
//		for(int i = 0; i < years * 12; i++)
//		{
//			
//			money += monthlyContribution;		
//			money *= 1+(0.02/12);
//			System.out.println(money);
//			
//		}
//		String printMoney =String.format("%.2f", money);
//		
//		return String.format("You would have "+ printMoney + " after 20 years");
//	}
//	@GetMapping("/threePercent") // called from index.html. This code changes the lable associated with the button
//	public String threePercent() 
//	{
//		double money = 0.0;
//		double monthlyContribution = 500.00;
//		int years = 20;
//		for(int i = 0; i < years * 12; i++)
//		{
//			
//			money += monthlyContribution;		
//			money *= 1+(0.03/12);
//			System.out.println(money);
//			
//		}
//		String printMoney =String.format("%.2f", money);
//		
//		return String.format("You would have "+ printMoney + " after 20 years");
//	}
//	@GetMapping("/fourPercent") // called from index.html. This code changes the lable associated with the button
//	public String fourPercent() 
//	{
//		double money = 0.0;
//		double monthlyContribution = 500.00;
//		int years = 20;
//		for(int i = 0; i < years * 12; i++)
//		{
//			
//			money += monthlyContribution;
//			money *= 1+(0.04/12);
//			System.out.println(money);
//			
//		}
//		String printMoney =String.format("%.2f", money);
//		
//		return String.format("You would have "+ printMoney + " after 20 years");
//	}
//	@GetMapping("/fivePercent") // called from index.html. This code changes the lable associated with the button
//	public String fivePercent() 
//	{
//		double money = 0.0;
//		double monthlyContribution = 500.00;
//		int years = 20;
//		for(int i = 0; i < years * 12; i++)
//		{
//			
//			money += monthlyContribution;
//			money *= 1+(0.05/12);
//			System.out.println(money);
//			
//		}
//		String printMoney =String.format("%.2f", money);
//		
//		return String.format("You would have "+ printMoney + " after 20 years");
//	}
//	@GetMapping("/sixPercent") // called from index.html. This code changes the lable associated with the button
//	public String sixPercent() 
//	{
//		double money = 0.0;
//		double monthlyContribution = 500.00;
//		int years = 20;
//		for(int i = 0; i < years * 12; i++)
//		{
//			
//			money += monthlyContribution;
//			money *= 1+(0.06/12);
//			System.out.println(money);
//			
//		}
//		String printMoney =String.format("%.2f", money);
//		
//		return String.format("You would have "+ printMoney + " after 20 years");
//		
//	}
//	@GetMapping("/sevenPercent") // called from index.html. This code changes the lable associated with the button
//	public String sevenPercent() 
//	{
//		double money = 0.0;
//		double monthlyContribution = 500.00;
//		int years = 20;
//		for(int i = 0; i < years * 12; i++)
//		{
//			
//			money += monthlyContribution;
//			money *= 1+(0.07/12);
//			System.out.println(money);
//			
//		}
//		String printMoney =String.format("%.2f", money);
//		
//		return String.format("You would have "+ printMoney + " after 20 years");
//	}
//	@GetMapping("/eightPercent") // called from index.html. This code changes the lable associated with the button
//	public String eightPercent() 
//	{
//		double money = 0.0;
//		double monthlyContribution = 500.00;
//		int years = 20;
//		for(int i = 0; i < years * 12; i++)
//		{
//			
//			money += monthlyContribution;			
//			money *= 1+(0.08/12);
//			System.out.println(money);
//			
//		}
//		String printMoney =String.format("%.2f", money);
//		
//		return String.format("You would have "+ printMoney + " after 20 years");
//	}
//	
	
}
	 