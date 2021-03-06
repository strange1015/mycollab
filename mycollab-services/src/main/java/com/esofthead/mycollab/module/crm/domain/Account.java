/**
 * This file is part of mycollab-services.
 *
 * mycollab-services is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-services is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-services.  If not, see <http://www.gnu.org/licenses/>.
 */
/*Domain class of table m_crm_account*/
package com.esofthead.mycollab.module.crm.domain;

import com.esofthead.mycollab.core.arguments.ValuedBean;
import java.util.Date;

@SuppressWarnings("ucd")
@com.esofthead.mycollab.core.db.metadata.Table("m_crm_account")
public class Account extends ValuedBean {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.id
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("id")
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.accountName
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=255, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("accountName")
    private String accountname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.website
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=255, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("website")
    private String website;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.phoneOffice
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("phoneOffice")
    private String phoneoffice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.fax
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("fax")
    private String fax;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.alternatePhone
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("alternatePhone")
    private String alternatephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.annualRevenue
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("annualRevenue")
    private String annualrevenue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.billingAddress
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=255, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("billingAddress")
    private String billingaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.city
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=100, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("city")
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.postalCode
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("postalCode")
    private String postalcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.state
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("state")
    private String state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.email
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("email")
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.ownership
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=255, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("ownership")
    private String ownership;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.shippingAddress
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=255, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("shippingAddress")
    private String shippingaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.shippingCity
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=100, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("shippingCity")
    private String shippingcity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.shippingPostalCode
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("shippingPostalCode")
    private String shippingpostalcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.shippingState
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("shippingState")
    private String shippingstate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.numemployees
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("numemployees")
    private Integer numemployees;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.createdTime
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("createdTime")
    private Date createdtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.createdUser
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("createdUser")
    private String createduser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.sAccountId
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("sAccountId")
    private Integer saccountid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.assignUser
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("assignUser")
    private String assignuser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.type
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("type")
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.industry
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("industry")
    private String industry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.lastUpdatedTime
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("lastUpdatedTime")
    private Date lastupdatedtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.billingCountry
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("billingCountry")
    private String billingcountry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.shippingCountry
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("shippingCountry")
    private String shippingcountry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.avatarId
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=100, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("avatarId")
    private String avatarid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_account.description
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=65535, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("description")
    private String description;

    private static final long serialVersionUID = 1;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.id
     *
     * @return the value of m_crm_account.id
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.id
     *
     * @param id the value for m_crm_account.id
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.accountName
     *
     * @return the value of m_crm_account.accountName
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getAccountname() {
        return accountname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.accountName
     *
     * @param accountname the value for m_crm_account.accountName
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.website
     *
     * @return the value of m_crm_account.website
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getWebsite() {
        return website;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.website
     *
     * @param website the value for m_crm_account.website
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.phoneOffice
     *
     * @return the value of m_crm_account.phoneOffice
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getPhoneoffice() {
        return phoneoffice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.phoneOffice
     *
     * @param phoneoffice the value for m_crm_account.phoneOffice
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setPhoneoffice(String phoneoffice) {
        this.phoneoffice = phoneoffice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.fax
     *
     * @return the value of m_crm_account.fax
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getFax() {
        return fax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.fax
     *
     * @param fax the value for m_crm_account.fax
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.alternatePhone
     *
     * @return the value of m_crm_account.alternatePhone
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getAlternatephone() {
        return alternatephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.alternatePhone
     *
     * @param alternatephone the value for m_crm_account.alternatePhone
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setAlternatephone(String alternatephone) {
        this.alternatephone = alternatephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.annualRevenue
     *
     * @return the value of m_crm_account.annualRevenue
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getAnnualrevenue() {
        return annualrevenue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.annualRevenue
     *
     * @param annualrevenue the value for m_crm_account.annualRevenue
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setAnnualrevenue(String annualrevenue) {
        this.annualrevenue = annualrevenue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.billingAddress
     *
     * @return the value of m_crm_account.billingAddress
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getBillingaddress() {
        return billingaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.billingAddress
     *
     * @param billingaddress the value for m_crm_account.billingAddress
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.city
     *
     * @return the value of m_crm_account.city
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.city
     *
     * @param city the value for m_crm_account.city
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.postalCode
     *
     * @return the value of m_crm_account.postalCode
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getPostalcode() {
        return postalcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.postalCode
     *
     * @param postalcode the value for m_crm_account.postalCode
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.state
     *
     * @return the value of m_crm_account.state
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.state
     *
     * @param state the value for m_crm_account.state
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.email
     *
     * @return the value of m_crm_account.email
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.email
     *
     * @param email the value for m_crm_account.email
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.ownership
     *
     * @return the value of m_crm_account.ownership
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getOwnership() {
        return ownership;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.ownership
     *
     * @param ownership the value for m_crm_account.ownership
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.shippingAddress
     *
     * @return the value of m_crm_account.shippingAddress
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getShippingaddress() {
        return shippingaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.shippingAddress
     *
     * @param shippingaddress the value for m_crm_account.shippingAddress
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.shippingCity
     *
     * @return the value of m_crm_account.shippingCity
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getShippingcity() {
        return shippingcity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.shippingCity
     *
     * @param shippingcity the value for m_crm_account.shippingCity
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setShippingcity(String shippingcity) {
        this.shippingcity = shippingcity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.shippingPostalCode
     *
     * @return the value of m_crm_account.shippingPostalCode
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getShippingpostalcode() {
        return shippingpostalcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.shippingPostalCode
     *
     * @param shippingpostalcode the value for m_crm_account.shippingPostalCode
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setShippingpostalcode(String shippingpostalcode) {
        this.shippingpostalcode = shippingpostalcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.shippingState
     *
     * @return the value of m_crm_account.shippingState
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getShippingstate() {
        return shippingstate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.shippingState
     *
     * @param shippingstate the value for m_crm_account.shippingState
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setShippingstate(String shippingstate) {
        this.shippingstate = shippingstate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.numemployees
     *
     * @return the value of m_crm_account.numemployees
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public Integer getNumemployees() {
        return numemployees;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.numemployees
     *
     * @param numemployees the value for m_crm_account.numemployees
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setNumemployees(Integer numemployees) {
        this.numemployees = numemployees;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.createdTime
     *
     * @return the value of m_crm_account.createdTime
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public Date getCreatedtime() {
        return createdtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.createdTime
     *
     * @param createdtime the value for m_crm_account.createdTime
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.createdUser
     *
     * @return the value of m_crm_account.createdUser
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getCreateduser() {
        return createduser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.createdUser
     *
     * @param createduser the value for m_crm_account.createdUser
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setCreateduser(String createduser) {
        this.createduser = createduser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.sAccountId
     *
     * @return the value of m_crm_account.sAccountId
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public Integer getSaccountid() {
        return saccountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.sAccountId
     *
     * @param saccountid the value for m_crm_account.sAccountId
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setSaccountid(Integer saccountid) {
        this.saccountid = saccountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.assignUser
     *
     * @return the value of m_crm_account.assignUser
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getAssignuser() {
        return assignuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.assignUser
     *
     * @param assignuser the value for m_crm_account.assignUser
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setAssignuser(String assignuser) {
        this.assignuser = assignuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.type
     *
     * @return the value of m_crm_account.type
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.type
     *
     * @param type the value for m_crm_account.type
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.industry
     *
     * @return the value of m_crm_account.industry
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.industry
     *
     * @param industry the value for m_crm_account.industry
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.lastUpdatedTime
     *
     * @return the value of m_crm_account.lastUpdatedTime
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public Date getLastupdatedtime() {
        return lastupdatedtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.lastUpdatedTime
     *
     * @param lastupdatedtime the value for m_crm_account.lastUpdatedTime
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setLastupdatedtime(Date lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.billingCountry
     *
     * @return the value of m_crm_account.billingCountry
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getBillingcountry() {
        return billingcountry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.billingCountry
     *
     * @param billingcountry the value for m_crm_account.billingCountry
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setBillingcountry(String billingcountry) {
        this.billingcountry = billingcountry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.shippingCountry
     *
     * @return the value of m_crm_account.shippingCountry
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getShippingcountry() {
        return shippingcountry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.shippingCountry
     *
     * @param shippingcountry the value for m_crm_account.shippingCountry
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setShippingcountry(String shippingcountry) {
        this.shippingcountry = shippingcountry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.avatarId
     *
     * @return the value of m_crm_account.avatarId
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getAvatarid() {
        return avatarid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.avatarId
     *
     * @param avatarid the value for m_crm_account.avatarId
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setAvatarid(String avatarid) {
        this.avatarid = avatarid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_account.description
     *
     * @return the value of m_crm_account.description
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_account.description
     *
     * @param description the value for m_crm_account.description
     *
     * @mbggenerated Tue Jun 23 23:25:31 ICT 2015
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public static enum Field {
        id,
        accountname,
        website,
        phoneoffice,
        fax,
        alternatephone,
        annualrevenue,
        billingaddress,
        city,
        postalcode,
        state,
        email,
        ownership,
        shippingaddress,
        shippingcity,
        shippingpostalcode,
        shippingstate,
        numemployees,
        createdtime,
        createduser,
        saccountid,
        assignuser,
        type,
        industry,
        lastupdatedtime,
        billingcountry,
        shippingcountry,
        avatarid,
        description;

        public boolean equalTo(Object value) {
            return name().equals(value);
        }
    }
}