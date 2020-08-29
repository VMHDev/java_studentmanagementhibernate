/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHGUI.Functions;

import VMHBUS.*;
import VMHDAO.*;
import VMHPOJO.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VMHIT
 */
public class frmInternalStudentClass extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInternalClass
     */
    public frmInternalStudentClass() {
        initComponents();

        // Căn giữa label thông tin form
        lblInfoStudent.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfoStudent.setVerticalAlignment(SwingConstants.CENTER);

        // Ẩn text box ID
        txtStudentID.setVisible(false);
        txtStudentID.revalidate();
        txtStudentID.repaint();

        LoadDefault();

        // Ẩn cột ID
        tblStudent.getColumn("ID").setPreferredWidth(0);
        tblStudent.getColumn("ID").setMinWidth(0);
        tblStudent.getColumn("ID").setWidth(0);
        tblStudent.getColumn("ID").setMaxWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlButton = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtStudentID = new javax.swing.JTextField();
        pnlTable = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblInfoStudent = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtStudentCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStudentIdentityNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboStudentGender = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cboClass = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Sinh viên");

        btnExit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtStudentID.setEditable(false);
        txtStudentID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlButtonLayout = new javax.swing.GroupLayout(pnlButton);
        pnlButton.setLayout(pnlButtonLayout);
        pnlButtonLayout.setHorizontalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pnlButtonLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnExit, btnSave});

        pnlButtonLayout.setVerticalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(btnAdd)
                .addComponent(btnSave)
                .addComponent(btnDelete)
                .addComponent(btnExit)
                .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlButtonLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDelete, btnExit, btnSave});

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblStudent.getTableHeader().setReorderingAllowed(false);
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        pnlTable.setViewportView(tblStudent);

        lblInfoStudent.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblInfoStudent.setText("Sinh viên theo lớp");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("MSSV:");

        txtStudentCode.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("CMND:");

        txtStudentIdentityNumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Họ tên:");

        txtStudentName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Giới tính:");

        cboStudentGender.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboStudentGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Lớp:");

        cboClass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtStudentCode)
                            .addComponent(txtStudentName)
                            .addComponent(cboClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtStudentIdentityNumber)
                            .addComponent(cboStudentGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfoStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtStudentCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtStudentIdentityNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cboStudentGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadDefault() {
        try {
            txtStudentID.setText("");
            txtStudentCode.setText("");
            txtStudentName.setText("");
            txtStudentIdentityNumber.setText("");
            cboStudentGender.setSelectedIndex(0);
            LoadDataToCombobox();
            LoadDataToTable();

            // Ẩn cột ID
            tblStudent.getColumn("ID").setPreferredWidth(0);
            tblStudent.getColumn("ID").setMinWidth(0);
            tblStudent.getColumn("ID").setWidth(0);
            tblStudent.getColumn("ID").setMaxWidth(0);
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

    private void LoadDataToTable() throws IOException {
        String[] colNames = new String[]{"ID", "MSSV", "Họ tên", "Giới tính", "CMND", "Lớp"};
        DefaultTableModel modelObj = new DefaultTableModel(null, colNames);
        List<Studentdto> lstObj = StudentDAO.GetAllStudent();

        for (int i = 0; i < lstObj.size(); i++) {
            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector<String> vecDataLine = new Vector<String>();
            vecDataLine.add(0, Integer.toString(lstObj.get(i).getId()));
            vecDataLine.add(1, lstObj.get(i).getStudentCode());
            vecDataLine.add(2, lstObj.get(i).getStudentName());
            vecDataLine.add(3, Integer.toString(lstObj.get(i).getGender()));
            vecDataLine.add(4, lstObj.get(i).getIdentityNumber());
            Classdto objClass = ClassDAO.GetClassWithID(lstObj.get(i).getClassId());
            vecDataLine.add(5, objClass.getClassCode());
            modelObj.addRow(vecDataLine);
        }
        tblStudent.setModel(modelObj);
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String sStudentCode = txtStudentCode.getText();
        String sStudentName = txtStudentName.getText();
        Integer sStudentGender = cboStudentGender.getSelectedIndex();
        String sStudentIdentityNumber = txtStudentIdentityNumber.getText();
        Classdto modelClass = (Classdto) cboClass.getSelectedItem();
        Integer classID = modelClass.getId();
        Studentdto objStudent = new Studentdto(sStudentCode, sStudentName, sStudentGender, sStudentIdentityNumber, classID);
        boolean rs = StudentDAO.AddStudent(objStudent);
        if (rs == true) {
            JOptionPane.showMessageDialog(null, "Thêm sinh viên thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            LoadDefault();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm sinh viên thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int row = tblStudent.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu để cập nhật!", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        boolean rs = false;
        Integer sStudentID = Integer.parseInt(txtStudentID.getText());
        String sStudentCode = txtStudentCode.getText();
        String sStudentName = txtStudentName.getText();
        Integer sStudentGender = cboStudentGender.getSelectedIndex();
        String sStudentIdentityNumber = txtStudentIdentityNumber.getText();
        Classdto modelClass = (Classdto) cboClass.getSelectedItem();
        Integer classID = modelClass.getId();

        Studentdto objStudent = StudentDAO.GetStudentWithID(sStudentID);
        if (objStudent != null) {
            objStudent.setStudentCode(sStudentCode);
            objStudent.setStudentName(sStudentName);
            objStudent.setGender(sStudentGender);
            objStudent.setIdentityNumber(sStudentIdentityNumber);
            objStudent.setClassId(classID);
            objStudent.setUpdatedDate(new Date());
            rs = StudentDAO.UpdateStudent(objStudent);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy lớp", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            LoadDefault();
            return;
        }

        if (rs == true) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            LoadDefault();
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblStudent.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu cần xóa", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.NO_OPTION || dialogResult == JOptionPane.CLOSED_OPTION) {
            return;
        }
        boolean rs = false;
        Integer sStudentID = Integer.parseInt(txtStudentID.getText());
        Studentdto objStudent = StudentDAO.GetStudentWithID(sStudentID);
        if (objStudent != null) {
            objStudent.setIsActive(false);
            objStudent.setUpdatedDate(new Date());
            rs = StudentDAO.UpdateStudent(objStudent);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            LoadDefault();
            return;
        }

        if (rs == true) {
            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            LoadDefault();
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        JTable sourceTable = (JTable) evt.getSource();
        int row = sourceTable.rowAtPoint(evt.getPoint());
        txtStudentID.setText(sourceTable.getModel().getValueAt(row, 0).toString());
        txtStudentCode.setText(sourceTable.getModel().getValueAt(row, 1).toString());
        txtStudentName.setText(sourceTable.getModel().getValueAt(row, 2).toString());
        cboStudentGender.setSelectedItem(sourceTable.getModel().getValueAt(row, 3).toString());
        txtStudentIdentityNumber.setText(sourceTable.getModel().getValueAt(row, 4).toString());
        String code = sourceTable.getModel().getValueAt(row, 5).toString();
        clsUtilityCombobox.setSelectClassWithCode(cboClass, code);
    }//GEN-LAST:event_tblStudentMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboClass;
    private javax.swing.JComboBox<String> cboStudentGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInfoStudent;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JScrollPane pnlTable;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtStudentCode;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentIdentityNumber;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
