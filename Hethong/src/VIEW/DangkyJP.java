/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package VIEW;
import Connection.Connect;
import DAO.DANGKYDAO;
import DAO.HOCVIENDAO;
import Model.DangKy;
import Model.Hocvien;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Acer
 */
public class DangkyJP extends javax.swing.JPanel {
     DefaultTableModel tbtModel;
     private TableRowSorter<TableModel> rowSorter = null;

    public DangkyJP() {
        initComponents();
        initcbbMaHV();
        initcbbMaLHP();
        Loadulieu();
    }
 //Khởi tạo cho cbb Mã Học viên
    private void initcbbMaHV() {
        try {
            String sql = "Select MaHV from HocVien";
            Connection conn = Connect.openConnect();
            PreparedStatement pm = conn.prepareStatement(sql);
            ResultSet rs = pm.executeQuery();
            cbbMaHV.removeAllItems();
            while (rs.next()) {
                cbbMaHV.addItem(rs.getString("MaHV"));
            }
            rs.close();
            pm.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }
    
    //Khởi tạo cho cbb Mã Lớp HP
     private void initcbbMaLHP() {
        try {
            String sql = "Select MaLHP from LopHP";
            Connection conn = Connect.openConnect();
            PreparedStatement pm = conn.prepareStatement(sql);
            ResultSet rs = pm.executeQuery();
            cbbMaLHP.removeAllItems();
            while (rs.next()) {
                cbbMaLHP.addItem(rs.getString("MaLHP"));
            }
            rs.close();
            pm.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    
      
    }
    
     public void Loadulieu() {
        try {
            tbl_dk.removeAll();
            String[] arr = {"Mã HV", "Mã LHP","Ngày đăng ký", "Khuyến mãi","Xếp loại","Chứng chỉ"};
            tbtModel = new DefaultTableModel(arr, 0);
            String sql = "SELECT * FROM DangKy";
            Connection conn = Connect.openConnect();
            PreparedStatement pm = conn.prepareStatement(sql);
            ResultSet rs = pm.executeQuery();
            tbtModel.setRowCount(0);
            while (rs.next()) {
                String[] row = new String[]
            {
                    rs.getString("MaHV"), 
                    rs.getString("MaLHP"),
                    rs.getString("NgayDk"),
                    rs.getString("Khuyenmai"),
                     rs.getString("Xeploai"),
                    rs.getString("Chungchi")};
                
                tbtModel.addRow(row);
            }
            tbl_dk.setModel(tbtModel);
            tbl_dk.setAutoCreateRowSorter(true);
            tbl_dk.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
            tbl_dk.getTableHeader().setPreferredSize(new Dimension(100, 50));
            tbtModel.fireTableDataChanged();
            Connect.CloseConnect(conn);
            
             rowSorter = new TableRowSorter<>(tbl_dk.getModel());
            tbl_dk.setRowSorter(rowSorter);
            
            jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblDong2 = new javax.swing.JLabel();
        lblDong3 = new javax.swing.JLabel();
        lblDong1 = new javax.swing.JLabel();
        txtNgayDk = new javax.swing.JTextField();
        lblDong4 = new javax.swing.JLabel();
        cbbXeploai = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        lblDong5 = new javax.swing.JLabel();
        lblDong6 = new javax.swing.JLabel();
        txtKhuyenmai = new javax.swing.JTextField();
        cbbchungchi = new javax.swing.JComboBox<>();
        cbbMaLHP = new javax.swing.JComboBox<>();
        cbbMaHV = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dk = new javax.swing.JTable();
        jtfSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1570, 970));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1580, 970));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("#9Slide03 Neutra", 1, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(118, 109, 200));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ ĐĂNG KÝ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(384, 384, 384))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(238, 237, 250));

        lblDong2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDong2.setText("Mã HV:");

        lblDong3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDong3.setText("Mã LHP:");

        lblDong1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDong1.setText("Ngày ĐK:");

        txtNgayDk.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lblDong4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDong4.setText("Xếp loại:");

        cbbXeploai.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cbbXeploai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));

        btnThem.setBackground(new java.awt.Color(190, 219, 171));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/A.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 242, 176));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/F.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(255, 183, 175));
        btnxoa.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/D.png"))); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        lblDong5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDong5.setText("Chứng chỉ:");

        lblDong6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDong6.setText("Khuyến mãi:");

        txtKhuyenmai.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        cbbchungchi.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cbbchungchi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JD bac 1", "JD bac 2", "JD bac 3", "JD bac 4", "JD bac 5" }));

        cbbMaLHP.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cbbMaLHP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));

        cbbMaHV.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cbbMaHV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDong3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblDong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblDong4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblDong1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblDong5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbXeploai, javax.swing.GroupLayout.Alignment.TRAILING, 0, 222, Short.MAX_VALUE)
                                            .addComponent(txtNgayDk, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbbMaLHP, 0, 222, Short.MAX_VALUE)
                                            .addComponent(cbbMaHV, javax.swing.GroupLayout.Alignment.TRAILING, 0, 222, Short.MAX_VALUE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(cbbchungchi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblDong6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtKhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblDong2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbMaHV, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDong3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cbbMaLHP)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayDk)
                    .addComponent(lblDong1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbXeploai)
                    .addComponent(lblDong4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDong5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbchungchi))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDong6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKhuyenmai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua))
                .addGap(18, 18, 18)
                .addComponent(btnxoa)
                .addGap(48, 48, 48))
        );

        jPanel6.setBackground(new java.awt.Color(238, 237, 250));
        jPanel6.setPreferredSize(new java.awt.Dimension(796, 600));

        tbl_dk.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tbl_dk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MaHV", "Hoten", "NgaySinh", "GioiTinh", "SDT", "CCCD"
            }
        ));
        tbl_dk.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_dk);

        jtfSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(520, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(112, 112, 112)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
         StringBuilder sb = new StringBuilder();
          DangKy dk = new DangKy();
            DANGKYDAO dkd = new DANGKYDAO();
        if (cbbMaHV.getSelectedItem().equals("")||cbbMaLHP.getSelectedItem().equals(""))
        {
            sb.append("MaHV hoặc Mã LHP đang trống!\n");
            cbbMaHV.requestFocus();
            cbbMaLHP.requestFocus();
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
           

            String n1 = cbbMaHV.getItemAt(cbbMaHV.getSelectedIndex());
            dk.setMaHV(n1);
            String n2 = cbbMaLHP.getItemAt(cbbMaLHP.getSelectedIndex());
            dk.setMaLHP(n2);
            dk.setNgayDk((txtNgayDk.getText()));
            dk.setKhuyenmai((txtKhuyenmai.getText()));
            String n3 = cbbXeploai.getItemAt(cbbXeploai.getSelectedIndex());
            dk.setXeploai(n3);
             String n4 = cbbchungchi.getItemAt(cbbchungchi.getSelectedIndex());
            dk.setChungchi(n4);

            dkd.insert(dk);
            Loadulieu();
            JOptionPane.showMessageDialog(this, "Thêm đăng ký thành công!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Không thể thêm đăng ký!");
            if(e.getMessage().equals("The transaction ended in the trigger. The batch has been aborted.")){
                JOptionPane.showMessageDialog(this, "Error: " + "Ngày đăng ký đang trễ hơn ngày bắt đầu học, vui lòng nhập lại!");
            } else
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
       StringBuilder sb = new StringBuilder();
         DangKy dk = new DangKy();
            DANGKYDAO dkup = new DANGKYDAO();

         if (cbbMaHV.getSelectedItem().equals("")||cbbMaLHP.getSelectedItem().equals(""))
        {
            sb.append("MaHV hoặc MaLHP đang trống!\n");
            cbbMaHV.requestFocus();
            cbbMaLHP.requestFocus();
        }
        if (sb.length() > 0)
        {
            JOptionPane.showMessageDialog(this, sb.toString(), "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
           
            String n1 = cbbMaHV.getItemAt(cbbMaHV.getSelectedIndex());
            dk.setMaHV(n1);
            String n2 = cbbMaLHP.getItemAt(cbbMaLHP.getSelectedIndex());
            dk.setMaLHP(n2);
            dk.setNgayDk((txtNgayDk.getText()));
            dk.setKhuyenmai((txtKhuyenmai.getText()));
            String n3 = cbbXeploai.getItemAt(cbbXeploai.getSelectedIndex());
            dk.setXeploai(n3);
            String n4 = cbbchungchi.getItemAt(cbbchungchi.getSelectedIndex());
            dk.setChungchi(n4);


            dkup.Update(dk);
            Loadulieu();
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Cập nhật không thành công!");
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
         StringBuilder sb = new StringBuilder();
         if (cbbMaHV.getSelectedItem().equals("")||cbbMaLHP.getSelectedItem().equals(""))
        {
            sb.append("MaHV hoặc MaLHP đang trống!\n");
            cbbMaHV.requestFocus();
            cbbMaLHP.requestFocus();
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int dk = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa lượt đăng ký này", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (dk == JOptionPane.YES_OPTION) {
            try {
                DANGKYDAO dkd = new DANGKYDAO();
                if (dkd.Delete((String)cbbMaHV.getSelectedItem(),(String)cbbMaLHP.getSelectedItem())){
                    JOptionPane.showMessageDialog(this, "Xóa lượt đăng ký thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa lượt đăng ký thất bại");
                }
                Loadulieu();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnxoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cbbMaHV;
    private javax.swing.JComboBox<String> cbbMaLHP;
    private javax.swing.JComboBox<String> cbbXeploai;
    private javax.swing.JComboBox<String> cbbchungchi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JLabel lblDong1;
    private javax.swing.JLabel lblDong2;
    private javax.swing.JLabel lblDong3;
    private javax.swing.JLabel lblDong4;
    private javax.swing.JLabel lblDong5;
    private javax.swing.JLabel lblDong6;
    private javax.swing.JTable tbl_dk;
    private javax.swing.JTextField txtKhuyenmai;
    private javax.swing.JTextField txtNgayDk;
    // End of variables declaration//GEN-END:variables

    
}
