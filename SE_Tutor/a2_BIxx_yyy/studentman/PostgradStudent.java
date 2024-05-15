package a2_BIxx_yyy.studentman;

import utils.*;


/**
 * @overview
 *   A PostgradStudent, a subclass of Student
 *
 * @attributes
 *   id           Integer
 *   name         String
 *   phoneNumber  String
 *   address      String
 *   gpa          Float
 *
 * @object
 *   A PostgradStudent is <id, name, phoneNumber, address, gpa>
 *
 * @abstract_properties
 *   id mutable: false, optional: false, min: 1e8 + 1, max: 1e9
 *   name mutable: true, optional: false, length: 50
 *   phoneNumber mutable: true, optional: false, length: 10
 *   address mutable: true, optional: false, length: 100
 *   gpa mutable: true, optional: false, min: 0.0, max: 4.0
 */

public class PostgradStudent extends Student {
    private static final int MIN_ID = (int) (1e8 + 1);
    private static final int MAX_ID = (int) 1e9;
    private static final float MIN_GPA = 0.0f;
    private static final float MAX_GPA = 4.0f;

    @DomainConstraint(type = "Float", optional = false, min = MIN_GPA, max = MAX_GPA)
    private float gpa;

    /**
     * Constructor
     * @effects
     *   init a PostgradStudent with id, name, phoneNumber, address, gpa
     * @throws NotPossibleException
     *   if any of the preconditions are violated
     */
    public PostgradStudent(
        @AttrRef("id") int id,
        @AttrRef("name") String name,
        @AttrRef("phoneNumber") String phoneNumber,
        @AttrRef("address") String address,
        @AttrRef("gpa") Float gpa
    ) throws NotPossibleException {
        if (!super.validateId(id)) {
            throw new NotPossibleException("PostgradStudent: Invalid id");
        } else if (!validateName(name)) {
            throw new NotPossibleException("PostgradStudent: Invalid name");
        } else if (!validatePhoneNumber(phoneNumber)) {
            throw new NotPossibleException("PostgradStudent: Invalid phone number");
        } else if (!validateAddress(address)) {
            throw new NotPossibleException("PostgradStudent: Invalid address");
        } else if (!validateGpa(gpa)) {
            throw new NotPossibleException("PostgradStudent: Invalid gpa");
        }
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gpa = gpa;
    }

    /**
     * @effects
     *   return GPA
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("gpa")
    public float getGpa() {
        return gpa;
    }

    /**
     * @effects
     *   return true if gpa is valid and set gpa to gpa
     *   else return false
     */
    @DOpt(type = OptType.Mutator)   @AttrRef("gpa")
    public boolean setGpa(float gpa) {
        if (!validateGpa(gpa)) {
            return false;
        }
        this.gpa = gpa;
        return true;
    }

    @Override
    public String toString() {
        return String.format("PostgradStudent(%d, %s, %s, %s, %f)", id, name, phoneNumber, address, gpa);
    }

    @Override
    public String toHtmlDoc() {
        return String.format("<html>\n" +
                "<head><title>PostgradStudent:%d-%s</title></head>\n" +
                "<body>\n" +
                "%d %s %s %s %f\n" +
                "</body></html>", id, name, id, name, phoneNumber, address, gpa);
    }

    @Override
    public boolean repOK() {
        return super.repOK() && validateGpa(gpa);
    }

    @Override
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
    @DOpt(type = OptType.Helper)
    protected boolean validateId(int id) {
        return (id >= MIN_ID && id <= MAX_ID);
    }

    /**
     * @param gpa GPA of a PostgradStudent
     * @effects
     *   return true if gpa is valid
     *   else return false
     */
    @DOpt(type = OptType.Helper)
    protected boolean validateGpa(float gpa) {
        return (gpa >= MIN_GPA && gpa <= MAX_GPA);
    }
}
