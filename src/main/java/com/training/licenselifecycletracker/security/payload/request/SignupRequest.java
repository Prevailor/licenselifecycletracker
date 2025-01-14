package com.training.licenselifecycletracker.security.payload.request;



import com.training.licenselifecycletracker.entities.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignupRequest {
	@NotBlank
	@Size(min = 3, max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	private Role role;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;
	
	@NotBlank
	@Size(max = 10)
	private String mobile;
	
	@NotBlank
	@Size(max = 220)
	private String address;
	@NotBlank
	@Size(max = 11)
	private String gender;

}