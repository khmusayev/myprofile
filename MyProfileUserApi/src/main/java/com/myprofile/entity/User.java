package com.myprofile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@NamedEntityGraph(
//		name="user-entity-graph",
//		attributeNodes = {
//				@NamedAttributeNode("userEdus")
//		}
//)
@Entity
@NoArgsConstructor
@Getter @Setter
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UserJob> userJobs = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UserEducation> userEdus = new HashSet<>();
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserContact userContact;
	
	public void setUserContact(UserContact contact) {
		if (contact == null) {
            if (getUserContact() != null) {
                getUserContact().setUser(null);
            }
        }
        else {
            contact.setUser(this);
        }
        this.userContact = contact;
    }

}
