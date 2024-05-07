import java.util.ArrayList;

public class Hospital {
    public ArrayList<Doctor> stored_doctors = null;
    public ArrayList<Nurse> stored_nurse = null;
    public ArrayList<Patient> stored_patients = null;
    Hospital(){
        stored_doctors=new ArrayList<Doctor>();
        stored_patients = new ArrayList<Patient>();

    }
    public void out_doc(){
        for (int i = 0; i < this.stored_doctors.size(); i++) {
            System.out.println(this.stored_doctors.get(i).toString());;
        }
    }
    public void out_pat(){
        for (int i = 0; i < this.stored_patients.size(); i++) {
            System.out.println(this.stored_patients.get(i).toString());;
        }
    }
}
