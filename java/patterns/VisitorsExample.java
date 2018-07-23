package org.rap.prgtests.patterns;

// Just an employee base class
abstract class Employee {
	public abstract void accept(EmployeeVisitor v);
}
// An hourly employee
class HourlyEmployee extends Employee {
	int baseSalary=0;
	int baseHours=0;
	int totalEarned=0;
	//Constructor: this guys win 10/hour, has worked 18 days, nine hours a day
	public HourlyEmployee(){ this.baseSalary=10; this.baseHours=9*18; } 
	public void accept(EmployeeVisitor v) {
		v.visit(this); // this is the visited class: an external method runs with me.
	}
}

// A salaried employee
class SalariedEmployee extends Employee {
	int baseSalary=0;
	int totalEarned=0;
	//Constructor: this guys just wins 1500/month
	public SalariedEmployee(){ this.baseSalary=1500; }
	public void accept(EmployeeVisitor v) {
		// This is the visit pattern: each object accepts visits with (this)
		v.visit(this); // this is the visited class: an external method runs with me.
	}
}

// Here begins the fun
public class VisitorsExample { /* MAIN ------------ */
	public static void main(String[] args) {
		Employee e1 = new HourlyEmployee();
		Employee e2 = new SalariedEmployee();
		
		//HERE is the meollo: We create a visitor
		PayReportVisit v = new PayReportVisit();
		//and visit each object (a foreach is enough)
		e1.accept(v);
		e2.accept(v);
	}
} /* MAIN END ------------------------------------- */

interface EmployeeVisitor {
	// The visitor behaves different whether he receives an HE or an SE 
	public void visit(HourlyEmployee he);
	public void visit(SalariedEmployee se);
}

// This is the visitor
class PayReportVisit implements EmployeeVisitor {
	// And we just implement the visit styles
	public void visit(HourlyEmployee he) {
		System.err.println("Hourly Employee Report; Base/Hour="+he.baseSalary+"; Hours="+he.baseHours+"; TotalEarned="+(he.baseSalary*7.5*21));
	}
	public void visit(SalariedEmployee se) {
		System.err.println("Salary Employee Report; Base/Month="+se.baseSalary+"; TotalEarned="+se.baseSalary);
	} // do nothing
}
