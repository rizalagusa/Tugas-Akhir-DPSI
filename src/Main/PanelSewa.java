package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class PanelSewa extends javax.swing.JPanel {
    FormContainer container;
    
    DefaultTableModel defaultTableInvoice, defaultTableBuku;
    
    Connection conn       = null;
    ResultSet rs          = null;
    PreparedStatement pst = null;
    
    private int id, barisBuku, barisInvoice, total;
    /**
     * Creates new form PanelPinjam
     * @param container
     */
    public PanelSewa(FormContainer container) {
        initComponents();
        this.container = container;
        this.conn      = MySQLConnection.ConnectDb();
        
        defaultTableInvoice = new DefaultTableModel(new String[]{"Kode", "Judul Buku", "Lama Peminjaman", "Harga"}, 0);
        
        defaultTableBuku = new DefaultTableModel(new String[]{"No.", "ID Buku", "Kode Buku", 
            "Judul Buku", "Penulis", "Penerbit", "Tahun Terbit", "Stok", "Jenis Buku", "Harga Sewa"}, 0);
        getAllBook();
        
        
        tblInvoice.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                hitungTotalHarga();
            }
        });
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
        panelHeaderSewa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inJudul = new javax.swing.JTextField();
        labelJudul = new javax.swing.JLabel();
        inKode = new javax.swing.JTextField();
        labelKode = new javax.swing.JLabel();
        inPenulis = new javax.swing.JTextField();
        labelPenulis = new javax.swing.JLabel();
        panelFooterSewa = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        panelHeaderInvoice = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelFooterInvoice = new javax.swing.JPanel();
        btnSewa = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        labelJudul4 = new javax.swing.JLabel();
        textHarga = new javax.swing.JLabel();
        panelInvoice = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInvoice = new javax.swing.JTable();
        panelTable1 = new javax.swing.JLayeredPane();
        panelTableHeader = new javax.swing.JLayeredPane();
        jLabel12 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuku = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(910, 697));

        panelHeaderSewa.setMinimumSize(new java.awt.Dimension(450, 55));
        panelHeaderSewa.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setText("Penyewaan Buku");
        panelHeaderSewa.add(jLabel1, new java.awt.GridBagConstraints());

        inJudul.setBorder(null);
        inJudul.setCaretColor(new java.awt.Color(255, 255, 255));

        labelJudul.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelJudul.setForeground(new java.awt.Color(57, 113, 177));
        labelJudul.setText("Judul");

        inKode.setBorder(null);
        inKode.setCaretColor(new java.awt.Color(255, 255, 255));

        labelKode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelKode.setForeground(new java.awt.Color(57, 113, 177));
        labelKode.setText("Kode");

        inPenulis.setBorder(null);
        inPenulis.setCaretColor(new java.awt.Color(255, 255, 255));

        labelPenulis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPenulis.setForeground(new java.awt.Color(57, 113, 177));
        labelPenulis.setText("Penuilis");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFooterSewaLayout = new javax.swing.GroupLayout(panelFooterSewa);
        panelFooterSewa.setLayout(panelFooterSewaLayout);
        panelFooterSewaLayout.setHorizontalGroup(
            panelFooterSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFooterSewaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelFooterSewaLayout.setVerticalGroup(
            panelFooterSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFooterSewaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFooterSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(btnReset))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelHeaderSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFooterSewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labelKode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inJudul)
                                    .addComponent(inKode)
                                    .addComponent(inPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelHeaderSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJudul))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inKode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKode))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPenulis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelFooterSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelHeaderInvoice.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setText("Invoice");
        panelHeaderInvoice.add(jLabel2, new java.awt.GridBagConstraints());

        btnSewa.setText("Sewa");
        btnSewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSewaActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        labelJudul4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelJudul4.setForeground(new java.awt.Color(57, 113, 177));
        labelJudul4.setText("Total Harga");

        textHarga.setText("Rp 0");

        javax.swing.GroupLayout panelFooterInvoiceLayout = new javax.swing.GroupLayout(panelFooterInvoice);
        panelFooterInvoice.setLayout(panelFooterInvoiceLayout);
        panelFooterInvoiceLayout.setHorizontalGroup(
            panelFooterInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFooterInvoiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHapus)
                .addGap(92, 92, 92)
                .addComponent(labelJudul4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(btnSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelFooterInvoiceLayout.setVerticalGroup(
            panelFooterInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFooterInvoiceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFooterInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFooterInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelJudul4)
                        .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFooterInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSewa)
                        .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelInvoice.setMaximumSize(new java.awt.Dimension(518, 167));
        panelInvoice.setMinimumSize(new java.awt.Dimension(518, 167));

        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode", "Judul Buku", "Lama Peminjaman", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblInvoice);
        if (tblInvoice.getColumnModel().getColumnCount() > 0) {
            tblInvoice.getColumnModel().getColumn(0).setResizable(false);
            tblInvoice.getColumnModel().getColumn(1).setResizable(false);
            tblInvoice.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout panelInvoiceLayout = new javax.swing.GroupLayout(panelInvoice);
        panelInvoice.setLayout(panelInvoiceLayout);
        panelInvoiceLayout.setHorizontalGroup(
            panelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        panelInvoiceLayout.setVerticalGroup(
            panelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelInvoice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelHeaderInvoice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelFooterInvoice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panelHeaderInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFooterInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText(" Daftar Buku");

        btnTambah.setText("Tambahkan");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        panelTableHeader.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelTableHeader.setLayer(btnTambah, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelTableHeaderLayout = new javax.swing.GroupLayout(panelTableHeader);
        panelTableHeader.setLayout(panelTableHeaderLayout);
        panelTableHeaderLayout.setHorizontalGroup(
            panelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTambah)
                .addContainerGap())
        );
        panelTableHeaderLayout.setVerticalGroup(
            panelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTableHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTableHeaderLayout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                " No.", "Nama Peminjam", "Judul Buku", "Tanggal Pinjam", "Tanggal Kembali", "Denda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBuku);

        panelTable1.setLayer(panelTableHeader, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelTable1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelTable1Layout = new javax.swing.GroupLayout(panelTable1);
        panelTable1.setLayout(panelTable1Layout);
        panelTable1Layout.setHorizontalGroup(
            panelTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTableHeader)
            .addComponent(jScrollPane1)
        );
        panelTable1Layout.setVerticalGroup(
            panelTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTable1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTableHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelTable1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
            tambahBuku(id);
            hitungTotalHarga();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String judul = inJudul.getText(),
                kode = inKode.getText(),
                penulis = inPenulis.getText();
        
        searchBook(judul, kode, penulis);
    }//GEN-LAST:event_btnCariActionPerformed

    private void tblBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBukuMouseClicked
        barisBuku = tblBuku.getSelectedRow();
        id = Integer.parseInt(tblBuku.getModel().getValueAt(barisBuku, 1).toString());
    }//GEN-LAST:event_tblBukuMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
         barisInvoice = tblInvoice.getSelectedRow();
         defaultTableInvoice.removeRow(barisInvoice);
         hitungTotalHarga();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        inJudul.setText("");
        inKode.setText("");
        inPenulis.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSewaActionPerformed
        String nama = JOptionPane.showInputDialog(this, "Masukan nama :");
        long tanggalPeminjaman = System.currentTimeMillis() / 1000L;
        long tanggalKembali    = tanggalPeminjaman + TimeUnit.DAYS.toMillis(1) / 1000L;
        
        String kode;
        int id, lamaPeminjaman, harga, stok;
        for (int i = 0; i < tblInvoice.getRowCount(); i++) {
            kode = String.valueOf(tblInvoice.getValueAt(i, 0));
            id = getBukuId(kode);
            lamaPeminjaman = Integer.parseInt(tblInvoice.getValueAt(i, 2)+ "");
            harga = Integer.parseInt(tblInvoice.getValueAt(i, 3) + "") * lamaPeminjaman;
            stok = getBukuStok(id);
            stok = stok - 1;
            sewaBuku(nama, id, lamaPeminjaman, harga, tanggalPeminjaman, tanggalKembali);
            updateBukuStok(id, stok);
        }
        getAllBook();
        defaultTableInvoice.setRowCount(0);
    }//GEN-LAST:event_btnSewaActionPerformed

    public void getAllBook(){
        defaultTableBuku.setRowCount(0);
        int no = 1, id, tahun, stok, harga;
        String judul, kode, penulis, penerbit, jenis;
        String query = "SELECT * FROM tbl_buku";
        try {
            pst = conn.prepareStatement(query);
            rs  = pst.executeQuery();
            while(rs.next()){
                id       = rs.getInt("buk_id");
                judul    = rs.getString("buk_judul");
                kode     = rs.getString("buk_kode");
                tahun    = rs.getInt("buk_tahun");
                penulis  = rs.getString("buk_penulis");
                penerbit = rs.getString("buk_penerbit");
                stok     = rs.getInt("buk_stok");
                jenis    = rs.getString("buk_jenis");
                harga    = rs.getInt("buk_harga");
                
                defaultTableBuku.addRow(new Object[]{no, id, kode, judul, penulis, penerbit, tahun, stok, jenis, harga});
                no++;
            }
            tblBuku.setModel(defaultTableBuku);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void hitungTotalHarga(){
        total = 0;
        int selectedRowHarga, jumlahHari;
        for (int i = 0; i < tblInvoice.getRowCount(); i++) {
            selectedRowHarga = Integer.parseInt(tblInvoice.getValueAt(i, 3) + "");
            jumlahHari = Integer.parseInt(tblInvoice.getValueAt(i, 2) + "");
            total = (selectedRowHarga * jumlahHari) + total;
            textHarga.setText("Rp" + total);
        }
    }
    
    public void searchBook(String inJudul, String inKode, String inPenulis){
        defaultTableBuku.setRowCount(0);
        
        int no = 1, id, tahun, stok, harga;
        String judul, kode, penulis, penerbit, jenis;
        
        String query = "SELECT * FROM tbl_buku WHERE buk_judul LIKE ? OR buk_penulis LIKE ? OR buk_kode LIKE ?";
        
        if(inJudul.isEmpty() && inKode.isEmpty() && inPenulis.isEmpty()){
            getAllBook();
            return;
        }
        
        try {
            pst = conn.prepareStatement(query);
            if(!inJudul.isEmpty()){
                pst.setString(1, "%" + inJudul + "%");
            }else {
                pst.setString(1, "");
            }
            
            if(!inPenulis.isEmpty()){
                pst.setString(2, "%" + inPenulis + "%");
            }else {
                pst.setString(2, "");
            }
            
            if(!inKode.isEmpty()){
                pst.setString(3, "%" + inKode + "%");
            }else{
                pst.setString(3, "");
            }
            
            
            rs = pst.executeQuery();
            while(rs.next()){
                id       = rs.getInt("buk_id");
                judul    = rs.getString("buk_judul");
                kode     = rs.getString("buk_kode");
                tahun    = rs.getInt("buk_tahun");
                penulis  = rs.getString("buk_penulis");
                penerbit = rs.getString("buk_penerbit");
                stok     = rs.getInt("buk_stok");
                jenis    = rs.getString("buk_jenis");
                harga    = rs.getInt("buk_harga");
                
                defaultTableBuku.addRow(new Object[]{no, id, kode, judul, penulis, penerbit, tahun, stok, jenis, harga});
                no++;
            }
            tblBuku.setModel(defaultTableBuku);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR : terjadi kesalahan sistem.");
        }
    }

    public void tambahBuku(int id){
        String judul, kode;
        int harga;
        String query = "SELECT * FROM tbl_buku WHERE buk_id = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            rs  = pst.executeQuery();
            
            while(rs.next()){
                judul    = rs.getString("buk_judul");
                kode     = rs.getString("buk_kode");
                harga    = rs.getInt("buk_harga");
                defaultTableInvoice.addRow(new Object[]{kode, judul, 1,harga});
            }
            tblInvoice.setModel(defaultTableInvoice);
        } catch (SQLException ex) {
            Logger.getLogger(PanelBuku.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Terjadi kesalahan sistem.");
        }
    }
    
    public void sewaBuku(String nama, int id, int lamaPeminjaman, int harga, long tanggalPinjam, long tanggalKembali){
        String query = "INSERT INTO tbl_sewa(buk_id, sew_nama, sew_lamaPeminjaman, sew_tanggalPinjam, sew_tanggalKembali, sew_totalHarga, sew_denda, sew_status) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, nama);
            pst.setInt(3, lamaPeminjaman);
            pst.setLong(4, tanggalPinjam);
            pst.setLong(5, tanggalKembali);
            pst.setInt(6, harga);
            pst.setInt(7, 0);
            pst.setString(8, "Pinjam");
            
            if(pst.executeUpdate() != 0){
                System.out.println("Sewa berhasil");
            }else{
                System.out.println("Sewa gagal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR : terjadi kesalahan sistem");
        }
        
    }
    
    public int getBukuId(String kode){
        int idBuku = 0;
        String query = "SELECT buk_id FROM tbl_buku WHERE buk_kode = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, kode);
            rs = pst.executeQuery();
            while(rs.next()){
                idBuku = rs.getInt("buk_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idBuku;
    }
    
    public int getBukuStok(int id){
        int stok = 0;
        String sql = "SELECT buk_stok FROM tbl_buku WHERE buk_id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                stok = rs.getInt("buk_stok");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR : terjadi kesalahan saat mengambil stok buku");
        }
        
        return stok;
    }
    
    public void updateBukuStok(int id, int stok){
        String sql = "UPDATE tbl_buku SET buk_stok = ? WHERE buk_id = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setInt(1, stok);
            pst.setInt(2, id);
            
            if(pst.executeUpdate() != 0){
                System.out.println("Update stok berhasil");
            }else{
                System.out.println("Update stok gagal");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("ERROR : terjadi kesalahan sistem saat update stok buku");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSewa;
    private javax.swing.JButton btnTambah;
    private javax.swing.JTextField inJudul;
    private javax.swing.JTextField inKode;
    private javax.swing.JTextField inPenulis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JLabel labelJudul4;
    private javax.swing.JLabel labelKode;
    private javax.swing.JLabel labelPenulis;
    private javax.swing.JPanel panelFooterInvoice;
    private javax.swing.JPanel panelFooterSewa;
    private javax.swing.JPanel panelHeaderInvoice;
    private javax.swing.JPanel panelHeaderSewa;
    private javax.swing.JPanel panelInvoice;
    private javax.swing.JLayeredPane panelTable1;
    private javax.swing.JLayeredPane panelTableHeader;
    private javax.swing.JTable tblBuku;
    private javax.swing.JTable tblInvoice;
    private javax.swing.JLabel textHarga;
    // End of variables declaration//GEN-END:variables
}
