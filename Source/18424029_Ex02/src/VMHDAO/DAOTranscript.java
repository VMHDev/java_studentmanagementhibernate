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
public class DAOTranscript {

    public static boolean AddTranscript(Long _StudentID, Float _ScoresMid, Float _ScoresEnd, Float _ScoresOther, Float _ScoresSum, Long _SubjectID) {
        String stringClass = _StudentID + "," + _ScoresMid + "," + _ScoresEnd + "," + _ScoresOther + "," + _ScoresSum + "," + _SubjectID;
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/transcript.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                data.append(line).append("\n");
                line = br.readLine();
            }
            data.append(stringClass);
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOTranscript.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOTranscript.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/transcript.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOTranscript.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static int UpdateTranscript(Long _StudentUpdate, Float _ScoresMid, Float _ScoresEnd, Float _ScoresOther, Float _ScoresSum, Long _SubjectUpdate) {
        StringBuilder data = new StringBuilder();
        boolean isUpdate = false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/transcript.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                String udp = "\n";
                if (_StudentUpdate == Long.parseLong(dataLine[0]) && _SubjectUpdate == Long.parseLong(dataLine[5])) {
                    udp = _StudentUpdate + "," + _ScoresMid + "," + _ScoresEnd + "," + _ScoresOther + "," + _ScoresSum + "," + _SubjectUpdate + "\n";
                    data.append(udp);
                    isUpdate = true;
                } else {
                    data.append(line).append(udp);
                }
                line = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOTranscript.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (IOException ex) {
            Logger.getLogger(DAOTranscript.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/transcript.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOTranscript.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

        if (!isUpdate) {
            return 0;
        }

        return 1;
    }

    public static int DeleteTranscript(Long _StudentDelete, Long _SubjectDelete) {
        StringBuilder data = new StringBuilder();
        boolean isDelete = false;
        try (BufferedReader br = new BufferedReader(new FileReader("./data/transcript.csv"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                if (_StudentDelete == Long.parseLong(dataLine[0]) && _SubjectDelete == Long.parseLong(dataLine[5])) {
                    isDelete = true;
                }
                if (_StudentDelete != Long.parseLong(dataLine[0]) && _SubjectDelete != Long.parseLong(dataLine[5])) {
                    data.append(line).append("\n");
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOTranscript.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (IOException ex) {
            Logger.getLogger(DAOTranscript.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

        try (BufferedWriter br = new BufferedWriter(new FileWriter("./data/transcript.csv"))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOTranscript.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        if (!isDelete) {
            return 0;
        }
        return 1;
    }
}
