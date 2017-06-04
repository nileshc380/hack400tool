//    "hack400tool"
//    - security handling tools for IBM Power Systems (formerly known as AS/400)
//    Copyright (C) 2010-2016  Bart Kulach
//    This file, HackUI.java, is part of hack400tool package.

//    "hack400tool" is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.

//    "hack400tool" is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.

//   You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
package org.hackthelegacy.hack400tool.ibmiscannergui;

import org.hackthelegacy.hack400tool.ibmiscannercore.TextAreaOutputStream;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.IFSJavaFile;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.User;
import java.awt.BorderLayout;
import org.hackthelegacy.hack400tool.ibmiscannercore.IBMiConnector;
import org.hackthelegacy.hack400tool.ibmiscannercore.SqliteDbConnector;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.Vector;
import javafx.scene.layout.Border;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.bind.DatatypeConverter;

public class HackUI extends javax.swing.JFrame {

    private IBMiConnector testSystem;
    public SqliteDbConnector dbConnection;
    private ByteArrayOutputStream bstdout, bstderr;
    private PrintStream stdouterr;
    private String jarPath;
    private File jarFile;
    
    public HackUI() throws IOException {
        jarFile = new File(HackUI.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        jarPath = jarFile.getParentFile().getPath();
        initComponents();
        String fileName = new SimpleDateFormat("YYMMddHHmmSS").format(new Date());
        stdouterr = new PrintStream(new TextAreaOutputStream(logTextArea, "", jarPath 
                                    + File.separator + "log" + File.separator + fileName + ".log"));
        System.setErr(stdouterr);
        System.setOut(stdouterr);       

        Logger.getLogger(HackUI.class.getName()).log(Level.INFO, jarPath);                
    }


    
    private void modifyJChooser(Component[] jc) {

    for (int i = 0; i < jc.length; i++) {
        Component c = jc[i];
        
        if (c instanceof JComboBox) {
            c.getParent().remove(c);
        } else if (c instanceof JLabel) {
            c.getParent().remove(c);
        } else if (c instanceof JButton) {
            ;
        } else if (c instanceof JTextField) {
            c.getParent().remove(c);
        }

        if (c instanceof Container) {
            try {    
                modifyJChooser(((Container) c).getComponents());
            } catch (Exception ex) {
            }
        }
        
    }

}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        life400ConnectionButtonGroup = new javax.swing.ButtonGroup();
        CLCommandExecutionButtonGroup = new javax.swing.ButtonGroup();
        ShellCommandExecutionButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tabAreaUI = new javax.swing.JTabbedPane();
        ConnectionConfigPane = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        temporaryLibTextField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        createTempLib = new javax.swing.JCheckBox();
        useSSL = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        systemName = new javax.swing.JTextField();
        outputDirFolderTextField = new javax.swing.JTextField();
        browseDirsButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        useJDBC = new javax.swing.JCheckBox();
        CLCommandPane = new javax.swing.JPanel();
        CLCommandText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CLCommandButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CLCommandOutput = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        CLCommandPlainExec = new javax.swing.JRadioButton();
        CLCommandJDBCExec = new javax.swing.JRadioButton();
        CLCommandPASEExec = new javax.swing.JRadioButton();
        WRKOBJpane = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        objName = new javax.swing.JTextField();
        libName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        objType = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        privList = new javax.swing.JTextArea();
        buttonWRKOBJ = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        objList = new javax.swing.JTable();
        authorizedObjectsOnlyCheckBox = new javax.swing.JCheckBox();
        displayMemberPane = new javax.swing.JPanel();
        objNameEdit = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        libNameEdit = new javax.swing.JTextField();
        objMemberEdit = new javax.swing.JTextField();
        buttonDisplayObjectMember = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        limitCountFrom = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        limitCountTo = new javax.swing.JTextField();
        buttonApplyChangesMember = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        objMemberContents = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        changesTable = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        buttonClearChangesTable = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SQLpane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        SQLCommandTextArea = new javax.swing.JTextArea();
        SQLResultTabPane = new javax.swing.JTabbedPane();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        maxRowsTextField = new javax.swing.JTextField();
        privilegeEscalatorPane = new javax.swing.JPanel();
        generateUserListButton = new javax.swing.JButton();
        escalatePrivilegesButton = new javax.swing.JButton();
        deescalatePrivilegesButton = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        privilegeEscalatorUserList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        FirstDEShashTextField = new javax.swing.JTextField();
        SecondDEShashTextField = new javax.swing.JTextField();
        LMHashTextField = new javax.swing.JTextField();
        FirstHMAChashTextField = new javax.swing.JTextField();
        SecondHMAChashTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        UnknownHashTextArea = new javax.swing.JTextArea();
        LMHashCopyButton = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        userNameHashLabel = new javax.swing.JLabel();
        FirstDESHashCopyButton = new javax.swing.JButton();
        FirstHMACHashCopyButton = new javax.swing.JButton();
        SecondHMACHashCopyButton = new javax.swing.JButton();
        UnknownHashCopyButton = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        DEShashTextField = new javax.swing.JTextField();
        DESHashCopyButton = new javax.swing.JButton();
        GrabHashButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        cancelButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ConnectionConfigPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Username:");

        jLabel10.setText("Password:");

        jLabel8.setText("Temporary library:");

        temporaryLibTextField.setText("QTEMP");

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        createTempLib.setText("Create at connect");

        useSSL.setText("Use SSL");

        jLabel6.setText("Directory to store output:");

        jLabel2.setText("IP address or DNS name:");

        outputDirFolderTextField.setText(jarPath + File.separator + "output");

        browseDirsButton.setText("Browse...");
        browseDirsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseDirsButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.setEnabled(false);
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        useJDBC.setSelected(true);
        useJDBC.setText("Use JDBC");

        javax.swing.GroupLayout ConnectionConfigPaneLayout = new javax.swing.GroupLayout(ConnectionConfigPane);
        ConnectionConfigPane.setLayout(ConnectionConfigPaneLayout);
        ConnectionConfigPaneLayout.setHorizontalGroup(
            ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectionConfigPaneLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(ConnectionConfigPaneLayout.createSequentialGroup()
                        .addComponent(outputDirFolderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseDirsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConnectionConfigPaneLayout.createSequentialGroup()
                        .addGroup(ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(systemName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(useSSL)
                            .addComponent(useJDBC))
                        .addGroup(ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ConnectionConfigPaneLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel10))
                            .addGroup(ConnectionConfigPaneLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(createTempLib)
                                    .addGroup(ConnectionConfigPaneLayout.createSequentialGroup()
                                        .addGroup(ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(temporaryLibTextField)
                                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(disconnectButton)))))))
                .addContainerGap(608, Short.MAX_VALUE))
        );

        ConnectionConfigPaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {systemName, userNameField});

        ConnectionConfigPaneLayout.setVerticalGroup(
            ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectionConfigPaneLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(systemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(temporaryLibTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton)
                    .addComponent(disconnectButton))
                .addGap(3, 3, 3)
                .addGroup(ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createTempLib)
                    .addComponent(useSSL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(useJDBC)
                .addGap(9, 9, 9)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ConnectionConfigPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputDirFolderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseDirsButton))
                .addContainerGap(264, Short.MAX_VALUE))
        );

        tabAreaUI.addTab("Connection configuration", ConnectionConfigPane);

        CLCommandPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Enter command:");

        CLCommandButton.setText("Run CL command");
        CLCommandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLCommandButtonActionPerformed(evt);
            }
        });

        CLCommandOutput.setColumns(20);
        CLCommandOutput.setRows(5);
        jScrollPane2.setViewportView(CLCommandOutput);

        jLabel12.setText("Command output:");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Command execution mode"));

        CLCommandExecutionButtonGroup.add(CLCommandPlainExec);
        CLCommandPlainExec.setSelected(true);
        CLCommandPlainExec.setText("Plain command execution (CL)");

        CLCommandExecutionButtonGroup.add(CLCommandJDBCExec);
        CLCommandJDBCExec.setText("Execution via JDBC");

        CLCommandExecutionButtonGroup.add(CLCommandPASEExec);
        CLCommandPASEExec.setText("Execution via PASE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CLCommandPlainExec)
                .addGap(69, 69, 69)
                .addComponent(CLCommandJDBCExec)
                .addGap(53, 53, 53)
                .addComponent(CLCommandPASEExec)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CLCommandPlainExec)
                    .addComponent(CLCommandJDBCExec)
                    .addComponent(CLCommandPASEExec))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CLCommandPaneLayout = new javax.swing.GroupLayout(CLCommandPane);
        CLCommandPane.setLayout(CLCommandPaneLayout);
        CLCommandPaneLayout.setHorizontalGroup(
            CLCommandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CLCommandPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CLCommandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1303, Short.MAX_VALUE)
                    .addGroup(CLCommandPaneLayout.createSequentialGroup()
                        .addComponent(CLCommandText)
                        .addGap(18, 18, 18)
                        .addComponent(CLCommandButton))
                    .addGroup(CLCommandPaneLayout.createSequentialGroup()
                        .addGroup(CLCommandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CLCommandPaneLayout.setVerticalGroup(
            CLCommandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CLCommandPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CLCommandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CLCommandText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLCommandButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabAreaUI.addTab("Execute CL commands", CLCommandPane);

        WRKOBJpane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Object . . . . . . . . :");

        jLabel14.setText("Library . . . . . . :");

        jLabel15.setText("Object type . . . . :");

        privList.setEditable(false);
        privList.setColumns(20);
        privList.setFont(new java.awt.Font("Courier", 0, 12)); // NOI18N
        privList.setRows(5);
        jScrollPane5.setViewportView(privList);

        buttonWRKOBJ.setText("Search");
        buttonWRKOBJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWRKOBJActionPerformed(evt);
            }
        });

        objList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        objList.setRowSelectionAllowed(true);
        objList.setColumnSelectionAllowed(false);
        objList.setCellSelectionEnabled(false);
        objList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        objList.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                try {
                    privList.setText(testSystem.printQSYSPrivileges(objList.getValueAt(objList.getSelectedRow(), 0).toString(),objList.getValueAt(objList.getSelectedRow(), 1).toString(),objList.getValueAt(objList.getSelectedRow(), 2).toString()));
                } catch (Exception ex) {
                    Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jScrollPane6.setViewportView(objList);

        authorizedObjectsOnlyCheckBox.setText("Show only objects you are authorized to");

        javax.swing.GroupLayout WRKOBJpaneLayout = new javax.swing.GroupLayout(WRKOBJpane);
        WRKOBJpane.setLayout(WRKOBJpaneLayout);
        WRKOBJpaneLayout.setHorizontalGroup(
            WRKOBJpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WRKOBJpaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WRKOBJpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WRKOBJpaneLayout.createSequentialGroup()
                        .addGroup(WRKOBJpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(WRKOBJpaneLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(libName, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(WRKOBJpaneLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(objName, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(WRKOBJpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(authorizedObjectsOnlyCheckBox)
                                .addGroup(WRKOBJpaneLayout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(18, 18, 18)
                                    .addComponent(objType, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addComponent(buttonWRKOBJ))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                .addContainerGap())
        );
        WRKOBJpaneLayout.setVerticalGroup(
            WRKOBJpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WRKOBJpaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WRKOBJpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WRKOBJpaneLayout.createSequentialGroup()
                        .addGroup(WRKOBJpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(objName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WRKOBJpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(libName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(buttonWRKOBJ))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WRKOBJpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(objType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(authorizedObjectsOnlyCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabAreaUI.addTab("Work with Objects", WRKOBJpane);

        displayMemberPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("Object . . . . . . . . :");

        jLabel17.setText("Library . . . . . . :");

        jLabel18.setText("Member  . . . . . . :");

        objMemberEdit.setText("%FIRST%");

        buttonDisplayObjectMember.setText("Display");
        buttonDisplayObjectMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDisplayObjectMemberActionPerformed(evt);
            }
        });

        jLabel19.setText("Limit row count:");

        limitCountFrom.setText("1");

        jLabel20.setText("From:");

        jLabel21.setText("To:");

        limitCountTo.setText("500");

        buttonApplyChangesMember.setText("Apply and save changes");
        buttonApplyChangesMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApplyChangesMemberActionPerformed(evt);
            }
        });

        jScrollPane7.setAutoscrolls(true);

        objMemberContents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        objMemberContents.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        objMemberContents.setCellEditor(new MemberEditTableCellEditor());
        objMemberContents.setCellSelectionEnabled(true);
        objMemberContents.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                try {
                    //
                } catch (Exception ex) {
                    Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jScrollPane7.setViewportView(objMemberContents);

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));

        changesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Column", "Original value", "New value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(changesTable);
        if (changesTable.getColumnModel().getColumnCount() > 0) {
            changesTable.getColumnModel().getColumn(0).setResizable(false);
            changesTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            changesTable.getColumnModel().getColumn(1).setResizable(false);
            changesTable.getColumnModel().getColumn(1).setPreferredWidth(10);
            changesTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel22.setText("Changes:");

        buttonClearChangesTable.setText("Clear changes table");
        buttonClearChangesTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearChangesTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displayMemberPaneLayout = new javax.swing.GroupLayout(displayMemberPane);
        displayMemberPane.setLayout(displayMemberPaneLayout);
        displayMemberPaneLayout.setHorizontalGroup(
            displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayMemberPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(displayMemberPaneLayout.createSequentialGroup()
                        .addComponent(buttonClearChangesTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonApplyChangesMember))
                    .addGroup(displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(displayMemberPaneLayout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addGap(65, 65, 65)
                            .addComponent(limitCountFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel21)
                            .addGap(12, 12, 12)
                            .addComponent(limitCountTo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel22))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, displayMemberPaneLayout.createSequentialGroup()
                        .addGroup(displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(displayMemberPaneLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(libNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(displayMemberPaneLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(objNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(displayMemberPaneLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addGroup(displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(objMemberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonDisplayObjectMember)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                .addContainerGap())
        );
        displayMemberPaneLayout.setVerticalGroup(
            displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayMemberPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, displayMemberPaneLayout.createSequentialGroup()
                        .addGroup(displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(objNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(buttonDisplayObjectMember))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(libNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(objMemberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(limitCountFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(limitCountTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addGroup(displayMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonApplyChangesMember)
                            .addComponent(buttonClearChangesTable))
                        .addGap(12, 12, 12))
                    .addGroup(displayMemberPaneLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        tabAreaUI.addTab("Display/Edit Object Member", displayMemberPane);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("\\");
            jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
            jScrollPane9.setViewportView(jTree1);

            jTextArea1.setColumns(20);
            jTextArea1.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
            jTextArea1.setRows(5);
            jScrollPane10.setViewportView(jTextArea1);

            jButton1.setText("Refresh view");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
            ));
            jScrollPane12.setViewportView(jTable1);

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane10)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
                    .addContainerGap())
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );

            tabAreaUI.addTab("IFS explorer", jPanel3);

            jLabel1.setText("SQL command(s) to run:");

            jLabel3.setText("Result:");

            SQLCommandTextArea.setColumns(20);
            SQLCommandTextArea.setRows(5);
            jScrollPane13.setViewportView(SQLCommandTextArea);

            jButton7.setText("Execute query");
            jButton7.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton7ActionPerformed(evt);
                }
            });

            jLabel4.setText("Max rows:");

            maxRowsTextField.setText("1000");

            javax.swing.GroupLayout SQLpaneLayout = new javax.swing.GroupLayout(SQLpane);
            SQLpane.setLayout(SQLpaneLayout);
            SQLpaneLayout.setHorizontalGroup(
                SQLpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SQLpaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(SQLpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SQLResultTabPane)
                        .addGroup(SQLpaneLayout.createSequentialGroup()
                            .addGroup(SQLpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addGroup(SQLpaneLayout.createSequentialGroup()
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(SQLpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton7)
                                        .addComponent(jLabel4)
                                        .addComponent(maxRowsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            SQLpaneLayout.setVerticalGroup(
                SQLpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SQLpaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(SQLpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(SQLpaneLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(maxRowsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton7)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(SQLResultTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addContainerGap())
            );

            tabAreaUI.addTab("SQL commander", SQLpane);

            privilegeEscalatorPane.setBackground(new java.awt.Color(255, 255, 255));

            generateUserListButton.setText("Generate user list");
            generateUserListButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    generateUserListButtonActionPerformed(evt);
                }
            });

            escalatePrivilegesButton.setText("Escalate privileges");
            escalatePrivilegesButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    escalatePrivilegesButtonActionPerformed(evt);
                }
            });

            deescalatePrivilegesButton.setText("Deescalate privileges");
            deescalatePrivilegesButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deescalatePrivilegesButtonActionPerformed(evt);
                }
            });

            jScrollPane11.setViewportView(privilegeEscalatorUserList);
            privilegeEscalatorUserList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            privilegeEscalatorUserList.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event) {
                }
            });

            jPanel2.setBackground(new java.awt.Color(255, 255, 255));
            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("User properties"));

            jLabel5.setText("DES PW_TOKENa");

            jLabel23.setText("DES PW_TOKENb");

            jLabel24.setText("LM hash");

            jLabel25.setText("SHA1 password hash (mixed case)");

            jLabel26.setText("SHA1 password hash (upper case)");

            FirstDEShashTextField.setEditable(false);

            SecondDEShashTextField.setEditable(false);

            LMHashTextField.setEditable(false);
            LMHashTextField.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    LMHashTextFieldActionPerformed(evt);
                }
            });

            FirstHMAChashTextField.setEditable(false);

            SecondHMAChashTextField.setEditable(false);

            jLabel27.setText("Unknown hash");

            UnknownHashTextArea.setEditable(false);
            UnknownHashTextArea.setColumns(20);
            UnknownHashTextArea.setLineWrap(true);
            UnknownHashTextArea.setRows(5);
            jScrollPane3.setViewportView(UnknownHashTextArea);

            LMHashCopyButton.setText("Copy");
            LMHashCopyButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    LMHashCopyButtonActionPerformed(evt);
                }
            });

            jLabel28.setText("User name");

            FirstDESHashCopyButton.setText("Copy");
            FirstDESHashCopyButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    FirstDESHashCopyButtonActionPerformed(evt);
                }
            });

            FirstHMACHashCopyButton.setText("Copy");
            FirstHMACHashCopyButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    FirstHMACHashCopyButtonActionPerformed(evt);
                }
            });

            SecondHMACHashCopyButton.setText("Copy");
            SecondHMACHashCopyButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SecondHMACHashCopyButtonActionPerformed(evt);
                }
            });

            UnknownHashCopyButton.setText("Copy");
            UnknownHashCopyButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    UnknownHashCopyButtonActionPerformed(evt);
                }
            });

            jLabel29.setText("DES password token (A xor B)");

            DEShashTextField.setEditable(false);

            DESHashCopyButton.setText("Copy");
            DESHashCopyButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    DESHashCopyButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap(80, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel28)
                                .addComponent(jLabel23)
                                .addComponent(jLabel5)
                                .addComponent(jLabel29))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(SecondDEShashTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                        .addComponent(FirstDEShashTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DEShashTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(FirstDESHashCopyButton)
                                        .addComponent(DESHashCopyButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addComponent(userNameHashLabel)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel24)
                                .addComponent(jLabel25)
                                .addComponent(jLabel26)
                                .addComponent(jLabel27))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(SecondHMAChashTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(FirstHMAChashTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LMHashTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LMHashCopyButton)
                                        .addComponent(FirstHMACHashCopyButton, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(SecondHMACHashCopyButton, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(UnknownHashCopyButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addContainerGap())
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(userNameHashLabel))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(FirstDEShashTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FirstDESHashCopyButton))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(SecondDEShashTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(DEShashTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DESHashCopyButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(LMHashTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LMHashCopyButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(FirstHMAChashTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FirstHMACHashCopyButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(SecondHMAChashTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SecondHMACHashCopyButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel27)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UnknownHashCopyButton))
                    .addGap(38, 38, 38))
            );

            GrabHashButton.setText("Grab the hash");
            GrabHashButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    GrabHashButtonActionPerformed(evt);
                }
            });

            cancelButton.setText("Cancel");
            cancelButton.setEnabled(false);
            cancelButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cancelButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout privilegeEscalatorPaneLayout = new javax.swing.GroupLayout(privilegeEscalatorPane);
            privilegeEscalatorPane.setLayout(privilegeEscalatorPaneLayout);
            privilegeEscalatorPaneLayout.setHorizontalGroup(
                privilegeEscalatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(privilegeEscalatorPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(privilegeEscalatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(privilegeEscalatorPaneLayout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(privilegeEscalatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(deescalatePrivilegesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(escalatePrivilegesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(generateUserListButton, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, privilegeEscalatorPaneLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancelButton)
                            .addGap(71, 71, 71)))
                    .addGroup(privilegeEscalatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(GrabHashButton))
                    .addContainerGap(51, Short.MAX_VALUE))
            );
            privilegeEscalatorPaneLayout.setVerticalGroup(
                privilegeEscalatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(privilegeEscalatorPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(privilegeEscalatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane11)
                        .addGroup(privilegeEscalatorPaneLayout.createSequentialGroup()
                            .addGroup(privilegeEscalatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(privilegeEscalatorPaneLayout.createSequentialGroup()
                                    .addComponent(generateUserListButton)
                                    .addGap(26, 26, 26)
                                    .addComponent(escalatePrivilegesButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(deescalatePrivilegesButton)
                                    .addGap(26, 26, 26)
                                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cancelButton)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(GrabHashButton)
                            .addGap(12, 12, 12)))
                    .addContainerGap())
            );

            tabAreaUI.addTab("Privilege escalator", privilegeEscalatorPane);

            jLabel7.setText("Log:");

            logTextArea.setColumns(20);
            logTextArea.setRows(5);
            jScrollPane1.setViewportView(logTextArea);

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jLabel7)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(tabAreaUI)))
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabAreaUI, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE))
            );

            //gray-out SQL pane
            tabAreaUI.setEnabledAt(5, false);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    
    if (!disconnectButton.isEnabled()) return;
    
    try {
            testSystem.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Thread SQLQueryThread = new Thread() {
            public void run() {
                jButton7.setEnabled(false);
                SQLResultTabPane.removeAll();
                try {
                    ResultSet[] resultSets = testSystem.runJDBCQuery(SQLCommandTextArea.getText(), Integer.valueOf(maxRowsTextField.getText()));
                    if (resultSets == null) {
                        jButton7.setEnabled(true);
                        return;
                    }
                    int i = 0;
                    while (i < resultSets.length) {
                        if (resultSets[i] != null) {
                            JPanel resultPanel = new JPanel();
                            resultPanel.setLayout(new BorderLayout());
                            JTable resultTable = new JTable();
                            JScrollPane resultScrollPane = new JScrollPane(resultTable);
                            ResultSetMetaData resultTableMetaData = resultSets[i].getMetaData();
                            int colCount = resultTableMetaData.getColumnCount();
                            DefaultTableModel tableModel = new DefaultTableModel();
                            tableModel.addColumn("#");
                            for (int curCol = 1; curCol <= colCount; curCol++)
                            tableModel.addColumn(resultTableMetaData.getColumnName(curCol));
                            int rowCount = 1;
                            while(resultSets[i].next()){
                                Object[] resultObjects = new Object[colCount+1];
                                resultObjects[0] = String.valueOf(rowCount++);
                                for(int curCol=1; curCol <= colCount; curCol++)
                                resultObjects[curCol]=resultSets[i].getObject(curCol);
                                tableModel.addRow(resultObjects);
                            }
                            resultTable.setModel(tableModel);
                            resultPanel.add(resultScrollPane, BorderLayout.CENTER);
                            SQLResultTabPane.add(resultSets[i].getCursorName(), resultPanel);
                        }
                        i++;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                jButton7.setEnabled(true);
            }};
            SQLQueryThread.start();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //show files
        Thread IFSRefreshThread = new Thread() {
            public void run() {
                jTree1.setModel(testSystem.getIFSTreeModel());
                jTree1.setCellRenderer(testSystem.getIFSFileTreeRenderer());
                jTree1.addTreeSelectionListener(new TreeSelectionListener() {
                    public void valueChanged(TreeSelectionEvent se) {
                        JTree tree = (JTree) se.getSource();
                        IFSJavaFile selectedFile = (IFSJavaFile) tree
                        .getLastSelectedPathComponent();
                        try {
                            jTextArea1.setText(testSystem.printObjectPrivileges(selectedFile.getAbsolutePath().replace("\\", "/")));        
                                jTable1.clearSelection();
                                jTable1.setModel(testSystem.getAuthoritiesForIFSFilesInFolder(selectedFile.getAbsolutePath().replace("\\", "/")));
                                    } catch (Exception ex) {
                                        Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, ex, null);
                                        return;
                                    }
                                }
                                });
                                jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                                    public void valueChanged(ListSelectionEvent event) {
                                        try {
                                            IFSJavaFile selectedFile = (IFSJavaFile)jTree1.getLastSelectedPathComponent();
                                            jTextArea1.setText(testSystem.printObjectPrivileges(
                                                selectedFile.getAbsolutePath().replace("\\", "/") 
                                                    + "/" + jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()));
                                        } catch (Exception ex) {
                                            Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
            }};
        IFSRefreshThread.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deescalatePrivilegesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deescalatePrivilegesButtonActionPerformed
        try {
            testSystem.deescalatePrivileges();
        } catch (Exception ex) {
            Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deescalatePrivilegesButtonActionPerformed

    private void escalatePrivilegesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escalatePrivilegesButtonActionPerformed
        if (!privilegeEscalatorUserList.isSelectionEmpty()){
                try {
                    testSystem.escalatePrivilegeWithoutPassword(privilegeEscalatorUserList.getSelectedValue().toString(), IBMiConnector.PASSWORD_TYPE_NOPWD);
                } catch (Exception ex) {
                    Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_escalatePrivilegesButtonActionPerformed

    private void generateUserListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateUserListButtonActionPerformed

        final Thread queryThread = new Thread(){
            public void run() {
                generateUserListButton.setEnabled(false);
                cancelButton.setEnabled(true);
                try {
                    DefaultListModel users = testSystem.getEscalationUsers();
                    if (users != null)
                        privilegeEscalatorUserList.setModel(users);
                    else
                        Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, "Unable to display. Cancelled?"); 
            } catch (Exception ex) {
                Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            generateUserListButton.setEnabled(true);
            progressBar.setValue(0);
            cancelButton.setEnabled(false);
        }};
                
        final SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
           @Override
           protected Void doInBackground() throws Exception {
               generateUserListButton.setEnabled(false);
               queryThread.start();
               int progress = 0;
               while ((progress = testSystem.getCurrentTaskProgress()) < 100) {
                   progressBar.setValue(progress);
               }
               while (queryThread.isAlive())
                   Thread.sleep(1);             
               
               return null;
           }
           @Override
            public void done() {
                generateUserListButton.setEnabled(true);
                progressBar.setValue(0);
                cancelButton.setEnabled(false);
            }
            
            
        };

        mySwingWorker.execute();
    }//GEN-LAST:event_generateUserListButtonActionPerformed

    private void buttonClearChangesTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearChangesTableActionPerformed
        for (int i = 0; i < changesTable.getRowCount(); i++) {
            ((DefaultTableModel)changesTable.getModel()).removeRow(i);
        }
    }//GEN-LAST:event_buttonClearChangesTableActionPerformed

    private void buttonApplyChangesMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyChangesMemberActionPerformed
        DefaultTableModel changesTableModel = (DefaultTableModel)changesTable.getModel();
        for (int i = 0; i < changesTableModel.getRowCount(); i++) {
            try {
                testSystem.updatePhysicalFileMemberRecord(libNameEdit.getText(), objNameEdit.getText(), objMemberEdit.getText(), Integer.parseInt(changesTableModel.getValueAt(i,0).toString()), Integer.parseInt(changesTableModel.getValueAt(i,1).toString()), changesTableModel.getValueAt(i, 3).toString());
            } catch (Exception ex) {
                Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
        buttonClearChangesTableActionPerformed(evt);
        buttonDisplayObjectMemberActionPerformed(evt);
    }//GEN-LAST:event_buttonApplyChangesMemberActionPerformed

    private void buttonDisplayObjectMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDisplayObjectMemberActionPerformed
        try {
            objMemberContents.setModel(testSystem.getPhysicalFileMemberAsTable(libNameEdit.getText(), objNameEdit.getText(), objMemberEdit.getText(), Integer.parseInt(limitCountFrom.getText()), Integer.parseInt(limitCountTo.getText())));
            TableColumn firstColumn = objMemberContents.getColumnModel().getColumn(0);
            firstColumn.setCellRenderer(new OutputTableFirstColumnRenderer());

            objMemberContents.setDefaultEditor(Object.class, new MemberEditTableCellEditor());

        } catch (Exception ex) {
            Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }//GEN-LAST:event_buttonDisplayObjectMemberActionPerformed

    private void buttonWRKOBJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWRKOBJActionPerformed
        Thread buttonWRKOBJThread = new Thread() {
            public void run() {
                try {
                    objList.setModel(testSystem.getObjectList(objName.getText(), libName.getText(), objType.getText(), authorizedObjectsOnlyCheckBox.isSelected()));
                } catch (Exception ex) {
                    Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
            }
        };
        buttonWRKOBJThread.start();
    }//GEN-LAST:event_buttonWRKOBJActionPerformed

    private void CLCommandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLCommandButtonActionPerformed
        CLCommandButton.setEnabled(false);
        Thread CLThread = new Thread() {
            public void run() {
                try {
                    String outputMessages = "";
                    if (CLCommandPlainExec.isSelected())
                        outputMessages = testSystem.runCLCommand(CLCommandText.getText(), IBMiConnector.CL_COMMAND_EXEC_PLAIN);
                    else if (CLCommandJDBCExec.isSelected())
                        outputMessages = testSystem.runCLCommand(CLCommandText.getText(), IBMiConnector.CL_COMMAND_EXEC_JDBC); 
                    else if (CLCommandPASEExec.isSelected())
                        outputMessages = testSystem.runCLCommand(CLCommandText.getText(), IBMiConnector.CL_COMMAND_EXEC_QSHELL);                         
                    logTextArea.setText(logTextArea.getText() + "\n\n" + outputMessages);
                } catch (Exception ex) {
                    logTextArea.setText(logTextArea.getText() + "\n\n" + ex.toString());
                }
                CLCommandButton.setEnabled(true);
            }
        };
        CLThread.start();
    }//GEN-LAST:event_CLCommandButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        try {
            testSystem.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);

        }
        connectButton.setEnabled(true);
        disconnectButton.setEnabled(false);

        // clear panes
        CLCommandButton.setEnabled(false);        
        tabAreaUI.setEnabledAt(5, false);
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void browseDirsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseDirsButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setSelectedFile(new File(outputDirFolderTextField.getText()));
        fileChooser.setMultiSelectionEnabled(false);

        int folderSelection = fileChooser.showSaveDialog(this);

        if (folderSelection == JFileChooser.APPROVE_OPTION) {
            File dirToSave = fileChooser.getSelectedFile();
            outputDirFolderTextField.setText(dirToSave.getAbsolutePath());
        }
    }//GEN-LAST:event_browseDirsButtonActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        final SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    connectButton.setEnabled(false);
                    String passwordString = new String(passwordField.getPassword());
                    testSystem = new IBMiConnector(systemName.getText(), useSSL.isSelected(), useJDBC.isSelected(),
                        (createTempLib.isSelected() ? temporaryLibTextField.getText() : null), userNameField.getText(),
                        passwordString);
                    disconnectButton.setEnabled(true);


                    //initialize panes
                    CLCommandButton.setEnabled(true);
                    tabAreaUI.setEnabledAt(5, useJDBC.isSelected());

                } catch (Exception ex) {
                    Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
                    connectButton.setEnabled(true);
                    disconnectButton.setEnabled(false);
                    tabAreaUI.setEnabledAt(5, false);
                }
                return null;
            }
        };

        mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {
           public void propertyChange(PropertyChangeEvent evt) {
           }
        });
        mySwingWorker.execute();
    

    }//GEN-LAST:event_connectButtonActionPerformed

    private void LMHashTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LMHashTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LMHashTextFieldActionPerformed

    private void GrabHashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrabHashButtonActionPerformed
        if (!privilegeEscalatorUserList.isSelectionEmpty()){
                try {
                    String userName = privilegeEscalatorUserList.getSelectedValue().toString();
                    userNameHashLabel.setText(userName);
                    String hashString = testSystem.getEncryptedPassword(userName, IBMiConnector.PASSWORD_HASH_ALLDATA);
                    if (hashString == null) {
                        Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, "Could not retrieve hashes. Insufficient privileges?");
                        return;
                    }
                    FirstDEShashTextField.setText(testSystem.getEncryptedPasswordFromHashString(hashString, IBMiConnector.PASSWORD_HASH_FIRSTDES));
                    SecondDEShashTextField.setText(testSystem.getEncryptedPasswordFromHashString(hashString, IBMiConnector.PASSWORD_HASH_SECONDDES));
                    DEShashTextField.setText(testSystem.getEncryptedPasswordFromHashString(hashString, IBMiConnector.PASSWORD_HASH_DES));
                    LMHashTextField.setText(testSystem.getEncryptedPasswordFromHashString(hashString, IBMiConnector.PASSWORD_HASH_LMHASH));
                    FirstHMAChashTextField.setText(testSystem.getEncryptedPasswordFromHashString(hashString, IBMiConnector.PASSWORD_HASH_HMACSHA1MC));
                    SecondHMAChashTextField.setText(testSystem.getEncryptedPasswordFromHashString(hashString, IBMiConnector.PASSWORD_HASH_HMACSHA1UC));
                    UnknownHashTextArea.setText(testSystem.getEncryptedPasswordFromHashString(hashString, IBMiConnector.PASSWORD_HASH_UNKNOWNHASH));
                } catch (Exception ex) {
                    Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_GrabHashButtonActionPerformed

    private void LMHashCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LMHashCopyButtonActionPerformed
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection hashData;

        hashData = new StringSelection(userNameHashLabel.getText() + ":" + LMHashTextField.getText());

        c.setContents(hashData, hashData);
    }//GEN-LAST:event_LMHashCopyButtonActionPerformed

    private void FirstDESHashCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstDESHashCopyButtonActionPerformed
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection hashData;

        hashData = new StringSelection(userNameHashLabel.getText() + ":$as400des$*" + userNameHashLabel.getText() + "*" + FirstDEShashTextField.getText());

        c.setContents(hashData, hashData);
    }//GEN-LAST:event_FirstDESHashCopyButtonActionPerformed

    private void FirstHMACHashCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstHMACHashCopyButtonActionPerformed
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection hashData;

        hashData = new StringSelection(userNameHashLabel.getText() + ":$as400ssha1$" + FirstHMAChashTextField.getText() + "$" + userNameHashLabel.getText());

        c.setContents(hashData, hashData);
    }//GEN-LAST:event_FirstHMACHashCopyButtonActionPerformed

    private void SecondHMACHashCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SecondHMACHashCopyButtonActionPerformed
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection hashData;

        hashData = new StringSelection(userNameHashLabel.getText() + ":$as400ssha1$" + SecondHMAChashTextField.getText() + "$" + userNameHashLabel.getText());

        c.setContents(hashData, hashData);
    }//GEN-LAST:event_SecondHMACHashCopyButtonActionPerformed

    private void UnknownHashCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnknownHashCopyButtonActionPerformed
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection hashData;

        hashData = new StringSelection(userNameHashLabel.getText() + ":" + UnknownHashTextArea.getText());

        c.setContents(hashData, hashData);
    }//GEN-LAST:event_UnknownHashCopyButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        testSystem.cancelCurrentTask();
        progressBar.setValue(0);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void DESHashCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DESHashCopyButtonActionPerformed
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection hashData;

        hashData = new StringSelection(userNameHashLabel.getText() + ":$as400des$*" + userNameHashLabel.getText() + "*" + DEShashTextField.getText());

        c.setContents(hashData, hashData);
    }//GEN-LAST:event_DESHashCopyButtonActionPerformed

        
    public class MemberEditTableCellEditor extends DefaultCellEditor {
        public MemberEditTableCellEditor() {
            super(new JTextField());
        }
        
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex) {
            JTextField editor = (JTextField) super.getTableCellEditorComponent(table, value, isSelected, rowIndex, vColIndex);
            editor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            editor.setText(value.toString());
            return editor;
            
        }
        
        @Override
        public boolean stopCellEditing() {
            Vector newRow = new Vector();
            newRow.addElement(Integer.parseInt(objMemberContents.getValueAt(objMemberContents.getEditingRow(), 0).toString()) + 1); //record numbers are 1-based in AS400
            newRow.addElement(objMemberContents.getEditingColumn() - 1); //record columns are 0-based in AS400
            newRow.addElement(objMemberContents.getValueAt(objMemberContents.getEditingRow(), objMemberContents.getEditingColumn()).toString());

            boolean outVal = super.stopCellEditing();
            newRow.addElement(objMemberContents.getValueAt(objMemberContents.getSelectedRow(), objMemberContents.getSelectedColumn()).toString());
            if (outVal)
                ((DefaultTableModel)changesTable.getModel()).addRow(newRow);
            return outVal;
        }
    }

    class OutputTableFirstColumnRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
          boolean hasFocus, int row, int column) {
        JLabel editor = new JLabel(value.toString());
        editor.setBackground(Color.GRAY);
        return editor;
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HackUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HackUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HackUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HackUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HackUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(HackUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CLCommandButton;
    private javax.swing.ButtonGroup CLCommandExecutionButtonGroup;
    private javax.swing.JRadioButton CLCommandJDBCExec;
    private javax.swing.JTextArea CLCommandOutput;
    private javax.swing.JRadioButton CLCommandPASEExec;
    private javax.swing.JPanel CLCommandPane;
    private javax.swing.JRadioButton CLCommandPlainExec;
    private javax.swing.JTextField CLCommandText;
    private javax.swing.JPanel ConnectionConfigPane;
    private javax.swing.JButton DESHashCopyButton;
    private javax.swing.JTextField DEShashTextField;
    private javax.swing.JButton FirstDESHashCopyButton;
    private javax.swing.JTextField FirstDEShashTextField;
    private javax.swing.JButton FirstHMACHashCopyButton;
    private javax.swing.JTextField FirstHMAChashTextField;
    private javax.swing.JButton GrabHashButton;
    private javax.swing.JButton LMHashCopyButton;
    private javax.swing.JTextField LMHashTextField;
    private javax.swing.JTextArea SQLCommandTextArea;
    private javax.swing.JTabbedPane SQLResultTabPane;
    private javax.swing.JPanel SQLpane;
    private javax.swing.JTextField SecondDEShashTextField;
    private javax.swing.JButton SecondHMACHashCopyButton;
    private javax.swing.JTextField SecondHMAChashTextField;
    private javax.swing.ButtonGroup ShellCommandExecutionButtonGroup;
    private javax.swing.JButton UnknownHashCopyButton;
    private javax.swing.JTextArea UnknownHashTextArea;
    private javax.swing.JPanel WRKOBJpane;
    private javax.swing.JCheckBox authorizedObjectsOnlyCheckBox;
    private javax.swing.JButton browseDirsButton;
    private javax.swing.JButton buttonApplyChangesMember;
    private javax.swing.JButton buttonClearChangesTable;
    private javax.swing.JButton buttonDisplayObjectMember;
    private javax.swing.JButton buttonWRKOBJ;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable changesTable;
    private javax.swing.JButton connectButton;
    private javax.swing.JCheckBox createTempLib;
    private javax.swing.JButton deescalatePrivilegesButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JPanel displayMemberPane;
    private javax.swing.JButton escalatePrivilegesButton;
    private javax.swing.JButton generateUserListButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField libName;
    private javax.swing.JTextField libNameEdit;
    private javax.swing.ButtonGroup life400ConnectionButtonGroup;
    private javax.swing.JTextField limitCountFrom;
    private javax.swing.JTextField limitCountTo;
    private javax.swing.JTextArea logTextArea;
    private javax.swing.JTextField maxRowsTextField;
    private javax.swing.JTable objList;
    private javax.swing.JTable objMemberContents;
    private javax.swing.JTextField objMemberEdit;
    private javax.swing.JTextField objName;
    private javax.swing.JTextField objNameEdit;
    private javax.swing.JTextField objType;
    private javax.swing.JTextField outputDirFolderTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextArea privList;
    private javax.swing.JPanel privilegeEscalatorPane;
    private javax.swing.JList privilegeEscalatorUserList;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField systemName;
    private javax.swing.JTabbedPane tabAreaUI;
    private javax.swing.JTextField temporaryLibTextField;
    private javax.swing.JCheckBox useJDBC;
    private javax.swing.JCheckBox useSSL;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameHashLabel;
    // End of variables declaration//GEN-END:variables
}
