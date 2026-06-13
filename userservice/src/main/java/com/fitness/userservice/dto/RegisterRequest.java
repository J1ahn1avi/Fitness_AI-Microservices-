package com.fitness.userservice.dto;

import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
	
	@NotBlank(message="Email is required")
	@Email(message="Invalid Email")
	private String email;
	
	@NotBlank(message="Password is required")
	@Size(min=6, message="Password must be atleast 6 charactors")
	
	private String password;
	private String firstName;
	private String lastName;
	@Override
	public String toString() {
		return "RegisterRequest [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public RegisterRequest(@NotBlank(message = "Email is required") @Email(message = "Invalid Email") String email,
			@NotBlank(message = "Password is required") @Size(min = 6, message = "Password must be atleast 6 charactors") String password,
			String firstName, String lastName) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public RegisterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterRequest other = (RegisterRequest) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password);
	}
	public String getKeycloakId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}