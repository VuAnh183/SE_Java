package studentman;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview Student represent someone who had or is participating in a school's course(s)
 * @attributes
 * id				Integer		int
 * name				String		string 
 * phoneNumber		String		string
 * address			String		string
 * @objects a typical Student object is s=<i, n, p, a>, where id(i), name(n), phoneNumber(p), address(a)
 * @abstract_properties
 * mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\ max(id) = 10^9 /\
 * mutable(name) = true /\ optional(name) = false /\ length(name) = 50 /\
 * mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length = 10 /\
 * mutable(address) = true /\ optional(address) = false /\ length = 100 /\
 * 
 * @author Dinh Vu Anh
 * 		https://github.com/VuAnh183/SE_Java
 */
public class Student implements Comparable, Document{
	// attributes
	@DomainConstraint(mutable = false, optional = false, min = 1, max = 10e9)
	protected int id;
	
	@DomainConstraint(mutable = true, optional = false, length = 50)
	protected String name;
	
	@DomainConstraint(mutable = true, optional = false, length = 10)
	protected String phoneNumber;
	
	@DomainConstraint(mutable = true, optional = false, length = 100)
	protected String address;
	
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
	public Student(
			@AttrRef("id") int id,
			@AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber,
			@AttrRef("address") String address)
			throws NotPossibleException {
		//TODO: check attributes validation
		
		if(!validateId(id)) {
			throw new NotPossibleException("Invalid id!");
		}
		
		if(!validateName(name)) {
			throw new NotPossibleException("Invalid name!");
		}
		
		if(!validatePhoneNumber(phoneNumber)) {
			throw new NotPossibleException("Invalid phone number!");
		}
		
		if(!validateAddress(address)) {
			throw new NotPossibleException("Invalid address!");
		}
		
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	
//	/**
//     * A default constructor is required to initialize attributes in subclasses with different "id" attributes.
//     * The subclass checks the given parameters before setting the attributes,
//     * making it necessary to have a separate constructor for initialization.
//     */
//    public Student() {
//        this.id = 0;
//        this.name = "";
//        this.phoneNumber = "";
//        this.address = "";
//    }
    
    
	// getters - observers
	/**
	 * @effect 
	 * 		return ID
	 */
	@DOpt(type = OptType.Observer) @AttrRef("id")
	public int getId() {
		return this.id;
	}
	
	/**
	 * @effect 
	 * 		return name
	 */
	@DOpt(type = OptType.Observer) @AttrRef("name")
	public String getName() {
		return this.name;
		
	}
	
	/**
	 * @effect 
	 * 		return phoneNumber
	 */
	@DOpt(type = OptType.Observer) @AttrRef("phoneNumber")
	public String getPhoneNumber() {
		return this.phoneNumber;
		
	}
	
	/**
	 * @effect 
	 * 		return address
	 */
	@DOpt(type = OptType.Observer) @AttrRef("address")
	public String getAddress() {
		return this.address;
		
	}
	
	
	//setters - mutators
	/**
	 * @modifies this.name
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
		if(validateName(newName)) {
			this.name = newName;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @modifies this.phoneNumber
	 * @effects <pre>
	 * if newphoneNumber is valid
	 * 		set this.phoneNumber = newphoneNumber
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("phoneNumber")
	public boolean setPhoneNumber(String newphoneNumber) {
		if(validatePhoneNumber(newphoneNumber)) {
			this.phoneNumber = newphoneNumber;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @modifies this.address
	 * @effects <pre>
	 * if newAddress is valid
	 * 		set this.address = newAddress
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("address")
	public boolean setAddress(String newAddress) {
		if(validateAddress(newAddress)) {
			this.address = newAddress;
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
	public boolean validateId(int id) {
		System.out.println("ValidateID Student");
		//min
		if(id < 1) {
			return false;
		}
		
		//max
		if(id > (int) (Math.pow(10, 9))) {
			return false;
		}
		
		return true;
		
	}
	
	/**
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
		if(name == null || name.length() == 0) {
			return false;
		}
		
		// length
		if(name.length() > 50) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @effects <pre>
	 * if phoneNumber is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 * 
	 */
	public boolean validatePhoneNumber(String phoneNumber) {
		
		// optional
		if(phoneNumber == null || phoneNumber.length() == 0) {
			return false;
		}
		
		// length
		if(phoneNumber.length() > 10) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @effects <pre>
	 * if address is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 * 
	 */
	public boolean validateAddress(String address) {
		
		// optional
		if(address == null || address.length() == 0) {
			return false;
		}
		
		// length
		if(address.length() > 100) {
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
		if(validateId(this.id) && validateName(this.name) && validatePhoneNumber(this.phoneNumber) && validateAddress(this.address)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// toString
	@DOpt(type = OptType.Default) 
	@Override
	public String toString() {
		return "Student <id="+this.id+", name="+this.name+", phone="+this.phoneNumber+", address="+this.address+">";
	}

	// compareTo
	@Override
	public int compareTo(Object o) throws 
	NullPointerException, ClassCastException{
		// TODO Auto-generated method stub
		 if (o == null)
		      throw new NullPointerException("Student.compareByName");
		    else if (!(o instanceof Student))
		      throw new ClassCastException("Student.compareByName: not a Student " + o);
		
		 Student s = (Student) o;
		return this.name.compareTo(s.name);
	}

	//toHtmlDoc
	/**
	 * @effects String representation for the current object
	 */
	@DOpt(type = OptType.Default)
	@Override
	public String toHtmlDoc() {
		// TODO Auto-generated method stub
		return String.format(
				"<html>\\n<head><title>Student: %d - %s</title></head>\\n<body>\\n%s %s %s %s\\n</body></html>\",\r\n",
				id, name, id, name, phoneNumber, address
				);
	}
}
