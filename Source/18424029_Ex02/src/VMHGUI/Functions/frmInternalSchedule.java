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
public class frmInternalSchedule extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInternalClass
     */
    public frmInternalSchedule() {
        initComponents();

        lblInfoSchedule.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfoSchedule.setVerticalAlignment(SwingConstants.CENTER);

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

        pnlTable = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblInfoSchedule = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboClass = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboSubject = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtScheduleRoom = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Thời khóa biều");

        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblScheduleMouseClicked(evt);
            }
        });
        pnlTable.setViewportView(tblSchedule);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addGap(20, 20, 20))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnExit, btnSave});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnDelete)
                    .addComponent(btnSave)
                    .addComponent(btnAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDelete, btnExit, btnSave});

        lblInfoSchedule.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblInfoSchedule.setText("Thời khóa biểu");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Lớp học");

        cboClass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Môn học");

        cboSubject.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setLabelFor(txtScheduleRoom);
        jLabel2.setText("Phòng");

        txtScheduleRoom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtScheduleRoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(cboClass, javax.swing.GroupLayout.Alignment.TRAILING, 0, 251, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboSubject, 0, 251, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfoSchedule)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtScheduleRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTable, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void LoadDefault() {
        try {
            txtScheduleRoom.setText("");
            LoadDataToTable();
            LoadDataToCombobox();
        } catch (IOException ex) {
            Logger.getLogger(frmInternalSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadDataToTable() throws IOException {
        String[] colNames = new String[]{"Lớp", "Môn học", "Phòng"};
        DefaultTableModel modelObj = new DefaultTableModel(null, colNames);
        List<Scheduledto> lstObj = ScheduleDAO.GetAllSchedule();

        for (int i = 0; i < lstObj.size(); i++) {
            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector<String> vecDataLine = new Vector<String>();
            Classdto objClass = ClassDAO.GetClassWithID(lstObj.get(i).getId().getClassId().getId());
            vecDataLine.add(0, objClass.getClassCode());
            Subjectdto objSubject = SubjectDAO.GetSubjectWithID(lstObj.get(i).getId().getSubjectId().getId());
            vecDataLine.add(1, objSubject.getSubjectName());
            vecDataLine.add(2, lstObj.get(i).getClassRoom());
            modelObj.addRow(vecDataLine);
        }
        tblSchedule.setModel(modelObj);
    }

    private void LoadDataToCombobox() {
        List<Classdto> arrlstClass = ClassDAO.GetAllClass();
        Classdto[] arrClass = arrlstClass.toArray(new Classdto[arrlstClass.size()]);
        DefaultComboBoxModel dmdCboClass = new DefaultComboBoxModel(arrClass);
        cboClass.setModel(dmdCboClass);

        List<Subjectdto> arrlstSubject = SubjectDAO.GetAllSubject();
        Subjectdto[] arrSubject = arrlstSubject.toArray(new Subjectdto[arrlstClass.size()]);
        DefaultComboBoxModel dmdCboSubject = new DefaultComboBoxModel(arrSubject);
        cboSubject.setModel(dmdCboSubject);
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Integer rs = 0;
        Classdto modelClass = (Classdto) cboClass.getSelectedItem();
        Subjectdto modelSubject = (Subjectdto) cboSubject.getSelectedItem();
        String sRoom = txtScheduleRoom.getText();
        ScheduledtoId objID = new ScheduledtoId(modelClass, modelSubject);

        Scheduledto objSchedule = new Scheduledto(objID, sRoom);
        rs = ScheduleDAO.AddSchedule(objSchedule);
        if (null == rs) {
            JOptionPane.showMessageDialog(null, "Thêm thời khóa biểu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else switch (rs) {
            case 1:
                JOptionPane.showMessageDialog(null, "Thêm thời khóa biểu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                LoadDefault();
                break;
            case -1:
                JOptionPane.showMessageDialog(null, "Dữ liệu đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                LoadDefault();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Thêm thời khóa biểu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int row = tblSchedule.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu để cập nhật!", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        boolean rs = false;
        Classdto modelClass = (Classdto) cboClass.getSelectedItem();
        Subjectdto modelSubject = (Subjectdto) cboSubject.getSelectedItem();
        String sRoom = txtScheduleRoom.getText();
        ScheduledtoId objID = new ScheduledtoId(modelClass, modelSubject);
        
        Scheduledto objSchedule = ScheduleDAO.GetScheduleWithID(objID);
        if (objSchedule != null) {
            objSchedule.setClassRoom(sRoom);
            objSchedule.setUpdatedDate(new Date());
            rs = ScheduleDAO.UpdateSchedule(objSchedule);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy thời khóa biểu", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
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
        int row = tblSchedule.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu cần xóa", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.NO_OPTION || dialogResult == JOptionPane.CLOSED_OPTION) {
            return;
        }
        
        boolean rs = false;
        Classdto modelClass = (Classdto) cboClass.getSelectedItem();
        Integer iIDClass = modelClass.getId();
        Subjectdto modelSubject = (Subjectdto) cboSubject.getSelectedItem();
        Integer iIDSubject = modelSubject.getId();
        ScheduledtoId objID = new ScheduledtoId(modelClass, modelSubject);
        
        Scheduledto objSchedule = ScheduleDAO.GetScheduleWithID(objID);
        if (objSchedule != null) {
            objSchedule.setIsActive(false);
            objSchedule.setUpdatedDate(new Date());
            rs = ScheduleDAO.UpdateSchedule(objSchedule);
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

    private void tblScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScheduleMouseClicked
        JTable sourceTable = (JTable) evt.getSource();
        int row = sourceTable.rowAtPoint(evt.getPoint());
        String classCode = sourceTable.getModel().getValueAt(row, 0).toString();
        clsUtilityCombobox.setSelectClassWithCode(cboClass, classCode);
        String subjectName = sourceTable.getModel().getValueAt(row, 1).toString();
        clsUtilityCombobox.setSelectSubjectWithName(cboSubject, subjectName);
        txtScheduleRoom.setText(sourceTable.getModel().getValueAt(row, 2).toString());
    }//GEN-LAST:event_tblScheduleMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboClass;
    private javax.swing.JComboBox<String> cboSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblInfoSchedule;
    private javax.swing.JScrollPane pnlTable;
    private javax.swing.JTable tblSchedule;
    private javax.swing.JTextField txtScheduleRoom;
    // End of variables declaration//GEN-END:variables
}