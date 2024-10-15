package generics.task5;



public class Animals {

    public Animals() {
    }
}
   class Cat extends Animals {
        private String name;

       public Cat(String name) {
           this.name = name;
       }

       @Override
       public String toString() {
           return name;
       }
   }
