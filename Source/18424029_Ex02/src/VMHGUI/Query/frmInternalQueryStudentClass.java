/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHGUI.Query;

import VMHGUI.Functions.*;
import VMHDAO.*;
import VMHPOJO.*;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VMHIT
 */
public class frmInternalQueryStudentClass extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInternalClass
     */
    public frmInternalQueryStudentClass() {
        initComponents();

        // Căn giữa label thông tin form
        lblInfoStudent.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfoStudent.setVerticalAlignment(SwingConstants.CENTER);

        LoadDefault();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInfo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtStudentCode = new javax.swing.JTextField();
        txtStudentName = new javax.swing.JTextField();
        txtStudentIdentityNumber = new javax.swing.JTextField();
        lblInfoStudent = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboStudentGender = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cboClass = new javax.swing.JComboBox<>();
        pnlButton = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        pnlTable = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();

        setClosable(true);
        setTitle("Sinh viên - Lớp");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("MSSV:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Họ tên:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("CMND:");

        txtStudentCode.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtStudentName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtStudentIdentityNumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblInfoStudent.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblInfoStudent.setText("Tra cứu thông tin sinh viên theo lớp");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Giới tính:");

        cboStudentGender.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboStudentGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam/Nữ", "Nam", "Nữ" }));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Lớp:");

        cboClass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoLayout.createSequentialGroup()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblInfoStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboClass, javax.swing.GroupLayout.Alignment.TRAILING, 0, 296, Short.MAX_VALUE)
                            .addComponent(txtStudentName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(txtStudentCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStudentIdentityNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(cboStudentGender, 0, 296, Short.MAX_VALUE))))
                .addGap(0, 0, 0))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblInfoStudent)
                .addGap(4, 4, 4)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtStudentCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtStudentIdentityNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(cboStudentGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        btnExit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonLayout = new javax.swing.GroupLayout(pnlButton);
        pnlButton.setLayout(pnlButtonLayout);
        pnlButtonLayout.setHorizontalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createSequentialGroup()
                .addContainerGap(554, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pnlButtonLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExit, btnSearch});

        pnlButtonLayout.setVerticalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(btnSearch)
                .addComponent(btnExit))
        );

        pnlButtonLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnExit, btnSearch});

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblStudent.getTableHeader().setReorderingAllowed(false);
        pnlTable.setViewportView(tblStudent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTable)
            .addComponent(pnlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadDefault() {
        try {
            txtStudentCode.setText("");
            txtStudentName.setText("");
            txtStudentIdentityNumber.setText("");
            cboStudentGender.setSelectedIndex(0);
            LoadDataToCombobox();
            LoadDataToTable(true);
        } catch (IOException ex) {
            Logger.getLogger(frmInternalClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void LoadDataToCombobox() {
        List<Classdto> arrlstClass = ClassDAO.GetAllClass();
        Classdto[] arrClass = arrlstClass.toArray(new Classdto[arrlstClass.size()]);
        DefaultComboBoxModel dmdCboClass = new DefaultComboBoxModel(arrClass);
        cboClass.setModel(dmdCboClass);
    }

    private void LoadDataToTable(Boolean _IsLoad) throws IOException {
        String[] colNames = new String[]{"MSSV", "Họ tên", "Giới tính", "CMND", "Lớp"};
        DefaultTableModel modelObj = new DefaultTableModel(null, colNames);

        String sStudentCode = txtStudentCode.getText();
        String sStudentName = txtStudentName.getText();
        Integer sStudentGender = cboStudentGender.getSelectedIndex();
        String sStudentIdentityNumber = txtStudentIdentityNumber.getText();
        Classdto modelClass = (Classdto) cboClass.getSelectedItem();
        if (_IsLoad) {
            modelClass = null;
        }
        List<Studentdto> lstObj = StudentDAO.GetStudentClass(sStudentCode, sStudentName, sStudentGender, sStudentIdentityNumber, modelClass);

        if (lstObj.size() <= 0 && !_IsLoad) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }

        for (int i = 0; i < lstObj.size(); i++) {
            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector<String> vecDataLine = new Vector<String>();
             vecDataLine.add(0, lstObj.get(i).getStudentCode());
            vecDataLine.add(1, lstObj.get(i).getStudentName());
            if (lstObj.get(i).getGender().equals(1)) {
                vecDataLine.add(2, "Nam");
            } else {
                vecDataLine.add(2, "Nữ");
            }
            vecDataLine.add(3, lstObj.get(i).getIdentityNumber());
            Classdto objClass = ClassDAO.GetClassWithID(lstObj.get(i).getClassId());
            vecDataLine.add(4, objClass.getClassCode());
            modelObj.addRow(vecDataLine);
        }
        tblStudent.setModel(modelObj);
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            LoadDataToTable(false);
        } catch (IOException ex) {
            Logger.getLogger(frmInternalQueryStudentClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboClass;
    private javax.swing.JComboBox<String> cboStudentGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblInfoStudent;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JScrollPane pnlTable;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtStudentCode;
    private javax.swing.JTextField txtStudentIdentityNumber;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
