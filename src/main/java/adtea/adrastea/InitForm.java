/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package adtea.adrastea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author JCH - 
 */


public class InitForm extends javax.swing.JFrame {
    
    

    /*Carga formatos formulario*/
    @SuppressWarnings("empty-statement")
    public InitForm() {
          initComponents();
//        setFechaActual();
//        setFechaEjecucion();
//        cargarCentros();
//        reestablecerValores();
//        setConstrutivoCentros();
//        setConstructivoClimatizacion();
//        cargaValores();
        
        numeroBancadasAmp.setEditable(false);
        numeroBancadasAmp.setText("0 Bancada/s");
        capacidadBancadaAmp.setEditable(false);
        capacidadBancadaAmp.setText("0 W");
        numeroModulosRectificadorAmp.setEditable(false);
        numeroModulosRectificadorAmp.setText("0 Rectificador/es");
        capacidadRectificadorAmp.setEditable(false);
        capacidadRectificadorAmp.setText("0 W");
        
        
        String[] opcionesConexionvCARectificador = {"","No Aplica","Monofásica", "Trifásica"};
        combocxRectificador.setModel(new DefaultComboBoxModel<>(opcionesConexionvCARectificador));
        
        String[] opcionesProteccionRectificador = {"","No Aplica","Monofásico", "Trifásico"};
        combocxMagneto.setModel(new DefaultComboBoxModel<>(opcionesProteccionRectificador));
        
        this.setTitle("Adrástea - Formulario dimensionamiento, consulta y reservas");
         // Establecer el icono del formulario
        try {
            // Reemplaza "ruta/al/archivo/icono.png" con la ruta real de tu archivo de icono en el sistema de archivos
            File iconFile = new File("images/adrastea.jpg");
            BufferedImage icon = ImageIO.read(iconFile);
            this.setIconImage(icon);
        } catch (IOException ex) {
            // Manejar cualquier excepción de lectura del archivo de icono

        }
        


   /*Establecer valores medida */
    cargaActual.addFocusListener(new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){

        }
        @Override
        public void focusLost(FocusEvent e){
        
        int cargaActualValor = Integer.parseInt(cargaActual.getText());
        cargaActual.setText(cargaActualValor + " A");
        setCalculos();
    }
});
    
    cargaSolicitada.addFocusListener(new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){

        }
        @Override
        public void focusLost(FocusEvent e){
        
        int cargaActualValor = Integer.parseInt(cargaSolicitada.getText());
        cargaSolicitada.setText(cargaActualValor + " A");
        setCalculos();

    }
    });
    
    cargaTotal.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
        }
        @Override  
        public void focusLost(FocusEvent e) {
        setCalculos();
        }
    });
    
    numeroModulosRectificador.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
        }
        @Override  
        public void focusLost(FocusEvent e) {
        
        int numeroModulosRectificadorValor = Integer.parseInt(numeroModulosRectificador.getText());
        numeroModulosRectificador.setText(numeroModulosRectificadorValor + " Rectificador/es");
        setCalculos();
        }
    });
    capacidadRectificador.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
        }
        @Override  
        public void focusLost(FocusEvent e){
        
        int cargaActualValor = Integer.parseInt(capacidadRectificador.getText());
        capacidadRectificador.setText(cargaActualValor + " W");
        setCalculos();

    }
    });
    numeroBancadas.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
        }
        @Override  
        public void focusLost(FocusEvent e) {
        
        int numeroBancadasValor = Integer.parseInt(numeroBancadas.getText());
        numeroBancadas.setText(numeroBancadasValor + " Bancada/s");
        setCalculos();
        
        }
    });
    
    capacidadBancada.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
        }
        @Override  
        public void focusLost(FocusEvent e){   
        
        int cargaActualValor = Integer.parseInt(capacidadBancada.getText());
        capacidadBancada.setText(cargaActualValor + " A");
        setCalculos();
        
    }
    });
    numeroBancadasAmp.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
            setCalculos();
        }
        @Override  
        public void focusLost(FocusEvent e){   
        
        int numeroBancadasAmpValor = Integer.parseInt(numeroBancadasAmp.getText());
        numeroBancadasAmp.setText(numeroBancadasAmpValor + " Bancada/s");
        setCalculos();
        
    }
    });
    capacidadBancadaAmp.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
            setCalculos();
        }
        @Override  
        public void focusLost(FocusEvent e){   
        
        int capacidadBancadaAmpValor = Integer.parseInt(capacidadBancadaAmp.getText());
        capacidadBancadaAmp.setText(capacidadBancadaAmpValor + " W");
        setCalculos();
        
    }
    });
    numeroModulosRectificadorAmp.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
            setCalculos();
        }
        @Override  
        public void focusLost(FocusEvent e){   
        
        int numeroModulosRectificadorAmpValor = Integer.parseInt(numeroModulosRectificadorAmp.getText());
        numeroModulosRectificadorAmp.setText(numeroModulosRectificadorAmpValor + " Rectificador/es");
        setCalculos();
        
    }
    });
    capacidadRectificadorAmp.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
            setCalculos();
        }
        @Override  
        public void focusLost(FocusEvent e){   
        
        int capacidadRectificadorAmpValor = Integer.parseInt(capacidadRectificadorAmp.getText());
        capacidadRectificadorAmp.setText(capacidadRectificadorAmpValor + " W");
        setCalculos();
        
    }
    });

    seccionCableRectificador.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
        }
        @Override  
        public void focusLost(FocusEvent e) {
            
        }
    });
    magnetoCorte.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
        }
        @Override  
        public void focusLost(FocusEvent e) {
            
        }
    });
    
    cargaTotalSite.addFocusListener (new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
        }
        @Override  
        public void focusLost(FocusEvent e) {

        }
   
            });
            }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelValidacionAcciones = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        accionAlterna = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        accionAutonomia = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        accionContinua = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        accionClimatizacion = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        DatosEnergiaClima = new javax.swing.JPanel();
        Estimaciones = new javax.swing.JPanel();
        Estimaciones1 = new javax.swing.JPanel();
        consumovcA = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        porcentajeConsumovcA = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        L1vcA = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        maxvcAFase = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        maxvcAFase2 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        L2vcA = new javax.swing.JTextField();
        L3vcA = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        Estimaciones3 = new javax.swing.JPanel();
        minnRectificadores = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        minnRectcBat = new javax.swing.JTextField();
        maxvcCFase = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        maxvcCFase2 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        fasesvcC = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Estimaciones2 = new javax.swing.JPanel();
        autonomiaBaterias = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        Estimaciones4 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        cargaTermicaActual = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        cargaTermicaFutura = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        climatizacionNormalizada = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        porcentajeClima = new javax.swing.JTextField();
        datosEnergia = new javax.swing.JTabbedPane();
        datosPestaEnergia = new javax.swing.JTabbedPane();
        Rectificadores = new javax.swing.JPanel();
        capacidadRectTotal = new javax.swing.JTextField();
        capacidadRectificador = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        numeroModulosRectificador = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        comboRectificador = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        CxRectificador = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        combocxRectificador = new javax.swing.JComboBox<>();
        combocxMagneto = new javax.swing.JComboBox<>();
        seccionCableRectificador = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        magnetoCorte = new javax.swing.JTextField();
        PotenciaContinua = new javax.swing.JPanel();
        cargaTotal = new javax.swing.JTextField();
        cargaReservadaRect = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cargaActual = new javax.swing.JTextField();
        cargaSolicitada = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cargaReservadaTotal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cargaTotalSite = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaRacks = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        Baterias = new javax.swing.JPanel();
        capacidadBatTotal = new javax.swing.JTextField();
        capacidadBancada = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        numeroBancadas = new javax.swing.JTextField();
        comboTipoBateria = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        PotenciaAlterna = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        codigoCups = new javax.swing.JTextField();
        terminoEnergia = new javax.swing.JTextField();
        terminoPotencia = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        seccionAcometida = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        icp = new javax.swing.JTextField();
        iga = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        conmutador = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        cetac = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        cetacCX = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        seccionTierra = new javax.swing.JTextField();
        Climatización = new javax.swing.JPanel();
        frigoriasClimatización = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        numeroClimatizadores = new javax.swing.JTextField();
        consumoClimatizadores = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaClima = new javax.swing.JTable();
        amp = new javax.swing.JPanel();
        capacidadBancadaAmp = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        numeroBancadasAmp = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        numeroModulosRectificadorAmp = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        capacidadRectificadorAmp = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        panelValidacionAcciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Validación y acciones"));

        accionAlterna.setColumns(20);
        accionAlterna.setRows(5);
        accionAlterna.setAutoscrolls(false);
        accionAlterna.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Alterna"));
        jScrollPane2.setViewportView(accionAlterna);

        accionAutonomia.setColumns(20);
        accionAutonomia.setRows(5);
        accionAutonomia.setAutoscrolls(false);
        accionAutonomia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Autonomía"));
        jScrollPane3.setViewportView(accionAutonomia);

        accionContinua.setColumns(20);
        accionContinua.setRows(5);
        accionContinua.setAutoscrolls(false);
        accionContinua.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Contínua"));
        jScrollPane4.setViewportView(accionContinua);

        accionClimatizacion.setColumns(20);
        accionClimatizacion.setRows(5);
        accionClimatizacion.setAutoscrolls(false);
        accionClimatizacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Climatización"));
        jScrollPane8.setViewportView(accionClimatizacion);

        javax.swing.GroupLayout panelValidacionAccionesLayout = new javax.swing.GroupLayout(panelValidacionAcciones);
        panelValidacionAcciones.setLayout(panelValidacionAccionesLayout);
        panelValidacionAccionesLayout.setHorizontalGroup(
            panelValidacionAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidacionAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValidacionAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelValidacionAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelValidacionAccionesLayout.setVerticalGroup(
            panelValidacionAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidacionAccionesLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        DatosEnergiaClima.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Energía y Climatización"));

        Estimaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Estimaciones"));

        Estimaciones1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dimensionamiento Alterna"));

        consumovcA.setBackground(new java.awt.Color(204, 204, 204));

        jLabel31.setText("Consumo vcA");

        jLabel32.setText("% Consumo");

        porcentajeConsumovcA.setBackground(new java.awt.Color(204, 204, 204));

        L1vcA.setBackground(new java.awt.Color(204, 204, 204));

        jLabel35.setText("L1");

        maxvcAFase.setBackground(new java.awt.Color(204, 204, 204));

        jLabel46.setText("<html>Consumo máximo por fase alterna<br> con nº módulos rectificador actuales</html>");

        maxvcAFase2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel47.setText("<html>Consumo máximo por fase alterna<br> con nº modulos necesarios</html>");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Valores máximos admitidos");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel51.setText("<html>El consumo en alterna está calculado en base <br>a todo equipamiento con independencia rectificador<br>seleccionado, sala, incluyendo consumos de <br>equipos de climatización de todo el centro</html>");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel34.setText("<html>Se tiene en cuenta carga de otros rectificadores<br> y equipos que consumen alterna</html>");

        L2vcA.setBackground(new java.awt.Color(204, 204, 204));

        L3vcA.setBackground(new java.awt.Color(204, 204, 204));

        jLabel56.setText("L2");

        jLabel57.setText("L3");

        javax.swing.GroupLayout Estimaciones1Layout = new javax.swing.GroupLayout(Estimaciones1);
        Estimaciones1.setLayout(Estimaciones1Layout);
        Estimaciones1Layout.setHorizontalGroup(
            Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Estimaciones1Layout.createSequentialGroup()
                .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Estimaciones1Layout.createSequentialGroup()
                        .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Estimaciones1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel32))
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(consumovcA, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(porcentajeConsumovcA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Estimaciones1Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(L1vcA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Estimaciones1Layout.createSequentialGroup()
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(L2vcA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Estimaciones1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Estimaciones1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(L3vcA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Estimaciones1Layout.createSequentialGroup()
                                .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maxvcAFase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maxvcAFase2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Estimaciones1Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(Estimaciones1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Estimaciones1Layout.setVerticalGroup(
            Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Estimaciones1Layout.createSequentialGroup()
                .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consumovcA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel35)
                    .addComponent(L1vcA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(porcentajeConsumovcA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L2vcA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Estimaciones1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(L3vcA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Estimaciones1Layout.createSequentialGroup()
                                .addGroup(Estimaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(maxvcAFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(maxvcAFase2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel33)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Estimaciones1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        Estimaciones3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dimensionamiento Contínua"));

        minnRectificadores.setBackground(new java.awt.Color(204, 204, 204));

        jLabel42.setText("Mínimo nº rectificadores");

        jLabel45.setText("Mínimo nº rect. + carga bat.");

        minnRectcBat.setBackground(new java.awt.Color(204, 204, 204));

        maxvcCFase.setBackground(new java.awt.Color(204, 204, 204));

        jLabel48.setText("<html>Consumo máximo por fase contínua<br>\ncon rectificadores actuales  </html>");

        jLabel49.setText("<html>Consumo máximo por fase contínua<br>\ncon rectificadores necesarios  </html>");

        maxvcCFase2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel54.setText("<html>Consumo por fase en contínua</html>");

        fasesvcC.setBackground(new java.awt.Color(204, 204, 204));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Valores máximos admitidos");

        javax.swing.GroupLayout Estimaciones3Layout = new javax.swing.GroupLayout(Estimaciones3);
        Estimaciones3.setLayout(Estimaciones3Layout);
        Estimaciones3Layout.setHorizontalGroup(
            Estimaciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Estimaciones3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Estimaciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Estimaciones3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Estimaciones3Layout.createSequentialGroup()
                        .addGroup(Estimaciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Estimaciones3Layout.createSequentialGroup()
                                .addGroup(Estimaciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel42))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Estimaciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(minnRectcBat, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(minnRectificadores)))
                            .addGroup(Estimaciones3Layout.createSequentialGroup()
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fasesvcC, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Estimaciones3Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(maxvcCFase, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Estimaciones3Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(Estimaciones3Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(maxvcCFase2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        Estimaciones3Layout.setVerticalGroup(
            Estimaciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Estimaciones3Layout.createSequentialGroup()
                .addGroup(Estimaciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minnRectificadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Estimaciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(minnRectcBat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Estimaciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fasesvcC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(10, 10, 10)
                .addGroup(Estimaciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Estimaciones3Layout.createSequentialGroup()
                        .addGroup(Estimaciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxvcCFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maxvcCFase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel44))
        );

        Estimaciones2.setBorder(javax.swing.BorderFactory.createTitledBorder("Autonomía baterías"));

        autonomiaBaterias.setBackground(new java.awt.Color(204, 204, 204));

        jLabel36.setText("Autonomía");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel50.setText("<html>Estimación en base a la caída de tensión de <br>baterías y falta de eficiencia térmica, 12% </html>");

        javax.swing.GroupLayout Estimaciones2Layout = new javax.swing.GroupLayout(Estimaciones2);
        Estimaciones2.setLayout(Estimaciones2Layout);
        Estimaciones2Layout.setHorizontalGroup(
            Estimaciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Estimaciones2Layout.createSequentialGroup()
                .addGroup(Estimaciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Estimaciones2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autonomiaBaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Estimaciones2Layout.createSequentialGroup()
                        .addGroup(Estimaciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Estimaciones2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel43))
                            .addGroup(Estimaciones2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Estimaciones2Layout.setVerticalGroup(
            Estimaciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Estimaciones2Layout.createSequentialGroup()
                .addGroup(Estimaciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autonomiaBaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel43)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Estimaciones4.setBorder(javax.swing.BorderFactory.createTitledBorder("Carga térmica"));

        jLabel69.setText("Actual");

        cargaTermicaActual.setBackground(new java.awt.Color(204, 204, 204));

        jLabel70.setText("Aumento estimado");

        cargaTermicaFutura.setBackground(new java.awt.Color(204, 204, 204));

        jLabel71.setText("Climatización normalizada");

        climatizacionNormalizada.setBackground(new java.awt.Color(204, 204, 204));

        jLabel40.setText("% Carga");

        porcentajeClima.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout Estimaciones4Layout = new javax.swing.GroupLayout(Estimaciones4);
        Estimaciones4.setLayout(Estimaciones4Layout);
        Estimaciones4Layout.setHorizontalGroup(
            Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Estimaciones4Layout.createSequentialGroup()
                .addGroup(Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Estimaciones4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Estimaciones4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Estimaciones4Layout.createSequentialGroup()
                        .addComponent(cargaTermicaFutura, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(porcentajeClima, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                    .addGroup(Estimaciones4Layout.createSequentialGroup()
                        .addGroup(Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(climatizacionNormalizada, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cargaTermicaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Estimaciones4Layout.setVerticalGroup(
            Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Estimaciones4Layout.createSequentialGroup()
                .addGroup(Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargaTermicaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(porcentajeClima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cargaTermicaFutura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel70)))
                .addGroup(Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Estimaciones4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel67))
                    .addGroup(Estimaciones4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Estimaciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(climatizacionNormalizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout EstimacionesLayout = new javax.swing.GroupLayout(Estimaciones);
        Estimaciones.setLayout(EstimacionesLayout);
        EstimacionesLayout.setHorizontalGroup(
            EstimacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstimacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstimacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Estimaciones4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Estimaciones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EstimacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Estimaciones3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Estimaciones2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EstimacionesLayout.setVerticalGroup(
            EstimacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstimacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstimacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(EstimacionesLayout.createSequentialGroup()
                        .addComponent(Estimaciones3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Estimaciones2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(Estimaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Estimaciones4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );

        datosEnergia.setPreferredSize(new java.awt.Dimension(400, 370));
        datosEnergia.setVerifyInputWhenFocusTarget(false);

        datosPestaEnergia.setPreferredSize(new java.awt.Dimension(424, 400));

        Rectificadores.setBorder(javax.swing.BorderFactory.createTitledBorder("Rectificadores"));

        capacidadRectTotal.setBackground(new java.awt.Color(204, 204, 204));

        jLabel27.setText("Nº de módulos*");

        jLabel28.setText("Capacidad rectificador*");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("Capacidad Total");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        jLabel30.setText("<html>*Campos obligatorios<br></html>");

        jLabel26.setText("Rectificador");

        CxRectificador.setBorder(javax.swing.BorderFactory.createTitledBorder("Conexión rectificador"));

        jLabel37.setText("Cuadro vcA");

        jLabel38.setText("Magnetotérmico");

        jLabel39.setText("Sección cable");

        jLabel41.setText("Corte Magenotérmico");

        javax.swing.GroupLayout CxRectificadorLayout = new javax.swing.GroupLayout(CxRectificador);
        CxRectificador.setLayout(CxRectificadorLayout);
        CxRectificadorLayout.setHorizontalGroup(
            CxRectificadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CxRectificadorLayout.createSequentialGroup()
                .addGroup(CxRectificadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41)
                    .addGroup(CxRectificadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(CxRectificadorLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jLabel37))
                        .addGroup(CxRectificadorLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel38)))
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CxRectificadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(magnetoCorte)
                    .addComponent(combocxMagneto, javax.swing.GroupLayout.Alignment.LEADING, 0, 90, Short.MAX_VALUE)
                    .addComponent(combocxRectificador, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seccionCableRectificador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CxRectificadorLayout.setVerticalGroup(
            CxRectificadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CxRectificadorLayout.createSequentialGroup()
                .addGroup(CxRectificadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combocxRectificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CxRectificadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(combocxMagneto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CxRectificadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(magnetoCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CxRectificadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seccionCableRectificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RectificadoresLayout = new javax.swing.GroupLayout(Rectificadores);
        Rectificadores.setLayout(RectificadoresLayout);
        RectificadoresLayout.setHorizontalGroup(
            RectificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RectificadoresLayout.createSequentialGroup()
                .addGroup(RectificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RectificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RectificadoresLayout.createSequentialGroup()
                        .addGroup(RectificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numeroModulosRectificador, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(capacidadRectificador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(RectificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(capacidadRectTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(RectificadoresLayout.createSequentialGroup()
                        .addComponent(comboRectificador, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(RectificadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RectificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RectificadoresLayout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addComponent(CxRectificador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        RectificadoresLayout.setVerticalGroup(
            RectificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RectificadoresLayout.createSequentialGroup()
                .addGroup(RectificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboRectificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RectificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroModulosRectificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RectificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capacidadRectificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(capacidadRectTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CxRectificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        datosPestaEnergia.addTab("Rectificador", Rectificadores);

        PotenciaContinua.setBorder(javax.swing.BorderFactory.createTitledBorder("Potencia C.Contínua"));

        cargaTotal.setBackground(new java.awt.Color(204, 204, 204));

        cargaReservadaRect.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setText("Carga Actual*");

        jLabel12.setText("Aumento estimado*");

        jLabel13.setText("Otras reservas en Rect");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        jLabel15.setText("<html>*Campos obligatorios<br> </html>");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Total Rect");

        jLabel19.setText("Otras reservas en site");

        cargaReservadaTotal.setBackground(new java.awt.Color(204, 204, 204));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Total site");

        cargaTotalSite.setBackground(new java.awt.Color(204, 204, 204));

        TablaRacks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(TablaRacks);

        jLabel25.setText("Datos racks");

        javax.swing.GroupLayout PotenciaContinuaLayout = new javax.swing.GroupLayout(PotenciaContinua);
        PotenciaContinua.setLayout(PotenciaContinuaLayout);
        PotenciaContinuaLayout.setHorizontalGroup(
            PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PotenciaContinuaLayout.createSequentialGroup()
                .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PotenciaContinuaLayout.createSequentialGroup()
                        .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cargaReservadaTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(cargaReservadaRect))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cargaTotalSite)
                            .addComponent(cargaTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addGroup(PotenciaContinuaLayout.createSequentialGroup()
                        .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PotenciaContinuaLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cargaSolicitada, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(cargaActual)))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(0, 29, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PotenciaContinuaLayout.setVerticalGroup(
            PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PotenciaContinuaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargaSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargaReservadaRect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cargaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PotenciaContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cargaReservadaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(cargaTotalSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        datosPestaEnergia.addTab("Corriente Contínua", PotenciaContinua);

        Baterias.setBorder(javax.swing.BorderFactory.createTitledBorder("Baterías"));

        capacidadBatTotal.setBackground(new java.awt.Color(204, 204, 204));

        jLabel21.setText("Tipo Batería");

        jLabel22.setText("Nº de Bancadas*");

        jLabel23.setText("Cap. bancada*");

        comboTipoBateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Plomo", "NiCd" }));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Capacidad Total");

        javax.swing.GroupLayout BateriasLayout = new javax.swing.GroupLayout(Baterias);
        Baterias.setLayout(BateriasLayout);
        BateriasLayout.setHorizontalGroup(
            BateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BateriasLayout.createSequentialGroup()
                .addGroup(BateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BateriasLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel21))
                    .addGroup(BateriasLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(BateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BateriasLayout.createSequentialGroup()
                        .addComponent(comboTipoBateria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(BateriasLayout.createSequentialGroup()
                        .addGroup(BateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numeroBancadas, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(capacidadBancada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(BateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(capacidadBatTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        BateriasLayout.setVerticalGroup(
            BateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BateriasLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(BateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoBateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroBancadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capacidadBancada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(capacidadBatTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        datosPestaEnergia.addTab("Baterías", Baterias);

        PotenciaAlterna.setBorder(javax.swing.BorderFactory.createTitledBorder("Potencia C.Alterna"));

        jLabel8.setText("Cups");

        jLabel9.setText("T.Energía");

        jLabel10.setText("T.Potencia");

        codigoCups.setBackground(new java.awt.Color(204, 204, 204));

        terminoEnergia.setBackground(new java.awt.Color(204, 204, 204));

        terminoPotencia.setBackground(new java.awt.Color(204, 204, 204));

        jLabel58.setText("Sección acometida");

        seccionAcometida.setBackground(new java.awt.Color(204, 204, 204));

        jLabel59.setText("IGA");

        jLabel60.setText("ICP");

        icp.setBackground(new java.awt.Color(204, 204, 204));

        iga.setBackground(new java.awt.Color(204, 204, 204));

        jLabel61.setText("Conmutador red/grupo");

        conmutador.setBackground(new java.awt.Color(204, 204, 204));

        jLabel62.setText("Cetac");

        cetac.setBackground(new java.awt.Color(204, 204, 204));

        jLabel63.setText("Tipo conexión Cetac");

        cetacCX.setBackground(new java.awt.Color(204, 204, 204));

        jLabel64.setText("Sección tierra");

        seccionTierra.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout PotenciaAlternaLayout = new javax.swing.GroupLayout(PotenciaAlterna);
        PotenciaAlterna.setLayout(PotenciaAlternaLayout);
        PotenciaAlternaLayout.setHorizontalGroup(
            PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PotenciaAlternaLayout.createSequentialGroup()
                .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PotenciaAlternaLayout.createSequentialGroup()
                        .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PotenciaAlternaLayout.createSequentialGroup()
                                .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PotenciaAlternaLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(codigoCups, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PotenciaAlternaLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(terminoPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(PotenciaAlternaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel64)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(seccionAcometida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                .addComponent(terminoEnergia, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(seccionTierra, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PotenciaAlternaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PotenciaAlternaLayout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conmutador, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PotenciaAlternaLayout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cetac, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cetacCX, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PotenciaAlternaLayout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(icp, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PotenciaAlternaLayout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iga, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        PotenciaAlternaLayout.setVerticalGroup(
            PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PotenciaAlternaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoCups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(terminoEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(terminoPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(seccionAcometida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(icp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seccionTierra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addGap(18, 18, 18)
                .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conmutador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PotenciaAlternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cetacCX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addComponent(cetac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        datosPestaEnergia.addTab("Corriente Alterna", PotenciaAlterna);

        datosEnergia.addTab("Datos energía", datosPestaEnergia);

        Climatización.setBorder(javax.swing.BorderFactory.createTitledBorder("Climatización"));

        jLabel65.setText("Nº Climatizadores site");

        jLabel66.setText("Frigorias Sala");

        jLabel68.setText("Consumo en Site");

        TablaClima.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(TablaClima);

        javax.swing.GroupLayout ClimatizaciónLayout = new javax.swing.GroupLayout(Climatización);
        Climatización.setLayout(ClimatizaciónLayout);
        ClimatizaciónLayout.setHorizontalGroup(
            ClimatizaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClimatizaciónLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ClimatizaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ClimatizaciónLayout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(consumoClimatizadores, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ClimatizaciónLayout.createSequentialGroup()
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numeroClimatizadores, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ClimatizaciónLayout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(frigoriasClimatización, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(ClimatizaciónLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ClimatizaciónLayout.setVerticalGroup(
            ClimatizaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClimatizaciónLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(ClimatizaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(numeroClimatizadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ClimatizaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consumoClimatizadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ClimatizaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frigoriasClimatización, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        datosEnergia.addTab("Datos Climatización", Climatización);

        amp.setBorder(javax.swing.BorderFactory.createTitledBorder("Ampliaciones dimensionamiento"));

        jLabel55.setText("Nº de Bancadas");

        jLabel72.setText("Cap. bancada");

        jLabel73.setText("Nº de módulos");

        jLabel74.setText("Cap.rectific");

        javax.swing.GroupLayout ampLayout = new javax.swing.GroupLayout(amp);
        amp.setLayout(ampLayout);
        ampLayout.setHorizontalGroup(
            ampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ampLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ampLayout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addGap(18, 18, 18))
                    .addGroup(ampLayout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(21, 21, 21)))
                .addGroup(ampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(numeroModulosRectificadorAmp, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(numeroBancadasAmp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel74)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(capacidadRectificadorAmp, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(capacidadBancadaAmp))
                .addContainerGap())
        );
        ampLayout.setVerticalGroup(
            ampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ampLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(ampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(numeroBancadasAmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capacidadBancadaAmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(capacidadRectificadorAmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numeroModulosRectificadorAmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel73)))
                .addContainerGap())
        );

        javax.swing.GroupLayout DatosEnergiaClimaLayout = new javax.swing.GroupLayout(DatosEnergiaClima);
        DatosEnergiaClima.setLayout(DatosEnergiaClimaLayout);
        DatosEnergiaClimaLayout.setHorizontalGroup(
            DatosEnergiaClimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatosEnergiaClimaLayout.createSequentialGroup()
                .addGroup(DatosEnergiaClimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosEnergiaClimaLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(amp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(datosEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(Estimaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        DatosEnergiaClimaLayout.setVerticalGroup(
            DatosEnergiaClimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosEnergiaClimaLayout.createSequentialGroup()
                .addGroup(DatosEnergiaClimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Estimaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DatosEnergiaClimaLayout.createSequentialGroup()
                        .addComponent(datosEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(DatosEnergiaClima);

        jLabel53.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel53.setText("Adrástea - v0.2Beta");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel53)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setCalculos() {
  
    // Calculo CargaTotal
    try{
            String cargaActualText = cargaActual.getText().replaceAll("[^\\d.,-]", "");
            int cargaActualValor = Integer.parseInt(cargaActualText);      
            
            String cargaSolicitadaText = cargaSolicitada.getText().replaceAll("[^\\d.,-]", "");
            int cargaSolicitadaValor = Integer.parseInt(cargaSolicitadaText);
            
            String cargaReservadaRectText = cargaReservadaRect.getText().replaceAll("[^\\d.,-]", "");
            int cargaReservadaRectValor = Integer.parseInt(cargaReservadaRectText);
                       
            int cargaTotalValor = cargaActualValor + cargaSolicitadaValor + cargaReservadaRectValor;            
            cargaTotal.setText(cargaTotalValor + " A");
            cargaTotal.setEditable(false);
        }catch (NumberFormatException ex) {
            cargaTotal.setText("0 A");
        }
    
    // Calculo CargaTotal Site
    try{
            String cargaActualText = cargaActual.getText().replaceAll("[^\\d.,-]", "");
            int cargaActualValor = Integer.parseInt(cargaActualText);    
            
            String cargaSolicitadaText = cargaSolicitada.getText().replaceAll("[^\\d.,-]", "");
            int cargaSolicitadaValor = Integer.parseInt(cargaSolicitadaText);
                                
            String cargaReservadaTotalText = cargaReservadaTotal.getText().replaceAll("[^\\d.,-]", "");
            int cargaReservadaTotalValor = Integer.parseInt(cargaReservadaTotalText);
            
            int cargaTotalSiteValor = cargaActualValor + cargaSolicitadaValor + cargaReservadaTotalValor;  

            cargaTotalSite.setText(cargaTotalSiteValor + " A");
            cargaTotalSite.setEditable(false);
        }catch (NumberFormatException ex) {
            cargaTotalSite.setText("0 A");
        }
    
    // Calculo Capacidad Rectificador
    try{
            //Rectificadores actuales
            String numeroModulosRectificadorText = numeroModulosRectificador.getText().replaceAll("[^\\d.,-]", "");
            int numeroModulosRectificadorValor = Integer.parseInt(numeroModulosRectificadorText);      
            String capacidadRectificadorText = capacidadRectificador.getText().replaceAll("[^\\d.,-]", "");            
            int capacidadRectificadorValor = Integer.parseInt(capacidadRectificadorText);
            
            // Rectificadores que amplia el proyecto
            String numeroModulosRectificadorAmpText = numeroModulosRectificadorAmp.getText().replaceAll("[^\\d.,-]", "");
            int numeroModulosRectificadorAmpValor = Integer.parseInt(numeroModulosRectificadorAmpText);  
            String capacidadRectificadorAmpText = capacidadRectificadorAmp.getText().replaceAll("[^\\d.,-]", "");
            int capacidadRectificadorAmpValor = Integer.parseInt(capacidadRectificadorAmpText);  
            
            //Cálculo
            int capacidadRectTotalValor = (numeroModulosRectificadorValor * capacidadRectificadorValor)+(numeroModulosRectificadorAmpValor * capacidadRectificadorAmpValor);            
            capacidadRectTotal.setText(capacidadRectTotalValor + " W");
            capacidadRectTotal.setEditable(false);
        }catch (NumberFormatException ex) {
            capacidadRectTotal.setText("0 W");
        }
    
    // Calculo Capacidad baterías
    try{
            //Baterías actuales
            String numeroBancadasText = numeroBancadas.getText().replaceAll("[^\\d.,-]", "");
            int numeroBancadasValor = Integer.parseInt(numeroBancadasText);      
            String capacidadBancadaText = capacidadBancada.getText().replaceAll("[^\\d.,-]", "");
            int capacidadBancadaValor = Integer.parseInt(capacidadBancadaText);            
            
            
            // String baterías que amplia el proyecto
            String numeroBancadasAmpText = numeroBancadasAmp.getText().replaceAll("[^\\d.,-]", "");
            int numeroBancadasAmpValor = Integer.parseInt(numeroBancadasAmpText);  
            String capacidadBancadaAmpText = capacidadBancadaAmp.getText().replaceAll("[^\\d.,-]", "");
            int capacidadBancadaAmpValor = Integer.parseInt(capacidadBancadaAmpText);  
            
            //Calculos
            int CapacidadBatTotalValor = (numeroBancadasValor * capacidadBancadaValor)+(numeroBancadasAmpValor*capacidadBancadaAmpValor);

            capacidadBatTotal.setText(CapacidadBatTotalValor + " A");
            capacidadBatTotal.setEditable(false);
        }catch (NumberFormatException ex) {
            capacidadBatTotal.setText("0 A");
        }
    
    //Cálculo consumo Alterna en kW
    try{
            String cargaTotalSiteText = cargaTotalSite.getText().replaceAll("[^\\d.,-]", "");
            int cargaTotalSiteValor = Integer.parseInt(cargaTotalSiteText);      
            
            String capacidadBatTotalText = capacidadBatTotal.getText().replaceAll("[^\\d.,-]", "");                      
            int capacidadBatTotalValor = Integer.parseInt(capacidadBatTotalText);
            
            String consumoClimatizadoresText = consumoClimatizadores.getText().replaceAll("[^\\d.,-]", "");                      
            double consumoClimatizadoresValor = Double.parseDouble(consumoClimatizadoresText);                
            
            double ConsumovcAValor = (((cargaTotalSiteValor + (capacidadBatTotalValor/10))*54.48) +(consumoClimatizadoresValor*230))/1000;            
            
            /*Defino el formato a dos decimales y la coma como separador*/
            DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
            simbolo.setDecimalSeparator(',');
            DecimalFormat formato = new DecimalFormat("#,##0.00",simbolo);
            String consumoFormateado = formato.format(ConsumovcAValor);
            
            consumovcA.setText(consumoFormateado + " kW");
            consumovcA.setEditable(false);
        }catch (NumberFormatException ex) {
            consumovcA.setText("0,00 kW");
        }
    
    //Cálculo porcentaje consumo de Alterna, validación y acciones
    try {
        String consumovcAText = consumovcA.getText().replaceAll("[^\\d., ]", ""); // Mantener la coma como separador decimal
        String terminoPotenciaText = terminoPotencia.getText().replaceAll("[^\\d., ]", ""); // Mantener la coma como separador decimal
        
        // Reemplazar ',' por '.' para que el número sea válido
        double consumovcAValor = Double.parseDouble(consumovcAText.replace(',', '.')); 
        double terminoPotenciaValor = Double.parseDouble(terminoPotenciaText.replace(',', '.'));
        
        
        // Calcular el porcentaje correctamente
        double porcentajeConsumovcAValor = (consumovcAValor / terminoPotenciaValor) * 100;
        
        // Formatear el porcentaje con dos decimales y agregar " kW" como unidad
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
            simbolo.setDecimalSeparator(',');
            DecimalFormat porcentaje = new DecimalFormat("#,##0.00",simbolo);
            String porcentajeFormateado = porcentaje.format(porcentajeConsumovcAValor);
        
        porcentajeConsumovcA.setText(porcentajeFormateado + " %");
        porcentajeConsumovcA.setEditable(false);
        accionAlterna.setText("");
        accionAlterna.setFont(new Font("Segoe UI", Font.BOLD, 12));
        accionAlterna.setEditable(false);
        accionAlterna.setLineWrap(true);
        accionAlterna.setWrapStyleWord(true);
        
        // Si el tipo de centro es "PDI" define una excepción en accionAlterna y accionAutonomia al contemplar que estos centros tienen dimensionamiento correcto y generadores.
        
        
        
        // Actualizar el color del JTextField porcentajeConsumovcA
               if (porcentajeConsumovcAValor < 80) {
                    porcentajeConsumovcA.setBackground(Color.GREEN);
                    accionAlterna.setText("Correcto");
                } else if (porcentajeConsumovcAValor >= 80 && porcentajeConsumovcAValor < 90) {
                    porcentajeConsumovcA.setBackground(Color.YELLOW);
                    accionAlterna.setText("Situación gravedad media, es necesario valorar el aumento de potencia contratada");
                } else if (porcentajeConsumovcAValor >= 90 && porcentajeConsumovcAValor <= 100) {
                    porcentajeConsumovcA.setBackground(Color.RED);
                    accionAlterna.setText("Situación gravedad alta, es necesario lanzar el aumento de potencia contratada, no se puede realizar la instalación en base al aumento de consumo indicado con garantías ");
                } else if ( porcentajeConsumovcAValor >= 100){
                    porcentajeConsumovcA.setBackground(Color.RED); 
                    accionAlterna.setText("Situación gravedad crítica, no se puede realizar la instalación en base al aumento de consumo indicado ya que la demanda superá la potencia contratada");
                } else {
                    porcentajeConsumovcA.setBackground(Color.BLACK); 
                    accionAlterna.setText("Situación gravedad crítica, no se puede realizar la instalación en base al aumento de consumo indicado ya que la demanda superá la potencia contratada");
                }
        
        

   } catch (NumberFormatException ex) {
        // Si ocurre un error al parsear los valores, mostrar "0,00 kW"
        porcentajeConsumovcA.setText("0,00 %");
    }
    
    //Cálculo rectificadores necesarios para garanizar redundancia N+1, declara mensaje al campo accionContinua
    try{
            String numeroModulosRectificadorText = numeroModulosRectificador.getText().replaceAll("[^\\d.,-]", "");
            int numeroModulosRectificadorValor = Integer.parseInt(numeroModulosRectificadorText);
            
            String numeroModulosRectificadorAmpText = numeroModulosRectificadorAmp.getText().replaceAll("[^\\d.,-]", "");
            int numeroModulosRectificadorAmpValor = Integer.parseInt(numeroModulosRectificadorAmpText);
            
            String cargaTotalText = cargaTotal.getText().replaceAll("[^\\d.,-]","");
            double cargaTotalValor = Double.parseDouble(cargaTotalText);
            
            String capacidadRectificadorText = capacidadRectificador.getText().replaceAll("[^\\d.,-]","");
            double capacidadRectificadorValor = Double.parseDouble(capacidadRectificadorText);
            
            int MinnRectificadoresValor;
            int faltanRectificadoresValor;
            accionContinua.setText("");
            accionContinua.setFont(new Font("Segoe UI", Font.BOLD, 12));
            accionContinua.setEditable(false);
            accionContinua.setLineWrap(true);
            accionContinua.setWrapStyleWord(true);
            
            int numeroModulosRectificadorResultadoValor = numeroModulosRectificadorValor + numeroModulosRectificadorAmpValor;
            
            
           if(capacidadRectificadorValor !=0){
               MinnRectificadoresValor = (int) Math.ceil((cargaTotalValor*54.48)/capacidadRectificadorValor)+1;
           }else{
            MinnRectificadoresValor = 0;
           }
           if (MinnRectificadoresValor <= numeroModulosRectificadorResultadoValor){
               minnRectificadores.setBackground(Color.GREEN);
               accionContinua.setText("Correcto");
           } else {
               minnRectificadores.setBackground(Color.RED);
               faltanRectificadoresValor = MinnRectificadoresValor - numeroModulosRectificadorResultadoValor;
               accionContinua.setText("No es posible ejecutar la instalación, es necesario ampliar " + faltanRectificadoresValor + " rectificador/es" );               
           }           
            minnRectificadores.setText (MinnRectificadoresValor + " Rectificador/es");
            minnRectificadores.setEditable(false);         
        }catch (NumberFormatException ex) {
            minnRectificadores.setText("0 Rectificador/es");
        }
    
    // Cálculo rectificadores necesarios garantizando la carga de baterías y redundancia N+1, añade mensaje al campo accionContinua
    try{
            String numeroModulosRectificadorText = numeroModulosRectificador.getText().replaceAll("[^\\d.,-]", "");
            int numeroModulosRectificadorValor = Integer.parseInt(numeroModulosRectificadorText);
            
            String numeroModulosRectificadorAmpText = numeroModulosRectificadorAmp.getText().replaceAll("[^\\d.,-]", "");
            int numeroModulosRectificadorAmpValor = Integer.parseInt(numeroModulosRectificadorAmpText);
            
            String cargaTotalText = cargaTotal.getText().replaceAll("[^\\d.,-]","");
            double cargaTotalValor = Double.parseDouble(cargaTotalText);
            
            String capacidadBatTotalText = capacidadBatTotal.getText().replaceAll("[^\\d.,-]","");
            double capacidadBatTotalValor = Double.parseDouble(capacidadBatTotalText);
            
            String capacidadRectificadorText = capacidadRectificador.getText().replaceAll("[^\\d.,-]","");
            double capacidadRectificadorValor = Double.parseDouble(capacidadRectificadorText);
            
            int MinnRectcBatValor;
            int faltanRectificadoresBatValor;
            String AccionContinuaText = accionContinua.getText() + "\n\n";
            accionContinua.setFont(new Font("Segoe UI", Font.BOLD, 12));
            accionContinua.setEditable(false);
            accionContinua.setLineWrap(true);
            accionContinua.setWrapStyleWord(true); 
            
           int numeroModulosRectificadorResultadoValor = numeroModulosRectificadorValor + numeroModulosRectificadorAmpValor;
                   

            
           if(capacidadRectificadorValor !=0){
               MinnRectcBatValor = (int) Math.ceil(((cargaTotalValor+(capacidadBatTotalValor/10))*54.48)/capacidadRectificadorValor)+1;
           }else{
            MinnRectcBatValor = 0;
           }
           if (MinnRectcBatValor <= numeroModulosRectificadorResultadoValor){
               minnRectcBat.setBackground(Color.GREEN);
               accionContinua.setText("Correcto");               
           } else {
               minnRectcBat.setBackground(Color.RED);
               faltanRectificadoresBatValor = MinnRectcBatValor - numeroModulosRectificadorResultadoValor;
               String AccionContinuaTextSinCorrecto = AccionContinuaText.replace("Correcto", "");
               accionContinua.setText(AccionContinuaTextSinCorrecto  + "No es posible garantizar la carga de baterías con el consumo estimado, es necesario revisar el modelo de carga actual y/o ampliar " + faltanRectificadoresBatValor + " rectificador/es");
           }  
            minnRectcBat.setText (MinnRectcBatValor + " Rectificador/es");
            minnRectcBat.setEditable(false);            
        }catch (NumberFormatException ex) {
           minnRectcBat.setText("0 Rectificador/es");           
        }
    
    // Cálculo de carga estimada por fase en alterna
    try {
        String cargaTotalSiteText = cargaTotalSite.getText().replaceAll("[^\\d.,-]","");
        double cargaTotalSiteValor = Double.parseDouble(cargaTotalSiteText);
        
        String capacidadBatTotalText = capacidadBatTotal.getText().replaceAll("[^\\d.,-]","");
        double capacidadBatTotalValor = Double.parseDouble(capacidadBatTotalText);
        
        double L1vcAValor = 0;
        double L2vcAValor = 0;
        double L3vcAValor = 0;
        double trifasicovcAValorClima = 0;
        
        String combocxRectificadorText = null;
        Map<String, Double> valoresConsumo = new HashMap<>();
        
        if (TablaClima.getRowCount() > 0) {
                for (int i = 0; i<TablaClima.getRowCount(); i++){
                Object consumoValor = TablaClima.getValueAt(i, 4);
                Object faseConectada = TablaClima.getValueAt(i, 2);
                
                if (faseConectada != null && consumoValor != null) {
                    String FaseConectada = faseConectada.toString();
                    double consumo = Double.parseDouble(consumoValor.toString().replace(",", "."));

                        if (FaseConectada.equals("L1")){
                            L1vcAValor += consumo;

                        } else if (FaseConectada.equals("L2")){
                            L2vcAValor += consumo;

                        } else if (FaseConectada.equals("L3")){
                            L3vcAValor += consumo;

                        } else if (FaseConectada.equals("Todas")){
                            trifasicovcAValorClima += consumo;
                            double consumoPorFase = consumo / 3.0; 
                            L1vcAValor += consumoPorFase;
                            L2vcAValor += consumoPorFase;
                            L3vcAValor += consumoPorFase;

                        }
                        valoresConsumo.put("L1", L1vcAValor);
                        valoresConsumo.put("L2", L2vcAValor);
                        valoresConsumo.put("L3", L3vcAValor);
                        valoresConsumo.put("Todas", trifasicovcAValorClima);
                }
                }
        }
        if (combocxRectificador != null) {
                Object selectedItem = combocxRectificador.getSelectedItem();
                if (selectedItem != null) {
                    combocxRectificadorText = selectedItem.toString();

                
                if (combocxRectificadorText.equals("Monofásica")) {
                    double resultadoMonofasica = ((cargaTotalSiteValor + (capacidadBatTotalValor/10)) * 54.48) / 230;
                    
                    L1vcAValor += resultadoMonofasica;
                                       
                    L1vcA.setBackground(new Color(204,204,204));
                    L2vcA.setBackground(Color.BLACK);
                    L3vcA.setBackground(Color.BLACK);
                    
                } else if (combocxRectificadorText.equals("Trifásica")) {
                    double resultadoTrifasica = (((cargaTotalSiteValor + (capacidadBatTotalValor/10)) * 54.48) / 3) / 230;
                    
                    L1vcAValor += resultadoTrifasica;
                    L2vcAValor += resultadoTrifasica;
                    L3vcAValor += resultadoTrifasica;
                    L1vcA.setBackground(new Color(204,204,204));
                    L2vcA.setBackground(new Color(204,204,204));
                    L3vcA.setBackground(new Color(204,204,204));                               
                } else {
                    L1vcA.setText("N/A");
                    L2vcA.setText("N/A");
                    L3vcA.setText("N/A");
                }
            } else {               
            } 
            
            DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
            simbolo.setDecimalSeparator(',');
            DecimalFormat formato = new DecimalFormat("#,##0.00",simbolo);
            String L1vcAFormateado = formato.format(L1vcAValor);
            String L2vcAFormateado = formato.format(L2vcAValor);
            String L3vcAFormateado = formato.format(L3vcAValor);


            L1vcA.setText(L1vcAFormateado + " A");
            L1vcA.setEditable(false);
            L2vcA.setText(L2vcAFormateado + " A");
            L2vcA.setEditable(false);
            L3vcA.setText(L3vcAFormateado + " A");
            L3vcA.setEditable(false);
            }
            
        } catch (NumberFormatException e){
        System.err.println("Error al convertir el valor a double: " + e.getMessage()); 
        }
    
    
    // Cálculo de carga máxima por fase en alterna con rectificadores actuales
    try{
            String capacidadRectTotalText = capacidadRectTotal.getText().replaceAll("[^\\d.,-]", "");
            int capacidadRectTotalValor = Integer.parseInt(capacidadRectTotalText);
            
                                             
            double MaxvcAFaseValor = 0;
            String combocxRectificadorText = null;
            if (combocxRectificador != null) {
                Object selectedItem = combocxRectificador.getSelectedItem();
                if (selectedItem != null) {
                    combocxRectificadorText = selectedItem.toString();
                }
            }
            if (combocxRectificadorText != null) {                        
                if (combocxRectificadorText.equals("Monofásica")) {
                MaxvcAFaseValor = capacidadRectTotalValor/230.0;                                        
                } else if (combocxRectificadorText.equals("Trifásica")){
                MaxvcAFaseValor = (capacidadRectTotalValor/3.0 )/230.0;                                       
                } else {                    
                }
            } else {               
            }
                
            
            DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
            simbolo.setDecimalSeparator(',');
            DecimalFormat formato = new DecimalFormat("#,##0.00",simbolo);
            String valorFormateado = formato.format(MaxvcAFaseValor);
            
            maxvcAFase.setText (valorFormateado + " A");
            maxvcAFase.setEditable(false);         
        }catch (NumberFormatException ex) {
            maxvcAFase.setText("0 A");
        }

    // Cálculo de carga máxima por fase en alterna con rectificadores necesarios
    try {
    String MinnRectcBatText = minnRectcBat.getText().replaceAll("[^\\d.,-]", "");
    int MinnRectcBatValor = Integer.parseInt(MinnRectcBatText);
        
    String capacidadRectificadorText = capacidadRectificador.getText().replaceAll("[^\\d.,-]","");
    double capacidadRectificadorValor = Double.parseDouble(capacidadRectificadorText);
    
    double MaxvcAFase2Valor = 0;
    String combocxRectificadorText = null;
    if (combocxRectificador != null) {
        Object selectedItem = combocxRectificador.getSelectedItem();
        if (selectedItem != null) {
            combocxRectificadorText = selectedItem.toString();
            
            if (combocxRectificadorText.equals("Monofásica")) {
                MaxvcAFase2Valor = (MinnRectcBatValor * capacidadRectificadorValor) / 230.0;                                      
            } else if (combocxRectificadorText.equals("Trifásica")) {
                MaxvcAFase2Valor = ((MinnRectcBatValor * capacidadRectificadorValor) / 3.0) / 230.0;           
            } else {
                // Manejar otros casos si es necesario
            }
        }
    }
    
    DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    simbolo.setDecimalSeparator(',');
    DecimalFormat formato = new DecimalFormat("#,##0.00",simbolo);
    String valorFormateado = formato.format(MaxvcAFase2Valor);
    
    
    maxvcAFase2.setText (valorFormateado + " A");
    maxvcAFase2.setEditable(false);         
} catch (NumberFormatException ex) {
    maxvcAFase2.setText("0 A");
    
}
    
    // Cálculo de carga estimada por fase en contínua
    try{
        String cargaTotalText = cargaTotal.getText().replaceAll("[^\\d.,-]", "");
        int cargaTotalValor = Integer.parseInt(cargaTotalText);   
            
            
        double fasesvcCValor = 0;
        String combocxMagnetoText = null;
    if (combocxMagneto != null) {
        Object selectedItem = combocxMagneto.getSelectedItem();
        if (selectedItem != null) {
            combocxMagnetoText = selectedItem.toString();                
        if (combocxMagnetoText.equals("Monofásico")) {
            fasesvcCValor = cargaTotalValor;
            } else if (combocxMagnetoText.equals("Trifásico")){
            fasesvcCValor = cargaTotalValor / 3.0;
            } else {
                // Manejar otros casos si es necesario
            }
        }
    }
            
            DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
            simbolo.setDecimalSeparator(',');
            DecimalFormat formato = new DecimalFormat("#,##0.00",simbolo);
            String valorFormateado = formato.format(fasesvcCValor);
            
            fasesvcC.setText (valorFormateado + " A");
            fasesvcC.setEditable(false);         
        }catch (NumberFormatException ex) {
            fasesvcC.setText("0 A");
        }
    
    // Cálculo de carga máxima por fase en contínua con rectificadores actuales
    try{
            String capacidadRectTotalText = capacidadRectTotal.getText().replaceAll("[^\\d.,-]", "");
            int capacidadRectTotalValor = Integer.parseInt(capacidadRectTotalText);
            
            double MaxvcCFaseValor = 0;
            String combocxMagnetoText = null;
    if (combocxMagneto != null) {
        Object selectedItem = combocxMagneto.getSelectedItem();
        if (selectedItem != null) {
            combocxMagnetoText = selectedItem.toString();  
            
            if (combocxMagnetoText.equals("Monofásico")) {
            MaxvcCFaseValor = capacidadRectTotalValor/54.48;                 
            } else if(combocxMagnetoText.equals("Trifásico")){
            MaxvcCFaseValor = (capacidadRectTotalValor/3.0 )/54.48;
            }else {
               
            }
        }
    }
            
            DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
            simbolo.setDecimalSeparator(',');
            DecimalFormat formato = new DecimalFormat("#,##0.00",simbolo);
            String valorFormateado = formato.format(MaxvcCFaseValor);
            
            maxvcCFase.setText (valorFormateado + " A");
            maxvcCFase.setEditable(false);         
        }catch (NumberFormatException ex) {
            maxvcCFase.setText("0 A");
        }
    
    // Cálculo de carga máxima por fase en contínua con rectificadores necesarios
    try{
            String MinnRectcBatText = minnRectcBat.getText().replaceAll("[^\\d.,-]", "");
            int MinnRectcBatValor = Integer.parseInt(MinnRectcBatText);           
            
            String capacidadRectificadorText = capacidadRectificador.getText().replaceAll("[^\\d.,-]","");
            double capacidadRectificadorValor = Double.parseDouble(capacidadRectificadorText);
            
            double MaxvcCFase2Valor = 0;
            String combocxMagnetoText = null;
            if (combocxMagneto != null) {
                Object selectedItem = combocxMagneto.getSelectedItem();
                if (selectedItem != null) {
                    combocxMagnetoText = selectedItem.toString();  
            
            if (combocxMagnetoText.equals("Monofásico")) {
            MaxvcCFase2Valor = (MinnRectcBatValor*capacidadRectificadorValor)/54.48;
            } else if(combocxMagnetoText.equals("Trifásico")){
            MaxvcCFase2Valor = ((MinnRectcBatValor*capacidadRectificadorValor)/3 )/54.48;
            }else {
            
            }
        }
    }
            
            
            DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
            simbolo.setDecimalSeparator(',');
            DecimalFormat formato = new DecimalFormat("#,##0.00",simbolo);
            String valorFormateado = formato.format(MaxvcCFase2Valor);
            
            maxvcCFase2.setText (valorFormateado + " A");
            maxvcCFase2.setEditable(false);         
        }catch (NumberFormatException ex) {
            maxvcCFase2.setText("0 A");
        }
    
    
    
    //Cálculo autonomái de baterías, declara mensaje accionAutonomia
    try{
            String cargaTotalText = cargaTotal.getText().replaceAll("[^\\d.,-]","");
            double cargaTotalValor = Double.parseDouble(cargaTotalText);
            
            String capacidadBatTotalText = capacidadBatTotal.getText().replaceAll("[^\\d.,-]","");
            double capacidadBatTotalValor = Double.parseDouble(capacidadBatTotalText);
            
            accionAutonomia.setText("");
            accionAutonomia.setFont(new Font("Segoe UI", Font.BOLD, 12));
            accionAutonomia.setEditable(false);
            accionAutonomia.setLineWrap(true);
            accionAutonomia.setWrapStyleWord(true);  
                        
            double AutonomiaBateriasValor = (capacidadBatTotalValor/cargaTotalValor) - (((capacidadBatTotalValor/cargaTotalValor)*12)/100);
                   
            
            /*Defino el formato a dos decimales y la coma como separador*/
            DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
            simbolo.setDecimalSeparator(',');
            DecimalFormat formato = new DecimalFormat("#,##0.00",simbolo);
            String autonomiaFormateado = formato.format(AutonomiaBateriasValor);
            
                if (AutonomiaBateriasValor >= 8){
                   autonomiaBaterias.setBackground(Color.GREEN);
                   accionAutonomia.setText("Correcto");               
               } else if (AutonomiaBateriasValor >=6.5 && AutonomiaBateriasValor <8) {
                   autonomiaBaterias.setBackground(Color.ORANGE);
                   accionAutonomia.setText("Situación gravedad media, es necesario valorar aumento de bancada de baterías o sustitución de las actuales por otras de mayor capacidad");
               } else if  (AutonomiaBateriasValor  <6.5) {
                   autonomiaBaterias.setBackground(Color.RED);
                   accionAutonomia.setText("Situación gravedad crítica, no se puede ejecutar la instalación, es necesario valorar aumento de bancada de baterías o sustitución de las actuales por otras de mayor capacidad");
               } else {
                autonomiaBaterias.setBackground(Color.BLACK);            
               }
            
            autonomiaBaterias.setText (autonomiaFormateado + " horas");
            autonomiaBaterias.setEditable(false);         
        }catch (NumberFormatException ex) {
            autonomiaBaterias.setText("0 horas");
        }
    
    // Calculo carga termica con el consumo actual
    try{
        String cargaActualText = cargaActual.getText().replaceAll("[^\\d.,-]", "");
        
        int cargaActualValor = Integer.parseInt(cargaActualText);
        double cargaTermicaActualValor = (cargaActualValor * 54.48) + 200;
        
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        DecimalFormat formato = new DecimalFormat("#,##000",simbolo);
        String cargaTermicaFormateado = formato.format(cargaTermicaActualValor);
        
        
        cargaTermicaActual.setText(cargaTermicaFormateado + " W");
        cargaTermicaActual.setEditable(false);
        
        
    } catch (NumberFormatException ex) {
            cargaTermicaActual.setText("0 W");        
    }
    
    
    // Calculo carga termica con el consumo futuro
    try{
        String cargaTotalSiteText = cargaTotalSite.getText().replaceAll("[^\\d.,-]", "");
        int cargaTotalSiteValor = Integer.parseInt(cargaTotalSiteText);
        double cargaTermicaFuturaValor = (cargaTotalSiteValor * 54.48) + 200;
        
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        DecimalFormat formato = new DecimalFormat("#,##000",simbolo);
        String cargaTermicaFuturaFormateado = formato.format(cargaTermicaFuturaValor);        
        
        cargaTermicaFutura.setText(cargaTermicaFuturaFormateado + " W");
        cargaTermicaFutura.setEditable(false);
    } catch (NumberFormatException ex) {
            cargaTermicaFutura.setText("0 W");        
    }    
 
    // Porcentaje climatización
        try {
        String cargaTermicaFuturaText = cargaTermicaFutura.getText().replaceAll("[^\\d., ]", ""); // Mantener la coma como separador decimal
        String frigoriasClimatizaciónText = frigoriasClimatización.getText().replaceAll("[^\\d., ]", ""); // Mantener la coma como separador decimal
        
        // Reemplazar ',' por '.' para que el número sea válido
        double cargaTermicaFuturaValor = Double.parseDouble(cargaTermicaFuturaText); 
        double frigoriasClimatizaciónValor = Double.parseDouble(frigoriasClimatizaciónText);
        
        
        // Calcular el porcentaje correctamente
        double porcentajeCargaTermicaValor = (cargaTermicaFuturaValor / frigoriasClimatizaciónValor ) * 100;
        
        // Formatear el porcentaje con dos decimales y agregar " kW" como unidad
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
            simbolo.setDecimalSeparator(',');
            DecimalFormat porcentaje = new DecimalFormat("#,##0.00",simbolo);
            String porcentajeFormateado = porcentaje.format(porcentajeCargaTermicaValor);
        
        porcentajeClima.setText(porcentajeFormateado + " %");
        porcentajeClima.setEditable(false);
        accionClimatizacion.setText("");
        accionClimatizacion.setFont(new Font("Segoe UI", Font.BOLD, 12));
        accionClimatizacion.setEditable(false);
        accionClimatizacion.setLineWrap(true);
        accionClimatizacion.setWrapStyleWord(true);
        
       
        // Actualizar el color del JTextField porcentajeConsumovcA
               if (porcentajeCargaTermicaValor < 80) {
                    porcentajeClima.setBackground(Color.GREEN);
                    accionClimatizacion.setText("Correcto");
                } else if (porcentajeCargaTermicaValor >= 80 && porcentajeCargaTermicaValor < 90) {
                    porcentajeClima.setBackground(Color.YELLOW);
                    accionClimatizacion.setText("Situación gravedad media, es necesario valorar el aumento de frigorías");
                } else if (porcentajeCargaTermicaValor >= 90 && porcentajeCargaTermicaValor <= 100) {
                    porcentajeClima.setBackground(Color.RED);
                    accionClimatizacion.setText("Situación gravedad alta, es necesario lanzar el aumento de frigorias para garantizar un correcto dimensionamiento térmico, no se puede realizar la instalación en base al aumento de consumo indicado con garantías ");
                } else if ( porcentajeCargaTermicaValor >= 100){
                    porcentajeClima.setBackground(Color.RED); 
                    accionClimatizacion.setText("Situación gravedad crítica, no se puede realizar la instalación en base al aumento de consumo indicado supera la carga termica que puede soportar la sala");
                } else {
                    porcentajeClima.setBackground(Color.BLACK); 
                    accionClimatizacion.setText("Situación gravedad crítica, no se puede realizar la instalación en base al aumento de consumo indicado ya que la demanda superá la carga térmica garantizada");
                }
        
        

    } catch (NumberFormatException ex) {
        // Si ocurre un error al parsear los valores, mostrar "0,00 kW"
        porcentajeClima.setText("0,00 %");
    }
    
    // Parametrización climatización normalizada
    try {
    String cargaTermicaFuturaText = cargaTermicaFutura.getText().replaceAll("[^\\d.,-]", "");
    double cargaTermicaFuturaValor = Double.parseDouble(cargaTermicaFuturaText);
    
    double climatizacionNormalizadaFinal = cargaTermicaFuturaValor * 1.3;


    if (cargaTermicaFuturaValor < 2000) {
        climatizacionNormalizadaFinal = 2.5;
    } else if (cargaTermicaFuturaValor < 3000) {
        climatizacionNormalizadaFinal = 3.5;
    } else if (cargaTermicaFuturaValor < 5000) {
        climatizacionNormalizadaFinal = 5;
    } else if (cargaTermicaFuturaValor < 7000) {
        climatizacionNormalizadaFinal = 7;
    } else if (cargaTermicaFuturaValor < 10000) {
        climatizacionNormalizadaFinal = 10;
    } else if (cargaTermicaFuturaValor < 12000) {
        climatizacionNormalizadaFinal = 12;
    } else if (cargaTermicaFuturaValor < 14000) {
        climatizacionNormalizadaFinal = 14;
    } else {
        climatizacionNormalizadaFinal = 0; // Si no se cumple ninguna condición, asigna 0
    }

    climatizacionNormalizada.setText(climatizacionNormalizadaFinal + " kW"); // Convierte el valor final a String antes de asignarlo al campo de texto
} catch (NumberFormatException ex) {
    // Manejar la excepción si el valor de cargaTermicaFutura no es un número válido
    ex.printStackTrace();
    }
}

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        
        
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(InitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new InitForm().setVisible(true);
        }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Baterias;
    private javax.swing.JPanel Climatización;
    private javax.swing.JPanel CxRectificador;
    private javax.swing.JPanel DatosEnergiaClima;
    private javax.swing.JPanel Estimaciones;
    private javax.swing.JPanel Estimaciones1;
    private javax.swing.JPanel Estimaciones2;
    private javax.swing.JPanel Estimaciones3;
    private javax.swing.JPanel Estimaciones4;
    private javax.swing.JTextField L1vcA;
    private javax.swing.JTextField L2vcA;
    private javax.swing.JTextField L3vcA;
    private javax.swing.JPanel PotenciaAlterna;
    private javax.swing.JPanel PotenciaContinua;
    private javax.swing.JPanel Rectificadores;
    private javax.swing.JTable TablaClima;
    private javax.swing.JTable TablaRacks;
    private javax.swing.JTextArea accionAlterna;
    private javax.swing.JTextArea accionAutonomia;
    private javax.swing.JTextArea accionClimatizacion;
    private javax.swing.JTextArea accionContinua;
    private javax.swing.JPanel amp;
    private javax.swing.JTextField autonomiaBaterias;
    private javax.swing.JTextField capacidadBancada;
    private javax.swing.JTextField capacidadBancadaAmp;
    private javax.swing.JTextField capacidadBatTotal;
    private javax.swing.JTextField capacidadRectTotal;
    private javax.swing.JTextField capacidadRectificador;
    private javax.swing.JTextField capacidadRectificadorAmp;
    private javax.swing.JTextField cargaActual;
    private javax.swing.JTextField cargaReservadaRect;
    private javax.swing.JTextField cargaReservadaTotal;
    private javax.swing.JTextField cargaSolicitada;
    private javax.swing.JTextField cargaTermicaActual;
    private javax.swing.JTextField cargaTermicaFutura;
    private javax.swing.JTextField cargaTotal;
    private javax.swing.JTextField cargaTotalSite;
    private javax.swing.JTextField cetac;
    private javax.swing.JTextField cetacCX;
    private javax.swing.JTextField climatizacionNormalizada;
    private javax.swing.JTextField codigoCups;
    private javax.swing.JComboBox<String> comboRectificador;
    private javax.swing.JComboBox<String> comboTipoBateria;
    private javax.swing.JComboBox<String> combocxMagneto;
    private javax.swing.JComboBox<String> combocxRectificador;
    private javax.swing.JTextField conmutador;
    private javax.swing.JTextField consumoClimatizadores;
    private javax.swing.JTextField consumovcA;
    private javax.swing.JTabbedPane datosEnergia;
    private javax.swing.JTabbedPane datosPestaEnergia;
    private javax.swing.JTextField fasesvcC;
    private javax.swing.JTextField frigoriasClimatización;
    private javax.swing.JTextField icp;
    private javax.swing.JTextField iga;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField magnetoCorte;
    private javax.swing.JTextField maxvcAFase;
    private javax.swing.JTextField maxvcAFase2;
    private javax.swing.JTextField maxvcCFase;
    private javax.swing.JTextField maxvcCFase2;
    private javax.swing.JTextField minnRectcBat;
    private javax.swing.JTextField minnRectificadores;
    private javax.swing.JTextField numeroBancadas;
    private javax.swing.JTextField numeroBancadasAmp;
    private javax.swing.JTextField numeroClimatizadores;
    private javax.swing.JTextField numeroModulosRectificador;
    private javax.swing.JTextField numeroModulosRectificadorAmp;
    private javax.swing.JPanel panelValidacionAcciones;
    private javax.swing.JTextField porcentajeClima;
    private javax.swing.JTextField porcentajeConsumovcA;
    private javax.swing.JTextField seccionAcometida;
    private javax.swing.JTextField seccionCableRectificador;
    private javax.swing.JTextField seccionTierra;
    private javax.swing.JTextField terminoEnergia;
    private javax.swing.JTextField terminoPotencia;
    // End of variables declaration//GEN-END:variables
}




