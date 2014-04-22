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

/** Generated Interface for C_Currency_Acct
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (1252452765)
 */
public interface I_C_Currency_Acct 
{

    /** TableName=C_Currency_Acct */
    public static final String Table_Name = "C_Currency_Acct";

    /** SPS_Table_ID=1000493 */
    public static final int SPS_Table_ID = 1000493;
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

    /** Column name C_AcctSchema_ID */
    public static final String COLUMNNAME_C_AcctSchema_ID = "C_AcctSchema_ID";

	/** Set Accounting Schema.
	  * Rules for accounting
	  */
	public void setC_AcctSchema_ID (int C_AcctSchema_ID);

	/** Get Accounting Schema.
	  * Rules for accounting
	  */
	public int getC_AcctSchema_ID();

    /** Column name C_Currency_ID */
    public static final String COLUMNNAME_C_Currency_ID = "C_Currency_ID";

	/** Set Currency.
	  * The Currency for this record
	  */
	public void setC_Currency_ID (int C_Currency_ID);

	/** Get Currency.
	  * The Currency for this record
	  */
	public int getC_Currency_ID();

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

    /** Column name RealizedGain_Acct */
    public static final String COLUMNNAME_RealizedGain_Acct = "RealizedGain_Acct";

	/** Set Realized Gain Acct.
	  * Realized Gain Account
	  */
	public void setRealizedGain_Acct (int RealizedGain_Acct);

	/** Get Realized Gain Acct.
	  * Realized Gain Account
	  */
	public int getRealizedGain_Acct();

    /** Column name RealizedLoss_Acct */
    public static final String COLUMNNAME_RealizedLoss_Acct = "RealizedLoss_Acct";

	/** Set Realized Loss Acct.
	  * Realized Loss Account
	  */
	public void setRealizedLoss_Acct (int RealizedLoss_Acct);

	/** Get Realized Loss Acct.
	  * Realized Loss Account
	  */
	public int getRealizedLoss_Acct();

    /** Column name UnrealizedGain_Acct */
    public static final String COLUMNNAME_UnrealizedGain_Acct = "UnrealizedGain_Acct";

	/** Set Unrealized Gain Acct.
	  * Unrealized Gain Account for currency revaluation
	  */
	public void setUnrealizedGain_Acct (int UnrealizedGain_Acct);

	/** Get Unrealized Gain Acct.
	  * Unrealized Gain Account for currency revaluation
	  */
	public int getUnrealizedGain_Acct();

    /** Column name UnrealizedLoss_Acct */
    public static final String COLUMNNAME_UnrealizedLoss_Acct = "UnrealizedLoss_Acct";

	/** Set Unrealized Loss Acct.
	  * Unrealized Loss Account for currency revaluation
	  */
	public void setUnrealizedLoss_Acct (int UnrealizedLoss_Acct);

	/** Get Unrealized Loss Acct.
	  * Unrealized Loss Account for currency revaluation
	  */
	public int getUnrealizedLoss_Acct();

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
