package Tutor3.ex2;

import utils.*;
/**
 * @overview
 * @attributes
 * manName    String      string
 * model      String      string
 * color      Character   char
 * year       Integer     int   
 * guaranteed Boolean     boolean
 * @objects a typical MobilePhone object is mb=<mN, m, c, y> where manName(mN), model(m), color(c), year(y)
 * @abstract_properties
 * mutable(manName) = false /\ optional(manName) = false /\ length(manName) = 10 /\
 * mutable(model) = false /\ optional(model) = false /\ length(model) = 20 /\
 * mutable(color) = false /\ optional(color) = false /\
 * mutable(year) = false /\ optional(year) = false /\ min(year) = 1973 /\ max(year) = 2024
 * mutable(guaranteed) = true /\ optional(guaranteed) = true 
 */ 
public class MobilePhone {
	// attributes
	
	@DomainConstraint(mutable = false, optional = false, length = 10)
	private String manName;
	
	@DomainConstraint(mutable = false, optional = false, length = 20)
	private String model;
	
	@DomainConstraint(mutable = false, optional = false)
	private char color;
	
	@DomainConstraint(mutable = false, optional = false, min = 1973, max = 2024)
	private int year;
	
	@DomainConstraint(mutable = true, optional = true)
	private boolean guaranteed;
	
	
	// methods
	// constructor - attr optional = false -> param
	
	public MobilePhone(
			@AttrRef("manName") String manName,
			@AttrRef("model") String model,
			@AttrRef("color") char color,
			@AttrRef("year") int year
			) throws NotPossibleException {
		//TODO: validation check
		this.manName = manName;
		this.model = model;
		this.color = color;
		this.year = year;
		
	}
	
	// getters
	/*
	 * @effect return this.manName
	 */
	@DOpt(type = OptType.Observer) @AttrRef("manName")
	public String getManName() {
		return this.manName;
	}
	
	/*
	 * @effect return this.model
	 */
	@DOpt(type = OptType.Observer) @AttrRef("model")
	public String getModel() {
		return this.model;
	}
	
	/*
	 * @effect return this.color
	 */
	@DOpt(type = OptType.Observer) @AttrRef("color")
	public char getColor() {
		return this.color;
	}
	
	/*
	 * @effect return this.year
	 */
	@DOpt(type = OptType.Observer) @AttrRef("year")
	public int getYear() {
		return this.year;
	}
	
	/*
	 * @effect return this.model
	 */
	@DOpt(type = OptType.Observer) @AttrRef("guaranteed")
	public boolean getGuaranteed() {
		return this.guaranteed;
	}
	
	// mutator - setters: mutable = true -> setter
	/*
	 * @effects <pre>
	 * if newGuaranteed is valid
	 * 		this.guaranteed = newGuaranteed
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	public boolean setGuaranteed(boolean newGuaranteed) {
		if(validateGuaranteed(guaranteed)) {
			this.guaranteed = newGuaranteed;
			return true;
		} else {
			return false;
		}
	}
	
	// helper - validators
	/*
	 * @effects <pre>
	 * if manName is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	public boolean validateManName(String manName) {
		
		// length
		if (manName.length() > 10) {
			return false;
		}
		
		return true;
	}
	public boolean repOK() {
	  //TODO:
	  return true;
	}
}
