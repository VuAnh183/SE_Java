package a2_BIxx_yyy.studentman;

import java.text.Format;

import utils.*;
/**
 * @overview
 *   Representing an undergraduate student
 *
 * @attributes
 *   id           Integer
 *   name         String
 *   phoneNumber  String
 *   address      String
 *
 * @object
 *   Contains information about an undergraduate student: <id, name, phoneNumber, address>
 *
 * @abstract_properties
 *   id mutable: false, optional: false, min: 1e5, max: 1e8
 *   name mutable: true, optional: false, length: 50
 *   phoneNumber mutable: true, optional: false, length: 10
 *   address mutable: true, optional: false, length: 100
 */

public class UndergradStudent extends Student {
    private static final int MIN_ID = (int) 1e5;
    private static final int MAX_ID = (int) 1e8;

    /**
     * @effects
     *   init an UndergradStudent with id, name, phoneNumber, address
     * @throws NotPossibleException
     *   if any of the preconditions are violated
     */
    public UndergradStudent(
        @AttrRef("id") int id,
        @AttrRef("name") String name,
        @AttrRef("phoneNumber") String phoneNumber,
        @AttrRef("address") String address
    ) throws NotPossibleException {
        if(!super.validateId(id)) {
            throw new NotPossibleException("Student: Invalid id");
        } else if (!super.validateName(name)) {
            throw new NotPossibleException("Student: Invalid name");
        } else if (!super.validatePhoneNumber(phoneNumber)) {
            throw new NotPossibleException("Student: Invalid phone number");
        } else if (!super.validateAddress(address)) {
            throw new NotPossibleException("Student: Invalid address");
        }
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("UndergradStudent(%d, %s, %s, %s)", id, name, phoneNumber, address);
    }

    @Override
    public String toHtmlDoc() {
        return String.format(
            "<html>\n<head><title>UndergradStudent:%d-%s</title></head>\n<body>\n%d %s %s %s\n</body></html>",
            id, name, id, name, phoneNumber, address
        );
    }

    @Override
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
    @DOpt(type = OptType.Helper)
    protected boolean validateId(int id) {
        return (id >= MIN_ID) && (id <= MAX_ID);
    }
}
