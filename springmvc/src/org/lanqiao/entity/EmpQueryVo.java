package org.lanqiao.entity;

public class EmpQueryVo {

	private Employee emp;

	private String deptName;

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "EmpQueryVo [emp=" + emp + ", deptName=" + deptName + "]";
	}

}
