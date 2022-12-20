package Service;

import Model.Condutor;
import Model.Veiculo;

import static Service.SistemaService.condutorService;

public class MenuService {

    static void painelPrincipalPrint() {
        System.out.println("==========================================");
        System.out.println("             Sistema de Multas            ");
        System.out.println("==========================================");
        System.out.println("1 - Condutor");
        System.out.println("2 - Veiculo");
        System.out.println("3 - Multa");
        System.out.println("4 - Sair");
    }

    static void painelDeMultasPrint() {
        System.out.println("==========================================");
        System.out.println("             Painel de Multas             ");
        System.out.println("==========================================");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Litar multas por veiculo");
        System.out.println("3 - voltar");


    }

    static void dadosMultaPrint() {
        System.out.println("==========================================");
        System.out.println("Codigo \t\t Pontuação \t\t valor ");
        System.out.println("1 - Leve \t\t 3 \t\t\t 195.00");
        System.out.println("2 - Media \t\t 5 \t\t\t 295.00");
        System.out.println("3 - Grave \t\t 7 \t\t\t 495.00");
        System.out.println("==========================================");
        System.out.print("Escolha uma opção: ");
    }

    static void menuVeiculoPrint() {
        System.out.println("==========================================");
        System.out.println("              Menu Veiculo              ");
        System.out.println("==========================================");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Transferir");
        System.out.println("3 - Buscar");
        System.out.println("4 - voltar");
    }
    static void informacoesVeiculoPrint(Veiculo v) {
        System.out.println("==========================================");
        System.out.println("=                VEICULO                  ");
        System.out.println("==========================================");
        System.out.println("Modelo: " + v.getModelo());
        System.out.println("Marca: " + v.getMarca());
        System.out.println("Ano em padrão Americano (mês-dia-ano): " + v.getAno());
        System.out.println("Placa: " + v.getPlaca());
        System.out.println("Proprietario: " + condutorService.buscarCondutor(v.getCondutor().getNumeroCnh()).getNome());
    }

    static void mensagemAoAtualizarVeiculo() {
        System.out.println("==========================================");
        System.out.println("    Tranferencia efetuada com sucesso!    ");
        System.out.println("==========================================");
    }

    static void cadastroDoVeiculo() {
        System.out.println("==========================================");
        System.out.println("            Cadastrar Veiculo             ");
        System.out.println("==========================================");
        System.out.print("Modelo: ");
    }

    static void painelCondutorPrint() {
        System.out.println("==========================================");
        System.out.println("             Painel Condutor              ");
        System.out.println("==========================================");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Buscar");
        System.out.println("3 - voltar");
    }

    static void imprimirCondutorPrint(Condutor c) {
        System.out.println("----------- Dados do Condutor ------------");
        System.out.println("Nome: " + c.getNome());
        System.out.println("Número da CNH: " + c.getNumeroCnh());
        System.out.println("Orgão Emissor: " + c.getOrgaoEmissor());
        System.out.println("Data da emissão no padrão Americano (mês-dia-ano): " + c.getDataEmissao());
        System.out.println("Pontuação: " + c.getPontuacao());
    }


    static void dadosCondutorPrint() {
        System.out.println("==========================================");
        System.out.println("            Cadastrar Condutor            ");
        System.out.println("==========================================");
        System.out.print("Nome: ");
    }

    static void condutorPrint() {
        System.out.println("==========================================");
        System.out.println("                 Condutor                 ");
        System.out.println("==========================================");
        System.out.print("Informe o número de sua CNH: ");
    }
}
