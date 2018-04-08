/**
 * 
 */
package com.circa.mrv.grs_manager.niox;

import java.util.Calendar;

/**
 * The Component class extends the Product class and implements Consumable interface. 
 * It has a date the component was packaged, from which the expiration can be calculated.
 * Component also has a serial number and product generation.
 *  
 * @author Arthur Vargas
 */
public class Component extends Product implements Consumable {
	/** Date the component was packaged */
	private Calendar packageDate;
	/** Serial Number */
	private long serial;
	/** Product generation */
	private String generation;
	
	/**
	 * Constructs a component with a description, part number, price, package date, serial number, and product
	 * generation.
	 * 
	 * @param the name of the product
	 * @param desc the description of the component
	 * @param pn the part number
	 * @param p the price
	 * @param packageDate the package date
	 * @param serial the serial number
	 * @param generation the product generation
	 */
	public Component(String name, String desc, String pn, double p, Calendar packageDate, long serial, String generation) {
		super(name, desc, pn, p);
		setPackageDate(packageDate);
		setSerial(serial);
		setGeneration(generation);
	}
	
	/**
	 * Constructs a component with a description, part number, price, package date, serial number, and product
	 * generation.
	 * @param name the name of the product
	 * @param desc the description of the component
	 * @param pn the part number
	 * @param p the price
	 */
	public Component(String name, String desc, String pn, double p) {
		super(name, desc, pn, p);
		setPackageDate(null);
		setSerial(0);
		setGeneration(null);
	}
	
	/**
	 * Constructs a component with a name, description, part number,
	 * @param name the name of the product
	 * @param desc the description of the component
	 * @param pn the part number
	 */
	public Component(String name, String desc, String pn) {
		super(name, desc, pn);
		setPackageDate(null);
		setSerial(0);
		setGeneration(null);
	}
	

	/**
	 * Returns the package date for this component
	 * @return the packageDate
	 */
	public Calendar getPackageDate() {
		return packageDate;
	}

	/**
	 * Sets the package date to the parameter packageDate
	 * @param packageDate the packageDate to set
	 */
	public void setPackageDate(Calendar packageDate) {
		this.packageDate = packageDate;
	}

	/**
	 * Returns the serial number for this component.
	 * @return the serial
	 */
	public long getSerial() {
		return serial;
	}

	/**
	 * Sets the serial number to the long named serial.
	 * @param serial the serial to set
	 */
	public void setSerial(long serial) {
		this.serial = serial;
	}

	/**
	 * Returns the product generation as a String.
	 * @return the generation
	 */
	public String getGeneration() {
		return generation;
	}

	/**
	 * Sets the product generation to the String in the parameter
	 * @param generation the generation to set
	 */
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	
	/**
	 * Calculates the expiration date based on the package date.
	 * @return date the expiration date based on the package date.
	 */
	public Calendar calculateExpiration() {
	    Calendar exp = packageDate;
	    exp.add(Calendar.YEAR, 2);
	    return exp;
	}
	
	/**
	 * Checks the expiration date by calculating the time elapsed from package date until today.
	 * 
	 * @param packageDate the date the item was packaged
	 * @return date the expiration date based on package date
	 * @throws NioxExpirationException if the item is past expiration
	 */
	@Override
	public Boolean checkExpiration( Calendar packageDate ) {
		return calculateExpiration().compareTo(Calendar.getInstance()) < 0; 
			
	}


	/**
	 * Generates the hashcode for an instance of component.
	 * @return the hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((generation == null) ? 0 : generation.hashCode());
		result = prime * result + ((packageDate == null) ? 0 : packageDate.hashCode());
		result = prime * result + (int) (serial ^ (serial >>> 32));
		return result;
	}


	/**
	 * Tests this Component for equality with the parameter obj
	 * @param obj the Object to compare with
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Component))
			return false;
		Component other = (Component) obj;
		if (generation == null) {
			if (other.generation != null)
				return false;
		} else if (!generation.equals(other.generation))
			return false;
		if (packageDate == null) {
			if (other.packageDate != null)
				return false;
		} else if (!packageDate.equals(other.packageDate))
			return false;
		if (serial != other.serial)
			return false;
		return true;
	}


	
}
