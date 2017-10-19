package model;

import java.sql.SQLException;

import dao.DB;
import dao.DaoSalonSql;
import dao.DaoUtilisateurSql;
import main.Io;
import main.Main;

public class Salon {

	protected int SAL_ID;
	protected String SAL_NAME;
	protected String SAL_MDP = "";
	protected int SAL_CREATEUR_ID;
	DaoSalonSql dao = new DaoSalonSql();
	public Salon(){
		
	}
	
	public Salon(String SAL_NAME, String SAL_MDP, int SAL_CREATEUR_ID){
		this.SAL_NAME = SAL_NAME;
		this.SAL_MDP = SAL_MDP;
		this.SAL_CREATEUR_ID = SAL_CREATEUR_ID;
	}

	/**
	 * @return the sAL_ID
	 */
	public int getSAL_ID() {	
		return SAL_ID;
	}

	/**
	 * @param sAL_ID the sAL_ID to set
	 */
	public void setSAL_ID(int sAL_ID) {
		SAL_ID = sAL_ID;
	}

	/**
	 * @return the sAL_NAME
	 */
	public String getSAL_NAME() {
		return SAL_NAME;
	}

	/**
	 * @param sAL_NAME the sAL_NAME to set
	 */
	public void setSAL_NAME(String sAL_NAME) {
		SAL_NAME = sAL_NAME;
	}

	/**
	 * @return the sAL_MDP
	 */
	public String getSAL_MDP() {
		return SAL_MDP;
	}

	/**
	 * @param sAL_MDP the sAL_MDP to set
	 */
	public void setSAL_MDP(String sAL_MDP) {
		SAL_MDP = sAL_MDP;
	}

	/**
	 * @return the sAL_CREATEURID
	 */
	public int getSAL_CREATEUR_ID() {
		return SAL_CREATEUR_ID;
	}

	/**
	 * @param sAL_CREATEURID the sAL_CREATEURID to set
	 */
	public void setSAL_CREATEUR_ID(int sAL_CREATEUR_ID) {
		SAL_CREATEUR_ID = sAL_CREATEUR_ID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Salon [SAL_ID=" + SAL_ID + ", SAL_NAME=" + SAL_NAME + ", SAL_MDP=" + SAL_MDP + ", SAL_CREATEURID="
				+ SAL_CREATEUR_ID + "]";
	}
	public Salon existe() throws SQLException {
		// TODO Auto-generated method stub
		DaoSalonSql dao = new DaoSalonSql();
		return dao.getByIdentifiants(Main.getDb(), this.SAL_NAME, this.SAL_MDP);
	}
	
}
