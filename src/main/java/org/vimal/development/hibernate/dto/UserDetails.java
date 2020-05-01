package org.vimal.development.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.hibernate.annotations.Type;

@Entity (name = "User_Details")
public class UserDetails {
	
	@Id 
	@Column (name = "UserId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column (name = "User_Name")
	private String userName;
	
//	@Embedded
//	private Address address;
	
	@ElementCollection
	@JoinTable(name = "User_Address",
			   joinColumns = @JoinColumn(name = "USER_ID")
	)						
	
	@GenericGenerator(name = "sequence_gen", strategy = "sequence")
	@CollectionId (columns = {@Column(name = "Address_Id")}, generator = "sequence_gen", type = @Type(type = "long"))
	private Collection<Address> addressList = new ArrayList();
	
	
	
public Collection<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(Collection<Address> addressList) {
		this.addressList = addressList;
	}
	//	private Set<Address> addressList = new HashSet<Address>();
//	public Set<Address> getAddressList() {
//		return addressList;
//	}
//	public void setAddressList(Set<Address> addressList) {
//		this.addressList = addressList;
//	}
	//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	public int getId() {
		return id;
	}
//	public List<Address> getAddressList() {
//		return addressList;
//	}
//	public void setAddressList(List<Address> addressList) {
//		this.addressList = addressList;
//	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
