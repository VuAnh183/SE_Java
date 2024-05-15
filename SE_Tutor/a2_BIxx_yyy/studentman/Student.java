package a2_BIxx_yyy.studentman;

import utils.*;

/**
 * @overview
 *   Representing a student
 *
 * @attributes
 *   id           Integer
 *   name         String
 *   phoneNumber  String
 *   address      String
 *
 * @object
 *   Contains information about a student: <id, name, phoneNumber, address>
 *
 * @abstract_properties
 *   id mutable: false, optional: false, min: 1, max: 1e9
 *   name mutable: true, optional: false, length: 50
 *   phoneNumber mutable: true, optional: false, length: 10
 *   address mutable: true, optional: false, length: 100
 */

public class Student implements Comparable<Student>, Document{
    private static final int MIN_ID = 1;
    private static final int MAX_ID = (int) 1e9;
    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_PHONE_NUMBER_LENGTH = 10;
    private static final int MAX_ADDRESS_LENGTH = 100;

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
    protected int id;
    @DomainConstraint(type = "String", optional = false, length = MAX_NAME_LENGTH)
    protected String name;
    @DomainConstraint(type = "String", optional = false, length = MAX_PHONE_NUMBER_LENGTH)
    protected String phoneNumber;
    @DomainConstraint(type = "String", optional = false, length = MAX_ADDRESS_LENGTH)
    protected String address;

    /**
     * Constructor
     * @effects
     *   init a Student with id, name, phoneNumber, address
     * @throws NotPossibleException
     *   if any of the preconditions are violated
     */
    public Student(
        @AttrRef("id") int id,
        @AttrRef("name") String name,
        @AttrRef("phoneNumber") String phoneNumber,
        @AttrRef("address") String address
    ) throws NotPossibleException {
        if (!validateId(id)) {
            throw new NotPossibleException("Student: Invalid id");
        } else if (!validateName(name)) {
            throw new NotPossibleException("Student: Invalid name");
        } else if (!validatePhoneNumber(phoneNumber)) {
            throw new NotPossibleException("Student: Invalid phone number");
        } else if (!validateAddress(address)) {
            throw new NotPossibleException("Student: Invalid address");
        }
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * A default constructor is required to initialize attributes in subclasses with different "id" attributes.
     * The subclass checks the given parameters before setting the attributes,
     * making it necessary to have a separate constructor for initialization.
     */
    public Student() {
        this.id = 0;
        this.name = "";
        this.phoneNumber = "";
        this.address = "";
    }

    /**
     * @effects
     *   return ID
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("id")
    public int getId() {
        return id;
    }

    /**
     * @effects
     *   return address
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("address")
    public String getAddress() {
        return address;
    }

    /**
     * @effects
     *   return name
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("name")
    public String getName() {
        return name;
    }

    /**
     * @effects
     *   return phoneNumber
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @effects
     *   return false if name is not valid
     *   otherwise return true and set name
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("name")
    public boolean setName(String name) {
        if (validateName(name)) {
            this.name = name;
            return true;
        }
        return false;
    }

    /**
     * @effects
     *   return false if phoneNumber is not valid
     *   otherwise return true and set phoneNumber
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("phoneNumber")
    public boolean setPhoneNumber(String phoneNumber) {
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            return true;
        }
        return false;
    }

    /**
     * @effects
     *   return false if address is not valid
     *   otherwise return true and set address
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("address")
    public boolean setAddress(String address) {
        if (validateAddress(address)) {
            this.address = address;
            return true;
        }
        return false;
    }

    /**
     * @param std object to be compared
     * @effects
     *   return the returned value of comparing this and std
     */
    @Override
    @DOpt(type = OptType.Default)
    public int compareTo(Student std) {
        return this.name.compareTo(std.getName());
    }

    /**
     * @effects
     *   String representation of this
     */
    @Override
    @DOpt(type = OptType.Default)
    public String toHtmlDoc() {
        return String.format(
            "<html>\n<head><title>Student: %d - %s</title></head>\n<body>\n%s %s %s %s\n</body></html>",
            id, name, id, name, phoneNumber, address
        );
    }
    /**
     * @effects
     *   return true if all attributes are valid
     */
    public boolean repOK() {
        return validateId(id) && validateName(name) && validatePhoneNumber(phoneNumber) && validateAddress(address);
    }

    @Override
    public String toString() {
        return String.format("Student(%d, %s, %s, %s)", id, name, phoneNumber, address);
    }


    /**
     * @param id ID to be validated
     * @effects
     * <pre>
     *   return true if id is valid else false
     */
    @DOpt(type = OptType.Helper)
    protected boolean validateId(int id) {
        return (id >= MIN_ID) && (id <= MAX_ID);
    }

    /**
     * @param name name to be validated
     * @effects
     *   return true if name is valid else false
     */
    @DOpt(type = OptType.Helper)
    protected boolean validateName(String name) {
        if (name == null || name.length() == 0 || name.length() > MAX_NAME_LENGTH) {
            return false;
        }
        return true;
    }

    /**
     * @param phoneNumber the phone number to be validated.
     * @effects
     *   return true if phoneNumber is valid else false
     */
    @DOpt(type = OptType.Helper)
    protected boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() == 0 || phoneNumber.length() > MAX_PHONE_NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

    /**
     * @param address the address to be validated.
     * @effects
     *   return true if address is valid else false
     */
    @DOpt(type = OptType.Helper)
    protected boolean validateAddress(String address) {
        if (address == null || address.length() == 0 || address.length() > MAX_ADDRESS_LENGTH) {
            return false;
        }
        return true;
    }
}