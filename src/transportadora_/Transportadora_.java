//Nome: Pedro Gabriel, Gabriel Teixeira Bernardes, Rafael de Padua Oliveira
//Tema: Transportadora 
//Data: 21/05/2025

package transportadora_;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class Transportadora_ {

    public static void main(String[] args) {

        // --- CONTROLE DE ACESSO ---
        // Solicita o nome completo do usuário
        String nomeCompleto = JOptionPane.showInputDialog("Digite seu nome completo:");
        if (nomeCompleto == null) System.exit(0); // Sai se o usuário cancelar

        // Extrai o primeiro nome e converte para maiúsculo
        String primeiroNome;
        if (nomeCompleto.contains(" ")) {
            primeiroNome = nomeCompleto.substring(0, nomeCompleto.indexOf(' '));
        } else {
            primeiroNome = nomeCompleto;
        }
        primeiroNome = primeiroNome.toUpperCase();

        // Gera data atual no formato ddmmaaaa
        Calendar hoje = Calendar.getInstance();
        String data = String.format("%02d%02d%04d",
            hoje.get(Calendar.DAY_OF_MONTH),
            hoje.get(Calendar.MONTH) + 1,
            hoje.get(Calendar.YEAR)
        );

        // Gera senha combinando nome com data
        String senhaGerada = primeiroNome + data;

        // Loop de autenticação
        while (true) {
            String tentativa = JOptionPane.showInputDialog("Digite a senha (" + senhaGerada + "):");
            if (tentativa == null) System.exit(0);
            if (tentativa.equals(senhaGerada)) {
                JOptionPane.showMessageDialog(null, "Acesso concedido!");
                break;
            }
            // Oferece nova tentativa se senha estiver incorreta
            int opc = JOptionPane.showConfirmDialog(
                null,
                "Senha incorreta!\n\nTentar novamente?",
                "Erro de Autenticação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE
            );
            if (opc != JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        
        // --- MENU PRINCIPAL ---
        // Variáveis para armazenar as instâncias
        Motorista motorista = null;
        MotoristaMoto motoristaMoto = null;
        MotoristaCarro motoristaCarro = null;
        Cliente cliente = null;
        String menu;

        // Loop do menu principal com opções para motorista e cliente
        do {
            menu = JOptionPane.showInputDialog(
                "--- MENU PRINCIPAL ---\n" +
                "1 - Cadastrar Motorista\n" +
                "2 - Consultar Motorista\n" +
                "3 - Editar Motorista\n" +
                "4 - Cadastrar Cliente\n" +
                "5 - Consultar Cliente\n" +
                "6 - Editar Cliente\n" +
                "0 - Sair\n\n" +
                "Opção:"
            );
            if (menu == null || menu.equals("0")) break;

            switch (menu) {                
                case "1":
                    // Cadastro de motorista
                    String nome = JOptionPane.showInputDialog("Nome:");
                    String tel = JOptionPane.showInputDialog("Telefone:");
                    
                    // Tratamento de erro para data de nascimento
                    Calendar nasc = Calendar.getInstance();
                    boolean dataValida = false;
                    while (!dataValida) {
                        try {
                            String dataInput = JOptionPane.showInputDialog("Data Nasc (dd mm aaaa):");
                            if (dataInput == null) break; // Usuário clicou em cancelar
                            
                            String[] d = dataInput.split("\\s+");
                            if (d.length != 3) {
                                throw new Exception("Formato inválido! Use o formato: dia mês ano com espaços entre eles.");
                            }
                            
                            int dia = Integer.parseInt(d[0]);
                            int mes = Integer.parseInt(d[1]);
                            int ano = Integer.parseInt(d[2]);
                            
                            // Verificações básicas de validade
                            if (dia < 1 || dia > 31 || mes < 1 || mes > 12  || ano > 2025) {
                                throw new Exception("Data inválida! Verifique os valores de dia, mês e ano.");
                            }
                            nasc.set(ano, mes - 1, dia);
                            dataValida = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, 
                                "Erro no formato da data! Use apenas números.", 
                                "ERRO!!!", JOptionPane.ERROR_MESSAGE);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, 
                                e.getMessage(), 
                                "ERRO!!!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (!dataValida) break; // Se usuário cancelou a entrada de data
                    String cnh = JOptionPane.showInputDialog("CNH:");
                    String placa = JOptionPane.showInputDialog("Placa:");
                    
                    // Solicitar e validar CPF imediatamente usando o método auxiliar
                    String cpf = Motorista.validarCPF();
                    if(cpf == null) break; // Se usuário cancelou a entrada do CPF
                    
                    // Perguntar qual tipo de motorista
                    String tipoMotorista = JOptionPane.showInputDialog(
                        "Escolha o tipo de motorista:\n" +
                        "1 - Motorista de Carro\n" +
                        "2 - Motorista de Moto\n\n" +
                        "Opção:"
                    );
                    
                    if ("1".equals(tipoMotorista)) {
                        // Cadastro de motorista de carro
                        String rotaDesignada = JOptionPane.showInputDialog("Rota Designada:");
                        double capacidadeCarga = Double.parseDouble(JOptionPane.showInputDialog("Capacidade de Carga (kg):"));
                        motoristaCarro = new MotoristaCarro(cnh, placa, nome, tel, nasc, rotaDesignada, capacidadeCarga, cpf);
                        motorista = motoristaCarro; // Mantém referência na variável genérica
                        JOptionPane.showMessageDialog(null, "Motorista de Carro cadastrado!");
                    } else if ("2".equals(tipoMotorista)) {                        // Cadastro de motorista de moto
                        String zonaAtuacao = JOptionPane.showInputDialog("Zona de Atuação:");
                        motoristaMoto = new MotoristaMoto(cnh, placa, nome, tel, nasc, zonaAtuacao, cpf);
                        motorista = motoristaMoto; // Mantém referência na variável genérica
                        JOptionPane.showMessageDialog(null, "Motorista de Moto cadastrado!");
                    } else {
                        // Opção inválida, cadastra como motorista genérico
                        motorista = new Motorista(cnh, placa, nome, tel, nasc, cpf);
                        JOptionPane.showMessageDialog(null, "Tipo inválido. Motorista cadastrado como genérico!");
                    }
                    break;

                case "2":
                    // Consulta de motorista
                    if (motorista != null) {
                        JOptionPane.showMessageDialog(null, motorista);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum motorista cadastrado.");
                    }
                    break;                
                
                case "3":
                    // Edição de dados do motorista
                    if (motorista == null) {
                        JOptionPane.showMessageDialog(null, "Cadastre um motorista primeiro.");
                        break;
                    }
                    
                    // Menu de edição específico para cada tipo de motorista
                    if (motorista instanceof MotoristaCarro) {
                        String ed = JOptionPane.showInputDialog(
                            "1 - Nova placa\n" +
                            "2 - Novo telefone\n" +
                            "3 - Alterar rota designada\n" +
                            "4 - Alterar capacidade de carga\n" +
                            "5 - Atualizar CPF\n\n" +
                            "Opção:"
                        );
                        
                        if ("1".equals(ed)) {
                            motorista.setPlaca(JOptionPane.showInputDialog("Digite a nova placa:"));
                        } else if ("2".equals(ed)) {
                            motorista.setTelefone(JOptionPane.showInputDialog("Digite o novo telefone:"));
                        } else if ("3".equals(ed)) {
                            ((MotoristaCarro)motorista).setRota_designada(
                                JOptionPane.showInputDialog("Digite a nova rota designada:")
                            );
                        } else if ("4".equals(ed)) {
                            ((MotoristaCarro)motorista).setCapacidade_carga(
                                Double.parseDouble(JOptionPane.showInputDialog("Digite a nova capacidade de carga (kg):"))
                            );
                        } else if ("5".equals(ed)) {
                            String novoCpf = Motorista.validarCPF();
                            if(novoCpf != null) {
                                motorista.setCpf(novoCpf);
                            }
                        }
                    } else if (motorista instanceof MotoristaMoto) {
                        String ed = JOptionPane.showInputDialog(
                            "1 - Nova placa\n" +
                            "2 - Novo telefone\n" +
                            "3 - Alterar zona de atuação\n" +
                            "4 - Registrar entregas do dia\n" +
                            "5 - Atualizar CPF\n\n" +
                            "Opção:"
                        );
                        
                        if ("1".equals(ed)) {
                            motorista.setPlaca(JOptionPane.showInputDialog("Digite a nova placa:"));
                        } else if ("2".equals(ed)) {
                            motorista.setTelefone(JOptionPane.showInputDialog("Digite o novo telefone:"));
                        } else if ("3".equals(ed)) {                            
                            ((MotoristaMoto)motorista).setZona_atuacao(
                                JOptionPane.showInputDialog("Digite a nova zona de atuação:")
                            );
                        } else if ("4".equals(ed)) {
                            ((MotoristaMoto)motorista).setEntregas_dia(
                                Integer.parseInt(JOptionPane.showInputDialog("Digite o número de entregas realizadas:"))
                            );
                        } else if ("5".equals(ed)) {
                            String novoCpf = Motorista.validarCPF();
                            if(novoCpf != null) {
                                motorista.setCpf(novoCpf);
                            }
                        }
                    } else {
                        // Motorista genérico
                        String ed = JOptionPane.showInputDialog(
                            "1 - Nova placa\n" +
                            "2 - Novo telefone\n" +
                            "3 - Atualizar CPF\n\n" +
                            "Opção:"
                        );
                        if ("1".equals(ed)) {
                            motorista.setPlaca(JOptionPane.showInputDialog("Digite a nova placa:"));
                        } else if ("2".equals(ed)) {
                            motorista.setTelefone(JOptionPane.showInputDialog("Digite o novo telefone:"));
                        } else if ("3".equals(ed)) {
                            String novoCpf = Motorista.validarCPF();
                            if(novoCpf != null) {
                                motorista.setCpf(novoCpf);
                            }
                        }
                    }
                      JOptionPane.showMessageDialog(null, "Atualizado:\n" + motorista);
                    break;
                
                case "4":
                    // Cadastro de cliente
                    String nomeC = JOptionPane.showInputDialog("Nome:");
                    String telC = JOptionPane.showInputDialog("Telefone:");
                    
                    // Tratamento de erro para data de nascimento
                    Calendar nascC = Calendar.getInstance();
                    boolean dataValidaCliente = false;
                    while (!dataValidaCliente) {
                        try {
                            String dataInput = JOptionPane.showInputDialog("Data Nasc (dd mm aaaa):");
                            if (dataInput == null) break; // Usuário clicou em cancelar
                            
                            String[] dataC = dataInput.split("\\s+");
                            if (dataC.length != 3) {
                                throw new Exception("Formato inválido! Use o formato: dia mês ano com espaços entre eles.");
                            }
                            
                            int dia = Integer.parseInt(dataC[0]);
                            int mes = Integer.parseInt(dataC[1]);
                            int ano = Integer.parseInt(dataC[2]);
                            
                            // Verificações básicas de validade
                            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1900 || ano > 2025) {
                                throw new Exception("Data inválida! Verifique os valores de dia, mês e ano.");
                            }
                            
                            nascC.set(ano, mes - 1, dia);
                            dataValidaCliente = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, 
                                "Erro no formato da data! Use apenas números.", 
                                "ERRO!!!", JOptionPane.ERROR_MESSAGE);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, 
                                e.getMessage(), 
                                "ERRO!!!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (!dataValidaCliente) break; // Se usuário cancelou a entrada de data
                    
                    String endereco = JOptionPane.showInputDialog("Endereço:");
                    cliente = new Cliente(nomeC, telC, nascC, endereco);
                    String cnpj = JOptionPane.showInputDialog("CNPJ (14 dígitos):");
                    cliente.setCnpj(cnpj);
                    int prio = JOptionPane.showConfirmDialog(null, "Cliente é prioritário?", "Prioridade", JOptionPane.YES_NO_OPTION);
                    cliente.setPrioridade(prio == JOptionPane.YES_OPTION);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado!");
                    break;

                case "5":
                    // Consulta de cliente
                    if (cliente != null) {
                        JOptionPane.showMessageDialog(null, cliente);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado.");
                    }
                    break;

                case "6":
                    // Edição de cliente
                    if (cliente == null) {
                        JOptionPane.showMessageDialog(null, "Cadastre um cliente primeiro.");
                        break;
                    }
                    String opt = JOptionPane.showInputDialog(
                        "1 - Novo Endereço\n" +
                        "2 - Alterar Prioridade\n\n" +
                        "Opção:"
                    );
                    if ("1".equals(opt)) {
                        cliente.setEndereco(JOptionPane.showInputDialog("Novo endereço:"));
                    } else if ("2".equals(opt)) {
                        int novaPrio = JOptionPane.showConfirmDialog(null, "Cliente é prioritário?", "Prioridade", JOptionPane.YES_NO_OPTION);
                        cliente.setPrioridade(novaPrio == JOptionPane.YES_OPTION);
                    }
                    JOptionPane.showMessageDialog(null, "Cliente atualizado:\n" + cliente);
                    break;

                default:
                    // Opção inválida
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (true);

        System.exit(0); // Encerra o programa
    }
}
