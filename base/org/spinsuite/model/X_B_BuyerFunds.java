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
/** Generated Model - DO NOT CHANGE */
package org.spinsuite.model;

import android.content.Context;
import android.database.Cursor;
import java.math.BigDecimal;
import java.util.Date;
import org.spinsuite.base.DB;
import org.spinsuite.util.Env;
import org.spinsuite.util.KeyNamePair;

/** Generated Model for B_BuyerFunds
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (1252452765) - $Id$ */
public class X_B_BuyerFunds extends PO implements I_B_BuyerFunds
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140422L;

    /** Standard Constructor */
    public X_B_BuyerFunds (Context ctx, int B_BuyerFunds_ID, DB conn)
    {
      super (ctx, B_BuyerFunds_ID, conn);
      /** if (B_BuyerFunds_ID == 0)
        {
			setAD_User_ID (0);
			setB_BuyerFunds_ID (0);
			setCommittedAmt (Env.ZERO);
			setNonCommittedAmt (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_B_BuyerFunds (Context ctx, Cursor rs, DB conn)
    {
      super (ctx, rs, conn);
    }


    /** Load Meta Data */
    protected POInfo initPO (Context ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, SPS_Table_ID, get_Connection());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_B_BuyerFunds[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Usuario.
		@param AD_User_ID 
		User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1) 
			set_Value (COLUMNNAME_AD_User_ID, null);
		else 
			set_Value (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get Usuario.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getAD_User_ID()));
    }

	/** Set Buyer Funds.
		@param B_BuyerFunds_ID 
		Buyer Funds for Bids on Topics
	  */
	public void setB_BuyerFunds_ID (int B_BuyerFunds_ID)
	{
		if (B_BuyerFunds_ID < 1) 
			set_Value (COLUMNNAME_B_BuyerFunds_ID, null);
		else 
			set_Value (COLUMNNAME_B_BuyerFunds_ID, Integer.valueOf(B_BuyerFunds_ID));
	}

	/** Get Buyer Funds.
		@return Buyer Funds for Bids on Topics
	  */
	public int getB_BuyerFunds_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_B_BuyerFunds_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Committed Amount.
		@param CommittedAmt 
		The (legal) commitment amount
	  */
	public void setCommittedAmt (BigDecimal CommittedAmt)
	{
		set_Value (COLUMNNAME_CommittedAmt, CommittedAmt);
	}

	/** Get Committed Amount.
		@return The (legal) commitment amount
	  */
	public BigDecimal getCommittedAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CommittedAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Order.
		@param C_Order_ID 
		Order
	  */
	public void setC_Order_ID (int C_Order_ID)
	{
		if (C_Order_ID < 1) 
			set_Value (COLUMNNAME_C_Order_ID, null);
		else 
			set_Value (COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
	}

	/** Get Order.
		@return Order
	  */
	public int getC_Order_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Order_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Payment.
		@param C_Payment_ID 
		Payment identifier
	  */
	public void setC_Payment_ID (int C_Payment_ID)
	{
		if (C_Payment_ID < 1) 
			set_Value (COLUMNNAME_C_Payment_ID, null);
		else 
			set_Value (COLUMNNAME_C_Payment_ID, Integer.valueOf(C_Payment_ID));
	}

	/** Get Payment.
		@return Payment identifier
	  */
	public int getC_Payment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Not Committed Aount.
		@param NonCommittedAmt 
		Amount not committed yet
	  */
	public void setNonCommittedAmt (BigDecimal NonCommittedAmt)
	{
		set_Value (COLUMNNAME_NonCommittedAmt, NonCommittedAmt);
	}

	/** Get Not Committed Aount.
		@return Amount not committed yet
	  */
	public BigDecimal getNonCommittedAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_NonCommittedAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}