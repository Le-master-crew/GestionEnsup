/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensup.gestionscolairespringboot.service;

/**
 *
 * @author lorris
 */
public interface IEnseignantService {
    
     public void noterEtudiant(int idEtudiant,int idEnseignant,double note);
    
}
