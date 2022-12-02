package io.ria.nailapp.Model;

public class NailCustomerModel {
    private String fullName;
    private String email;
    private String  cellPhone;
    private String  appointmentDate;
    private int  optionOne;
    private int optionTwo;
    private int  optionThree;
    private int optionFour;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(int optionOne) {
        this.optionOne = optionOne;
    }

    public int getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(int optionTwo) {
        this.optionTwo = optionTwo;
    }

    public int getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(int optionThree) {
        this.optionThree = optionThree;
    }

    public int getOptionFour() {
        return optionFour;
    }

    public void setOptionFour(int optionFour) {
        this.optionFour = optionFour;
    }
}
