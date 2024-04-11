package Tutor3.ex2;

import utils.*;

/**
 * @overview Person represents someone join into the seminar
 * @attributes
 * id     Integer       int
 * name   String        string
 * phone  MobilePhone   
 * @objects a typical Person object is p=<i, n>, where id(i), name(n)
 * @abstract_properties
 * mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\
 * mutable(name) = true /\ optional(name) = false /\ length(name) = 30 /\
 * mutable(phone) = true /\ optional(phone) = true /\
 */ 
public class Person implements Comparable<Person>{
	// state space - attributes
	@DomainConstraint(mutable = false, optional = false, min = 1)
	private int id;
	
	@DomainConstraint(mutable = true, optional = false, length = 30)
	private String name;
	
	@DomainConstraint(mutable = true, optional = true)
	private MobilePhone phone;
	
	// behavior space - methods 
	// public return type methodName(param_type paramName, param_type2 paramName2, ...) {...}
	// constructor - atts optional = false -> params 
	/*
	 * @modifies this.id, this.name 		
	 * @effects <pre>
	 * if id, name are valid
	 * 		initialize this as <id, name>
	 * else
	 * 		throw NotPossibleException	
	 * </pre>
	 */
	public Person(
			@AttrRef("id") int id,
			@AttrRef("name") String name
			) throws NotPossibleException {
		//TODO: check if id, name are valid
		if(!validateId(id)) {
			throw new NotPossibleException("Invalid id!");
		}
		
		if(!validateName(name)) {
			throw new NotPossibleException("Invalid name!");
		}
		
		
		this.id = id;
		this.name = name;

	} 
	// getters - foreach attr -> getter
	/*
	 * @effect return this.id
	 */
	@DOpt(type = OptType.Observer) @ AttrRef("id")
	public int getId() {
		return this.id;
	}
	
	/*
	 * @effect return this.name
	 */
	@DOpt(type = OptType.Observer) @ AttrRef("name")
	public String getName() {
		return this.name;
	}
	
	/*
	 * @effect return this.phone
	 */
	@DOpt(type = OptType.Observer) @ AttrRef("phone")
	public MobilePhone getPhone() {
		return this.phone;
	}
	
	// mutator - setters: mutable = true -> setter 
	/*
	 * @effects <pre>
	 * if newName is valid 
	 * 		set this.name = newName
	 * 		return true
	 * else 
	 * 		return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("name")
	public boolean setName(String newName) {
		if (validateName(newName)) {
			this.name = newName;
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * @effects <pre>
	 * if newPhone is valid 
	 * 		set this.phone = newPhone
	 * 		return true
	 * else 
	 * 		return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("phone")
	public boolean setPhone(MobilePhone newPhone) {
		if (validatePhone(newPhone)) {
			this.phone = newPhone;
			return true;
		} else {
			return false;
		}
	}
	
	// helper - validators 
	/*
	 * @effects <pre>
	 * if id is valid
	 * 		return true
	 * else 
	 * 		return false 
	 * </pre>
	 * 
	 */
	public boolean validateId(int id) {
		
		// min
		if (id < 1) {
			return false;
		}
		return true;
	}
	
	/*
	 * @effects <pre>
	 * if name is valid
	 * 		return true
	 * else 
	 * 		return false 
	 * </pre>
	 * 
	 */
	public boolean validateName(String name) {
		
		// optional 
		if (name == null) {
			return false;
		}
		
		if (name.length() == 0) {
			return false;
		}
		
		// max length
		if (name.length() > 30) {
			return false;
		}
		return true;
	}
		/*
		 * @effects <pre>
		 * if phone is valid
		 * 		return true
		 * else 
		 * 		return false 
		 * </pre>
		 * 
		 */
		public boolean validatePhone(MobilePhone phone) {
			
			// optional = true
			if (phone != null) {
				if (!phone.repOK()) {
					return false;
				}
			}
			
			return true;
	}
		
	// repOK
	/*
	 * @effects <pre>
	 * if this satisfies abastract properties
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	public boolean repOK() {
		if (validateId(this.id) && validateName(this.name) && validatePhone(this.phone)) {
			return true;
		} else {
			return false;
		}
	}
	
	// toString 
	public String toString() {
		return "Person <id="+this.id+", name="+this.name+", phone="+this.phone+">";
	}
	
	@Override
	public int compareTo(Person p) {
		// TODO Auto-generated method stub
		// < return -1
		// = return 0 
		// > return 1
		
//		if (this.id <p.id) {
//			return -1;
//		} else if (this.id == p.id) {
//			return 0;
//		} else {
//			return 1;
//		}
		
		return this.name.compareTo(p.name);
	}
}
