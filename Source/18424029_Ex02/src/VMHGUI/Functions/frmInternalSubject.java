/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHGUI.Functions;

import VMHDAO.*;
import VMHPOJO.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VMHIT
 */
public class frmInternalSubject extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInternalClass
     */
    public frmInternalSubject() {
        initComponents();

        lblInfoSubject.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfoSubject.setVerticalAlignment(SwingConstants.CENTER);

        txtSubjectID.setVisible(false);
        txtSubjectID.revalidate();
        txtSubjectID.repaint();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSubjectCode = new javax.swing.JTextField();
        txtSubjectName = new javax.swing.JTextField();
        lblInfoSubject = new javax.swing.JLabel();
        pnlTable = new javax.swing.JScrollPane();
        tblSubject = new javax.swing.JTable();
        pnlButton = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtSubjectID = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Môn học");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setLabelFor(txtSubjectCode);
        jLabel1.setText("Mã môn học:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setLabelFor(txtSubjectName);
        jLabel2.setText("Tên môn học:");

        txtSubjectCode.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSubjectCode.setMaximumSize(getMaximumSize());

        txtSubjectName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblInfoSubject.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblInfoSubject.setText("Thông tin môn học");

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSubjectCode, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSubjectName, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblInfoSubject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(78, 78, 78))
        );

        tblSubject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubjectMouseClicked(evt);
            }
        });
        pnlTable.setViewportView(tblSubject);

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

        txtSubjectID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlButtonLayout = new javax.swing.GroupLayout(pnlButton);
        pnlButton.setLayout(pnlButtonLayout);
        pnlButtonLayout.setHorizontalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addGap(20, 20, 20))
        );

        pnlButtonLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnExit, btnSave});

        pnlButtonLayout.setVerticalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(btnAdd)
                .addComponent(btnSave)
                .addComponent(btnDelete)
                .addComponent(btnExit)
                .addComponent(txtSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlButtonLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDelete, btnExit, btnSave});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
            .addComponent(pnlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void LoadDefault() {
        try {
            txtSubjectCode.setText("");
            txtSubjectName.setText("");
            LoadDataToTable();
            // Ẩn cột ID
            tblSubject.getColumn("ID").setPreferredWidth(0);
            tblSubject.getColumn("ID").setMinWidth(0);
            tblSubject.getColumn("ID").setWidth(0);
            tblSubject.getColumn("ID").setMaxWidth(0);
        } catch (IOException ex) {
            Logger.getLogger(frmInternalSubject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadDataToTable() throws IOException {
        String[] colNames = new String[]{"ID", "Mã môn học", "Tên môn học"};
        DefaultTableModel modelObj = new DefaultTableModel(null, colNames);
        List<Subjectdto> lstObj = SubjectDAO.GetAllSubject();

        for (int i = 0; i < lstObj.size(); i++) {
            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector<String> vecDataLine = new Vector<String>();
            vecDataLine.add(0, Integer.toString(lstObj.get(i).getId()));
            vecDataLine.add(1, lstObj.get(i).getSubjectCode());
            vecDataLine.add(2, lstObj.get(i).getSubjectName());
            modelObj.addRow(vecDataLine);
        }
        tblSubject.setModel(modelObj);
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String sSubjectCode = txtSubjectCode.getText();
        String sSubjectName = txtSubjectName.getText();
        Subjectdto objSubject = new Subjectdto(sSubjectCode, sSubjectName);
        boolean rs = SubjectDAO.AddSubject(objSubject);
        if (rs == true) {
            JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            LoadDefault();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int row = tblSubject.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu để cập nhật!", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        boolean rs = false;
        Integer sSubjectID = Integer.parseInt(txtSubjectID.getText());
        String sSubjectCode = txtSubjectCode.getText();
        String sSubjectName = txtSubjectName.getText();
        Subjectdto objSubject = SubjectDAO.GetSubjectWithID(sSubjectID);
        if (objSubject != null) {
            objSubject.setSubjectCode(sSubjectCode);
            objSubject.setSubjectName(sSubjectName);
            objSubject.setUpdatedDate(new Date());
            rs = SubjectDAO.UpdateSubject(objSubject);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy môn học", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
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
        int row = tblSubject.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu cần xóa", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.NO_OPTION || dialogResult == JOptionPane.CLOSED_OPTION) {
            return;
        }
        boolean rs = false;
        Integer sSubjectID = Integer.parseInt(txtSubjectID.getText());
        Subjectdto objSubject = SubjectDAO.GetSubjectWithID(sSubjectID);
        if (objSubject != null) {
            objSubject.setIsActive(false);
            objSubject.setUpdatedDate(new Date());
            rs = SubjectDAO.UpdateSubject(objSubject);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy lớp", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
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

    private void tblSubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubjectMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        txtSubjectID.setText(source.getModel().getValueAt(row, 0).toString());
        txtSubjectCode.setText(source.getModel().getValueAt(row, 1).toString());
        txtSubjectName.setText(source.getModel().getValueAt(row, 2).toString());
    }//GEN-LAST:event_tblSubjectMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblInfoSubject;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JScrollPane pnlTable;
    private javax.swing.JTable tblSubject;
    private javax.swing.JTextField txtSubjectCode;
    private javax.swing.JTextField txtSubjectID;
    private javax.swing.JTextField txtSubjectName;
    // End of variables declaration//GEN-END:variables
}
