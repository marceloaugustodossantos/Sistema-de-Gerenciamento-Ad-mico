/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.desktop.ui;

//import edu.ifpb.dac.ga.entidades.entidades.Professor;
import edu.ifpb.dac.ga.entidades.entidades.Professor;
import edu.ifpb.dac.service.ProfessorService;
import edu.ifpb.dac.service.locator.ServicesFacade;
import edu.ifpb.dac.validator.Validador;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo Augusto
 */
public class PainelCadastroProfessor extends javax.swing.JPanel {

    /**
     * Creates new form PainelCadastroProfessor
     */
    FramePrincipalAdmin framePrincipal;
    //Professor professor;

    public PainelCadastroProfessor() {
        initComponents();
    }

    public PainelCadastroProfessor(FramePrincipalAdmin framePrincipalAdmin) {
        this.framePrincipal = framePrincipalAdmin;
        initComponents();
        campoSenha.setText("");
    }

//    public PainelCadastroProfessor(FramePrincipalAdmin framePrincipalAdmin, Professor professor) {
//        this.framePrincipal = framePrincipalAdmin;
//        initComponents();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoNome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        campoMatricula = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        campoUinidade = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        campoRegime = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        campoVinculo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();

        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(null);

        campoNome.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        add(campoNome);
        campoNome.setBounds(170, 120, 430, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Nome completo");
        add(jLabel8);
        jLabel8.setBounds(70, 120, 90, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("Email");
        add(jLabel9);
        jLabel9.setBounds(120, 160, 40, 30);

        campoEmail.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });
        add(campoEmail);
        campoEmail.setBounds(170, 160, 430, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setText("Matrícula");
        add(jLabel14);
        jLabel14.setBounds(100, 200, 60, 30);

        campoMatricula.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        add(campoMatricula);
        campoMatricula.setBounds(170, 200, 200, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("Unidade");
        add(jLabel10);
        jLabel10.setBounds(110, 240, 50, 30);

        campoUinidade.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        add(campoUinidade);
        campoUinidade.setBounds(170, 240, 200, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setText("Regime");
        add(jLabel13);
        jLabel13.setBounds(110, 280, 50, 30);

        campoRegime.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        add(campoRegime);
        campoRegime.setBounds(170, 280, 200, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setText("Vínculo");
        add(jLabel11);
        jLabel11.setBounds(110, 320, 50, 20);

        campoVinculo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        campoVinculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoVinculoActionPerformed(evt);
            }
        });
        add(campoVinculo);
        campoVinculo.setBounds(170, 320, 200, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setText("Senha");
        add(jLabel12);
        jLabel12.setBounds(120, 360, 40, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/accept_1.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(260, 420, 100, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete_1.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(390, 420, 120, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/image_edit.png"))); // NOI18N
        jLabel1.setText("Cadastro de professor");
        add(jLabel1);
        jLabel1.setBounds(220, 20, 310, 50);

        campoSenha.setText("jPasswordField1");
        add(campoSenha);
        campoSenha.setBounds(170, 360, 200, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed

    private void campoVinculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoVinculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoVinculoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Professor professor = new Professor();

        professor.setNome(campoNome.getText());
        professor.setMatricula(campoMatricula.getText());
        professor.setSenha(new String(campoSenha.getPassword()));
        professor.setRegime(campoRegime.getText());
        professor.setUnidade(campoUinidade.getText());
        professor.setVinculo(campoVinculo.getText());
        professor.setEmail(campoEmail.getText());
        Validador<Professor> validador = new Validador<>();

        if (validador.ehValido(professor)) {
            ProfessorService professorService = ServicesFacade.getProfessorService();
            professorService.cadastrar(professor);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            campoEmail.setText("");
            campoMatricula.setText("");
            campoNome.setText("");
            campoRegime.setText("");
            campoSenha.setText("");
            campoUinidade.setText("");
            campoVinculo.setText("");
        } else {
            JOptionPane.showMessageDialog(null, validador.getErros());
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.framePrincipal.setContentPane(new PainelPrincipal());
        this.framePrincipal.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoMatricula;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoRegime;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUinidade;
    private javax.swing.JTextField campoVinculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
