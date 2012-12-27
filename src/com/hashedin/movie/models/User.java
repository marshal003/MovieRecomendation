package com.hashedin.movie.models;

public class User {
int UserId;
int Age;
char Gender;
String Occupation;
int zipCode;

public User()
{
	
}
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public char getGender() {
	return Gender;
}
public void setGender(char gender) {
	Gender = gender;
}
public String getOccupation() {
	return Occupation;
}
public void setOccupation(String occupation) {
	Occupation = occupation;
}
public int getZip_code() {
	return zipCode;
}
public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}
public User(int userId, int age, char gender, String occupation, int zip_code) {
	super();
	UserId = userId;
	Age = age;
	Gender = gender;
	Occupation = occupation;
	this.zipCode = zip_code;
}
@Override
public String toString() {
	return "User [UserId=" + UserId + ", Age=" + Age + ", Gender=" + Gender
			+ ", Occupation=" + Occupation + ", zipCode=" + zipCode + "]";
}

}
