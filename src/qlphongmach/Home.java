package qlphongmach;


import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import keeptoo.Drag;
import qlphongmach.Connect_db;
import qlphongmach.Doctor;
import qlphongmach.Medicine;
import qlphongmach.MedicineBill;
import qlphongmach.Patient;
import qlphongmach.Service;
import qlphongmach.ServiceBill;
import qlphongmach.TotalBill;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sieus
 */
public class Home extends javax.swing.JFrame {


    Connect_db con = new Connect_db();
    Doctor Dr = new Doctor();
    Patient Patient = new Patient();
    Service ser = new Service();
    Medicine med = new Medicine();
    ServiceBill serBill = new ServiceBill();
    MedicineBill medBill = new MedicineBill();
    TotalBill total = new TotalBill();
    private int flag = 0;
    /**
     * Creates new form Home
     * @throws java.sql.SQLException
     */
    public Home() throws SQLException {
        initComponents();
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
        jInternalFrame7.setVisible(false);
        jInternalFrame8.setVisible(false);
    }
    //----------------------------------------------------------------------//
    //-----------------------------CLEARTEXT-------------------------------//
    //--------------------------------------------------------------------//

    public void ClearTextBN()
    {
        txtIDPatient.setText("");
        txtNamePatient.setText("");
        //txtBirthday.setText("");
        //Date  date = new Date("");
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //Date Date = sdf.parse(" ");
        //ChooserBirthday.setDate(Date);
        txtGender.setText("");
        txtAddress.setText("");
        txtHealthInsurance.setText("");
    }
    public void ClearTextDV()
    {
        txtIDService.setText("");
        txtNameService.setText("");
        txtServicePrices.setText("");
    }
    public void CLearTextT()
    {
        txtIDMedicine.setText("");
        txtNameMedicine.setText("");
        txtMedicinePrices.setText("");
        txtExpiryDate.setText("");
        txtDosage.setText("");
    }
    public void ClearTextDDV()
    {
        txtIDServiceBill.setText("");
        txtIDPatientServiceBill.setText("");
        txtAddressServiceBill.setText("");
        txtGenderServiceBill.setText("");
        txtNamePatientServiceBill.setText("");
        txtBirthdayrServiceBill.setText("");
        txtHealthInsuranceServiceBill.setText("");
        txtNameDoctorServiceBill.setText("");
        txtIDDoctorServiceBill.setText("");
        txtIDServiceServiceBill.setText("");
        txtServiceBillPrices.setText("");
    }
    public void ClearTextDT()
    {
        txtIDMedicineBill.setText("");
        txtIDPatientMedicineBill.setText("");
        txtNamePatientMedicineBill.setText("");
        txtAddressMedicineBill.setText("");
        txtGenderMedicineBill.setText("");
        txtBirthdayMedicineBill.setText("");
        txtHealthInsuranceMedicineBill.setText("");
        txtIDDoctorMedicineBill.setText("");
        txtNameDoctorMedicineBill.setText("");
        txtIDMedicineMedicineBill.setText("");
        txtDosageMedicineBill.setText("");
        txtTotalPricesMedicineBill.setText("");
    }
    public void ClearTextHD()
    {
        txtIDTotalBill.setText("");
        txtIDPatientTotalBill.setText("");
        txtNamePatientTotalBill.setText("");
        txtAddressTotalBill.setText("");
        txtGenderTotalBill.setText("");
        txtBirthdayTotalBill.setText("");
        txtHealthInsuranceTotalBill.setText("");
        txtIDMedicineTotalBill.setText("");
        txtIDServiceTotalBill.setText("");
        txtTotalPricesTotalBill.setText("");
    }
    //----------------------------------------------------------------------//
    //-------------------------------SHOWDATA-------------------------------//
    //----------------------------------------------------------------------//
    public void  showDataBS()
    {
        String[] columNames = {"MaBS","TenBS","ChuyenNganh"};
        // Đối tượng này để chứa dữ liệu từ SQL để cho vào jTable
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columNames);
        tblListDoctor.setModel(model);

        String MaBS = "";
        String TenBS = "";
        String ChuyenNganh = "";

        ResultSet rs = con.getData("SELECT * FROM BACSI");
        try {
            while(rs.next())
            {
                MaBS = rs.getString("MaBS");
                TenBS = rs.getString("TenBS");
                ChuyenNganh = rs.getString("ChuyenNganh");

                model.addRow(new Object[]{MaBS, TenBS , ChuyenNganh});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void  showDataBN()
    {
        String[] columNames = {"MaBN","TenBN","Ngaysinh","GT","DiaChi","BaoHiem"};
        // Đối tượng này để chứa dữ liệu từ SQL để cho vào jTable
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columNames);
        tblListPatient.setModel(model);

        String MaBN = "";
        String TenBN = "";
        String Ngaysinh = "";
        String GT = "";
        String DiaChi = "";
        String BaoHiem = "";

        ResultSet rs = con.getData("SELECT * FROM BENHNHAN");
        try {
            while(rs.next())
            {
                MaBN = rs.getString("MaBN");
                TenBN = rs.getString("TenBN");
                Ngaysinh = rs.getString("NgaySinh");
                GT = rs.getString("GT");
                DiaChi = rs.getString("DiaChi");
                BaoHiem = rs.getString("BaoHiem");
                model.addRow(new Object[]{MaBN, TenBN ,Ngaysinh, GT, DiaChi, BaoHiem});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void  showDataDV()
    {
        String[] columNames = {"MaDV","TenDV","GiaDV"};
        // Đối tượng này để chứa dữ liệu từ SQL để cho vào jTable
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columNames);
        tblListService.setModel(model);

        String MaDV = "";
        String TenDV = "";
        String GiaDV = "";

        ResultSet rs = con.getData("SELECT * FROM DICHVU");
        try {
            while(rs.next())
            {
                MaDV = rs.getString("MaDV");
                TenDV = rs.getString("TenDV");
                GiaDV = rs.getString("GiaDV");
                model.addRow(new Object[]{MaDV, TenDV ,GiaDV});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void  showDataT()
    {
        String[] columNames = {"MaT","TenT","HSD","LieuDung","GiaT"};
        // Đối tượng này để chứa dữ liệu từ SQL để cho vào jTable
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columNames);
        tblListMedicine.setModel(model);

        String MaT = "";
        String TenT = "";
        String HSD = "";
        String GiaT = "";
        String LieuDung = "";
        ResultSet rs = con.getData("SELECT * FROM THUOC");
        try {
            while(rs.next())
            {
                MaT = rs.getString("MaT");
                TenT = rs.getString("TenThuoc");
                HSD = rs.getString("HSD");
                LieuDung = rs.getString("LieuDung");
                GiaT = rs.getString("GiaThuoc");
                model.addRow(new Object[]{MaT, TenT ,HSD,LieuDung,GiaT});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //SERVICE BILL

    public void  showDataDDV()
    {
        String[] columNames = {"MaDDV","MaBS","MaBN","MaDV","TienDV"};
        // Đối tượng này để chứa dữ liệu từ SQL để cho vào jTable
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columNames);
        tblListServiceBill.setModel(model);

        String MaDDV = "";
        String MaBS = "";
        String MaBN = "";
        String MaDV = "";
        String TienDV = "";
        ResultSet rs = con.getData("SELECT * FROM DONDV");
        try {
            while(rs.next())
            {
                MaDDV = rs.getString("MaDDV");
                MaBS = rs.getString("MaBS");
                MaBN = rs.getString("MaBN");
                MaDV = rs.getString("MaDV");
                TienDV = rs.getString("TienDV");
                model.addRow(new Object[]{MaDDV, MaBS ,MaBN,MaDV,TienDV});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showDataDT()
    {
        String[]  columNames = {"MaDT","MaBS","MaBN","MaT","TienThuoc"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columNames);
        tblListMedicineBill.setModel(model);
        String MaDT = "";
        String MaBS = "";
        String MaBN = "";
        String MaT = "";
        String TienThuoc = "";

        ResultSet rs = con.getData("SELECT * FROM DONTHUOC");
        try {
            while(rs.next())
            {
                MaDT = rs.getString("MaDT");
                MaBS = rs.getString("MaBS");
                MaBN = rs.getString("MaBN");
                MaT = rs.getString("MaT");
                TienThuoc = rs.getString("TienThuoc");
                model.addRow(new Object[] {MaDT,MaBS,MaBN,MaT,TienThuoc});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //TOTAL BILL

    public void showDataHD()
    {
        String[]  columNames = {"MaHD","MaDT","MaDDV","MaBN","TongTien"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columNames);
        tblListTotalBill.setModel(model);
        String MaHD = "";
        String MaDT = "";
        String MaDDV = "";
        String MaBN = "";
        String TongTien = "";

        ResultSet rs = con.getData("SELECT * FROM HOADON");
        try {
            while(rs.next())
            {
                MaHD = rs.getString("MaHD");
                MaDT = rs.getString("MaDT");
                MaDDV = rs.getString("MaDDV");
                MaBN = rs.getString("MaBN");
                TongTien = rs.getString("TongTien");
                model.addRow(new Object[] {MaHD,MaDT,MaDDV,MaBN,TongTien});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //ABOUT
    public void  showDataUser()
    {
        PreparedStatement statement;
        String Username = "";
        String Address = "";
        String Fullname = "";

        ResultSet rs = con.getData("SELECT * FROM USERS WHERE Username = ?");
        try {
            while(rs.next())
            {
                Username = rs.getString("Username");
                Address = rs.getString("Address");
                Fullname = rs.getString("Fullname");

                //statement.setString(1, stringSQL);
                //rs = statement.executeQuery();
                txtUsername.setText(Username);
                txtFullname.setText(Fullname);
                txtAboutAddress.setText(Address);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //------------------------------------------------------------//
    //---------------------------BUTTON-----------------------//
    //----------------------------------------------------------//
    //DOCTOR
    public void getSelectFirstBS(){
        int selectedRow = 0;
        txtIDDoctor.setText(tblListDoctor.getValueAt(selectedRow, 0).toString());
        txtNameDoctor.setText(tblListDoctor.getValueAt(selectedRow, 1).toString());
        txtSpecialized.setText(tblListDoctor.getValueAt(selectedRow, 2).toString());
        tblListDoctor.setRowSelectionInterval(0, 0);
    }
    public void getSelectPreviousBS(){
        if(tblListDoctor.getSelectedRow() >= 1)
        {
            int selectedRow = tblListDoctor.getSelectedRow() - 1;
            txtIDDoctor.setText(tblListDoctor.getValueAt(selectedRow, 0).toString());
            txtNameDoctor.setText(tblListDoctor.getValueAt(selectedRow, 1).toString());
            txtSpecialized.setText(tblListDoctor.getValueAt(selectedRow, 2).toString());
            tblListDoctor.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectNextBS(){
        if(tblListDoctor.getSelectedRow() < tblListDoctor.getRowCount() - 1)
        {
            int selectedRow = tblListDoctor.getSelectedRow() + 1;
            txtIDDoctor.setText(tblListDoctor.getValueAt(selectedRow, 0).toString());
            txtNameDoctor.setText(tblListDoctor.getValueAt(selectedRow, 1).toString());
            txtSpecialized.setText(tblListDoctor.getValueAt(selectedRow, 2).toString());
            tblListDoctor.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectLastBS(){
        int selectedRow = tblListDoctor.getRowCount()- 1;
        txtIDDoctor.setText(tblListDoctor.getValueAt(selectedRow, 0).toString());
        txtNameDoctor.setText(tblListDoctor.getValueAt(selectedRow, 1).toString());
        txtSpecialized.setText(tblListDoctor.getValueAt(selectedRow, 2).toString());
        tblListDoctor.setRowSelectionInterval(selectedRow, selectedRow);
    }
    //PATIENT
    public void getSelectFirstBN(){

        try {
            int selectedRow = 0;
            //DefaultTableModel model = (DefaultTableModel)tblListPatient.getModel();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tblListPatient.getValueAt(selectedRow, 2).toString());
            ChooserBirthday.setDate(date);
            txtIDPatient.setText(tblListPatient.getValueAt(selectedRow, 0).toString());
            txtNamePatient.setText(tblListPatient.getValueAt(selectedRow, 1).toString());
            txtGender.setText(tblListPatient.getValueAt(selectedRow, 3).toString());
            txtAddress.setText(tblListPatient.getValueAt(selectedRow, 4).toString());
            //txtPhoneNumber.setText(tblListPatient.getValueAt(selectedRow, 2).toString());
            txtHealthInsurance.setText(tblListPatient.getValueAt(selectedRow, 5).toString());

            tblListPatient.setRowSelectionInterval(0, 0);
        } catch (ParseException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void getSelectPreviousBN(){
        if(tblListPatient.getSelectedRow() >= 1)
        {
            try {
                int selectedRow = tblListPatient.getSelectedRow() - 1;
                Date  date = new SimpleDateFormat("yyyy-MM-dd").parse(tblListPatient.getValueAt(selectedRow, 2).toString());
                ChooserBirthday.setDate(date);
                txtIDPatient.setText(tblListPatient.getValueAt(selectedRow, 0).toString());
                txtNamePatient.setText(tblListPatient.getValueAt(selectedRow, 1).toString());
                txtGender.setText(tblListPatient.getValueAt(selectedRow, 3).toString());
                txtAddress.setText(tblListPatient.getValueAt(selectedRow, 4).toString());
                //txtPhoneNumber.setText(tblListPatient.getValueAt(selectedRow, 2).toString());
                txtHealthInsurance.setText(tblListPatient.getValueAt(selectedRow, 5).toString());
                tblListPatient.setRowSelectionInterval(selectedRow, selectedRow);
            } catch (ParseException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    public void getSelectNextBN(){
        if(tblListPatient.getSelectedRow() < tblListPatient.getRowCount() - 1)
        {
            try {
                int selectedRow = tblListPatient.getSelectedRow() + 1;
                Date  date = new SimpleDateFormat("yyyy-MM-dd").parse(tblListPatient.getValueAt(selectedRow, 2).toString());
                ChooserBirthday.setDate(date);
                txtIDPatient.setText(tblListPatient.getValueAt(selectedRow, 0).toString());
                txtNamePatient.setText(tblListPatient.getValueAt(selectedRow, 1).toString());
                txtGender.setText(tblListPatient.getValueAt(selectedRow, 3).toString());
                txtAddress.setText(tblListPatient.getValueAt(selectedRow, 4).toString());
                //txtPhoneNumber.setText(tblListPatient.getValueAt(selectedRow, 2).toString());
                txtHealthInsurance.setText(tblListPatient.getValueAt(selectedRow, 5).toString());
                tblListPatient.setRowSelectionInterval(selectedRow, selectedRow);
            } catch (ParseException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    public void getSelectLastBN(){
        try {
            int selectedRow = tblListPatient.getRowCount()- 1;
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tblListPatient.getValueAt(selectedRow, 2).toString());
            ChooserBirthday.setDate(date);
            txtIDPatient.setText(tblListPatient.getValueAt(selectedRow, 0).toString());
            txtNamePatient.setText(tblListPatient.getValueAt(selectedRow, 1).toString());
            txtGender.setText(tblListPatient.getValueAt(selectedRow, 3).toString());
            txtAddress.setText(tblListPatient.getValueAt(selectedRow, 4).toString());
            //txtPhoneNumber.setText(tblListPatient.getValueAt(selectedRow, 2).toString());
            txtHealthInsurance.setText(tblListPatient.getValueAt(selectedRow, 5).toString());
            tblListPatient.setRowSelectionInterval(selectedRow, selectedRow);
        } catch (ParseException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //SERVICE
    public void getSelectFirstDV(){
        int selectedRow = 0;
        txtIDService.setText(tblListService.getValueAt(selectedRow, 0).toString());
        txtNameService.setText(tblListService.getValueAt(selectedRow, 1).toString());
        txtServicePrices.setText(tblListService.getValueAt(selectedRow, 2).toString());
        tblListService.setRowSelectionInterval(0, 0);
    }
    public void getSelectPreviousDV(){
        if(tblListService.getSelectedRow() >= 1)
        {
            int selectedRow = tblListService.getSelectedRow() - 1;
            txtIDService.setText(tblListService.getValueAt(selectedRow, 0).toString());
            txtNameService.setText(tblListService.getValueAt(selectedRow, 1).toString());
            txtServicePrices.setText(tblListService.getValueAt(selectedRow, 2).toString());
            tblListService.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectNextDV(){
        if(tblListService.getSelectedRow() < tblListService.getRowCount() - 1)
        {
            int selectedRow = tblListService.getSelectedRow() + 1;
            txtIDService.setText(tblListService.getValueAt(selectedRow, 0).toString());
            txtNameService.setText(tblListService.getValueAt(selectedRow, 1).toString());
            txtServicePrices.setText(tblListService.getValueAt(selectedRow, 2).toString());
            tblListService.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectLastDV(){
        int selectedRow = tblListService.getRowCount()- 1;
        txtIDService.setText(tblListService.getValueAt(selectedRow, 0).toString());
        txtNameService.setText(tblListService.getValueAt(selectedRow, 1).toString());
        txtServicePrices.setText(tblListService.getValueAt(selectedRow, 2).toString());
        tblListService.setRowSelectionInterval(selectedRow, selectedRow);
    }
    //MEDICINE
    public void getSelectFirstT(){
        int selectedRow = 0;
        txtIDMedicine.setText(tblListMedicine.getValueAt(selectedRow, 0).toString());
        txtNameMedicine.setText(tblListMedicine.getValueAt(selectedRow, 1).toString());
        txtExpiryDate.setText(tblListMedicine.getValueAt(selectedRow, 2).toString());
        txtDosage.setText(tblListMedicine.getValueAt(selectedRow, 3).toString());
        txtMedicinePrices.setText(tblListMedicine.getValueAt(selectedRow, 4).toString());
        tblListMedicine.setRowSelectionInterval(0, 0);
    }
    public void getSelectPreviousT(){
        if(tblListMedicine.getSelectedRow() >= 1)
        {
            int selectedRow = tblListMedicine.getSelectedRow() - 1;
            txtIDMedicine.setText(tblListMedicine.getValueAt(selectedRow, 0).toString());
            txtNameMedicine.setText(tblListMedicine.getValueAt(selectedRow, 1).toString());
            txtExpiryDate.setText(tblListMedicine.getValueAt(selectedRow, 2).toString());
            txtDosage.setText(tblListMedicine.getValueAt(selectedRow, 3).toString());
            txtMedicinePrices.setText(tblListMedicine.getValueAt(selectedRow, 4).toString());
            tblListMedicine.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectNextT(){
        if(tblListMedicine.getSelectedRow() < tblListMedicine.getRowCount() - 1)
        {
            int selectedRow = tblListMedicine.getSelectedRow() + 1;
            txtIDMedicine.setText(tblListMedicine.getValueAt(selectedRow, 0).toString());
            txtNameMedicine.setText(tblListMedicine.getValueAt(selectedRow, 1).toString());
            txtExpiryDate.setText(tblListMedicine.getValueAt(selectedRow, 2).toString());
            txtDosage.setText(tblListMedicine.getValueAt(selectedRow, 3).toString());
            txtMedicinePrices.setText(tblListMedicine.getValueAt(selectedRow, 4).toString());
            tblListMedicine.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectLastT(){
        int selectedRow = tblListMedicine.getRowCount()- 1;
        txtIDMedicine.setText(tblListMedicine.getValueAt(selectedRow, 0).toString());
        txtNameMedicine.setText(tblListMedicine.getValueAt(selectedRow, 1).toString());
        txtExpiryDate.setText(tblListMedicine.getValueAt(selectedRow, 2).toString());
        txtDosage.setText(tblListMedicine.getValueAt(selectedRow, 3).toString());
        txtMedicinePrices.setText(tblListMedicine.getValueAt(selectedRow, 4).toString());
        tblListMedicine.setRowSelectionInterval(selectedRow, selectedRow);
    }
    //SERVICE BILL
    public void showServicePrices(int selectedRow)
    {
        String[]stringSQL = {tblListServiceBill.getValueAt(selectedRow, 3).toString(),tblListServiceBill.getValueAt(selectedRow, 3).toString()};
        int isInsert = serBill.ServicePrices(stringSQL);
        showDataDDV();
    }
    public void getSelectFirstDDV() {
        int selectedRow = 0;
        showServicePrices(selectedRow);
        txtIDServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 0).toString());
        txtIDDoctorServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 1).toString());
        txtIDPatientServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 2).toString());
        txtIDServiceServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 3).toString());
        txtServiceBillPrices.setText(tblListServiceBill.getValueAt(selectedRow, 4).toString());
        ResultSet rs = Patient.getDataBN(tblListServiceBill.getValueAt(selectedRow, 2).toString());
        ResultSet rs1 = Dr.getDataBS(tblListServiceBill.getValueAt(selectedRow, 1).toString());
        String TenBS = "";
        String TenBN = "";
        String Diachi = "";
        String Gioitinh = "";
        String NgaySinh = "";
        String BaoHiem = "";
        try {
            while(rs.next())
            {
                TenBN = rs.getString("TenBN");
                Diachi = rs.getString("DiaChi");
                Gioitinh = rs.getString("GT");
                NgaySinh = rs.getString("NgaySinh");
                BaoHiem = rs.getString("BaoHiem");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs1.next())
            {
                TenBS = rs1.getString("TenBS");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNameDoctorServiceBill.setText(TenBS);
        txtNamePatientServiceBill.setText(TenBN);
        txtAddressServiceBill.setText(Diachi);
        txtGenderServiceBill.setText(Gioitinh);
        txtBirthdayrServiceBill.setText(NgaySinh);
        txtHealthInsuranceServiceBill.setText(BaoHiem);
        tblListServiceBill.setRowSelectionInterval(0, 0);
    }
    public void getSelectPreviousDDV(){
        if(tblListServiceBill.getSelectedRow() >= 1)
        {
            int selectedRow = tblListServiceBill.getSelectedRow() - 1;
            showServicePrices(selectedRow);
            txtIDServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 0).toString());
            txtIDDoctorServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 1).toString());
            txtIDPatientServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 2).toString());
            txtIDServiceServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 3).toString());
            txtServiceBillPrices.setText(tblListServiceBill.getValueAt(selectedRow, 4).toString());
            ResultSet rs = Patient.getDataBN(tblListServiceBill.getValueAt(selectedRow, 2).toString());
            ResultSet rs1 = Dr.getDataBS(tblListServiceBill.getValueAt(selectedRow, 1).toString());
            String TenBS = "";
            String TenBN = "";
            String Diachi = "";
            String Gioitinh = "";
            String NgaySinh = "";
            String BaoHiem = "";
            try {
                while(rs.next())
                {
                    TenBN = rs.getString("TenBN");
                    Diachi = rs.getString("DiaChi");
                    Gioitinh = rs.getString("GT");
                    NgaySinh = rs.getString("NgaySinh");
                    BaoHiem = rs.getString("BaoHiem");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while(rs1.next())
                {
                    TenBS = rs1.getString("TenBS");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtNameDoctorServiceBill.setText(TenBS);
            txtNamePatientServiceBill.setText(TenBN);
            txtAddressServiceBill.setText(Diachi);
            txtGenderServiceBill.setText(Gioitinh);
            txtBirthdayrServiceBill.setText(NgaySinh);
            txtHealthInsuranceServiceBill.setText(BaoHiem);
            tblListServiceBill.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectNextDDV(){
        if(tblListServiceBill.getSelectedRow() < tblListServiceBill.getRowCount() - 1)
        {
            int selectedRow = tblListServiceBill.getSelectedRow() + 1;
            showServicePrices(selectedRow);
            txtIDServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 0).toString());
            txtIDDoctorServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 1).toString());
            txtIDPatientServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 2).toString());
            txtIDServiceServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 3).toString());
            txtServiceBillPrices.setText(tblListServiceBill.getValueAt(selectedRow, 4).toString());
            ResultSet rs = Patient.getDataBN(tblListServiceBill.getValueAt(selectedRow, 2).toString());
            ResultSet rs1 = Dr.getDataBS(tblListServiceBill.getValueAt(selectedRow, 1).toString());
            String TenBS = "";
            String TenBN = "";
            String Diachi = "";
            String Gioitinh = "";
            String NgaySinh = "";
            String BaoHiem = "";
            try {
                while(rs.next())
                {
                    TenBN = rs.getString("TenBN");
                    Diachi = rs.getString("DiaChi");
                    Gioitinh = rs.getString("GT");
                    NgaySinh = rs.getString("NgaySinh");
                    BaoHiem = rs.getString("BaoHiem");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while(rs1.next())
                {
                    TenBS = rs1.getString("TenBS");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtNameDoctorServiceBill.setText(TenBS);
            txtNamePatientServiceBill.setText(TenBN);
            txtAddressServiceBill.setText(Diachi);
            txtGenderServiceBill.setText(Gioitinh);
            txtBirthdayrServiceBill.setText(NgaySinh);
            txtHealthInsuranceServiceBill.setText(BaoHiem);
            tblListServiceBill.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectLastDDV(){
        int selectedRow = tblListServiceBill.getRowCount()- 1;
        showServicePrices(selectedRow);
        txtIDServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 0).toString());
        txtIDDoctorServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 1).toString());
        txtIDPatientServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 2).toString());
        txtIDServiceServiceBill.setText(tblListServiceBill.getValueAt(selectedRow, 3).toString());
        txtServiceBillPrices.setText(tblListServiceBill.getValueAt(selectedRow, 4).toString());
        ResultSet rs = Patient.getDataBN(tblListServiceBill.getValueAt(selectedRow, 2).toString());
        ResultSet rs1 = Dr.getDataBS(tblListServiceBill.getValueAt(selectedRow, 1).toString());
        String TenBS = "";
        String TenBN = "";
        String Diachi = "";
        String Gioitinh = "";
        String NgaySinh = "";
        String BaoHiem = "";
        try {
            while(rs.next())
            {
                TenBN = rs.getString("TenBN");
                Diachi = rs.getString("DiaChi");
                Gioitinh = rs.getString("GT");
                NgaySinh = rs.getString("NgaySinh");
                BaoHiem = rs.getString("BaoHiem");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs1.next())
            {
                TenBS = rs1.getString("TenBS");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNameDoctorServiceBill.setText(TenBS);
        txtNamePatientServiceBill.setText(TenBN);
        txtAddressServiceBill.setText(Diachi);
        txtGenderServiceBill.setText(Gioitinh);
        txtBirthdayrServiceBill.setText(NgaySinh);
        txtHealthInsuranceServiceBill.setText(BaoHiem);
        tblListServiceBill.setRowSelectionInterval(selectedRow, selectedRow);
    }
    //MEDICINE BILL
    public void showMedicinePrices(int selectedRow)
    {
        String[]stringSQL = {tblListMedicineBill.getValueAt(selectedRow, 3).toString()};
        int isInsert = medBill.MedicinePrices(stringSQL);
        showDataDT();
    }
    public void getSelectFirstDT() {
        int selectedRow = 0;
        showMedicinePrices(selectedRow);
        txtIDMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 0).toString());
        txtIDDoctorMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 1).toString());
        txtIDPatientMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 2).toString());
        txtIDMedicineMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 3).toString());

        txtTotalPricesMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 4).toString());
        ResultSet rs = Patient.getDataBN(tblListMedicineBill.getValueAt(selectedRow, 2).toString());
        ResultSet rs1 = Dr.getDataBS(tblListMedicineBill.getValueAt(selectedRow, 1).toString());
        ResultSet rs2 = med.getDataT(tblListMedicineBill.getValueAt(selectedRow, 3).toString());
        String TenBS = "";
        String TenBN = "";
        String Diachi = "";
        String Gioitinh = "";
        String NgaySinh = "";
        String BaoHiem = "";
        String LieuDung = "";
        try {
            while(rs.next())
            {
                TenBN = rs.getString("TenBN");
                Diachi = rs.getString("DiaChi");
                Gioitinh = rs.getString("GT");
                NgaySinh = rs.getString("NgaySinh");
                BaoHiem = rs.getString("BaoHiem");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs1.next())
            {
                TenBS = rs1.getString("TenBS");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs2.next())
            {
                LieuDung = rs2.getString("LieuDung");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtDosageMedicineBill.setText(LieuDung);
        txtNameDoctorMedicineBill.setText(TenBS);
        txtNamePatientMedicineBill.setText(TenBN);
        txtAddressMedicineBill.setText(Diachi);
        txtGenderMedicineBill.setText(Gioitinh);
        txtBirthdayMedicineBill.setText(NgaySinh);
        txtHealthInsuranceMedicineBill.setText(BaoHiem);
        tblListMedicineBill.setRowSelectionInterval(0, 0);
    }
    public void getSelectPreviousDT(){
        if(tblListMedicineBill.getSelectedRow() >= 1)
        {
            int selectedRow = tblListMedicineBill.getSelectedRow() - 1;
            showMedicinePrices(selectedRow);
            txtIDMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 0).toString());
            txtIDDoctorMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 1).toString());
            txtIDPatientMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 2).toString());
            txtIDMedicineMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 3).toString());
            //txtDosageMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 4).toString());
            txtTotalPricesMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 4).toString());
            ResultSet rs = Patient.getDataBN(tblListMedicineBill.getValueAt(selectedRow, 2).toString());
            ResultSet rs1 = Dr.getDataBS(tblListMedicineBill.getValueAt(selectedRow, 1).toString());
            ResultSet rs2 = med.getDataT(tblListMedicineBill.getValueAt(selectedRow, 3).toString());
            String TenBS = "";
            String TenBN = "";
            String Diachi = "";
            String Gioitinh = "";
            String NgaySinh = "";
            String BaoHiem = "";
            String LieuDung = "";
            try {
                while(rs.next())
                {
                    TenBN = rs.getString("TenBN");
                    Diachi = rs.getString("DiaChi");
                    Gioitinh = rs.getString("GT");
                    NgaySinh = rs.getString("NgaySinh");
                    BaoHiem = rs.getString("BaoHiem");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while(rs1.next())
                {
                    TenBS = rs1.getString("TenBS");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while(rs2.next())
                {
                    LieuDung = rs2.getString("LieuDung");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtDosageMedicineBill.setText(LieuDung);
            txtNameDoctorMedicineBill.setText(TenBS);
            txtNamePatientMedicineBill.setText(TenBN);
            txtAddressMedicineBill.setText(Diachi);
            txtGenderMedicineBill.setText(Gioitinh);
            txtBirthdayMedicineBill.setText(NgaySinh);
            txtHealthInsuranceMedicineBill.setText(BaoHiem);
            tblListMedicineBill.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectNextDT(){
        if(tblListMedicineBill.getSelectedRow() < tblListMedicineBill.getRowCount() - 1)
        {
            int selectedRow = tblListMedicineBill.getSelectedRow() + 1;
            showMedicinePrices(selectedRow);
            txtIDMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 0).toString());
            txtIDDoctorMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 1).toString());
            txtIDPatientMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 2).toString());
            txtIDMedicineMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 3).toString());
            //txtDosageMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 4).toString());
            txtTotalPricesMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 4).toString());
            ResultSet rs = Patient.getDataBN(tblListMedicineBill.getValueAt(selectedRow, 2).toString());
            ResultSet rs1 = Dr.getDataBS(tblListMedicineBill.getValueAt(selectedRow, 1).toString());
            ResultSet rs2 = med.getDataT(tblListMedicineBill.getValueAt(selectedRow, 3).toString());
            String TenBS = "";
            String TenBN = "";
            String Diachi = "";
            String Gioitinh = "";
            String NgaySinh = "";
            String BaoHiem = "";
            String LieuDung = "";
            try {
                while(rs.next())
                {
                    TenBN = rs.getString("TenBN");
                    Diachi = rs.getString("DiaChi");
                    Gioitinh = rs.getString("GT");
                    NgaySinh = rs.getString("NgaySinh");
                    BaoHiem = rs.getString("BaoHiem");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while(rs1.next())
                {
                    TenBS = rs1.getString("TenBS");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while(rs2.next())
                {
                    LieuDung = rs2.getString("LieuDung");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtDosageMedicineBill.setText(LieuDung);
            txtNameDoctorMedicineBill.setText(TenBS);
            txtNamePatientMedicineBill.setText(TenBN);
            txtAddressMedicineBill.setText(Diachi);
            txtGenderMedicineBill.setText(Gioitinh);
            txtBirthdayMedicineBill.setText(NgaySinh);
            txtHealthInsuranceMedicineBill.setText(BaoHiem);
            tblListMedicineBill.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectLastDT(){
        int selectedRow = tblListMedicineBill.getRowCount()- 1;
        showMedicinePrices(selectedRow);
        txtIDMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 0).toString());
        txtIDDoctorMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 1).toString());
        txtIDPatientMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 2).toString());
        txtIDMedicineMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 3).toString());
        //txtDosageMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 4).toString());
        txtTotalPricesMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow, 4).toString());
        ResultSet rs = Patient.getDataBN(tblListMedicineBill.getValueAt(selectedRow, 2).toString());
        ResultSet rs1 = Dr.getDataBS(tblListMedicineBill.getValueAt(selectedRow, 1).toString());
        ResultSet rs2 = med.getDataT(tblListMedicineBill.getValueAt(selectedRow, 3).toString());
        String TenBS = "";
        String TenBN = "";
        String Diachi = "";
        String Gioitinh = "";
        String NgaySinh = "";
        String BaoHiem = "";
        String LieuDung = "";
        try {
            while(rs.next())
            {
                TenBN = rs.getString("TenBN");
                Diachi = rs.getString("DiaChi");
                Gioitinh = rs.getString("GT");
                NgaySinh = rs.getString("NgaySinh");
                BaoHiem = rs.getString("BaoHiem");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs1.next())
            {
                TenBS = rs1.getString("TenBS");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs2.next())
            {
                LieuDung = rs2.getString("LieuDung");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtDosageMedicineBill.setText(LieuDung);
        txtNameDoctorMedicineBill.setText(TenBS);
        txtNamePatientMedicineBill.setText(TenBN);
        txtAddressMedicineBill.setText(Diachi);
        txtGenderMedicineBill.setText(Gioitinh);
        txtBirthdayMedicineBill.setText(NgaySinh);
        txtHealthInsuranceMedicineBill.setText(BaoHiem);
        tblListMedicineBill.setRowSelectionInterval(selectedRow, selectedRow);
    }
    //TOTAL BILL
    public void showTotalPrices(int selectedRow)
    {
        String[]stringSQL = {tblListTotalBill.getValueAt(selectedRow, 1).toString(),tblListTotalBill.getValueAt(selectedRow, 2).toString(),tblListTotalBill.getValueAt(selectedRow, 0).toString()};
        int isInsert = total.totalPrices(stringSQL);
        showDataHD();
    }
    public void getSelectFirstHD() {
        int selectedRow = 0;
        showTotalPrices(selectedRow);
        txtIDTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 0).toString());
        txtIDMedicineTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 1).toString());
        txtIDServiceTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 2).toString());
        txtIDPatientTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 3).toString());
        txtTotalPricesTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 4).toString());
        ResultSet rs = Patient.getDataBN(tblListTotalBill.getValueAt(selectedRow, 3).toString());
        String TenBN = "";
        String Diachi = "";
        String Gioitinh = "";
        String NgaySinh = "";
        String BaoHiem = "";
        try {
            while(rs.next())
            {
                TenBN = rs.getString("TenBN");
                Diachi = rs.getString("DiaChi");
                Gioitinh = rs.getString("GT");
                NgaySinh = rs.getString("NgaySinh");
                BaoHiem = rs.getString("BaoHiem");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNamePatientTotalBill.setText(TenBN);
        txtAddressTotalBill.setText(Diachi);
        txtGenderTotalBill.setText(Gioitinh);
        txtBirthdayTotalBill.setText(NgaySinh);
        txtHealthInsuranceTotalBill.setText(BaoHiem);
        tblListTotalBill.setRowSelectionInterval(0, 0);
    }
    public void getSelectPreviousHD(){
        if(tblListTotalBill.getSelectedRow() >= 1)
        {
            int selectedRow = tblListTotalBill.getSelectedRow() - 1;
            showTotalPrices(selectedRow);
            txtIDTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 0).toString());
            txtIDMedicineTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 1).toString());
            txtIDServiceTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 2).toString());
            txtIDPatientTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 3).toString());
            txtTotalPricesTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 4).toString());
            ResultSet rs = Patient.getDataBN(tblListTotalBill.getValueAt(selectedRow, 3).toString());
            String TenBN = "";
            String Diachi = "";
            String Gioitinh = "";
            String NgaySinh = "";
            String BaoHiem = "";
            try {
                while(rs.next())
                {
                    TenBN = rs.getString("TenBN");
                    Diachi = rs.getString("DiaChi");
                    Gioitinh = rs.getString("GT");
                    NgaySinh = rs.getString("NgaySinh");
                    BaoHiem = rs.getString("BaoHiem");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtNamePatientTotalBill.setText(TenBN);
            txtAddressTotalBill.setText(Diachi);
            txtGenderTotalBill.setText(Gioitinh);
            txtBirthdayTotalBill.setText(NgaySinh);
            txtHealthInsuranceTotalBill.setText(BaoHiem);
            tblListTotalBill.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectNextHD(){
        if(tblListTotalBill.getSelectedRow() < tblListTotalBill.getRowCount() - 1)
        {
            int selectedRow = tblListTotalBill.getSelectedRow() + 1;
            showTotalPrices(selectedRow);
            txtIDTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 0).toString());
            txtIDMedicineTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 1).toString());
            txtIDServiceTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 2).toString());
            txtIDPatientTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 3).toString());
            txtTotalPricesTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 4).toString());
            ResultSet rs = Patient.getDataBN(tblListTotalBill.getValueAt(selectedRow, 3).toString());
            String TenBN = "";
            String Diachi = "";
            String Gioitinh = "";
            String NgaySinh = "";
            String BaoHiem = "";
            try {
                while(rs.next())
                {
                    TenBN = rs.getString("TenBN");
                    Diachi = rs.getString("DiaChi");
                    Gioitinh = rs.getString("GT");
                    NgaySinh = rs.getString("NgaySinh");
                    BaoHiem = rs.getString("BaoHiem");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtNamePatientTotalBill.setText(TenBN);
            txtAddressTotalBill.setText(Diachi);
            txtGenderTotalBill.setText(Gioitinh);
            txtBirthdayTotalBill.setText(NgaySinh);
            txtHealthInsuranceTotalBill.setText(BaoHiem);
            tblListTotalBill.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectLastHD(){
        int selectedRow = tblListTotalBill.getRowCount()- 1;
        showTotalPrices(selectedRow);
        txtIDTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 0).toString());
        txtIDMedicineTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 1).toString());
        txtIDServiceTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 2).toString());
        txtIDPatientTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 3).toString());
        txtTotalPricesTotalBill.setText(tblListTotalBill.getValueAt(selectedRow, 4).toString());
        ResultSet rs = Patient.getDataBN(tblListTotalBill.getValueAt(selectedRow, 3).toString());
        String TenBN = "";
        String Diachi = "";
        String Gioitinh = "";
        String NgaySinh = "";
        String BaoHiem = "";
        try {
            while(rs.next())
            {
                TenBN = rs.getString("TenBN");
                Diachi = rs.getString("DiaChi");
                Gioitinh = rs.getString("GT");
                NgaySinh = rs.getString("NgaySinh");
                BaoHiem = rs.getString("BaoHiem");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNamePatientTotalBill.setText(TenBN);
        txtAddressTotalBill.setText(Diachi);
        txtGenderTotalBill.setText(Gioitinh);
        txtBirthdayTotalBill.setText(NgaySinh);
        txtHealthInsuranceTotalBill.setText(BaoHiem);
        tblListTotalBill.setRowSelectionInterval(selectedRow, selectedRow);
    }
    //------------------------------------------------------------//
    //---------------------------CHỨC NĂNG-----------------------//
    //----------------------------------------------------------//
    //DOCTOR
    public void InsertDataBS()
    {
        if(txtIDDoctor.getText().toString().equals("")||txtNameDoctor.getText().toString().equals("")||txtSpecialized.getText().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        }
        else
        {
            String[]stringSQL = {txtIDDoctor.getText().toString(),txtNameDoctor.getText().toString(),txtSpecialized.getText().toString()};
            int isInsert = Dr.Insert(stringSQL);

            if(isInsert > 0)
            {
                JOptionPane.showMessageDialog(this, "Bạn đã thêm dữ liệu thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Bạn chưa thêm thành công");
            }

            showDataBS();
            txtIDDoctor.setText("");
            txtNameDoctor.setText("");
            txtSpecialized.setText("");
        }
    }
    public void UpdateDataBS()
    {
        String[]stringSQL = {txtNameDoctor.getText().toString(),txtSpecialized.getText().toString(),txtIDDoctor.getText().toString()};
        int isUpdate = Dr.Update(stringSQL);

        if(isUpdate > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã sửa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa sửa thành công");
        }

        showDataBS();
        txtIDDoctor.setText("");
        txtNameDoctor.setText("");
        txtSpecialized.setText("");
    }
    public void DeleteDataBS()
    {
        String[]stringSQL = {txtIDDoctor.getText().toString()};
        int isDelete = Dr.Delete(stringSQL);

        if(isDelete > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã xóa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa xóa thành công");
        }

        showDataBS();
        txtIDDoctor.setText("");
        txtNameDoctor.setText("");
        txtSpecialized.setText("");
    }
    //Lấy thông tin dữ liệu được chọn
    public void getSelectedDataBS()
    {
        int selectedRow = tblListDoctor.getSelectedRow();

        txtIDDoctor.setText(tblListDoctor.getValueAt(selectedRow,0).toString());
        txtNameDoctor.setText(tblListDoctor.getValueAt(selectedRow,1).toString());
        txtSpecialized.setText(tblListDoctor.getValueAt(selectedRow,2).toString());
    }
    //PATIENT

    public void InsertDataBN()
    {
        if(txtIDPatient.getText().toString().equals("")||txtNamePatient.getText().toString().equals("")||txtGender.getText().toString().equals("")||txtAddress.getText().toString().equals("")||txtHealthInsurance.getText().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        }
        else if ((txtHealthInsurance.getText().equals("Có")||txtHealthInsurance.getText().equals("Không"))&&(txtGender.getText().equals("Nam")||txtGender.getText().equals("Nữ")))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String Date = sdf.format(ChooserBirthday.getDate());
            String[]stringSQL = {txtIDPatient.getText().toString(),txtNamePatient.getText().toString(),Date,txtGender.getText().toString(),txtAddress.getText().toString(),txtHealthInsurance.getText().toString()};
            int isInsert = Patient.Insert(stringSQL);

            if(isInsert > 0)
            {
                JOptionPane.showMessageDialog(this, "Bạn đã thêm dữ liệu thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Bạn chưa thêm thành công");
            }

            showDataBN();
            ClearTextBN();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Vui đúng nhập lại giới tính hoặc bảo hiểm");
        }
    }
    public void UpdateDataBN()
    {
        if(txtIDPatient.getText().toString().equals("")||txtNamePatient.getText().toString().equals("")||txtGender.getText().toString().equals("")||txtAddress.getText().toString().equals("")||txtHealthInsurance.getText().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        }
        else if ((txtHealthInsurance.getText().equals("Có")||txtHealthInsurance.getText().equals("Không"))&&(txtGender.getText().equals("Nam")||txtGender.getText().equals("Nữ")))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String Date = sdf.format(ChooserBirthday.getDate());
            String[]stringSQL = {txtNamePatient.getText().toString(),Date,txtGender.getText().toString(),txtAddress.getText().toString(),txtHealthInsurance.getText().toString(),txtIDPatient.getText().toString()};
            int isUpdate = Patient.Update(stringSQL);

            if(isUpdate > 0)
            {
                JOptionPane.showMessageDialog(this, "Bạn đã sửa dữ liệu thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Bạn chưa sửa thành công");
            }

            showDataBN();
            ClearTextBN();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Vui đúng nhập lại giới tính hoặc bảo hiểm");
        }

    }
    public void DeleteDataBN()
    {
        String[]stringSQL = {txtIDPatient.getText().toString()};
        int isDelete = Patient.Delete(stringSQL);

        if(isDelete > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã xóa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa xóa thành công");
        }

        showDataBN();
        ClearTextBN();
    }
    //Lấy thông tin dữ liệu được chọn
    public void getSelectedDataBN()
    {
        int selectedRow = tblListPatient.getSelectedRow();

        txtIDPatient.setText(tblListPatient.getValueAt(selectedRow,0).toString());
        txtNamePatient.setText(tblListPatient.getValueAt(selectedRow,1).toString());
        txtGender.setText(tblListPatient.getValueAt(selectedRow,3).toString());
        txtAddress.setText(tblListPatient.getValueAt(selectedRow,4).toString());
        txtHealthInsurance.setText(tblListPatient.getValueAt(selectedRow,5).toString());
    }
    //SERVICE
    public void InsertDataDV()
    {
        if(txtIDService.getText().toString().equals("")||txtNameService.getText().toString().equals("")||txtServicePrices.getText().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        }
        else
        {
            String[]stringSQL = {txtIDService.getText().toString(),txtNameService.getText().toString(),txtServicePrices.getText().toString()};
            int isInsert = ser.Insert(stringSQL);

            if(isInsert > 0)
            {
                JOptionPane.showMessageDialog(this, "Bạn đã thêm dữ liệu thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Bạn chưa thêm thành công");
            }

            showDataDV();
            ClearTextDV();
        }
    }
    public void UpdateDataDV()
    {
        String[]stringSQL = {txtNameService.getText().toString(),txtServicePrices.getText().toString(),txtIDService.getText().toString()};
        int isUpdate = ser.Update(stringSQL);

        if(isUpdate > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã sửa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa sửa thành công");
        }

        showDataDV();
        ClearTextDV();
    }
    public void DeleteDataDV()
    {
        String[]stringSQL = {txtIDService.getText().toString()};
        int isDelete = ser.Delete(stringSQL);

        if(isDelete > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã xóa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa xóa thành công");
        }

        showDataDV();
        ClearTextDV();
    }
    //Lấy thông tin dữ liệu được chọn
    public void getSelectedDataDV()
    {
        int selectedRow = tblListService.getSelectedRow();

        txtIDService.setText(tblListService.getValueAt(selectedRow,0).toString());
        txtNameService.setText(tblListService.getValueAt(selectedRow,1).toString());
        txtServicePrices.setText(tblListService.getValueAt(selectedRow,2).toString());
    }
    //MEDICINE
    public void InsertDataT()
    {
        if(txtIDMedicine.getText().toString().equals("")||txtNameMedicine.getText().toString().equals("")||txtDosage.getText().toString().equals("")||txtExpiryDate.getText().toString().equals("")||txtMedicinePrices.getText().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        }
        else
        {
            String[]stringSQL = {txtIDMedicine.getText().toString(),txtNameMedicine.getText().toString(),txtExpiryDate.getText().toString(),txtDosage.getText().toString(),txtMedicinePrices.getText().toString()};
            int isInsert = med.Insert(stringSQL);

            if(isInsert > 0)
            {
                JOptionPane.showMessageDialog(this, "Bạn đã thêm dữ liệu thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Bạn chưa thêm thành công");
            }

            showDataT();
            CLearTextT();
        }
    }
    public void UpdateDataT()
    {
        String[]stringSQL = {txtNameMedicine.getText().toString(),txtExpiryDate.getText().toString(),txtDosage.getText().toString(),txtMedicinePrices.getText().toString(),txtIDMedicine.getText().toString()};
        int isUpdate = med.Update(stringSQL);

        if(isUpdate > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã sửa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa sửa thành công");
        }

        showDataT();
        CLearTextT();
    }
    public void DeleteDataT()
    {
        String[]stringSQL = {txtIDMedicine.getText().toString()};
        int isDelete = med.Delete(stringSQL);

        if(isDelete > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã xóa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa xóa thành công");
        }

        showDataT();
        CLearTextT();
    }
    //Lấy thông tin dữ liệu được chọn
    public void getSelectedDataT()
    {
        int selectedRow = tblListMedicine.getSelectedRow();

        txtIDMedicine.setText(tblListMedicine.getValueAt(selectedRow,0).toString());
        txtNameMedicine.setText(tblListMedicine.getValueAt(selectedRow,1).toString());
        txtExpiryDate.setText(tblListMedicine.getValueAt(selectedRow,2).toString());
        txtMedicinePrices.setText(tblListMedicine.getValueAt(selectedRow,3).toString());
    }
    //SERVICEBILL
    public void InsertDataDDV()
    {
        String[]stringSQL = {txtIDServiceBill.getText().toString(),txtIDDoctorServiceBill.getText().toString(),txtIDPatientServiceBill.getText().toString(),txtIDServiceServiceBill.getText().toString(),txtServiceBillPrices.getText().toString()};
        int isInsert = serBill.Insert(stringSQL);

        if(isInsert > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã thêm dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa thêm thành công");
        }
        showDataDDV();
        ClearTextDDV();
    }
    public void UpdateDataDDV()
    {
        String[]stringSQL = {txtIDDoctorServiceBill.getText().toString(),txtIDPatientServiceBill.getText().toString(),txtIDServiceServiceBill.getText().toString(),txtServiceBillPrices.getText().toString(),txtIDServiceBill.getText().toString()};
        int isUpdate = serBill.Update(stringSQL);

        if(isUpdate > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã sửa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa sửa thành công");
        }
        showDataDDV();
        ClearTextDDV();
    }
    public void DeleteDataDDV()
    {
        String[]stringSQL = {txtIDServiceBill.getText().toString()};
        int isDelete = serBill.Delete(stringSQL);

        if(isDelete > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã xóa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa xóa thành công");
        }

        showDataDDV();
        ClearTextDDV();
    }
    //Lấy thông tin dữ liệu được chọn
    public void getSelectedDataDDV()
    {
        int selectedRow = tblListServiceBill.getSelectedRow();

        txtIDServiceBill.setText(tblListServiceBill.getValueAt(selectedRow,0).toString());
        txtIDPatientServiceBill.setText(tblListServiceBill.getValueAt(selectedRow,1).toString());
        txtAddressServiceBill.setText(tblListServiceBill.getValueAt(selectedRow,2).toString());
        txtGenderServiceBill.setText(tblListServiceBill.getValueAt(selectedRow,3).toString());
        txtNamePatientServiceBill.setText(tblListServiceBill.getValueAt(selectedRow,4).toString());
        txtBirthdayrServiceBill.setText(tblListServiceBill.getValueAt(selectedRow,5).toString());
        txtHealthInsuranceServiceBill.setText(tblListServiceBill.getValueAt(selectedRow,6).toString());
        txtNameDoctorServiceBill.setText(tblListServiceBill.getValueAt(selectedRow,7).toString());
        txtIDDoctorServiceBill.setText(tblListServiceBill.getValueAt(selectedRow,8).toString());
        txtIDServiceServiceBill.setText(tblListServiceBill.getValueAt(selectedRow,9).toString());
        txtServiceBillPrices.setText(tblListServiceBill.getValueAt(selectedRow,10).toString());

    }

    //MEDICINE BILL
    public void InsertDataDT()
    {
        String[]stringSQL = {txtIDMedicineBill.getText().toString(),txtIDDoctorMedicineBill.getText().toString(),txtIDPatientMedicineBill.getText().toString(),txtIDMedicineMedicineBill.getText().toString(),txtTotalPricesMedicineBill.getText().toString()};
        int isInsert = medBill.Insert(stringSQL);

        if(isInsert > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã thêm dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa thêm thành công");
        }

        showDataDT();
        ClearTextDT();
    }
    public void UpdateDataDT()
    {
        String[]stringSQL = {txtIDDoctorMedicineBill.getText().toString(),txtIDPatientMedicineBill.getText().toString(),txtIDMedicineMedicineBill.getText().toString(),txtTotalPricesMedicineBill.getText().toString(),txtIDMedicineBill.getText().toString()};
        int isUpdate = medBill.Update(stringSQL);

        if(isUpdate > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã sửa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa sửa thành công");
        }

        showDataDT();
        ClearTextDT();
    }
    public void DeleteDataDT()
    {
        String[]stringSQL = {txtIDMedicineBill.getText().toString()};
        int isDelete = medBill.Delete(stringSQL);

        if(isDelete > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã xóa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa xóa thành công");
        }

        showDataDT();
        ClearTextDT();
    }
    //Lấy thông tin dữ liệu được chọn
    public void getSelectedDataDT()
    {
        int selectedRow = tblListMedicineBill.getSelectedRow();

        txtIDMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,0).toString());
        txtIDPatientMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,1).toString());
        txtNamePatientMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,2).toString());
        txtAddressMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,3).toString());
        txtGenderMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,4).toString());
        txtBirthdayMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,5).toString());
        txtHealthInsuranceMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,6).toString());
        txtIDDoctorMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,7).toString());
        txtNameDoctorMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,8).toString());
        txtIDMedicineMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,9).toString());
        txtDosageMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,10).toString());
        txtTotalPricesMedicineBill.setText(tblListMedicineBill.getValueAt(selectedRow,11).toString());

    }
    //TOTAL BILL
    public void InsertDataHD()
    {
        String[]stringSQL = {txtIDTotalBill.getText().toString(),txtIDMedicineTotalBill.getText().toString(),txtIDServiceTotalBill.getText().toString(),txtIDPatientTotalBill.getText().toString(),txtTotalPricesTotalBill.getText().toString()};
        int isInsert = total.Insert(stringSQL);

        if(isInsert > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã thêm dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa thêm thành công");
        }

        showDataHD();
        ClearTextHD();
    }
    public void UpdateDataHD()
    {
        String[]stringSQL = {txtIDMedicineTotalBill.getText().toString(),txtIDServiceTotalBill.getText().toString(),txtIDPatientTotalBill.getText().toString(),txtTotalPricesTotalBill.getText().toString(),txtIDTotalBill.getText().toString()};
        int isUpdate = total.Update(stringSQL);

        if(isUpdate > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã sửa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa sửa thành công");
        }

        showDataHD();
        ClearTextHD();
    }
    public void DeleteDataHD()
    {
        String[]stringSQL = {txtIDTotalBill.getText().toString()};
        int isDelete = total.Delete(stringSQL);

        if(isDelete > 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn đã xóa dữ liệu thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa xóa thành công");
        }

        showDataHD();
        ClearTextHD();
    }
    //Lấy thông tin dữ liệu được chọn
    public void getSelectedDataHD()
    {
        int selectedRow = tblListTotalBill.getSelectedRow();

        txtIDTotalBill.setText(tblListTotalBill.getValueAt(selectedRow,0).toString());
        txtIDPatientTotalBill.setText(tblListTotalBill.getValueAt(selectedRow,1).toString());
        txtNamePatientTotalBill.setText(tblListTotalBill.getValueAt(selectedRow,2).toString());
        txtAddressTotalBill.setText(tblListTotalBill.getValueAt(selectedRow,3).toString());
        txtGenderTotalBill.setText(tblListTotalBill.getValueAt(selectedRow,4).toString());
        txtBirthdayTotalBill.setText(tblListTotalBill.getValueAt(selectedRow,5).toString());
        txtHealthInsuranceTotalBill.setText(tblListTotalBill.getValueAt(selectedRow,6).toString());
        txtIDMedicineTotalBill.setText(tblListTotalBill.getValueAt(selectedRow,7).toString());
        txtIDServiceTotalBill.setText(tblListTotalBill.getValueAt(selectedRow,8).toString());
        txtTotalPricesTotalBill.setText(tblListTotalBill.getValueAt(selectedRow,9).toString());

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        bar = new javax.swing.JPanel();
        barTotalBill = new javax.swing.JPanel();
        bar7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        barDoctor = new javax.swing.JPanel();
        bar1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        barPatient = new javax.swing.JPanel();
        bar2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        barService = new javax.swing.JPanel();
        bar3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        barMedicine = new javax.swing.JPanel();
        bar4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        barServiceBill = new javax.swing.JPanel();
        bar5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        barMedicineBill = new javax.swing.JPanel();
        bar6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        barAbout = new javax.swing.JPanel();
        bar8 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDDoctor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtSpecialized = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtNameDoctor = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListDoctor = new javax.swing.JTable();
        jLabel102 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnInsertDoctor = new javax.swing.JLabel();
        btnUpdateDoctor = new javax.swing.JLabel();
        btnDeleteDoctor = new javax.swing.JLabel();
        btnSaveDoctor = new javax.swing.JLabel();
        btnCancelDoctor = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel18 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txtIDPatient = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtAddress = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtNamePatient = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListPatient = new javax.swing.JTable();
        ChooserBirthday = new com.toedter.calendar.JDateChooser();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtHealthInsurance = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnInsertPatient = new javax.swing.JLabel();
        btnUpdatePatient = new javax.swing.JLabel();
        btnDeletePatient = new javax.swing.JLabel();
        btnSavePatient = new javax.swing.JLabel();
        btnCancelPatient = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        txtIDService = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        txtServicePrices = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        txtNameService = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblListService = new javax.swing.JTable();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnInsertService = new javax.swing.JLabel();
        btnUpdateService = new javax.swing.JLabel();
        btnDeleteService = new javax.swing.JLabel();
        btnSaveService = new javax.swing.JLabel();
        btnCancelService = new javax.swing.JLabel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        txtIDMedicine = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        txtExpiryDate = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        txtNameMedicine = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblListMedicine = new javax.swing.JTable();
        txtMedicinePrices = new javax.swing.JTextField();
        jSeparator21 = new javax.swing.JSeparator();
        jLabel59 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        txtDosage = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jSeparator51 = new javax.swing.JSeparator();
        jPanel14 = new javax.swing.JPanel();
        btnInsertMedicine = new javax.swing.JLabel();
        btnUpdateMedicine = new javax.swing.JLabel();
        btnDeleteMedicine = new javax.swing.JLabel();
        btnSaveMedicine = new javax.swing.JLabel();
        btnCancelMedicine = new javax.swing.JLabel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txtIDServiceBill = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        txtNamePatientServiceBill = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        txtIDPatientServiceBill = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListServiceBill = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtAddressServiceBill = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        txtGenderServiceBill = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        txtBirthdayrServiceBill = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        txtHealthInsuranceServiceBill = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel64 = new javax.swing.JLabel();
        txtNameDoctorServiceBill = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        txtIDServiceServiceBill = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        txtServiceBillPrices = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        txtIDDoctorServiceBill = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jSeparator49 = new javax.swing.JSeparator();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnInsertServiceBill = new javax.swing.JLabel();
        btnUpdateServiceBill = new javax.swing.JLabel();
        btnDeleteServiceBill = new javax.swing.JLabel();
        btnSaveServiceBill = new javax.swing.JLabel();
        btnCancelServiceBill = new javax.swing.JLabel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        txtIDMedicineBill = new javax.swing.JTextField();
        jSeparator28 = new javax.swing.JSeparator();
        txtNamePatientMedicineBill = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jSeparator29 = new javax.swing.JSeparator();
        txtIDPatientMedicineBill = new javax.swing.JTextField();
        jSeparator30 = new javax.swing.JSeparator();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblListMedicineBill = new javax.swing.JTable();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtAddressMedicineBill = new javax.swing.JTextField();
        jSeparator31 = new javax.swing.JSeparator();
        txtGenderMedicineBill = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jSeparator32 = new javax.swing.JSeparator();
        txtBirthdayMedicineBill = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jSeparator33 = new javax.swing.JSeparator();
        txtHealthInsuranceMedicineBill = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jSeparator34 = new javax.swing.JSeparator();
        jLabel79 = new javax.swing.JLabel();
        txtNameDoctorMedicineBill = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jSeparator35 = new javax.swing.JSeparator();
        txtDosageMedicineBill = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jSeparator36 = new javax.swing.JSeparator();
        txtTotalPricesMedicineBill = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jSeparator37 = new javax.swing.JSeparator();
        txtIDMedicineMedicineBill = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jSeparator38 = new javax.swing.JSeparator();
        txtIDDoctorMedicineBill = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jSeparator50 = new javax.swing.JSeparator();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        btnInsertMedicineBill = new javax.swing.JLabel();
        btnUpdateMedicineBill = new javax.swing.JLabel();
        btnDeleteMedicineBill = new javax.swing.JLabel();
        btnSaveMedicineBill = new javax.swing.JLabel();
        btnCancelMedicineBill = new javax.swing.JLabel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jInternalFrame7 = new javax.swing.JInternalFrame();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        txtIDTotalBill = new javax.swing.JTextField();
        jSeparator39 = new javax.swing.JSeparator();
        txtNamePatientTotalBill = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jSeparator40 = new javax.swing.JSeparator();
        txtIDPatientTotalBill = new javax.swing.JTextField();
        jSeparator41 = new javax.swing.JSeparator();
        jLabel89 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblListTotalBill = new javax.swing.JTable();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        txtAddressTotalBill = new javax.swing.JTextField();
        jSeparator42 = new javax.swing.JSeparator();
        txtGenderTotalBill = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jSeparator43 = new javax.swing.JSeparator();
        txtBirthdayTotalBill = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jSeparator44 = new javax.swing.JSeparator();
        txtHealthInsuranceTotalBill = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jSeparator45 = new javax.swing.JSeparator();
        jLabel95 = new javax.swing.JLabel();
        txtIDServiceTotalBill = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        jSeparator46 = new javax.swing.JSeparator();
        txtTotalPricesTotalBill = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jSeparator47 = new javax.swing.JSeparator();
        txtIDMedicineTotalBill = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jSeparator48 = new javax.swing.JSeparator();
        jLabel101 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        btnInsertTotalBill = new javax.swing.JLabel();
        btnUpdateTotalBill = new javax.swing.JLabel();
        btnDeleteTotalBill = new javax.swing.JLabel();
        btnSaveTotalBill = new javax.swing.JLabel();
        btnCancelTotalBill = new javax.swing.JLabel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        jInternalFrame8 = new javax.swing.JInternalFrame();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtFullname = new javax.swing.JTextField();
        txtAboutAddress = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        kGradientPanel1.setkEndColor(new java.awt.Color(196, 219, 246));
        kGradientPanel1.setkStartColor(new java.awt.Color(59, 139, 235));
        kGradientPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel1MouseDragged(evt);
            }
        });
        kGradientPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel1MousePressed(evt);
            }
        });
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bar.setBackground(new java.awt.Color(36, 48, 94));
        bar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barTotalBill.setBackground(new java.awt.Color(36, 48, 94));
        barTotalBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barTotalBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barTotalBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barTotalBillMouseExited(evt);
            }
        });
        barTotalBill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bar7.setBackground(new java.awt.Color(247, 108, 108));
        barTotalBill.add(bar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Total Bill");
        barTotalBill.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel11.setBackground(new java.awt.Color(36, 48, 94));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(247, 108, 108));
        jLabel12.setOpaque(true);
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Service Bill");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        barTotalBill.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 180, 50));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-stack-of-money-40.png"))); // NOI18N
        barTotalBill.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        bar.add(barTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 180, 50));

        barDoctor.setBackground(new java.awt.Color(36, 48, 94));
        barDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        barDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barDoctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barDoctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barDoctorMouseExited(evt);
            }
        });
        barDoctor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bar1.setBackground(new java.awt.Color(247, 108, 108));
        barDoctor.add(bar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Doctor");
        barDoctor.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Doctor");
        barDoctor.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-surgeon-skin-type-1-40.png"))); // NOI18N
        barDoctor.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        bar.add(barDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 50));

        barPatient.setBackground(new java.awt.Color(36, 48, 94));
        barPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barPatientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barPatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barPatientMouseExited(evt);
            }
        });
        barPatient.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bar2.setBackground(new java.awt.Color(247, 108, 108));
        barPatient.add(bar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Patient");
        barPatient.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cast-40.png"))); // NOI18N
        barPatient.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        bar.add(barPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 180, 50));

        barService.setBackground(new java.awt.Color(36, 48, 94));
        barService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barServiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barServiceMouseExited(evt);
            }
        });
        barService.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bar3.setBackground(new java.awt.Color(247, 108, 108));
        barService.add(bar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Service");
        barService.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-doctors-bag-40.png"))); // NOI18N
        barService.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        bar.add(barService, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 180, 50));

        barMedicine.setBackground(new java.awt.Color(36, 48, 94));
        barMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barMedicineMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barMedicineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barMedicineMouseExited(evt);
            }
        });
        barMedicine.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bar4.setBackground(new java.awt.Color(247, 108, 108));
        barMedicine.add(bar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Medicine");
        barMedicine.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-pill-40.png"))); // NOI18N
        barMedicine.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        bar.add(barMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 180, 50));

        barServiceBill.setBackground(new java.awt.Color(36, 48, 94));
        barServiceBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barServiceBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barServiceBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barServiceBillMouseExited(evt);
            }
        });
        barServiceBill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bar5.setBackground(new java.awt.Color(247, 108, 108));
        barServiceBill.add(bar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Service Bill");
        barServiceBill.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel13.setBackground(new java.awt.Color(36, 48, 94));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(247, 108, 108));
        jLabel16.setOpaque(true);
        jPanel13.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Service Bill");
        jPanel13.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        barServiceBill.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 180, 50));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-bill-40.png"))); // NOI18N
        barServiceBill.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        bar.add(barServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 180, 50));

        barMedicineBill.setBackground(new java.awt.Color(36, 48, 94));
        barMedicineBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barMedicineBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barMedicineBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barMedicineBillMouseExited(evt);
            }
        });
        barMedicineBill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bar6.setBackground(new java.awt.Color(247, 108, 108));
        barMedicineBill.add(bar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Medicine Bill");
        barMedicineBill.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel15.setBackground(new java.awt.Color(36, 48, 94));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(247, 108, 108));
        jLabel20.setOpaque(true);
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("Service Bill");
        jPanel15.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        barMedicineBill.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 180, 50));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-hand-with-a-pill-40.png"))); // NOI18N
        barMedicineBill.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        bar.add(barMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 180, 50));

        barAbout.setBackground(new java.awt.Color(36, 48, 94));
        barAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barAboutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barAboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barAboutMouseExited(evt);
            }
        });
        barAbout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bar8.setBackground(new java.awt.Color(247, 108, 108));
        barAbout.add(bar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(204, 204, 204));
        jLabel36.setText("About");
        barAbout.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel20.setBackground(new java.awt.Color(36, 48, 94));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel130.setBackground(new java.awt.Color(247, 108, 108));
        jLabel130.setOpaque(true);
        jPanel20.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(204, 204, 204));
        jLabel131.setText("Service Bill");
        jPanel20.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        barAbout.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 180, 50));

        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-about-40.png"))); // NOI18N
        barAbout.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        bar.add(barAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 180, 50));

        kGradientPanel1.add(bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 550));

        jPanel1.setBackground(new java.awt.Color(196, 219, 246));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-minimize-window-15.png"))); // NOI18N
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 8, -1, -1));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cancel-15.png"))); // NOI18N
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 8, -1, -1));

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 30));

        jInternalFrame1.setBorder(null);
        jInternalFrame1.setOpaque(true);
        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Information");
        jInternalFrame1.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("List");
        jInternalFrame1.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Function");
        jInternalFrame1.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 50, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID :");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 50, -1, -1));

        txtIDDoctor.setBorder(null);
        jPanel3.add(txtIDDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 50, 155, -1));

        jSeparator1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 55, 150, 10));

        txtSpecialized.setBorder(null);
        txtSpecialized.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSpecializedActionPerformed(evt);
            }
        });
        jPanel3.add(txtSpecialized, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 90, 155, -1));

        jLabel2.setText("Specialized :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, -1, -1));

        jSeparator2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 95, 150, 10));

        txtNameDoctor.setBorder(null);
        jPanel3.add(txtNameDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 50, 155, -1));

        jSeparator3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 55, 150, 10));

        jLabel3.setText("Name :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        tblListDoctor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListDoctor);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 150, 450, 220));

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-fast-forward-20.png"))); // NOI18N
        jLabel102.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-rewind-20.png"))); // NOI18N
        jLabel106.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel106MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 380, -1, -1));

        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-left-15.png"))); // NOI18N
        jLabel107.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel107MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 382, -1, -1));

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-right-15.png"))); // NOI18N
        jLabel108.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel108MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 382, -1, -1));

        jInternalFrame1.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 500, 420));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsertDoctor.setBackground(new java.awt.Color(247, 158, 2));
        btnInsertDoctor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInsertDoctor.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertDoctor.setText("     INSERT");
        btnInsertDoctor.setToolTipText("");
        btnInsertDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertDoctor.setOpaque(true);
        btnInsertDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertDoctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertDoctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertDoctorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnInsertDoctorMousePressed(evt);
            }
        });
        jPanel4.add(btnInsertDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));

        btnUpdateDoctor.setBackground(new java.awt.Color(247, 158, 2));
        btnUpdateDoctor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateDoctor.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateDoctor.setText("    UPDATE");
        btnUpdateDoctor.setToolTipText("");
        btnUpdateDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateDoctor.setOpaque(true);
        btnUpdateDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateDoctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateDoctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateDoctorMouseExited(evt);
            }
        });
        jPanel4.add(btnUpdateDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, 30));

        btnDeleteDoctor.setBackground(new java.awt.Color(247, 158, 2));
        btnDeleteDoctor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteDoctor.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteDoctor.setText("    DELETE");
        btnDeleteDoctor.setToolTipText("");
        btnDeleteDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteDoctor.setOpaque(true);
        btnDeleteDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteDoctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteDoctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteDoctorMouseExited(evt);
            }
        });
        jPanel4.add(btnDeleteDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 30));

        btnSaveDoctor.setBackground(new java.awt.Color(247, 158, 2));
        btnSaveDoctor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSaveDoctor.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveDoctor.setText("      SAVE");
        btnSaveDoctor.setToolTipText("");
        btnSaveDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveDoctor.setOpaque(true);
        btnSaveDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveDoctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveDoctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveDoctorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSaveDoctorMousePressed(evt);
            }
        });
        jPanel4.add(btnSaveDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 30));

        btnCancelDoctor.setBackground(new java.awt.Color(247, 158, 2));
        btnCancelDoctor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelDoctor.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelDoctor.setText("     CANCEL");
        btnCancelDoctor.setToolTipText("");
        btnCancelDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelDoctor.setOpaque(true);
        btnCancelDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelDoctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelDoctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelDoctorMouseExited(evt);
            }
        });
        jPanel4.add(btnCancelDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 30));

        jInternalFrame1.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 140, 420));

        kGradientPanel2.setkEndColor(new java.awt.Color(196, 219, 246));
        kGradientPanel2.setkStartColor(new java.awt.Color(59, 138, 235));

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
                kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 730, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
                kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 550, Short.MAX_VALUE)
        );

        jInternalFrame1.getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 550));

        kGradientPanel1.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -20, 740, 580));

        jInternalFrame2.setBorder(null);
        jInternalFrame2.setOpaque(true);
        jInternalFrame2.setVisible(true);
        jInternalFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Information");
        jInternalFrame2.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 50, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("List");
        jInternalFrame2.getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Function");
        jInternalFrame2.getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 50, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setText("ID :");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 50, -1, -1));

        txtIDPatient.setBorder(null);
        jPanel5.add(txtIDPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 50, 155, -1));

        jSeparator4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 55, 150, 10));

        txtAddress.setBorder(null);
        jPanel5.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 155, -1));

        jLabel34.setText("Address :");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, -1, -1));

        jSeparator5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 95, 150, 10));

        txtNamePatient.setBorder(null);
        jPanel5.add(txtNamePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 50, 155, -1));

        jSeparator6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 55, 150, 10));

        jLabel35.setText("Name :");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        tblListPatient.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblListPatient);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 250, 450, 120));

        ChooserBirthday.setDateFormatString("yyyy-MM-dd");
        jPanel5.add(ChooserBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 130, 155, -1));

        jSeparator8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 135, 150, 10));

        jLabel37.setText("Birthday :");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 130, -1, -1));

        jLabel38.setText("Health Insurance :");
        jPanel5.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        txtHealthInsurance.setBorder(null);
        jPanel5.add(txtHealthInsurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 130, 155, -1));

        jSeparator9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 135, 150, 10));

        jLabel39.setText("Gender :");
        jPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        txtGender.setBorder(null);
        jPanel5.add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 90, 155, -1));

        jSeparator10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 95, 150, 10));

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-right-15.png"))); // NOI18N
        jLabel109.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel109MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 382, -1, -1));

        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-fast-forward-20.png"))); // NOI18N
        jLabel110.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel110.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel110MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-rewind-20.png"))); // NOI18N
        jLabel111.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel111MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 380, -1, -1));

        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-left-15.png"))); // NOI18N
        jLabel112.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel112.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel112MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 382, -1, -1));

        jInternalFrame2.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 500, 420));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsertPatient.setBackground(new java.awt.Color(247, 158, 2));
        btnInsertPatient.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInsertPatient.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertPatient.setText("     INSERT");
        btnInsertPatient.setToolTipText("");
        btnInsertPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertPatient.setOpaque(true);
        btnInsertPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertPatientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertPatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertPatientMouseExited(evt);
            }
        });
        jPanel6.add(btnInsertPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));

        btnUpdatePatient.setBackground(new java.awt.Color(247, 158, 2));
        btnUpdatePatient.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdatePatient.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdatePatient.setText("    UPDATE");
        btnUpdatePatient.setToolTipText("");
        btnUpdatePatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdatePatient.setOpaque(true);
        btnUpdatePatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdatePatientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdatePatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdatePatientMouseExited(evt);
            }
        });
        jPanel6.add(btnUpdatePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, 30));

        btnDeletePatient.setBackground(new java.awt.Color(247, 158, 2));
        btnDeletePatient.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeletePatient.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletePatient.setText("    DELETE");
        btnDeletePatient.setToolTipText("");
        btnDeletePatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletePatient.setOpaque(true);
        btnDeletePatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeletePatientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeletePatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeletePatientMouseExited(evt);
            }
        });
        jPanel6.add(btnDeletePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 30));

        btnSavePatient.setBackground(new java.awt.Color(247, 158, 2));
        btnSavePatient.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSavePatient.setForeground(new java.awt.Color(255, 255, 255));
        btnSavePatient.setText("      SAVE");
        btnSavePatient.setToolTipText("");
        btnSavePatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSavePatient.setOpaque(true);
        btnSavePatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSavePatientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSavePatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSavePatientMouseExited(evt);
            }
        });
        jPanel6.add(btnSavePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 30));

        btnCancelPatient.setBackground(new java.awt.Color(247, 158, 2));
        btnCancelPatient.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelPatient.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelPatient.setText("     CANCEL");
        btnCancelPatient.setToolTipText("");
        btnCancelPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelPatient.setOpaque(true);
        btnCancelPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelPatientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelPatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelPatientMouseExited(evt);
            }
        });
        jPanel6.add(btnCancelPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 30));

        jInternalFrame2.getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 140, 420));

        kGradientPanel3.setkEndColor(new java.awt.Color(196, 219, 246));
        kGradientPanel3.setkStartColor(new java.awt.Color(59, 138, 235));

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
                kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 730, Short.MAX_VALUE)
        );
        kGradientPanel3Layout.setVerticalGroup(
                kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 550, Short.MAX_VALUE)
        );

        jInternalFrame2.getContentPane().add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 550));

        kGradientPanel1.add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -20, 740, 580));

        jInternalFrame3.setBorder(null);
        jInternalFrame3.setOpaque(true);
        jInternalFrame3.setVisible(true);
        jInternalFrame3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("Information");
        jInternalFrame3.getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 50, -1, -1));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("List");
        jInternalFrame3.getContentPane().add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("Function");
        jInternalFrame3.getContentPane().add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 50, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setText("ID :");
        jPanel9.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 50, -1, -1));

        txtIDService.setBorder(null);
        jPanel9.add(txtIDService, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 50, 155, -1));

        jSeparator14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel9.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 55, 150, 10));

        txtServicePrices.setBorder(null);
        jPanel9.add(txtServicePrices, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 155, -1));

        jLabel50.setText("Service prices :");
        jPanel9.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, -1, -1));

        jSeparator15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel9.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 95, 150, 10));

        txtNameService.setBorder(null);
        jPanel9.add(txtNameService, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 50, 155, -1));

        jSeparator16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel9.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 55, 150, 10));

        jLabel51.setText("Name :");
        jPanel9.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        tblListService.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblListService);

        jPanel9.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 150, 450, 200));

        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-right-15.png"))); // NOI18N
        jLabel113.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel113.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel113MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 382, -1, -1));

        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-fast-forward-20.png"))); // NOI18N
        jLabel114.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel114.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel114MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-rewind-20.png"))); // NOI18N
        jLabel115.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel115MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 380, -1, -1));

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-left-15.png"))); // NOI18N
        jLabel116.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel116.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel116MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 382, -1, -1));

        jInternalFrame3.getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 500, 420));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsertService.setBackground(new java.awt.Color(247, 158, 2));
        btnInsertService.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInsertService.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertService.setText("     INSERT");
        btnInsertService.setToolTipText("");
        btnInsertService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertService.setOpaque(true);
        btnInsertService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertServiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertServiceMouseExited(evt);
            }
        });
        jPanel10.add(btnInsertService, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));

        btnUpdateService.setBackground(new java.awt.Color(247, 158, 2));
        btnUpdateService.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateService.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateService.setText("    UPDATE");
        btnUpdateService.setToolTipText("");
        btnUpdateService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateService.setOpaque(true);
        btnUpdateService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateServiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateServiceMouseExited(evt);
            }
        });
        jPanel10.add(btnUpdateService, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, 30));

        btnDeleteService.setBackground(new java.awt.Color(247, 158, 2));
        btnDeleteService.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteService.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteService.setText("    DELETE");
        btnDeleteService.setToolTipText("");
        btnDeleteService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteService.setOpaque(true);
        btnDeleteService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteServiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteServiceMouseExited(evt);
            }
        });
        jPanel10.add(btnDeleteService, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 30));

        btnSaveService.setBackground(new java.awt.Color(247, 158, 2));
        btnSaveService.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSaveService.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveService.setText("      SAVE");
        btnSaveService.setToolTipText("");
        btnSaveService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveService.setOpaque(true);
        btnSaveService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveServiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveServiceMouseExited(evt);
            }
        });
        jPanel10.add(btnSaveService, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 30));

        btnCancelService.setBackground(new java.awt.Color(247, 158, 2));
        btnCancelService.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelService.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelService.setText("     CANCEL");
        btnCancelService.setToolTipText("");
        btnCancelService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelService.setOpaque(true);
        btnCancelService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelServiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelServiceMouseExited(evt);
            }
        });
        jPanel10.add(btnCancelService, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 30));

        jInternalFrame3.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 140, 420));

        kGradientPanel5.setkEndColor(new java.awt.Color(196, 219, 246));
        kGradientPanel5.setkStartColor(new java.awt.Color(59, 138, 235));

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
                kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 730, Short.MAX_VALUE)
        );
        kGradientPanel5Layout.setVerticalGroup(
                kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 550, Short.MAX_VALUE)
        );

        jInternalFrame3.getContentPane().add(kGradientPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 550));

        kGradientPanel1.add(jInternalFrame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -20, 740, 580));

        jInternalFrame4.setBorder(null);
        jInternalFrame4.setOpaque(true);
        jInternalFrame4.setVisible(true);
        jInternalFrame4.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setText("Information");
        jInternalFrame4.getContentPane().add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 50, -1, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setText("List");
        jInternalFrame4.getContentPane().add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setText("Function");
        jInternalFrame4.getContentPane().add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 50, -1, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setText("ID :");
        jPanel12.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 50, -1, -1));

        txtIDMedicine.setBorder(null);
        jPanel12.add(txtIDMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 50, 155, -1));

        jSeparator18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel12.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 55, 150, 10));

        txtExpiryDate.setBorder(null);
        jPanel12.add(txtExpiryDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 90, 155, -1));

        jLabel57.setText("Expiry date :");
        jPanel12.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, -1, -1));

        jSeparator19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel12.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 95, 150, 10));

        txtNameMedicine.setBorder(null);
        jPanel12.add(txtNameMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 50, 155, -1));

        jSeparator20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel12.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 55, 150, 10));

        jLabel58.setText("Name :");
        jPanel12.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 50, -1, -1));

        tblListMedicine.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblListMedicine);

        jPanel12.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 200, 450, 150));

        txtMedicinePrices.setBorder(null);
        jPanel12.add(txtMedicinePrices, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 130, 155, -1));

        jSeparator21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel12.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 135, 150, 10));

        jLabel59.setText("Medicine Prices :");
        jPanel12.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 130, -1, -1));

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-right-15.png"))); // NOI18N
        jLabel117.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel117.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel117MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 382, -1, -1));

        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-fast-forward-20.png"))); // NOI18N
        jLabel118.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel118.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel118MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-rewind-20.png"))); // NOI18N
        jLabel119.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel119.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel119MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 380, -1, -1));

        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-left-15.png"))); // NOI18N
        jLabel120.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel120MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 382, -1, -1));

        txtDosage.setBorder(null);
        jPanel12.add(txtDosage, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 90, 155, -1));

        jLabel129.setText("Dosage :");
        jPanel12.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        jSeparator51.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel12.add(jSeparator51, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 95, 150, 10));

        jInternalFrame4.getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 500, 420));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsertMedicine.setBackground(new java.awt.Color(247, 158, 2));
        btnInsertMedicine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInsertMedicine.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertMedicine.setText("     INSERT");
        btnInsertMedicine.setToolTipText("");
        btnInsertMedicine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertMedicine.setOpaque(true);
        btnInsertMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertMedicineMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertMedicineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertMedicineMouseExited(evt);
            }
        });
        jPanel14.add(btnInsertMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));

        btnUpdateMedicine.setBackground(new java.awt.Color(247, 158, 2));
        btnUpdateMedicine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateMedicine.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateMedicine.setText("    UPDATE");
        btnUpdateMedicine.setToolTipText("");
        btnUpdateMedicine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateMedicine.setOpaque(true);
        btnUpdateMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMedicineMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMedicineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMedicineMouseExited(evt);
            }
        });
        jPanel14.add(btnUpdateMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, 30));

        btnDeleteMedicine.setBackground(new java.awt.Color(247, 158, 2));
        btnDeleteMedicine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteMedicine.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteMedicine.setText("    DELETE");
        btnDeleteMedicine.setToolTipText("");
        btnDeleteMedicine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteMedicine.setOpaque(true);
        btnDeleteMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMedicineMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMedicineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMedicineMouseExited(evt);
            }
        });
        jPanel14.add(btnDeleteMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 30));

        btnSaveMedicine.setBackground(new java.awt.Color(247, 158, 2));
        btnSaveMedicine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSaveMedicine.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveMedicine.setText("      SAVE");
        btnSaveMedicine.setToolTipText("");
        btnSaveMedicine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveMedicine.setOpaque(true);
        btnSaveMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMedicineMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMedicineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMedicineMouseExited(evt);
            }
        });
        jPanel14.add(btnSaveMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 30));

        btnCancelMedicine.setBackground(new java.awt.Color(247, 158, 2));
        btnCancelMedicine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelMedicine.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelMedicine.setText("     CANCEL");
        btnCancelMedicine.setToolTipText("");
        btnCancelMedicine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelMedicine.setOpaque(true);
        btnCancelMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMedicineMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMedicineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMedicineMouseExited(evt);
            }
        });
        jPanel14.add(btnCancelMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 30));

        jInternalFrame4.getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 140, 420));

        kGradientPanel6.setkEndColor(new java.awt.Color(196, 219, 246));
        kGradientPanel6.setkStartColor(new java.awt.Color(59, 138, 235));

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
                kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 730, Short.MAX_VALUE)
        );
        kGradientPanel6Layout.setVerticalGroup(
                kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 550, Short.MAX_VALUE)
        );

        jInternalFrame4.getContentPane().add(kGradientPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 550));

        kGradientPanel1.add(jInternalFrame4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -20, 740, 580));

        jInternalFrame5.setBorder(null);
        jInternalFrame5.setOpaque(true);
        jInternalFrame5.setVisible(true);
        jInternalFrame5.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Information");
        jInternalFrame5.getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 50, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("List");
        jInternalFrame5.getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("Function");
        jInternalFrame5.getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 50, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setText("ID :");
        jPanel7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 30, -1, -1));

        txtIDServiceBill.setBorder(null);
        jPanel7.add(txtIDServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 30, 155, -1));

        jSeparator11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 35, 150, 10));

        txtNamePatientServiceBill.setBorder(null);
        jPanel7.add(txtNamePatientServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 90, 155, -1));

        jLabel44.setText("Name :");
        jPanel7.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        jSeparator12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 95, 150, 10));

        txtIDPatientServiceBill.setBorder(null);
        jPanel7.add(txtIDPatientServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 90, 155, -1));

        jSeparator13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 95, 150, 10));

        jLabel45.setText("ID :");
        jPanel7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        tblListServiceBill.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblListServiceBill);

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 300, 450, 100));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setText("Patient");
        jPanel7.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 70, -1, -1));

        jLabel60.setText("Address :");
        jPanel7.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 130, -1, -1));

        txtAddressServiceBill.setBorder(null);
        jPanel7.add(txtAddressServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 130, 155, -1));

        jSeparator17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 135, 150, 10));

        txtGenderServiceBill.setBorder(null);
        jPanel7.add(txtGenderServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 170, 155, -1));

        jLabel61.setText("Gender :");
        jPanel7.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 170, -1, -1));

        jSeparator22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 175, 150, 10));

        txtBirthdayrServiceBill.setBorder(null);
        jPanel7.add(txtBirthdayrServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 130, 155, -1));

        jLabel62.setText("Birthday :");
        jPanel7.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 130, -1, -1));

        jSeparator23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 135, 150, 10));

        txtHealthInsuranceServiceBill.setBorder(null);
        jPanel7.add(txtHealthInsuranceServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 170, 155, -1));

        jLabel63.setText("Health Insurance :");
        jPanel7.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jSeparator24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 175, 150, 10));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setText("More Information");
        jPanel7.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 200, -1, -1));

        txtNameDoctorServiceBill.setBorder(null);
        jPanel7.add(txtNameDoctorServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 230, 155, -1));

        jLabel65.setText("Name Doctor :");
        jPanel7.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        jSeparator25.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 235, 150, 10));

        txtIDServiceServiceBill.setBorder(null);
        jPanel7.add(txtIDServiceServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 260, 155, -1));

        jLabel66.setText("ID Service :");
        jPanel7.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jSeparator26.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 265, 150, 10));

        txtServiceBillPrices.setBorder(null);
        jPanel7.add(txtServiceBillPrices, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 260, 155, -1));

        jLabel67.setText("Total Prices :");
        jPanel7.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        jSeparator27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 265, 150, 10));

        txtIDDoctorServiceBill.setBorder(null);
        jPanel7.add(txtIDDoctorServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 230, 155, -1));

        jLabel99.setText("ID Doctor :");
        jPanel7.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 230, -1, -1));

        jSeparator49.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jSeparator49, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 235, 150, 10));

        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-fast-forward-20.png"))); // NOI18N
        jLabel121.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel121.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel121MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 400, -1, -1));

        jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-left-15.png"))); // NOI18N
        jLabel122.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel122.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel122MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 402, -1, -1));

        jLabel123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-right-15.png"))); // NOI18N
        jLabel123.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel123.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel123MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 402, -1, -1));

        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-rewind-20.png"))); // NOI18N
        jLabel124.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel124.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel124MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        jInternalFrame5.getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 500, 420));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsertServiceBill.setBackground(new java.awt.Color(247, 158, 2));
        btnInsertServiceBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInsertServiceBill.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertServiceBill.setText("     INSERT");
        btnInsertServiceBill.setToolTipText("");
        btnInsertServiceBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertServiceBill.setOpaque(true);
        btnInsertServiceBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertServiceBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertServiceBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertServiceBillMouseExited(evt);
            }
        });
        jPanel8.add(btnInsertServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));

        btnUpdateServiceBill.setBackground(new java.awt.Color(247, 158, 2));
        btnUpdateServiceBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateServiceBill.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateServiceBill.setText("    UPDATE");
        btnUpdateServiceBill.setToolTipText("");
        btnUpdateServiceBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateServiceBill.setOpaque(true);
        btnUpdateServiceBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateServiceBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateServiceBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateServiceBillMouseExited(evt);
            }
        });
        jPanel8.add(btnUpdateServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, 30));

        btnDeleteServiceBill.setBackground(new java.awt.Color(247, 158, 2));
        btnDeleteServiceBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteServiceBill.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteServiceBill.setText("    DELETE");
        btnDeleteServiceBill.setToolTipText("");
        btnDeleteServiceBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteServiceBill.setOpaque(true);
        btnDeleteServiceBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteServiceBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteServiceBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteServiceBillMouseExited(evt);
            }
        });
        jPanel8.add(btnDeleteServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 30));

        btnSaveServiceBill.setBackground(new java.awt.Color(247, 158, 2));
        btnSaveServiceBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSaveServiceBill.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveServiceBill.setText("      SAVE");
        btnSaveServiceBill.setToolTipText("");
        btnSaveServiceBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveServiceBill.setOpaque(true);
        btnSaveServiceBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveServiceBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveServiceBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveServiceBillMouseExited(evt);
            }
        });
        jPanel8.add(btnSaveServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 30));

        btnCancelServiceBill.setBackground(new java.awt.Color(247, 158, 2));
        btnCancelServiceBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelServiceBill.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelServiceBill.setText("     CANCEL");
        btnCancelServiceBill.setToolTipText("");
        btnCancelServiceBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelServiceBill.setOpaque(true);
        btnCancelServiceBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelServiceBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelServiceBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelServiceBillMouseExited(evt);
            }
        });
        jPanel8.add(btnCancelServiceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 30));

        jInternalFrame5.getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 140, 420));

        kGradientPanel4.setkEndColor(new java.awt.Color(196, 219, 246));
        kGradientPanel4.setkStartColor(new java.awt.Color(59, 138, 235));

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
                kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 730, Short.MAX_VALUE)
        );
        kGradientPanel4Layout.setVerticalGroup(
                kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 550, Short.MAX_VALUE)
        );

        jInternalFrame5.getContentPane().add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 550));

        kGradientPanel1.add(jInternalFrame5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -20, 740, 580));

        jInternalFrame6.setBorder(null);
        jInternalFrame6.setOpaque(true);
        jInternalFrame6.setVisible(true);
        jInternalFrame6.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel68.setText("Information");
        jInternalFrame6.getContentPane().add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 50, -1, -1));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel69.setText("List");
        jInternalFrame6.getContentPane().add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel70.setText("Function");
        jInternalFrame6.getContentPane().add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 50, -1, -1));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setText("ID :");
        jPanel16.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 30, -1, -1));

        txtIDMedicineBill.setBorder(null);
        jPanel16.add(txtIDMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 30, 155, -1));

        jSeparator28.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 35, 150, 10));

        txtNamePatientMedicineBill.setBorder(null);
        jPanel16.add(txtNamePatientMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 90, 155, -1));

        jLabel72.setText("Name :");
        jPanel16.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        jSeparator29.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator29, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 95, 150, 10));

        txtIDPatientMedicineBill.setBorder(null);
        jPanel16.add(txtIDPatientMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 90, 155, -1));

        jSeparator30.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator30, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 95, 150, 10));

        jLabel73.setText("ID :");
        jPanel16.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        tblListMedicineBill.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tblListMedicineBill);

        jPanel16.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 300, 450, 100));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel74.setText("Patient");
        jPanel16.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 70, -1, -1));

        jLabel75.setText("Address :");
        jPanel16.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 130, -1, -1));

        txtAddressMedicineBill.setBorder(null);
        jPanel16.add(txtAddressMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 130, 155, -1));

        jSeparator31.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator31, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 135, 150, 10));

        txtGenderMedicineBill.setBorder(null);
        jPanel16.add(txtGenderMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 170, 155, -1));

        jLabel76.setText("Gender :");
        jPanel16.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 170, -1, -1));

        jSeparator32.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator32, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 175, 150, 10));

        txtBirthdayMedicineBill.setBorder(null);
        jPanel16.add(txtBirthdayMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 130, 155, -1));

        jLabel77.setText("Birthday :");
        jPanel16.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 130, -1, -1));

        jSeparator33.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator33, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 135, 150, 10));

        txtHealthInsuranceMedicineBill.setBorder(null);
        jPanel16.add(txtHealthInsuranceMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 170, 155, -1));

        jLabel78.setText("Health Insurance :");
        jPanel16.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jSeparator34.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator34, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 175, 150, 10));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel79.setText("More Information");
        jPanel16.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 200, -1, -1));

        txtNameDoctorMedicineBill.setBorder(null);
        jPanel16.add(txtNameDoctorMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 230, 155, -1));

        jLabel80.setText("Name Doctor :");
        jPanel16.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 230, -1, -1));

        jSeparator35.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator35, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 235, 150, 10));

        txtDosageMedicineBill.setBorder(null);
        jPanel16.add(txtDosageMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 260, 155, -1));

        jLabel81.setText("Dosage :");
        jPanel16.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jSeparator36.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator36, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 265, 150, 10));

        txtTotalPricesMedicineBill.setBorder(null);
        jPanel16.add(txtTotalPricesMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 260, 155, -1));

        jLabel82.setText("Total Prices :");
        jPanel16.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        jSeparator37.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator37, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 265, 150, 10));

        txtIDMedicineMedicineBill.setBorder(null);
        jPanel16.add(txtIDMedicineMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 230, 155, -1));

        jLabel83.setText("ID Medicine :");
        jPanel16.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        jSeparator38.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator38, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 235, 150, 10));

        txtIDDoctorMedicineBill.setBorder(null);
        jPanel16.add(txtIDDoctorMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 200, 155, -1));

        jLabel100.setText("ID Doctor :");
        jPanel16.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        jSeparator50.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.add(jSeparator50, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 205, 150, 10));

        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-fast-forward-20.png"))); // NOI18N
        jLabel125.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel125.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel125MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 400, -1, -1));

        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-left-15.png"))); // NOI18N
        jLabel126.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel126.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel126MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 402, -1, -1));

        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-right-15.png"))); // NOI18N
        jLabel127.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel127.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel127MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 402, -1, -1));

        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-rewind-20.png"))); // NOI18N
        jLabel128.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel128.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel128MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        jInternalFrame6.getContentPane().add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 500, 420));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsertMedicineBill.setBackground(new java.awt.Color(247, 158, 2));
        btnInsertMedicineBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInsertMedicineBill.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertMedicineBill.setText("     INSERT");
        btnInsertMedicineBill.setToolTipText("");
        btnInsertMedicineBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertMedicineBill.setOpaque(true);
        btnInsertMedicineBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertMedicineBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertMedicineBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertMedicineBillMouseExited(evt);
            }
        });
        jPanel17.add(btnInsertMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));

        btnUpdateMedicineBill.setBackground(new java.awt.Color(247, 158, 2));
        btnUpdateMedicineBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateMedicineBill.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateMedicineBill.setText("    UPDATE");
        btnUpdateMedicineBill.setToolTipText("");
        btnUpdateMedicineBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateMedicineBill.setOpaque(true);
        btnUpdateMedicineBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMedicineBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMedicineBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMedicineBillMouseExited(evt);
            }
        });
        jPanel17.add(btnUpdateMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, 30));

        btnDeleteMedicineBill.setBackground(new java.awt.Color(247, 158, 2));
        btnDeleteMedicineBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteMedicineBill.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteMedicineBill.setText("    DELETE");
        btnDeleteMedicineBill.setToolTipText("");
        btnDeleteMedicineBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteMedicineBill.setOpaque(true);
        btnDeleteMedicineBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMedicineBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMedicineBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMedicineBillMouseExited(evt);
            }
        });
        jPanel17.add(btnDeleteMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 30));

        btnSaveMedicineBill.setBackground(new java.awt.Color(247, 158, 2));
        btnSaveMedicineBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSaveMedicineBill.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveMedicineBill.setText("      SAVE");
        btnSaveMedicineBill.setToolTipText("");
        btnSaveMedicineBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveMedicineBill.setOpaque(true);
        btnSaveMedicineBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMedicineBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMedicineBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMedicineBillMouseExited(evt);
            }
        });
        jPanel17.add(btnSaveMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 30));

        btnCancelMedicineBill.setBackground(new java.awt.Color(247, 158, 2));
        btnCancelMedicineBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelMedicineBill.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelMedicineBill.setText("     CANCEL");
        btnCancelMedicineBill.setToolTipText("");
        btnCancelMedicineBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelMedicineBill.setOpaque(true);
        btnCancelMedicineBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMedicineBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMedicineBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMedicineBillMouseExited(evt);
            }
        });
        jPanel17.add(btnCancelMedicineBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 30));

        jInternalFrame6.getContentPane().add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 140, 420));

        kGradientPanel7.setkEndColor(new java.awt.Color(196, 219, 246));
        kGradientPanel7.setkStartColor(new java.awt.Color(59, 138, 235));

        javax.swing.GroupLayout kGradientPanel7Layout = new javax.swing.GroupLayout(kGradientPanel7);
        kGradientPanel7.setLayout(kGradientPanel7Layout);
        kGradientPanel7Layout.setHorizontalGroup(
                kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 730, Short.MAX_VALUE)
        );
        kGradientPanel7Layout.setVerticalGroup(
                kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 550, Short.MAX_VALUE)
        );

        jInternalFrame6.getContentPane().add(kGradientPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 550));

        kGradientPanel1.add(jInternalFrame6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -20, 740, 580));

        jInternalFrame7.setBorder(null);
        jInternalFrame7.setOpaque(true);
        jInternalFrame7.setVisible(true);
        jInternalFrame7.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel84.setText("Information");
        jInternalFrame7.getContentPane().add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 50, -1, -1));

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel85.setText("List");
        jInternalFrame7.getContentPane().add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel86.setText("Function");
        jInternalFrame7.getContentPane().add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 50, -1, -1));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel87.setText("ID :");
        jPanel18.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 30, -1, -1));

        txtIDTotalBill.setBorder(null);
        jPanel18.add(txtIDTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 30, 155, -1));

        jSeparator39.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel18.add(jSeparator39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 35, 150, 10));

        txtNamePatientTotalBill.setBorder(null);
        jPanel18.add(txtNamePatientTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 90, 155, -1));

        jLabel88.setText("Name :");
        jPanel18.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        jSeparator40.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel18.add(jSeparator40, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 95, 150, 10));

        txtIDPatientTotalBill.setBorder(null);
        jPanel18.add(txtIDPatientTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 90, 155, -1));

        jSeparator41.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel18.add(jSeparator41, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 95, 150, 10));

        jLabel89.setText("ID :");
        jPanel18.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 90, -1, -1));

        tblListTotalBill.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tblListTotalBill);

        jPanel18.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 300, 450, 100));

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel90.setText("Patient");
        jPanel18.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 70, -1, -1));

        jLabel91.setText("Address :");
        jPanel18.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 130, -1, -1));

        txtAddressTotalBill.setBorder(null);
        jPanel18.add(txtAddressTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 130, 155, -1));

        jSeparator42.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel18.add(jSeparator42, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 135, 150, 10));

        txtGenderTotalBill.setBorder(null);
        jPanel18.add(txtGenderTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 170, 155, -1));

        jLabel92.setText("Gender :");
        jPanel18.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 170, -1, -1));

        jSeparator43.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel18.add(jSeparator43, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 175, 150, 10));

        txtBirthdayTotalBill.setBorder(null);
        jPanel18.add(txtBirthdayTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 130, 155, -1));

        jLabel93.setText("Birthday :");
        jPanel18.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 130, -1, -1));

        jSeparator44.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel18.add(jSeparator44, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 135, 150, 10));

        txtHealthInsuranceTotalBill.setBorder(null);
        jPanel18.add(txtHealthInsuranceTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 170, 155, -1));

        jLabel94.setText("Health Insurance :");
        jPanel18.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jSeparator45.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel18.add(jSeparator45, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 175, 150, 10));

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel95.setText("More Information");
        jPanel18.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 200, -1, -1));

        txtIDServiceTotalBill.setBorder(null);
        jPanel18.add(txtIDServiceTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 230, 155, -1));

        jLabel96.setText("ID Service Bill :");
        jPanel18.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 230, -1, -1));

        jSeparator46.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel18.add(jSeparator46, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 235, 150, 10));

        txtTotalPricesTotalBill.setBorder(null);
        jPanel18.add(txtTotalPricesTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 260, 155, -1));

        jLabel97.setText("Total Prices :");
        jPanel18.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 260, -1, -1));

        jSeparator47.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel18.add(jSeparator47, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 265, 150, 10));

        txtIDMedicineTotalBill.setBorder(null);
        jPanel18.add(txtIDMedicineTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 155, -1));

        jLabel98.setText("ID Medicine Bill :");
        jPanel18.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 230, -1, -1));

        jSeparator48.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel18.add(jSeparator48, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 235, 150, 10));

        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-fast-forward-20.png"))); // NOI18N
        jLabel101.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel101MouseClicked(evt);
            }
        });
        jPanel18.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 400, -1, -1));

        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-left-15.png"))); // NOI18N
        jLabel103.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel103MouseClicked(evt);
            }
        });
        jPanel18.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 402, -1, -1));

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sort-right-15.png"))); // NOI18N
        jLabel104.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel104MouseClicked(evt);
            }
        });
        jPanel18.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 402, -1, -1));

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-rewind-20.png"))); // NOI18N
        jLabel105.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel105MouseClicked(evt);
            }
        });
        jPanel18.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        jInternalFrame7.getContentPane().add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 500, 420));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsertTotalBill.setBackground(new java.awt.Color(247, 158, 2));
        btnInsertTotalBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInsertTotalBill.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertTotalBill.setText("     INSERT");
        btnInsertTotalBill.setToolTipText("");
        btnInsertTotalBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertTotalBill.setOpaque(true);
        btnInsertTotalBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertTotalBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertTotalBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertTotalBillMouseExited(evt);
            }
        });
        jPanel19.add(btnInsertTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));

        btnUpdateTotalBill.setBackground(new java.awt.Color(247, 158, 2));
        btnUpdateTotalBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateTotalBill.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateTotalBill.setText("    UPDATE");
        btnUpdateTotalBill.setToolTipText("");
        btnUpdateTotalBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateTotalBill.setOpaque(true);
        btnUpdateTotalBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateTotalBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateTotalBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateTotalBillMouseExited(evt);
            }
        });
        jPanel19.add(btnUpdateTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, 30));

        btnDeleteTotalBill.setBackground(new java.awt.Color(247, 158, 2));
        btnDeleteTotalBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteTotalBill.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteTotalBill.setText("    DELETE");
        btnDeleteTotalBill.setToolTipText("");
        btnDeleteTotalBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteTotalBill.setOpaque(true);
        btnDeleteTotalBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteTotalBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteTotalBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteTotalBillMouseExited(evt);
            }
        });
        jPanel19.add(btnDeleteTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 30));

        btnSaveTotalBill.setBackground(new java.awt.Color(247, 158, 2));
        btnSaveTotalBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSaveTotalBill.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveTotalBill.setText("      SAVE");
        btnSaveTotalBill.setToolTipText("");
        btnSaveTotalBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveTotalBill.setOpaque(true);
        btnSaveTotalBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveTotalBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveTotalBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveTotalBillMouseExited(evt);
            }
        });
        jPanel19.add(btnSaveTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 30));

        btnCancelTotalBill.setBackground(new java.awt.Color(247, 158, 2));
        btnCancelTotalBill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelTotalBill.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelTotalBill.setText("     CANCEL");
        btnCancelTotalBill.setToolTipText("");
        btnCancelTotalBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelTotalBill.setOpaque(true);
        btnCancelTotalBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelTotalBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelTotalBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelTotalBillMouseExited(evt);
            }
        });
        jPanel19.add(btnCancelTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 30));

        jInternalFrame7.getContentPane().add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 140, 420));

        kGradientPanel8.setkEndColor(new java.awt.Color(196, 219, 246));
        kGradientPanel8.setkStartColor(new java.awt.Color(59, 138, 235));

        javax.swing.GroupLayout kGradientPanel8Layout = new javax.swing.GroupLayout(kGradientPanel8);
        kGradientPanel8.setLayout(kGradientPanel8Layout);
        kGradientPanel8Layout.setHorizontalGroup(
                kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 730, Short.MAX_VALUE)
        );
        kGradientPanel8Layout.setVerticalGroup(
                kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 550, Short.MAX_VALUE)
        );

        jInternalFrame7.getContentPane().add(kGradientPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 550));

        kGradientPanel1.add(jInternalFrame7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -20, 740, 580));

        jInternalFrame8.setBorder(null);
        jInternalFrame8.setOpaque(true);
        jInternalFrame8.setVisible(true);
        jInternalFrame8.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel9.setkEndColor(new java.awt.Color(196, 219, 246));
        kGradientPanel9.setkStartColor(new java.awt.Color(59, 138, 235));

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setText("Username :");

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 255, 255));
        jLabel134.setText("Fullname :");

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(255, 255, 255));
        jLabel135.setText("Address :");

        txtUsername.setBackground(new Color(0,0,0,0)
        );
        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtUsername.setEnabled(false);
        txtUsername.setOpaque(false);

        txtFullname.setBackground(new Color(0,0,0,0)
        );
        txtFullname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFullname.setForeground(new java.awt.Color(255, 255, 255));
        txtFullname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFullname.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtFullname.setEnabled(false);
        txtFullname.setOpaque(false);

        txtAboutAddress.setBackground(new Color(0,0,0,0)
        );
        txtAboutAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAboutAddress.setForeground(new java.awt.Color(255, 255, 255));
        txtAboutAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtAboutAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtAboutAddress.setEnabled(false);
        txtAboutAddress.setOpaque(false);

        javax.swing.GroupLayout kGradientPanel9Layout = new javax.swing.GroupLayout(kGradientPanel9);
        kGradientPanel9.setLayout(kGradientPanel9Layout);
        kGradientPanel9Layout.setHorizontalGroup(
                kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel9Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(kGradientPanel9Layout.createSequentialGroup()
                                                .addComponent(jLabel135)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtAboutAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel9Layout.createSequentialGroup()
                                                .addComponent(jLabel134)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel9Layout.createSequentialGroup()
                                                .addComponent(jLabel133)
                                                .addGap(53, 53, 53)
                                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(200, Short.MAX_VALUE))
        );
        kGradientPanel9Layout.setVerticalGroup(
                kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel9Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel133)
                                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel134)
                                        .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel135)
                                        .addComponent(txtAboutAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(357, Short.MAX_VALUE))
        );

        jInternalFrame8.getContentPane().add(kGradientPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 550));

        kGradientPanel1.add(jInternalFrame8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -20, 740, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel30MouseClicked
    //DOCTOR
    private void barDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barDoctorMouseClicked

        bar(bar1);
        jInternalFrame1.setVisible(true);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
        jInternalFrame7.setVisible(false);
        jInternalFrame8.setVisible(false);
        showDataBS();
    }//GEN-LAST:event_barDoctorMouseClicked

    private void barDoctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barDoctorMouseEntered
        barDoctor.setBackground(Color.decode("#374785"));
        bar(bar1);
    }//GEN-LAST:event_barDoctorMouseEntered

    private void barDoctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barDoctorMouseExited
        barDoctor.setBackground(Color.decode("#24305E"));
    }//GEN-LAST:event_barDoctorMouseExited
    //PATIENT
    private void barPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barPatientMouseClicked
        bar(bar2);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(true);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
        jInternalFrame7.setVisible(false);
        jInternalFrame8.setVisible(false);
        showDataBN();
    }//GEN-LAST:event_barPatientMouseClicked

    private void barPatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barPatientMouseEntered
        barPatient.setBackground(Color.decode("#374785"));
        bar(bar2);
    }//GEN-LAST:event_barPatientMouseEntered

    private void barPatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barPatientMouseExited
        barPatient.setBackground(Color.decode("#24305E"));
    }//GEN-LAST:event_barPatientMouseExited
    //SERVICE
    private void barServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barServiceMouseClicked
        bar(bar3);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(true);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
        jInternalFrame7.setVisible(false);
        jInternalFrame8.setVisible(false);
        showDataDV();
    }//GEN-LAST:event_barServiceMouseClicked

    private void barServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barServiceMouseEntered
        barService.setBackground(Color.decode("#374785"));
        bar(bar3);
    }//GEN-LAST:event_barServiceMouseEntered

    private void barServiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barServiceMouseExited
        barService.setBackground(Color.decode("#24305E"));
    }//GEN-LAST:event_barServiceMouseExited
    //Medicine
    private void barMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMedicineMouseClicked
        bar(bar4);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(true);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
        jInternalFrame7.setVisible(false);
        jInternalFrame8.setVisible(false);
        showDataT();
    }//GEN-LAST:event_barMedicineMouseClicked

    private void barMedicineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMedicineMouseEntered
        barMedicine.setBackground(Color.decode("#374785"));
        bar(bar4);
    }//GEN-LAST:event_barMedicineMouseEntered

    private void barMedicineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMedicineMouseExited
        barMedicine.setBackground(Color.decode("#24305E"));
    }//GEN-LAST:event_barMedicineMouseExited
    //Service Bill
    private void barServiceBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barServiceBillMouseClicked
        bar(bar5);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(true);
        jInternalFrame6.setVisible(false);
        jInternalFrame7.setVisible(false);
        jInternalFrame8.setVisible(false);
        showDataDDV();
    }//GEN-LAST:event_barServiceBillMouseClicked

    private void barServiceBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barServiceBillMouseEntered
        barServiceBill.setBackground(Color.decode("#374785"));
        bar(bar5);
    }//GEN-LAST:event_barServiceBillMouseEntered

    private void barServiceBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barServiceBillMouseExited
        barServiceBill.setBackground(Color.decode("#24305E"));
    }//GEN-LAST:event_barServiceBillMouseExited

    private void barMedicineBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMedicineBillMouseClicked
        bar(bar6);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(true);
        jInternalFrame7.setVisible(false);
        jInternalFrame8.setVisible(false);
        showDataDT();
    }//GEN-LAST:event_barMedicineBillMouseClicked

    private void barMedicineBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMedicineBillMouseEntered
        barMedicineBill.setBackground(Color.decode("#374785"));
        bar(bar6);
    }//GEN-LAST:event_barMedicineBillMouseEntered

    private void barMedicineBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMedicineBillMouseExited
        barMedicineBill.setBackground(Color.decode("#24305E"));
    }//GEN-LAST:event_barMedicineBillMouseExited
    //Total Bill
    private void barTotalBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barTotalBillMouseClicked
        bar(bar7);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
        jInternalFrame7.setVisible(true);
        jInternalFrame8.setVisible(false);
        showDataHD();
    }//GEN-LAST:event_barTotalBillMouseClicked

    private void barTotalBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barTotalBillMouseEntered
        barTotalBill.setBackground(Color.decode("#374785"));
        bar(bar7);
    }//GEN-LAST:event_barTotalBillMouseEntered

    private void barTotalBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barTotalBillMouseExited
        barTotalBill.setBackground(Color.decode("#24305E"));
    }//GEN-LAST:event_barTotalBillMouseExited
    //PATIENT
    private void btnInsertPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertPatientMouseClicked
        ClearTextBN();
        flag = 1;
        btnSavePatient.setEnabled(true);
        btnUpdatePatient.setEnabled(false);
        btnDeletePatient.setEnabled(false);
        btnInsertPatient.setEnabled(false);
        btnCancelPatient.setEnabled(true);
    }//GEN-LAST:event_btnInsertPatientMouseClicked

    private void btnUpdatePatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdatePatientMouseClicked
        ClearTextBN();
        flag = 2;
        btnSavePatient.setEnabled(true);
        btnUpdatePatient.setEnabled(false);
        btnDeletePatient.setEnabled(false);
        btnInsertPatient.setEnabled(false);
        btnCancelPatient.setEnabled(true);
    }//GEN-LAST:event_btnUpdatePatientMouseClicked

    private void btnDeletePatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletePatientMouseClicked
        ClearTextBN();
        flag = 3;
        btnSavePatient.setEnabled(true);
        btnUpdatePatient.setEnabled(false);
        btnDeletePatient.setEnabled(false);
        btnInsertPatient.setEnabled(false);
        btnCancelPatient.setEnabled(true);
    }//GEN-LAST:event_btnDeletePatientMouseClicked

    private void btnSavePatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSavePatientMouseClicked
        if(flag == 0)
        {
            JOptionPane.showMessageDialog(null, "Mời chọn chức năng");
        }
        else if(flag == 1) {
            InsertDataBN();
            btnInsertPatient.setEnabled(true);
            btnUpdatePatient.setEnabled(true);
            btnDeletePatient.setEnabled(true);
        }
        else if(flag == 2){
            UpdateDataBN();
            btnInsertPatient.setEnabled(true);
            btnUpdatePatient.setEnabled(true);
            btnDeletePatient.setEnabled(true);
        }
        else if(flag == 3){
            DeleteDataBN();
            btnInsertPatient.setEnabled(true);
            btnUpdatePatient.setEnabled(true);
            btnDeletePatient.setEnabled(true);
        }
        flag = 0;
    }//GEN-LAST:event_btnSavePatientMouseClicked

    private void btnCancelPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelPatientMouseClicked
        ClearTextBN();
        btnUpdatePatient.setEnabled(true);
        btnDeletePatient.setEnabled(true);
        btnInsertPatient.setEnabled(true);
        flag = 0;
    }//GEN-LAST:event_btnCancelPatientMouseClicked
    //SERVICE
    private void btnInsertServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertServiceMouseClicked
        ClearTextDV();
        flag = 1;
        btnSaveService.setEnabled(true);
        btnUpdateService.setEnabled(false);
        btnDeleteService.setEnabled(false);
        btnInsertService.setEnabled(false);
        btnCancelService.setEnabled(true);
    }//GEN-LAST:event_btnInsertServiceMouseClicked

    private void btnUpdateServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateServiceMouseClicked
        ClearTextDV();
        flag = 2;
        btnSaveService.setEnabled(true);
        btnUpdateService.setEnabled(false);
        btnDeleteService.setEnabled(false);
        btnInsertService.setEnabled(false);
        btnCancelService.setEnabled(true);
    }//GEN-LAST:event_btnUpdateServiceMouseClicked

    private void btnDeleteServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteServiceMouseClicked
        ClearTextDV();
        flag = 3;
        btnSaveService.setEnabled(true);
        btnUpdateService.setEnabled(false);
        btnDeleteService.setEnabled(false);
        btnInsertService.setEnabled(false);
        btnCancelService.setEnabled(true);
    }//GEN-LAST:event_btnDeleteServiceMouseClicked

    private void btnSaveServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveServiceMouseClicked
        if(flag == 0)
        {
            JOptionPane.showMessageDialog(null, "Mời chọn chức năng");
        }
        else if(flag == 1) {
            InsertDataDV();
            btnInsertService.setEnabled(true);
            btnUpdateService.setEnabled(true);
            btnDeleteService.setEnabled(true);
        }
        else if(flag == 2){
            UpdateDataDV();
            btnInsertService.setEnabled(true);
            btnUpdateService.setEnabled(true);
            btnDeleteService.setEnabled(true);
        }
        else if(flag == 3){
            DeleteDataDV();
            btnInsertService.setEnabled(true);
            btnUpdateService.setEnabled(true);
            btnDeleteService.setEnabled(true);
        }
        flag = 0;
    }//GEN-LAST:event_btnSaveServiceMouseClicked

    private void btnCancelServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelServiceMouseClicked
        ClearTextDV();
        btnUpdateService.setEnabled(true);
        btnDeleteService.setEnabled(true);
        btnInsertService.setEnabled(true);
        flag = 0;
    }//GEN-LAST:event_btnCancelServiceMouseClicked

    private void btnInsertMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMedicineMouseClicked
        CLearTextT();
        flag = 1;
        btnSaveMedicine.setEnabled(true);
        btnUpdateMedicine.setEnabled(false);
        btnDeleteMedicine.setEnabled(false);
        btnInsertMedicine.setEnabled(false);
        btnCancelMedicine.setEnabled(true);
    }//GEN-LAST:event_btnInsertMedicineMouseClicked

    private void btnUpdateMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMedicineMouseClicked
        CLearTextT();
        flag = 2;
        btnSaveMedicine.setEnabled(true);
        btnUpdateMedicine.setEnabled(false);
        btnDeleteMedicine.setEnabled(false);
        btnInsertMedicine.setEnabled(false);
        btnCancelMedicine.setEnabled(true);
    }//GEN-LAST:event_btnUpdateMedicineMouseClicked

    private void btnDeleteMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMedicineMouseClicked
        CLearTextT();
        flag = 3;
        btnSaveMedicine.setEnabled(true);
        btnUpdateMedicine.setEnabled(false);
        btnDeleteMedicine.setEnabled(false);
        btnInsertMedicine.setEnabled(false);
        btnCancelMedicine.setEnabled(true);
    }//GEN-LAST:event_btnDeleteMedicineMouseClicked

    private void btnSaveMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMedicineMouseClicked
        if(flag == 0)
        {
            JOptionPane.showMessageDialog(null, "Mời chọn chức năng");
        }
        else if(flag == 1) {
            InsertDataT();
            btnUpdateMedicine.setEnabled(true);
            btnDeleteMedicine.setEnabled(true);
            btnInsertMedicine.setEnabled(true);
        }
        else if(flag == 2){
            UpdateDataT();
            btnUpdateMedicine.setEnabled(true);
            btnDeleteMedicine.setEnabled(true);
            btnInsertMedicine.setEnabled(true);
        }
        else if(flag == 3){
            DeleteDataT();
            btnUpdateMedicine.setEnabled(true);
            btnDeleteMedicine.setEnabled(true);
            btnInsertMedicine.setEnabled(true);
        }
        flag = 0;
    }//GEN-LAST:event_btnSaveMedicineMouseClicked

    private void btnCancelMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMedicineMouseClicked
        CLearTextT();
        btnUpdateMedicine.setEnabled(true);
        btnDeleteMedicine.setEnabled(true);
        btnInsertMedicine.setEnabled(true);
        flag = 0;
    }//GEN-LAST:event_btnCancelMedicineMouseClicked

    private void btnInsertServiceBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertServiceBillMouseClicked
        ClearTextDDV();
        flag = 1;
        btnSaveServiceBill.setEnabled(true);
        btnUpdateServiceBill.setEnabled(false);
        btnDeleteServiceBill.setEnabled(false);
        btnInsertServiceBill.setEnabled(false);
        btnCancelServiceBill.setEnabled(true);
    }//GEN-LAST:event_btnInsertServiceBillMouseClicked

    private void btnUpdateServiceBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateServiceBillMouseClicked
        ClearTextDDV();
        flag = 2;
        btnSaveServiceBill.setEnabled(true);
        btnUpdateServiceBill.setEnabled(false);
        btnDeleteServiceBill.setEnabled(false);
        btnInsertServiceBill.setEnabled(false);
        btnCancelServiceBill.setEnabled(true);
    }//GEN-LAST:event_btnUpdateServiceBillMouseClicked

    private void btnDeleteServiceBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteServiceBillMouseClicked
        ClearTextDDV();
        flag = 3;
        btnSaveServiceBill.setEnabled(true);
        btnUpdateServiceBill.setEnabled(false);
        btnDeleteServiceBill.setEnabled(false);
        btnInsertServiceBill.setEnabled(false);
        btnCancelServiceBill.setEnabled(true);
    }//GEN-LAST:event_btnDeleteServiceBillMouseClicked

    private void btnSaveServiceBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveServiceBillMouseClicked
        if(flag == 0)
        {
            JOptionPane.showMessageDialog(null, "Mời chọn chức năng");
        }
        else if(flag == 1) {
            InsertDataDDV();
            btnUpdateServiceBill.setEnabled(true);
            btnDeleteServiceBill.setEnabled(true);
            btnInsertServiceBill.setEnabled(true);
        }
        else if(flag == 2){
            UpdateDataDDV();
            btnUpdateServiceBill.setEnabled(true);
            btnDeleteServiceBill.setEnabled(true);
            btnInsertServiceBill.setEnabled(true);
        }
        else if(flag == 3){
            DeleteDataDDV();
            btnUpdateServiceBill.setEnabled(true);
            btnDeleteServiceBill.setEnabled(true);
            btnInsertServiceBill.setEnabled(true);
        }
        flag = 0;
    }//GEN-LAST:event_btnSaveServiceBillMouseClicked

    private void btnCancelServiceBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelServiceBillMouseClicked
        ClearTextDDV();
        btnUpdateServiceBill.setEnabled(true);
        btnDeleteServiceBill.setEnabled(true);
        btnInsertServiceBill.setEnabled(true);
        flag = 0;
    }//GEN-LAST:event_btnCancelServiceBillMouseClicked

    private void btnInsertMedicineBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMedicineBillMouseClicked
        ClearTextDT();
        flag = 1;
        btnSaveMedicineBill.setEnabled(true);
        btnUpdateMedicineBill.setEnabled(false);
        btnDeleteMedicineBill.setEnabled(false);
        btnInsertMedicineBill.setEnabled(false);
        btnCancelMedicineBill.setEnabled(true);
    }//GEN-LAST:event_btnInsertMedicineBillMouseClicked

    private void btnUpdateMedicineBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMedicineBillMouseClicked
        ClearTextDT();
        flag = 2;
        btnSaveMedicineBill.setEnabled(true);
        btnUpdateMedicineBill.setEnabled(false);
        btnDeleteMedicineBill.setEnabled(false);
        btnInsertMedicineBill.setEnabled(false);
        btnCancelMedicineBill.setEnabled(true);
    }//GEN-LAST:event_btnUpdateMedicineBillMouseClicked

    private void btnDeleteMedicineBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMedicineBillMouseClicked
        ClearTextDT();
        flag = 3;
        btnSaveMedicineBill.setEnabled(true);
        btnUpdateMedicineBill.setEnabled(false);
        btnDeleteMedicineBill.setEnabled(false);
        btnInsertMedicineBill.setEnabled(false);
        btnCancelMedicineBill.setEnabled(true);
    }//GEN-LAST:event_btnDeleteMedicineBillMouseClicked

    private void btnSaveMedicineBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMedicineBillMouseClicked
        if(flag == 0)
        {
            JOptionPane.showMessageDialog(null, "Mời chọn chức năng");
        }
        else if(flag == 1) {
            InsertDataDT();
            btnUpdateMedicineBill.setEnabled(true);
            btnDeleteMedicineBill.setEnabled(true);
            btnInsertMedicineBill.setEnabled(true);
        }
        else if(flag == 2){
            UpdateDataDT();
            btnUpdateMedicineBill.setEnabled(true);
            btnDeleteMedicineBill.setEnabled(true);
            btnInsertMedicineBill.setEnabled(true);
        }
        else if(flag == 3){
            DeleteDataDT();
            btnUpdateMedicineBill.setEnabled(true);
            btnDeleteMedicineBill.setEnabled(true);
            btnInsertMedicineBill.setEnabled(true);
        }
        flag = 0;
    }//GEN-LAST:event_btnSaveMedicineBillMouseClicked

    private void btnCancelMedicineBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMedicineBillMouseClicked
        ClearTextDT();
        btnUpdateMedicineBill.setEnabled(true);
        btnDeleteMedicineBill.setEnabled(true);
        btnInsertMedicineBill.setEnabled(true);
        flag = 0;
    }//GEN-LAST:event_btnCancelMedicineBillMouseClicked

    private void btnInsertTotalBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertTotalBillMouseClicked
        ClearTextHD();
        flag = 1;
        btnSaveTotalBill.setEnabled(true);
        btnUpdateTotalBill.setEnabled(false);
        btnDeleteTotalBill.setEnabled(false);
        btnInsertTotalBill.setEnabled(false);
        btnCancelTotalBill.setEnabled(true);
    }//GEN-LAST:event_btnInsertTotalBillMouseClicked

    private void btnUpdateTotalBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateTotalBillMouseClicked
        ClearTextHD();
        flag = 2;
        btnSaveTotalBill.setEnabled(true);
        btnUpdateTotalBill.setEnabled(false);
        btnDeleteTotalBill.setEnabled(false);
        btnInsertTotalBill.setEnabled(false);
        btnCancelTotalBill.setEnabled(true);
    }//GEN-LAST:event_btnUpdateTotalBillMouseClicked

    private void btnDeleteTotalBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteTotalBillMouseClicked
        ClearTextHD();
        flag = 3;
        btnSaveTotalBill.setEnabled(true);
        btnUpdateTotalBill.setEnabled(false);
        btnDeleteTotalBill.setEnabled(false);
        btnInsertTotalBill.setEnabled(false);
        btnCancelTotalBill.setEnabled(true);
    }//GEN-LAST:event_btnDeleteTotalBillMouseClicked

    private void btnSaveTotalBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveTotalBillMouseClicked
        if(flag == 0)
        {
            JOptionPane.showMessageDialog(null, "Mời chọn chức năng");
        }
        else if(flag == 1) {
            InsertDataHD();
            btnUpdateTotalBill.setEnabled(true);
            btnDeleteTotalBill.setEnabled(true);
            btnInsertTotalBill.setEnabled(true);
        }
        else if(flag == 2){
            UpdateDataHD();
            btnUpdateTotalBill.setEnabled(true);
            btnDeleteTotalBill.setEnabled(true);
            btnInsertTotalBill.setEnabled(true);
        }
        else if(flag == 3){
            DeleteDataHD();
            btnUpdateTotalBill.setEnabled(true);
            btnDeleteTotalBill.setEnabled(true);
            btnInsertTotalBill.setEnabled(true);
        }
        flag = 0;
    }//GEN-LAST:event_btnSaveTotalBillMouseClicked

    private void btnCancelTotalBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelTotalBillMouseClicked
        ClearTextHD();
        btnUpdateTotalBill.setEnabled(true);
        btnDeleteTotalBill.setEnabled(true);
        btnInsertTotalBill.setEnabled(true);
        flag = 0;
    }//GEN-LAST:event_btnCancelTotalBillMouseClicked

    private void jLabel111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseClicked
        getSelectFirstBN();
    }//GEN-LAST:event_jLabel111MouseClicked

    private void jLabel112MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel112MouseClicked
        getSelectPreviousBN();
    }//GEN-LAST:event_jLabel112MouseClicked

    private void jLabel109MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseClicked
        getSelectNextBN();
    }//GEN-LAST:event_jLabel109MouseClicked

    private void jLabel110MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel110MouseClicked
        getSelectLastBN();
    }//GEN-LAST:event_jLabel110MouseClicked

    private void jLabel115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel115MouseClicked
        getSelectFirstDV();
    }//GEN-LAST:event_jLabel115MouseClicked

    private void jLabel116MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel116MouseClicked
        getSelectPreviousDV();
    }//GEN-LAST:event_jLabel116MouseClicked

    private void jLabel113MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel113MouseClicked
        getSelectNextDV();
    }//GEN-LAST:event_jLabel113MouseClicked

    private void jLabel114MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel114MouseClicked
        getSelectLastDV();
    }//GEN-LAST:event_jLabel114MouseClicked

    private void jLabel119MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel119MouseClicked
        getSelectFirstT();
    }//GEN-LAST:event_jLabel119MouseClicked

    private void jLabel120MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel120MouseClicked
        getSelectPreviousT();
    }//GEN-LAST:event_jLabel120MouseClicked

    private void jLabel117MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel117MouseClicked
        getSelectNextT();
    }//GEN-LAST:event_jLabel117MouseClicked

    private void jLabel118MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel118MouseClicked
        getSelectLastT();
    }//GEN-LAST:event_jLabel118MouseClicked

    private void jLabel124MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel124MouseClicked
        getSelectFirstDDV();
    }//GEN-LAST:event_jLabel124MouseClicked

    private void jLabel122MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel122MouseClicked
        getSelectPreviousDDV();
    }//GEN-LAST:event_jLabel122MouseClicked

    private void jLabel123MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel123MouseClicked
        getSelectNextDDV();
    }//GEN-LAST:event_jLabel123MouseClicked

    private void jLabel121MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel121MouseClicked
        getSelectLastDDV();
    }//GEN-LAST:event_jLabel121MouseClicked

    private void jLabel128MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel128MouseClicked
        getSelectFirstDT();
    }//GEN-LAST:event_jLabel128MouseClicked

    private void jLabel126MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel126MouseClicked
        getSelectPreviousDT();
    }//GEN-LAST:event_jLabel126MouseClicked

    private void jLabel127MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel127MouseClicked
        getSelectNextDT();
    }//GEN-LAST:event_jLabel127MouseClicked

    private void jLabel125MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel125MouseClicked
        getSelectLastDT();
    }//GEN-LAST:event_jLabel125MouseClicked

    private void jLabel105MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel105MouseClicked
        getSelectFirstHD();
    }//GEN-LAST:event_jLabel105MouseClicked

    private void jLabel103MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel103MouseClicked
        getSelectPreviousHD();
    }//GEN-LAST:event_jLabel103MouseClicked

    private void jLabel104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel104MouseClicked
        getSelectNextHD();
    }//GEN-LAST:event_jLabel104MouseClicked

    private void jLabel101MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel101MouseClicked
        getSelectLastHD();
    }//GEN-LAST:event_jLabel101MouseClicked

    private void btnInsertPatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertPatientMouseEntered
        btnInsertPatient.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnInsertPatientMouseEntered

    private void btnInsertPatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertPatientMouseExited
        btnInsertPatient.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnInsertPatientMouseExited

    private void btnUpdatePatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdatePatientMouseEntered
        btnUpdatePatient.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnUpdatePatientMouseEntered

    private void btnUpdatePatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdatePatientMouseExited
        btnUpdatePatient.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnUpdatePatientMouseExited

    private void btnDeletePatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletePatientMouseEntered
        btnDeletePatient.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnDeletePatientMouseEntered

    private void btnDeletePatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletePatientMouseExited
        btnDeletePatient.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnDeletePatientMouseExited

    private void btnSavePatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSavePatientMouseEntered
        btnSavePatient.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnSavePatientMouseEntered

    private void btnSavePatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSavePatientMouseExited
        btnSavePatient.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnSavePatientMouseExited

    private void btnCancelPatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelPatientMouseEntered
        btnCancelPatient.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnCancelPatientMouseEntered

    private void btnCancelPatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelPatientMouseExited
        btnCancelPatient.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnCancelPatientMouseExited

    private void btnInsertServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertServiceMouseEntered
        btnInsertService.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnInsertServiceMouseEntered

    private void btnInsertServiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertServiceMouseExited
        btnInsertService.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnInsertServiceMouseExited

    private void btnUpdateServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateServiceMouseEntered
        btnUpdateService.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnUpdateServiceMouseEntered

    private void btnUpdateServiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateServiceMouseExited
        btnUpdateService.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnUpdateServiceMouseExited

    private void btnDeleteServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteServiceMouseEntered
        btnDeleteService.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnDeleteServiceMouseEntered

    private void btnDeleteServiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteServiceMouseExited
        btnDeleteService.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnDeleteServiceMouseExited

    private void btnSaveServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveServiceMouseEntered
        btnSaveService.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnSaveServiceMouseEntered

    private void btnSaveServiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveServiceMouseExited
        btnSaveService.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnSaveServiceMouseExited

    private void btnCancelServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelServiceMouseEntered
        btnCancelService.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnCancelServiceMouseEntered

    private void btnCancelServiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelServiceMouseExited
        btnCancelService.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnCancelServiceMouseExited

    private void btnInsertMedicineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMedicineMouseEntered
        btnInsertMedicine.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnInsertMedicineMouseEntered

    private void btnInsertMedicineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMedicineMouseExited
        btnInsertMedicine.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnInsertMedicineMouseExited

    private void btnUpdateMedicineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMedicineMouseEntered
        btnUpdateMedicine.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnUpdateMedicineMouseEntered

    private void btnUpdateMedicineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMedicineMouseExited
        btnUpdateMedicine.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnUpdateMedicineMouseExited

    private void btnDeleteMedicineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMedicineMouseEntered
        btnDeleteMedicine.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnDeleteMedicineMouseEntered

    private void btnDeleteMedicineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMedicineMouseExited
        btnDeleteMedicine.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnDeleteMedicineMouseExited

    private void btnSaveMedicineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMedicineMouseEntered
        btnSaveMedicine.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnSaveMedicineMouseEntered

    private void btnSaveMedicineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMedicineMouseExited
        btnSaveMedicine.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnSaveMedicineMouseExited

    private void btnCancelMedicineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMedicineMouseEntered
        btnCancelMedicine.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnCancelMedicineMouseEntered

    private void btnCancelMedicineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMedicineMouseExited
        btnCancelMedicine.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnCancelMedicineMouseExited

    private void btnInsertServiceBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertServiceBillMouseEntered
        btnInsertServiceBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnInsertServiceBillMouseEntered

    private void btnInsertServiceBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertServiceBillMouseExited
        btnInsertServiceBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnInsertServiceBillMouseExited

    private void btnUpdateServiceBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateServiceBillMouseEntered
        btnUpdateServiceBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnUpdateServiceBillMouseEntered

    private void btnUpdateServiceBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateServiceBillMouseExited
        btnUpdateServiceBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnUpdateServiceBillMouseExited

    private void btnDeleteServiceBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteServiceBillMouseEntered
        btnDeleteServiceBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnDeleteServiceBillMouseEntered

    private void btnDeleteServiceBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteServiceBillMouseExited
        btnDeleteServiceBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnDeleteServiceBillMouseExited

    private void btnSaveServiceBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveServiceBillMouseEntered
        btnSaveServiceBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnSaveServiceBillMouseEntered

    private void btnSaveServiceBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveServiceBillMouseExited
        btnSaveServiceBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnSaveServiceBillMouseExited

    private void btnCancelServiceBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelServiceBillMouseEntered
        btnCancelServiceBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnCancelServiceBillMouseEntered

    private void btnCancelServiceBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelServiceBillMouseExited
        btnCancelServiceBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnCancelServiceBillMouseExited

    private void btnInsertMedicineBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMedicineBillMouseEntered
        btnInsertMedicineBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnInsertMedicineBillMouseEntered

    private void btnInsertMedicineBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMedicineBillMouseExited
        btnInsertMedicineBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnInsertMedicineBillMouseExited

    private void btnUpdateMedicineBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMedicineBillMouseEntered
        btnUpdateMedicineBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnUpdateMedicineBillMouseEntered

    private void btnUpdateMedicineBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMedicineBillMouseExited
        btnUpdateMedicineBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnUpdateMedicineBillMouseExited

    private void btnDeleteMedicineBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMedicineBillMouseEntered
        btnDeleteMedicineBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnDeleteMedicineBillMouseEntered

    private void btnDeleteMedicineBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMedicineBillMouseExited
        btnDeleteMedicineBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnDeleteMedicineBillMouseExited

    private void btnSaveMedicineBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMedicineBillMouseEntered
        btnSaveMedicineBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnSaveMedicineBillMouseEntered

    private void btnSaveMedicineBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMedicineBillMouseExited
        btnSaveMedicineBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnSaveMedicineBillMouseExited

    private void btnCancelMedicineBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMedicineBillMouseEntered
        btnCancelMedicineBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnCancelMedicineBillMouseEntered

    private void btnCancelMedicineBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMedicineBillMouseExited
        btnCancelMedicineBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnCancelMedicineBillMouseExited

    private void btnInsertTotalBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertTotalBillMouseEntered
        btnInsertTotalBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnInsertTotalBillMouseEntered

    private void btnInsertTotalBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertTotalBillMouseExited
        btnInsertTotalBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnInsertTotalBillMouseExited

    private void btnUpdateTotalBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateTotalBillMouseEntered
        btnUpdateTotalBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnUpdateTotalBillMouseEntered

    private void btnUpdateTotalBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateTotalBillMouseExited
        btnUpdateTotalBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnUpdateTotalBillMouseExited

    private void btnDeleteTotalBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteTotalBillMouseEntered
        btnDeleteTotalBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnDeleteTotalBillMouseEntered

    private void btnDeleteTotalBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteTotalBillMouseExited
        btnDeleteTotalBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnDeleteTotalBillMouseExited

    private void btnSaveTotalBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveTotalBillMouseEntered
        btnSaveTotalBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnSaveTotalBillMouseEntered

    private void btnSaveTotalBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveTotalBillMouseExited
        btnSaveTotalBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnSaveTotalBillMouseExited

    private void btnCancelTotalBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelTotalBillMouseEntered
        btnCancelTotalBill.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnCancelTotalBillMouseEntered

    private void btnCancelTotalBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelTotalBillMouseExited
        btnCancelTotalBill.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnCancelTotalBillMouseExited

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged
        new Drag(kGradientPanel1).moveWindow(evt);
    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed
        new Drag(kGradientPanel1).onPress(evt);
    }//GEN-LAST:event_kGradientPanel1MousePressed

    private void barAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barAboutMouseClicked
        bar(bar8);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
        jInternalFrame7.setVisible(false);
        jInternalFrame8.setVisible(true);
    }//GEN-LAST:event_barAboutMouseClicked

    private void barAboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barAboutMouseEntered
        barAbout.setBackground(Color.decode("#374785"));
        bar(bar8);
    }//GEN-LAST:event_barAboutMouseEntered

    private void barAboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barAboutMouseExited
        barAbout.setBackground(Color.decode("#24305E"));
    }//GEN-LAST:event_barAboutMouseExited

    private void txtSpecializedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpecializedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSpecializedActionPerformed

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
        getSelectLastBS();
    }//GEN-LAST:event_jLabel102MouseClicked

    private void jLabel108MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel108MouseClicked
        getSelectNextBS();
    }//GEN-LAST:event_jLabel108MouseClicked

    private void jLabel107MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel107MouseClicked
        getSelectPreviousBS();
    }//GEN-LAST:event_jLabel107MouseClicked

    private void jLabel106MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel106MouseClicked
        getSelectFirstBS();
    }//GEN-LAST:event_jLabel106MouseClicked

    private void btnCancelDoctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelDoctorMouseExited
        btnCancelDoctor.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnCancelDoctorMouseExited

    private void btnCancelDoctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelDoctorMouseEntered
        btnCancelDoctor.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnCancelDoctorMouseEntered

    private void btnCancelDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelDoctorMouseClicked

        txtIDDoctor.setText("");
        txtNameDoctor.setText("");
        txtSpecialized.setText("");
        btnUpdateDoctor.setEnabled(true);
        btnDeleteDoctor.setEnabled(true);
        btnInsertDoctor.setEnabled(true);
        flag = 0;
    }//GEN-LAST:event_btnCancelDoctorMouseClicked

    private void btnSaveDoctorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveDoctorMousePressed

    }//GEN-LAST:event_btnSaveDoctorMousePressed

    private void btnSaveDoctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveDoctorMouseExited
        btnSaveDoctor.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnSaveDoctorMouseExited

    private void btnSaveDoctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveDoctorMouseEntered
        btnSaveDoctor.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnSaveDoctorMouseEntered

    private void btnSaveDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveDoctorMouseClicked
        if(flag == 0)
        {
            JOptionPane.showMessageDialog(null, "Mời chọn chức năng");
        }
        else if(flag == 1) {
            InsertDataBS();
            btnInsertDoctor.setEnabled(true);
            btnUpdateDoctor.setEnabled(true);
            btnDeleteDoctor.setEnabled(true);
            btnCancelDoctor.setEnabled(true);
        }
        else if(flag == 2){
            UpdateDataBS();
            btnInsertDoctor.setEnabled(true);
            btnUpdateDoctor.setEnabled(true);
            btnDeleteDoctor.setEnabled(true);
            btnCancelDoctor.setEnabled(true);
        }
        else if(flag == 3){
            DeleteDataBS();
            btnInsertDoctor.setEnabled(true);
            btnUpdateDoctor.setEnabled(true);
            btnDeleteDoctor.setEnabled(true);
            btnCancelDoctor.setEnabled(true);
        }
        flag = 0;
    }//GEN-LAST:event_btnSaveDoctorMouseClicked

    private void btnDeleteDoctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteDoctorMouseExited
        btnDeleteDoctor.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnDeleteDoctorMouseExited

    private void btnDeleteDoctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteDoctorMouseEntered
        btnDeleteDoctor.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnDeleteDoctorMouseEntered

    private void btnDeleteDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteDoctorMouseClicked
        txtIDDoctor.setText("");
        txtNameDoctor.setText("");
        txtSpecialized.setText("");
        btnSaveDoctor.setEnabled(true);
        flag = 3;
        btnUpdateDoctor.setEnabled(false);
        btnDeleteDoctor.setEnabled(false);
        btnInsertDoctor.setEnabled(false);
        btnCancelDoctor.setEnabled(true);
    }//GEN-LAST:event_btnDeleteDoctorMouseClicked

    private void btnUpdateDoctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateDoctorMouseExited
        btnUpdateDoctor.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnUpdateDoctorMouseExited

    private void btnUpdateDoctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateDoctorMouseEntered
        btnUpdateDoctor.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnUpdateDoctorMouseEntered

    private void btnUpdateDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateDoctorMouseClicked
        txtIDDoctor.setText("");
        txtNameDoctor.setText("");
        txtSpecialized.setText("");
        btnSaveDoctor.setEnabled(true);
        flag = 2;
        btnUpdateDoctor.setEnabled(false);
        btnDeleteDoctor.setEnabled(false);
        btnInsertDoctor.setEnabled(false);
        btnCancelDoctor.setEnabled(true);
    }//GEN-LAST:event_btnUpdateDoctorMouseClicked

    private void btnInsertDoctorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertDoctorMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertDoctorMousePressed

    private void btnInsertDoctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertDoctorMouseExited
        btnInsertDoctor.setBackground(Color.decode("#F79E02"));
    }//GEN-LAST:event_btnInsertDoctorMouseExited

    private void btnInsertDoctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertDoctorMouseEntered
        btnInsertDoctor.setBackground(Color.decode("#FCCD04"));
    }//GEN-LAST:event_btnInsertDoctorMouseEntered

    //-----------------------------------------------------//
//--------------------BUTTON--------------------------//
//---------------------------------------------------//
    //DOCTOR
    private void btnInsertDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertDoctorMouseClicked
        txtIDDoctor.setText("");
        txtNameDoctor.setText("");
        txtSpecialized.setText("");
        btnSaveDoctor.setEnabled(true);
        flag = 1;
        btnUpdateDoctor.setEnabled(false);
        btnDeleteDoctor.setEnabled(false);
        btnInsertDoctor.setEnabled(false);
        btnCancelDoctor.setEnabled(true);

    }//GEN-LAST:event_btnInsertDoctorMouseClicked


    public void bar( JLabel lab)
    {
        bar1.setOpaque(false);
        bar2.setOpaque(false);
        bar3.setOpaque(false);
        bar4.setOpaque(false);
        bar5.setOpaque(false);
        bar6.setOpaque(false);
        bar7.setOpaque(false);
        bar8.setOpaque(false);
        lab.setOpaque(true);
        bar.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser ChooserBirthday;
    private javax.swing.JPanel bar;
    private javax.swing.JLabel bar1;
    private javax.swing.JLabel bar2;
    private javax.swing.JLabel bar3;
    private javax.swing.JLabel bar4;
    private javax.swing.JLabel bar5;
    private javax.swing.JLabel bar6;
    private javax.swing.JLabel bar7;
    private javax.swing.JLabel bar8;
    private javax.swing.JPanel barAbout;
    private javax.swing.JPanel barDoctor;
    private javax.swing.JPanel barMedicine;
    private javax.swing.JPanel barMedicineBill;
    private javax.swing.JPanel barPatient;
    private javax.swing.JPanel barService;
    private javax.swing.JPanel barServiceBill;
    private javax.swing.JPanel barTotalBill;
    private javax.swing.JLabel btnCancelDoctor;
    private javax.swing.JLabel btnCancelMedicine;
    private javax.swing.JLabel btnCancelMedicineBill;
    private javax.swing.JLabel btnCancelPatient;
    private javax.swing.JLabel btnCancelService;
    private javax.swing.JLabel btnCancelServiceBill;
    private javax.swing.JLabel btnCancelTotalBill;
    private javax.swing.JLabel btnDeleteDoctor;
    private javax.swing.JLabel btnDeleteMedicine;
    private javax.swing.JLabel btnDeleteMedicineBill;
    private javax.swing.JLabel btnDeletePatient;
    private javax.swing.JLabel btnDeleteService;
    private javax.swing.JLabel btnDeleteServiceBill;
    private javax.swing.JLabel btnDeleteTotalBill;
    private javax.swing.JLabel btnInsertDoctor;
    private javax.swing.JLabel btnInsertMedicine;
    private javax.swing.JLabel btnInsertMedicineBill;
    private javax.swing.JLabel btnInsertPatient;
    private javax.swing.JLabel btnInsertService;
    private javax.swing.JLabel btnInsertServiceBill;
    private javax.swing.JLabel btnInsertTotalBill;
    private javax.swing.JLabel btnSaveDoctor;
    private javax.swing.JLabel btnSaveMedicine;
    private javax.swing.JLabel btnSaveMedicineBill;
    private javax.swing.JLabel btnSavePatient;
    private javax.swing.JLabel btnSaveService;
    private javax.swing.JLabel btnSaveServiceBill;
    private javax.swing.JLabel btnSaveTotalBill;
    private javax.swing.JLabel btnUpdateDoctor;
    private javax.swing.JLabel btnUpdateMedicine;
    private javax.swing.JLabel btnUpdateMedicineBill;
    private javax.swing.JLabel btnUpdatePatient;
    private javax.swing.JLabel btnUpdateService;
    private javax.swing.JLabel btnUpdateServiceBill;
    private javax.swing.JLabel btnUpdateTotalBill;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JInternalFrame jInternalFrame7;
    private javax.swing.JInternalFrame jInternalFrame8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator40;
    private javax.swing.JSeparator jSeparator41;
    private javax.swing.JSeparator jSeparator42;
    private javax.swing.JSeparator jSeparator43;
    private javax.swing.JSeparator jSeparator44;
    private javax.swing.JSeparator jSeparator45;
    private javax.swing.JSeparator jSeparator46;
    private javax.swing.JSeparator jSeparator47;
    private javax.swing.JSeparator jSeparator48;
    private javax.swing.JSeparator jSeparator49;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator50;
    private javax.swing.JSeparator jSeparator51;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    private javax.swing.JTable tblListDoctor;
    private javax.swing.JTable tblListMedicine;
    private javax.swing.JTable tblListMedicineBill;
    private javax.swing.JTable tblListPatient;
    private javax.swing.JTable tblListService;
    private javax.swing.JTable tblListServiceBill;
    private javax.swing.JTable tblListTotalBill;
    private javax.swing.JTextField txtAboutAddress;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAddressMedicineBill;
    private javax.swing.JTextField txtAddressServiceBill;
    private javax.swing.JTextField txtAddressTotalBill;
    private javax.swing.JTextField txtBirthdayMedicineBill;
    private javax.swing.JTextField txtBirthdayTotalBill;
    private javax.swing.JTextField txtBirthdayrServiceBill;
    private javax.swing.JTextField txtDosage;
    private javax.swing.JTextField txtDosageMedicineBill;
    private javax.swing.JTextField txtExpiryDate;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtGenderMedicineBill;
    private javax.swing.JTextField txtGenderServiceBill;
    private javax.swing.JTextField txtGenderTotalBill;
    private javax.swing.JTextField txtHealthInsurance;
    private javax.swing.JTextField txtHealthInsuranceMedicineBill;
    private javax.swing.JTextField txtHealthInsuranceServiceBill;
    private javax.swing.JTextField txtHealthInsuranceTotalBill;
    private javax.swing.JTextField txtIDDoctor;
    private javax.swing.JTextField txtIDDoctorMedicineBill;
    private javax.swing.JTextField txtIDDoctorServiceBill;
    private javax.swing.JTextField txtIDMedicine;
    private javax.swing.JTextField txtIDMedicineBill;
    private javax.swing.JTextField txtIDMedicineMedicineBill;
    private javax.swing.JTextField txtIDMedicineTotalBill;
    private javax.swing.JTextField txtIDPatient;
    private javax.swing.JTextField txtIDPatientMedicineBill;
    private javax.swing.JTextField txtIDPatientServiceBill;
    private javax.swing.JTextField txtIDPatientTotalBill;
    private javax.swing.JTextField txtIDService;
    private javax.swing.JTextField txtIDServiceBill;
    private javax.swing.JTextField txtIDServiceServiceBill;
    private javax.swing.JTextField txtIDServiceTotalBill;
    private javax.swing.JTextField txtIDTotalBill;
    private javax.swing.JTextField txtMedicinePrices;
    private javax.swing.JTextField txtNameDoctor;
    private javax.swing.JTextField txtNameDoctorMedicineBill;
    private javax.swing.JTextField txtNameDoctorServiceBill;
    private javax.swing.JTextField txtNameMedicine;
    private javax.swing.JTextField txtNamePatient;
    private javax.swing.JTextField txtNamePatientMedicineBill;
    private javax.swing.JTextField txtNamePatientServiceBill;
    private javax.swing.JTextField txtNamePatientTotalBill;
    private javax.swing.JTextField txtNameService;
    private javax.swing.JTextField txtServiceBillPrices;
    private javax.swing.JTextField txtServicePrices;
    private javax.swing.JTextField txtSpecialized;
    private javax.swing.JTextField txtTotalPricesMedicineBill;
    private javax.swing.JTextField txtTotalPricesTotalBill;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
