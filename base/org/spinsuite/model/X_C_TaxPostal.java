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
import java.util.Date;
import org.spinsuite.base.DB;
import org.spinsuite.util.KeyNamePair;

/** Generated Model for C_TaxPostal
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (1252452765) - $Id$ */
public class X_C_TaxPostal extends PO implements I_C_TaxPostal
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140422L;

    /** Standard Constructor */
    public X_C_TaxPostal (Context ctx, int C_TaxPostal_ID, DB conn)
    {
      super (ctx, C_TaxPostal_ID, conn);
      /** if (C_TaxPostal_ID == 0)
        {
			setC_Tax_ID (0);
			setC_TaxPostal_ID (0);
			setPostal (null);
        } */
    }

    /** Load Constructor */
    public X_C_TaxPostal (Context ctx, Cursor rs, DB conn)
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
      StringBuffer sb = new StringBuffer ("X_C_TaxPostal[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Tax.
		@param C_Tax_ID 
		Tax identifier
	  */
	public void setC_Tax_ID (int C_Tax_ID)
	{
		if (C_Tax_ID < 1) 
			set_Value (COLUMNNAME_C_Tax_ID, null);
		else 
			set_Value (COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
	}

	/** Get Tax.
		@return Tax identifier
	  */
	public int getC_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tax ZIP.
		@param C_TaxPostal_ID 
		Tax Postal/ZIP
	  */
	public void setC_TaxPostal_ID (int C_TaxPostal_ID)
	{
		if (C_TaxPostal_ID < 1) 
			set_Value (COLUMNNAME_C_TaxPostal_ID, null);
		else 
			set_Value (COLUMNNAME_C_TaxPostal_ID, Integer.valueOf(C_TaxPostal_ID));
	}

	/** Get Tax ZIP.
		@return Tax Postal/ZIP
	  */
	public int getC_TaxPostal_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_TaxPostal_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ZIP.
		@param Postal 
		Postal code
	  */
	public void setPostal (String Postal)
	{
		set_Value (COLUMNNAME_Postal, Postal);
	}

	/** Get ZIP.
		@return Postal code
	  */
	public String getPostal () 
	{
		return (String)get_Value(COLUMNNAME_Postal);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getPostal());
    }

	/** Set ZIP To.
		@param Postal_To 
		Postal code to
	  */
	public void setPostal_To (String Postal_To)
	{
		set_Value (COLUMNNAME_Postal_To, Postal_To);
	}

	/** Get ZIP To.
		@return Postal code to
	  */
	public String getPostal_To () 
	{
		return (String)get_Value(COLUMNNAME_Postal_To);
	}
}