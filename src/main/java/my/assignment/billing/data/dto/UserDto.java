package my.assignment.billing.data.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bkothari on 26/05/18.
 */
public class UserDto implements Serializable {

    private String username;
    private String userType;

    private String firstName;
    private String lastName;
    private String gender;

    private String email;
    private String phone;

    private Date registrationDate;
    private Date modifiedDate;

    private boolean active;
    private boolean deleted;

    public UserDto() {}

    public UserDto(String username, String userType, String firstName, String lastName, String gender, String email, String phone, Date registrationDate, Date modifiedDate, boolean active, boolean deleted) {
        this.username = username;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.registrationDate = registrationDate;
        this.modifiedDate = modifiedDate;
        this.active = active;
        this.deleted = deleted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
