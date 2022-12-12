package Service;

import Model.Multa;
import Model.Veiculo;
import Dao.MultaDao;
import Dao.VeiculoDao;
import java.util.List;
import java.util.Optional;

public class MultaService {
    private MultaDao multaDao = new MultaDao();

    private VeiculoDao veiculoDao = new VeiculoDao();

    public Multa registrarMulta(Multa multa) {
        if( multa.getVeiculo() == null || !multaDao.save(multa)) {
            throw new RuntimeException("Erro ao criar uma nova multa");
        }
        System.out.println("Multa aplicada com sucesso!");
        return multa;
    }

    public void getMultasVeiculos(String placa) {
        try {
            Veiculo v = veiculoDao.getVeiculo(placa);
            List<Multa>  list = multaDao.ListaMultas(v.getId());
            if (!list.isEmpty()) {
                list.stream().forEach(m ->
                        System.out.println("------------------------------------------ " +
                                "\nMulta: " + m.getCodigoMulta() +
                                "\nPontuação: " + m.getPontuacao() +
                                "\nValor: " + m.getValor()));
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}