package com.example.registration;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity

@ToString

public class Customers {
	@Id
	
	private @Getter@Setter   int cid;
	private @Getter@Setter  String cname;
	private @Getter@Setter String cemail;
	


}
