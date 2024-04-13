package a1_22BI13012;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;
import java.lang.Math;

/**
 * @overview PostgradStudent represent someone who has graduate from school
 * @attributes
 * id				Integer		int
 * name				String		string 
 * phoneNumber		String		string
 * address			String		string
 * gpa				Float		float
 * @objects a typical PostgradStudent object is s=<i, n, p, a, g>, where id(i), name(n), phoneNumber(p), address(a), gpa(g)
 * @abstract_properties
 * P_Student.id /\ min(id) = 10^8 + 1 /\ max(id) = 10^9 /\
 * P_Student.name /\
 * P_Student.phoneNumber /\
 * P_Student.address /\
 * mutable(gpa) = true /\ optional(gpa) = false /\ min(gpa) = 0.0 /\ max(gpa) = 4.0 /\
 * 
 * @author VuAnh_183
 * 		https://github.com/VuAnh183/SE_Java
 */
public class PostgradStudent extends Student{
	
	// constants
	private static final int MIN_ID = (int) 10e8 + 1;

	private static final int MAX_ID = (int) 10e9;
	
	// attributes
	@DomainConstraint(mutable = true, optional = false, min = 0.0, max = 4.0)
	private float gpa;
	
	// methods
	// constructor
	/**
	 * @modifies this.id, this.name, this.phoneNumber, this.address
	 * @effects <pre>
	 * if id, name, phoneNumber, address are valid
	 * 		initialize this as (id, name, phoneNumber, address)
	 * else
	 * 		throws new NotPossibleException
	 * </pre>
	 */
	public PostgradStudent(
			@AttrRef("id") int id,
			@AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber,
			@AttrRef("address") String address,
			@AttrRef("gpa") float gpa)
			throws NotPossibleException {
		//TODO: check attributes validation
		super(id, name, phoneNumber, address);
		if(!validateId(id)) {
			throw new NotPossibleException("Invalid id!");
		}
		
		if(!validateGPA(gpa)) {
			throw new NotPossibleException("Invalid GPA");
		}

		this.gpa = gpa;
	}
	
	// getters - observers
	/**
	 * @effect return <tt>gpa</tt>
	 */
	@DOpt(type = OptType.Observer) @AttrRef("gpa")
	public float getGPA() {
		return this.gpa;
	
	}	
	
	//setters - mutators
	/**
	 * @modifies this.gpa
	 * @effects <pre>
	 * if newGPA is valid
	 * 		set this.gpa = newGPA
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("gpa")
	public boolean setGPA(float newGPA) {
		if(validateGPA(newGPA)) {
			this.gpa = newGPA;
			return true;
		} else {
			return false;
		}
	}
	
	// helper - validators
	/**
	 * @effects <pre>
	 * if id is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 * 
	 */
	@Override
	@DomainConstraint(mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
	public boolean validateId(int id) {
		
		//min
		if(id < Math.pow(10, 8) + 1) {
			return false;
		}
		
		//max
		if(id > Math.pow(10, 9)) {
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * @effects <pre>
	 * if gpa is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 * 
	 */
	public boolean validateGPA(float gpa) {
		
		// min
		if(gpa < 0.0) {
			return false;
		}
		
		// max
		if(gpa > 4.0) {
			return false;
		}
		
		return true;
	}
	
	// repOK
	/**
	 * @effects <pre>
	 * if this satisfies abstract properties
	 * 		return true
	 * else 
	 * 		return false
	 * </pre>
	 * 
	 */
	public boolean repOK() {
		return super.repOK() && validateGPA(this.gpa);
	}
	
	// toString
	@DOpt(type = OptType.Default) 
	@Override
	public String toString() {
		String temp = super.toString();
		return "Postgrad" + 
				temp.substring(0, temp.length() - 1)
				+ ", " + gpa + ">";
	}
	
	// equals
	@Override
	public boolean equals(Object student) {
		if (!(student instanceof PostgradStudent)) {
			return false;
		}
		
		int yourID = ((Student) student).getId();
		return yourID == this.getId();
	}
}
