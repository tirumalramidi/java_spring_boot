package com.Section6.formValidation;

import com.Section6.formValidation.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Max(value = 10, message = "Should be less than 10")
    @Min(value = 0,message = "min value is 0")

    private Integer freePasses;

    private String postalCode;

    @CourseCode(value = "CSE", message = "must start with CSE")
//    @CourseCode
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 chars/nums")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
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
}
