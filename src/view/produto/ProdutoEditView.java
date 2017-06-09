/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.produto;

import control.ProdutoController;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Produto;
import model.Supermercado;

/**
 *
 * @author Leo
 */
public class ProdutoEditView extends javax.swing.JDialog {

    /**
     * Creates new form AlunoEditView
     */
    
    private File imagem;
    
    public ProdutoEditView() {
        initComponents();
        
        List<Supermercado> supermercado = ProdutoController.getInstance().BuscarTodosMercados();
        jcbMercado.setModel(new DefaultComboBoxModel(supermercado.toArray()));
        jcbMercado.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jtfCod = new javax.swing.JTextField();
        jtfDescricao = new javax.swing.JTextField();
        jtfPreco = new javax.swing.JTextField();
        jcbMercado = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jbGravar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jlbImagem = new javax.swing.JLabel();
        jbAdicionarImagem = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Cod:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Descricao:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Preço:");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("Mercado:");

        jtfID.setEnabled(false);

        jtfNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jtfCod.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jtfDescricao.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jtfPreco.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jbGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/Save.png"))); // NOI18N
        jbGravar.setText("Gravar");
        jbGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGravarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/Abort.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGravar)
                    .addComponent(jButton2))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jbAdicionarImagem.setText("Adicionar Imagem");
        jbAdicionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarImagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbMercado, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAdicionarImagem)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jlbImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlbImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jbAdicionarImagem))
                    .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbMercado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    //Persistindo objeto no banco
    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed
        try {
                if(validation()){
                // Pega os dados informados nos campos cria um objeto produto e dispara o metodo de persitêcia na tela 
               
                ProdutoController.getInstance().persistir(getDados());

                JOptionPane.showMessageDialog(this, "Registro gravado com sucesso.");
                //Fecha a tela 
                dispose();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu o seguinte erro na gravação dos dados: " + ex.getMessage());
            }
    }//GEN-LAST:event_jbGravarActionPerformed

    
    
    //BEGIN Trabalhando com imagem
    
    private void jbAdicionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarImagemActionPerformed
        imagem = selecionarImagem();
        abrirImagem(imagem);
    }//GEN-LAST:event_jbAdicionarImagemActionPerformed

  
    //Abre a caixa de dialogo para selecionar o arquivo
    private File selecionarImagem(){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens em JPEG e PNG", "jpg","png");
        fileChooser.addChoosableFileFilter(filtro);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooser.setCurrentDirectory(new File("/"));
        fileChooser.showOpenDialog(this);
        
        return fileChooser.getSelectedFile();
    }
    
    //Retorna a imagem em forma de array contida no arquivo
    private byte[] getImagem(){
       boolean isPng = false;
       
       if(imagem != null){
         isPng = imagem.getName().endsWith("png");
         
           try {
               BufferedImage image = ImageIO.read(imagem);
               ByteArrayOutputStream out = new ByteArrayOutputStream();
               int type = BufferedImage.TYPE_INT_RGB;
               
               if(isPng){
                 type = BufferedImage.BITMASK;
               }
               
               BufferedImage novaImagem = new BufferedImage(jlbImagem.getWidth() - 5, jlbImagem.getHeight() - 10, type);
               Graphics2D g = novaImagem.createGraphics();
               g.setComposite(AlphaComposite.Src);
               g.drawImage(image, 0,0, jlbImagem.getWidth() - 5, jlbImagem.getHeight() - 10, null);
               
               if(isPng){
                 ImageIO.write(novaImagem, "png", out);
               }else{
                 ImageIO.write(novaImagem, "jpg", out);
               }
               
               out.flush();
               byte[] byteArray = out.toByteArray();
               out.close();
               
               return byteArray;
           } catch (IOException ex) {
               ex.printStackTrace();
           }
       }
       
       return null;
    }
    
    //END Trabalhando com imagem
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProdutoEditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoEditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoEditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoEditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoEditView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAdicionarImagem;
    private javax.swing.JButton jbGravar;
    private javax.swing.JComboBox jcbMercado;
    private javax.swing.JLabel jlbImagem;
    private javax.swing.JTextField jtfCod;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPreco;
    // End of variables declaration//GEN-END:variables

/**
     * Seta os dados do objeto Produto para os componentes da tela.
     *
     * @param produto
     */
    public void setDados(Produto produto) {
        
        jtfID.setText(produto.getId().toString());
        jtfCod.setText(produto.getCod());
        jtfNome.setText(produto.getNome());
        jtfDescricao.setText(produto.getDescricao());
        jtfPreco.setText(String.valueOf(produto.getPrecoCusto()));
        jcbMercado.getModel().setSelectedItem(produto.getSupermercado());
        
        //*********************************************************
        //Era para carregar a imagem quando pegar os dados do banco
        //ManipularImagem.exibiImagemLabel(produto.getFoto(), jlbImagem);
        //*********************************************************

    }
    
    
    
    //Carregando imagem quando o usuario faz o upload
    private void abrirImagem(Object source){
      if(source instanceof File){
         ImageIcon icon = new ImageIcon(imagem.getAbsolutePath());
         icon.setImage(icon.getImage().getScaledInstance(jlbImagem.getWidth() -5, jlbImagem.getHeight() - 10, 100));
         jlbImagem.setIcon(icon);
      }
    }
    
    /**
     * Pega os dados dos componentes da View e joga para o objeto Produto
     *
     * @return Produto
     */
    public Produto getDados() {
        
        Produto p = new Produto();

        /**
         * Verificacao para edição ou inserção jtfCodigo vazio = inserção
         * jtfCodigo com valor = edição
         */
        if (!jtfID.getText().equals("")) {
            p.setId(Long.parseLong(jtfID.getText()));
        }

        p.setNome(jtfNome.getText());
        p.setCod(jtfCod.getText());
        p.setDescricao(jtfDescricao.getText());
        p.setPrecoCusto(Float.parseFloat(jtfPreco.getText()));
        p.setSupermercado((Supermercado) jcbMercado.getSelectedItem());
        
        if(imagem != null){
          p.setFoto(getImagem());
        }
                  
        return p;
    }
    //Validação dos campos em obrigatórios
    private boolean validation(){
        if(jtfNome.getText().equals("")){
          JOptionPane.showMessageDialog(this, "Campo nome é obrigatório.");
          jtfNome.requestFocus();
          return false;
        }
        
        if(jtfCod.getText().equals("")){
          JOptionPane.showMessageDialog(this, "Campo COD é obrigatório.");
          jtfCod.requestFocus();
          return false;
        }
        
        if(jtfPreco.getText().equals("")){
          JOptionPane.showMessageDialog(this, "Campo Preço é obrigatório.");
          jtfNome.requestFocus();
          return false;
        }
        
        return true;
    }
}
