package Modele;

import java.sql.Date;

public class Message {
	
	protected int MES_ID;
	protected int MES_UTI_ID;
	protected String MES_MESSAGE;
	protected Date MES_DATE;
	protected int MES_SAL_ID;
	
	public Message(){
		
	}

	/**
	 * @return the mES_ID
	 */
	public int getMES_ID() {
		return MES_ID;
	}

	/**
	 * @param mES_ID the mES_ID to set
	 */
	public void setMES_ID(int mES_ID) {
		MES_ID = mES_ID;
	}

	/**
	 * @return the mES_UTI_ID
	 */
	public int getMES_UTI_ID() {
		return MES_UTI_ID;
	}

	/**
	 * @param mES_UTI_ID the mES_UTI_ID to set
	 */
	public void setMES_UTI_ID(int mES_UTI_ID) {
		MES_UTI_ID = mES_UTI_ID;
	}

	/**
	 * @return the mES_MESSAGE
	 */
	public String getMES_MESSAGE() {
		return MES_MESSAGE;
	}

	/**
	 * @param mES_MESSAGE the mES_MESSAGE to set
	 */
	public void setMES_MESSAGE(String mES_MESSAGE) {
		MES_MESSAGE = mES_MESSAGE;
	}

	/**
	 * @return the mES_DATE
	 */
	public Date getMES_DATE() {
		return MES_DATE;
	}

	/**
	 * @param mES_DATE the mES_DATE to set
	 */
	public void setMES_DATE(Date mES_DATE) {
		MES_DATE = mES_DATE;
	}

	/**
	 * @return the mES_SAL_ID
	 */
	public int getMES_SAL_ID() {
		return MES_SAL_ID;
	}

	/**
	 * @param mES_SAL_ID the mES_SAL_ID to set
	 */
	public void setMES_SAL_ID(int mES_SAL_ID) {
		MES_SAL_ID = mES_SAL_ID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [MES_ID=" + MES_ID + ", MES_UTI_ID=" + MES_UTI_ID + ", MES_MESSAGE=" + MES_MESSAGE
				+ ", MES_DATE=" + MES_DATE + ", MES_SAL_ID=" + MES_SAL_ID + "]";
	}
}
