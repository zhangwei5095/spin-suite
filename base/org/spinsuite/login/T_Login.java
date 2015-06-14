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
 * Copyright (C) 2012-2015 E.R.P. Consultores y Asociados, S.A. All Rights Reserved. *
 * Contributor(s): Yamel Senih www.erpcya.com                                        *
 *************************************************************************************/
package org.spinsuite.login;


import java.util.logging.Level;

import org.spinsuite.base.DB;
import org.spinsuite.base.R;
import org.spinsuite.interfaces.I_Login;
import org.spinsuite.util.Env;
import org.spinsuite.util.LogM;
import org.spinsuite.util.Msg;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * 
 * @author Yamel Senih, ysenih@erpcya.com, ERPCyA http://www.erpcya.com Feb 26, 2015, 11:51:10 PM
 *	<li> Login Correct
 * 	@see https://adempiere.atlassian.net/browse/SPIN-2
 */
public class T_Login extends Fragment implements I_Login {
	/**	Login User					*/
	private EditText 		et_User;
	/**	Login Pass					*/
	private EditText 		et_Pass;
	/**	Current View				*/
	private View 			m_View = null;
	/**	Is Load Ok					*/
	private boolean			m_IsLoadOk = false;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //	Current
    	if(m_View != null)
        	return m_View;
        //	RE-Load
        m_View = inflater.inflate(R.layout.t_pref_login, container, false);
    	return m_View;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	super.onActivityCreated(savedInstanceState);
    	if(m_IsLoadOk)
    		return;
    	//	
    	et_User = (EditText) 			m_View.findViewById(R.id.et_User);
    	et_Pass = (EditText) 			m_View.findViewById(R.id.et_Pass);
		m_IsLoadOk = true;
    }
    
    /**
     * Valid User and Password
     * @author Yamel Senih, ysenih@erpcya.com, ERPCyA http://www.erpcya.com
     * @return
     * @return boolean
     */
    private boolean validUser() {
    	String user = et_User.getText().toString().trim();
    	String pass = et_Pass.getText().toString().trim();
    	if(user != null && user.length() > 0){
    		if(pass != null && pass.length() > 0){
    			Env.setContext("#SUser", user);
    			Env.setContext("#AD_User_Name", user);
    			Env.setContext("#SPass", pass);
    			if(!Env.isEnvLoad())
    				return true;
    			else if(findUser(user, pass)) {
    				return true;
    			} else {
    				Msg.alertMsg(this.getActivity(), 
    						getResources().getString(R.string.msg_UserPassDoNotMatch));
    			}
    		} else {
    			Msg.alertMustFillField(this.getActivity(), R.string.Pass, et_Pass);
    		}
    	} else {
    		Msg.alertMustFillField(this.getActivity(), R.string.User, et_User);
    	}
    	return false;
    }
    
    /**
     * Find User on database
     * @author Yamel Senih, ysenih@erpcya.com, ERPCyA http://www.erpcya.com
     * @param user
     * @param pass
     * @return
     * @return boolean
     */
    private boolean findUser(String user, String pass){
    	boolean ok = false;
    	try {
    		DB con = new DB(this.getActivity());
        	con.openDB(DB.READ_ONLY);
        	String sql = "SELECT u.AD_User_ID " +
        			"FROM AD_User u " +
        			"WHERE u.Name = ? AND u.PassWord = ?";
        	Cursor rs = con.querySQL(sql, new String[]{user, pass});
        	//
        	if(rs.moveToFirst()){
        		Env.setAD_User_ID(rs.getInt(0));
        		Env.setIsLogin(true);
        		ok = true;
        	} else {
        		Env.setIsLogin(false);
        	}
        	con.closeDB(rs);
    	} catch(Exception e) {
    		LogM.log(getActivity(), getClass(), Level.SEVERE, "Error", e);
    	}
    	return ok;
    }
    
    /**
     * Valid Exit
     * @author Yamel Senih, ysenih@erpcya.com, ERPCyA http://www.erpcya.com
     * @return
     * @return boolean
     */
    private boolean validExit() {
    	return true;
    }
    
    @Override
    public void onStart() {
    	super.onStart();
    	//	Load Data
    	loadData();
    }
    
	@Override
	public boolean aceptAction() {
		return validUser();
	}

	@Override
	public boolean cancelAction() {
		return validExit();
	}

	@Override
	public boolean loadData() {
		String user = et_User.getText().toString();
     	String pass = et_Pass.getText().toString();
     	//boolean isSavePass = ch_SavePass.isChecked();
     	if(user == null || user.length() == 0){
     		user = Env.getContext("#SUser");
     		if(user != null)
     			et_User.setText(user);
     	}
     	//	Save Pass
     	if(Env.isSavePass()){
     		pass = Env.getContext("#SPass");
     		if(pass != null)
     			et_Pass.setText(pass);
		}
 		//	
		return true;
	}

	@Override
	public void setEnabled(boolean enabled) {
		if(!m_IsLoadOk)
			return;
		et_User.setEnabled(enabled);
    	et_Pass.setEnabled(enabled);
	}
}
