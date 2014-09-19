/*************************************************************************************
 * Product: Spin-Suite (Making your Business Spin)                                   *
 * This program is free software; you can redistribute it and/or modify it           *
 * under the terms version 2 of the GNU General Public License as published          *
 * by the Free Software Foundation. This program is distributed in the hope          *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied        *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.                  *
 * See the GNU General Public License for more details.                              *
 * You should have received a copy of the GNU General Public License along           *
 * with this program; if not, write to the Free Software Foundation, Inc.,           *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                            *
 * For the text or an alternative of this public license, you may reach us           *
 * Copyright (C) 2012-2014 E.R.P. Consultores y Asociados, S.A. All Rights Reserved. *
 * Contributor(s): Yamel Senih www.erpconsultoresyasociados.com                      *
 *************************************************************************************/
package org.spinsuite.view.lookup;

import java.util.ArrayList;
import java.util.logging.Level;

import org.spinsuite.base.DB;
import org.spinsuite.util.DisplayLookupSpinner;
import org.spinsuite.util.DisplayType;
import org.spinsuite.util.Env;
import org.spinsuite.util.LogM;
import org.spinsuite.util.TabParameter;

import android.content.Context;
import android.database.Cursor;

/**
 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a>
 *
 */
public class Lookup {
	
	/**
	 * 
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 11/09/2014, 10:07:25
	 * @param ctx
	 * @param field
	 * @param tableAlias
	 */
	public Lookup(Context ctx, InfoField field, String tableAlias) {
		this(ctx, 0, 0, field, tableAlias);
	}
	
	/**
	 * 
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 11/09/2014, 10:08:19
	 * @param ctx
	 * @param field
	 */
	public Lookup(Context ctx, InfoField field) {
		this(ctx, 0, 0, field, null);
	}
	
	/**
	 * 
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 28/08/2014, 14:58:02
	 * @param ctx
	 * @param m_ActivityNo
	 * @param m_TabNo
	 * @param field
	 * @param tableAlias
	 */
	public Lookup(Context ctx, int m_ActivityNo, int m_TabNo, InfoField field, String tableAlias) {
		this(ctx, null, field, tableAlias);
		//	New
		m_TabParam = new TabParameter();
		m_TabParam.setActivityNo(m_ActivityNo);
		m_TabParam.setTabNo(m_TabNo);
	}
	
	/**
	 * 
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 05/09/2014, 11:43:05
	 * @param ctx
	 * @param tabParam
	 * @param field
	 * @param tableAlias
	 */
	public Lookup(Context ctx, TabParameter tabParam, InfoField field, String tableAlias) {
		this.m_field = field;
		this.ctx = ctx;
		m_Language = Env.getAD_Language(ctx);
		m_IsBaseLanguage = Env.isBaseLanguage(ctx);
		m_TabParam = tabParam;
		m_TableAlias = tableAlias;
		//	Add Alias
		if(tableAlias != null
				&& tableAlias.length() > 0) {
			ctx_lookup_value = CTX_VALUE_PREFIX + m_Language + "|" + tableAlias + "|" + m_field.SPS_Column_ID;
			ctx_lookup_has_where = CTX_HAS_WHERE + m_Language + "|" + tableAlias + "|" + m_field.SPS_Column_ID;
			ctx_lookup_info = CTX_LOOKUP_INFO_PREFIX + m_Language + "|" + tableAlias + "|" + m_field.SPS_Column_ID;
		} else {
			ctx_lookup_value = CTX_VALUE_PREFIX + m_Language + "|" + m_field.SPS_Column_ID;
			ctx_lookup_has_where = CTX_HAS_WHERE + m_Language + "|" + m_field.SPS_Column_ID;
			ctx_lookup_info = CTX_LOOKUP_INFO_PREFIX + m_Language + "|" + m_field.SPS_Column_ID;
		}
		//	Valid Null
		if(m_TabParam == null) {
			m_TabParam = new TabParameter();
			m_TabParam.setActivityNo(0);
			m_TabParam.setTabNo(0);
		}
	}
	
	/**
	 * 
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 16/09/2014, 20:12:45
	 * @param ctx
	 * @param m_SPS_Column_ID
	 * @param tableAlias
	 */
	public Lookup(Context ctx, int m_SPS_Column_ID, String tableAlias) {
		this(ctx, null, m_SPS_Column_ID, tableAlias);
	}
	
	/**
	 * With Column Identifier
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 16/09/2014, 20:10:58
	 * @param ctx
	 * @param tabParam
	 * @param m_SPS_Column_ID
	 * @param tableAlias
	 */
	public Lookup(Context ctx, TabParameter tabParam, int m_SPS_Column_ID, String tableAlias) {
		this.m_field = GridField.loadInfoColumnField(ctx, m_SPS_Column_ID);
		this.ctx = ctx;
		m_Language = Env.getAD_Language(ctx);
		m_IsBaseLanguage = Env.isBaseLanguage(ctx);
		m_TabParam = tabParam;
		m_TableAlias = tableAlias;
		//	Add Alias
		if(tableAlias != null
				&& tableAlias.length() > 0) {
			ctx_lookup_value = CTX_VALUE_PREFIX + m_Language + "|" + tableAlias + "|" + m_field.SPS_Column_ID;
			ctx_lookup_has_where = CTX_HAS_WHERE + m_Language + "|" + tableAlias + "|" + m_field.SPS_Column_ID;
			ctx_lookup_info = CTX_LOOKUP_INFO_PREFIX + m_Language + "|" + tableAlias + "|" + m_field.SPS_Column_ID;
		} else {
			ctx_lookup_value = CTX_VALUE_PREFIX + m_Language + "|" + m_field.SPS_Column_ID;
			ctx_lookup_has_where = CTX_HAS_WHERE + m_Language + "|" + m_field.SPS_Column_ID;
			ctx_lookup_info = CTX_LOOKUP_INFO_PREFIX + m_Language + "|" + m_field.SPS_Column_ID;
		}
		//	Valid Null
		if(m_TabParam == null) {
			m_TabParam = new TabParameter();
			m_TabParam.setActivityNo(0);
			m_TabParam.setTabNo(0);
		}
	}
	
	/**
	 * 
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 11/09/2014, 10:09:45
	 * @param ctx
	 * @param tabParam
	 * @param field
	 */
	public Lookup(Context ctx, TabParameter tabParam, InfoField field) {
		this(ctx, tabParam, field, null);
	}
	
	/**
	 * With Column
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 05/09/2014, 12:19:50
	 * @param ctx
	 * @param m_SPS_Column_ID
	 * @param tabParam
	 */
	public Lookup(Context ctx, int m_SPS_Column_ID, TabParameter tabParam) {
		//	Load Field
		m_field = GridField.loadInfoColumnField(ctx, m_SPS_Column_ID);
		//	Set Property
		this.ctx = ctx;
		m_Language = Env.getAD_Language(ctx);
		m_IsBaseLanguage = Env.isBaseLanguage(ctx);
		ctx_lookup_value = CTX_VALUE_PREFIX + m_Language + "|" + m_field.SPS_Column_ID;
		ctx_lookup_has_where = CTX_HAS_WHERE + m_Language + "|" + m_field.SPS_Column_ID;
		ctx_lookup_info = CTX_LOOKUP_INFO_PREFIX + m_Language + "|" + m_field.SPS_Column_ID;
		m_TabParam = tabParam;
		//	Valid Null
		if(m_TabParam == null) {
			m_TabParam = new TabParameter();
			m_TabParam.setActivityNo(0);
			m_TabParam.setTabNo(0);
		}
	}
	
	/**
	 * With Table Name and column Name for lookup manual
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 05/09/2014, 12:20:36
	 * @param ctx
	 * @param m_TableName
	 * @param m_ColumnName
	 * @param tabParam
	 */
	public Lookup(Context ctx, String m_TableName, String m_ColumnName, TabParameter tabParam) {
		//	Load Field
		m_field = GridField.loadInfoColumnField(ctx, m_TableName, m_ColumnName);
		//	Set Property
		this.ctx = ctx;
		m_Language = Env.getAD_Language(ctx);
		m_IsBaseLanguage = Env.isBaseLanguage(ctx);
		ctx_lookup_value = CTX_VALUE_PREFIX + m_Language + "|" + m_field.SPS_Column_ID;
		ctx_lookup_has_where = CTX_HAS_WHERE + m_Language + "|" + m_field.SPS_Column_ID;
		ctx_lookup_info = CTX_LOOKUP_INFO_PREFIX + m_Language + "|" + m_field.SPS_Column_ID;
		m_TabParam = tabParam;
		//	Valid Null
		if(m_TabParam == null) {
			m_TabParam = new TabParameter();
			m_TabParam.setActivityNo(0);
			m_TabParam.setTabNo(0);
		}
	}
	
	
	/**
	 * Get from Search
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 05/03/2014, 16:20:14
	 * @param ctx
	 * @param m_SPS_Table_ID
	 */
	public Lookup(Context ctx, int m_SPS_Table_ID) {
		this.m_SPS_Table_ID = m_SPS_Table_ID;
		this.ctx = ctx;
		m_Language = Env.getAD_Language(ctx);
		m_IsBaseLanguage = Env.isBaseLanguage(ctx);
		ctx_lookup_value = CTX_VALUE_PREFIX_TABLE + m_Language + "|" + m_SPS_Table_ID;
		ctx_lookup_has_where = CTX_HAS_WHERE_TABLE + m_Language + "|" + m_SPS_Table_ID;
		ctx_lookup_info = CTX_LOOKUP_INFO_PREFIX_TABLE + m_Language + "|" + m_SPS_Table_ID;
		m_TabParam = new TabParameter();
		m_TabParam.setActivityNo(0);
		m_TabParam.setTabNo(0);
	}
	
	/**	Field					*/
	private InfoField 							m_field 				= null;
	/**	Table					*/
	private int									m_SPS_Table_ID 			= 0;
	/**	Context					*/
	private Context								ctx 					= null;
	/**	Optional where clause	*/
	private String								m_OptionalWhereClause 	= null;
	/**	Validation Rule			*/
	private String 								m_ValRule				= null;
	/**	Lookup Information		*/
	private InfoLookup 							m_InfoLookup 			= null;
	/**	Is Loaded				*/
	private boolean 							m_IsLoaded				= false;
	/**	SQL						*/
	private String 								m_SQL					= null;
	/**	SQL Join				*/
	private StringBuffer						m_From					= null;
	/**	Language				*/
	private String 								m_Language 				= null;
	/**	Is Base Language		*/
	private boolean 							m_IsBaseLanguage 		= true;
	/**	Has Where				*/
	private boolean 							m_IsHasWhere			= false;
	/**	Syntax Error			*/
	private boolean 							isSyntaxError 			= false;
	/**	Display Lookup Spinner	*/
	private ArrayList<DisplayLookupSpinner> 	data 					= null;
	/**	Tab Parameter			*/
	protected TabParameter 						m_TabParam 				= null;
	/**	Table Alias				*/
	private String								m_TableAlias			= null;
	
	private String			ctx_lookup_value 		= null;
	private String 			ctx_lookup_has_where 	= null;
	private String 			ctx_lookup_info		 	= null;
	/**	Context Value Prefix	*/
	private final String	CTX_VALUE_PREFIX 				= "LK|C|";
	private final String	CTX_VALUE_PREFIX_TABLE			= "LK|T|";
	private final String	CTX_HAS_WHERE					= "LK|HW|C|";
	private final String	CTX_HAS_WHERE_TABLE				= "LK|HW|T|";
	private final String	CTX_LOOKUP_INFO_PREFIX 			= "LKI|C|";
	private final String	CTX_LOOKUP_INFO_PREFIX_TABLE	= "LKI|T|";
	private final String	MARK_WHERE						= "<MARK_WHERE>";
	
	/**	Constant to Inner	*/
	private final String 	LEFT_JOIN 					= "LEFT JOIN";
	private final String 	ON 							= "ON";
	private final String 	AND 						= "AND";
	private final String 	EQUAL 						= "=";
	private final String	POINT						= ".";
	private final String 	AS 							= "AS";
	private final String	ALIAS_PREFIX_IDENTIFIER		= "tda";
	private final String	DOC_STATUS					= "DocStatus";
	private final String	IS_ACTIVE					= "IsActive";
	
	/**
	 * Get Parsed SQL
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 23/05/2014, 15:08:05
	 * @param sql
	 * @return
	 * @return String
	 */
	private String getParsedSQL(String sql) {
		//	If Null
		if(m_OptionalWhereClause == null
				|| m_OptionalWhereClause.length() == 0)
			return sql.replaceAll(MARK_WHERE, "");
		//	Add Where
		String where = " WHERE ";
		//	Evaluate where
		if(m_IsHasWhere)
			where = " AND ";
		//	Return
		return sql.replaceAll(MARK_WHERE, where + m_OptionalWhereClause + " ");
	}
	
	/**
	 * Get SQL
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 05/03/2014, 15:31:15
	 * @return
	 * @return String
	 */
	public String getSQL() {
		//	Cache
		if(m_IsLoaded)
			return Env.parseContext(ctx, m_TabParam.getActivityNo(), m_TabParam.getTabNo(), getParsedSQL(m_SQL), false, null);
		//	
		boolean isCache = false;
		String sqlParsed = null;
		//	
		if(m_SPS_Table_ID == 0) {
			//	
			m_SQL = Env.getContext(ctx, ctx_lookup_value);
			isCache = m_SQL != null;
			//	Return Cache
			if(isCache) {
				m_IsHasWhere = Env.getContextAsBoolean(ctx, ctx_lookup_has_where);
				m_InfoLookup = (InfoLookup) Env.getContextObject(ctx, ctx_lookup_info, InfoLookup.class);
				//	From Cache Where Clause
				if(m_InfoLookup != null)
					LogM.log(ctx, getClass(), Level.FINE, "From Cache[Where Clause=" + m_InfoLookup.WhereClause + "]");
				//	Parse
				sqlParsed = getParsedSQL(m_SQL);
				//	
				LogM.log(ctx, getClass(), Level.FINE, "From Cache[SQL=" + sqlParsed + "]");
				return Env.parseContext(ctx, m_TabParam.getActivityNo(), m_TabParam.getTabNo(), sqlParsed, false, null);
			}
			//	Reload
			LogM.log(ctx, getClass(), Level.FINE, 
					"Reload Field=(" + m_field.ColumnName + ", " 
							+ m_field.DisplayType + ", " + m_field.AD_Reference_Value_ID + ")");
			//	
			if(m_field.DisplayType == DisplayType.TABLE_DIR) {
				m_SQL = loadSQLTableDirect();
				LogM.log(ctx, getClass(), Level.FINE, "SQLTableDirect=" + m_SQL);
			} else if((m_field.DisplayType == DisplayType.TABLE 
					|| m_field.DisplayType == DisplayType.SEARCH)
					&& m_field.AD_Reference_Value_ID != 0) {
				m_SQL = loadSQLTableSearch();
				LogM.log(ctx, getClass(), Level.FINE, "SQLTableSearch=" + m_SQL);
			} else if((m_field.DisplayType == DisplayType.LIST)
					&& m_field.AD_Reference_Value_ID != 0) {
				m_SQL = loadSQLList();
				LogM.log(ctx, getClass(), Level.FINE, "SQLList=" + m_SQL);
			} else {
				m_SQL = loadSQLTableDirect();
				LogM.log(ctx, getClass(), Level.FINE, "SQLTableDirectDefault=" + m_SQL);
			}
		} else {
			//	
			m_SQL = Env.getContext(ctx, ctx_lookup_value);
			isCache = m_SQL != null;
			//	Return Cache
			if(isCache) {
				m_IsHasWhere = Env.getContextAsBoolean(ctx, ctx_lookup_has_where);
				m_InfoLookup = (InfoLookup) Env.getContextObject(ctx, ctx_lookup_info, InfoLookup.class);
				//	From Cache Where Clause
				if(m_InfoLookup != null)
					LogM.log(ctx, getClass(), Level.FINE, "From Cache[Where Clause=" + m_InfoLookup.WhereClause + "]");
				//	Parse
				sqlParsed = getParsedSQL(m_SQL);
				//	
				LogM.log(ctx, getClass(), Level.FINE, "From Cache[SQL=" + sqlParsed + "]");
				return Env.parseContext(ctx, m_TabParam.getActivityNo(), m_TabParam.getTabNo(), sqlParsed, false, null);
			}
			//	
			m_SQL = loadFromTable();
			LogM.log(ctx, getClass(), Level.FINE, "SQL=" + m_SQL);
		}
		//	Set Is Loaded
		m_IsLoaded = true;
		//	Set to Cache
		Env.setContext(ctx, ctx_lookup_value, m_SQL);
		Env.setContext(ctx, ctx_lookup_has_where, m_IsHasWhere);
		Env.setContextObject(ctx, ctx_lookup_info, m_InfoLookup);
		//	Parse SQL
		sqlParsed = getParsedSQL(m_SQL);
		//	
		//	From Cache Where Clause
		if(m_InfoLookup != null)
			LogM.log(ctx, getClass(), Level.FINE, "Without Cache[Where Clause=" + m_InfoLookup.WhereClause + "]");
		//	
		LogM.log(ctx, getClass(), Level.FINE, "[SQL Without Cache=" + sqlParsed + "]");
		//	Return
		return Env.parseContext(ctx, m_TabParam.getActivityNo(), m_TabParam.getTabNo(), sqlParsed, false, null);
	}
	
	/**
	 * Get Info Lookup
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 24/03/2014, 21:00:23
	 * @return
	 * @return InfoLookup
	 */
	public InfoLookup getInfoLookup() {
		//	Get SQL
		if(m_InfoLookup == null) {
			m_InfoLookup = (InfoLookup) Env.getContextObject(ctx, ctx_lookup_info, InfoLookup.class);
			LogM.log(ctx, getClass(), Level.FINE, "[Get Lookup From Cache=" + m_InfoLookup + "]");
		}
		if(m_InfoLookup == null)
			getSQL();
		//	Load ending
		return m_InfoLookup;
	}
	
	/**
	 * Get Validation Rule
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 26/02/2014, 14:45:20
	 * @return
	 * @return String
	 */
	private String getValRule() {
		if(m_field.AD_Val_Rule_ID == 0)
			return "";
		//	Cache
		if(m_ValRule != null)
			return m_ValRule;
		//	
		String code = DB.getSQLValueString(ctx, "SELECT vr.Code " +
				"FROM AD_Val_Rule vr " +
				"WHERE AD_Val_Rule_ID = " + m_field.AD_Val_Rule_ID);
		//	Parse
		return code;
	}
	
	/**
	 * Get SQL from Table Direct
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 25/02/2014, 22:06:00
	 * @return String
	 */
	private String loadSQLTableDirect() {
		//	Instance Lookup
		m_InfoLookup = new InfoLookup();
		//	Instance join
		m_From = new StringBuffer();
		//	
		StringBuffer sql = new StringBuffer();
		StringBuffer where = new StringBuffer();
		String tableName = m_field.ColumnName.replaceAll("_ID", "");
		//	Set Info Lookup
		m_InfoLookup.TableName = tableName;
		m_InfoLookup.KeyColumn = m_field.ColumnName;
		//	Set Table Alias
		if(m_TableAlias == null
				|| m_TableAlias.length() == 0)
			m_TableAlias = tableName;
		//	
		m_InfoLookup.TableAlias = m_TableAlias;
		//	SQL
		sql.append("SELECT ").append(m_TableAlias).append(".").append(m_field.ColumnName);
		//	
		DB conn = new DB(ctx);
		DB.loadConnection(conn, DB.READ_ONLY);
		Cursor rs = null;
		//	Query
		rs = conn.querySQL("SELECT c.ColumnName, c.SPS_Column_ID, c.AD_Reference_ID " +
				"FROM SPS_Table t " +
				"INNER JOIN SPS_Column c ON(c.SPS_Table_ID = t.SPS_Table_ID) " +
				"WHERE t.TableName = ? " +
				"AND c.IsIdentifier = ? ORDER BY SeqNo", new String[]{tableName, "Y"});
		//	First
		boolean isFirst = true;
		//	Alias Identifier
		String aliasPrefix = ALIAS_PREFIX_IDENTIFIER + m_field.ColumnName;
		int aliasCount = 1;
		if(rs.moveToFirst()) {
			sql.append(", ");
			StringBuffer longColumn = new StringBuffer();
			do {
				String columnName = rs.getString(0);
				int m_SPS_Column_ID = rs.getInt(1);
				int displayType = rs.getInt(2);
				//	Is First
				if(!isFirst)
					longColumn.append("||'_'||");
				//	
				if(DisplayType.isLookup(displayType)) {
					Lookup lookup = new Lookup(ctx, m_SPS_Column_ID, aliasPrefix + aliasCount++);
					InfoLookup infoLookup = lookup.getInfoLookup();
					//	Add to Display Column
					longColumn.append(infoLookup.DisplayColumn
							.replaceAll(InfoLookup.TABLE_SEARCH_SEPARATOR, "_"));
					//	Add Join
					addJoin(m_TableAlias, lookup.getField(), infoLookup);
				} else {
					longColumn.append("COALESCE(").append(m_TableAlias).append(".").append(columnName).append(",'')");
				}
				//	Set false
				if(isFirst)
					isFirst = false;
			} while(rs.moveToNext());
			//	
			sql.append(longColumn);
			//	Set Info Lookup
			m_InfoLookup.DisplayColumn = longColumn.toString();
			m_InfoLookup.TableJoin = m_From.toString();
			//	
			//	Separator
		} else {
			sql.append(", ")
				.append(tableName).append(".").append(m_field.ColumnName);
		}
		//	Close
		DB.closeConnection(conn);
		sql.append(" FROM ").append(tableName)
				.append(" AS ").append(m_TableAlias);
		//	Add Joins
		if(m_From.length() > 0)
			sql.append(" ").append(m_From);
		
		//	Validation Rule
		if(getValRule() != null
				&& getValRule().length() > 0) {
			where.append(" WHERE ").append(getValRule());
			//	Add Mark
			m_IsHasWhere = true;
		} else {
			m_IsHasWhere = false;
		}
		//	
		m_InfoLookup.WhereClause = where.toString();
		//	
		where.append(MARK_WHERE);
		//	Add Where Clause to SQL
		sql.append(where);
		//	Return
		return sql.toString();
	}
	
	/**
	 * Get SQL from Reference Value
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 25/02/2014, 22:32:49
	 * @return String
	 */
	private String loadSQLTableSearch() {
		//	Instance Lookup
		m_InfoLookup = new InfoLookup();		
		//	
		StringBuffer sql = new StringBuffer();
		StringBuffer where = new StringBuffer();
		sql.append("SELECT ");
		DB conn = new DB(ctx);
		DB.loadConnection(conn, DB.READ_ONLY);
		Cursor rs = null;
		//	Query
		rs = conn.querySQL("SELECT t.TableName, ck.ColumnName, cd.ColumnName, " +
				"rl.IsValueDisplayed, rl.WhereClause, rl.OrderByClause " +
				"FROM AD_Ref_Table rl " +
				"INNER JOIN SPS_Table t ON(t.AD_Table_ID = rl.AD_Table_ID) " +
				"INNER JOIN SPS_Column ck ON(ck.AD_Column_ID = rl.AD_Key) " +
				"INNER JOIN SPS_Column cd ON(cd.AD_Column_ID = rl.AD_Display) " +
				"WHERE rl.AD_Reference_ID = " + m_field.AD_Reference_Value_ID, null);
		//	
		if(rs.moveToFirst()) {
			String tableName = rs.getString(0);
			String pkColumnName = rs.getString(1);
			String dColumnName = rs.getString(2);
			String isValueDisplayed = rs.getString(3);
			String whereClause = rs.getString(4);
			String orderByClause = rs.getString(5);
			//	Close
			DB.closeConnection(conn);
			//	Set Lookup Info
			m_InfoLookup.TableName = tableName;
			m_InfoLookup.KeyColumn = pkColumnName;
			//	Set Table Alias
			if(m_TableAlias == null
					|| m_TableAlias.length() == 0)
				m_TableAlias = tableName;
			//	
			m_InfoLookup.TableAlias = m_TableAlias;
			//	
			sql.append(m_TableAlias).append(".").append(pkColumnName).append(", ");
			//	Display Column
			StringBuffer longColumn = new StringBuffer();
			//	Display Value
			if(isValueDisplayed != null
					&& isValueDisplayed.equals("Y")) {
				longColumn.append("COALESCE(").append(m_TableAlias).append(".")
							.append("Value").append(", '')");
				//	
				longColumn.append("||'").append(InfoLookup.TABLE_SEARCH_SEPARATOR).append("'||");
			}
			//	Display Column
			longColumn.append("COALESCE(").append(m_TableAlias).append(".").append(dColumnName).append(",'')");
			sql.append(longColumn);
			//	Check Document Status
			int m_DocAction_ID = DB.getSQLValue(ctx, "SELECT c.SPS_Column_ID " +
										"FROM SPS_Column c " +
										"WHERE c.SPS_Table_ID = " + m_SPS_Table_ID + " " +
										"AND c.ColumnName = ?", DOC_STATUS);
			//	
			String lastColumn = IS_ACTIVE;
			//	Verify Last Column like Document status
			if(m_DocAction_ID > 0) {
				lastColumn = DOC_STATUS;
			}
			//	Add Column Last Column
			sql.append(", ").append(tableName).append(".").append(lastColumn);
			//	Set Info Lookup
			m_InfoLookup.DisplayColumn = longColumn.toString();
			//	Separator
			sql.append(" FROM ").append(tableName)
					.append(" AS ").append(m_TableAlias);
			//	Where Clause
			if(whereClause != null
					&& whereClause.length() > 0)
				where.append(" WHERE ").append(whereClause);
			//	Set Where
			//	Validation Rule
			if(getValRule() != null
					&& getValRule().length() > 0) {
				//	Add And
				if(where.length() > 0)
					where.append(" AND ");
				else
					where.append(" WHERE ");
				//	
				where.append(getValRule());
			}
			//	Add Mark Where
			if(where.length() > 0)
				m_IsHasWhere = true;
			else
				m_IsHasWhere = false;
			//	Where
			m_InfoLookup.WhereClause = where.toString();
			//	Mark
			where.append(MARK_WHERE);
			//	Set SQL
			sql.append(where);
			//	Order By Clause
			if(orderByClause != null
					&& orderByClause.length() > 0)
				sql.append(" ORDER BY ").append(orderByClause);
		}
		//	Return
		return sql.toString();
	}
	
	/**
	 * Load SQL for Reference List
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 26/02/2014, 10:54:32
	 * @return String
	 */
	private String loadSQLList() {
		//	Instance Lookup
		m_InfoLookup = new InfoLookup();
		//	Set Table Alias
		if(m_TableAlias == null
				|| m_TableAlias.length() == 0)
			m_TableAlias = "AD_Ref_List";
		
		//	Set Lookup Info
		m_InfoLookup.KeyColumn = "Value";
		m_InfoLookup.TableName = "AD_Ref_List";
		m_InfoLookup.TableAlias = m_TableAlias;
		
		//	Set SQL
		StringBuffer sql = new StringBuffer("SELECT rl.Value, ");
		//	Handle Language
		if(m_IsBaseLanguage) {
			sql.append("rl.Name ");
			//	From
			sql.append("FROM AD_Ref_List rl ");
			//	Set Lookup Info
			m_InfoLookup.DisplayColumn = "COALESCE(" + m_TableAlias + ".Name,'')";
		} else {
			sql.append("rlt.Name ");
			//	From
			sql.append("FROM AD_Ref_List rl ");
			//	Join
			sql.append("INNER JOIN AD_Ref_List_Trl rlt ON(rlt.AD_Ref_List_ID = rl.AD_Ref_List_ID " +
					"AND rlt.AD_Language = '").append(m_Language).append("') ");
			//	Set Lookup Info
			m_InfoLookup.DisplayColumn = "COALESCE(" + 
											m_TableAlias + 
											InfoLookup.TR_TABLE_SUFFIX + 
											".Name,'')";
		}
		//	Where Clause			
		sql.append("WHERE rl.AD_Reference_ID = ").append(m_field.AD_Reference_Value_ID);
		//	Validation Rule
		if(getValRule() != null
				&& getValRule().length() > 0) {
			//	Add And
			sql.append(" AND ").append(getValRule());
			//	Set Where
			m_InfoLookup.WhereClause = getValRule();
		}
		//	Add Mark
		m_IsHasWhere = true;
		sql.append(MARK_WHERE);
		//	
		sql.append(" ORDER BY 2 ");
		//	Return
		return sql.toString();
	}
	
	/**
	 * Load Sql from Table
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 05/03/2014, 16:22:06
	 * @return
	 * @return String
	 */
	private String loadFromTable() {
		//	Instance Lookup
		m_InfoLookup = new InfoLookup();
		//	Instance join
		m_From = new StringBuffer();
		//	
		StringBuffer sql = new StringBuffer();
		String tableName = null;
		DB conn = new DB(ctx);
		DB.loadConnection(conn, DB.READ_ONLY);
		Cursor rs = null;
		//	Query
		rs = conn.querySQL("SELECT t.TableName, c.ColumnName, c.SPS_Column_ID, c.AD_Reference_ID " +
				"FROM SPS_Table t " +
				"INNER JOIN SPS_Column c ON(c.SPS_Table_ID = t.SPS_Table_ID) " +
				"WHERE t.SPS_Table_ID = ? " +
				"AND c.IsIdentifier = ? " +
				"ORDER BY SeqNo", new String[]{String.valueOf(m_SPS_Table_ID), "Y"});

		boolean isFirst = true;
		if(rs.moveToFirst()) {
			tableName = rs.getString(0);
			//	Set Info Lookup
			m_InfoLookup.TableName = tableName;
			m_InfoLookup.KeyColumn = tableName + "_ID";
			//	Alias Identifier
			String aliasPrefix = ALIAS_PREFIX_IDENTIFIER + tableName;
			int aliasCount = 1;
			//	
			sql.append("SELECT ").append(tableName).append(".").append(tableName).append("_ID").append(", ");
			//	Display Type
			StringBuffer longColumn = new StringBuffer();
			do {
				String columnName = rs.getString(1);
				int m_SPS_Column_ID = rs.getInt(2);
				int displayType = rs.getInt(3);
				//	Is First
				if(!isFirst)
					longColumn.append("||'").append(InfoLookup.TABLE_SEARCH_SEPARATOR).append("'||");
				//	
				if(DisplayType.isLookup(displayType)) {
					Lookup lookup = new Lookup(ctx, m_SPS_Column_ID, aliasPrefix + aliasCount++);
					InfoLookup infoLookup = lookup.getInfoLookup();
					//	Add to Display Column
					longColumn.append(infoLookup.DisplayColumn);
					//	Add Join
					addJoin(tableName, lookup.getField(), infoLookup);
				} else {
					longColumn.append("COALESCE(").append(tableName).append(".").append(columnName).append(",'')");
				}
				//	Set false
				if(isFirst)
					isFirst = false;
			}while(rs.moveToNext());
			//	
			sql.append(longColumn);
			//	Check Document Status
			int m_DocAction_ID = DB.getSQLValue(ctx, "SELECT c.SPS_Column_ID " +
										"FROM SPS_Column c " +
										"WHERE c.SPS_Table_ID = " + m_SPS_Table_ID + " " +
										"AND c.ColumnName = ?", DOC_STATUS);
			//	
			String lastColumn = IS_ACTIVE;
			//	Verify Last Column like Document status
			if(m_DocAction_ID > 0) {
				lastColumn = DOC_STATUS;
			}
			//	Add Column Last Column
			sql.append(", ").append(tableName).append(".").append(lastColumn);
			//	Set Info Lookup
			m_InfoLookup.DisplayColumn = longColumn.toString();
			m_InfoLookup.TableJoin = m_From.toString();
			//	Separator
		}
		//	Close
		DB.closeConnection(conn);
		sql.append(" FROM ").append(tableName);
		//	Add Joins
		if(m_From.length() > 0)
			sql.append(" ").append(m_From);
		//	Optional Where
		m_IsHasWhere = false;
		m_InfoLookup.WhereClause = null;
		sql.append(MARK_WHERE);
		//	Return
		return sql.toString();
	}
	
	/**
	 * Add Join
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 16/09/2014, 21:06:48
	 * @param tableName
	 * @param linkColumn
	 * @param lookup
	 * @return void
	 */
	private void addJoin(String tableName, InfoField linkColumn, InfoLookup lookup) {
		//	Is Mandatory
		m_From.append(LEFT_JOIN).append(" ");
		//	Table Name
		m_From.append(lookup.TableName).append(" ").append(AS).append(" ").append(lookup.TableAlias).append(" ");
		//	On
		m_From.append(ON).append("(")
							.append(lookup.TableAlias).append(POINT).append(lookup.KeyColumn)
							.append(EQUAL).append(tableName).append(POINT).append(linkColumn.ColumnName);
		if(linkColumn.DisplayType == DisplayType.LIST) {
			m_From.append(" ").append(AND).append(" ")
								.append(lookup.TableAlias).append(POINT)
								.append(InfoLookup.REFERENCE_TN).append("_ID")
								.append(EQUAL).append(linkColumn.AD_Reference_Value_ID);
		}
		//	Add finish
		m_From.append(")").append(" ");
		//	Add Translation to List
		if(linkColumn.DisplayType == DisplayType.LIST
				&& !m_IsBaseLanguage) {
			m_From.append(LEFT_JOIN).append(" ");
			//	Table Name
			m_From.append(lookup.TableName).append(InfoLookup.TR_TABLE_SUFFIX).append(" ")
								.append(AS).append(" ").append(lookup.TableAlias).append(InfoLookup.TR_TABLE_SUFFIX).append(" ");
			//	On
			m_From.append(ON).append("(")
								.append(lookup.TableAlias).append(InfoLookup.TR_TABLE_SUFFIX)
								.append(POINT).append(InfoLookup.REF_LIST_TN).append("_ID")
								.append(EQUAL).append(lookup.TableAlias)
								.append(POINT).append(InfoLookup.REF_LIST_TN).append("_ID ")
								.append(AND).append(" ").append(lookup.TableAlias).append(InfoLookup.TR_TABLE_SUFFIX)
								.append(POINT).append(InfoLookup.AD_LANGUAGE_CN)
								.append(EQUAL).append("'").append(m_Language).append("'").append(")").append(" ");
		}
	}
	
	/**
	 * Set Optional where clause
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 13/03/2014, 22:24:26
	 * @param whereClause
	 * @return void
	 */
	public void setCriteria(String whereClause) {
		m_OptionalWhereClause = whereClause;
		m_IsLoaded = false;
	}

	/**
	 * Load Data
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 19/05/2014, 09:44:09
	 * @return void
	 */
	public void load() {
		load(true);
	}
	
	/**
	 * 
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 19/05/2014, 08:40:36
	 * @param reQuery
	 * @return void
	 */
	public void load(boolean reQuery) {
		//	Is Syntax Error
		if(isSyntaxError)
			return;
		try{
			//	Cache
			if(!reQuery
					&& data != null) {
				//	Set Adapter
				//if(v_Spinner.getAdapter() == null)
					//setAdapter(v_Spinner);
				return;
			}
			//	
			DB conn = new DB(ctx);
			//	
			DB.loadConnection(conn, DB.READ_ONLY);
			Cursor rs = null;
			//	Query
			rs = conn.querySQL(getSQL()
					.replaceAll(InfoLookup.TABLE_SEARCH_SEPARATOR, "_"), null);
			data = new ArrayList<DisplayLookupSpinner>();
			if(rs.moveToFirst()) {
				if(!m_field.IsMandatory) {
					if(m_field.DisplayType == DisplayType.LIST)
						data.add(new DisplayLookupSpinner(null, null));
					else
						data.add(new DisplayLookupSpinner(-1, null));
				}
				//	Loop
				do{
					if(m_field.DisplayType == DisplayType.LIST)
						data.add(new DisplayLookupSpinner(rs.getString(0), rs.getString(1)));
					else
						data.add(new DisplayLookupSpinner(rs.getInt(0), rs.getString(1)));
				}while(rs.moveToNext());
			}
			//	Close
			DB.closeConnection(conn);
		} catch(Exception e) {
			isSyntaxError = true;
			data = new ArrayList<DisplayLookupSpinner>();
			LogM.log(ctx, getClass(), Level.SEVERE, "Error in Load", e);
		}
	}
	
	/**
	 * Is Syntax Error
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 16/03/2014, 11:36:25
	 * @return
	 * @return boolean
	 */
	public boolean isSyntaxError() {
		return isSyntaxError;
	}
	
	/**
	 * Return Data Loaded
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 05/09/2014, 11:29:41
	 * @return
	 * @return ArrayList<DisplayLookupSpinner>
	 */
	public ArrayList<DisplayLookupSpinner> getData() {
		return data;
	}
	
	/**
	 * Get Field
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 05/09/2014, 11:39:13
	 * @return
	 * @return InfoField
	 */
	public InfoField getField() {
		return m_field;
	}
	
	/**
	 * Get Tab Parameter
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 05/09/2014, 11:54:05
	 * @return
	 * @return TabParameter
	 */
	public TabParameter getTabParameter() {
		return m_TabParam;
	}
	
	/**
	 * Get Validation
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 05/09/2014, 11:59:07
	 * @return
	 * @return String
	 */
	public String getValidation() {
		getInfoLookup();
		if(m_InfoLookup != null)
			return m_InfoLookup.WhereClause;
		//	Default
		return null;
	}
	
	@Override
	public String toString() {
		return "LookupDisplayType [m_field=" + m_field + ", m_SPS_Table_ID="
				+ m_SPS_Table_ID + ", ctx=" + ctx + ", m_optionalWhereClause="
				+ m_OptionalWhereClause + ", m_InfoLookup=" + m_InfoLookup
				+ ", m_IsLoaded=" + m_IsLoaded + ", m_SQL=" + m_SQL + "]";
	}
}