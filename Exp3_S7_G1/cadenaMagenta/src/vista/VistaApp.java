package vista;

import controlador.CarteleraControlador;
import dao.PeliculaDao;
import modelo.Pelicula;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class VistaApp extends JFrame{
    private CarteleraControlador controlador = new CarteleraControlador();
    private JPanel panel1;
    private JLabel nombreP;
    private JTextField nombrePelicula;
    private JButton buscarButton;
    private JTextField director;
    private JTextField anio;
    private JTextField genero;
    private JTextField duracion;
    private JButton buscarPeliculaButton;
    private JButton eliminarPeliculaButton;
    private JTable resultados;
    private JTextField buscarNombreField;
    private JTextField eliminarPeliculaField;
    private JButton guardarPelicula;
    private JButton modificarPelicula;
    private JButton limpiarDatos;


    //Metodo para limpiar los campos de texto
    private void limpiarDatos(){
        nombrePelicula.setText("");
        director.setText("");
        anio.setText("");
        duracion.setText("");
        genero.setText("");
    }


    private void cargarDatosEnTabla(List<Pelicula> peliculas) {
        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) resultados.getModel();

        // Limpiar la tabla
        modelo.setRowCount(0);

        // Llenar la tabla con los datos
        for (Pelicula pelicula : peliculas) {
            Object[] fila = {
                    pelicula.getId(),
                    pelicula.getTitulo(),
                    pelicula.getDirector(),
                    pelicula.getAnio(),
                    pelicula.getDuracion(),
                    pelicula.getGenero()
            };
            modelo.addRow(fila);
        }
    }


    public VistaApp(){
        setTitle("Cines Magenta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 750);
        setLocationRelativeTo(null);
        setVisible(true);

        add(panel1);
        setVisible(true);


        String[] columnas = {"ID", "Nombre Película", "Director", "Año", "Duración", "Género"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabla de solo lectura
            }
        };
        resultados.setModel(modelo);

        //Clear sobre el campo de texto Buscar Nombre al momento del click
        buscarNombreField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                buscarNombreField.setText("");
            }
        });

        //Boton Buscar Pelicula
        buscarPeliculaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.setRowCount(0);
                String nombreBusqueda = buscarNombreField.getText().trim();
                List<Pelicula> peliculaList;
                peliculaList = controlador.buscarPorNombre(nombreBusqueda);
                buscarNombreField.setText("Ingresa el nombre de la pelicula");

                if(peliculaList.isEmpty()){
                    buscarNombreField.setText("Ingresa el nombre de la pelicula");
                }else{
                    cargarDatosEnTabla(peliculaList);
                }
            }
        });

        //Muestra la lista completa de peliculas
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.setRowCount(0);
                cargarDatosEnTabla(controlador.listar());
            }
        });

        //Eliminar Pelicula Field
        eliminarPeliculaField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                eliminarPeliculaField.setText("");
            }
        });

        //Eliminar Pelicula Boton
        eliminarPeliculaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.setRowCount(0);
                try{

                    String idTexto = eliminarPeliculaField.getText().trim();
                    if (idTexto.isEmpty() || idTexto.isBlank()) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID");
                        return;
                    }
                    int opcionEliminar = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar la película con ID: " + idTexto + "?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION);
                    if(opcionEliminar == 0 ){
                        if(controlador.eliminarPelicula(eliminarPeliculaField.getText())){
                            JOptionPane.showMessageDialog(null, "La Pelicula ha sido eliminada de forma correcta");
                        }else{
                            JOptionPane.showMessageDialog(null, "Error en la eliminacion de la Pelicula.");
                        }
                        eliminarPeliculaField.setText("Ingresa el ID de la Pelicula");

                    }else{
                        eliminarPeliculaField.setText("Ingresa el ID de la Pelicula");

                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    eliminarPeliculaField.setText("Ingresa el ID de la Pelicula");

                }

            }
        });


        //Guardar Pelicula Boton
        guardarPelicula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int validarPelicula = controlador.validarPelicula(nombrePelicula.getText(), director.getText(), anio.getText(), duracion.getText(), genero.getText());
                if(validarPelicula ==0){
                    JOptionPane.showMessageDialog(null, "Debes ingresar todos los valores");

                }else if(validarPelicula ==1){
                    JOptionPane.showMessageDialog(null, "Hay valores numericos erroneos");

                }else if(validarPelicula ==2) {
                    JOptionPane.showMessageDialog(null, "El nombre ingresado ya se encuentra en Cartelera");
                    limpiarDatos();

                }else if(validarPelicula == 3){
                    if(controlador.guardarPelicula(nombrePelicula.getText(), director.getText(), anio.getText(), duracion.getText(), genero.getText())){
                        JOptionPane.showMessageDialog(null, "Pelicula ingresada de forma correcta");
                        limpiarDatos();

                    }else{
                        JOptionPane.showMessageDialog(null, ("La Pelicula " + nombrePelicula.getText() + "no pudo ser ingresada"));
                        limpiarDatos();
                    }

                }
            }
        });

        //Boton Limpiar Datos
        limpiarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarDatos();
            }
        });


        modificarPelicula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int validarPelicula = controlador.validarPelicula(nombrePelicula.getText(), director.getText(), anio.getText(), duracion.getText(), genero.getText());
                if(validarPelicula ==0){
                    JOptionPane.showMessageDialog(null, "Debes ingresar todos los valores");

                }else if(validarPelicula ==1){
                    JOptionPane.showMessageDialog(null, "Hay valores numericos erroneos");

                }else if(controlador.validarPelicula(nombrePelicula.getText(), director.getText(), anio.getText(), duracion.getText(), genero.getText()) ==3){
                    String idPelicula = JOptionPane.showInputDialog(null, "Ingresa el ID de la Pelicula que deseas actualizar:",
                            "ID Pelicula", JOptionPane.QUESTION_MESSAGE);

                    if(controlador.buscarPorId(idPelicula) != null){
                       Pelicula pelicula = controlador.buscarPorId(idPelicula);
                    }

                    int opcionActualizar = JOptionPane.showConfirmDialog(null, "Confirma para modificar los campos",
                            "Confirmar actualización",
                            JOptionPane.YES_NO_OPTION);
                    Pelicula peliculaActualizar = new Pelicula(nombrePelicula.getText(), director.getText(), anio.getText(), duracion.getText(), genero.getText());

                    if(opcionActualizar == 0 ){
                        if(controlador.actualizar(peliculaActualizar, idPelicula)){
                            JOptionPane.showMessageDialog(null, "Pelicula actualizada de forma correcta");
                            limpiarDatos();
                        }
                    }
                }
            }
        });
    }

}
