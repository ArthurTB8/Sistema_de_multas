package Service;

import Model.Condutor;
import Model.Multa;
import Model.Veiculo;

import java.time.LocalDate;
import java.util.Scanner;

public class SistemaService {




    private static Scanner entrada = new Scanner(System.in);
    private static ConductorService condutorService = new ConductorService();
    private static VeiculoService veiculoService = new VeiculoService();
    private static MultaService multaService = new MultaService();

    public static void painelPincipal() {
        boolean repetir = true;
        while (repetir) {
            System.out.println("==========================================");
            System.out.println("             Sistema de Multas            ");
            System.out.println("==========================================");
            System.out.println("1 - Condutor");
            System.out.println("2 - Veiculo");
            System.out.println("3 - Multa");
            System.out.println("4 - Sair");
            int opcao = Integer.parseInt(entrada.nextLine());
            switch (opcao) {
                case 1:
                    painelCondutor();
                    break;
                case 2:
                    MenuVeiculo();
                    break;
                case 3:
                    painelDeMultas();
                    break;
                case 4:
                    repetir = false;
                    break;

            }
        }
    }

    private static void painelDeMultas() {
        while (true) {
            System.out.println("==========================================");
            System.out.println("             Painel de Multas             ");
            System.out.println("==========================================");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Litar multas por veiculo");
            System.out.println("3 - voltar");
            int opcao = Integer.parseInt(entrada.nextLine());
            switch (opcao) {
                case 1:
                    Multa multa = dadosMulta();
                    try {
                        multaService.registrarMulta(multa);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    listarMultasporVeiculos();
                    break;
                case 3:
                    painelPincipal();
                    break;


            }
        }
    }

    private static void listarMultasporVeiculos() {
        System.out.print("Informe a placa do veiculo: ");
        multaService.getMultasVeiculos(entrada.nextLine());

    }

    private static Multa dadosMulta() {
        Multa multa = new Multa();
        System.out.println("==========================================");
        System.out.println("Codigo \t\t Pontuação \t\t valor ");
        System.out.println("1 - Leve \t\t 3 \t\t\t 195.00");
        System.out.println("2 - Media \t\t 5 \t\t\t 295.00");
        System.out.println("3 - Grave \t\t 7 \t\t\t 495.00");
        System.out.println("==========================================");
        System.out.print("Escolha uma opção: ");
        int codigoMulta = Integer.parseInt(entrada.nextLine());
        System.out.print("Informe a placa do veiculo que será aplicado a multa: ");
        String placa = entrada.nextLine();
        System.out.println();
        switch (codigoMulta) {
            case 1:
                multa.setCodigoMulta("Leve");
                multa.setPontuacao(3l);
                multa.setValor(195d);
                multa.setVeiculo(veiculoService.buscarVeiculo(placa));
                break;
            case 2:
                multa.setCodigoMulta("Media");
                multa.setPontuacao(5l);
                multa.setValor(295d);
                multa.setVeiculo(veiculoService.buscarVeiculo(placa));
                break;
            case 3:
                multa.setCodigoMulta("Grave");
                multa.setPontuacao(7l);
                multa.setValor(495d);
                multa.setVeiculo(veiculoService.buscarVeiculo(placa));
                break;

        }
        aplicarMultaCondutor(multa);
        return multa;
    }

    private static void aplicarMultaCondutor(Multa multa) {
        Condutor condutor = null;
        try {
            condutor = condutorService.buscarCondutor(multa.getVeiculo().getCondutor().getNumeroCnh());
        } catch (NullPointerException e) {
            return;
        }
        if (multa.getPontuacao() > condutor.getPontuacao()) {
            condutor.setPontuacao(0);
            System.out.println("Sua CNH está presa!");
        } else {
            condutor.setPontuacao((int) (condutor.getPontuacao() - multa.getPontuacao()));
            condutorService.atualizaPontuacaoCNH(condutor);
        }
    }

    private static void MenuVeiculo() {
        while (true) {
            System.out.println("==========================================");
            System.out.println("              Menu Veiculo              ");
            System.out.println("==========================================");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Transferir");
            System.out.println("3 - Buscar");
            System.out.println("4 - voltar");
            int opcao = Integer.parseInt(entrada.nextLine());
            switch (opcao) {
                case 1:
                    Veiculo veiculo = dadosVeiculo();
                    veiculoService.cadastrarVeiculo(veiculo);
                    break;
                case 2:
                    transferirVeiculo();
                    break;
                case 3:
                    System.out.print("Informe a placa do veiculo: ");
                    Veiculo v = veiculoService.buscarVeiculo(entrada.nextLine());
                    informacoesVeiculo(v);
                    break;
                case 4:
                    painelPincipal();
                    break;

            }
        }
    }

    private static void informacoesVeiculo(Veiculo v) {
        if (v.getId() != null) {
            System.out.println("==========================================");
            System.out.println("=                VEICULO                  ");
            System.out.println("==========================================");
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Marca: " + v.getMarca());
            System.out.println("Ano em padrão Americano (mês-dia-ano): " + v.getAno());
            System.out.println("Placa: " + v.getPlaca());
            System.out.println("Proprietario: " + condutorService.buscarCondutor(v.getCondutor().getNumeroCnh()).getNome());
        }
    }

    private static void transferirVeiculo() {
        System.out.print("Informe a placa do veiculo que deseja transferir: ");
        String placa = entrada.nextLine();

        Veiculo v = veiculoService.buscarVeiculo(placa);
        System.out.print("Informe a CNH do condutor que deseja fazer a transferencia do veiculo: ");
        String cnh = entrada.nextLine();
        try {
            Condutor c = condutorService.buscarCondutor(cnh);
            v.setCondutor(c);
            if (veiculoService.atualizarVeiculo(v)) {
                System.out.println("==========================================");
                System.out.println("    Tranferencia efetuada com sucesso!    ");
                System.out.println("==========================================");
            }
        } catch (NullPointerException e) {
            return;
        }

    }

    private static Veiculo dadosVeiculo() {
        Veiculo v = new Veiculo();
        System.out.println("==========================================");
        System.out.println("            Cadastrar Veiculo             ");
        System.out.println("==========================================");
        System.out.print("Modelo: ");
        v.setModelo(entrada.nextLine());
        System.out.print("Marca: ");
        v.setMarca(entrada.nextLine());
        System.out.print("Ano em padrão Americano (mês-dia-ano): ");
        v.setAno(entrada.nextLine());
        System.out.print("Placa: ");
        v.setPlaca(entrada.nextLine());
        System.out.println("CNH do proprietario: ");
        v.setCondutor(condutorService.buscarCondutor(entrada.nextLine()));
        return v;
    }

    private static void painelCondutor() {
        while (true) {
            System.out.println("==========================================");
            System.out.println("             Painel Condutor              ");
            System.out.println("==========================================");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - voltar");
            int opcao = Integer.parseInt(entrada.nextLine());
            switch (opcao) {
                case 1:
                    Condutor condutor = dadosCondutor();
                    condutorService.criarCondutor(condutor);
                    break;
                case 2:
                    try {
                        Condutor c = getCondutor();
                        imprimirCondutor(c);
                    } catch (NullPointerException e) {
                        return;
                    }

                    break;
                case 3:
                    painelPincipal();
                    break;

            }
        }
    }

    private static void imprimirCondutor(Condutor c) {
        if (c.getId() != null) {
            System.out.println("----------- Dados do Condutor ------------");
            System.out.println("Nome: " + c.getNome());
            System.out.println("Número da CNH: " + c.getNumeroCnh());
            System.out.println("Orgão Emissor: " + c.getOrgaoEmissor());
            System.out.println("Data da emissão no padrão Americano (mês-dia-ano): " + c.getDataEmissao());
            System.out.println("Pontuação: " + c.getPontuacao());
        }
    }

    private static Condutor dadosCondutor() {
        Condutor condutor = new Condutor();
        System.out.println("==========================================");
        System.out.println("            Cadastrar Condutor            ");
        System.out.println("==========================================");
        System.out.print("Nome: ");
        condutor.setNome(entrada.nextLine());
        System.out.print("Número da CNH: ");
        condutor.setNumeroCnh(entrada.nextLine());
        System.out.print("Data de emissão no padrão Americano (mês-dia-ano): ");
        condutor.setDataEmissao(LocalDate.parse(entrada.nextLine()));
        System.out.print("Orgão Emissor: ");
        condutor.setOrgaoEmissor(String.valueOf(entrada.nextLine()));
        condutor.setPontuacao(21);
        return condutor;

    }

    private static Condutor getCondutor() {
        System.out.println("==========================================");
        System.out.println("                 Condutor                 ");
        System.out.println("==========================================");
        System.out.print("Informe o número de sua CNH: ");
        String cnh = entrada.nextLine();
        return condutorService.buscarCondutor(cnh);


    }

}