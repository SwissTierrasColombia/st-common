package com.ai.st.microservice.common.dto.notifier;

import java.io.Serializable;
import java.util.Date;

public class MicroserviceNotificationLoadOfInputsDto implements Serializable {

	private static final long serialVersionUID = 3050930525504636650L;

	private Long userCode;
	private String email;
	private String type;
	private int status;
	private boolean loadStatus;
	private String mpio;
	private String dpto;
	private String requestNumber;
	private Date loadDate;
	private String supportFile;

	public MicroserviceNotificationLoadOfInputsDto() {

	}

	public Long getUserCode() {
		return userCode;
	}

	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMpio() {
		return mpio;
	}

	public void setMpio(String mpio) {
		this.mpio = mpio;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String getSupportFile() {
		return supportFile;
	}

	public void setSupportFile(String supportFile) {
		this.supportFile = supportFile;
	}

	public boolean isLoadStatus() {
		return loadStatus;
	}

	public void setLoadStatus(boolean loadStatus) {
		this.loadStatus = loadStatus;
	}

	public String getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}

	public Date getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Date loadDate) {
		this.loadDate = loadDate;
	}

	public String getSubject() {
		return "Notificación Sistema de Transición Barrido Predial – Cargue de Insumo XTF";
	}

}
