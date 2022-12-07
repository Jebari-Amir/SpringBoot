package tn.esprit.telecom.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.telecom.demo.repositories.IDetailEquipeRepository;
import tn.esprit.telecom.demo.entites.DetailEquipe;

import java.util.List;
@Service
@AllArgsConstructor
public class DetailEquipeServicesImpl implements IDetailEquipeServices{
    IDetailEquipeRepository detailEquipeRepository;
    @Override
    public DetailEquipe addOrUpdateDetailEquipe(DetailEquipe detailEquipe) {
        return null;
    }

    @Override
    public void removeDetailEquipe(Integer idDetailEquipe) {

    }

    @Override
    public DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe) {
        return null;
    }

    @Override
    public List<DetailEquipe> retrieveAllDetailEquipe() {
        return null;
    }
}
