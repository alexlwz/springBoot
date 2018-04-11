package com.fcloud.CICDServer.dataBean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class InstitutionInfo {
	public String institutionId;
	public String institutionName;
	public String institutionAbbr;
	public String institutionType;
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getInstitutionAbbr() {
		return institutionAbbr;
	}
	public void setInstitutionAbbr(String institutionAbbr) {
		this.institutionAbbr = institutionAbbr;
	}
	public String getInstitutionType() {
		return institutionType;
	}
	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}
	
}

