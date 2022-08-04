class Casting {
    public void castingPrint() {
        System.out.println("from Casring print method");
    }
}

class Subcasting extends Casting {
    public void subcastingPrint() {
        System.out.println("From subCastingPrint method");
    }

    public static void main(String[] args) {
        Casting c = new Casting();
        c.castingPrint();

        Subcasting sc = new Subcasting();
        sc.subcastingPrint();
            sc.castingPrint();

        Casting c2 = new Subcasting();
        c2.castingPrint();
      // c2.subCastingPrint();  NOT ACCESIBLE  

      //java.lang.ClassCastException: class Casting cannot be cast to class Subcasting
      //Subcasting subcast = (Subcasting) c;

      // DOWNCASTING
        Subcasting subcast = (Subcasting) c2;
        subcast.castingPrint();
        subcast.subcastingPrint();

        // UPCASTING
        Casting c1 = sc;
        c1.castingPrint();
        // c1.subCastingPrint(); NOT ACCESIBLE

    }
}
