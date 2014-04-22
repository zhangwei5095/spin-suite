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

/** Generated Interface for M_PromotionReward
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (1252452765)
 */
public interface I_M_PromotionReward 
{

    /** TableName=M_PromotionReward */
    public static final String Table_Name = "M_PromotionReward";

    /** SPS_Table_ID=1000772 */
    public static final int SPS_Table_ID = 1000772;
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

    /** Column name Amount */
    public static final String COLUMNNAME_Amount = "Amount";

	/** Set Amount.
	  * Amount in a defined currency
	  */
	public void setAmount (BigDecimal Amount);

	/** Get Amount.
	  * Amount in a defined currency
	  */
	public BigDecimal getAmount();

    /** Column name C_Charge_ID */
    public static final String COLUMNNAME_C_Charge_ID = "C_Charge_ID";

	/** Set Charge.
	  * Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID);

	/** Get Charge.
	  * Additional document charges
	  */
	public int getC_Charge_ID();

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

    /** Column name DistributionSorting */
    public static final String COLUMNNAME_DistributionSorting = "DistributionSorting";

	/** Set Distribution Sorting.
	  * Quantity distribution sorting by unit price
	  */
	public void setDistributionSorting (String DistributionSorting);

	/** Get Distribution Sorting.
	  * Quantity distribution sorting by unit price
	  */
	public String getDistributionSorting();

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

    /** Column name IsForAllDistribution */
    public static final String COLUMNNAME_IsForAllDistribution = "IsForAllDistribution";

	/** Set For all distribution.
	  * This reward is for all distribution
	  */
	public void setIsForAllDistribution (boolean IsForAllDistribution);

	/** Get For all distribution.
	  * This reward is for all distribution
	  */
	public boolean isForAllDistribution();

    /** Column name IsSameDistribution */
    public static final String COLUMNNAME_IsSameDistribution = "IsSameDistribution";

	/** Set Same distribution for source and target.
	  * Use the same distribution for source and target
	  */
	public void setIsSameDistribution (boolean IsSameDistribution);

	/** Get Same distribution for source and target.
	  * Use the same distribution for source and target
	  */
	public boolean isSameDistribution();

    /** Column name M_PromotionDistribution_ID */
    public static final String COLUMNNAME_M_PromotionDistribution_ID = "M_PromotionDistribution_ID";

	/** Set Promotion Distribution	  */
	public void setM_PromotionDistribution_ID (int M_PromotionDistribution_ID);

	/** Get Promotion Distribution	  */
	public int getM_PromotionDistribution_ID();

    /** Column name M_Promotion_ID */
    public static final String COLUMNNAME_M_Promotion_ID = "M_Promotion_ID";

	/** Set Promotion	  */
	public void setM_Promotion_ID (int M_Promotion_ID);

	/** Get Promotion	  */
	public int getM_Promotion_ID();

    /** Column name M_PromotionReward_ID */
    public static final String COLUMNNAME_M_PromotionReward_ID = "M_PromotionReward_ID";

	/** Set Promotion Reward.
	  * Setup reward for the promotion
	  */
	public void setM_PromotionReward_ID (int M_PromotionReward_ID);

	/** Get Promotion Reward.
	  * Setup reward for the promotion
	  */
	public int getM_PromotionReward_ID();

    /** Column name M_TargetDistribution_ID */
    public static final String COLUMNNAME_M_TargetDistribution_ID = "M_TargetDistribution_ID";

	/** Set Target distribution.
	  * Get product from target distribution to apply the promotion reward
	  */
	public void setM_TargetDistribution_ID (int M_TargetDistribution_ID);

	/** Get Target distribution.
	  * Get product from target distribution to apply the promotion reward
	  */
	public int getM_TargetDistribution_ID();

    /** Column name Qty */
    public static final String COLUMNNAME_Qty = "Qty";

	/** Set Quantity.
	  * Quantity
	  */
	public void setQty (BigDecimal Qty);

	/** Get Quantity.
	  * Quantity
	  */
	public BigDecimal getQty();

    /** Column name RewardType */
    public static final String COLUMNNAME_RewardType = "RewardType";

	/** Set Reward Type.
	  * Type of reward which consists of percentage discount, flat discount or absolute amount
	  */
	public void setRewardType (String RewardType);

	/** Get Reward Type.
	  * Type of reward which consists of percentage discount, flat discount or absolute amount
	  */
	public String getRewardType();

    /** Column name SeqNo */
    public static final String COLUMNNAME_SeqNo = "SeqNo";

	/** Set Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public void setSeqNo (int SeqNo);

	/** Get Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public int getSeqNo();

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
