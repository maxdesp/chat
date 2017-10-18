package model;

public class Salon {

	protected int SAL_ID;
	protected String SAL_NAME;
	protected String SAL_MDP;
	protected int SAL_CREATEUR_ID;
	
	public Salon(){
		
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
}
