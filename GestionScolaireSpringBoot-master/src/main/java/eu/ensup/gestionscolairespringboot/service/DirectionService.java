/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensup.gestionscolairespringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eu.ensup.gestionscolairespringboot.dao.EtudiantRepository;
import eu.ensup.gestionscolairespringboot.dao.NoteRepository;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;
import eu.ensup.gestionscolairespringboot.domaine.Note;
import eu.ensup.gestionscolairespringboot.domaine.projection.EtudiantMoyenneVO;

/**
 *
 * @author lorris
 */
public class DirectionService implements IDirectionService{

    
    
    @Autowired
    private NoteRepository noteDAO;
    
    @Autowired
    private EtudiantService etudiantService;
    
    @Autowired
    private EtudiantRepository daoetu;
    
    
    @Override
    public  List<EtudiantMoyenneVO> listeMoyenneEtudiants() {
        
       List<Etudiant> listeEtudiant = new ArrayList<>();
       listeEtudiant = etudiantService.getAll();
       
        List<Note> listeNoteEtudiant = new ArrayList<>();
        
        
        List<EtudiantMoyenneVO> listeMoyenneEtudiant = new ArrayList<>();
     
       
       
        for (int y = 0; y < listeEtudiant.size(); y++) {
             
              listeNoteEtudiant = noteDAO.findAll();
              
            for (int i = 0; i < listeNoteEtudiant.size(); i++) {
                if (listeNoteEtudiant.get(i).getIdEtu() != listeEtudiant.get(y).getId()) {
                    listeNoteEtudiant.remove(i);
                }
               EtudiantMoyenneVO etudiantMoyenneVO =  
                       this.calculerMoyenneEtudiants(listeNoteEtudiant,listeEtudiant.get(y).getId());
               listeMoyenneEtudiant.add(etudiantMoyenneVO);
            }
        }
      
      
        
       return listeMoyenneEtudiant;
    }

    
/**
 *
 * Calcule la moyenne de toute les notes d'un étudiant
 */
    @Override
    public EtudiantMoyenneVO calculerMoyenneEtudiants(List<Note> liste, int idEtu) {
    
        double countNotes = 0 ;
        int index = 0;
        for (int i = 0 ; i< liste.size();i++)
        {
            index++;
            countNotes = countNotes + liste.get(i).getNote();
        }
        double moyenne = countNotes / index;
        EtudiantMoyenneVO etuVO = new EtudiantMoyenneVO();
        Etudiant etu = daoetu.getOne(idEtu);
        etuVO.setAdresse(etu.getAdresse());
        etuVO.setCours(etu.getCours());
        etuVO.setDateNaissance(etu.getDateNaissance());
        etuVO.setMail(etu.getMail());
        etuVO.setId(etu.getId());
        etuVO.setNom(etu.getNom());
        etuVO.setPrenom(etu.getPrenom());
        etuVO.setTelephone(etu.getTelephone());
        etuVO.setMoyenne(moyenne);
        
        return etuVO;
    }

    
    
}
