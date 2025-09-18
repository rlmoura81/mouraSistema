package br.com.rlmoura81.moura.principalinterface;

import br.com.rlmoura81.moura.animal.Animal;
import br.com.rlmoura81.moura.principalcadastrointerface.JIFPrestadorServico;
import br.com.rlmoura81.moura.principalcadastrointerface.JIFCidade;
import br.com.rlmoura81.moura.principalcadastrointerface.JIFCategoria;
import br.com.rlmoura81.moura.principalcadastrointerface.JIFEstado;
import br.com.rlmoura81.moura.catalogointerface.JIFCatalogo;
import br.com.rlmoura81.moura.catalogointerface.JIFEditora;
import br.com.rlmoura81.moura.financeirointerface.JIFAcaoProvento;
import br.com.rlmoura81.moura.financeirointerface.JIFAluguel;
import br.com.rlmoura81.moura.financeirointerface.JIFAtivo;
import br.com.rlmoura81.moura.financeirointerface.JIFBanco;
import br.com.rlmoura81.moura.cartaointerface.JIFCartao;
import br.com.rlmoura81.moura.cartaointerface.JIFCartaoLancamento;
import br.com.rlmoura81.moura.financeirointerface.JIFConta;
import br.com.rlmoura81.moura.financeirointerface.JIFDespesa;
import br.com.rlmoura81.moura.financeirointerface.JIFMovimentoCaixa;
import br.com.rlmoura81.moura.financeirointerface.JIFNotaCorretagem;
import br.com.rlmoura81.moura.financeirointerface.JIFPoupanca;
import br.com.rlmoura81.moura.financeirointerface.JIFFundoImobiliarioProvento;
import br.com.rlmoura81.moura.financeirointerface.JIFIndiceValor;
import br.com.rlmoura81.moura.financeirointerface.JIFPoupancaAplicacao;
import br.com.rlmoura81.moura.financeirointerface.JIFRendaFixa;
import br.com.rlmoura81.moura.imovelinterface.JIFImovel;
import br.com.rlmoura81.moura.animalinterface.JIFAnimal;
import br.com.rlmoura81.moura.animalinterface.JIFHistorico;
import br.com.rlmoura81.moura.animalinterface.JIFProduto;
import br.com.rlmoura81.moura.animalinterface.JIFRaca;
import br.com.rlmoura81.moura.financeirointerface.JIFAtivoSaldo;
import br.com.rlmoura81.moura.financeirointerface.JIFRenda;
import br.com.rlmoura81.moura.financeirointerface.JIFFundoInvestimento;
import br.com.rlmoura81.moura.financeirointerface.JIFFundoInvestimentoAplicacao;
import br.com.rlmoura81.moura.financeirointerface.JIFMoedaValor;
import br.com.rlmoura81.moura.financeirointerface.JIFMovimentoCaixaFuturo;
import br.com.rlmoura81.moura.imovel.Imovel;
import br.com.rlmoura81.moura.principalcadastrointerface.JIFAssinatura;
import br.com.rlmoura81.moura.principalcadastrointerface.JIFGrupo;
import br.com.rlmoura81.moura.relatoriointerface.JIFRelatorioFinanceiro;
import br.com.rlmoura81.moura.relatoriointerface.JIFResumo;
import br.com.rlmoura81.moura.rpginterface.JIFRpg;
import br.com.rlmoura81.moura.veiculo.Veiculo;
import br.com.rlmoura81.moura.veiculointerface.JIFModelo;
import br.com.rlmoura81.moura.veiculointerface.JIFVeiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class JFPrincipal extends javax.swing.JFrame {
    
    GerenciarInterface gerenciainterface;

    public JFPrincipal() {
        initComponents();
        
        this.gerenciainterface = new GerenciarInterface(jDPPrincipal);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("MouraSistema" + " - " + "Usuário: " + JPLogin.loginuser + " - " + JPLogin.codloginuser);
        nlsDateFormat();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDPPrincipal = new javax.swing.JDesktopPane();
        JMBPrincipal = new javax.swing.JMenuBar();
        jMArquivo = new javax.swing.JMenu();
        jMPrincipalCad = new javax.swing.JMenu();
        jMGeral = new javax.swing.JMenu();
        jMIEstado = new javax.swing.JMenuItem();
        jMICidade = new javax.swing.JMenuItem();
        jMIGrupo = new javax.swing.JMenuItem();
        jMICategoria = new javax.swing.JMenuItem();
        jMIPrestadorServico = new javax.swing.JMenuItem();
        jMIModulo = new javax.swing.JMenuItem();
        jMPessoa = new javax.swing.JMenuItem();
        jMUsuario = new javax.swing.JMenuItem();
        jMISair = new javax.swing.JMenuItem();
        jMAssinatura = new javax.swing.JMenu();
        jMIAssinatura = new javax.swing.JMenuItem();
        jMCatalogo = new javax.swing.JMenu();
        jMCatalogoLista = new javax.swing.JMenuItem();
        jMEditora = new javax.swing.JMenuItem();
        jMFinanceiro = new javax.swing.JMenu();
        jMFinanceiroCad = new javax.swing.JMenu();
        jMIAtivo = new javax.swing.JMenuItem();
        jMICadBancos = new javax.swing.JMenuItem();
        jMICadContas = new javax.swing.JMenuItem();
        jMAluguel = new javax.swing.JMenu();
        jMIAluguelCad = new javax.swing.JMenuItem();
        jMCartoes = new javax.swing.JMenu();
        jMICartoesCad = new javax.swing.JMenuItem();
        jMICartoesLanc = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMICreditoCad = new javax.swing.JMenuItem();
        jMDespesa = new javax.swing.JMenu();
        jMIDespesasCad = new javax.swing.JMenuItem();
        jMInvestimento = new javax.swing.JMenu();
        jMAcao = new javax.swing.JMenu();
        jMIProventoAcao = new javax.swing.JMenuItem();
        jMISaldoAcao = new javax.swing.JMenuItem();
        jMFundoImobiliario = new javax.swing.JMenu();
        jMIProventoFI = new javax.swing.JMenuItem();
        jMISaldoFI = new javax.swing.JMenuItem();
        jMPoupanca = new javax.swing.JMenu();
        jMIPoupancaCad = new javax.swing.JMenuItem();
        jMIPoupancaAplic = new javax.swing.JMenuItem();
        jMRendaFixa = new javax.swing.JMenu();
        jMIRendaFixaAplic = new javax.swing.JMenuItem();
        jMFundoInvestimento = new javax.swing.JMenu();
        jMIFdInvestimentoCad = new javax.swing.JMenuItem();
        jMIFdInvestimentoAplic = new javax.swing.JMenuItem();
        jMLancamento = new javax.swing.JMenu();
        jMIMovimentoCaixa = new javax.swing.JMenuItem();
        jMIMovvimentoCaixaLanc = new javax.swing.JMenuItem();
        jMINotaCorretagem = new javax.swing.JMenuItem();
        jMIIndice = new javax.swing.JMenuItem();
        jMICotacao = new javax.swing.JMenuItem();
        jMIDespesasRel = new javax.swing.JMenuItem();
        jMIResumo = new javax.swing.JMenuItem();
        jMImovel = new javax.swing.JMenu();
        jMIImovel = new javax.swing.JMenuItem();
        jMIImovelDespesa = new javax.swing.JMenuItem();
        jMAnimal = new javax.swing.JMenu();
        jMPetCad = new javax.swing.JMenu();
        jMRaca = new javax.swing.JMenuItem();
        jMIPetLista = new javax.swing.JMenuItem();
        jMIProduto = new javax.swing.JMenuItem();
        jMIAnimalDespesa = new javax.swing.JMenuItem();
        JMIHistorico = new javax.swing.JMenuItem();
        jMVeiculo = new javax.swing.JMenu();
        jMIVeiculoCad = new javax.swing.JMenuItem();
        jMIVeiculo = new javax.swing.JMenuItem();
        jMIVeiculoDespesas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDPPrincipal.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        javax.swing.GroupLayout jDPPrincipalLayout = new javax.swing.GroupLayout(jDPPrincipal);
        jDPPrincipal.setLayout(jDPPrincipalLayout);
        jDPPrincipalLayout.setHorizontalGroup(
            jDPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );
        jDPPrincipalLayout.setVerticalGroup(
            jDPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );

        jMArquivo.setText("Menu");

        jMPrincipalCad.setText("Cadastro");

        jMGeral.setText("Geral");

        jMIEstado.setText("Estado");
        jMIEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEstadoActionPerformed(evt);
            }
        });
        jMGeral.add(jMIEstado);

        jMICidade.setText("Cidade");
        jMICidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICidadeActionPerformed(evt);
            }
        });
        jMGeral.add(jMICidade);

        jMIGrupo.setText("Grupo");
        jMIGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIGrupoActionPerformed(evt);
            }
        });
        jMGeral.add(jMIGrupo);

        jMICategoria.setText("Categoria");
        jMICategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICategoriaActionPerformed(evt);
            }
        });
        jMGeral.add(jMICategoria);

        jMIPrestadorServico.setText("Prestador de Serviços");
        jMIPrestadorServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrestadorServicoActionPerformed(evt);
            }
        });
        jMGeral.add(jMIPrestadorServico);

        jMIModulo.setText("Módulos");
        jMIModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIModuloActionPerformed(evt);
            }
        });
        jMGeral.add(jMIModulo);

        jMPrincipalCad.add(jMGeral);

        jMPessoa.setText("Pessoa");
        jMPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPessoaActionPerformed(evt);
            }
        });
        jMPrincipalCad.add(jMPessoa);

        jMUsuario.setText("Usuario");
        jMUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMUsuarioActionPerformed(evt);
            }
        });
        jMPrincipalCad.add(jMUsuario);

        jMArquivo.add(jMPrincipalCad);

        jMISair.setText("Sair");
        jMISair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISairActionPerformed(evt);
            }
        });
        jMArquivo.add(jMISair);

        JMBPrincipal.add(jMArquivo);

        jMAssinatura.setText("Assinatura");

        jMIAssinatura.setText("Assinaturas");
        jMIAssinatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAssinaturaActionPerformed(evt);
            }
        });
        jMAssinatura.add(jMIAssinatura);

        JMBPrincipal.add(jMAssinatura);

        jMCatalogo.setText("Catálogo");

        jMCatalogoLista.setText("Catálogo");
        jMCatalogoLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCatalogoListaActionPerformed(evt);
            }
        });
        jMCatalogo.add(jMCatalogoLista);

        jMEditora.setText("Editora");
        jMEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEditoraActionPerformed(evt);
            }
        });
        jMCatalogo.add(jMEditora);

        JMBPrincipal.add(jMCatalogo);

        jMFinanceiro.setText("Financeiro");

        jMFinanceiroCad.setText("Cadastros");

        jMIAtivo.setText("Ativos");
        jMIAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAtivoActionPerformed(evt);
            }
        });
        jMFinanceiroCad.add(jMIAtivo);

        jMICadBancos.setText("Bancos");
        jMICadBancos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICadBancosActionPerformed(evt);
            }
        });
        jMFinanceiroCad.add(jMICadBancos);

        jMICadContas.setText("Contas");
        jMICadContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICadContasActionPerformed(evt);
            }
        });
        jMFinanceiroCad.add(jMICadContas);

        jMFinanceiro.add(jMFinanceiroCad);

        jMAluguel.setText("Aluguel");

        jMIAluguelCad.setText("Cadastros");
        jMIAluguelCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAluguelCadActionPerformed(evt);
            }
        });
        jMAluguel.add(jMIAluguelCad);

        jMFinanceiro.add(jMAluguel);

        jMCartoes.setText("Cartões");

        jMICartoesCad.setText("Cadastros");
        jMICartoesCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICartoesCadActionPerformed(evt);
            }
        });
        jMCartoes.add(jMICartoesCad);

        jMICartoesLanc.setText("Lançamentos");
        jMICartoesLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICartoesLancActionPerformed(evt);
            }
        });
        jMCartoes.add(jMICartoesLanc);

        jMFinanceiro.add(jMCartoes);

        jMenu1.setText("Renda");

        jMICreditoCad.setText("Cadastros");
        jMICreditoCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICreditoCadActionPerformed(evt);
            }
        });
        jMenu1.add(jMICreditoCad);

        jMFinanceiro.add(jMenu1);

        jMDespesa.setText("Despesa");

        jMIDespesasCad.setText("Cadastros");
        jMIDespesasCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDespesasCadActionPerformed(evt);
            }
        });
        jMDespesa.add(jMIDespesasCad);

        jMFinanceiro.add(jMDespesa);

        jMInvestimento.setText("Investimentos");

        jMAcao.setText("Ação");

        jMIProventoAcao.setText("Proventos");
        jMIProventoAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIProventoAcaoActionPerformed(evt);
            }
        });
        jMAcao.add(jMIProventoAcao);

        jMISaldoAcao.setText("Saldo");
        jMISaldoAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISaldoAcaoActionPerformed(evt);
            }
        });
        jMAcao.add(jMISaldoAcao);

        jMInvestimento.add(jMAcao);

        jMFundoImobiliario.setText("Fundos Imobiliários");

        jMIProventoFI.setText("Proventos");
        jMIProventoFI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIProventoFIActionPerformed(evt);
            }
        });
        jMFundoImobiliario.add(jMIProventoFI);

        jMISaldoFI.setText("Saldo");
        jMISaldoFI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISaldoFIActionPerformed(evt);
            }
        });
        jMFundoImobiliario.add(jMISaldoFI);

        jMInvestimento.add(jMFundoImobiliario);

        jMPoupanca.setText("Poupança");

        jMIPoupancaCad.setText("Cadastros");
        jMIPoupancaCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPoupancaCadActionPerformed(evt);
            }
        });
        jMPoupanca.add(jMIPoupancaCad);

        jMIPoupancaAplic.setText("Aplicação");
        jMIPoupancaAplic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPoupancaAplicActionPerformed(evt);
            }
        });
        jMPoupanca.add(jMIPoupancaAplic);

        jMInvestimento.add(jMPoupanca);

        jMRendaFixa.setText("Renda Fixa");

        jMIRendaFixaAplic.setText("Aplicação");
        jMIRendaFixaAplic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRendaFixaAplicActionPerformed(evt);
            }
        });
        jMRendaFixa.add(jMIRendaFixaAplic);

        jMInvestimento.add(jMRendaFixa);

        jMFundoInvestimento.setText("Fundo de Investimento");

        jMIFdInvestimentoCad.setText("Cadastro");
        jMIFdInvestimentoCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFdInvestimentoCadActionPerformed(evt);
            }
        });
        jMFundoInvestimento.add(jMIFdInvestimentoCad);

        jMIFdInvestimentoAplic.setText("Aplicação");
        jMIFdInvestimentoAplic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFdInvestimentoAplicActionPerformed(evt);
            }
        });
        jMFundoInvestimento.add(jMIFdInvestimentoAplic);

        jMInvestimento.add(jMFundoInvestimento);

        jMFinanceiro.add(jMInvestimento);

        jMLancamento.setText("Lançamentos");

        jMIMovimentoCaixa.setText("Movimento Caixa");
        jMIMovimentoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIMovimentoCaixaActionPerformed(evt);
            }
        });
        jMLancamento.add(jMIMovimentoCaixa);

        jMIMovvimentoCaixaLanc.setText("Movimento Caixa Lançamentos");
        jMIMovvimentoCaixaLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIMovvimentoCaixaLancActionPerformed(evt);
            }
        });
        jMLancamento.add(jMIMovvimentoCaixaLanc);

        jMINotaCorretagem.setText("Nota de Corretagem");
        jMINotaCorretagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMINotaCorretagemActionPerformed(evt);
            }
        });
        jMLancamento.add(jMINotaCorretagem);

        jMIIndice.setText("Índices");
        jMIIndice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIIndiceActionPerformed(evt);
            }
        });
        jMLancamento.add(jMIIndice);

        jMICotacao.setText("Cotação");
        jMICotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICotacaoActionPerformed(evt);
            }
        });
        jMLancamento.add(jMICotacao);

        jMFinanceiro.add(jMLancamento);

        jMIDespesasRel.setText("Relatório");
        jMIDespesasRel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDespesasRelActionPerformed(evt);
            }
        });
        jMFinanceiro.add(jMIDespesasRel);

        jMIResumo.setText("Resumo");
        jMIResumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIResumoActionPerformed(evt);
            }
        });
        jMFinanceiro.add(jMIResumo);

        JMBPrincipal.add(jMFinanceiro);

        jMImovel.setText("Imoveis");

        jMIImovel.setText("Imóveis");
        jMIImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIImovelActionPerformed(evt);
            }
        });
        jMImovel.add(jMIImovel);

        jMIImovelDespesa.setText("Despesa");
        jMIImovelDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIImovelDespesaActionPerformed(evt);
            }
        });
        jMImovel.add(jMIImovelDespesa);

        JMBPrincipal.add(jMImovel);

        jMAnimal.setText("Animal");

        jMPetCad.setText("Cadastro");

        jMRaca.setText("Raça");
        jMRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRacaActionPerformed(evt);
            }
        });
        jMPetCad.add(jMRaca);

        jMAnimal.add(jMPetCad);

        jMIPetLista.setText("Animal");
        jMIPetLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPetListaActionPerformed(evt);
            }
        });
        jMAnimal.add(jMIPetLista);

        jMIProduto.setText("Produto");
        jMIProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIProdutoActionPerformed(evt);
            }
        });
        jMAnimal.add(jMIProduto);

        jMIAnimalDespesa.setText("Despesa");
        jMIAnimalDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAnimalDespesaActionPerformed(evt);
            }
        });
        jMAnimal.add(jMIAnimalDespesa);

        JMIHistorico.setText("Histórico");
        JMIHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIHistoricoActionPerformed(evt);
            }
        });
        jMAnimal.add(JMIHistorico);

        JMBPrincipal.add(jMAnimal);

        jMVeiculo.setText("Veiculos");

        jMIVeiculoCad.setText("Cadastros");
        jMIVeiculoCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIVeiculoCadActionPerformed(evt);
            }
        });
        jMVeiculo.add(jMIVeiculoCad);

        jMIVeiculo.setText("Veiculos");
        jMIVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIVeiculoActionPerformed(evt);
            }
        });
        jMVeiculo.add(jMIVeiculo);

        jMIVeiculoDespesas.setText("Despesas");
        jMIVeiculoDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIVeiculoDespesasActionPerformed(evt);
            }
        });
        jMVeiculo.add(jMIVeiculoDespesas);

        JMBPrincipal.add(jMVeiculo);

        jMenu2.setText("RPG");

        jMenuItem1.setText("RPG");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        JMBPrincipal.add(jMenu2);

        jMSobre.setText("Sobre");
        jMSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMSobreMouseClicked(evt);
            }
        });
        JMBPrincipal.add(jMSobre);

        setJMenuBar(JMBPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]) {        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal().setVisible(true);
            }
        });
    }
      
    /**
     * <p><strong>EN:</strong> Validates and adjusts the Oracle session’s 
     * NLS_DATE_FORMAT parameter.  
     * If the current format is different from <code>DD/MM/RR</code>, 
     * updates the session to use <code>dd/MM/yyyy</code>.</p>
     *
     * <p><strong>IT:</strong> Verifica e aggiorna il parametro 
     * NLS_DATE_FORMAT della sessione Oracle.  
     * Se il formato attuale è diverso da <code>DD/MM/RR</code>, 
     * imposta la sessione su <code>dd/MM/yyyy</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Valida e ajusta o parâmetro 
     * NLS_DATE_FORMAT da sessão Oracle.  
     * Se o formato atual for diferente de <code>DD/MM/RR</code>, 
     * altera a sessão para <code>dd/MM/yyyy</code>.</p>
     */
    private void nlsDateFormat(){
        String sql;
        String nlsDateFormat = null;
        try{
            sql = "SELECT value" +
                  "  FROM NLS_SESSION_PARAMETERS" +
                  " WHERE PARAMETER = 'NLS_DATE_FORMAT'";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nlsDateFormat = rs.getString("value");
            }
            if(!nlsDateFormat.equals("DD/MM/RR")){
                try{
                    sql = "ALTER SESSION SET NLS_DATE_FORMAT = 'dd/MM/yyyy'";
                    ps.execute(sql);
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro ao alterar a nls_Date_Format:\n" +
                            ex.getMessage());
                }
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de nls_Date_Format:\n" +
                    ex.getMessage());
        }
    }
    
    private void jMSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMSobreMouseClicked
        JOptionPane.showMessageDialog(null, "Versão - beta\n" + "by rlmoura81", "Moura Sistema",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMSobreMouseClicked

    private void jMIDespesasCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDespesasCadActionPerformed
        gerenciainterface.abrirInterface(JIFDespesa.getInstancia());
    }//GEN-LAST:event_jMIDespesasCadActionPerformed

    private void jMICadContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICadContasActionPerformed
        gerenciainterface.abrirInterface(JIFConta.getInstancia());
    }//GEN-LAST:event_jMICadContasActionPerformed

    private void jMICadBancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICadBancosActionPerformed
        gerenciainterface.abrirInterface(JIFBanco.getInstancia());
    }//GEN-LAST:event_jMICadBancosActionPerformed

    private void jMCatalogoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCatalogoListaActionPerformed
        gerenciainterface.abrirInterface(JIFCatalogo.getInstancia());
    }//GEN-LAST:event_jMCatalogoListaActionPerformed

    private void jMISairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISairActionPerformed
        try {
            JPLogin.conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexao no banco:\n" +
                    ex.getMessage());
        }
        System.exit(0);
    }//GEN-LAST:event_jMISairActionPerformed

    private void jMUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMUsuarioActionPerformed
        gerenciainterface.abrirInterface(JIFUsuario.getInstancia());
    }//GEN-LAST:event_jMUsuarioActionPerformed

    private void jMPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMPessoaActionPerformed
        gerenciainterface.abrirInterface(JIFPessoaFisica.getInstancia());
    }//GEN-LAST:event_jMPessoaActionPerformed

    private void jMIPrestadorServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrestadorServicoActionPerformed
        gerenciainterface.abrirInterface(JIFPrestadorServico.getInstancia());
    }//GEN-LAST:event_jMIPrestadorServicoActionPerformed

    private void jMICategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICategoriaActionPerformed
        gerenciainterface.abrirInterface(JIFCategoria.getInstancia());
    }//GEN-LAST:event_jMICategoriaActionPerformed

    private void jMICidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICidadeActionPerformed
        gerenciainterface.abrirInterface(JIFCidade.getInstancia());
    }//GEN-LAST:event_jMICidadeActionPerformed

    private void jMIEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEstadoActionPerformed
        gerenciainterface.abrirInterface(JIFEstado.getInstancia());
    }//GEN-LAST:event_jMIEstadoActionPerformed

    private void jMIImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIImovelActionPerformed
        gerenciainterface.abrirInterface(JIFImovel.getInstancia());
    }//GEN-LAST:event_jMIImovelActionPerformed

    private void jMRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMRacaActionPerformed
        gerenciainterface.abrirInterface(JIFRaca.getInstancia());
    }//GEN-LAST:event_jMRacaActionPerformed

    private void jMIPetListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPetListaActionPerformed
        gerenciainterface.abrirInterface(JIFAnimal.getInstancia());
    }//GEN-LAST:event_jMIPetListaActionPerformed

    private void jMICartoesCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICartoesCadActionPerformed
        gerenciainterface.abrirInterface(JIFCartao.getInstancia());
    }//GEN-LAST:event_jMICartoesCadActionPerformed

    private void jMIVeiculoCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIVeiculoCadActionPerformed
        gerenciainterface.abrirInterface(JIFModelo.getInstancia());
    }//GEN-LAST:event_jMIVeiculoCadActionPerformed

    private void jMIVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIVeiculoActionPerformed
        gerenciainterface.abrirInterface(JIFVeiculo.getInstacia());
    }//GEN-LAST:event_jMIVeiculoActionPerformed

    private void jMIPoupancaCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPoupancaCadActionPerformed
        gerenciainterface.abrirInterface(JIFPoupanca.getInstancia());
    }//GEN-LAST:event_jMIPoupancaCadActionPerformed

    private void jMIAluguelCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAluguelCadActionPerformed
        gerenciainterface.abrirInterface(JIFAluguel.getInstancia());
    }//GEN-LAST:event_jMIAluguelCadActionPerformed

    private void jMIMovimentoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIMovimentoCaixaActionPerformed
        gerenciainterface.abrirInterface(JIFMovimentoCaixa.getInstancia());
    }//GEN-LAST:event_jMIMovimentoCaixaActionPerformed

    private void jMIProventoFIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIProventoFIActionPerformed
        gerenciainterface.abrirInterface(JIFFundoImobiliarioProvento.getInstancia());
    }//GEN-LAST:event_jMIProventoFIActionPerformed

    private void jMINotaCorretagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMINotaCorretagemActionPerformed
        gerenciainterface.abrirInterface(JIFNotaCorretagem.getInstancia());
    }//GEN-LAST:event_jMINotaCorretagemActionPerformed

    private void jMICartoesLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICartoesLancActionPerformed
        gerenciainterface.abrirInterface(JIFCartaoLancamento.getInstancia());
    }//GEN-LAST:event_jMICartoesLancActionPerformed

    private void jMIAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAtivoActionPerformed
        gerenciainterface.abrirInterface(JIFAtivo.getInstancia());
    }//GEN-LAST:event_jMIAtivoActionPerformed

    private void jMIIndiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIIndiceActionPerformed
        gerenciainterface.abrirInterface(JIFIndiceValor.getInstancia());
    }//GEN-LAST:event_jMIIndiceActionPerformed

    private void jMIProventoAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIProventoAcaoActionPerformed
        gerenciainterface.abrirInterface(JIFAcaoProvento.getInstancia());
    }//GEN-LAST:event_jMIProventoAcaoActionPerformed

    private void jMIPoupancaAplicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPoupancaAplicActionPerformed
        gerenciainterface.abrirInterface(JIFPoupancaAplicacao.getInstancia());
    }//GEN-LAST:event_jMIPoupancaAplicActionPerformed

    private void jMEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMEditoraActionPerformed
        gerenciainterface.abrirInterface(JIFEditora.getInstacia());
    }//GEN-LAST:event_jMEditoraActionPerformed

    private void jMICotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICotacaoActionPerformed
        gerenciainterface.abrirInterface(JIFMoedaValor.getInstancia());
    }//GEN-LAST:event_jMICotacaoActionPerformed

    private void jMIRendaFixaAplicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRendaFixaAplicActionPerformed
        gerenciainterface.abrirInterface(JIFRendaFixa.getInstancia());
    }//GEN-LAST:event_jMIRendaFixaAplicActionPerformed

    private void jMIFdInvestimentoCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFdInvestimentoCadActionPerformed
        gerenciainterface.abrirInterface(JIFFundoInvestimento.getInstancia());
    }//GEN-LAST:event_jMIFdInvestimentoCadActionPerformed

    private void jMIFdInvestimentoAplicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFdInvestimentoAplicActionPerformed
        gerenciainterface.abrirInterface(JIFFundoInvestimentoAplicacao.getInstancia());
    }//GEN-LAST:event_jMIFdInvestimentoAplicActionPerformed

    private void jMISaldoAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISaldoAcaoActionPerformed
        gerenciainterface.abrirInterface(JIFAtivoSaldo.getInstancia(0));
    }//GEN-LAST:event_jMISaldoAcaoActionPerformed

    private void jMISaldoFIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISaldoFIActionPerformed
        gerenciainterface.abrirInterface(JIFAtivoSaldo.getInstancia(1));
    }//GEN-LAST:event_jMISaldoFIActionPerformed

    private void jMICreditoCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICreditoCadActionPerformed
        gerenciainterface.abrirInterface(JIFRenda.getInstancia());
    }//GEN-LAST:event_jMICreditoCadActionPerformed

    private void jMIVeiculoDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIVeiculoDespesasActionPerformed
        Veiculo v = new Veiculo();
        gerenciainterface.abrirInterface(JIFModuloDespesa.getInstancia(v));
    }//GEN-LAST:event_jMIVeiculoDespesasActionPerformed

    private void jMIProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIProdutoActionPerformed
        gerenciainterface.abrirInterface(JIFProduto.getInstancia());
    }//GEN-LAST:event_jMIProdutoActionPerformed

    private void jMIModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIModuloActionPerformed
        gerenciainterface.abrirInterface(JIFModulo.getInstancia());
    }//GEN-LAST:event_jMIModuloActionPerformed

    private void jMIImovelDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIImovelDespesaActionPerformed
        Imovel i = new Imovel();
        gerenciainterface.abrirInterface(JIFModuloDespesa.getInstancia(i));
    }//GEN-LAST:event_jMIImovelDespesaActionPerformed

    private void jMIAnimalDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAnimalDespesaActionPerformed
        Animal a = new Animal();
        gerenciainterface.abrirInterface(JIFModuloDespesa.getInstancia(a));
    }//GEN-LAST:event_jMIAnimalDespesaActionPerformed

    private void JMIHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIHistoricoActionPerformed
        gerenciainterface.abrirInterface(JIFHistorico.getInstancia());
    }//GEN-LAST:event_JMIHistoricoActionPerformed

    private void jMIAssinaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAssinaturaActionPerformed
        gerenciainterface.abrirInterface(JIFAssinatura.getInstancia());
    }//GEN-LAST:event_jMIAssinaturaActionPerformed

    private void jMIDespesasRelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDespesasRelActionPerformed
        gerenciainterface.abrirInterface(JIFRelatorioFinanceiro.getInstancia());
    }//GEN-LAST:event_jMIDespesasRelActionPerformed

    private void jMIMovvimentoCaixaLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIMovvimentoCaixaLancActionPerformed
        gerenciainterface.abrirInterface(JIFMovimentoCaixaFuturo.getInstancia());
    }//GEN-LAST:event_jMIMovvimentoCaixaLancActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        gerenciainterface.abrirInterface(JIFRpg.getInstancia());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMIGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIGrupoActionPerformed
        gerenciainterface.abrirInterface(JIFGrupo.getInstancia());
    }//GEN-LAST:event_jMIGrupoActionPerformed

    private void jMIResumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIResumoActionPerformed
        gerenciainterface.abrirInterface(JIFResumo.getInstancia());
    }//GEN-LAST:event_jMIResumoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar JMBPrincipal;
    private javax.swing.JMenuItem JMIHistorico;
    private javax.swing.JDesktopPane jDPPrincipal;
    private javax.swing.JMenu jMAcao;
    private javax.swing.JMenu jMAluguel;
    private javax.swing.JMenu jMAnimal;
    private javax.swing.JMenu jMArquivo;
    private javax.swing.JMenu jMAssinatura;
    private javax.swing.JMenu jMCartoes;
    private javax.swing.JMenu jMCatalogo;
    private javax.swing.JMenuItem jMCatalogoLista;
    private javax.swing.JMenu jMDespesa;
    private javax.swing.JMenuItem jMEditora;
    private javax.swing.JMenu jMFinanceiro;
    private javax.swing.JMenu jMFinanceiroCad;
    private javax.swing.JMenu jMFundoImobiliario;
    private javax.swing.JMenu jMFundoInvestimento;
    private javax.swing.JMenu jMGeral;
    private javax.swing.JMenuItem jMIAluguelCad;
    private javax.swing.JMenuItem jMIAnimalDespesa;
    private javax.swing.JMenuItem jMIAssinatura;
    private javax.swing.JMenuItem jMIAtivo;
    private javax.swing.JMenuItem jMICadBancos;
    private javax.swing.JMenuItem jMICadContas;
    private javax.swing.JMenuItem jMICartoesCad;
    private javax.swing.JMenuItem jMICartoesLanc;
    private javax.swing.JMenuItem jMICategoria;
    private javax.swing.JMenuItem jMICidade;
    private javax.swing.JMenuItem jMICotacao;
    private javax.swing.JMenuItem jMICreditoCad;
    private javax.swing.JMenuItem jMIDespesasCad;
    private javax.swing.JMenuItem jMIDespesasRel;
    private javax.swing.JMenuItem jMIEstado;
    private javax.swing.JMenuItem jMIFdInvestimentoAplic;
    private javax.swing.JMenuItem jMIFdInvestimentoCad;
    private javax.swing.JMenuItem jMIGrupo;
    private javax.swing.JMenuItem jMIImovel;
    private javax.swing.JMenuItem jMIImovelDespesa;
    private javax.swing.JMenuItem jMIIndice;
    private javax.swing.JMenuItem jMIModulo;
    private javax.swing.JMenuItem jMIMovimentoCaixa;
    private javax.swing.JMenuItem jMIMovvimentoCaixaLanc;
    private javax.swing.JMenuItem jMINotaCorretagem;
    private javax.swing.JMenuItem jMIPetLista;
    private javax.swing.JMenuItem jMIPoupancaAplic;
    private javax.swing.JMenuItem jMIPoupancaCad;
    private javax.swing.JMenuItem jMIPrestadorServico;
    private javax.swing.JMenuItem jMIProduto;
    private javax.swing.JMenuItem jMIProventoAcao;
    private javax.swing.JMenuItem jMIProventoFI;
    private javax.swing.JMenuItem jMIRendaFixaAplic;
    private javax.swing.JMenuItem jMIResumo;
    private javax.swing.JMenuItem jMISair;
    private javax.swing.JMenuItem jMISaldoAcao;
    private javax.swing.JMenuItem jMISaldoFI;
    private javax.swing.JMenuItem jMIVeiculo;
    private javax.swing.JMenuItem jMIVeiculoCad;
    private javax.swing.JMenuItem jMIVeiculoDespesas;
    private javax.swing.JMenu jMImovel;
    private javax.swing.JMenu jMInvestimento;
    private javax.swing.JMenu jMLancamento;
    private javax.swing.JMenuItem jMPessoa;
    private javax.swing.JMenu jMPetCad;
    private javax.swing.JMenu jMPoupanca;
    private javax.swing.JMenu jMPrincipalCad;
    private javax.swing.JMenuItem jMRaca;
    private javax.swing.JMenu jMRendaFixa;
    private javax.swing.JMenu jMSobre;
    private javax.swing.JMenuItem jMUsuario;
    private javax.swing.JMenu jMVeiculo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables

}
