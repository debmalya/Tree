package org.deb.hierarchy;

import java.util.ArrayList;
import java.util.List;



public class Employee {
	
	private String enmae;
	private List<Employee> subordinates = new ArrayList<Employee>();
	
	
	public List<Employee> getSubordinates() {
		return subordinates;
	}

	/**
	 * This needs to be improved.
	 * TODO: Employee should not have details of boss.
	 * 
	 * Through this employee can get access to all private information of other employees.
	 */
	private Employee boss;
	
	/**
	 * Constructor create employee with passed name.
	 * @param enmae
	 */
	public Employee(String enmae) {
		super();
		this.setEnmae(enmae);
	}

	public Employee getBoss() {
		return boss;
	}

	public void setBoss(Employee boss) {
		this.boss = boss;
	}
	
	public void addSubordinate(Employee employee){
		if (!subordinates.contains(employee)) {
			subordinates.add(employee);
			employee.setBoss(this);
		}
	}

	public String getEnmae() {
		return enmae;
	}

	public void setEnmae(String enmae) {
		this.enmae = enmae;
	}

}
