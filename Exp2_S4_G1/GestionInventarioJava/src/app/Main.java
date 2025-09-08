package app;

import controlador.ControladoInventario;
import modelo.Inventario;
import vista.MenuPrincipal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Inventario inventario = new Inventario();
        MenuPrincipal vistaInventario = new MenuPrincipal(new Scanner(System.in));
        ControladoInventario controladoInventario = new ControladoInventario(vistaInventario, inventario);

        controladoInventario.iniciarAplicacion();
    }
}