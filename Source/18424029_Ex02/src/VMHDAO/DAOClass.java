/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHDAO;

import VMHBUS.clsUtilityCombobox;
import VMHDTO.DTOClass;
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
public class DAOClass {

    public static boolean AddClass(Long _ClassID, String _ClassName) {
        String stringClass = _ClassID + "," + _ClassName;
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/class.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                data.append(line).append("\n");
                line = br.readLine();
            }
            data.append(stringClass);
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/class.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean UpdateClass(Long _ClassUpdate, String _ClassName) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/class.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                String udp = "\n";
                if (_ClassUpdate == Long.parseLong(dataLine[0])) {
                    udp = _ClassUpdate + "," + _ClassName + "\n";
                    data.append(udp);
                } else {
                    data.append(line).append(udp);
                }
                line = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/class.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean DeleteClass(Long _ClassDelete) {
        StringBuilder data = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("./data/class.csv"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                if (_ClassDelete == Long.parseLong(dataLine[0])) {

                } else {
                    data.append(line).append("\n");
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new FileWriter("./data/class.csv"))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    // Lấy tất cả danh sách lớp
    public static ArrayList<DTOClass> GetListClass() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/class.csv"), "UTF-8"))) {
            ArrayList<DTOClass> arrClass = new ArrayList<DTOClass>();
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                DTOClass modelClass = new DTOClass();
                modelClass.setID(Long.parseLong(dataLine[0]));
                modelClass.setClassName(dataLine[1]);
                arrClass.add(modelClass);
                line = br.readLine();
            }
            return arrClass;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clsUtilityCombobox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Lấy thông tin lớp theo ID
    public static DTOClass GetClassWithID(Long _ClassID) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/class.csv"), "UTF-8"))) {
            DTOClass modelClass = new DTOClass();
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                if (_ClassID == Long.parseLong(dataLine[0])) {                    
                    modelClass.setID(Long.parseLong(dataLine[0]));
                    modelClass.setClassName(dataLine[1]);
                    break;
                }
                line = br.readLine();
            }
            return modelClass;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clsUtilityCombobox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
