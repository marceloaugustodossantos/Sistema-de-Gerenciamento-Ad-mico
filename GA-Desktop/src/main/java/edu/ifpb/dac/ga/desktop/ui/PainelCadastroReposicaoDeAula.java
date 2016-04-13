/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.desktop.ui;

import edu.ifpb.dac.enums.Horarios;
import edu.ifpb.dac.ga.entidades.entidades.AulaReposicao;
import edu.ifpb.dac.ga.entidades.entidades.Horario;
import edu.ifpb.dac.ga.entidades.entidades.LocalEntity;
import edu.ifpb.dac.ga.entidades.entidades.Turma;
import edu.ifpb.dac.service.AulaReposicaoService;
import edu.ifpb.dac.service.HorarioService;
import edu.ifpb.dac.service.LocalService;
import edu.ifpb.dac.service.TurmaService;
import edu.ifpb.dac.service.locator.ServicesFacade;
import edu.ifpb.dac.validator.Validador;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo Augusto
 */
public class PainelCadastroReposicaoDeAula extends javax.swing.JPanel {

    private FramePrincipalAdmin framePrincipalAdmin;
    private List<Turma> turmas;
    private List<Horario> horarios;
    private List<LocalEntity> locais;
    private Turma turma;
    AulaReposicao aulaReposicao;

    /**
     * Creates new form PainelCadastroAulasHorarioDisciplina
     */
    public PainelCadastroReposicaoDeAula() {
        initComponents();
    }

    public PainelCadastroReposicaoDeAula(FramePrincipalAdmin framePrincipalAdmin) {
        this.framePrincipalAdmin = framePrincipalAdmin;
        initComponents();
        carregarComboBoxTurmas();
        carregarComboBoxDias();
        aulaReposicao = new AulaReposicao();
    }

    private void carregarComboBoxTurmas() {
        TurmaService turmaService = ServicesFacade.getTurmaService();
        turmas = turmaService.listarTodasAsTurmas();
        for (Turma turmaF : turmas) {
            comboBoxTurma.addItem(turmaF);
        }
    }

    public void carregarComboBoxDias() {
        comboBoxDia.addItem(DayOfWeek.MONDAY);
        comboBoxDia.addItem(DayOfWeek.TUESDAY);
        comboBoxDia.addItem(DayOfWeek.WEDNESDAY);
        comboBoxDia.addItem(DayOfWeek.THURSDAY);
        comboBoxDia.addItem(DayOfWeek.FRIDAY);
    }

    private void atualizarTabela(Horario horario) {
        DayOfWeek dia = horario.getDia();
        int coluna = dia.getValue() - 1;
        int linha = 0;
        switch (horario.getDescricao()) {
            case "M1":
                linha = 0;
                break;
            case "M2":
                linha = 1;
                break;
            case "M3":
                linha = 2;
                break;
            case "M4":
                linha = 3;
                break;
            case "M5":
                linha = 4;
                break;
            case "M6":
                linha = 5;
                break;
            case "T1":
                linha = 6;
                break;
            case "T2":
                linha = 7;
                break;
            case "T3":
                linha = 8;
                break;
            case "T4":
                linha = 9;
                break;
            case "T5":
                linha = 10;
                break;
            case "T6":
                linha = 11;
                break;
            case "N1":
                linha = 12;
                break;
            case "N2":
                linha = 13;
                break;
            case "N3":
                linha = 14;
                break;
            case "N4":
                linha = 15;
                break;
            case "N5":
                linha = 16;
                break;
        }
        tabelaHorarios.getColumnClass(coluna);
        tabelaHorarios.setValueAt(horario.toString(), linha, coluna);
    }

    private void limparTabela() {
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 5; j++) {
                tabelaHorarios.setValueAt("", i, j);
            }
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

        comboBoxTurma = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        comboBoxDia = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        btSalvarHorario = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboBoxHorario = new javax.swing.JComboBox(Horarios.values());
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaHorarios = new javax.swing.JTable();
        comboBoxDia1 = new javax.swing.JComboBox();
        campoData = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        btAddAula = new javax.swing.JButton();

        setLayout(null);

        comboBoxTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTurmaActionPerformed(evt);
            }
        });
        add(comboBoxTurma);
        comboBoxTurma.setBounds(80, 140, 200, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel6.setText("Cadastro de Reposição de Aulas de Turma");
        add(jLabel6);
        jLabel6.setBounds(220, 30, 510, 40);

        add(comboBoxDia);
        comboBoxDia.setBounds(80, 200, 200, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/block_1.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(560, 490, 150, 40);

        btSalvarHorario.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btSalvarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/accept.png"))); // NOI18N
        btSalvarHorario.setText("Confirmar reposição de aula");
        btSalvarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarHorarioActionPerformed(evt);
            }
        });
        add(btSalvarHorario);
        btSalvarHorario.setBounds(240, 490, 280, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Turma");
        add(jLabel8);
        jLabel8.setBounds(20, 140, 40, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("Data");
        add(jLabel9);
        jLabel9.setBounds(30, 340, 30, 30);

        comboBoxHorario.setMaximumRowCount(10);
        add(comboBoxHorario);
        comboBoxHorario.setBounds(80, 270, 200, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("Horário");
        add(jLabel10);
        jLabel10.setBounds(20, 270, 50, 30);

        tabelaHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {"", " ", "", null, null},
                {" ", null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Segunda", "Terça", "Quarta", "Quinta", "Sexta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaHorarios.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tabelaHorarios);
        tabelaHorarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        add(jScrollPane1);
        jScrollPane1.setBounds(310, 140, 560, 300);

        add(comboBoxDia1);
        comboBoxDia1.setBounds(80, 200, 200, 30);

        try {
            campoData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        add(campoData);
        campoData.setBounds(80, 340, 200, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setText("Dia");
        add(jLabel11);
        jLabel11.setBounds(40, 200, 30, 30);

        btAddAula.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btAddAula.setText("Adicionar aula");
        btAddAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddAulaActionPerformed(evt);
            }
        });
        add(btAddAula);
        btAddAula.setBounds(80, 400, 200, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.framePrincipalAdmin.setContentPane(new PainelPrincipal());
        this.framePrincipalAdmin.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboBoxTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTurmaActionPerformed

    private void btSalvarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarHorarioActionPerformed

        Validador<AulaReposicao> validador = new Validador<>();
        if (validador.ehValido(aulaReposicao)) {
            AulaReposicaoService aulaReposicaoService = ServicesFacade.getAulaReposicaoService();
            aulaReposicaoService.cadastrar(aulaReposicao);
            limparTabela();
            JOptionPane.showMessageDialog(null, "Cadastro realiazado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, validador.getErros());
        }

    }//GEN-LAST:event_btSalvarHorarioActionPerformed

    private void btAddAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddAulaActionPerformed
        this.turma = (Turma) comboBoxTurma.getSelectedItem();
        if (turma != null) {
            try {
                String dataString = campoData.getText();
                String[] split = dataString.split("-");
                StringBuilder data = new StringBuilder();
                data.append(split[1]).append("/").append(split[0]).append("/").append(split[2]);
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
                Date parse = df.parse(data.toString());
                aulaReposicao.setData(parse);
                aulaReposicao.setTurma(turma);
                Horarios selected = Horarios.valueOf(comboBoxHorario.getSelectedItem().toString());
                Horario horario = selected.horario;
                horario.setDia((DayOfWeek) comboBoxDia.getSelectedItem());
                aulaReposicao.addHorario(horario);
                atualizarTabela(horario);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Formato da data inválido! Formato correto:(dd/MM/yyyy)");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma turma!");
        }

    }//GEN-LAST:event_btAddAulaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddAula;
    private javax.swing.JButton btSalvarHorario;
    private javax.swing.JFormattedTextField campoData;
    private javax.swing.JComboBox comboBoxDia;
    private javax.swing.JComboBox comboBoxDia1;
    private javax.swing.JComboBox comboBoxHorario;
    private javax.swing.JComboBox comboBoxTurma;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaHorarios;
    // End of variables declaration//GEN-END:variables

}
