package org.laredo.poointerfaces.repositorio.lista;

import org.laredo.poointerfaces.model.Cliente;
import org.laredo.poointerfaces.repositorio.AbstractoListRepositorio;
import org.laredo.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractoListRepositorio<Cliente> {

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for (Cliente cli : this.dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente cli = this.porId(cliente.getId());
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
                    int resultado = 0;
                    if (dir == Direccion.ASC) {
                        resultado = ordenar(campo, a, b);
                    }else if (dir == Direccion.DESC) {
                        resultado = ordenar(campo, b, a);
                    }
                    return resultado;
                }
        );
        return listaOrdenada;
    }

    public static int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }
}
