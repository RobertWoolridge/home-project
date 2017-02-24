package rjw.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints= @UniqueConstraint(columnNames = {"name"}))
public class ApplicationType {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long uid;
	
	@Column(nullable=false)
	private String name;
	
	private boolean multiClient;
	
	private boolean multiRolePerUser;
	
	public ApplicationType() {
		
	}
	
	public ApplicationType(String name, boolean isMultiClient, boolean isMutiRolePerUser) {
		setName(name);
		setMultiClient(isMultiClient);
		setMultiRolePerUser(isMutiRolePerUser);
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMultiClient() {
		return multiClient;
	}

	public void setMultiClient(boolean multiClient) {
		this.multiClient = multiClient;
	}

	public boolean isMultiRolePerUser() {
		return multiRolePerUser;
	}

	public void setMultiRolePerUser(boolean multiRolePerUser) {
		this.multiRolePerUser = multiRolePerUser;
	}
}
