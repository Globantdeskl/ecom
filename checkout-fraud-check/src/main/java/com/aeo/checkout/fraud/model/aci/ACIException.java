package com.aeo.checkout.fraud.model.aci;

public class ACIException extends Exception {

	private static final long serialVersionUID = -6116152382884776402L;
	private Throwable mAciFailureCause;

	/**
	 * @return Returns the ACI Failure Cause.
	 */
	public Throwable getAciFailureCause() {
		return mAciFailureCause;
	}

	/**
	 * 
	 */
	public ACIException() {
		super();
	}

	/**
	 * @param pMessage
	 */
	public ACIException(String pMessage) {
		super(pMessage);
	}

	/**
	 * @param pCause
	 */
	public ACIException(Throwable pCause) {
		mAciFailureCause = pCause;
	}

	/**
	 * @param pMessage
	 * @param pCause
	 */
	public ACIException(String pMessage, Throwable pCause) {
		super(pMessage);
		mAciFailureCause = pCause;
	}

	/**
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		Throwable cause = getAciFailureCause();
		if(cause != null){
			StringBuffer sb = new StringBuffer(super.toString());
			sb.append("; AciFailureCause=" + cause.toString());
			return sb.toString();
		} else{
			return super.toString();
		}
	}
}
