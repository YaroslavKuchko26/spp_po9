import java.util.ArrayList;

public class Nurse extends Mensch {
    Hospital hospital;
    int id;
    Nurse(String name, Hospital hospital,int age){
        super(name,age);
        this.name=name;
        this.hospital=hospital;
        this.id=0;
        hospital.stored_nurse.add(this);
        if(hospital.stored_nurse==null){
            hospital.stored_nurse= new ArrayList<Nurse>();
        }
        boolean flag=true;
        for (int i=1;this.id==0;i++){
            flag=true;
            for(int j=0;j<hospital.stored_nurse.size();j++){
                if(hospital.stored_nurse.get(j).id == i)
                {
                    flag=false;
                }
            }
            if(flag) {
                this.id = i;
            }
        }
    }

    void Set_ukol(Patient patient){
        System.out.println(patient.toString());
        System.out.println("УКОЛОТ");
    }
    void Cure(Patient patient){
        for(int j=0;j<patient.hospital.stored_patients.size();j++){
            if(patient.hospital.stored_patients.get(j).id == patient.id)
            {
                patient.hospital.stored_patients.remove(j);
            }
        }

    }
    public String toString(){
        return "NURSE\n" +
                "id: "+this.id + '\n' +
                "name: "+this.name + "\n\n";
    }
}
