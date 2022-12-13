package Service;

import Model.Condutor;
import Dao.CondutorDao;

public class ConductorService {

    private CondutorDao condutorDao = new CondutorDao();



    public Condutor criarCondutor(Condutor condutor) {
        if(!condutorDao.save(condutor)) {
            throw new RuntimeException("Erro ao criar um novo condutor");
        }
        System.out.println("Condutor Cadastrado com sucesso!");
        return condutor;
    }

    public Condutor buscarCondutor(String cnh) {
        try {
            return condutorDao.getCondutor(cnh);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void atualizaPontuacaoCNH(Condutor condutor) {

        condutorDao.atualizarPontuacaoCNH(condutor);
    }
}
