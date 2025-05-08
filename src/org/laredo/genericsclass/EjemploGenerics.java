package org.laredo.genericsclass;

public class EjemploGenerics {

    public static <T> void imprimirCamion(Camion<T> camion){
        for (T a : camion) {
            if(a instanceof Animal) {
                System.out.println(((Animal)a).getNombre() + ", tipo: " +((Animal)a).getTipo());
            } else if (a instanceof Automovil) {
                System.out.println(((Automovil)a).getMarca());
            } else if (a instanceof Maquinaria) {
                System.out.println(((Maquinaria)a).getTipo());
            }
        }

    }

    public static void main(String[] args) {
        Camion<Animal> trasporteCaballos = new Camion<>(5);
        trasporteCaballos.add(new Animal("peregrino", "caballo"));
        trasporteCaballos.add(new Animal("grillo", "caballo"));
        trasporteCaballos.add(new Animal("tunquen", "caballo"));
        trasporteCaballos.add(new Animal("topocalma", "caballo"));
        trasporteCaballos.add(new Animal("longotoma", "caballo"));

        imprimirCamion(trasporteCaballos);

        System.out.println();

        Camion<Maquinaria> trasporteMaquinaria = new Camion<>(3);
        trasporteMaquinaria.add(new Maquinaria("tractor"));
        trasporteMaquinaria.add(new Maquinaria("perforadora"));
        trasporteMaquinaria.add(new Maquinaria("aplanadora"));

        imprimirCamion(trasporteMaquinaria);

        System.out.println();

        Camion<Automovil> transportarAutos = new Camion<>(5);
        transportarAutos.add(new Automovil("audi"));
        transportarAutos.add(new Automovil("bmw"));
        transportarAutos.add(new Automovil("porsche"));
        transportarAutos.add(new Automovil("toyota"));
        transportarAutos.add(new Automovil("mazda"));

        imprimirCamion(transportarAutos);

    }
}
