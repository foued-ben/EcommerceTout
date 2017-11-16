package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class CategorieServiceTest {
	// N�cessaire pour faire tourner les tests : cat�gorie avec un id �gal � 1, changer dans les attributs si n�cessaire
	
	@Autowired
	private ICategorieService categorieService;
	
	// Tests de getCategorieById
	//@Test
	public void testGetCategorieById(){
		assertEquals(1,categorieService.getCategorieById(1).getId());
	}
	
	//@Test
	public void testGetCategorieById1(){
		assertEquals("Chat",categorieService.getCategorieById(1).getNomCategorie());
	}
	
	//@Test
	public void testGetCategorieById2(){
		assertEquals("Un mignon f�lin",categorieService.getCategorieById(1).getDescription());
	}

}
