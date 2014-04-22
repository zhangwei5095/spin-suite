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

/** Generated Model for AD_MigrationScript
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (1252452765) - $Id$ */
public class X_AD_MigrationScript extends PO implements I_AD_MigrationScript
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140422L;

    /** Standard Constructor */
    public X_AD_MigrationScript (Context ctx, int AD_MigrationScript_ID, DB conn)
    {
      super (ctx, AD_MigrationScript_ID, conn);
      /** if (AD_MigrationScript_ID == 0)
        {
			setAD_MigrationScript_ID (0);
			setFileName (null);
			setisApply (false);
			setName (null);
			setProjectName (null);
			setReleaseNo (null);
			setStatus (null);
        } */
    }

    /** Load Constructor */
    public X_AD_MigrationScript (Context ctx, Cursor rs, DB conn)
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
      StringBuffer sb = new StringBuffer ("X_AD_MigrationScript[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Migration Script.
		@param AD_MigrationScript_ID 
		Migration Scripts for the System
	  */
	public void setAD_MigrationScript_ID (int AD_MigrationScript_ID)
	{
		if (AD_MigrationScript_ID < 1) 
			set_Value (COLUMNNAME_AD_MigrationScript_ID, null);
		else 
			set_Value (COLUMNNAME_AD_MigrationScript_ID, Integer.valueOf(AD_MigrationScript_ID));
	}

	/** Get Migration Script.
		@return Migration Scripts for the System
	  */
	public int getAD_MigrationScript_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_MigrationScript_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Developer Name.
		@param DeveloperName Developer Name	  */
	public void setDeveloperName (String DeveloperName)
	{
		set_Value (COLUMNNAME_DeveloperName, DeveloperName);
	}

	/** Get Developer Name.
		@return Developer Name	  */
	public String getDeveloperName () 
	{
		return (String)get_Value(COLUMNNAME_DeveloperName);
	}

	/** Set File Name.
		@param FileName 
		Name of the local file or URL
	  */
	public void setFileName (String FileName)
	{
		set_Value (COLUMNNAME_FileName, FileName);
	}

	/** Get File Name.
		@return Name of the local file or URL
	  */
	public String getFileName () 
	{
		return (String)get_Value(COLUMNNAME_FileName);
	}

	/** Set Apply Script.
		@param isApply Apply Script	  */
	public void setisApply (boolean isApply)
	{
		set_Value (COLUMNNAME_isApply, Boolean.valueOf(isApply));
	}

	/** Get Apply Script.
		@return Apply Script	  */
	public boolean isApply () 
	{
		Object oo = get_Value(COLUMNNAME_isApply);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Set Project.
		@param ProjectName 
		Name of the Project
	  */
	public void setProjectName (String ProjectName)
	{
		set_Value (COLUMNNAME_ProjectName, ProjectName);
	}

	/** Get Project.
		@return Name of the Project
	  */
	public String getProjectName () 
	{
		return (String)get_Value(COLUMNNAME_ProjectName);
	}

	/** Set Reference.
		@param Reference 
		Reference for this record
	  */
	public void setReference (String Reference)
	{
		set_Value (COLUMNNAME_Reference, Reference);
	}

	/** Get Reference.
		@return Reference for this record
	  */
	public String getReference () 
	{
		return (String)get_Value(COLUMNNAME_Reference);
	}

	/** Set Release No.
		@param ReleaseNo 
		Internal Release Number
	  */
	public void setReleaseNo (String ReleaseNo)
	{
		set_Value (COLUMNNAME_ReleaseNo, ReleaseNo);
	}

	/** Get Release No.
		@return Internal Release Number
	  */
	public String getReleaseNo () 
	{
		return (String)get_Value(COLUMNNAME_ReleaseNo);
	}

	/** Set Script.
		@param Script 
		Dynamic Java Language Script to calculate result
	  */
	public void setScript (byte[] Script)
	{
		set_Value (COLUMNNAME_Script, Script);
	}

	/** Get Script.
		@return Dynamic Java Language Script to calculate result
	  */
	public byte[] getScript () 
	{
		return (byte[])get_Value(COLUMNNAME_Script);
	}

	/** Set Roll the Script.
		@param ScriptRoll Roll the Script	  */
	public void setScriptRoll (String ScriptRoll)
	{
		set_Value (COLUMNNAME_ScriptRoll, ScriptRoll);
	}

	/** Get Roll the Script.
		@return Roll the Script	  */
	public String getScriptRoll () 
	{
		return (String)get_Value(COLUMNNAME_ScriptRoll);
	}

	/** Status AD_Reference_ID=53239 */
	public static final int STATUS_AD_Reference_ID=53239;
	/** In Progress = IP */
	public static final String STATUS_InProgress = "IP";
	/** Completed = CO */
	public static final String STATUS_Completed = "CO";
	/** Error = ER */
	public static final String STATUS_Error = "ER";
	/** Set Status.
		@param Status 
		Status of the currently running check
	  */
	public void setStatus (String Status)
	{

		set_Value (COLUMNNAME_Status, Status);
	}

	/** Get Status.
		@return Status of the currently running check
	  */
	public String getStatus () 
	{
		return (String)get_Value(COLUMNNAME_Status);
	}

	/** Set URL.
		@param URL 
		Full URL address - e.g. http://www.adempiere.org
	  */
	public void setURL (String URL)
	{
		set_Value (COLUMNNAME_URL, URL);
	}

	/** Get URL.
		@return Full URL address - e.g. http://www.adempiere.org
	  */
	public String getURL () 
	{
		return (String)get_Value(COLUMNNAME_URL);
	}
}