package model;

public class Utilisateur {
	
	protected int UTI_ID;
	protected String UTI_PSEUDO;
	protected String UTI_AVATAR;
	protected boolean UTI_CONNECTED = false;
	
	public Utilisateur(){
		
	}

	/**
	 * @return the uTI_ID
	 */
	public int getUTI_ID() {
		return UTI_ID;
	}

	/**
	 * @param uTI_ID the uTI_ID to set
	 */
	public void setUTI_ID(int uTI_ID) {
		UTI_ID = uTI_ID;
	}

	/**
	 * @return the uTI_PSEUDO
	 */
	public String getUTI_PSEUDO() {
		return UTI_PSEUDO;
	}

	/**
	 * @param uTI_PSEUDO the uTI_PSEUDO to set
	 */
	public void setUTI_PSEUDO(String uTI_PSEUDO) {
		UTI_PSEUDO = uTI_PSEUDO;
	}

	/**
	 * @return the uTI_AVATAR
	 */
	public String getUTI_AVATAR() {
		return UTI_AVATAR;
	}

	/**
	 * @param uTI_AVATAR the uTI_AVATAR to set
	 */
	public void setUTI_AVATAR(String uTI_AVATAR) {
		UTI_AVATAR = uTI_AVATAR;
	}

	/**
	 * @return the uTI_CONNECTED
	 */
	public boolean isUTI_CONNECTED() {
		return UTI_CONNECTED;
	}

	/**
	 * @param uTI_CONNECTED the uTI_CONNECTED to set
	 */
	public void setUTI_CONNECTED(boolean uTI_CONNECTED) {
		UTI_CONNECTED = uTI_CONNECTED;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utilisateur [UTI_ID=" + UTI_ID + ", UTI_PSEUDO=" + UTI_PSEUDO + ", UTI_AVATAR=" + UTI_AVATAR
				+ ", UTI_CONNECTED=" + UTI_CONNECTED + "]";
	}
	
	
	public boolean inscription(){
		return false;
		
	}
	
	public boolean modifierProfil(){
		return false;
		
	}
	
	public boolean seConnecter(){
		return false;
	}
	
	public boolean seDeconnecter(){
		return false;
	}
	
	public boolean ecrireMessage(){
		return false;
		
	}
	
	public boolean modifierMessage(){
		return false;
		
	}
	
	public boolean supprimerMessage(){
		return false;
		
	}
	
	public boolean creerSalon(){
		return false;
		
	
	}
	
	public boolean modifierSalon(){
		return false;
		
	}
	
	public boolean supprimerSalon(){
		return false;
		
	}
	
	

}
