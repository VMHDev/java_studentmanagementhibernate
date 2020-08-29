/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHGUI.Query;

import VMHBUS.clsParameterSys;
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
public class frmInternalQueryStudentScores extends javax.swing.JInternalFrame {

    private Studentdto objStudent;

    /**
     * Creates new form frmInternalClass
     */
    public frmInternalQueryStudentScores() {
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
        tblTranscript = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblInfoSchedule = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboScheduleClass = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboScheduleSubject = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtStudentCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Tra cứu điểm");

        tblTranscript.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        pnlTable.setViewportView(tblTranscript);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addGap(20, 20, 20))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExit, btnSearch});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnSearch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnExit, btnSearch});

        lblInfoSchedule.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblInfoSchedule.setText("Tra cứu điểm sinh viên");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Lớp học");

        cboScheduleClass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Môn học");

        cboScheduleSubject.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setLabelFor(txtStudentCode);
        jLabel2.setText("MSSV");

        txtStudentCode.setEditable(false);
        txtStudentCode.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Tên");

        txtStudentName.setEditable(false);
        txtStudentName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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
                            .addComponent(txtStudentCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(cboScheduleClass, javax.swing.GroupLayout.Alignment.TRAILING, 0, 251, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboScheduleSubject, 0, 251, Short.MAX_VALUE)
                            .addComponent(txtStudentName))))
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
                    .addComponent(cboScheduleClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboScheduleSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtStudentCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            txtStudentCode.setText(clsParameterSys.getUserName());
            objStudent = StudentDAO.GetStudentWithCode(clsParameterSys.getUserName());
            if (objStudent == null) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            txtStudentName.setText(objStudent.getStudentName());
            LoadDataToTable(true);
            LoadDataToCombobox();
        } catch (IOException ex) {
            Logger.getLogger(frmInternalQueryStudentScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadDataToTable(Boolean _IsLoad) throws IOException {
        String[] colNames = new String[]{"MSSV", "Họ tên", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng", "Môn học", "Lớp", "Đậu/Rớt"};
        DefaultTableModel modelObj = new DefaultTableModel(null, colNames);

        Classdto modelClass = (Classdto) cboScheduleClass.getSelectedItem();
        Subjectdto modelSubject = (Subjectdto) cboScheduleSubject.getSelectedItem();
        if (_IsLoad) {
            modelClass = null;
            modelSubject = null;
        }

        List<Transcriptdto> lstObj = TranscriptDAO.GetTranscript(modelClass, modelSubject, objStudent);
        
        if (lstObj.size() <= 0 && !_IsLoad) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        
        for (int i = 0; i < lstObj.size(); i++) {
            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector<String> vecDataLine = new Vector<String>();
            vecDataLine.add(0, lstObj.get(i).getId().getStudentId().getStudentCode());
            vecDataLine.add(1, lstObj.get(i).getId().getStudentId().getStudentName());
            vecDataLine.add(2, Float.toString(lstObj.get(i).getScoresMid()));
            vecDataLine.add(3, Float.toString(lstObj.get(i).getScoresEnd()));
            vecDataLine.add(4, Float.toString(lstObj.get(i).getScoresOther()));
            vecDataLine.add(5, Float.toString(lstObj.get(i).getScoresSum()));
            vecDataLine.add(6, lstObj.get(i).getId().getSubjectId().getSubjectName());
            vecDataLine.add(7, lstObj.get(i).getId().getClassId().getClassCode());
            if (lstObj.get(i).getScoresSum() >= 5) {
                vecDataLine.add(8, "Đậu");
            }
            else{
                vecDataLine.add(8, "Rớt");
            }            
            modelObj.addRow(vecDataLine);
        }
        tblTranscript.setModel(modelObj);
    }

    private void LoadDataToCombobox() {
        List<Classdto> arrlstClass = ClassDAO.GetAllClass();
        arrlstClass.add(0, null);
        Classdto[] arrClass = arrlstClass.toArray(new Classdto[arrlstClass.size()]);
        DefaultComboBoxModel dmdCboClass = new DefaultComboBoxModel(arrClass);
        cboScheduleClass.setModel(dmdCboClass);

        List<Subjectdto> arrlstSubject = SubjectDAO.GetAllSubject();
        arrlstSubject.add(0, null);
        Subjectdto[] arrSubject = arrlstSubject.toArray(new Subjectdto[arrlstClass.size()]);
        DefaultComboBoxModel dmdCboSubject = new DefaultComboBoxModel(arrSubject);
        cboScheduleSubject.setModel(dmdCboSubject);
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            LoadDataToTable(false);
        } catch (IOException ex) {
            Logger.getLogger(frmInternalQueryStudentScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboScheduleClass;
    private javax.swing.JComboBox<String> cboScheduleSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblInfoSchedule;
    private javax.swing.JScrollPane pnlTable;
    private javax.swing.JTable tblTranscript;
    private javax.swing.JTextField txtStudentCode;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
