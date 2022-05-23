
package pruebasbases;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class GUI {
        
    JFrame frame;
    JPanel panel;
    JButton crear, conexion, eliminar, modificar;
    JLabel titulo, presenta;
    JSeparator separador1;
    
    public void crearEventos(){
        Font fuente = new Font("A",1,34);
        frame = new JFrame("Eventos");
        frame.setSize(600, 500);
        panel = new JPanel();
        panel.setSize(600, 500);
        panel.setLayout(null);
        
        titulo = new JLabel("Bienvenido administrador/a");
        titulo.setBounds(40, 0, 600, 100);
        titulo.setFont(fuente);
        
        presenta = new JLabel("Que quiere hacer en este momento?");
        presenta.setBounds(170,30, 300, 200);
        
        separador1 = new JSeparator();
        separador1.setBounds(0, 100, 700, 10);
        
        crear = new JButton("Añadir usuario");
        crear.setBounds(350, 200, 150, 50);
        
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(350, 300, 150, 50);
        
        modificar = new JButton("Modificar");
        modificar.setBounds(100, 300, 150, 50);
        
        conexion = new JButton("Conectar");
        conexion.setBounds(100, 200, 150, 50);
        
        //ponemos los componentes al panel.
        panel.add(conexion);
        panel.add(modificar);
        panel.add(titulo);
        panel.add(eliminar);
        panel.add(presenta);
        panel.add(crear);
        panel.add(separador1);
        frame.add(panel);
        frame.setLocationRelativeTo(frame);
        //xestion de eventos
        conexion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                Connection con = null;
                
                try{
                    con = DriverManager.getConnection( "jdbc:sqlite:data.sqlite" );
                    crearTabla();
                if ( con != null ){
                      System.out.println("Conexión exitosa!");
                        }
             }  catch (SQLException ex) {
                    System.out.println("a");
                }}
        });
        crear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              JFrame framecr = new JFrame("Añadir usuario");
              framecr.setSize(600,500);
              framecr.setLocationRelativeTo(framecr);
              
              JPanel panelcr = new JPanel();
              panelcr.setSize(600,500);
              panelcr.setLayout(null);
              
              JButton boton = new JButton("Crear");
              boton.setBounds(300,350, 100, 50);
              
         
              
              JLabel nombre = new JLabel("Nombre:");
              nombre.setBounds(50, 50, 100, 100);
              
              JLabel primerApellido = new JLabel("Primer apellido:");
              primerApellido.setBounds(50, 100, 150, 100);
              
              JLabel segundoApellido = new JLabel("Segundo apellido:");
              segundoApellido.setBounds(50, 150, 150, 100);
              
              JLabel dni = new JLabel("DNI:");
              dni.setBounds(50, 200, 150, 100);
              
              JLabel telf = new JLabel("Número telefono:");
              telf.setBounds(50, 250, 150, 100);
              
              JTextField nombreCampo = new JTextField();
              nombreCampo.setBounds(220, 85, 300, 30);
              
              JTextField primerApellidoCampo = new JTextField();
              primerApellidoCampo.setBounds(220, 135, 300, 30);
              
              JTextField segundoApellidoCampo = new JTextField();
              segundoApellidoCampo.setBounds(220, 185, 300, 30);
              
              JTextField dniCampo = new JTextField();
              dniCampo.setBounds(220, 235, 300, 30);
              
              JTextField telfCampo = new JTextField();
              telfCampo.setBounds(220, 285, 300, 30);
              
              boton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        framecr.dispose();
                        String nome = nombreCampo.getText();
                        String apel = primerApellidoCampo.getText();
                        String segunApel = segundoApellidoCampo.getText();
                        String dnii = dniCampo.getText();
                        String telefono = telfCampo.getText();
                        
                        insertar(nome, apel, segunApel, dnii, telefono);
                        
                    }
                    
              });
              
              framecr.add(boton);
              framecr.add(nombreCampo);
              framecr.add(primerApellidoCampo);
              framecr.add(segundoApellidoCampo);
              framecr.add(dniCampo);
              framecr.add(telfCampo);
              framecr.add(telf);
              framecr.add(primerApellido);
              framecr.add(segundoApellido);
              framecr.add(dni);
              framecr.add(nombre);
              framecr.add(panelcr);
              framecr.setVisible(true);
            }
        });
        eliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              JFrame framecr = new JFrame("Eliminar");
              framecr.setSize(600,500);
              framecr.setLocationRelativeTo(framecr);
              
              JPanel panelcr = new JPanel();
              panelcr.setSize(600,500);
              panelcr.setLayout(null);
              
              
              framecr.add(panelcr);
              framecr.setVisible(true);
            }
        });
        modificar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              JFrame framecr = new JFrame("Modificar");
              framecr.setSize(600,500);
              framecr.setLocationRelativeTo(framecr);
              
              JPanel panelcr = new JPanel();
              panelcr.setSize(600,500);
              panelcr.setLayout(null);
              
              
              framecr.add(panelcr);
              framecr.setVisible(true);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void crearTabla(){
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test2.db");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "CREATE TABLE USUARIOS " +
                        "(DNI TEXT PRIMARY KEY     NOT NULL," +
                        " NOMBRE           TEXT    NOT NULL, " + 
                        " APELLIDO         TEXT     NOT NULL, " + 
                        " SEGUNDOAPELLIDO        TEXT, " + 
                        " TELEFONO         TEXT)"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
    }
    
    public void insertar(String dni, String nombre, String apellido, String segundoapellido, String telefono){
        Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test2.db");
         c.setAutoCommit(false);
         System.out.println("Abierta la base de datos");

         stmt = c.createStatement();
         String sql = "INSERT INTO USUARIOS (DNI,NOMBRE,APELLIDO,SEGUNDOAPELLIDO,TELEFONO) " +
                        "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
    }
    
    public void consultar(){
        
        Connection c = null;
   Statement stmt = null;
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test2.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" );
      
      while ( rs.next() ) {
         int id = rs.getInt("dni");
         String  name = rs.getString("nombre");
         int age  = rs.getInt("apellido");
         String  address = rs.getString("segundoapellido");
         float salary = rs.getFloat("telefono");
         
         System.out.println( "DNI = " + id );
         System.out.println( "NOMBRE = " + name );
         System.out.println( "APELLIDO = " + age );
         System.out.println( "SEGUNDOAPELLIDO = " + address );
         System.out.println( "telefono = " + salary );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
   System.out.println("Operation done successfully");
    }
}

