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
public class DAOUser {

    public static boolean AddUser(String _UserName, String _Password, boolean _IsAdmin) {
        String sPassEncrypt = clsEncryption.encrypt(_Password, _UserName);
        String sClass = _UserName + "," + sPassEncrypt + ",0";
        if (_IsAdmin) {
            sClass = _UserName + "," + sPassEncrypt + ",1";
        }
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/user.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                data.append(line).append("\n");
                line = br.readLine();
            }
            data.append(sClass);
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/user.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean ChangePasswordUser(String _UserName, String _Password) {
        String sPassEncrypt = clsEncryption.encrypt(_Password, _UserName);
        String sUser = _UserName + "," + sPassEncrypt + ",0";
        if (clsParameterSys.getIsAdmin()) {
            sUser = _UserName + "," + sPassEncrypt + ",1";
        }
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/user.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                String udp = "\n";
                if (_UserName == null ? dataLine[0] == null : _UserName.equals(dataLine[0])) {
                    udp = sUser + "\n";
                    data.append(udp);
                } else {
                    data.append(line).append(udp);
                }
                line = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/user.csv"), StandardCharsets.UTF_8))) {
            br.write(data.toString());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    // Lấy thông tin user theo user name
    public DTOUser GetUserWithName(String _UserName) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/user.csv"), "UTF-8"))) {

            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                if (_UserName.equals(dataLine[0])) {
                    DTOUser modelUser = new DTOUser();
                    modelUser.setUserName(dataLine[0]);
                    modelUser.setPassword(dataLine[1]);
                    return modelUser;
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clsUtilityCombobox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Kiểm tra user đăng nhập
    public static boolean CheckLogin(String _UserName, String _Password) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/user.csv"), "UTF-8"))) {
            String line = br.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                String sPassDecrypt = clsEncryption.encrypt(_Password, _UserName);
                if (_UserName.equals(dataLine[0]) && sPassDecrypt.equals(dataLine[1])) {
                    clsParameterSys.setIsAdmin(dataLine[2].equals("1"));
                    return true;
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clsUtilityCombobox.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
}
