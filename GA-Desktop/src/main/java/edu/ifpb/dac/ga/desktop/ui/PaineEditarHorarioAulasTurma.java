/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.desktop.ui;

import edu.ifpb.dac.enums.Horarios;
import edu.ifpb.dac.ga.entidades.entidades.Aula;
import edu.ifpb.dac.ga.entidades.entidades.Horario;
import edu.ifpb.dac.ga.entidades.entidades.LocalEntity;
import edu.ifpb.dac.ga.entidades.entidades.Turma;
import edu.ifpb.dac.service.AulaService;
import edu.ifpb.dac.service.LocalService;
import edu.ifpb.dac.service.TurmaService;
import edu.ifpb.dac.service.impl.AulaServiceImpl;
import edu.ifpb.dac.service.locator.ServicesFacade;
import edu.ifpb.dac.validator.Validador;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo Augusto
 */
public class PaineEditarHorarioAulasTurma extends javax.swing.JPanel {

    private FramePrincipalAdmin framePrincipalAdmin;
    private List<Turma> turmas;
    private List<Horario> horarios;
    private List<LocalEntity> locais;
    private Turma turma;

    /**
     * Creates new form PainelCadastroAulasHorarioDisciplina
     */
    public PaineEditarHorarioAulasTurma() {
        initComponents();
    }

    public PaineEditarHorarioAulasTurma(FramePrincipalAdmin framePrincipalAdmin) {
        this.framePrincipalAdmin = framePrincipalAdmin;
        initComponents();
        // FALTA POVOAR O BANCO COM OS DADOS DISPONIBILIZADOS POR JOB, ENQUANTO ISSO CHAME ESSES MÉTODOS  
   //      salvarLocaisNoBanco();
        carregarComboBoxTurmas();
        carregarComboBoxHorarios();
        carregarComboBoxDias();
        carregarComboBoxLocais();

    }

    private void carregarComboBoxTurmas() {
        TurmaService turmaService = ServicesFacade.getTurmaService();
        turmas = turmaService.listarTodasAsTurmas();
        for (Turma turmaF : turmas) {
            comboBoxTurma.addItem(turmaF);
        }
    }

    public void salvarLocaisNoBanco() {
        LocalService localService = ServicesFacade.getLocalService();
        LocalEntity lab1 = new LocalEntity();
        lab1.setDescricao("Laboratório de informática 01");
        lab1.setAbreviacao("LAB 01");

        LocalEntity sala1 = new LocalEntity();
        lab1.setDescricao("Sala 01");
        lab1.setAbreviacao("Sala 01");
        localService.cadastrar(lab1);
        localService.cadastrar(sala1);
    }

    
    public void carregarComboBoxHorarios() {
        comboBoxHorario.addItem(Horarios.M1.horario);
        comboBoxHorario.addItem(Horarios.M2.horario);
        comboBoxHorario.addItem(Horarios.M3.horario);
        comboBoxHorario.addItem(Horarios.M4.horario);
        comboBoxHorario.addItem(Horarios.M5.horario);
        comboBoxHorario.addItem(Horarios.M6.horario);
        comboBoxHorario.addItem(Horarios.T1.horario);
        comboBoxHorario.addItem(Horarios.T2.horario);
        comboBoxHorario.addItem(Horarios.T3.horario);
        comboBoxHorario.addItem(Horarios.T4.horario);
        comboBoxHorario.addItem(Horarios.T5.horario);
        comboBoxHorario.addItem(Horarios.T6.horario);
        comboBoxHorario.addItem(Horarios.N1.horario);
        comboBoxHorario.addItem(Horarios.N2.horario);
        comboBoxHorario.addItem(Horarios.N3.horario);
        comboBoxHorario.addItem(Horarios.N4.horario);
        comboBoxHorario.addItem(Horarios.N5.horario);    
    }

    public void carregarComboBoxDias() {
        comboBoxDia.addItem(DayOfWeek.MONDAY);
        comboBoxDia.addItem(DayOfWeek.TUESDAY);
        comboBoxDia.addItem(DayOfWeek.WEDNESDAY);
        comboBoxDia.addItem(DayOfWeek.THURSDAY);
        comboBoxDia.addItem(DayOfWeek.FRIDAY);
    }

    public void carregarComboBoxLocais() {
        LocalService localService = ServicesFacade.getLocalService();
        this.locais = localService.listarTodosOsLocais();
        for (LocalEntity local : locais) {
            comboBoxLocal.addItem(local);
        }
    }
    
    private void atualizarTabela(Horario horario) {
        DayOfWeek dia = horario.getDia();
        int coluna = dia.getValue()-1;
        int linha = 0;
        switch(horario.getDescricao()){
            case  "M1" : linha = 0; break;
            case  "M2" : linha = 1; break;
            case  "M3" : linha = 2; break;
            case  "M4" : linha = 3; break;
            case  "M5" : linha = 4; break;
            case  "M6" : linha = 5; break;
            case  "T1" : linha = 6; break;
            case  "T2" : linha = 7; break;
            case  "T3" : linha = 8; break;
            case  "T4" : linha = 9; break;
            case  "T5" : linha = 10; break;
            case  "T6" : linha = 11; break;
            case  "N1" : linha = 12; break;
            case  "N2" : linha = 13; break;
            case  "N3" : linha = 14; break;
            case  "N4" : linha = 15; break;
            case  "N6" : linha = 16; break;
        }               
        
        tabelaHorarios.getColumnClass(coluna);
        tabelaHorarios.setValueAt(horario.toString(), linha, coluna);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        comboBoxTurma = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        comboBoxDia = new javax.swing.JComboBox();
        btAddAula = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btSalvarHorario = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        comboBoxLocal = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        comboBoxHorario = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaHorarios = new javax.swing.JTable();
        btSelecionarTurma = new javax.swing.JButton();
        comboBoxDia1 = new javax.swing.JComboBox();

        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Escolha a turma");
        add(jLabel2);
        jLabel2.setBounds(160, 120, 110, 30);

        comboBoxTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTurmaActionPerformed(evt);
            }
        });
        add(comboBoxTurma);
        comboBoxTurma.setBounds(290, 120, 200, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel6.setText("Cadastro de Horário de Aulas de Turma");
        add(jLabel6);
        jLabel6.setBounds(250, 30, 460, 40);

        add(comboBoxDia);
        comboBoxDia.setBounds(80, 200, 200, 30);

        btAddAula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAddAula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/add.png"))); // NOI18N
        btAddAula.setText("Adicionar aula");
        btAddAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddAulaActionPerformed(evt);
            }
        });
        add(btAddAula);
        btAddAula.setBounds(80, 410, 200, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/block_1.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(490, 530, 150, 40);

        btSalvarHorario.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btSalvarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/accept.png"))); // NOI18N
        btSalvarHorario.setText("Salvar Horário");
        btSalvarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarHorarioActionPerformed(evt);
            }
        });
        add(btSalvarHorario);
        btSalvarHorario.setBounds(260, 530, 170, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Dia");
        add(jLabel8);
        jLabel8.setBounds(40, 200, 30, 30);

        add(comboBoxLocal);
        comboBoxLocal.setBounds(80, 340, 200, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("Local");
        add(jLabel9);
        jLabel9.setBounds(30, 340, 40, 30);

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
        jScrollPane1.setBounds(320, 200, 560, 270);

        btSelecionarTurma.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btSelecionarTurma.setText("Selecionar turma");
        btSelecionarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarTurmaActionPerformed(evt);
            }
        });
        add(btSelecionarTurma);
        btSelecionarTurma.setBounds(530, 120, 150, 30);

        add(comboBoxDia1);
        comboBoxDia1.setBounds(80, 200, 200, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void btAddAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddAulaActionPerformed
        // ----------- FALTA ADICIONAR AS AULAS NA TABELA ---------------
        //A TABELA SERÁ USADA PARA EXIBIÇÃO APENAS
        if (turma != null) {
            Horario horario = (Horario) comboBoxHorario.getSelectedItem();
            horario.setDia((DayOfWeek) comboBoxDia.getSelectedItem());            
            Aula aula = new Aula();
            aula.setHorario(horario);
            List<LocalEntity> locais = new ArrayList();
            LocalEntity local = (LocalEntity) comboBoxLocal.getSelectedItem();
            AulaService aulaService = ServicesFacade.getAulaService();
//            Map <String, Object> parametros = new HashMap();
//            parametros.put("descricao", horario.getDescricao());
//            parametros.put("dia", horario.getDia());
//            parametros.put("descricaoLocal", local.getDescricao());
//            List<Aula> aulas = aulaService.listarTodasAulas("busca.aula.pordiaehorario", parametros);
//            System.out.println("eh vazio:"+aulas.isEmpty());
            
            locais.add(local);
            aula.setLocal(locais);
            
            aulaService.cadastrar(aula);
            turma.adicionarAula(aula);            
            atualizarTabela(horario);
        } else {JOptionPane.showMessageDialog(null, "Selecione uma turma!");}

    }//GEN-LAST:event_btAddAulaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.framePrincipalAdmin.setContentPane(new PainelPrincipal());
        this.framePrincipalAdmin.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboBoxTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTurmaActionPerformed

    private void btSelecionarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarTurmaActionPerformed
        this.turma = (Turma) comboBoxTurma.getSelectedItem();
    }//GEN-LAST:event_btSelecionarTurmaActionPerformed

    private void btSalvarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarHorarioActionPerformed
        Validador<Turma> validador = new Validador<>();
        if (turma != null && validador.ehValido(turma)) {
            TurmaService turmaService = ServicesFacade.getTurmaService();
            turmaService.atualizar(turma);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma turma!");
        }
    }//GEN-LAST:event_btSalvarHorarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddAula;
    private javax.swing.JButton btSalvarHorario;
    private javax.swing.JButton btSelecionarTurma;
    private javax.swing.JComboBox comboBoxDia;
    private javax.swing.JComboBox comboBoxDia1;
    private javax.swing.JComboBox comboBoxHorario;
    private javax.swing.JComboBox comboBoxLocal;
    private javax.swing.JComboBox comboBoxTurma;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaHorarios;
    // End of variables declaration//GEN-END:variables

    
}
