/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHBUS;

import VMHDTO.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VMHIT
 */
public class clsUtility {

    // Map dữ liệu Key - Value
    public static Map<Long, String> GetMapObject(String _Type) throws IOException {
        switch (_Type) {
            case "ClassName":
                Map<Long, String> arrClassName = new HashMap<Long, String>();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/class.csv"), "UTF-8"))) {
                    String line = br.readLine();
                    while (line != null) {
                        String[] dataLine = line.split(",");
                        arrClassName.put(Long.parseLong(dataLine[0]), dataLine[1]);
                        line = br.readLine();
                    }
                    return arrClassName;
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(clsUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "SubjectCode":
                Map<Long, String> arrSubjectCode = new HashMap<Long, String>();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/subject.csv"), "UTF-8"))) {
                    String line = br.readLine();
                    while (line != null) {
                        String[] dataLine = line.split(",");
                        arrSubjectCode.put(Long.parseLong(dataLine[0]), dataLine[1]);
                        line = br.readLine();
                    }
                    return arrSubjectCode;
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(clsUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "SubjectName":
                Map<Long, String> arrSubjectName = new HashMap<Long, String>();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/subject.csv"), "UTF-8"))) {
                    String line = br.readLine();
                    while (line != null) {
                        String[] dataLine = line.split(",");
                        arrSubjectName.put(Long.parseLong(dataLine[0]), dataLine[2]);
                        line = br.readLine();
                    }
                    return arrSubjectName;
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(clsUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "StudentSubject_StudentCode":
                Map<Long, String> arrStudentCode = new HashMap<Long, String>();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/student_subject.csv"), "UTF-8"))) {
                    String line = br.readLine();
                    while (line != null) {
                        String[] dataLine = line.split(",");
                        arrStudentCode.put(Long.parseLong(dataLine[0]), dataLine[1]);
                        line = br.readLine();
                    }
                    return arrStudentCode;
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(clsUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        }

        return null;
    }

    public static String GetValueFromID(Long _ID) {
        try {
            Map<Long, String> objMapClass = clsUtility.GetMapObject("class");
            for (Map.Entry m : objMapClass.entrySet()) {
                if (m.getKey() == _ID) {
                    return m.getValue().toString();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(clsUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static ArrayList<KeyValue> GetListObjectKeyValue(String _Type) throws IOException {
//        ArrayList<KeyValue> arrClass = new ArrayList<KeyValue>();
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/" + _Type + ".csv"), "UTF-8"))) {
//            String line = br.readLine();
//            while (line != null) {
//                String[] dataLine = line.split(",");
//                KeyValue objModel = new KeyValue();
//                objModel.setID(Long.parseLong(dataLine[0]));
//                objModel.setValue(dataLine[1]);
//                arrClass.add(objModel);
//                line = br.readLine();
//            }
//            return arrClass;
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(clsUtility.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }

    public static String GetValueFromIDKeyValue(long _ID) {
//        try {
//            ArrayList<KeyValue> objMapClass = clsUtility.GetListObjectKeyValue("class");
//            for (int i = 0; i < objMapClass.size(); i++) {
//                if (objMapClass.get(i).getID() == _ID) {
//                    return objMapClass.get(i).getValue();
//                }
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(clsUtility.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return "";
    }
}
