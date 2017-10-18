package model;

import dao.DaoUtilisateurSql;

public class Utilisateur {
	
	DaoUtilisateurSql dao = new DaoUtilisateurSql();
	
	public String getUTI_MDP() {
		return UTI_MDP;
	}
	public void setUTI_MDP(String uTI_MDP) {
		UTI_MDP = uTI_MDP;
	}

	protected int UTI_ID;
	protected String UTI_PSEUDO;
	protected String UTI_MDP;
	protected String UTI_AVATAR;

	protected boolean UTI_CONNECTED = false;
	
	public Utilisateur(){
		
	}
	public Utilisateur(String UTI_PSEUDO, String UTI_MDP){
		this.UTI_PSEUDO = UTI_PSEUDO;
		this.UTI_MDP = UTI_MDP;
		this.UTI_AVATAR = "http://www.larousse.fr/encyclopedie/data/images/1006415-Poney.jpg";
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
	 * @param b the uTI_CONNECTED to set
	 */
	public void setUTI_CONNECTED(boolean b) {
		UTI_CONNECTED = b;
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
	
	public boolean envoyerMessage(){
		return false;
		
	}
	
	public boolean modifierMessage(){
		return false;
		
	}
	
	public boolean supprimerMessage(){
		return false;
		
	}
	
	public boolean creerSalon(String SAL_NOM, String SAL_PASSWORD, int i){
		Salon salon = new Salon(SAL_NOM, SAL_PASSWORD, this.UTI_ID);
		return false;
		
	
	}
	
	public boolean modifierSalon(){
		return false;
		
	}
	
	public boolean supprimerSalon(){
		return false;
		
	}
	
	

}
