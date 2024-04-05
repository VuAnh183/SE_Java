package a1_22BI13012;

import utils.DomainConstraint;

/**
 * @overview
 * Represent people who studied at the university
 * @attributes
 * id			Integer			int
 * name			String			string
 * phoneNumber	String		 	string
 * address		String			string
 * @object A typical Person is c=<d, n>, where id(d), name(n).
 * @abstract_properties 
 * mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\ max(id) = 10^9
 * mutable(name) = true /\ optional(name) = false /\ length(name) = 50 
 * mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = 10
 * mutable(address) = true /\ optional(address) = false /\ length(address) = 100 
*/
public class Student implements Comparable<Student> {
	@DomainConstraint(mutable = false, optional = false, min = 1, max = 10^9)
	private int id;
	
	@DomainConstraint(mutable = true, optional = false, length = 50)
	private String name;
	
	@DomainConstraint(mutable = true, optional = false, length = 10)
	private String phoneNumber;
	
	@DomainConstraint(mutable = true, optional = false, length = 100)
	private String address;

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
