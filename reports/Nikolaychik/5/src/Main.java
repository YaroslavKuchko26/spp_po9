import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        //new Ex_1();
        new Ex_2();
        //example_3();

    }
    public static void example_3(){
        Hospital hospital= new Hospital();
        hospital.stored_doctors.add(new Doctor("Koba",hospital,34));
        hospital.stored_doctors.add(new Doctor("Zloba",hospital,213));
        hospital.stored_doctors.add(new Doctor("Moba",hospital,56));
        hospital.stored_doctors.add(new Doctor("Zaznoba",hospital,37));
        hospital.stored_patients.add(new Patient("Pufik",hospital,
                hospital.stored_doctors.get(0),23));
        hospital.stored_patients.add(new Patient("Aufik",hospital,
                hospital.stored_doctors.get(1),45));
        hospital.stored_patients.add(new Patient("Gulfik",hospital,
                hospital.stored_doctors.get(2),12));
        hospital.stored_patients.add(new Patient("Rufik",hospital,
                hospital.stored_doctors.get(3),89));

        hospital.stored_nurse.add(new Nurse("Rufik",hospital, 56));

        hospital.stored_nurse.get(0).Set_ukol(hospital.stored_patients.get(2));

        hospital.out_doc();
        hospital.out_pat();
    }
}