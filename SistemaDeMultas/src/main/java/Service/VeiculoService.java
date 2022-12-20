package Service;

import Model.Veiculo;
import Dao.VeiculoDao;

public class VeiculoService {


    private VeiculoDao veiculoDao = new VeiculoDao();


    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        if (veiculoDao.save(veiculo)) {
            return veiculo;
        }
        return null;
    }

    public Veiculo buscarVeiculo(String placa){
        try {
            return veiculoDao.getVeiculo(placa);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean atualizarVeiculo(Veiculo v) {
        return   veiculoDao.update(v);
    }
}
