/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHGUI.Import;

import VMHDAO.*;
import VMHPOJO.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VMHIT
 */
public class frmInternalImportSchedule extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInternalImportSchedule
     */
    public frmInternalImportSchedule() {
        initComponents();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlInfo = new javax.swing.JPanel();
        btnFileChoose = new javax.swing.JButton();
        txtFilePath = new javax.swing.JTextField();
        lblFilePath = new javax.swing.JLabel();
        lblClass = new javax.swing.JLabel();
        cboClass = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        pnlTable = new javax.swing.JScrollPane();
        tblShedule = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setTitle("Nhập thời khóa biểu từ CSV");

        btnFileChoose.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFileChoose.setText("Chọn File");
        btnFileChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileChooseActionPerformed(evt);
            }
        });

        txtFilePath.setEditable(false);
        txtFilePath.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblFilePath.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFilePath.setLabelFor(txtFilePath);
        lblFilePath.setText("Đường dẫn File:");

        lblClass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblClass.setLabelFor(cboClass);
        lblClass.setText("Lớp:");

        cboClass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnSave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblClass)
                    .addComponent(lblFilePath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFilePath)
                    .addComponent(cboClass, 0, 428, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFileChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFileChoose)
                    .addComponent(txtFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFilePath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClass)
                    .addComponent(btnSave))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        tblShedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã môn", "Tên môn", "Phòng học"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlTable.setViewportView(tblShedule);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadDefault() {
        txtFilePath.setText("");
        LoadDataToCombobox();
    }

    private void LoadDataToTable() throws IOException {
        if (txtFilePath.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Chưa chọn file! Vui lòng chọn!", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(txtFilePath.getText()), "UTF-8"))) {
            String[] colNames = new String[]{"STT", "Mã môn", "Tên môn", "Phòng học"};
            DefaultTableModel modelSV = new DefaultTableModel(null, colNames);
            String line = br.readLine();
            if (!line.equals("STT,Mã môn,Tên môn,Phòng học")) {
                JOptionPane.showMessageDialog(null, "File không đúng cấu trúc! Vui lòng chọn lại", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ArrayList<String[]> arrlstData = new ArrayList<String[]>();
            while (line != null) {
                String[] dataLine = line.split(",");
                arrlstData.add(dataLine);
                line = br.readLine();
            }

            for (int i = 1; i < arrlstData.size(); i++) {
                modelSV.addRow(arrlstData.get(i));
            }

            tblShedule.setModel(modelSV);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmInternalImportSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void LoadDataToCombobox() {
        List<Classdto> lstClass = ClassDAO.GetAllClass();
        Classdto[] arrClass = lstClass.toArray(new Classdto[lstClass.size()]);
        DefaultComboBoxModel dmdCboClass = new DefaultComboBoxModel(arrClass);
        cboClass.setModel(dmdCboClass);
    }

    private void btnFileChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileChooseActionPerformed
        try {
            JFileChooser frmFileChoose = new JFileChooser("./filecsv");
            frmFileChoose.setDialogTitle("Chọn file nhập liệu");
            FileNameExtensionFilter filterExtension = new FileNameExtensionFilter("Các tập tin *.csv", "csv");
            frmFileChoose.setFileFilter(filterExtension);
            int chon = frmFileChoose.showOpenDialog(null);
            if (chon == JFileChooser.APPROVE_OPTION) {

                File f = frmFileChoose.getSelectedFile();
                txtFilePath.setText(f.getAbsolutePath());
                LoadDataToTable();
            }
        } catch (IOException ex) {
            Logger.getLogger(frmInternalImportSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFileChooseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        DefaultTableModel modelDataTable = (DefaultTableModel) (tblShedule.getModel());
        ArrayList<Scheduledto> lstSchedule = GetDataToArrayList(modelDataTable);
        Integer rs = 1;
        for (Scheduledto item : lstSchedule) {
            rs = ScheduleDAO.AddSchedule(item);
            if (rs == -1 || rs == 0) {
                break;
            }
        }
        if (rs == 1) {
            JOptionPane.showMessageDialog(null, "Nhập liệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nhập liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    public ArrayList<Scheduledto> GetDataToArrayList(DefaultTableModel modelTable) {
        @SuppressWarnings("Convert2Diamond")
        ArrayList<Scheduledto> lstSchedule = new ArrayList<Scheduledto>();
        for (int i = 0; i < modelTable.getRowCount(); i++) {
            // Lấy dữ liệu lớp
            Classdto modelClass = (Classdto) cboClass.getSelectedItem();
            
            //Lấy dữ liệu môn
            String sSubjectCode = modelTable.getValueAt(i, 1).toString();
            Subjectdto objSubject = SubjectDAO.GetSubjectWithCode(sSubjectCode);
            
            //Lấy thông tin phòng
            String sRoom = modelTable.getValueAt(i, 3).toString();
            
            //Tạo đối tượng TKB
            ScheduledtoId objID = new ScheduledtoId(modelClass, objSubject);
            Scheduledto schedule = new Scheduledto(objID, sRoom);
            
            //Thêm đối tượng vào danh sách
            lstSchedule.add(schedule);
        }
        return lstSchedule;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFileChoose;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboClass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblFilePath;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JScrollPane pnlTable;
    private javax.swing.JTable tblShedule;
    private javax.swing.JTextField txtFilePath;
    // End of variables declaration//GEN-END:variables
}