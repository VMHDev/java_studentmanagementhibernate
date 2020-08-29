/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHDAO;

import VMHBUS.clsUtilityCombobox;
import VMHDTO.DTOSubject;
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
public class DAOSubject {

    public static boolean AddSubject(Long _SubjectID, String _SubjectCode, String _SubjectName) {
        String stringClass = _SubjectID + "," + _SubjectCode + "," + _SubjectName;
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/subject.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                data.append(line).append("\n");
                line = br.readLine();
            }
            data.append(stringClass);
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/subject.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean UpdateSubject(Long _SubjectUpdate, String _SubjectCode, String _SubjectName) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/subject.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                String udp = "\n";
                if (_SubjectUpdate == Long.parseLong(dataLine[0])) {
                    udp = _SubjectUpdate + "," + _SubjectCode + "," + _SubjectName + "\n";
                    data.append(udp);
                } else {
                    data.append(line).append(udp);
                }
                line = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/subject.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean DeleteSubject(Long _SubjectDelete) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("./data/subject.csv"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                if (_SubjectDelete != Long.parseLong(dataLine[0])) {
                    data.append(line).append("\n");
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new FileWriter("./data/subject.csv"))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    // Lấy tất cả danh sách môn học
    public static ArrayList<DTOSubject> GetListSubject() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/subject.csv"), "UTF-8"))) {
            ArrayList<DTOSubject> arrSubject = new ArrayList<DTOSubject>();
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                DTOSubject modelSubject = new DTOSubject();
                modelSubject.setID(Long.parseLong(dataLine[0]));
                modelSubject.setCode(dataLine[1]);
                modelSubject.setName(dataLine[2]);
                arrSubject.add(modelSubject);
                line = br.readLine();
            }
            return arrSubject;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clsUtilityCombobox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Lấy thông tin môn học theo ID
    public static DTOSubject GetSubjectWithID(Long _SubjectID) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/subject.csv"), "UTF-8"))) {
            DTOSubject modelSubject = new DTOSubject();
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                if (_SubjectID == Long.parseLong(dataLine[0])) {

                    modelSubject.setID(Long.parseLong(dataLine[0]));
                    modelSubject.setCode(dataLine[1]);
                    modelSubject.setName(dataLine[2]);
                    break;
                }
                line = br.readLine();
            }
            return modelSubject;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clsUtilityCombobox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
