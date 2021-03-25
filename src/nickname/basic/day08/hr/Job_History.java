package nickname.basic.day08.hr;

public class Job_History {

    private int employee_id;
    private String start_date;
    private String end_date;
    private String job_id;
    private int department_id;

    public Job_History(int employee_id, String start_date, String end_date, String job_id, int department_id) {
        this.employee_id = employee_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.job_id = job_id;
        this.department_id = department_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
