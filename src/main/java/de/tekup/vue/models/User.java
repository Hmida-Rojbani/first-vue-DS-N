package de.tekup.vue.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int id;
	
	private String name;
	
	private String password;
	
	private LocalDate dateOfBirth;
	
	private String email;

}
