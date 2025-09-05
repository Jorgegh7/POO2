package app;

import controlador.ControladoInventario;
import modelo.Inventario;
import vista.VistaInventario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Inventario inventario = new Inventario();
        VistaInventario vistaInventario = new VistaInventario(new Scanner(System.in));
        ControladoInventario controladoInventario = new ControladoInventario(vistaInventario, inventario);

        controladoInventario.iniciarAplicacion();
    }
}