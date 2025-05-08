package org.laredo.poointerfaces;

import org.laredo.poointerfaces.model.Cliente;
import org.laredo.poointerfaces.repositorio.*;
import org.laredo.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        FullRepositorio<Cliente> repo = new ClienteListRepositorio();
        repo.crear(new Cliente("fabio", "laredo"));
        repo.crear(new Cliente("delia", "ramos"));
        repo.crear(new Cliente("laura", "lorena"));
        repo.crear(new Cliente("juan", "torres"));

        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.println("\n===== paginable =====\n");
        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(1, 4);
        paginable.forEach(System.out::println);

        System.out.println("\n===== ordenAsc =====\n");
        List<Cliente> clientesOrdenAsc = ((OrdenableRepositorio)repo).listar("nombre", Direccion.ASC);
        clientesOrdenAsc.forEach(System.out::println);

        System.out.println("\n===== ordenDesc =====\n");
        List<Cliente> clientesOrdenDesc = ((OrdenableRepositorio)repo).listar("apellido", Direccion.DESC);
        clientesOrdenDesc.forEach(System.out::println);

        System.out.println("\n===== editar =====\n");
        Cliente fabioActualizar = new Cliente("fabio", "rodriguez");
        fabioActualizar.setId(1);
        repo.editar(fabioActualizar);

        System.out.println("\n===== ordenDescActualizado =====\n");
        List<Cliente> clientesOrdenDesc2 = ((OrdenableRepositorio)repo).listar("apellido", Direccion.DESC);
        clientesOrdenDesc2.forEach(System.out::println);

        System.out.println("\n===== eliminar =====\n");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);




    }
}
