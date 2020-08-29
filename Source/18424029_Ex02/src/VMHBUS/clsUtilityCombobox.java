/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHBUS;

import VMHDTO.*;
import VMHPOJO.*;
import javax.swing.JComboBox;

/**
 *
 * @author VMHIT
 */
public class clsUtilityCombobox {

    // Lấy item Combobox Class dựa trên ID
    public static void setSelectClassWithID(JComboBox comboBox, Integer value) {
        Classdto item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i) == null) {
                continue;
            }
            item = (Classdto) comboBox.getItemAt(i);
            if (item.getId() == value) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    // Lấy item Combobox Class dựa trên Code
    public static void setSelectClassWithCode(JComboBox comboBox, String value) {
        Classdto item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i) == null) {
                continue;
            }
            item = (Classdto) comboBox.getItemAt(i);
            if (item.getClassCode().equals(value)) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // Lấy item Combobox Subject dựa trên ID
    public static void setSelectSubjectWithID(JComboBox comboBox, Integer value) {
        Subjectdto item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i) == null) {
                continue;
            }
            item = (Subjectdto) comboBox.getItemAt(i);
            if (item.getId() == value) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    // Lấy item Combobox Subject dựa trên Name
    public static void setSelectSubjectWithName(JComboBox comboBox, String value) {
        Subjectdto item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i) == null) {
                continue;
            }
            item = (Subjectdto) comboBox.getItemAt(i);
            if (item.getSubjectName().equals(value)) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // Lấy item Combobox Student dựa trên ID
    public static void setSelectStudentWithID(JComboBox comboBox, Integer value) {
        Studentdto item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i) == null) {
                continue;
            }
            item = (Studentdto) comboBox.getItemAt(i);
            if (item.getId() == value) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // Lấy item Combobox ScoresType dựa trên Value
    public static void setSelectKeyValueWithValue(JComboBox comboBox, String value) {
        KeyValue item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i) == null) {
                continue;
            }
            item = (KeyValue) comboBox.getItemAt(i);
            if (item.getValue().equals(value)) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }
    
    // Lấy item Combobox ScoresType dựa trên ID
    public static void setSelectKeyValueWithID(JComboBox comboBox, String id) {
        KeyValue item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i) == null) {
                continue;
            }
            item = (KeyValue) comboBox.getItemAt(i);
            if (item.getID().equals(id)) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }
}
