import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;

public class StudentAttributes implements Serializable {
    private String sName;
    private int sId;
    private String sGender;
    private String sAgeGroup;
    private String sHobbies;


    public StudentAttributes(String sName, int sId, String sGender, String sAgeGroup, String sHobbies) {
        this.sName = sName;
        this.sId = sId;
        this.sGender = sGender;
        this.sAgeGroup = sAgeGroup;
        this.sHobbies = sHobbies;
    }

    public StudentAttributes(int sId, String sName, String sGender) {
        this.sName = sName;
        this.sId = sId;
        this.sGender = sGender;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsGender() {
        return sGender;
    }

    public void setsGender(String sGender) {
        this.sGender = sGender;
    }

    public String getsAgeGroup() {
        return sAgeGroup;
    }

    public void setsAgeGroup(String sAgeGroup) {
        this.sAgeGroup = sAgeGroup;
    }

    public String getsHobbies() {
        return sHobbies;
    }

    public void setsHobbies(String sHobbies) {
        this.sHobbies = sHobbies;
    }



    @Override
    public String toString() {
        return "Student Name: " + sName + " | " +
                "Student Id: " + sId + " | " +
                "Gender: " + sGender + " | " +
                "Age Group: " + sAgeGroup + " | " +
                "Hobbies: "+ sHobbies + " | ";
    }
}
