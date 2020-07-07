package eu.ensup.gestionscolairespringboot.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import eu.ensup.gestionscolairespringboot.dao.DirectionRepository;
import eu.ensup.gestionscolairespringboot.dao.EtudiantRepository;
import eu.ensup.gestionscolairespringboot.dao.NoteRepository;
import eu.ensup.gestionscolairespringboot.domaine.Direction;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;
import eu.ensup.gestionscolairespringboot.domaine.Note;
import eu.ensup.gestionscolairespringboot.domaine.projection.EtudiantMoyenneVO;
import eu.ensup.gestionscolairespringboot.service.DirectionService;
import eu.ensup.gestionscolairespringboot.service.EtudiantService;

class DirectionServiceTest {

	@Mock
	private DirectionRepository idirectiondao;
	@Mock
	private NoteRepository daoNote;
	@Mock
	private EtudiantRepository daoEtu;

	@Autowired
	@InjectMocks
	private EtudiantService etudiantService;

	@Autowired
	@InjectMocks
	private DirectionService directionService;
	
	@BeforeEach
	public void setupMock() {
		MockitoAnnotations.initMocks(this); // Cette méthode initialise également les objets simulés lors de
											// l'initialisation des tests junit.
	}

	
	@Test
	void loginTest() {
		Direction direction = new Direction();
		direction.setLogin("login");
		direction.setPassword("pwd");
		when(idirectiondao.findByLoginAndPassword("login","pwd")).thenReturn(direction);
		assertEquals(direction, etudiantService.login("login","pwd"));
	}
	
	@Test
	void listerMoyenneEtudiantReturn10() {
		//
	}

	@Test
	void CalculerMoyenneEtudiantReturn10() {
		// la moyenne d'un étudiant dont l'id est 1 et dont les notes sont 0 et 20 
		//est égale à la moyenne d'un nouveletudiant dont la moyenne est 10
		Etudiant etu = new Etudiant(1,"1", "1", "1", "1", 1, "1");
		
		Note note = new Note();
		note.setNote(0.0);
		Note note2 = new Note();
		note.setNote(20.00);
		List<Note> notes = new ArrayList<Note>();
		notes.add(note);
		notes.add(note2);
		
		when(daoEtu.getOne(1)).thenReturn(etu);
		
		EtudiantMoyenneVO etuVOExtpected = new EtudiantMoyenneVO();
		etuVOExtpected.setMoyenne(10.00);
		EtudiantMoyenneVO etuVOActual = directionService.calculerMoyenneEtudiants(notes, 1);
		
		assertEquals(etuVOExtpected.getMoyenne(), etuVOActual.getMoyenne());
		
		
		
	}
	
}
