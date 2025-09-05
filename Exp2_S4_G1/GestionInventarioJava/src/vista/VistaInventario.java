package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaInventario {
   private Scanner scanner;

   public VistaInventario(Scanner scanner) {
      this.scanner = scanner;
   }

   public void mostrarMenu(){
      System.out.println("=".repeat(40));
      System.out.println("      INVENTARIO PRODUCTOS");
      System.out.println("=".repeat(40));
      System.out.println("1. Mostrar Productos");
      System.out.println("2. Agregar Nuevo Producto");
      System.out.println("3. Eliminar Producto");
      System.out.println("4. Modificar Stock Producto");
      System.out.println("5. Salir");
      System.out.println("=".repeat(40));
      System.out.print("Seleccione una opción: ");
   }

   public int leerOpcion(){
      try{
         return scanner.nextInt();
      } catch (InputMismatchException e) {
         scanner.nextLine();
         System.out.println();
         return -1;
      }
   }

   public String leerNombreProducto(){
      System.out.print("Indica el NOMBRE del Producto: ");
      try{
         return scanner.nextLine().strip().toUpperCase();
      } catch (Exception e) {
         System.out.println("Error al leer el producto. Intenta de nuevo.");
         return "";
      }
   }

   public String leerCodigoProducto(){
      scanner.nextLine();
      System.out.print("Indica el CODIGO: ");
      try{
         return scanner.nextLine().strip().toUpperCase();
      } catch (Exception e) {
         System.out.println("Error al leer el producto. Intenta de nuevo.");
         return "";
      }
   }

   public double leerprecio(){
      try{
         System.out.print("Ingresa el Precio: ");
         return scanner.nextDouble();
      } catch (InputMismatchException e) {
         System.out.println("El valor ingresado es invalido.");
         return 0;
      }
   }

   public int leerStockProducto(){
      try{
         System.out.print("Ingresa el Stock: ");
         int unidades = scanner.nextInt();
         return unidades;
      } catch (InputMismatchException e) {
         System.out.println("El valor ingresado es invalido.");
         System.out.println();
         scanner.nextLine();
         return 0;
      }
   }

   public boolean salirSistema(){
      System.out.println("=".repeat(40));
      System.out.println("Cerrando Sistema...");
      System.out.println("Hasta Pronto!");
      return false;
   }

   public void opcionInvalida(){
      System.out.println("Valor ingresado invalido!");
      System.out.println();
   }


}
