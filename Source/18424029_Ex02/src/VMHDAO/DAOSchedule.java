/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHDAO;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VMHIT
 */
public class DAOSchedule {

    public static boolean AddSchedule(Long _ClassID, Long _SubjectID, String _Room) {
        String stringClass = _ClassID + "," + _SubjectID + "," + _Room;
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/schedule.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                data.append(line).append("\n");
                line = br.readLine();
            }
            data.append(stringClass);
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOSchedule.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOSchedule.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/schedule.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOSchedule.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean UpdateSchedule(Long _ClassUpdate, Long _SubjectID, String _Room) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/schedule.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                String udp = "\n";
                if (_ClassUpdate == Long.parseLong(dataLine[0]) && _SubjectID == Long.parseLong(dataLine[1])) {
                    udp = _ClassUpdate + "," + _SubjectID + "," + _Room + "\n";
                    data.append(udp);
                } else {
                    data.append(line).append(udp);
                }
                
                line = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOSchedule.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOSchedule.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/schedule.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOSchedule.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean DeleteSchedule(Long _ClassID, Long _SubjectID) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("./data/schedule.csv"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                if (_ClassID == null ? dataLine[0] == null : _ClassID == Long.parseLong(dataLine[0]) && _SubjectID == null ? dataLine[1] == null : _SubjectID == Long.parseLong(dataLine[1])) {

                } else {
                    data.append(line).append("\n");
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOSchedule.class.getName()).log(Level.SEVERE, null, ex);
            return false;            
        } catch (IOException ex) {
            Logger.getLogger(DAOSchedule.class.getName()).log(Level.SEVERE, null, ex);
            return false;            
        }

        try (BufferedWriter br = new BufferedWriter(new FileWriter("./data/schedule.csv"))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOSchedule.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
