package org.deb.hierarchy;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrganizationHierarchyTest {

	private static OrganizationHierarchy organization;

	private static Employee ceo;
	private static Employee e1 = new Employee("e1");

	private static Employee e2 = new Employee("e2");
	private static Employee e3 = new Employee("e3");
	private static Employee e4 = new Employee("e4");

	private static Employee e5 = new Employee("e5");
	private static Employee e6 = new Employee("e6");

	private static Employee e7 = new Employee("e7");
	private static Employee e8 = new Employee("e8");

	private static Employee e9 = new Employee("e9");
	private static Employee e10 = new Employee("e10");

	@BeforeClass
	public static void initialize() {
		ceo = new Employee("CEO");
		organization = new OrganizationHierarchy(ceo);

		// CEO and subordinates
		ceo.addSubordinate(e1);
		ceo.addSubordinate(e2);
		ceo.addSubordinate(e3);
		ceo.addSubordinate(e4);

		// E1 and subordinates
		e1.addSubordinate(e5);
		e1.addSubordinate(e6);

		// E6 and subordinates
		e6.addSubordinate(e7);
		e6.addSubordinate(e8);

		// E2 and subordinates
		e2.addSubordinate(e9);
		e2.addSubordinate(e10);

	}

	@Test
	public void testGetLowestCommonAncesstor() {
		Assert.assertEquals(ceo, organization.getLowestCommonAncesstor(ceo, e1, e2));
		Employee commonBoss = organization.getLowestCommonAncesstor(ceo, e9, e10);
		Assert.assertEquals("e2", commonBoss.getEnmae());
		
		Assert.assertEquals(ceo,organization.getLowestCommonAncesstor(ceo, e7, e9));
	}

}
