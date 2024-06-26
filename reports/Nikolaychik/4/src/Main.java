public class Main {
    public static void main(String[] args) {
        System.out.println("\n1 ПРИМЕР\n");
        example_1();
        System.out.println("\n2 ПРИМЕР\n");
        example_2();
        System.out.println("\n3 ПРИМЕР\n");
        example_3();
    }
    public static void example_1(){
        Account acc1 = new Account();
        Account acc2 = new Account();
        Manager.addAccount(acc1);
        Manager.addAccount(acc2);
        acc1.refresh();
        System.out.println("\nПополнение 500\n");
        Manager.Operation_in(acc1,500);
        acc1.refresh();
        acc2.refresh();
        System.out.println("\nПеревод 250\n");
        Manager.Operation_to(acc1,250, acc2.getId());
        acc1.refresh();
        acc2.refresh();
        System.out.println("\nВывод 200\n");
        Manager.Operation_out(acc2,200);
        acc2.refresh();
    }
    public static void example_2(){
        Page page = new Page();
        page.out();
        System.out.println("\nУдаление и добавление параграфа\n");
        page.addParagraph(0,new Paragraph("ABOBA"));
        page.delParagraph(2);
        System.out.println();
        page.out();
    }
    public static void example_3(){
        Hospital hospital= new Hospital();
        hospital.stored_doctors.add(new Doctor("Koba",hospital));
        hospital.stored_doctors.add(new Doctor("Zloba",hospital));
        hospital.stored_doctors.add(new Doctor("Moba",hospital));
        hospital.stored_doctors.add(new Doctor("Zaznoba",hospital));
        hospital.stored_patients.add(new Patient("Pufik",hospital,
                hospital.stored_doctors.get(0)));
        hospital.stored_patients.add(new Patient("Aufik",hospital,
                hospital.stored_doctors.get(1)));
        hospital.stored_patients.add(new Patient("Gulfik",hospital,
                hospital.stored_doctors.get(2)));
        hospital.stored_patients.add(new Patient("Rufik",hospital,
                hospital.stored_doctors.get(3)));
        hospital.out_doc();
        hospital.out_pat();
    }
}