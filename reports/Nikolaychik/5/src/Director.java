public class Director implements Employee{
    int age = 0;
    String name = null;
    float money = 0;
    float mood = 0;
    String type="director";
    Director(int age,String name,float money,float mood){
        this.mood=mood;
        this.age=age;
        this.money=money;
        this.name=name;
    }
    @Override
    public void interacted(String type, float cost){
        if(type.equals("director")){
            this.money+=cost/4;
            this.mood-=cost/4;
        }
        else{
            this.money+=cost*3/4;
            this.mood+=cost/2;
        }
    }
    @Override
    public void Interaction(Employee employee, float cost){
        employee.interacted(type,cost);
        this.money+=cost*3/4;
        this.mood+=cost/2;
    }
    public void out(){
        System.out.println("age: " + age);
        System.out.println("name: " +name);
        System.out.println("money: " +money);
        System.out.println("mood: " +mood);
        System.out.println();
    }
}
