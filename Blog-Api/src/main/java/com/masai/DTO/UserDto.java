package com.masai.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min=4,message="Username is min 4 characters")
	private String name;
	
	@Email(message="Enter Valid Email")
	private String email;
	
	@NotEmpty
	@Size(min=3,max=10,message="Password min 3 character and max 10 character")
	private String password;
	
	@NotNull
	private String about;
}
