/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2007 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.spinsuite.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import org.spinsuite.util.KeyNamePair;

/** Generated Interface for R_RequestUpdate
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (1252452765)
 */
public interface I_R_RequestUpdate 
{

    /** TableName=R_RequestUpdate */
    public static final String Table_Name = "R_RequestUpdate";

    /** SPS_Table_ID=1000312 */
    public static final int SPS_Table_ID = 1000312;
    KeyNamePair Model = new KeyNamePair(SPS_Table_ID, Table_Name);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name ConfidentialTypeEntry */
    public static final String COLUMNNAME_ConfidentialTypeEntry = "ConfidentialTypeEntry";

	/** Set Entry Confidentiality.
	  * Confidentiality of the individual entry
	  */
	public void setConfidentialTypeEntry (String ConfidentialTypeEntry);

	/** Get Entry Confidentiality.
	  * Confidentiality of the individual entry
	  */
	public String getConfidentialTypeEntry();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Date getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name EndTime */
    public static final String COLUMNNAME_EndTime = "EndTime";

	/** Set End Time.
	  * End of the time span
	  */
	public void setEndTime (Date EndTime);

	/** Get End Time.
	  * End of the time span
	  */
	public Date getEndTime();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name M_ProductSpent_ID */
    public static final String COLUMNNAME_M_ProductSpent_ID = "M_ProductSpent_ID";

	/** Set Product Used.
	  * Product/Resource/Service used in Request
	  */
	public void setM_ProductSpent_ID (int M_ProductSpent_ID);

	/** Get Product Used.
	  * Product/Resource/Service used in Request
	  */
	public int getM_ProductSpent_ID();

    /** Column name QtyInvoiced */
    public static final String COLUMNNAME_QtyInvoiced = "QtyInvoiced";

	/** Set Quantity Invoiced.
	  * Invoiced Quantity
	  */
	public void setQtyInvoiced (BigDecimal QtyInvoiced);

	/** Get Quantity Invoiced.
	  * Invoiced Quantity
	  */
	public BigDecimal getQtyInvoiced();

    /** Column name QtySpent */
    public static final String COLUMNNAME_QtySpent = "QtySpent";

	/** Set Quantity Used.
	  * Quantity used for this event
	  */
	public void setQtySpent (BigDecimal QtySpent);

	/** Get Quantity Used.
	  * Quantity used for this event
	  */
	public BigDecimal getQtySpent();

    /** Column name Result */
    public static final String COLUMNNAME_Result = "Result";

	/** Set Result.
	  * Result of the action taken
	  */
	public void setResult (String Result);

	/** Get Result.
	  * Result of the action taken
	  */
	public String getResult();

    /** Column name R_Request_ID */
    public static final String COLUMNNAME_R_Request_ID = "R_Request_ID";

	/** Set Request.
	  * Request from a Business Partner or Prospect
	  */
	public void setR_Request_ID (int R_Request_ID);

	/** Get Request.
	  * Request from a Business Partner or Prospect
	  */
	public int getR_Request_ID();

    /** Column name R_RequestUpdate_ID */
    public static final String COLUMNNAME_R_RequestUpdate_ID = "R_RequestUpdate_ID";

	/** Set Request Update	  */
	public void setR_RequestUpdate_ID (int R_RequestUpdate_ID);

	/** Get Request Update	  */
	public int getR_RequestUpdate_ID();

    /** Column name StartTime */
    public static final String COLUMNNAME_StartTime = "StartTime";

	/** Set Start Time.
	  * Time started
	  */
	public void setStartTime (Date StartTime);

	/** Get Start Time.
	  * Time started
	  */
	public Date getStartTime();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Date getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
