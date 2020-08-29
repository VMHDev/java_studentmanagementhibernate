/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHDAO;

import VMHBUS.*;
import VMHDTO.*;
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
public class DAOStudentSubject {

    public static boolean AddStudentSubject(Long _ID, String _Code, String _Name, String _Gender, String _IdentityNumber, Long _SubjectID) {
        String stringClass = _ID + "," + _Code + "," + _Name + "," + _Gender + "," + _IdentityNumber + "," + _SubjectID;
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/student_subject.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                data.append(line).append("\n");
                line = br.readLine();
            }
            data.append(stringClass);
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOStudentSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/student_subject.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean UpdateStudentSubject(Long _IDUpdate, String _Code, String _Name, String _Gender, String _IdentityNumber, Long _SubjectID) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/student_subject.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                String udp = "\n";
                if (_IDUpdate == Long.parseLong(dataLine[0])) {
                    udp = _IDUpdate + "," + _Code + "," + _Name + "," + _Gender + "," + _IdentityNumber + "," + _SubjectID + "\n";
                    data.append(udp);
                } else {
                    data.append(line).append(udp);
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOStudentSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/student_subject.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean DeleteStudentSubject(Long _IDDelete) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("./data/student_subject.csv"))) {
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
            Logger.getLogger(DAOStudentSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new FileWriter("./data/student_subject.csv"))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOStudentSubject.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    // Lấy tất cả sinh viên theo môn học 
    public static ArrayList<DTOStudentSubject> GetListStudentSubject() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/student_subject.csv"), "UTF-8"))) {
            ArrayList<DTOStudentSubject> arrStudentSubject = new ArrayList<DTOStudentSubject>();
            ArrayList<DTOSubject> arrlstSubject = DAOSubject.GetListSubject();
            ArrayList<DTOClass> arrlstClass = DAOClass.GetListClass();
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                DTOStudentSubject modelStudentSubject = new DTOStudentSubject();
                modelStudentSubject.setID(Long.parseLong(dataLine[0]));
                modelStudentSubject.setCode(dataLine[1]);
                modelStudentSubject.setName(dataLine[2]);
                modelStudentSubject.setGender(dataLine[3]);
                modelStudentSubject.setIdentityNumber(dataLine[4]);
                for (DTOSubject itemSubject : arrlstSubject) {
                    if (itemSubject.getID() == Long.parseLong(dataLine[5])) {
                        DTOSubject modelSubject = new DTOSubject(itemSubject);
                        modelStudentSubject.setStudentSubject(modelSubject);
                        break;
                    }
                }
                for (DTOClass itemClass : arrlstClass) {
                    if (itemClass.getID() == Long.parseLong(dataLine[6])) {
                        DTOClass modelClass = new DTOClass(itemClass);
                        modelStudentSubject.setStudentClass(modelClass);
                        break;
                    }
                }
                arrStudentSubject.add(modelStudentSubject);
                line = br.readLine();
            }
            return arrStudentSubject;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clsUtilityCombobox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Lấy danh sách sinh viên theo môn học, theo lớp
    public static ArrayList<DTOStudentSubject> GetListStudentSubject(Long _SubjectID, Long _ClassID) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/student_subject.csv"), "UTF-8"))) {
            ArrayList<DTOStudentSubject> arrSubject = new ArrayList<DTOStudentSubject>();
            ArrayList<DTOSubject> arrlstSubject = DAOSubject.GetListSubject();
            ArrayList<DTOClass> arrlstClass = DAOClass.GetListClass();
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                if (_SubjectID == Long.parseLong(dataLine[5]) && _ClassID == Long.parseLong(dataLine[6])) {
                    DTOStudentSubject modelStudentSubject = new DTOStudentSubject();
                    modelStudentSubject.setID(Long.parseLong(dataLine[0]));
                    modelStudentSubject.setCode(dataLine[1]);
                    modelStudentSubject.setName(dataLine[2]);
                    modelStudentSubject.setGender(dataLine[3]);
                    modelStudentSubject.setIdentityNumber(dataLine[4]);

                    for (DTOSubject itemSubject : arrlstSubject) {
                        if (itemSubject.getID() == Long.parseLong(dataLine[5])) {
                            DTOSubject modelSubject = new DTOSubject(itemSubject);
                            modelStudentSubject.setStudentSubject(modelSubject);
                            break;
                        }
                    }
                    for (DTOClass itemClass : arrlstClass) {
                        if (itemClass.getID() == Long.parseLong(dataLine[6])) {
                            DTOClass modelClass = new DTOClass(itemClass);
                            modelStudentSubject.setStudentClass(modelClass);
                            break;
                        }
                    }
                    arrSubject.add(modelStudentSubject);
                }
                line = br.readLine();
            }
            return arrSubject;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clsUtilityCombobox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Lấy thông tin sinh viên theo Code
    public static DTOStudentSubject GetStudentSubjectWithCode(String _StudentCode) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/student_subject.csv"), "UTF-8"))) {
            DTOStudentSubject modelStudentSubject = new DTOStudentSubject();
            ArrayList<DTOSubject> arrlstSubject = DAOSubject.GetListSubject();
            ArrayList<DTOClass> arrlstClass = DAOClass.GetListClass();
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                if (_StudentCode.equals(dataLine[1])) {
                    modelStudentSubject.setID(Long.parseLong(dataLine[0]));
                    modelStudentSubject.setCode(dataLine[1]);
                    modelStudentSubject.setName(dataLine[2]);
                    modelStudentSubject.setGender(dataLine[3]);
                    modelStudentSubject.setIdentityNumber(dataLine[4]);

                    for (DTOSubject itemSubject : arrlstSubject) {
                        if (itemSubject.getID() == Long.parseLong(dataLine[5])) {
                            DTOSubject modelSubject = new DTOSubject(itemSubject);
                            modelStudentSubject.setStudentSubject(modelSubject);
                            break;
                        }
                    }
                    for (DTOClass itemClass : arrlstClass) {
                        if (itemClass.getID() == Long.parseLong(dataLine[6])) {
                            DTOClass modelClass = new DTOClass(itemClass);
                            modelStudentSubject.setStudentClass(modelClass);
                            break;
                        }
                    }
                }
                line = br.readLine();
            }
            return modelStudentSubject;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clsUtilityCombobox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    // Lấy thông tin sinh viên theo Code, Subject, Class
    public static DTOStudentSubject GetStudentSubjectWithCodeSubjectClass(String _StudentCode, Long _SubjectID, Long _ClassID) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/student_subject.csv"), "UTF-8"))) {            
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                if (_StudentCode.equals(dataLine[1]) && _SubjectID == Long.parseLong(dataLine[5]) && _ClassID == Long.parseLong(dataLine[6])) {
                    DTOStudentSubject modelStudentSubject = new DTOStudentSubject();
                    modelStudentSubject.setID(Long.parseLong(dataLine[0]));
                    modelStudentSubject.setCode(dataLine[1]);
                    modelStudentSubject.setName(dataLine[2]);
                    modelStudentSubject.setGender(dataLine[3]);
                    modelStudentSubject.setIdentityNumber(dataLine[4]);
                    
                    Long lSubjectID = Long.parseLong(dataLine[5]);
                    DTOSubject modelSubject = DAOSubject.GetSubjectWithID(lSubjectID);
                    modelStudentSubject.setStudentSubject(modelSubject);

                    Long lClassID = Long.parseLong(dataLine[6]);
                    DTOClass modelClass = DAOClass.GetClassWithID(lClassID);
                    modelStudentSubject.setStudentClass(modelClass);
                    return modelStudentSubject;
                }
                line = br.readLine();
            }        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clsUtilityCombobox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
