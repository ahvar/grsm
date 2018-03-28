package com.circa.mrv.grs_manager.niox;

import java.util.Calendar;

/**
 * Creates a product in the NIOX family with a part-number, description, and price. The Niox class implements
 * the Expiration interface which declares methods for how different Niox items calculate their expiration
 * date.
 * 
 * @author Arthur Vargas
 */
public abstract class Product {
	/** A description of the product. */
	private String description;
	/** A part-number for the product */
	private String partNumber;
	/** A price for this customer*/
	private double price;
	
	/**
	 * Niox is constructed from a description, part number, and price for the product.
	 * 
	 * @param desc the product description
	 * @param partNumber partNumber for this Niox product
	 */
	public Product(String desc, String pn) {
		setDescription(desc);
		setPartNumber(pn);
	}
	
	/**
	 * Niox is constructed from a description, part number, and price for the product.
	 * 
	 * @param desc the product description
	 * @param partNumber partNumber for this Niox product
	 */
	public Product(String desc, String pn, double p ) {
		this(desc,pn);
		setPrice(p);
	}
	
	/**
	 * Returns the description.
	 * 
	 * @return description the description 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description to the pararmeter string. If the string is null or empty an
	 * IllegalArgumentExcpetion is thrown
	 * 
	 * @param description
	 *            the description to set
	 * @throws IllegalArgumentException
	 *             if the string provided for the description is null or empty.
	 */
	public void setDescription(String d) {
	
		if (d == null || d.isEmpty()) {
			throw new IllegalArgumentException("Invalid description.");
		}
	
		this.description = d;
	}
	
	/**
	 * Sets the part-number for this product to the value of pn.
	 * @param pn the part-number for this product.
	 */
	public void setPartNumber(String pn) { partNumber = pn; }
    
	/**
	 * Returns the part-number for this product.
	 * @return partNumber the part-number for the product
	 */
	public String getPartNumber() { return partNumber; }
	
	/**
	 * Sets the price for this product to the value passed in by 'p'.
	 * @param p the price for the product.
	 */
	public void setPrice(double p) { price = p; }
	
	/**
	 * Returns the price for this product
	 * @return price the price
	 */
	public double getPrice() { return price; }
	
	/**
	 * Generates and returns an array with two strings representing the partNumber and the product
	 * description.
	 * 
	 * @return string array of information
	 */
	public String[] getShortDisplayArray(){
		String[] s = { partNumber, description };
		return s;
	}
	
	/**
	 * Generate an array of strings that provides partNumber, description, price.
	 * @return string array of information 
	 */
	public String[] getLongDisplayArray(){
		String [] s = { partNumber, description, Double.toString(price) };
		return s;
	}
	
	
	/**
	 * Checks whether this 
	 * @param activity the activity to check
	 * @return true if duplicate false otherwise.
	 */
	//public boolean isDuplicate(Niox activity) {
		
//	}
	
	
	/**
	 * returns the Course's meetingDays
	 * 
	 * @return the meetingDays
	 
	public String getMeetingDays() {
		return meetingDays;
	}/*

	/**
	 * sets the activity's meetingDays.  
	 * @param meetingDays the meetingDays to set
	 *
	public void setMeetingDays(String meetingDays) {	
		if (meetingDays == null || meetingDays.isEmpty())
			throw new IllegalArgumentException("Invalid meeting days");
		
		this.meetingDays = meetingDays;
	}/*

	/**
	 * Creates a string to display the meeting days with the start and end times
	 * formatted to be standard time. If meetingDays is A only, then the string
	 * is "Arranged".
	 * 
	 * @return meetingString a string that shows either "Arranged" for
	 *         meetingDays = "A" or a formatted string showing the meetingDays
	 *         and the start and end times in standard time.
	 *
	public String getMeetingString() {
		String meetingString = "";
		int startHour = startTime / 100;
		int endHour = endTime / 100;
		int startMinutes = startTime % 100;
		int endMinutes = endTime % 100;
		String formattedStartMinutes = "";
		String formattedEndMinutes = "";
		String startAMOrPM = "AM";
		String endAMOrPM = "AM";
	
		if ("A".equals(meetingDays)) {
			meetingString = "Arranged";
		} else {
	
			formattedStartMinutes = getFormattedMinutes(startMinutes);
			formattedEndMinutes = getFormattedMinutes(endMinutes);
	
			if (startHour == 12)
				startAMOrPM = "PM";
			if (startHour > 12) {
				startHour -= 12;
				startAMOrPM = "PM";
			}
			if(endHour == 12)
				endAMOrPM = "PM";
			if (endHour > 12) {
				endHour -= 12;
				endAMOrPM = "PM";
			}
	
			meetingString = meetingDays + " " + startHour + ":" + formattedStartMinutes + startAMOrPM + "-" + endHour
					+ ":" + formattedEndMinutes + endAMOrPM;
		}
		return meetingString;
	}*/

	/**
	 * Is passed a time in minutes and formats it so that 0's are shown properly
	 * for standard time output.
	 * 
	 * @param minutes
	 *            the minutes portion of the time
	 * @return minutesFormatted the minutes portion of the time formatted so
	 *         that 0's are shown properly for standard time output.
	 *
	private String getFormattedMinutes(int minutes) {
		String minutesFormatted = "";
	
		if (minutes == 0) {
			minutesFormatted = minutes + "0";
		} else if (minutes < 10) {
			minutesFormatted = "0" + minutes;
		} else {
			minutesFormatted += minutes;
		}
		return minutesFormatted;
	}*/

	/**
	 * returns the Course's startTime
	 * 
	 * @return the startTime
	 *
	public int getStartTime() {
		return startTime;
	}*/

	/**
	 * returns the Course's endTime
	 * 
	 * @return the endTime
	 *
	public int getEndTime() {
		return endTime;
	}*/
	
	/**
	 * sets the activity's startTime and endTime by calling the setCourseTime method and passing it
	 * the startTime and endTime.
	 * @param startTime of the activity
	 * @param endTime of the activity
	 *
	public void setActivityTime(int startTime, int endTime){
		setCourseTime(startTime, endTime);
	}*/
	
	/**
	 * sets the endtime and startTime of the course after checking that the
	 * times are valid. also verifies that times should be supplied (ie. if
	 * meetingDay is A no times should be supplied that are !=0.
	 * 
	 * @param startTime
	 *            the start time of the course
	 * @param endTime
	 *            the end time of the course
	 * @throws IllegalArgumentException
	 *             if times are not valid 
	 *
	public void setCourseTime(int startTime, int endTime) {
	
//		if ("A".equals(meetingDays)) {
//				this.startTime = 0;
//				this.endTime = 0;
//				return;
//		}
		if ("A".equals(meetingDays)) {
			
			if (startTime != 0 || endTime != 0) {
				throw new IllegalArgumentException();
			} else {
				this.startTime = startTime;
				this.endTime = endTime;
				return;
			}
		}
	
		if (startTime < endTime && validateCourseTimeRange(startTime) && validateCourseTimeRange(endTime)
				&& startTime % 100 < UPPER_HOUR && endTime % 100 < UPPER_HOUR) {
	
			this.startTime = startTime;
			this.endTime = endTime;
		} else {
			throw new IllegalArgumentException("Invalid meeting times");
		}
	
	}*/

	/**
	 * validates that the time supplied falls within the valid range of times.
	 * 
	 * @param courseTime
	 *            either the startTime or the endTime.
	 * @return isValid which is true if time falls within range. false
	 *         otherwise.
	 *
	private boolean validateCourseTimeRange(int courseTime) {
		boolean isValid = false;
	
		if (courseTime >= 0 && courseTime < UPPER_TIME) {
			isValid = true;
		}
		return isValid;
	}*/
	
  /**
   * generates a hashcode for activity
   * @return hashcode for activity
   *
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endTime;
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		return result;
	}*/

    /**
     * 
     * Compares a given object to this object for equality on all fields.
     * 
     * @param obj the object to compare
     * @return true if the objects are the same on all fields.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (description != other.description)
			return false;
		if (partNumber == null) {
			if (other.partNumber != null)
				return false;
		} else if (!partNumber.equals(other.partNumber))
			return false;
		if (price != other.price)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	
	/**
	 * Checks that the passed activity does not have the same meeting days and times (or overlapping times) as this 
	 * activity. If the end or start times of either activity are equal an overlap is also assumed. IF a conflict is 
	 * determined, a ConflictException is thrown
	 * @param possibleConflictingActivity the activity to check against this activity to see if a conflict exists
	 * @throws ConflictException if a conflict is determined to exist between the two activities. 
	 *
	@Override
	public void checkConflict(NioxProduct possibleConflictingActivity) throws ConflictException {
		char pCAchar; //character for possibleConflictingActivity
		char thisChar; //character for this activity
		String pCAMeetingDaysString = possibleConflictingActivity.getMeetingDays();
		String thisActivityMeetingDaysString = this.getMeetingDays();
		
		if (pCAMeetingDaysString.charAt(0) != 'A'){
			
			for(int i = 0 ; i < pCAMeetingDaysString.length() ; i++){
				pCAchar = pCAMeetingDaysString.charAt(i);

				for (int k = 0 ; k < thisActivityMeetingDaysString.length() ; k++){
					thisChar = thisActivityMeetingDaysString.charAt(k);

					if (pCAchar == thisChar){

						if (this.startTime <= possibleConflictingActivity.startTime &&
								this.endTime >= possibleConflictingActivity.startTime)
							throw new ConflictException();

						if (this.startTime <= possibleConflictingActivity.endTime &&
								this.endTime >= possibleConflictingActivity.endTime)
							throw new ConflictException();

						if (this.startTime >= possibleConflictingActivity.startTime &&
								this.endTime <= possibleConflictingActivity.endTime)
							throw new ConflictException();
					}

				}		

			}
			
		}
	
	}*/
	
}