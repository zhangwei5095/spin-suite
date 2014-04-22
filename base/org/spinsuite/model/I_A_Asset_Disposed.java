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

/** Generated Interface for A_Asset_Disposed
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (1252452765)
 */
public interface I_A_Asset_Disposed 
{

    /** TableName=A_Asset_Disposed */
    public static final String Table_Name = "A_Asset_Disposed";

    /** SPS_Table_ID=1000642 */
    public static final int SPS_Table_ID = 1000642;
    KeyNamePair Model = new KeyNamePair(SPS_Table_ID, Table_Name);

    /** Load Meta Data */

    /** Column name A_Asset_Disposed_ID */
    public static final String COLUMNNAME_A_Asset_Disposed_ID = "A_Asset_Disposed_ID";

	/** Set Disposed Asset	  */
	public void setA_Asset_Disposed_ID (int A_Asset_Disposed_ID);

	/** Get Disposed Asset	  */
	public int getA_Asset_Disposed_ID();

    /** Column name A_Asset_ID */
    public static final String COLUMNNAME_A_Asset_ID = "A_Asset_ID";

	/** Set Asset.
	  * Asset used internally or by customers
	  */
	public void setA_Asset_ID (int A_Asset_ID);

	/** Get Asset.
	  * Asset used internally or by customers
	  */
	public int getA_Asset_ID();

    /** Column name A_Asset_Trade_ID */
    public static final String COLUMNNAME_A_Asset_Trade_ID = "A_Asset_Trade_ID";

	/** Set Asset Trade	  */
	public void setA_Asset_Trade_ID (int A_Asset_Trade_ID);

	/** Get Asset Trade	  */
	public int getA_Asset_Trade_ID();

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name A_Disposed_Date */
    public static final String COLUMNNAME_A_Disposed_Date = "A_Disposed_Date";

	/** Set Disposed Date	  */
	public void setA_Disposed_Date (Date A_Disposed_Date);

	/** Get Disposed Date	  */
	public Date getA_Disposed_Date();

    /** Column name A_Disposed_Method */
    public static final String COLUMNNAME_A_Disposed_Method = "A_Disposed_Method";

	/** Set Disposal Method	  */
	public void setA_Disposed_Method (String A_Disposed_Method);

	/** Get Disposal Method	  */
	public String getA_Disposed_Method();

    /** Column name A_Disposed_Reason */
    public static final String COLUMNNAME_A_Disposed_Reason = "A_Disposed_Reason";

	/** Set Disposed Reason Code	  */
	public void setA_Disposed_Reason (String A_Disposed_Reason);

	/** Get Disposed Reason Code	  */
	public String getA_Disposed_Reason();

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

    /** Column name A_Proceeds */
    public static final String COLUMNNAME_A_Proceeds = "A_Proceeds";

	/** Set Proceeds	  */
	public void setA_Proceeds (BigDecimal A_Proceeds);

	/** Get Proceeds	  */
	public BigDecimal getA_Proceeds();

    /** Column name C_Period_ID */
    public static final String COLUMNNAME_C_Period_ID = "C_Period_ID";

	/** Set Period.
	  * Period of the Calendar
	  */
	public void setC_Period_ID (int C_Period_ID);

	/** Get Period.
	  * Period of the Calendar
	  */
	public int getC_Period_ID();

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

    /** Column name DateAcct */
    public static final String COLUMNNAME_DateAcct = "DateAcct";

	/** Set Account Date.
	  * Accounting Date
	  */
	public void setDateAcct (Date DateAcct);

	/** Get Account Date.
	  * Accounting Date
	  */
	public Date getDateAcct();

    /** Column name DateDoc */
    public static final String COLUMNNAME_DateDoc = "DateDoc";

	/** Set Document Date.
	  * Date of the Document
	  */
	public void setDateDoc (Date DateDoc);

	/** Get Document Date.
	  * Date of the Document
	  */
	public Date getDateDoc();

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

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

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
