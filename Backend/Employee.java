import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private int eid;
    private String ename;
    private Date dob;
    private String email;
    private String mobile;
    private double salary;
    private String dept;
    private String address;
    private String adhaarCard;
    private String companyName;
    private Date joinDate;

    // Constructor
    public Employee(int eid, String ename, Date dob, String email, String mobile, double salary,
                    String dept, String address, String adhaarCard, String companyName, Date joinDate) {
        this.eid = eid;
        this.ename = ename;
        this.dob = dob;
        this.email = email;
        this.mobile = mobile;
        this.salary = salary;
        this.dept = dept;
        this.address = address;
        this.adhaarCard = adhaarCard;
        this.companyName = companyName;
        this.joinDate = joinDate;
    }

    // Getters
    public int getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public Date getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public double getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }

    public String getAddress() {
        return address;
    }

    public String getAdhaarCard() {
        return adhaarCard;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                ", address='" + address + '\'' +
                ", adhaarCard='" + adhaarCard + '\'' +
                ", companyName='" + companyName + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }
}