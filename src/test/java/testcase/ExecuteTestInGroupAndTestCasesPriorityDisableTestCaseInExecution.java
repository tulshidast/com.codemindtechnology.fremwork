package testcase;

import org.testng.annotations.Test;

public class ExecuteTestInGroupAndTestCasesPriorityDisableTestCaseInExecution {

	// setting priority, enabled test case for execution and assigned group is
	// group1
	@Test(priority = 0, enabled = true, groups = { "group1" })
	public void first() {
		System.out.println("first executed");

	}

	@Test(priority = 1, groups = { "group1" })
	public void second() {
		System.out.println("second executed");
	}

	@Test(priority = 2, groups = { "group1" })
	public void third() {
		System.out.println("third executed");
	}

	@Test(priority = 3, groups = { "group2" })
	public void fourth() {
		System.out.println("fourth executed");
	}

	@Test(priority = 0, groups = { "group2" })
	public void fifth() {
		System.out.println("fifth executed");
	}

}
