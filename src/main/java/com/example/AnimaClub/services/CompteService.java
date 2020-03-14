package com.example.AnimaClub.services;

import com.example.AnimaClub.dao.CompteDAO;
import com.example.AnimaClub.dao.impl.CompteDAOimpl;
import com.example.AnimaClub.dto.CompteDTO;
import com.example.AnimaClub.model.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class CompteService {

    @Autowired
    private CompteDAOimpl compteDAOimpl;

    public List<Compte> findAll() throws SQLException {
        return compteDAOimpl.findAll();
    }

    public CompteDTO searchById(int id) throws SQLException{
        return ofNullable(compteDAOimpl.find(id))
                .map(this::convertToDTo).orElse(null);
    }

    public CompteDTO create(CompteDTO compteDTO)throws SQLException{
        Compte compte = compteDAOimpl.find(compteDTO.getId());

        if (compte != null) {
            throw new RuntimeException("Account cannot be created");
        }else {
            compteDAOimpl.create(convert(compteDTO));
        }
        return searchById(compteDTO.getId());
    }

    public CompteDTO searchByPseudo(String pseudo) throws SQLException{
        return convertToDTo(compteDAOimpl.findByPseudo(pseudo));
    }

    public CompteDTO searchByMail(String mail) throws SQLException{
        return convertToDTo(compteDAOimpl.findByMail(mail));
    }

    private CompteDTO convertToDTo(Compte compte){
        return new CompteDTO(
            compte.getId(),
            compte.getPseudo(),
            compte.getMail(),
            compte.getPassword()
        );
    }

    private Compte convert(CompteDTO compteDTO){
        return new Compte(
        compteDTO.getId(),
        compteDTO.getPseudo(),
        compteDTO.getMail(),
        compteDTO.getPassword());
    }
}
