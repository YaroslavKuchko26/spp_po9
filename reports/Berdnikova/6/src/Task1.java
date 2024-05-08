 interface Coffee {
        void prepare();
    }

    class Americano implements Coffee {
        @Override
        public void prepare() {
            System.out.println("Американо готово!");
        }
    }

    class Latte implements Coffee {
        @Override
        public void prepare() {
            System.out.println("Латте готово!");
        }
    }

    class Cappuccino implements Coffee {
        @Override
        public void prepare() {
            System.out.println("Капуччино готово!");
        }
    }

    class Espresso implements Coffee {
        @Override
        public void prepare() {
            System.out.println("Эспрессо готово!");
        }
    }

    class Macchiato implements Coffee {
        @Override
        public void prepare() {
            System.out.println("Макиато готово!");
        }
    }

    interface CoffeeAbstractFactory {
        Coffee createCoffee();
    }

    class AmericanoFactory implements CoffeeAbstractFactory {
        @Override
        public Coffee createCoffee() {
            return new Americano();
        }
    }

    class LatteFactory implements CoffeeAbstractFactory {
        @Override
        public Coffee createCoffee() {
            return new Latte();
        }
    }

    class CappuccinoFactory implements CoffeeAbstractFactory {
        @Override
        public Coffee createCoffee() {
            return new Cappuccino();
        }
    }

    class EspressoFactory implements CoffeeAbstractFactory {
        @Override
        public Coffee createCoffee() {
            return new Espresso();
        }
    }

    class MacchiatoFactory implements CoffeeAbstractFactory {
        @Override
        public Coffee createCoffee() {
            return new Macchiato();
        }
    }

    public class Task1 {
        public static void main(String[] args) {

            CoffeeAbstractFactory americanoFactory = new AmericanoFactory();
            CoffeeAbstractFactory latteFactory = new LatteFactory();
            CoffeeAbstractFactory cappuccinoFactory = new CappuccinoFactory();
            CoffeeAbstractFactory espressoFactory = new EspressoFactory();
            CoffeeAbstractFactory macchiatoFactory = new MacchiatoFactory();

            Coffee americano = americanoFactory.createCoffee();
            americano.prepare();

            Coffee latte = latteFactory.createCoffee();
            latte.prepare();

            Coffee cappuccino = cappuccinoFactory.createCoffee();
            cappuccino.prepare();

            Coffee espresso = espressoFactory.createCoffee();
            espresso.prepare();

            Coffee macchiato = macchiatoFactory.createCoffee();
            macchiato.prepare();
        }
    }
