package org.laredo.generics;

import org.laredo.poointerfaces.model.Cliente;
import org.laredo.poointerfaces.model.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenerics {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("piero", "laredo"));

        Cliente piero = clientes.iterator().next();


        // ARREGLOS
        Cliente[] clientesArreglo = {
                new Cliente("rachell", "santos"),
                new Cliente("beto", "rafael"),
                new Cliente("maricarmen", "barrientos")
        };

        Integer[] numbers = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        String[] frameworks = {
                "spring boot", "angular", "react", "netJs"
        };

        ClientePremium[] clientesPremiums= {
                new ClientePremium("alejandro", "infantes"),
                new ClientePremium("gonzalo", "motta"),
                new ClientePremium("sarita", "quispe"),
                new ClientePremium("charo", "ramos")
        };

        // CONVIRTIENDO DE ARRAYS A LIST
        List<Cliente> clienteLista = fromArrayToList(clientesArreglo);
        List<Integer> integerLista = fromArrayToList(numbers);
        List<String> stringLista = fromArrayToList(frameworks, numbers);
        List<ClientePremium> clientePremiumLista = fromArrayToList(clientesPremiums);

        clienteLista.forEach(System.out::println);
        System.out.println();
        integerLista.forEach(System.out::println);
        System.out.println();
        stringLista.forEach(System.out::println);

        // IMPRIMIR CLIENTES
        imprimirClientes(clientes);
        imprimirClientes(clienteLista);
        imprimirClientes(clientePremiumLista);

        System.out.println("máximo de  4, 20, 14 es: " + maximo(4, 20, 14));
        System.out.println("máximo de 4.56, 86.14, 79.24 es: " + maximo(4.56, 86.14, 79.24));
        System.out.println("máximo de plátano, zanahoria, fresa es: " + maximo("plátano", "zanahoria", "fresa"));
    }

    // ESTE MÉTODO GENÉRICO CONVIERTE UN ARREGLO EN UNA LISTA, GENÉRICO XQ PUEDE CONVERTIR UN ARREGLO QUE CUALQUIER TIPO A UNA LISTA
    // USA EL <T> List <T> PARA HACERLO GENÉRICO
    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Cliente> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    // CAMBIA DE UN ARRAY A UNA LISTA, SOLO NÚMEROS, USANDO EXTENDS
    public static <T extends Number> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x) {
        for (G elemento : x){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    // EL ?extends HACE QUE PUEDA GENERALIZAR Y USAR CUALQUIER TIPO DE "Cliente"
    public static void imprimirClientes (List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    // COMPARA Y DA EL VALOR MÁXIMO
    public static <T extends Comparable <T>> T maximo (T a, T b, T c){
        T max = a;
        if (b.compareTo(max) > 0){
            max = b;
        }
        if (c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }
}
