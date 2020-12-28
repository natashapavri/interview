package google;

public class EmployeeCost {

	public static void main(String[] args) {
		int[] employees = {10, 15, 5, 20, 10};
		int hirecost = 1000;
		int salary = 15000;
		int severance = 5000;
		
		int minCost = Integer.MAX_VALUE;
		int prevEmployees = 0;
		int totalCost = 0;
		
		for(int i = 0; i < employees.length; i++) {
			if(prevEmployees == employees[i]) {
				totalCost = totalCost + (employees[i] * salary);
			} else if(prevEmployees < employees[i]) {
				int hireEmployees = employees[i] - prevEmployees;
				totalCost = totalCost + (hireEmployees * hirecost);
				totalCost = totalCost + (employees[i] * salary);
			} else {
				int fireEmployees = prevEmployees - employees[i];
				totalCost = totalCost + (fireEmployees * severance);
				totalCost = totalCost + (employees[i] * salary);
			}
			minCost = Math.min(totalCost, minCost);
		}
		
		System.out.println(minCost);
	}
}
