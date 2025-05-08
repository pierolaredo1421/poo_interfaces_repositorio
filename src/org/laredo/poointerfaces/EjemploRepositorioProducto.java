package org.laredo.poointerfaces;

import org.laredo.poointerfaces.model.Producto;
import org.laredo.poointerfaces.repositorio.Direccion;
import org.laredo.poointerfaces.repositorio.FullRepositorio;
import org.laredo.poointerfaces.repositorio.OrdenableRepositorio;
import org.laredo.poointerfaces.repositorio.PaginableRepositorio;
import org.laredo.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        FullRepositorio<Producto> repoProduct = new ProductoListRepositorio();
        repoProduct.crear(new Producto("MacBook Pro", 6800));
        repoProduct.crear(new Producto("PC Gamer", 3700));
        repoProduct.crear(new Producto("Monitor ViewSonic", 488));
        repoProduct.crear(new Producto("Teclado Apex Pro TKL", 840));

        List<Producto> producto = repoProduct.listar();
        producto.forEach(System.out::println);

        System.out.println("\n===== paginable =====\n");
        List<Producto> paginable = ((PaginableRepositorio) repoProduct).listar(1, 4);
        paginable.forEach(System.out::println);

        System.out.println("\n===== ordenAsc =====\n");
        List<Producto> productosOrdenAsc = ((OrdenableRepositorio) repoProduct).listar("description", Direccion.ASC);
        productosOrdenAsc.forEach(System.out::println);

        System.out.println("\n===== ordenDesc =====\n");
        List<Producto> productosOrdenDesc = ((OrdenableRepositorio) repoProduct).listar("precio", Direccion.DESC);
        productosOrdenDesc.forEach(System.out::println);

        System.out.println("\n===== editar =====\n");
        Producto productoActualizado = new Producto("Licencia Intellij IDEA", 760);
        productoActualizado.setId(1);
        repoProduct.editar(productoActualizado);
        Producto licencia = repoProduct.porId(1);
        System.out.println(licencia);


        System.out.println("\n===== ordenDescActualizado =====\n");
        List<Producto> productosOrdenDesc2 = ((OrdenableRepositorio) repoProduct).listar("precio", Direccion.DESC);
        productosOrdenDesc2.forEach(System.out::println);

        System.out.println("\n===== eliminar =====\n");
        repoProduct.eliminar(4);
        repoProduct.listar().forEach(System.out::println);
    }
}
