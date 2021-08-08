package hu.ulyssys.java.course.maven.rest.model;

public class CarModel extends CoreRestModel{
    private String licensePlateNumber;
    private Integer doorNumbers;

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public Integer getDoorNumbers() {
        return doorNumbers;
    }

    public void setDoorNumbers(Integer doorNumbers) {
        this.doorNumbers = doorNumbers;
    }
}
