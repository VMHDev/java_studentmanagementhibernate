/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHDAO;

import VMHBUS.clsUtilityCombobox;
import VMHDTO.DTOStudentSubject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VMHIT
 */
public class DAOStudentClass {

    public static boolean AddStudentClass(Long _ID, String _Code, String _Name, String _Gender, String _IdentityNumber, Long _ClassID) {
        String stringStudent = _ID + "," + _Code + "," + _Name + "," + _Gender + "," + _IdentityNumber + "," + _ClassID;
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/student_class.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                data.append(line).append("\n");
                line = br.readLine();
            }
            data.append(stringStudent);
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOStudentClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/student_class.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean UpdateStudentClass(Long _IDUpdate, String _Code, String _Name, String _Gender, String _IdentityNumber, Long _ClassID) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/student_class.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                String udp = "\n";
                if (_IDUpdate == Long.parseLong(dataLine[0])) {
                    udp = _IDUpdate + "," + _Code + "," + _Name + "," + _Gender + "," + _IdentityNumber + "," + _ClassID + "\n";
                    data.append(udp);
                } else {
                    data.append(line).append(udp);
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOStudentClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/student_class.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean DeleteStudentClass(Long _IDDelete) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("./data/student_class.csv"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                if (_IDDelete == null ? dataLine[0] == null : _IDDelete == Long.parseLong(dataLine[0])) {

                } else {
                    data.append(line).append("\n");
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOStudentClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new FileWriter("./data/student_class.csv"))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

}
